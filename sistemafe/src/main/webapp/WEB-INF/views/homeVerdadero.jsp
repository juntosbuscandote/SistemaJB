<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>JB</title>
<link rel="shortcut icon" href="resources/img/log1.png">

<!-- Bootstrap -->
<link href="resources/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="resources/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Animate.css -->
<link href="resources/vendors/animate.css/animate.min.css"
	rel="stylesheet">

<script src="resources/vendors/jquery/dist/jquery.min.js"></script>

<!-- Custom Theme Style -->
<link href="resources/build/css/custom.min.css" rel="stylesheet">
<!-- validator -->
<link href="resources/dist/css/cmxform.css" rel="stylesheet">
<link href="resources/dist/css/cmxformTemplate.css" rel="stylesheet">
<!-- 	    <link href="resources/dist/css/core.css" rel="stylesheet"> -->
<link href="resources/dist/css/reset.css" rel="stylesheet">
<!-- 	    <link href="resources/dist/css/screen.css" rel="stylesheet"> -->
<link rel="stylesheet" href="resources/vendors/dist/ladda-themeless.min.css">
</head>
<script type="text/javascript">
	$(document).on('ready', function() {
		var home = new Home();
		home.init();
	});
</script>
<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor" id="signin"></a> 

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content"> <!--<form method="post" action="validLogin3">-->
				<form id="frmLogin" name="frmLogin">
					<!--                         <form method="post" action="home.jsp"> -->
					<h1>Juntos Buscandote</h1>
					<input type="text" class="form-control" placeholder="Usuario"
						name="frmLoginUsuario" id="frmLoginUsuario" required
						value="" /> 
					<input type="password" class="form-control"
						placeholder="Contraseña" name="frmLoginPassword"
						id="frmLoginPassword" required value="" />
					<div class="progress-demo">
						<button class="btn btn-dark ladda-button" data-style="expand-right" type="button" id="btn_ingresar" >
						<span>Ingresar </span>
<!-- 						<div class="ladda-progress"  style="width: 132px;"> </div> -->
					    </button>
						<!-- <a class="reset_pass" href="#">¿Perdiste tu contraseña?</a> -->
					</div>

					<div class="clearfix"></div>

					<div class="separator">
						<!--                                 <p class="change_link">¿Nuevo en el sitio? -->
						<!--                                     <a href="#signup" class="to_register"> Crear una cuenta </a> -->
						<!--                                 </p> -->

						<div class="clearfix"></div>
						<br />

						<div>
							<h1>
								<img src="resources/img/logoFinal.png" width="200" height="100">
							</h1>
							<div align="center">
							<a href="comprobanteelectronico/buscarcpe">Consultar  aquí</a>
							<br><br><br><br>
							</div>
							<p>Cibertec 2019 - Todos los derechos reservados</p>
						</div>
					</div>
				</form>
				</section>
			</div>


			<!--                 <div id="register" class="animate form registration_form"> -->
			<!--                     <section class="login_content" > -->
			<!--                             <h1>Ingrese sus Datos</h1> -->
			<!--                             <div> -->

			<!--                                 <form id="frmClienteFinal" name="frmClienteFinal"> -->

			<!--                                     <br> -->
			<!--                                     <input type="text" class="form-control" id="" name=""  placeholder="Razón Social / Nombres Completos" required="" /> -->
			<!--                                     <input type="text" class="form-control" id="clie_inumdoc" name="clie_inumdoc" placeholder="Ruc" required="" /> -->
			<!--                                     <input type="email"class="form-control" id="clie_vemail" name="clie_vemail" placeholder="Correo Electronico" required="" /> -->
			<!-- 									<input type="text" class="form-control" id="busi_vphone" name="busi_vphone" placeholder="Telefono / Celular" required="" /> -->
			<!--                                     <input type="password"class="form-control" id="clie_vpass" name="clie_vpass" placeholder="Contraseña" required="" /> -->
			<!--                                     <input type="password"class="form-control" id="clie_vrepass" name="clie_vrepass" placeholder="Confirmar Contraseña" required="" /> -->
			<!-- 									<div class="g-recaptcha" data-sitekey="6LcePAATAAAAAGPRWgx90814DTjgt5sXnNbV5WaW"></div> -->

			<!--                                     </form> -->
			<!--                                 </div> -->

			<!--                                 <div> -->
			<!--                                     <button class="btn btn-primary" type="button" id="btnIngresarFact">Registrar</button> -->
			<!--                                     <button class="btn btn-default submit" type="button" id="btn_ingresar" ><a href="#signin" > Registrar </a></button> -->
			<!--                                 </div> -->

			<!--                                 <div class="clearfix"></div> -->
			<!--                                 <div class="separator"> -->
			<!--                                     <p class="change_link">¿Tienes una cuenta? -->
			<!--                                         <a href="#signin" class="to_register"> Iniciar sesión </a> -->
			<!--                                     </p> -->

			<!--                                     <div class="clearfix"></div> -->
			<!--                                     <br /> -->

			<!--                                                                    <div>
<!--                                                                         <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1> -->
			<!--                                                                         <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p> -->
			<!--                                                                     </div>-->
			<!--                                 </div> -->

			<!--                     </section> -->
			<!--                 </div> -->

		</div>
	</div>
	<script src="resources/js/bootbox.min.js"></script>
	<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="resources/js/bootbox.min.js"></script>
	<script src="resources/js/jquery.validate.js"></script>

	<script src="resources/vendors/dist/spin.min.js"></script>
	<script src="resources/vendors/dist/ladda.min.js"></script>
	<script src="resources/vendors/global.js"></script>


	<script src='https://www.google.com/recaptcha/api.js?hl=es'></script>

	<script type="text/javascript" src="resources/v1/HomeController.js"></script>

<script src="resources/vendors/dist/spin.min.js"></script>
<script src="resources/vendors/dist/ladda.min.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			

			/*$("#btnIngresarFact").click(function(e) {

				location.href = "/SistemaFE/facturacionelectronica/"

			});*/
			
			/*$("#btn_ingresar").click(function(e){
                $.ajax({
                url: "validLogin4",
                type: "POST",
                data: "usuario=" + $('#frmLoginUsuario').val() + "&password=" + $('#frmLoginPassword').val(),
                //contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function () {

                },
                success: function (data) {
                    if (data.estado != "ok") {
                            bootbox.alert({
                                size: null,
                                title: null,
                                message: data.msg,
                                onEscape: true,
                                callback: function () {
                                }
                            });
                    }else {
                            //alert("Se guardo correctamente al usuario");
                            //location.href = data.url;
                        }
                },
                complete: function () {
                    //laddaButton.stop();
                    //laddaButton.remove();
                    //btn_buscar_persona.ladda('stop');
                },
                error: function (jqXHR, exception) {
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
              });*/

		});
	</script>


</body>
</html>


