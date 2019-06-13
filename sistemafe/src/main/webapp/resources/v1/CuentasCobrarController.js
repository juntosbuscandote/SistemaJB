function CuentasCobrar() {
	this.lstCuentaDetallado = $('#lstcuentaDetallado');
	this.lstCuentaResumido = $('#lstCuentaResumido');
	this.lstDataTableGrillaCuentaCobrar;
	this.gMethods = system.globalMethods;	
    $("#filtroRangoFecha").daterangepicker();
	$("#filtroRangoFecha").val("");
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});
}

CuentasCobrar.prototype.init = function() {
	this.handler();
	this.listarCuentaResumido();
	
}

CuentasCobrar.prototype.handler = function() {
	var obj=this;
    obj.gMethods.setValidatorDefaults();
    var selected = [];
//    obj.CuentasCobrar();
    $('body').on('click', '#btnCleanCuentas', function(event) {
		$('#filtroPersonas').val('').trigger('change');
		$('#filtroCPE').val('').trigger('change');
		$('#filtroTipoDetalle').val('').trigger('change');
    });
	 $("#exportExcel").on("click", function () {
		 $.ajax({
				url : "/SistemaFE/cuentacobrar/exportExcel/",
				type : "POST",
				dataType : "json",
				beforeSend : function() {
				},
				success : function(data) {
					if (data.msg == "ok") {
						location.href = data.respuesta;
					}else{
						bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					console.log("ocurrio un error");  
				}
			});
	 });
    
    $("#filtroRangoFecha").val("");
	$("#tabcuentaDetallado").hide();
	$('body').on('click', '#btn_search', function(event) {			
        var fecha= $("#filtroRangoFecha").val();
		if($("#filtroRangoFecha").val()!=null){
			$("#idMovDetFilterFecha").val(fecha);
		}
		var filtroCPE= $("#filtroCPE").val();
		if($("#filtroCPE").val()!=null){
			$("#idfiltroCPE").val(filtroCPE);
		}
    	obj.reloadDataTableCuentas();
	});
	
	
	$('body').on('click', '#Salir', function(event) {
		$('#frmmodalMostrarDetalle').modal('hide');
		$('#idCompra').val("");
    });		
	
	 $('body').on('click', '.btnVerDetCompra', function() {
			var boton=$(this);
			var codDet=boton.attr( "attr-user" );
			var TipoCuenta=boton.attr( "attr-tipocuenta" );
			if($("#idMovDetFilterFecha").val()!=null){
				var idMovDetFilterFecha= $("#idMovDetFilterFecha").val();
			} else {
				var idMovDetFilterFecha= "";
			}
			$("#tipoCuenta").val(TipoCuenta);
			$("#tipoCuentas").val(TipoCuenta);
			$("#idCompra").val(codDet);	
			$('#VerDetCompra').val(codDet);
			 $.ajax({
	               url : "/SistemaFE/cuentacobrar/MostrarDetalleCobrar/",
	               type : "POST",
	               data : {"codDet":codDet,"idMovDetFilterFecha":idMovDetFilterFecha},  
	               dataType : "json",
	               beforeSend : function() { },
	               success : function(data) {
	                      if (data.msg == "ok") {
	                    	  obj.listarCuentaCobrar();
	                            $('#frmmodalMostrarDetalle').modal({backdrop: 'static', keyboard: false});
	               }                   
	               },
	               error : function(xhr, statusText, errorThrown) {
	                      console.log("ocurrio un error");  
	               }
	        });
		});
	
    
}

CuentasCobrar.prototype.reloadDataTableCuentas = function() {
	var table = $('#lstcuentaResumido').DataTable().ajax.url("/SistemaFE/cuentacobrar/lista_cuentas"+'?'+$('#frm_filtrarCuentasCobrar').serialize()).load();
}


CuentasCobrar.prototype.listarCuentaResumido = function() {
	var table = $('#lstcuentaResumido').DataTable({
//        "scrollY" : "500px",
//		"scrollX" : true,
//		"sScrollX" : "50%",
		"bScrollCollapse" : true,
		"sProcessing" : "Procesando...",
		"serverSide" : true,
        "pagingType": "numbers",
		"lengthMenu" : [100, 250, 500, 1000],
		"pageLength": 100,
        "paging": true,
        "Paginate" : true,		        
        "ajax": {
            "url": "/SistemaFE/cuentacobrar/lista_cuentas"+"?"+$('#frm_filtrarCuentasCobrar').serialize(),
            "type": "POST"
        },
		"columnDefs" : [
				{
					"targets" : 0,
					"data" : "sel",
					"defaultContent" : "",
					"className" : "text-center",
					"orderable" : false,
					"render" : function(data, type, full, meta) {
						return "<input type='checkbox' class='flat' />";
					}
				},
	        	{
	                "targets": 1,
	                "data": "accion", "defaultContent": "",
	                "className": "text-center",
	                "width": '20%',
	                "render": function (data, type, full, meta) {
	                	var estadoEd="enabled"
	                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetCompra ladda-button' title ='Ver Detalle'" +
	                    " attr-user='"+full.bnumber_doc_clie+"'"+ " attr-total='"+full.totalneto+"'"+" attr-totalconversion='"+full.totalconversion+"'"+ 
	                    " attr-tipocuenta='"+full.tipocuenta+"'"+
	                    		" > </button> "
	                }
				},
				{
					"targets" : 2,
					"data" : "vbusiname_clie",
				},
				{
					"targets" : 3,
					"data" : "totalneto",
				},
				{
					"targets" : 4,
					"data" : "totalconversion",
				}
		],
		"preDrawCallback" : function(settings) {
			var api = new $.fn.dataTable.Api(settings);
			var pagination = $(this).closest('.dataTables_wrapper')
					.find('.dataTables_paginate');
			pagination.toggle(api.page.info().pages > 1);
		},
		"drawCallback" : function(settings) {
			$(".filterWrapping").append($(".filter-block"));
			$(".filterActive").append($("#filterActive"));
			$("#filterActive").removeClass("hidden");
			$(".filter-block").removeClass("hidden");
			$(".multiBtnWrapping").append(
					$("#btnBar_multipleSelection"));
			$("#btnBar_multipleSelection").removeClass("hidden");
			$(this).closest('.dataTables_wrapper').removeClass(
					"form-inline");
			$("input[id='select_all']").prop('checked', false);

		}
	});
	$("#lstcuentaResumido_filter").hide();
}
	
CuentasCobrar.prototype.listarCuentaCobrar = function() {
	var obj = this;
	obj.lstDataTableGrillaCuentaCobrar = obj.lstCuentaDetallado.DataTable({
				"sPaginationType" : "simple_numbers",
				"bScrollCollapse" : true,
				"destroy": true,	
				"serverSide" : false,
				"dom" : '<"row"<"col-md-12 addButtonHere">><"row"<"col-md-12"tr>><"row"<"col-md-8"i><"col-md-4 text-right"p>>',
				"pagingType": "simple_numbers",
				"lengthMenu" : [10, 25, 50, 100],
				"pageLength": 10,
		        "paging": true,
		        "Paginate" : true,	
//				"language": {
//                    "decimal": ".",//separador decimales
//                    "thousands": ","//Separador miles
//          },
				"ajax": {							
		            "url": "/SistemaFE/cuentacobrar/MostrarDetalleCobrar"+"?"+"codDet="+$('#idCompra').val()+"&"+"idMovDetFilterFecha="+$('#idMovDetFilterFecha').val()+"&"+"idfiltroCPE="+$('#idfiltroCPE').val(),
		            "type": "POST"					
		        },
				"columnDefs" : [
						{
							"targets" : 0,
							"data" : "vbusiname_clie"
						},
						{
							"targets" : 1,
							"data" : "sdetTemisionDate"
						},
						{
							"targets" : 2,
							"data" : "sdetExpiryDate"
						},
						{
							"targets" : 3,
							"data" : "vserienumbervoucher"
						},
						{
							"targets" : 4,
							"data" : "observacion"
						},
						{
							"targets" : 5,
							"data" : "totalneto",
						},
						{
							"targets" : 6,
							"data" : "totalconversion",
						}
						],
					     "footerCallback": function ( row, data, start, end, display ) {
					            var api = this.api(), data;
					            var intVal = function ( i ) {
					                return typeof i === 'string' ?
					                    i.replace(/[\$,]/g, '')*1 :
					                    typeof i === 'number' ?
					                        i : 0;
					            };
					            total = api
					                .column( 5 )
					                .data()
					                .reduce( function (a, b) {
					                    return intVal(a) + intVal(b);
					                }, 0 );
					            totalConversion = api
				                .column( 6 )
				                .data()
				                .reduce( function (a, b) {
				                    return intVal(a) + intVal(b);
				                }, 0 );

					                $("#frmResultadoTotal").val(total.toFixed(2)),
							        $("#frmResultadoTotalConversion").val(totalConversion.toFixed(2))
					        },
			 "drawCallback": function (settings) {
		        	$(".filterWrapping").append($(".filter-block"));
					$(".filterActive").append($("#filterActive"));
					$("#filterActive").removeClass("hidden");
					$(".filter-block").removeClass("hidden");
					$(".multiBtnWrapping").append(
							$("#btnBar_multipleSelection"));
					$("#btnBar_multipleSelection").removeClass("hidden");
					$(this).closest('.dataTables_wrapper').removeClass(
							"form-inline");
					$("input[id='select_all']").prop('checked', false);
		        }
			});
	
	$("#lstcuentaDetallado_filter").hide();
	$("#lstcuentaDetallado_length").hide();
}

	
	
	
	
	
	
	
	
	