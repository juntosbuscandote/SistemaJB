/**
 * Controller para la grilla empresa
 * 
 * @returns
 */
function Sucursal() {
	this.lstSucursal = $('#lstSucursal');
	this.lstUsuario = $('#lstUsuario');
	this.lstUsuarioxsucursal = $('#lstUsuario');
	this.lstUsuarioDataTableGrilla;
	this.gMethods = system.globalMethods;
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});

}
Sucursal.prototype.init = function() {
	this.handler();
	this.listarSucursal();
	this.listarUsuarioxSucursal(); 
//	this.listarUsuario();
}

Sucursal.prototype.handler = function() {
	var obj=this;
	obj.gMethods.setAutocompletado();
	obj.gMethods.setValidatorDefaults();
	obj.gMethods.setSoloNumero();
	obj.habilitar(1);
	  var selected = [];
//	$('input[name="box"]').on('change', function(e){
//	    if (this.checked) {
//	        console.log('Checkbox ' + $(e.currentTarget).val() + ' checked');
//	    } else {
//	        console.log('Checkbox ' + $(e.currentTarget).val() + ' unchecked');
//	    }
//	});
	
//	if ($('.checkuser').is(':checked') ) {
//	    console.log("Checkbox seleccionado");
//	}

	$('body').on('click', '#btn_cleanSucursal', function(event) {
		$('#frmEmpFiltroEstado').val('').trigger('change');
	});
	  
	$('body').on('change', '.checkuser', function() {
		var boton=$(this);
		var idOffice=boton.attr("attr-persident");
		 var id = this.id;
	        var index = $.inArray(id, selected);
	        var $row = $(this).closest('tr');
	        if( $(this).is(':checked') ) {
	            selected.push(id);
	            console.log("Activo "+index);        
	            $row.addClass('selected');     
//	            var boton=$(this);
//	            var codDetselect=boton.attr( "attr-idBident" );
	            $("#idDetalle").val(idOffice);   
//	            $("#idParaElDetalle").val(codDetselect);
//        if($(this).is(':checked')){
//            $('input[type="checkbox"]').not(this).prop('checked', false); 
//            var tr = $(this).closest('tr'); 
            console.log(" "+idOffice);	
//            
//        }else{
//        	console.log("salio input");	
        }
    });
	
	if($("#proccess").val()=="modif"){
		$("#sucu_codigo").attr("readonly", true);
		$("#alm_codigo").attr("readonly", true);
		$("#sucu_empr" ).val($("#busiBident").val()).trigger( "change" );
	}
	
	
//	$("#btnSucursalxUsuario").click(function() {
//		if($("#proccess").val()=="modif"){
//			obj.editarSucursal();
//		}else{
//			obj.crearUsuarioxSucursal();
//		}
//	});
	
	
	
	$("#frmSucursalGuardar").click(function() {
		if($("#proccess").val()=="modif"){
			obj.editarSucursal();
		}else{
			obj.crearSucursal();
		}
	});
	
	$("#btnSalir").click(function(e) {
		bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res) {
			if (res) {
				location.href = "/SistemaFE/sucursal/";
			}
		});
	});
	
	$("#btnSalirUserSucursal").click(function(e) {
		bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res) {
			if (res) {
				location.href = "/SistemaFE/sucursal/";
			}
		});
	});
	
	
	$('body').on('click', '.btnEditSuc', function() {
		var boton=$(this);
		var idOffice=boton.attr("attr-ident");
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar sucursal?:</label>",function(res){
			if (res) {			
				location.href="/SistemaFE/sucursal/editarSucursal?idOffice="+idOffice;				
			}
		});
	}); 
	
	$('body').on('click', '.btnUserSucursal', function() {
		var boton=$(this);
		var idOffice=boton.attr("attr-ident");
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea añadir usuarios a esta sucursal?:</label>",function(res){
			if (res) {			
				location.href="/SistemaFE/sucursal/usuarioxsucursal?idOffice="+idOffice;	
				$("#grupocom_vmodule" ).val(idOffice).trigger( "change" );
			}
		});
	}); 
	
	$('body').on('click', '.delete', function() {
		var boton=$(this);
		var idOffice=boton.attr("attr-ident");
		var idOffice=boton.attr("attr-ident");
		var idOffice=boton.attr("attr-ident");
		
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea deshabilitar la venta:</label> <label class='text-danger'>?</label>",function(res){
			if (res) {
				$.ajax({
					url : "/SistemaFE/sucursal/DeshabilitarSucursal/",
					type : "POST",
					data : {"codVta":idOffice
//						,"serie":serie,"nrodoc":nrodoc
						},
					dataType : "json",
					beforeSend : function() {
	//$('#btnProccess').ladda().ladda('start');
					},
					success : function(data) {
						if (data.msg == "ok") {
							bootbox.alert({
				                size: null,
				                title: null,
				                message: "<label class='text-danger'>Se Inhabilito sucursal :</label>",
				                callback: function () {
				                	location.href = "/SistemaFE/sucursal/";
				                }
				            });
						}else{
							alert("Esta enviado a sunat");
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
			}
		});
	});
	
	
	$('body').on('click', '.btnVerDetSuc', function() {
		var boton=$(this);
		var idOffice=boton.attr("attr-ident");
		$.ajax({
			url : "/SistemaFE/sucursal/detalleemp/",
			type : "POST",
			data : {"sucuId":idOffice},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$("#sucu_codigo").val(data.sucuCodigo);
					$("#sucu_nombre").val(data.sucuNombre);
					$("#sucu_nombreCorto").val(data.sucuNombreCorto);
					$("#sucu_telefono").val(data.sucuTelefono);
					$("#sucu_direccion").val(data.sucuDireccion);
					
					$("#alm_codigo").val(data.almCodigo);
					$("#alm_nombre").val(data.almNombre);
					$("#alm_nombreCorto").val(data.almNombreCorto);
					$("#alm_telefono").val(data.almTelefono);
					$("#alm_encargado").val(data.almEncargado);
					$("#sucu_empr" ).val(data.busiBident).trigger( "change" );
					
					obj.habilitar(2);
					$("#frmmodalSucursal").modal("show");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
		$("#sucu_empr").select2({ width: '100%' });
	}); 
	
	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableUsuario();
    	
    });
	
	$('body').on('click', '#btn_searchSucursal', function(event) {
    	obj.reloadDataTableEmpresa();
    	
    });
//	$('body').on('click', '#btnUsuarioListar', function(event) {
//		this.listarUsuario();
//		obj.reloadDataTableUsuario(); 
//    });
//	$("#btnSucursalxUsuario").click(function() {
//		this.listarUsuarioxSucursal(); 
//		this.listarUsuario();
//	});
	  var numero = $('#grupocom_vmodule').val();
	  $('#idSucursal').val(numero);
//	if( $('#idSucursal').val(numero)==numero){
//		obj.reloadDataTableUsuario();
//		
//	}else{
//		this.listarUsuarioxSucursal(); 
//	}
	
	$("#btnSucursalxUsuario").click(function() {
	  var valores = new Array();
	  var valores2 = new Array();
	  $('input[type=checkbox]').each(function () {
	    if(this.checked){
	      valores.push(
	          $(this).parent().parent().find(".codigoDetVen").text()
	      );
	    }else{
	    	valores2.push(
	  	          $(this).parent().parent().find(".codigo").text()
	  	      );
	    }
	  });
	  
	  $("#idMostrarDetVenta").val(valores);
	  $("#idSucursal").val();
      $("#idMostrarDetVenta").val();
      $("#idModificar").val(valores2);
      obj.crearUsuarioxSucursal();
	  });
	$("#frmSucursal").validate({
		rules: {
			sucu_codigo: {
                required: true,
                maxlength: 2
            },
            sucu_nombre: {
                required: true,
                maxlength: 100
            },
            sucu_nombreCorto: {
                required: false,
                maxlength: 10
            },
            sucu_telefono: {
            	required: false,
            	maxlength: 15
            },
            sucu_direccion: {
            	required: true,
            	maxlength: 250
            },
            sucu_empr: {
            	required: true
            },
            alm_codigo: {
            	required: true,
            	maxlength: 2
            },
            alm_nombre: {
            	required: true,
            	maxlength: 100
            },
            alm_nombreCorto: {
            	required: true,
            	maxlength: 10
            },
            alm_telefono: {
            	required: false,
            	maxlength: 50
            },
            alm_encargado: {
            	required: false,
            	maxlength: 250
            }
        }
	});
	
	
}

Sucursal.prototype.reloadDataTableEmpresa = function() {
	this.lstSucursal.DataTable().ajax.url("/SistemaFE/sucursal/lista_sucursal"+'?'+$('#frm_filtrarSucursal').serialize()).load();
}

Sucursal.prototype.listarSucursal = function() {
	var obj = this;
	obj.lstSucursal.DataTable({
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
				"url" : "/SistemaFE/sucursal/lista_sucursal" + "?"+ $('#frm_filtrarSucursal').serialize(),
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
						"data" : "offiVcode"
					},
					{
						"targets" : 2,
						"data" : "offiVname"
					},
					{
						"targets" : 3,
						"data" : "offiVshortname"
					},
					{
						"targets" : 4,
						"data" : "offiVphone"
					},
					{
						"targets" : 5,
						"data" : "offiVaddress"
					},
					{
						"targets" : 6,
						"data" : "accion",
						"defaultContent" : "",
						"className" : "text-center",
						"orderable" : false,
						"width" : "100px",
						"render" : function(data, type, full, meta) {
							var estado = "";
							if (full.offiState == "Inactivo") {
								return "<div class='badge bg-red'>"+ "Inactivo" + "</div>";
							} else {
								return "<div class='badge' style='background-color: #15a01f;' >"+ "Activo"+ "</div> ";
							}
						}
					},
					{
						"targets" : 7,
						"data" : "accion",
						"defaultContent" : "",
						"className" : "text-center",
						"orderable" : false,
						"width" : "100px",
						"render" : function(data, type, full, meta) {
							var estado = "";
							if (full.busiState == "Inactivo") {
								estado = "disabled"
							}
							return    "<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetSuc' title ='Ver Detalle' attr-ident='"+ full.offiBident + "' > </button> "
									+ "<button type='button' class='fa fa-edit editar btn btn-warning btn-sm btnEditSuc' title ='Editar' attr-ident='"+ full.offiBident+ "' > </button> "
									+ "<button type='button' class='fa fa-users btn btn-success btn-sm btnUserSucursal' title ='Usuario Sucursal' attr-ident='"+ full.offiBident+ "' > </button> "
									+ "<button type='button' class='fa fa-ban delete btn btn-danger btn-sm btnInhaSuc' title ='Inhabilitar' attr-ident='"+ full.offiBident+ "' > </button> ";
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
	
	$("#lstSucursal_filter").hide();
}
 
Sucursal.prototype.habilitar = function(tipo) {
	if($("#validEmpr").val()=="1"){
		$("#sucu_empr").attr("disabled", false);
	}else{
		$("#sucu_empr").attr("disabled", true);
	}
	if(tipo=="1"){
		$("#sucu_codigo").attr("readonly", false);
		$("#sucu_nombre").attr("readonly", false);
		$("#sucu_nombreCorto").attr("readonly", false);
		$("#sucu_telefono").attr("readonly", false);
		$("#sucu_direccion").attr("readonly", false);
		
		$("#alm_codigo").attr("readonly", false);
		$("#alm_nombre").attr("readonly", false);
		$("#alm_nombreCorto").attr("readonly", false);
		$("#alm_telefono").attr("readonly", false);
		$("#alm_encargado").attr("readonly", false);
	}else if(tipo=="2"){
		$("#sucu_codigo").attr("readonly", true);
		$("#sucu_nombre").attr("readonly", true);
		$("#sucu_nombreCorto").attr("readonly", true);
		$("#sucu_telefono").attr("readonly", true);
		$("#sucu_direccion").attr("readonly", true);
		
		$("#alm_codigo").attr("readonly", true);
		$("#alm_nombre").attr("readonly", true);
		$("#alm_nombreCorto").attr("readonly", true);
		$("#alm_telefono").attr("readonly", true);
		$("#alm_encargado").attr("readonly", true);
	}
}

Sucursal.prototype.crearSucursal = function() {
	var l = Ladda.create(document.querySelector('#frmSucursalGuardar'));
	var dataSucursal;
	dataSucursal = {
		"sucuCodigo" : $("#sucu_codigo").val(),
		"sucuNombre" : $("#sucu_nombre").val(),
		"sucuNombreCorto" : $("#sucu_nombreCorto").val(),
		"sucuTelefono" : $("#sucu_telefono").val(),
		"sucuDireccion" : $("#sucu_direccion").val(),
		"sucuEmpr" : $("#sucu_empr").val(),

		"almCodigo" : $("#alm_codigo").val(),
		"almNombre" : $("#alm_nombre").val(),
		"almNombreCorto" : $("#alm_nombreCorto").val(),
		"almTelefono" : $("#alm_telefono").val(),
		"almEncargado" : $("#alm_encargado").val(),
		"proceso":"I"
	}
	if($("#frmSucursal").valid()){
	$.ajax({
		url : "/SistemaFE/sucursal/administrarSucursal/",
		type : "POST",
		data : dataSucursal,
		dataType : "json",
		beforeSend : function() {
			l.start();
		},
		success : function(data) {
			if (data.msg == "ok") {
				swal({
					title : 'Se creo un nuevo sucursal',
					text : '',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false
				}).then(function() {
					location.href = "/SistemaFE/sucursal/";
				})
			} else {
				bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
	}
}

Sucursal.prototype.editarSucursal = function() {
	var l = Ladda.create(document.querySelector('#frmSucursalGuardar'));
	var dataSucursal;
	dataSucursal = {
		"sucuId":$("#sucuId").val(),
		"sucuCodigo" : $("#sucu_codigo").val(),
		"sucuNombre" : $("#sucu_nombre").val(),
		"sucuNombreCorto" : $("#sucu_nombreCorto").val(),
		"sucuTelefono" : $("#sucu_telefono").val(),
		"sucuDireccion" : $("#sucu_direccion").val(),
		"sucuEmpr" : $("#sucu_empr").val(),

		"almId":$("#almId").val(),
		"almCodigo" : $("#alm_codigo").val(),
		"almNombre" : $("#alm_nombre").val(),
		"almNombreCorto" : $("#alm_nombreCorto").val(),
		"almTelefono" : $("#alm_telefono").val(),
		"almEncargado" : $("#alm_encargado").val(),
		"proceso":"M"
	}
	$.ajax({
		url : "/SistemaFE/sucursal/administrarSucursal/",
		type : "POST",
		data : dataSucursal,
		dataType : "json",
		beforeSend : function() {
			l.start();
		},
		success : function(data) {
			if (data.msg == "ok") {
				swal({
					title : 'Se actualizo sucursal',
					text : '',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false
				}).then(function() {
					location.href = "/SistemaFE/sucursal/";
				})
			} else {
				bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
}

Sucursal.prototype.crearUsuarioxSucursal = function() {
	var l = Ladda.create(document.querySelector('#frm_filtrarUsuario'));
	 var selected = [];
	var arrayRegistros = [];
	var obj = this;
	var id = this.id;
    var index = $.inArray(id, selected);
    var $row = $(this).closest('tr');
  
    var sucucodigo=$("#idSucursal").val();
    var proceso=$("#idMostrarDetVenta").val();
    var sucuxuserbident =$("#idModificar").val();
	$.ajax({
		url : "/SistemaFE/sucursal/administrarUserxSucursal/",
		type : "POST",
		data : {"sucucodigo":sucucodigo,"proceso":proceso,"sucuxuserbident":sucuxuserbident},
		dataType : "json",
		beforeSend : function() {
			l.start();
		},
		success : function(data) {
			if (data.msg == "ok") {
				swal({
					title : 'Se Procedio Correctamente',
					text : '',
					type : 'success',
					confirmButtonColor : '#3085d6',
					confirmButtonText : 'Ok',
					confirmButtonClass : 'btn btn-success',
					buttonsStyling : false,
					allowOutsideClick : false
				}).then(function() {
					location.href = "/SistemaFE/sucursal/";
				})
			} else {
				bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
//	}
}



Sucursal.prototype.reloadDataTableUsuario = function() {
	this.lstUsuarioxsucursal.DataTable().ajax.url("/SistemaFE/sucursal/lista_sucursalxusuario"+'?'+$('#frm_filtrarUsuario').serialize()).load();
}

Sucursal.prototype.listarUsuarioxSucursal = function () {
    var obj = this;
    var numero = $('#grupocom_vmodule').val();
    obj.lstUsuarioDataTableGrilla= obj.lstUsuarioxsucursal.DataTable({
    	"sPaginationType": "simple_numbers",
    	  "scrollY" : "500px",
    	"scrollX": true,
    	"sScrollX": "100%",
// "scrollY": 400,
// "SSCROLLXINNER": "101%",
    	"bScrollCollapse": true,
        "processing": false,
        "serverSide": true,
        "order": [],
        
        "colReorder": {
            "fixedColumnsLeft": 1,
            "fixedColumnsRight": 2
        },
        "pagingType": "numbers",
        "lengthMenu": [10,25,50,100],
        "pageLength": 10,
// "iDisplayLength": 10,
        "paging": true,
        "Paginate" : true,
        // se creara otro metodo para obtener la lista desde el controlador
        "ajax": {
            "url": "/SistemaFE/sucursal/lista_sucursalxusuario"+"?"+"idSucursal="+numero,
            "type": "POST"
        },
       
        "columnDefs": [
            {
            	
                "targets":  0, 
                "data": "sel", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.offiBident=="1"){
                    return "<input type='checkbox' class='flat checkuser' name='box' checked  attr-persident='"+full.userVuser+"'" +
                    "attr-sucuxuser='"+full.offiBident+"'" +
                    "attr-sucuuser_bident='"+full.offiBident+"'/>";
                }	
                    else{
                	return "<input type='checkbox' class='flat sss checkuser' name='box'  attr-persident='"+full.userVuser+"'" +
                	"attr-sucuuser_bident='"+full.offiBident+"'/>";
                }
                    }
            },
            {"targets": 1, "class" : "codigoDetVen","data": "userVuser"},
            {"targets": 2,  "data": "userNombres"},
            {"targets": 3,"class" : "codigo",  "visible":false,"data": "offiBident"},
            {"targets": 4, "visible": false,"data": "userNombres"},
            {"targets": 5, "visible": false,"data": "userNombres"},
//            {"targets": 6, "data": "userState"},
            {
                "targets": 6,
                "visible": false,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
//                    if(full.userState=="activo"){
//                   	 	return 	"<div class='badge' style='background-color: #15a01f;'>"+full.userState+ "</div> ";
//                    } else {
//                    	return 	"<div class='badge bg-red'>"+full.userState+ "</div>";
//                    }
                   
                }
            },           
            {
                "targets": 7, 
                "visible": false,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.userState=="inactivo"){
                    	estado="disabled"
                    }
                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetUser ladda-button' title ='Ver Detalle'" +
                    " attr-user='"+full.userVuser+"'"+   
                    		" > </button> " +
                    		"<button type='button' class='fa fa-edit editar btn btn-warning btn-sm' id='btnEditar' title ='Editar' " +
//                    		"attr-ruc='"+full.busiVruc+"'" +
                    		" attr-user='"+full.persBident+"'"+" attr-usuario='"+full.userVuser+"'"+
                            ""+estado+"> </button> " +
                            "<button type='button' class='fa fa-ban delete btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' " +
//                            "attr-ruc='"+full.busiVruc+"'" +
                            " attr-user='"+full.persBident+"'"+" attr-usuario='"+full.userVuser+"'"+
                            ""+estado+"> </button> "
//                            + 
//                            "<button type='button' class='fa fa-edit agrega btn btn-warning btn-sm' id='agregar' title ='Crear' " +
//                    		" attr-user='"+full.userVuser+"'"+   
//                           ""+estado+"> </button> "
                           ;
                }
            }
        ]
        ,
        "preDrawCallback": function (settings) {
            var api = new $.fn.dataTable.Api(settings);
            var pagination = $(this).closest('.dataTables_wrapper').find('.dataTables_paginate');
            pagination.toggle(api.page.info().pages > 1);
        },
        "drawCallback": function (settings) {
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
    $("#lstUsuario_filter").hide();
}



    	



