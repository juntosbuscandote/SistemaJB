function Serie() {
	this.lstSerie = $('#lstSerie');
	this.gMethods = system.globalMethods;
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});

}
Serie.prototype.init = function() {
	this.handler();
	this.listarSerie();
	
}

Serie.prototype.handler = function() {
	var obj=this;
	obj.gMethods.setAutocompletado();
	obj.gMethods.setValidatorDefaults();
	obj.gMethods.setSoloNumero();
	obj.habilitar(1);
	
    $('body').on('click', '#btn_clean', function(event) {
		$('#listaCatDetCompro').val('').trigger('change');
		$('#frmEmpFiltroSuc').val('').trigger('change');
		$('#frmEmpFiltroEstado').val('').trigger('change');
    });
    
	$("#frmSerieGuardar").click(function() {
		if($("#proccess").val()=="modif"){
			obj.editarSerie();
		}else{
			obj.crearSerie();
		}
	});
	
	$("#btnSalir").click(function(e) {
		bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res) {
			if (res) {
				location.href = "/SistemaFE/serie/";
			}
		});
	});
	
	$('body').on('click', '.btnEditSerie', function() {
		var boton=$(this);
		var idSerie=boton.attr("attr-ident");
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar serie?:</label>",function(res){
			if (res) {			
				location.href="/SistemaFE/serie/editarSerie?idSerie="+idSerie;				
			}
		});
	}); 
	
	$('body').on('click', '.btnVerDetSerie', function() {
		var boton=$(this);
		var idSerie=boton.attr("attr-ident");
		$.ajax({
			url : "/SistemaFE/serie/detalleemp/",
			type : "POST",
			data : {"seriId":idSerie},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					obj.habilitar(2);
					$("#listaCatDetComp").val(data.tipocp).trigger( "change" );
					$("#serieNro").val(data.serie);
					$("#sucu_empr" ).val(data.seriesucursal).trigger( "change");	
					$("#frmmodalSerie").modal("show");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
		$("#sucu_empr").select2({ width: '100%' });
	}); 
	
	
	$('body').on('click', '.btnInhaSerie', function() {
		var boton=$(this);
		var idSerie=boton.attr("attr-ident");
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea deshabilitar esta serie?",function(res){
			if (res) {
				$.ajax({
					url : "/SistemaFE/serie/DeshabilitaEstado/",
					type : "POST",
					data : {"idSerie":idSerie},
					dataType : "json",
					beforeSend : function() {},
					success : function(data) {
						if (data.msg == "ok") {
							bootbox.alert({
				                size: null,
				                title: null,
				                message: "<label class='text-danger'>Se inhabilitó la serie correctamente</label>",
				                callback: function () {
				                	location.href = "/SistemaFE/serie/";
				                }
				            });
						}else{
							bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
			}
		});
	});

	$('body').on('click', '#btn_search', function(event) {
		obj.reloadDataTableSerie();
		
	});
	
	
	$("#frmSeries").validate({
		rules: {
			listaCatDetComp: {
            	required: true
            },
            serieNro: {
            	required: true
            },
            sucu_empr: {
            	required: true
            },         
        }
	});
	
}





Serie.prototype.reloadDataTableSerie = function() {
	this.lstSerie.DataTable().ajax.url("/SistemaFE/serie/lista_serie"+'?'+$('#frm_filtrarSerie').serialize()).load();
}

Serie.prototype.listarSerie = function() {
	var obj = this;
	obj.lstSerie.DataTable({
			"sPaginationType" : "simple_numbers",
			"scrollY" : "500px",
			"scrollX" : true,
			"sScrollX" : "100%",
			"bScrollCollapse" : true,
			"processing" : false,
			"serverSide" : true,
			"order" : [],
			"colReorder" : {
				"fixedColumnsLeft" : 1,
				"fixedColumnsRight" : 2
			},
			"pagingType" : "numbers",
			"lengthMenu" : [ 10, 25, 50, 100 ],
			"pageLength" : 10,
			"paging" : true,
			"Paginate" : true,
			"ajax" : {
				"url" : "/SistemaFE/serie/lista_serie" + "?"+ $('#frm_filtrarSerie').serialize(),
				"type" : "POST"
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
						"targets" : 1,
						"data" : "tipocp"
					},
					{
						"targets" : 2,
						"data" : "accion",
						"defaultContent" : "",
						"className" : "text-left",
						"orderable" : false,
						"width" : "100px",
						"render" : function(data, type, full, meta) {
							var estado = "";
							if (full.tipocp == 01) {
								return "<div >"+ "Factura" + "</div>";
							} else if (full.tipocp == 03){
								return "<div' >"+ "Boleta de Venta" + "</div> ";
							}else if (full.tipocp == 07){
								return "<div' >"+ "Nota de Credito" + "</div> ";
							}else if (full.tipocp == 08){
								return "<div' >"+ "Nota de Debito" + "</div> ";
							}else if (full.tipocp == 09){
								return "<div' >"+ "Guia Remision - Remitente" + "</div> ";
							}else if (full.tipocp == 20){
								return "<div' >"+ "Comprobante de Retencion" + "</div> ";
							}else if (full.tipocp == 40){
								return "<div' >"+ "Comprobante de Percepcion" + "</div> ";	
							}else if (full.tipocp == 99){
								return "<div' >"+ "Nota de Venta" + "</div> ";
							}
						}
					},
					{
						"targets" : 3,
						"data" : "serie"
					},
					{
						"targets" : 4,
						"data" : "seriesucursal"
					},
					{
						"targets" : 5,
						"data" : "accion",
						"defaultContent" : "",
						"className" : "text-center",
						"orderable" : false,
						"width" : "100px",
						"render" : function(data, type, full, meta) {
							var estado = "";
							if (full.seriestado == 2) {
								return "<div class='badge bg-red'>"+ "INACTIVO" + "</div>";
							} else {
								return "<div class='badge' style='background-color: #15a01f;' >"+ "ACTIVO" + "</div> ";
							}
						}
					},
					{
						"targets" : 6,
						"data" : "accion",
						"defaultContent" : "",
						"className" : "text-center",
						"orderable" : false,
						"width" : "100px",
						"render" : function(data, type, full, meta) {
							var estadoEd = "";
							var estadoIn = "";
							if (full.seriestado == 2) {
								estadoEd = "disabled";
								estadoIn = "disabled";
							}else if (full.serieSecuen != 0) {
								estadoEd = "disabled";
								estadoIn = "";
							}
							return    "<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetSerie' title ='Ver Detalle' attr-ident='"+ full.seriBident + "' > </button> "
									+ "<button type='button' class='fa fa-edit editar btn btn-warning btn-sm btnEditSerie' title ='Editar' attr-ident='"+ full.seriBident+ "'" +""+estadoEd+" > </button> "
									+ "<button type='button' class='fa fa-ban delete btn btn-danger btn-sm btnInhaSerie' title ='Inhabilitar' attr-ident='"+ full.seriBident+ "'" +""+estadoIn+"> </button> ";
						}
					}

			],
			"preDrawCallback" : function(settings) {
				var api = new $.fn.dataTable.Api(settings);
				var pagination = $(this).closest('.dataTables_wrapper').find('.dataTables_paginate');
				pagination.toggle(api.page.info().pages > 1);
			},
			"drawCallback" : function(settings) {
				$(".filterWrapping").append($(".filter-block"));
				$(".filterActive").append($("#filterActive"));
				$("#filterActive").removeClass("hidden");
				$(".filter-block").removeClass("hidden");
				$(".multiBtnWrapping").append($("#btnBar_multipleSelection"));
				$("#btnBar_multipleSelection").removeClass("hidden");
				$(this).closest('.dataTables_wrapper').removeClass("form-inline");
				$("input[id='select_all']").prop('checked', false);

			}
	});
	$("#lstSerie_filter").hide();
}

Serie.prototype.habilitar = function(tipo) {
	if(tipo=="1"){
		$("#listaCatDetComp").attr("readonly", false);
		$("#serieNro").attr("readonly", false);
		$("#sucu_empr").attr("readonly", false);
		$("#listaCatDetComp" ).val($("#tipoDoc").val()).trigger( "change" );
		$("#sucu_empr" ).val($("#sucursal").val()).trigger( "change" );
	}else if(tipo=="2"){
		$("#listaCatDetComp").attr("readonly", true);
		$("#serieNro").attr("readonly", true);
		$("#sucu_empr").attr("disabled", true);
	}
}

Serie.prototype.crearSerie = function() {
	var l = Ladda.create(document.querySelector('#frmSerieGuardar'));
	var dataSerie;
	dataSerie = {
		"tipoDoc" : $("#listaCatDetComp").val(),
		"serie" : $("#serieNro").val(),
		"sucursal" : $("#sucu_empr").val(),
		"proceso":"I"
	}
	$.ajax({
		url : "/SistemaFE/serie/administrarSerie/",
		type : "POST",
		data : dataSerie,
		dataType : "json",
		beforeSend : function() {
			l.start();
		},
		success : function(data) {
			if (data.msg == "ok") {
				swal({
					title : 'Se creo una nueva serie',
					text : '',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false,
					allowEscapeKey : false
				}).then(function() {
					location.href = "/SistemaFE/serie/";
				})
			} else {
				bootbox.alert("<label class='text-danger'>ADVERTENCIA : <br>La serie ya se encuentra registrada , ingrese una nueva.</label>");
				l.stop();
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
}

Serie.prototype.editarSerie = function() {
	var l = Ladda.create(document.querySelector('#frmSerieGuardar'));
	var obj = this;
	var serie = 
    {
			"seriId2":$("#seriId2").val(),
			"tipoDoc" : $("#listaCatDetComp").val(),
			"serie" : $("#serieNro").val(),
			"sucursal" : $("#sucu_empr").val(),
			"proceso":"M"
    };
	$.ajax({
		url : "/SistemaFE/serie/ActualizarSerie/",
		type : "POST",
		data : JSON.stringify(serie),
		dataType : "json",
		contentType: "application/json",
		beforeSend : function() {
			// $('#btnProccess').ladda().ladda('start');
		},
		success : function(data) {
			if (data.msg == "ok") {
				swal({
					title : 'Se actualizó correctamente',
					text : 'Listo',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false,
					allowEscapeKey : false
				}).then(function() {
					location.href = "/SistemaFE/serie/";
				})
			}else
				if (data.msg == "Existe"){
					bootbox.alert("<label>La serie ya se encuentra registrada</label>");
				} else
					if (data.msg == "Uso"){
						bootbox.alert("<label>La serie ya está en uso</label>");
					}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
}
