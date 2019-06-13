function Home() {
}

Home.prototype.init = function() {
 
	this.handler();
}

Home.prototype.handler = function() {
	var obj = this;
	$("#frmLogin").validate({
		rules : {
			
			listaEmpresa : {
				required : true,
				number : true,
				minlength : 11

			},
			frmLoginUsuario : {
				required : true

			},
			frmLoginPassword : {
				required : true

			}
		},
		messages : {
			listaEmpresa : {
				required : "Campo Requerido",
				number : "solo n&uacute;meros",
				minlength : "m&iacute;nimo 11 car&aacute;cteres"

			},
			frmLoginUsuario : {
				required : "Campo Requerido"

			},
			frmLoginPassword : {
				required : "Campo Requerido"

			}
		}
	});
	
	$("#frmEnviarPass").validate({
		rules : {

			frmMailUser : {
				required : true
			}
		},
		messages : {
			frmMailUser : {
				required : "Campo Requerido"
			}
		}
	});

	//	Ladda.bind('button[id=btn_ingresar]');
	$("#btn_ingresar").click(
			function(e) {
				if ($("#frmLogin").valid()) {
				var l = Ladda.create(this);
				var empresa =  $('#listaEmpresa').val();
				var empresa2 =  $('#empresa').val();
				if (empresa == null || empresa == ''){
					empresas = empresa2
				}else{
					empresas = empresa
				}
				l.start();
				$.ajax({
					url : "validLogin4",
					type : "POST",
					data : "usuario=" + $('#frmLoginUsuario').val()
							+ "&password=" + $('#frmLoginPassword').val()
							+ "&empresa=" + empresas ,
					//contentType: "application/json; charset=utf-8",
					dataType : "json",
					beforeSend : function() {
						//Ladda.create(this).start();

					},
					success : function(data) {
						if (data.estado != "ok") {
							bootbox.alert({
								size : null,
								title : null,
								message : data.msg,
								onEscape : true,
								callback : function() {
									l.stop();
								}
							});
							//            	Ladda.bind('button[id=btn_ingresar]').stop();
						} else {
							//            	Ladda.bind('button[id=btn_ingresar]');
							//$('#btn_ingresar').ladda().ladda('start');
							//alert("Se guardo correctamente al usuario");
							location.href = data.url;
							//                    Ladda.bind('button[id=btn_ingresar]');
						}
					},
					complete : function() {
						//laddaButton.stop();
						//laddaButton.remove();
						//btn_buscar_persona.ladda('stop');
					},
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
						} else {
						}
					}
				});
				}
			});
	
	
	$("#btn_consultar").click(
			function(e) {
			location.href = "comprobanteelectronico/buscarcpe";
    });
	
	var empresa =  $('#listaEmpresa').val();
	var empresa2 =  $('#empresa').val();
	if (empresa == empresa2 || empresa2 == ''){
		$('#listaEmpre').show();
	}else if(empresa == null ){
		$('#listaEmpre').hide();
	}else{
		$('#listaEmpre').show();
	}
	
	$("#enviarCorreoPass").click(
			function(e) {

				var l = Ladda.create(this);
				l.start();
				$.ajax({
					url : "/SistemaFE/enviarcorreopasswordNew",
					type : "GET",
					data : {
						"correo_user":$('#frmMailUser').val()
						},
					dataType : "json",
					beforeSend : function() {

					},
					success : function(data) {
						if (data.cod == "1") {
							bootbox.alert("Mensaje enviado al correo, Tiene 24 horas de vigencia del correo");
							l.stop();
							$("#frmMailUser").val("");
						}else{
							bootbox.alert("Ocurrio un error, verificar usuario");
							l.stop();
						}
					},
					error : function(xhr, statusText, errorThrown) {
						console.log("ocurrio un error");  
					}
				});
			});
	$("#btn_CambioPass").click(
			function(e) {
	if ($('#frmPass').val() != $('#frmRePass').val()) {
        bootbox.alert("Las contrase&ntilde;as ingresadas no coinciden", function () {	
        	$("#frmPass").val("");
        	$("#frmRePass").val("");
        	return;
        }); 
	}
	else {
				var l = Ladda.create(this);
				l.start();
				$.ajax({
					url : "/SistemaFE/ActualizarPass",
					type : "POST",
					data : { 
						"iduser":$('#iduser').val(),"user_vpassword":$('#frmPass').val()
						},
					dataType : "json",
					beforeSend : function() {
					    		},
					    		success : function(data) {
					    			if (data.msg == "ok") {
					    				bootbox.confirm("<label class='text-danger'>Se modifico correctamente</label>",function(res){
				                			if (res) {
				                				location.href = "/SistemaFE/";
				                			}
				                			
				                		});
					    			}
					    		},
					    		error : function(xhr, statusText, errorThrown) {
					    			console.log("ocurrio un error");  
					    		}
					    	});
       
	} });
}
