function PersonaController() {
	this.gMethods = system.globalMethods;
	this.process="";//I:insertar M:modificar 
	
	$("#fecCisto").daterangepicker({
		 singleDatePicker : !0,		 
		 timePicker: true,
	     timePicker24Hour: true,
	     timePickerSeconds: true,
	     startDate:moment().startOf('minutes'),
		maxDate: new Date(),
		locale: {
//			format :'DD-MM-YYYY',
			format :'DD-MM-YYYY,HH:mm:ss',
//			
	          "daysOfWeek": [
	              "Do",
	              "Lu",
	              "Ma",
	              "Mi",
	              "Ju",
	              "Vi",
	              "Sá"
	          ],
	          "monthNames": [
	              "Enero",
	              "Febrero",
	              "Marzo",
	              "Abril",
	              "Mayo",
	              "Junio",
	              "Julio",
	              "Agosto",
	              "Septiembre",
	              "Octubre",
	              "Noviembre",
	              "Diciembre"
	          ]
	        },
		singleClasses : "picker_4"
	}, function(a, b, c) {
	console.log(a.toISOString(), b.toISOString(), c)
	});
}

PersonaController.prototype.init = function() {
	this.handler();
}

PersonaController.prototype.handler = function() {
	var obj = this;
	obj.gMethods.setAutocompletado();
	obj.gMethods.setValidatorDefaults();
	obj.gMethods.setSoloNumero();
	
	$("#personLegal").hide();
	$("#pers_vdoctype").attr("disabled", false);
	$('#pers_vdoctype').val("7");
	var cant = $('#pers_vdoctype option:selected').attr('cantidad');
	$("#pers_vnumdoc").attr("maxlength",cant);
	$("#natural_vtipoPerson").val("D");

		
	// modificar
	if($("#proccess").val()=="modif"){
		obj.process="M";
		$("#btnValidNum").attr("disabled", true);
		$("#pers_vdoctype").attr("disabled", true);
		$("#pers_vnumdoc").attr("disabled", true);
		$("#frmTipoPersonNatural").attr("disabled", true);
		$("#frmTipoPersonLegal").attr("disabled", true);
		if($("#tipoPerson").val()=="N"){
			$( "#frmTipoPersonNatural" ).prop( "checked", true );
			$("#personNatural").show();
        	$("#personLegal").hide();
			$("#natural_vpais" ).val($("#idpais").val()).trigger( "change" );
			$("#natural_vlocalidad" ).val($("#idubigeo").val()).trigger( "change" );
			$("#natural_vtipoPerson").val($("#domiciled").val());
			obj.habilitarNatural(2);
		}else if($("#tipoPerson").val()=="L"){
			$( "#frmTipoPersonLegal" ).prop( "checked", true );
			$("#personNatural").hide();
        	$("#personLegal").show();
			$("#legal_vpais" ).val($("#idpais").val()).trigger( "change" );
			$("#legal_vlocalidad" ).val($("#idubigeo").val()).trigger( "change" );
			$("#legal_vtipoPerson").val($("#domiciled").val());
			obj.habilitarLegal("2");
		}
		$("#pers_vdoctype").val($("#idtipodoc").val());
	}
	
	$('input[type=radio][name=frmTipoPerson]').change(function() {
		obj.limpiartxt();
	        if ($('input[name=frmTipoPerson]:checked').val() == 1) {
	        	$("#personNatural").show();
	        	$("#personLegal").hide();
	        	$("#pers_vdoctype").val("1");
	        	$("#pers_vdoctype").attr("disabled", false);
	        	obj.deshabilitarNatural();
	        	obj.deshabilitarLegal();
	        	$("#natural_vtipoPerson").val("D");
	        	$('#pers_vdoctype').children('option[value="1"]').show();
	        }else if ($('input[name=frmTipoPerson]:checked').val() == 2) {
	        	$("#personNatural").hide();
	        	$("#personLegal").show();
	        	$("#pers_vdoctype").val("6");
	        	$("#pers_vdoctype").attr("disabled",false);
	        	obj.deshabilitarNatural();
	        	obj.deshabilitarLegal();
	        	$("#legal_vtipoPerson").val("D");
	        	$('#pers_vdoctype').children('option[value="1"]').hide();
	        	
	        }
	        $('#pers_vdoctype').trigger('change');
	});
	
	$('#pers_vdoctype').change(function() {
		var cant = $('#pers_vdoctype option:selected').attr('cantidad');
		$("#pers_vnumdoc").attr("maxlength",cant);
		obj.validarDocumento();
	});
	
	$('#pers_vnumdoc').change(function() {
		obj.limpiartxt();
		obj.deshabilitarNatural();
    	obj.deshabilitarLegal();
	});
	
	obj.validarDocumento();
	
	$("#frmDocumento").validate({
		rules : {
			pers_vdoctype : {
				required : true,
			},
			pers_vnumdoc : {
				numero_documento : $('#pers_vdoctype option:selected').attr('cantidad')
			}
		}
	});
	
	
	
	$("#frmNaturalPersona").validate({
		rules : {
			natural_vname : {
				required : true,
				maxlength: 50
			},
			natural_vlastnamefather : {
				required : true,
				maxlength: 50
			},
			natural_vlastnamemother : {
				required : true,
				maxlength: 50
			},
			natural_vtipoPerson : {
				required : true
			},
			natural_vmail : {
				required : true,
				email : true,
				maxlength: 50
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
			},
			natural_vaddress : {
				required : true,
				maxlength: 250
			}
		}
	});
	
	$("#frmLegalPersona").validate({
		rules : {
			legal_vbusiname : {
				required : true,
				maxlength: 500
			},
			legal_vpais : {
				required : true
			},
			legal_vlocalidad : {
				required : { 
					depends: function (element) {
						return $("#natural_vpais").val()=="348";
					}
				}
			},
			legal_vmail : {
				required : true,
				email : true,
				maxlength: 50
			},
			legal_vaddress : {
				required : true,
				maxlength: 250
			},
			legal_vtipoPerson : {
				required : true
			}
		}
	});
//	 function clearThis(target){
//	        if(target.value=='exemplo@exemplo.com'){
//	        target.value= "";}
//	    }
	
	$("#btnValidNum").click(function() {
		if($("#frmDocumento").valid()){
			var l = Ladda.create(this);
			var tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
			$.ajax({
				url : "/SistemaFE/persona/validaPersona/",
				type : "POST",
				data : {"tipdoc":$("#pers_vdoctype").val(),"numerodoc":$("#pers_vnumdoc").val(),"tipoperson":tipoPerson},
				dataType : "json",
				beforeSend : function() {
					l.start();
				},
				success : function(data) {
					if (data.msg == "ok") {
						if(data.msgresp=="1"){
							if(tipoPerson!=data.tipoPerson){
								if(data.tipoPerson=="N"){
	                        		$("#frmTipoPersonNatural").prop("checked", true);
	                        	}else if(data.tipoPerson=="L"){
	                        		$("#frmTipoPersonLegal").prop("checked", true);
	                        	}
	                        	$('input[type=radio][name=frmTipoPerson]').trigger('change');
	                        	tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
							}
							obj.process="M";
							if(data.tipoPerson=="N"){
								obj.deshabilitarNatural();
								obj.habilitarNatural("2");
								$("#pers_vdoctype").val(data.idtipodoc);
								$("#natural_vname").val(data.nombre);
								$("#natural_vlastnamefather").val(data.apetpat);
								$("#natural_vlastnamemother").val(data.apetmat);
								$("#natural_vmail").val(data.email);
								$("#natural_vphone").val(data.telefono);
								$("#natural_vaddress").val(data.direccion);
								$("#natural_vpais" ).val(data.idpais).trigger( "change" );
								$("#natural_vlocalidad" ).val(data.idubigeo).trigger( "change" );
								$("#natural_vtipoPerson").val(data.domiciled);
								$("#natural_vtradename").val(data.nombreComercial);
							}else if(data.tipoPerson=="L"){
								obj.deshabilitarLegal();
								obj.habilitarLegal("2");
								$("#legal_vbusiname").val(data.razonSocial);
								$("#legal_vtradename").val(data.nombreComercial);
								$("#legal_vphone").val(data.telefono);
								$("#legal_vaddress").val(data.direccion);
								$("#legal_vmail").val(data.email);	
								$("#legal_vpais" ).val(data.idpais).trigger( "change" );
								$("#legal_vlocalidad" ).val(data.idubigeo).trigger( "change" );
								$("#legal_vtipoPerson").val(data.domiciled);
							}
							$('#pers_vdoctype').trigger('change');
							// $('#btnValidNum').trigger('click');
						}else if(data.msgresp=="2" && data.msgrespr!=null){
							obj.process="I";
							bootbox.alert("<label class='text- primary'>CONSULTA CON EXITO : <br> se consulto en RENIEC</label>");
							$("#natural_vname").val(data.nombre);
							$("#natural_vlastnamefather").val(data.apetpat);
							$("#natural_vlastnamemother").val(data.apetmat);
							$("#consultarrENIEC").show
							$("#estadoSunat").html('<label class="control-label '+data.estadoColor+'" for="natural_vmail">'+data.estado+'</label>');
							$("#condicionSunat").html('<label class="control-label '+data.condicionDomicilioColor+'" for="natural_vmail">'+data.condicionDomicilio+'</label>');
//							obj.limpiartxt();
							if(tipoPerson=='N'){
								obj.habilitarNatural(1);
							}else if(tipoPerson=='L'){
								obj.habilitarLegal(1);
							}
							$("#natural_vpais" ).val('348').trigger( "change" );
							$("#legal_vpais" ).val('348').trigger( "change" );
						}else if(data.msgresp=="2"){
							obj.process="I";
							bootbox.alert("<label class='text-warning'>ADVERTENCIA : <br> No se encontro persona</label>");
//							obj.limpiartxt();
							if(tipoPerson=='N'){
								obj.habilitarNatural(1);
							}else if(tipoPerson=='L'){
								obj.habilitarLegal(1);
							}
							$("#natural_vpais" ).val('348').trigger( "change" );
							$("#legal_vpais" ).val('348').trigger( "change" );
						}else if(data.msgresp=="3"){
							obj.limpiartxt();
							if(tipoPerson!=data.tipoPerson){
								if(data.tipoPerson=="N"){
	                        		$("#frmTipoPersonNatural").prop("checked", true);
	                        	}else if(data.tipoPerson=="L"){
	                        		$("#frmTipoPersonLegal").prop("checked", true);
	                        	}
	                        	$('input[type=radio][name=frmTipoPerson]').trigger('change');
	                        	tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
							}
							if(data.tipoPerson=="N"){
								$("#natural_vname").val(data.nombre);
								$("#natural_vlastnamefather").val(data.apetpat);
								$("#natural_vlastnamemother").val(data.apetmat);
								$("#natural_vaddress").val(data.direccion);
								$("#natural_vlocalidad" ).val(data.idubigeo).trigger( "change" );
							}else if(data.tipoPerson=="L"){
								$("#legal_vbusiname").val(data.razonSocial);
								$("#legal_vaddress").val(data.direccion);
								$("#legal_vlocalidad" ).val(data.idubigeo).trigger( "change" );
							}
							$("#estadoSunat").html('<label class="control-label '+data.estadoColor+'" for="natural_vmail">'+data.estado+'</label>');
							$("#condicionSunat").html('<label class="control-label '+data.condicionDomicilioColor+'" for="natural_vmail">'+data.condicionDomicilio+'</label>');
							obj.process="I";
							if(tipoPerson=='N'){
								obj.habilitarNatural(1);
							}else if(tipoPerson=='L'){
								obj.habilitarLegal(1);
							}
							$("#consultarSunat").show();
							$("#pers_vdoctype").val("6");
							$('#pers_vdoctype').trigger('change');
							$("#natural_vpais" ).val('348').trigger( "change" );
							$("#legal_vpais" ).val('348').trigger( "change" );
						}else if(data.msgresp=="4"){
							obj.limpiartxt();
							if(tipoPerson!=data.tipoPerson){
								if(data.tipoPerson=="N"){
	                        		$("#frmTipoPersonNatural").prop("checked", true);
	                        	}
	                        	$('input[type=radio][name=frmTipoPerson]').trigger('change');
	                        	tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
							}
							if(data.tipoPerson=="N"){
								$("#natural_vname").val(data.nombre);
								$("#natural_vlastnamefather").val(data.apetpat);
								$("#natural_vlastnamemother").val(data.apetmat);
								$("#natural_vaddress").val(data.direccion);
								$("#natural_vlocalidad" ).val(data.idubigeo).trigger( "change" );
							}
							$("#estadoSunat").html('<label class="control-label '+data.estadoColor+'" for="natural_vmail">'+data.estado+'</label>');
							$("#condicionSunat").html('<label class="control-label '+data.condicionDomicilioColor+'" for="natural_vmail">'+data.condicionDomicilio+'</label>');
							obj.process="I";
							if(tipoPerson=='N'){
								obj.habilitarNatural(1);
							}
							$("#consultarSunat").show();
							$("#pers_vdoctype").val("1");
							$('#pers_vdoctype').trigger('change');
							$("#natural_vpais" ).val('348').trigger( "change" );
							$("#legal_vpais" ).val('348').trigger( "change" );
						}
						l.stop();
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
	
}

PersonaController.prototype.habilitarNatural = function(tipo) {
	if(tipo=="1"){
		$("#natural_vname").attr("readonly", false);
		$("#natural_vlastnamefather").attr("readonly", false);
		$("#natural_vlastnamemother").attr("readonly", false);
		$("#natural_vmail").attr("readonly", false);
		$("#natural_vphone").attr("readonly", false);
		$("#natural_vaddress").attr("readonly", false);
		$("#natural_vpais").attr("disabled", false);
		$("#natural_vlocalidad").attr("disabled", false);
		$("#natural_vtipoPerson").attr("disabled", false);
		$("#natural_vtradename").attr("readonly", false);
		$("#foto").attr("readonly", false);
		$("#situacPers").attr("readonly", false);
		$("#fecCisto").attr("readonly", false);
		$("#edad").attr("readonly", false);
		$("#sexo").attr("readonly", false);
	}else if(tipo=="2"){
		$("#pers_vdoctype").attr("disabled", true);
		$("#natural_vmail").attr("readonly", false);
		$("#natural_vphone").attr("readonly", false);
		$("#natural_vaddress").attr("readonly", false);
		$("#natural_vpais").attr("disabled", false);
		$("#natural_vlocalidad").attr("disabled", false);
	}
}

PersonaController.prototype.deshabilitarNatural = function() {
	$("#natural_vname").attr("readonly", true);
	$("#natural_vlastnamefather").attr("readonly", true);
	$("#natural_vlastnamemother").attr("readonly", true);
	$("#natural_vmail").attr("readonly", true);
	$("#natural_vphone").attr("readonly", true);
	$("#natural_vaddress").attr("readonly", true);
	$("#natural_vpais").attr("disabled", true);
	$("#natural_vlocalidad").attr("disabled", true);
	$("#natural_vtipoPerson").attr("disabled", true);
	$("#natural_vtradename").attr("readonly", true);
}

PersonaController.prototype.habilitarLegal = function(tipo) {
	if(tipo=="1"){
		$("#legal_vbusiname").attr("readonly", false);
		$("#legal_vtradename").attr("readonly", false);
		$("#legal_vphone").attr("readonly", false);
		$("#legal_vaddress").attr("readonly", false);
		$("#legal_vmail").attr("readonly", false);
		$("#legal_vpais").attr("disabled", false);
		$("#legal_vlocalidad").attr("disabled", false);
		$("#legal_vtipoPerson").attr("disabled", false);
	}else if(tipo=="2"){
		$("#legal_vphone").attr("readonly", false);
		$("#legal_vaddress").attr("readonly", false);
		$("#legal_vmail").attr("readonly", false);
		$("#legal_vpais").attr("disabled", false);
		$("#legal_vlocalidad").attr("disabled", false);
	}
}

PersonaController.prototype.deshabilitarLegal = function() {
	$("#legal_vbusiname").attr("readonly", true);
	$("#legal_vtradename").attr("readonly", true);
	$("#legal_vphone").attr("readonly", true);
	$("#legal_vaddress").attr("readonly", true);
	$("#legal_vmail").attr("readonly", true);
	$("#legal_vpais").attr("disabled", true);
	$("#legal_vlocalidad").attr("disabled", true);
	$("#legal_vtipoPerson").attr("disabled", true);
}

PersonaController.prototype.limpiartxt=function(){
	$("#consultarSunat").hide();
	// natural
	$("#natural_vname").val("");
	$("#natural_vlastnamefather").val("");
	$("#natural_vlastnamemother").val("");
	$("#natural_vmail").val("");
	$("#natural_vphone").val("");
	$("#natural_vaddress").val("");
	$( "#natural_vpais" ).val("").trigger( "change" );
	$( "#natural_vlocalidad" ).val("").trigger( "change" );
	$( "#natural_vtradename" ).val("");
	$( "#natural_vtipoPerson" ).val("D");
	// legal
	$("#legal_vbusiname").val("");
	$("#legal_vtradename").val("");
	$("#legal_vphone").val("");
	$("#legal_vaddress").val("");
	$("#legal_vmail").val("");	
	$( "#legal_vpais" ).val("").trigger( "change" );
	$( "#legal_vlocalidad" ).val("").trigger( "change" );
	$( "#legal_vtipoPerson" ).val("D");
}

PersonaController.prototype.validarDocumento = function() {
	$.validator.addMethod("numero_documento", function (value, element) {
		var maxLengthVal = $(element).attr('maxlength');
		var regularExp = "^\\d{"+maxLengthVal+"}$";
	    return this.optional(element) || new RegExp(regularExp, "ig").test(value);
	}, 'Debe contener '+$('#pers_vdoctype option:selected').attr('cantidad')+ ' dígitos');
}

PersonaController.prototype.validarPersona = function() {
	var tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
	if(tipoPerson=='N'){
		return $("#frmNaturalPersona").valid();
	}else if(tipoPerson=='L'){
		return $("#frmLegalPersona").valid();
	}
}

PersonaController.prototype.crearPersona = function(objeto) {
	var obj = this;
	var tipoPerson=$('input[name=frmTipoPerson]:checked').val() == 1?"N":"L";
	var dataPersona;
	if(tipoPerson=='N'){
		dataPersona={
				"tipoDoc":$("#pers_vdoctype").val(),
				"numdoc":$("#pers_vnumdoc").val(),
				"nombre":$("#natural_vname").val(),
				"apetpat":$("#natural_vlastnamefather").val(),
				"apetMat":$("#natural_vlastnamemother").val(),
				"email":$("#natural_vmail").val(),
				"telefono":$("#natural_vphone").val(),
				"idpais":$("#natural_vpais").val(),
				"idlocalidad":$("#natural_vlocalidad").val(),
				"direccion":$("#natural_vaddress").val(),
				"razonsocial":"",
				"nombrecomercial":$("#natural_vtradename").val(),
				"tipoPerson":"N",
				"proceso":obj.process,
				"domiciled":$("#natural_vtipoPerson").val()
				}
	}else if(tipoPerson=='L'){
		dataPersona={
				"tipoDoc":$("#pers_vdoctype").val(),
				"numdoc":$("#pers_vnumdoc").val(),
				"nombre":"",
				"apetpat":"",
				"apetMat":"",
				"email":$("#legal_vmail").val(),
				"telefono":$("#legal_vphone").val(),
				"idpais":$("#legal_vpais").val(),
				"idlocalidad":$("#legal_vlocalidad").val(),
				"direccion":$("#legal_vaddress").val(),
				"razonsocial":$("#legal_vbusiname").val(),
				"nombrecomercial":$("#legal_vtradename").val(),
				"tipoPerson":"L",
				"proceso":obj.process,
				"domiciled":$("#legal_vtipoPerson").val()
				}
		
	}
	
	$.ajax({
		url : "/SistemaFE/persona/administrarPersona/",
		type : "POST",
		data : dataPersona,
		dataType : "json",
		beforeSend : function() {
		},
		success : function(data) {
			if (data.msg == "ok") {
				objeto.procesar(data.info);
			}else{
				bootbox.alert("<label class='text-danger'>ERROR : <br> Se produjo un error interno en los servicios</label>");
			}
		},
		error : function(xhr, statusText, errorThrown) {
			console.log("ocurrio un error");  
		}
	});
}
