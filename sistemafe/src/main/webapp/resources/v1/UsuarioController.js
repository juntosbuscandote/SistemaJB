function Usuario() {
	this.lstUsuario = $('#lstUsuario');
//	var button = "<input type='button'  class='btn btn-primary' value='Nuevo Usuario' id='nuevo_usuario' name='Nuevo Usuario'" +" attr-userID='"+usuario+"'	/>"
//	$('#agregar').append(button);
	this.objPerson=null;
	this.gMethods = system.globalMethods;
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});
}

Usuario.prototype.init = function() {
	this.handler();
	this.listarUsuario();
	
}

Usuario.prototype.handler = function() {
	var obj=this;
	
    $('body').on('click', '#btn_clean', function(event) {
		$('#frmUserFiltroPerfil').val('').trigger('change');
		$('#frmUserFiltroEstado').val('').trigger('change');
    });
    $("#vstBussiness").hide();
    $("#filtroCompraCP").select2({ width: '100%' });
	$("#listaProfile").val("2");
	$("#vstBussines").hide();
	
	if($("#proccess").val()=="modif"){
		$("#listaProfile").val($("#perfil").val());
		$("#user_vpassword").attr("readonly", false);
		$("#user_vRepassword").attr("readonly", false);
		$("#listaProfile").attr("disabled", false);
		$("#usu_sucursal").attr("disabled", false);
		$('#listaProfile').trigger('change');
		$("#vstBussiness").show();
		$("#vstPassword").hide();		
		if($("#listaProfile").val()=="2" || $("#listaProfile").val()=="3" ){
			$("#vstBussiness").hide();
		}
	}else{
		$("#listaProfile").change(function() {
			if($("#listaProfile").val()=="2" || $("#listaProfile").val()=="3" ){
				$("#vstBussines").hide();
				$("#usu_sucursal").attr("disabled", true);	
			}else{
				$("#vstBussines").show();
				$("#usu_sucursal").attr("disabled", false);
			}
		});
		
	}
	
	function validarContra(value, element, param) {
    	if($("#user_vpassword").val()!="" && $("#user_vRepassword").val()!=""){
			return $("#user_vpassword").val()==$("#user_vRepassword").val();
		}else{
			return true;
		}
	}
	$.validator.addMethod("validarContra", validarContra, "Contraseñas diferentes");
	
	$("#btnSalir").click(function(e){
		bootbox.confirm("<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",function(res){
			if (res) {
				location.href = "/SistemaFE/usuario/";
			}
		});
	});
	
	$("#frmUser").validate({
		rules : {
			listaProfile : {
				required : true,
			},
			usu_empresa : {
				required :  {
                    depends: function (element) {
                        return $("#listaProfile").val() =='1';
                    }
				}
			},
			user_vuser : {
				required : true
			},
			usu_sucursal : {
				required : true
			},
			user_vpassword : {
				required : true
			},
			user_vRepassword : {
				required : true,
				validarContra: true
			}
		}

	});
	

	$("#btnRegUser").click(function() {
		var l = Ladda.create(this);
		var valid=obj.validarUsuario();
		if($("#proccess").val()!="modif" && valid){
			bootbox.alert("<label class='text-danger'>ERROR : <br> Ya existe el usuario</label>");
		}else{
			if(obj.objPerson.validarPersona() && $("#frmUser").valid()){
				l.start();
				obj.objPerson.crearPersona(obj);
				obj.crearEmpresa(this);
			}
		}
	});
	
	//funcion de persona
	$("#btnValidNum").click(function() { 
		$("#listaProfile").attr("disabled", false);
		$("#user_vuser").attr("readonly", false);
		$("#user_vpassword").attr("readonly", false);
		$("#user_vRepassword").attr("readonly", false);
		
		$("#listaProfile").val("2");
		$("#user_vuser").val("");
		$("#user_vpassword").val("");
		$("#user_vRepassword").val("");
	});

	//funcion de persona
	$('input[type=radio][name=frmTipoPerson]').change(function() {
//		$("#listaProfile").attr("disabled", true);
//		$("#user_vuser").attr("readonly", true);
//		$("#user_vpassword").attr("readonly", true);
//		$("#user_vRepassword").attr("readonly", true);
		
		$("#listaProfile").val("2");
		$("#user_vuser").val("");
		$("#user_vpassword").val("");
		$("#user_vRepassword").val("");
		$('#listaProfile').trigger('change');
		
	});
	
	//funcion de persona
	$('#pers_vnumdoc').change(function() {
		$("#listaProfile").attr("disabled", true);
		$("#user_vuser").attr("readonly", true);
		$("#user_vpassword").attr("readonly", true);
		$("#user_vRepassword").attr("readonly", true);

		$("#listaProfile").val("2");
		$("#user_vuser").val("");
		$("#user_vpassword").val("");
		$("#user_vRepassword").val("");
		
	});
	
	
	
	
	
	
	
	$('#frmCPEFiltrosfecInicio').daterangepicker();
   
	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableUsuario();
    	
    });
	

	$('body').on('click', '.editar', function() {
		var boton=$(this);
		var nomUser=boton.attr( "attr-usuario" );
		console.log(boton.attr( "attr-user" ));
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea modificar usuario</label>"+' '+nomUser+
		"<label class='text-danger'>?</label>",function(res){
			if (res) {
				location.href="/SistemaFE/usuario/EditarUsuario?usuario="+nomUser;
			}
		});
	}); 

	// Boton ver detalle
	$('body').on('click', '.btnVerDetUser', function() {
		var boton=$(this);
		var user=boton.attr( "attr-user" );
		$.ajax({
			url : "/SistemaFE/usuario/detalleusuario/",
			type : "POST",
			data : {"user":user},  
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if (data.msg == "ok") {
					obj.gMethods.verPersona(data);
					
					$("#frmmodalEditarUsuario").modal("show");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	});
	
	// Cambiar estado empresa
		$('body').on('click', '.delete', function() {
			var boton=$(this);
			var user=boton.attr( "attr-user" );
			var nomUser=boton.attr( "attr-usuario" );
			var emple=boton.attr( "attr-emple" );
//			var =boton.attr( "attr-empleado" );
			bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea inhabilitar el usuario:</label>"+' '+nomUser+" <label class='text-danger'>?</label>",function(res){
				if (res) {
					$.ajax({
						url : "/SistemaFE/usuario/EstadoUsuario/",
						type : "POST",
						data : {"user":user},
						dataType : "json",
						beforeSend : function() {
// $('#btnProccess').ladda().ladda('start');
						},
						success : function(data) {
							if (data.msg == "ok") {
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>Se inhabilitó el usuario :</label>"+nomUser,
					                callback: function () {
					                	location.href = "/SistemaFE/usuario/";
					                }
					            });
							}
						},
						error : function(xhr, statusText, errorThrown) {
							console.log("ocurrio un error");  
						}
					});
					
				}
			});
		});
		
}

Usuario.prototype.procesar = function(data) {
	var objrsp=JSON.parse(data);
	var l = Ladda.create(document.querySelector('#btnRegUser'));
	if($("#proccess").val()=="modif"){
		$.ajax({
			url : "/SistemaFE/usuario/actualizarUsuario/",
			type : "POST",
			data : {
				"usuario":$("#user_vuser").val(),
				"contra":$("#user_vpassword").val(),
				"perfil":$("#listaProfile").val(),
				"personId":objrsp["persBident"]
				},
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if (data.msg == "ok") {
					swal({
						title : 'Se actualizo el usuario',
						text : '',
						type : 'success',
						confirmButtonColor : '#3085d6',
						confirmButtonText : 'Ok',
						confirmButtonClass : 'btn btn-success',
						buttonsStyling : false,
						allowOutsideClick : false,
						allowEscapeKey : false
					}).then(function() {location.href = "/SistemaFE/usuario/";})
				}else{
					bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
			}
		});
	}else{
		$.ajax({
			url : "/SistemaFE/usuario/insertarUsuario/",
			type : "POST",
			data : {
				"perfil":$("#listaProfile").val(),
				"usuario":$("#user_vuser").val(),
				"contra":$("#user_vpassword").val(),
				"empreId":$("#busibident").val(),
				"sucuId":$("#usu_sucursal").val(),
				"personId":objrsp["persBident"]
				},
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if (data.msg == "ok") {				
					$.ajax({
						url : "/SistemaFE/empresa/enviarcorreo",
						type : "POST",
						data : {"correo_rl" : $('#natural_vmail').val(),
								"emp_nombre" : $('#natural_vname').val(),
								"user_rl" : $('#user_vuser').val(),
								"contra" : $('#user_vpassword').val()
								},
								dataType : "json",
								beforeSend : function() {},
								success : function(data) {
									if (data.cod == "1") {	
									swal({
										title : 'Se creo un nuevo usuario',
										text : 'Se envió credenciales a '+ $('#natural_vmail').val(),
										type : 'success',
										confirmButtonColor : '#3085d6',
										confirmButtonText : 'Ok',
										confirmButtonClass : 'btn btn-success',
										buttonsStyling : false,
										allowOutsideClick : false,
										allowEscapeKey : false
									}).then(function() {location.href = "/SistemaFE/usuario/";})											
									} else {					
										swal({
											title : 'Se creo nuevo usuario',
											type : 'info',			 
											text : "ALERTA :  No se envio las credenciales a" + $('#natural_vmail').val(),												
											confirmButtonColor : '#3085d6',
											confirmButtonText : 'Ok',
											confirmButtonClass : 'btn btn-danger',
											buttonsStyling : false,
											allowOutsideClick : false
										}).then(function() {location.href = "/SistemaFE/usuario/";})
									}
								},
								error : function(xhr, statusText,
										errorThrown) {
									console.log("ocurrio un error");
								}
							});
				}else{
					bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					l.stop();
				}
			},
			error : function(xhr, statusText, errorThrown) {
				console.log("ocurrio un error");  
				l.stop();
			}
		});
	}
}

Usuario.prototype.reloadDataTableUsuario = function() {
	this.lstUsuario.DataTable().ajax.url("/SistemaFE/usuario/lista_usuario"+'?'+$('#frm_filtrarUsuario').serialize()).load();
}

Usuario.prototype.validarUsuario = function() {
	var valid=false
	$.ajax({
		url : "/SistemaFE/usuario/validarUsuario/",
		type : "POST",
		data : {"usuario":$("#user_vuser").val()},
		dataType : "json",
		async: false,
		beforeSend : function() {
		},
		success : function(data) {
			if (data.msg == "1") {
				valid=true;
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
	return valid;
}


Usuario.prototype.enviarCredencial = function(button) {
	var obj = this;
	$.ajax({
				url : "/SistemaFE/usuario/InsertarEmpresa/",
				type : "POST",
				data : $("#frmbussines").serialize()+"&validRepreLegal="+obj.insertRepreLegal+"&persBident="+obj.persBident,
				//+"&legal_vpais="+$('#legal_vpais').val()+"&legal_vlocalidad="+$('#legal_vlocalidad').val()+"&legal_vtipoPerson="+$('#legal_vtipoPerson').val(),
				dataType : "json",
				beforeSend : function() {},
				success : function(data) {
					if (data.msg == "ok") {
						$.ajax({
							url : "/SistemaFE/empresa/enviarcorreo",
							type : "POST",
							data : {"correo_rl" : $('#mail_vmail_repleg').val(),
									"emp_nombre" : $('#lega_businame').val(),
									"user_rl" : data.user,
									"contra" : $('#pers_vnumdoc_repleg').val()
									},
									dataType : "json",
									beforeSend : function() {},
									success : function(data) {
										// Se añadio para el efecto de aviso que
										// se guardo correctamente Luis S.
										if (data.cod == "1") {
											// bootbox.alert("Se reenvio
											// correctamente la información");
											swal({
												title : 'Se creo nueva empresa',
												text : 'Se envió credenciales a '+ $('#mail_vmail_repleg').val(),
												type : 'success',
												confirmButtonColor : '#3085d6',
												confirmButtonText : 'Ok',
												confirmButtonClass : 'btn btn-success',
												buttonsStyling : false,
												allowOutsideClick : false,
												allowEscapeKey : false
											}).then(function() {location.href = "/SistemaFE/empresa/";})
										} else {
											
											swal({
												title : 'Se creo nueva empresa',
												type : 'info',			 
												text : "ALERTA :  No se envio las credenciales a" + $('#mail_vmail_repleg').val(),												
												confirmButtonColor : '#3085d6',
												confirmButtonText : 'Ok',
												confirmButtonClass : 'btn btn-danger',
												buttonsStyling : false,
												allowOutsideClick : false
											}).then(function() {location.href = "/SistemaFE/empresa/";})
										}
									},
									error : function(xhr, statusText,
											errorThrown) {
										console.log("ocurrio un error");
									}
								});

					}else{
						var l = Ladda.create(button);
						l.stop();
						bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
					}
				},
				error : function(xhr, statusText, errorThrown) {
					// l.stop();
					console.log("ocurrio un error");
				}
			});
	// })
}

Usuario.prototype.listarUsuario = function () {
    var obj = this;
    obj.lstUsuario.DataTable({
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
            "url": "/SistemaFE/usuario/lista_usuario"+"?"+$('#frm_filtrarUsuario').serialize(),
            "type": "POST"
        },
       
        "columnDefs": [
            {
            	
                "targets":  0, 
                "data": "sel", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "render": function (data, type, full, meta) {
                    return "<input type='checkbox' class='flat' />";
                }
            },
            {"targets": 1, "data": "userVuser"},
            {"targets": 2, "data": "userNombres"},
            {"targets": 3, "data": "userVdescription"},
            {"targets": 4, "data": "userBusiname"},
            {"targets": 5, "data": "userTregistrationDate"},
//            {"targets": 6, "data": "userState"},
            {
                "targets": 6,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.userState=="activo"){
                   	 	return 	"<div class='badge' style='background-color: #15a01f;'>"+full.userState+ "</div> ";
                    } else {
                    	return 	"<div class='badge bg-red'>"+full.userState+ "</div>";
                    }
                   
                }
            },           
            {
                "targets": 7,
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



    	



