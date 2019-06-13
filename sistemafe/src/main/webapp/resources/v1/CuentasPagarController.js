function CuentasPagar() {
	this.lstCuentaDetallado = $('#lstcuentaDetallado');
	this.lstCuentaResumido = $('#lstCuentaResumido');
	this.lstDataTableGrillaCuentaPagar;
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

CuentasPagar.prototype.init = function() {
	this.handler();
	this.listarCuentaResumido();
	 $( "#filtroTipoDetalle" ).val('02').trigger( "change" );
	
}

CuentasPagar.prototype.handler = function() {
	var obj=this;
    obj.gMethods.setValidatorDefaults();
    var selected = [];
//    obj.CuentasPagar();
    $('body').on('click', '#btnCleanCuentas', function(event) {
		$('#filtroPersonas').val('').trigger('change');
		$('#filtroCPE').val('').trigger('change');
		$('#filtroTipoDetalle').val('').trigger('change');
    });
    
	 $("#exportExcel").on("click", function () {
		 $.ajax({
				url : "/SistemaFE/cuentapagar/exportExcel/",
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
    $( "#filtroTipoDetalle" ).val('02').trigger( "change" );
    $("#filtroRangoFecha").val("");
    $("#tabcuentaDetallado").hide();
	$('body').on('click', '#btn_search', function(event) {	
        var fecha= $("#filtroRangoFecha").val();
		if($("#filtroRangoFecha").val()!=null){
			$("#idMovDetFilterFecha").val(fecha);
		}
		var sucursal= $("#filtroCPE").val();
		if($("#filtroCPE").val()!=null){
			$("#idfiltroCPE").val(sucursal);
		}
    	obj.reloadDataTableCuentas();
	});
	
	
	$('body').on('click', '#Salir', function(event) {
		$('#frmmodalMostrarDetalle').modal('hide');
		$('#idCompra').val("");
    });
	
	
	 $('body').on('click', '.btnVerDetPagar', function() {
			var boton=$(this);
			var codDet=boton.attr( "attr-user" );
			var Montotal=boton.attr( "attr-total" );
			var MontotalConversion=boton.attr( "attr-totalconversion" );
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
	               url : "/SistemaFE/cuentapagar/MostrarDetallePagar/",
	               type : "POST",
	               data : {"codDet":codDet,"idMovDetFilterFecha":idMovDetFilterFecha},  
	               dataType : "json",
	               beforeSend : function() { },
	               success : function(data) {
	                      if (data.msg == "ok") {
	                    	obj.listarCuentaPagar();
	                        $('#frmmodalMostrarDetalle').modal({backdrop: 'static', keyboard: false});                  
	                      }
	                      },
	               error : function(xhr, statusText, errorThrown) {
	                      console.log("ocurrio un error");  
	               }
	        });
		});
	 $('body').on('click', '.btnVerDetPagar', function() {		

	 });
		    
}

CuentasPagar.prototype.reloadDataTableCuentas = function() {
	var table = $('#lstcuentaResumido').DataTable().ajax.url("/SistemaFE/cuentapagar/lista_cuentas"+'?'+$('#frm_filtrarCuentasPagar').serialize()).load();
}


CuentasPagar.prototype.listarCuentaResumido = function() {	
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
            "url": "/SistemaFE/cuentapagar/lista_cuentas"+"?"+$('#frm_filtrarCuentasPagar').serialize(),
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
	                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetPagar ladda-button' title ='Ver Detalle'" +
	                    " attr-user='"+full.formapago+"'"+ " attr-total='"+full.totalneto+"'"+" attr-totalconversion='"+full.totalconversion+"'"+
	                    "attr-tipocuenta='"+full.tipocuenta+"'"+
	                    		" > </button> "
	                }
				},
				{
					"targets" : 2,
					"data" : "vbusiname_prov",
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
		 "ordering": false,
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
	
CuentasPagar.prototype.listarCuentaPagar = function() {
	var obj = this;
	obj.lstDataTableGrillaCuentaPagar = obj.lstCuentaDetallado.DataTable({
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
				"ajax": {							
		            "url": "/SistemaFE/cuentapagar/MostrarDetallePagar"+"?"+"codDet="+$('#idCompra').val()+"&"+"idMovDetFilterFecha="+$('#idMovDetFilterFecha').val()+"&"+"idfiltroCPE="+$('#idfiltroCPE').val()
		            +"&"+"montototal="+$('#montotal').val(),
		            "type": "POST"					
		        },
				"columnDefs" : [
						{
							"targets" : 0,
							"data" : "vbusiname_prov"
						},
						{
							"targets" : 1,
							"data" : "TemisionDate"
						},
						{
							"targets" : 2,
							"data" : "TexpiryDate"
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
	
	
	
	
	
	
	
	
	
	
	
	