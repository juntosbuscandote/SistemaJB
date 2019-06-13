/**
 * Controller para la grilla empresa
 * 
 * @returns
 */
function Empresa() {
	this.lstEmpresa = $('#lstEmpresa');
	this.gMethods = system.globalMethods;
	
	$.fn.select2.defaults.set("theme", "bootstrap");
	var placeholder = "Seleccione";
	$(".select2-single").select2({
		placeholder: placeholder,
		width: null,
		containerCssClass: ':all:'
	});
}
Empresa.prototype.init = function() {
	this.handler();
	this.listarEmpresa();
	
}

Empresa.prototype.handler = function() {
	var obj=this;
	
	obj.gMethods.setAutocompletado();
	obj.gMethods.setValidatorDefaults();
	obj.gMethods.setSoloNumero();
	$('body').on('click', '#btn_search', function(event) {
    	obj.reloadDataTableEmpresa();
    });
	
    $('body').on('click', '#btn_clean', function(event) {
		$('#frmEmpFiltroEstado').val('').trigger('change');
    });
	
	if($("#emprVdoctype").val()!=''){
		$("#empr_vdoctype").val($("#emprVdoctype").val());
	}
	if($("#repLegalVTipoDoc").val()!=''){
		$("#pers_vdoctype").val($("#repLegalVTipoDoc").val());
	}
	 
	
	$('body').on('click', '.editar', function() {
		var boton=$(this);
		var ruc=boton.attr( "attr-ruc" );
		var raz=boton.attr( "attr-raz" );
		console.log(boton.attr( "attr-ruc" ));
		// BootBox sobre el boton editar Luis S.
		bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea editar la empresa con N° de RUC :</label>"+' '+ruc+" <label class='text-danger'>?</label>",function(res){
			if (res) {
				location.href="/SistemaFE/empresa/EditarEmpresa?ruc="+ruc;
			}
			
		});
	});
	
	// Boton ver detalle
	$('body').on('click', '.btnVerDetEmp', function() {
		var boton=$(this);
		var ruc=boton.attr( "attr-ruc" );
		$.ajax({
			url : "/SistemaFE/empresa/detalleemp/",
			type : "POST",
			data : {"ruc":ruc},
			dataType : "json",
			beforeSend : function() {},
			success : function(data) {
				if (data.msg == "ok") {
					$("#empr_vdoctype").val(data.emprVdoctype);
					$("#pers_vnumdoc").val(data.persVnumdoc);
					$("#lega_businame").val(data.legaBusiname);
					$("#pers_vtradename").val(data.persVtradename);
					$("#phon_vphone").val(data.phonVphone);
					$("#legal_vpais").val(data.legalVpais);
					$("#legal_vlocalidad").val(data.legalVlocalidad);
					$("#mail_vmail").val(data.mailVemail);
					$("#addr_vaddress").val(data.addrVaddress);
					$("#legal_vtipoPerson").val(data.legalVtipoPerson);
					
					$("#pers_vdoctype").val(data.pers_vdoctype);
					$("#pers_vnumdoc_repleg").val(data.persVnumdocRepleg);
					$("#natu_vname").val(data.natuVname);
					$("#natu_vlastnamefather").val(data.natuVlastnamefather);
					$("#natu_vlastnamemother").val(data.natuVlastnamemother);
					$("#natural_vtradename").val(data.naturalVtradename);
					$("#natural_vtipoPerson").val(data.naturalVtipoPerson);
					$("#natural_vpais").val(data.naturalVpais);
					$("#natural_vlocalidad").val(data.naturalVlocalidad);
					$("#mail_vmail_repleg").val(data.mailVmailRepleg);
					$("#phon_vphone_repleg").val(data.phonVphoneRepleg);
					$("#addr_vaddress_repleg").val(data.addrVaddressRepleg);
					
					$("#frmmodalEditarEmpresa").modal("show");
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
			var ruc=boton.attr( "attr-ruc" );
			var user=boton.attr( "attr-user" );
			bootbox.confirm("<label class='text-danger'>¿Esta seguro que desea inhabilitar la empresa con N° de RUC :</label>"+' '+ruc+" <label class='text-danger'>?</label>",function(res){
				if (res) {
					$.ajax({
						url : "/SistemaFE/empresa/EstadoEmpresa/",
						type : "POST",
						data : {"pers_vnumdoc":ruc, "pers_bidentUser":user},
						dataType : "json",
						beforeSend : function() {},
						success : function(data) {
							if (data.msg == "ok") {
								bootbox.alert({
					                size: null,
					                title: null,
					                message: "<label class='text-danger'>Se inhabilitó la empresa con el RUC :</label>"+ruc,
					                callback: function () {
					                	location.href = "/SistemaFE/empresa/";
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

Empresa.prototype.reloadDataTableEmpresa = function() {
	this.lstEmpresa.DataTable().ajax.url("/SistemaFE/empresa/lista_empresa"+'?'+$('#frm_filtrarEmpresa').serialize()).load();
}

Empresa.prototype.listarEmpresa = function () {
    var obj = this;
    obj.lstEmpresa.DataTable({
    	"sPaginationType": "simple_numbers",
    	  "scrollY" : "500px",
    	"scrollX": true,
    	"sScrollX": "100%",
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
        "paging": true,
        "Paginate" : true,
        "ajax": {
            "url": "/SistemaFE/empresa/lista_empresa"+"?"+$('#frm_filtrarEmpresa').serialize(),
            "type": "POST"
        },
        "columnDefs": [
            {
                "targets": 0, 
                "data": "sel", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "render": function (data, type, full, meta) {
                    return "<input type='checkbox' class='flat' />";
                }
            },
            {"targets": 1, "data": "busiVruc"},
            {"targets": 2, "data": "busiVbusiname"},
            {"targets": 3, "data": "busiVaddress"},
            {"targets": 4, "data": "busiVemail"},
            {"targets": 5, "data": "busiVphone"},
            {
                "targets": 6,
                "data": "accion", "defaultContent": "",
                "className": "text-center",
                "orderable": false,
                "width": "100px",
                "render": function (data, type, full, meta) {
                	var estado="";
                    if(full.busiState=="Inactivo"){
                    	 return 	"<div class='badge bg-red'>"+full.busiState+ "</div>";
                    } else {
                    	 return 	"<div class='badge' style='background-color: #15a01f;' >"+full.busiState+ "</div> ";
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
                    if(full.busiState=="Inactivo"){
                    	estado="disabled"
                    }
                    return 	"<button type='button' class='btn btn-info fa fa-eye btn-sm btnVerDetEmp' title ='Ver Detalle' attr-ruc='"+full.busiVruc+"'" +
                    		" > </button> " +
                    		"<button type='button' class='fa fa-edit editar btn btn-warning btn-sm' id='btnEditar' title ='Editar' attr-ruc='"+full.busiVruc+"'" +
                    		" attr-raz='"+full.busiVbusiname+"'"+
                            ""+estado+"> </button> " +
                            "<button type='button' class='fa fa-ban delete btn btn-danger btn-sm' id='btnDeshabilitar' title ='Inhabilitar' attr-ruc='"+full.busiVruc+"'" +
                            " attr-raz='"+full.busiVbusiname+"'"+" attr-user='"+$("#pers_bidentUser").val()+"'"+
                            ""+estado+"> </button> ";
                }
            }

        ],
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
    $("#lstEmpresa_filter").hide();
}

function UsuariosValidaruc() {
	
}

UsuariosValidaruc.prototype.init = function() {
	this.handler();
}


UsuariosValidaruc.prototype.handler = function() {
	var obj = this;
}

/**
 * Controller para la insertar empresa
 * 
 * @returns
 */
function EmpresaProccess() {
	this.insertRepreLegal;
	this.persBident;
	this.gMethods = system.globalMethods;
}

EmpresaProccess.prototype.init = function() {
	this.handler();
}

EmpresaProccess.prototype.handler = function() {
	var obj = this;
	
	obj.gMethods.setAutocompletado();
	obj.gMethods.setValidatorDefaults();
	obj.gMethods.setSoloNumero();
	$("#empr_vdoctype").val(6);
	$("#pers_vdoctype").val(1);
	$('#empr_vdoctype').children('option[value="1"]').hide();
	
	if($("#emprGC").val()!=''){
		$( "#legal_vgrupoCom" ).val($("#emprGC").val()).trigger( "change" );
	}
	
	if($("#emprPais").val()!=''){
		$( "#legal_vpais" ).val($("#emprPais").val()).trigger( "change" );
	}
	
	
	if($("#emprLocalidad").val()!=''){
		$( "#legal_vlocalidad" ).val($("#emprLocalidad").val()).trigger( "change" );
	}
	if($("#emprDomici").val()!=''){
		$("#legal_vtipoPerson").val($("#emprDomici").val());
	}
	
	
	if($("#repPais").val()!=''){
		$( "#natural_vpais" ).val($("#repPais").val()).trigger( "change" );
	}
	if($("#repLocalidad").val()!=''){
		$( "#natural_vlocalidad" ).val($("#repLocalidad").val()).trigger( "change" );
	}
	if($("#repDomici").val()!=''){
		$("#natural_vtipoPerson").val($("#repDomici").val());
	}
	if($("#repLegalVTipoDoc").val()!=''){
		$("#pers_vdoctype").val($("#repLegalVTipoDoc").val());
	}
	
	if ($("#fProcess").val() != "save") {
		$("#validRucEmpresa").hide();
		$("#empr_vdoctype").attr("readonly", true);
		$("#pers_vnumdoc").attr("readonly", true);
		
		$("#lega_businame").attr("readonly", false);
		$("#pers_vtradename").attr("readonly", false);
		$("#phon_vphone").attr("readonly", false);
		$("#addr_vaddress").attr("readonly", false);
		$("#mail_vmail").attr("readonly", false);
		$("#natu_vname").attr("disabled", false);
		$("#natu_vlastnamefather").attr("disabled", false);
		$("#mail_vmail_repleg").attr("disabled", false);
		$("#natu_vlastnamemother").attr("disabled", false);
		$("#phon_vphone_repleg").attr("disabled", false);
		$("#pers_vnumdoc_repleg").attr("readonly", true);
		$("#pers_vdoctype").attr("disabled", false);
		$("#pers_vnumdoc_repleg").attr("readonly", false);
		$("#legal_vgrupoCom").attr("disabled", false);
		$('#legal_vlocalidad').attr("disabled", false);
		$('#legal_vpais').attr("disabled", false);
		
		
		$("#selTipDoc").hide();
		$("#nomTipDoc").show();

	}
	
	$("#btnSalir").click(function(e) {
		bootbox.confirm(
				"<label class='text-danger'>Se descartarán los cambios ¿Desea Salir?</label>",
				function(res) {
					if (res) {
						location.href = "/SistemaFE/empresa/";
					}
				});
	});

	$("#btnProccess").click(function() {
		var l = Ladda.create(this);
		l.start();
		if ($("#frmbussines").valid()) {
			if ($("#fProcess").val() == "save") {
				obj.crearEmpresa(this);
			} else {
				obj.updateEmpresa();
			}
		} else {
			l.stop();
			// alert("Verificar campos requeridos");
			bootbox.alert("<label>Verificar campos requeridos</label>");
		}
	});
	
	$("#validRucEmpresa").click(function(e) {
		$("#lega_businame").val("");
		$("#pers_vtradename").val("");
		$("#addr_vaddress").val("");
		$("#phon_vphone").val("");
		$("#mail_vmail").val("");
		$("#natu_vname").val("");
		$("#natu_vlastnamefather").val("");
		$("#mail_vmail_repleg").val("");
		$("#pers_vnumdoc_repleg").val("");
		$("#natu_vlastnamemother").val("");
		$("#phon_vphone_repleg").val("");

		$("#legal_vpais").val("").trigger( "change" );
		$("#legal_vlocalidad").val("").trigger( "change" );
		$('#legal_vtipoPerson').val("D");
		obj.limpiar();
		var l = Ladda.create(this);
			if ($("#pers_vnumdoc").valid()) {
				$.ajax({
						url : "validRuc",
						type : "POST",
						data : "ruc="+ $('#pers_vnumdoc').val(),
						dataType : "json",
						beforeSend : function() {
							l.start();
						},
						success : function(data) {
							if (data.estado == "0") {
								bootbox.alert("<label class='text-danger'>Existe una empresa registrada con el mismo RUC</label>");
								$("#consultarSunat").hide();
								$("#lega_businame").attr("readonly","readonly");
								$("#pers_vtradename").attr("readonly","readonly");
								$("#addr_vaddress").attr("readonly","readonly");
								$("#phon_vphone").attr("readonly","readonly");
								$("#mail_vmail").attr("readonly","readonly");
								$('#pers_vdoctype').attr("disabled", true);
								$("#natu_vname").attr("readonly","readonly");
								$("#natu_vlastnamefather").attr("readonly","readonly");
								$("#mail_vmail_repleg").attr("readonly","readonly");
								$("#pers_vnumdoc_repleg").attr("readonly","readonly");
								$("#natu_vlastnamemother").attr("readonly","readonly");
								$("#phon_vphone_repleg").attr("readonly","readonly");
								
								$('#legal_vpais').attr("disabled", true);
								$('#legal_vlocalidad').attr("disabled", true);
								$('#legal_vtipoPerson').attr("disabled", true);
								
							} else if(data.estado == "2"){
								bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
							} else {
								if(data.rspsunat == "2"){
									bootbox.alert("<label class='text-danger'><br> No existe este ruc en sunat</label>");
								}else{
									if(data.tipoPerson == "N"){
										bootbox.alert("<label class='text-danger'><br> El numero de ruc pertenece a una persona natural</label>");
									}else{
										$("#consultarSunat").show();
										$("#lega_businame").val(data.razonSocial);
										$("#addr_vaddress").val(data.direccion);
										$("#legal_vlocalidad").val(data.idubigeo).trigger("change");
										$("#estadoSunat").html('<label class="control-label '+data.estadoColor+'" for="natural_vmail">'+data.estadoSunat+'</label>');
										$("#condicionSunat").html('<label class="control-label '+data.condicionDomicilioColor+'" for="natural_vmail">'+data.condicionDomicilio+'</label>');
									}
								}
								$("#lega_businame").removeAttr("readOnly");
								$("#pers_vtradename").removeAttr("readOnly");
								$("#addr_vaddress").removeAttr("readOnly");
								$("#phon_vphone").removeAttr("readOnly");
								$("#mail_vmail").removeAttr("readOnly");
								$('#pers_vdoctype').removeAttr("disabled")
								$("#pers_vnumdoc_repleg").removeAttr("readOnly");
								$('#legal_vpais').attr("disabled", false);
								$('#legal_vgrupoCom').attr("disabled", false);
								$('#legal_vlocalidad').attr("disabled", false);
								$('#legal_vtipoPerson').attr("disabled", false);
							}
							l.stop();
						},
						complete : function() {},
						error : function(jqXHR, exception) {
								if (jqXHR.status === 0) {
								} else if (jqXHR.status == 400) {
								} else if (jqXHR.status == 401) {
								} else if (jqXHR.status == 403) {
								} else if (jqXHR.status == 404) {
								} else if (jqXHR.status == 500) {
								} else if (jqXHR.status == 503) {
								} else if (exception === 'parsererror') {
								} else if (exception === 'timeout') {
								} else if (exception === 'abort') {
								} else {}
						}
				});
			}
		});
	
	$("#buscar_repre_legal").click(function(e) {
		$("#consultarSunatRL").hide();
		var l = Ladda.create(this);
		if ($("#pers_vnumdoc_repleg").valid()) {
			$.ajax({
					url : "validRepreLegal",
					type : "POST",
					data : "numDoc="+ $('#pers_vnumdoc_repleg').val()+"&tipoDoc="+ $('#pers_vdoctype').val(),
					dataType : "json",
					beforeSend : function() {
						l.start();
					},
					success : function(data) {
//						0:no existe el representante legal
//						1:existe el representante legal
						if (data.msg == "0") {
							$("#natu_vname").removeAttr("readonly");
							$("#natu_vlastnamefather").removeAttr("readonly");
							$("#natu_vlastnamemother").removeAttr("readonly");
							$("#mail_vmail_repleg").removeAttr("readonly");
							$("#phon_vphone_repleg").removeAttr("readonly");
							$("#addr_vaddress_repleg").removeAttr("readonly");
							
							$("#natural_vtradename").removeAttr("readonly");
							$('#natural_vpais').attr("disabled", false);
							$('#natural_vlocalidad').attr("disabled", false);
							$('#natural_vtipoPerson').attr("disabled", false);
							
							$("#natu_vname").val("");
							$("#natu_vlastnamefather").val("");
							$("#natu_vlastnamemother").val("");
							$("#mail_vmail_repleg").val("");
							$("#phon_vphone_repleg").val("");
							$("#addr_vaddress_repleg").val("");
							
							$("#natural_vtradename").val("");
							$("#natural_vtipoPerson").val("D");
							$( "#natural_vpais" ).val("").trigger( "change" );
							$( "#natural_vlocalidad" ).val("").trigger( "change" );
							
							obj.persBident=null;
							if(data.rspsunat == "2"){
								bootbox.alert("<label class='text-danger'><br> No existe este ruc en sunat</label>");
							}else if(data.rspsunat == "1"){
								if(data.tipoPerson == "L"){
									bootbox.alert("<label class='text-danger'><br> El numero de ruc pertenece a una persona juridica</label>");
								}else{
									$("#consultarSunatRL").show();
									$("#natu_vname").val(data.nombre);
									$("#natu_vlastnamefather").val(data.apetpat);
									$("#natu_vlastnamemother").val(data.apetmat);
									$("#addr_vaddress_repleg").val(data.direccion);
									$("#natural_vlocalidad").val(data.idubigeo).trigger("change");
									$("#estadoSunatRL").html('<label class="control-label '+data.estadoColor+'" for="natural_vmail">'+data.estadoSunat+'</label>');
									$("#condicionSunatRL").html('<label class="control-label '+data.condicionDomicilioColor+'" for="natural_vmail">'+data.condicionDomicilio+'</label>');
								}
							}
						} else if (data.msg == "1"){
							$("#natu_vname").val(data.nombre);
							$("#natu_vlastnamefather").val(data.aptPaterno);
							$("#natu_vlastnamemother").val(data.aptMaterno);
							$("#mail_vmail_repleg").val(data.email);
							$("#phon_vphone_repleg").val(data.telefono);
							$("#addr_vaddress_repleg").val(data.address);
							
							$("#natural_vtradename").val(data.naturalVtradename);
							$("#natural_vtipoPerson").val(data.naturalVtipoPerson);
							$("#natural_vpais").val(data.naturalVpais).trigger( "change" );
							$("#natural_vlocalidad").val(data.naturalVlocalidad).trigger( "change" );
							
							$("#natu_vname").attr("readonly","readonly");
							$("#natu_vlastnamefather").attr("readonly","readonly");
							$("#natu_vlastnamemother").attr("readonly","readonly");
							$("#mail_vmail_repleg").attr("readonly","readonly");
							$("#phon_vphone_repleg").attr("readonly","readonly");
							$("#addr_vaddress_repleg").attr("readonly","readonly");
							$('#natural_vpais').attr("disabled", true);
							$('#natural_vlocalidad').attr("disabled", true);
							$('#natural_vtipoPerson').attr("disabled", true);
							obj.persBident=data.persBident;
						}
						obj.insertRepreLegal=data.msg;
						l.stop();
					},
					complete : function() {},
					error : function(jqXHR, exception) {
							if (jqXHR.status === 0) {
							} else if (jqXHR.status == 400) {
							} else if (jqXHR.status == 401) {
							} else if (jqXHR.status == 403) {
							} else if (jqXHR.status == 404) {
							} else if (jqXHR.status == 500) {
							} else if (jqXHR.status == 503) {
							} else if (exception === 'parsererror') {
							} else if (exception === 'timeout') {
							} else if (exception === 'abort') {
							} else {}
					}
			});
		}
	});
	
	$('#empr_vdoctype').change(function() {
		var cant = $('#empr_vdoctype option:selected').attr('cantidad');
		$("#pers_vnumdoc").attr("maxlength",cant);
		obj.validarDocumento();
	});
	
	obj.validarDocumento();
	obj.gMethods.setValidatorDefaults();
	$("#frmbussines").validate({
		rules : {
			pers_vnumdoc : {
				numero_documento : $('#empr_vdoctype option:selected').attr('cantidad')
			},
			lega_businame : {
				required : true
			},
			addr_vaddress : {
				required : true
			},
			mail_vmail : {
				required : true,
				email : true
			},
			pers_vnumdoc_repleg : {
				required : true,
				number : true
			},
			natu_vname : {
				required : true
			},
			natu_vlastnamefather : {
				required : true
			},
			natu_lastname2 : {
				required : true
			},
			mail_vmail_repleg : {
				required : true,
				email : true
			},
			phon_vphone_repleg : {
				required : true,
				number : true
			},
			legal_vpais : {
				required : true
			},
			legal_vlocalidad : {
				required : { 
					depends: function (element) {
						return $("#legal_vlocalidad").val()=="348";
					}
				}
			},
			natural_vtipoPerson : {
				required : true
			},
			natural_vpais : {
				required : true
			},
			natural_vlocalidad : {
				required : { 
					depends: function (element) {
						return $("#natural_vpais").val()=="348";
					}
				}
			}

		}
	});

}
EmpresaProccess.prototype.limpiar = function() {
	$("#consultarSunat").hide();
	$("#lega_businame").val("");
	$("#addr_vaddress").val("");
}

EmpresaProccess.prototype.validarDocumento = function() {
	$.validator.addMethod("numero_documento", function (value, element) {
		var maxLengthVal = $(element).attr('maxlength');
		var regularExp = "^\\d{"+maxLengthVal+"}$";
	    return this.optional(element) || new RegExp(regularExp, "ig").test(value);
	}, 'Debe contener '+$('#empr_vdoctype option:selected').attr('cantidad')+ ' dígitos');
}

EmpresaProccess.prototype.crearEmpresa = function(button) {
	var obj = this;
	$.ajax({
				url : "/SistemaFE/empresa/InsertarEmpresa/",
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
EmpresaProccess.prototype.updateEmpresa = function() {
	console.log("click");
	$.ajax({
		url : "/SistemaFE/empresa/ActualizarEmpresa/",
		type : "POST",
		data : $("#frmbussines").serialize(),
		dataType : "json",
		beforeSend : function() {
			// $('#btnProccess').ladda().ladda('start');
		},
		success : function(data) {
			if (data.msg == "ok") {
				// Se añadio para el efecto de aviso que se guardo correctamente
				// Luis S.
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
					location.href = "/SistemaFE/empresa/";
				})

			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");
		}
	});
}



