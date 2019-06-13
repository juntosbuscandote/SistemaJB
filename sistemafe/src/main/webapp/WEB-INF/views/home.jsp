<%@page session="true"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	<link rel="shortcut icon" href="resources/img/iconJB_1.jpg">
	<title>Juntos_Buscandote</title>													



<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/img/favicon.svg"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendors/bootstrap/dist/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendors/font-awesome/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendors/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/vendors/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->

<!-- NProgress -->  
<link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendors/animate.css/animate.css">
<link rel="stylesheet" type="text/css" href="resources/vendors/css/util.css">
<link rel="stylesheet" type="text/css" href="resources/vendors/css/main.css">
<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="resources/build/css/custom.min.css" rel="stylesheet">
<link href="resources/dist/css/cmxform.css" rel="stylesheet">
<link href="resources/dist/css/cmxformTemplate.css" rel="stylesheet">
<link href="resources/dist/css/reset.css" rel="stylesheet">
<link rel="stylesheet" href="resources/vendors/dist/ladda-themeless.min.css">
<!--===============================================================================================-->
</head>
<script type="text/javascript">
	$(document).on('ready', function() {
		var home = new Home();
		home.init();
	});
</script>
<STYLE type="text/css">
                img {
    max-width: 100%;
    height: auto;
    width: auto; /* Bug de ie8 */
                }
</STYLE>
<body class="login">
	<img>
	<div class="limiter">
<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor" id="signin"></a> 
		<div class="container-login100">
			<div class="wrap-login100">
			<div class="login100-more" >
			
			<img   src="resources/img/log1.jpg">
			
			</div>
				<form class="login100-form validate-form" id="frmLogin" name="frmLogin">
			<!-- <img class="w-full p-b-34" src="resources/img/logo_JB.png"> -->
					<img class="w-full p-b-34" >
					
					<span class="login100-form-title p-b-34">
					Juntos Buscandote
					</span>   
<!-- 					<div id="listaEmpre" class="container-login100-form-btn progress-demo" > -->
<!-- 						<label class="login10-form-title">Empresas:</label>  -->
<!-- 						<select style="width: 100%" class="form-control filter-single inputConData " -->
<!-- 							id="listaEmpresa" name="listaEmpresa"> -->
<!-- <!-- 							<option value="">seleccione una opción</option> --> 
<%-- 							<c:forEach items="${empresasprueba}" var="empresasprueba"> --%>
<%-- 								<option value="${empresasprueba}" attr_empresa="${empresasprueba}">${empresasprueba}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<!-- 					</div> -->
					
					<br><br><br><br><br>
					
					<input  type="hidden" id="empresa" value="<c:out value='${empresa}' />" style="width: 10px; "/>
					<div class=" rs1-wrap-input100 validate-input m-b-20" data-validate="Escribir usuario">
						<input id="frmLoginUsuario" class="input100" type="text" name="frmLoginUsuario" placeholder="Usuario" value="" />
						<span class="focus-input100"></span>
					</div>
					
					
					<div class=" rs2-wrap-input100 validate-input m-b-20" data-validate="Escribir contraseña">
						<input class="input100" type="password" placeholder="Contraseña" name="frmLoginPassword" id="frmLoginPassword"  value=""/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn progress-demo" >
						<button class="login100-form-btn ladda-button"  data-style="expand-right" type="button" id="btn_ingresar" >
							Ingresar
					    </button>
					    <button class="login100-form-btn ladda-button"  data-style="expand-left" type="button" id="btn_consultar" >
							Consultar Persona
					    </button>
					</div>					
			
			<div class="w-full text-center p-t-27 p-b-40">
				 <ul class="sub-menu">
					<li id="menu-item-1230" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1230">
		                <a target="_blank" href="/SistemaFE/resources/1.manual%20de%20acceso[640]/manual%20de%20acceso.pdf"><span class="txt1">VER MANUAL</span></a>
		                <br><br>
		               
		                
		                <a id="OlvidePass" name="OlvidePass" href="/SistemaFE/enviarpass" ><span class="txt1">¿Olvidaste Contraseña? </span></a>
		                <br><br>
		                 <a href="/SistemaFE/crearusuario/" ><button class="login100-form-btn ladda-button"  data-style="expand-left" type="button" id="btn_registrar" >
							Registrarse
					    </button></a>
					    <br>
		                <a><span class="txt1">Contáctenos: </span><span class="txt2">juntosbuscandote@gmail.com</span></a><br>
		                <a><span class="txt1">Central Telefónica: </span><span class="txt2">01 5050-2020</span></a><br>
		                <a><span class="txt1">Sitio Web: </span></a><a target="_blank" href="#"><span class="txt2">www.juntosbuscandote.net</span></a>
	                </li>
	              </ul>
              </div>

					<div align="center">
<!-- 							 <h1><a  class="txt1" href="comprobanteelectronico/buscarcpe">Consultar Comprobante Electrónico aquí</a></h1> -->
							<br><br><br><br>
					</div>


					<br>
					<div class="w-full text-center">
					  <a class="txt2">
							Cibertec 2019 - Todos los derechos reservados
					  </a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	

	<div id="dropDownSelect1"></div>
<!--===============================================================================================-->
	<script src="resources/vendors/moment/moment.min.js"></script>
	<script src="resources/js/bootbox.min.js"></script>
	<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="resources/js/bootbox.min.js"></script>
	<script src="resources/js/jquery.validate.js"></script>

	<script src="resources/vendors/dist/spin.min.js"></script>
	<script src="resources/vendors/dist/ladda.min.js"></script>
	<script src="resources/vendors/global.js"></script>


	<script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
	<script type="text/javascript" src="resources/v1/HomeController.js"></script>
</body>
</html>

