<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<link href="../resources/vendors/sweetalert/sweet-alert.css"> 
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/cmxform.css" rel="stylesheet">
<link href="../resources/dist/css/cmxformTemplate.css" rel="stylesheet">
<link href="../resources/dist/css/reset.css" rel="stylesheet">
<!-- <link href="../resources/dist/css/screen.css" rel="stylesheet"> -->
<link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css" />
<%@include file="../Global/header.jsp"%>
  
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Usuario</h3>
						</div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row" id="modalCrearEmpresa">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Configuracion Usuario<small></small>
									</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
<!-- 									<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist"> -->
<!-- 										<li role="presentation" class="active"><a href="#tab_content" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Empresa</a></li> -->
<!-- 										<li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Usuario</a></li> -->
<!-- 									</ul> -->
<!-- 									<div id="myTabContent" class="tab-content"> -->
<!-- 										<div role="tabpanel" class="tab-pane fade active in" id="tab_content" aria-labelledby="home-tab"> -->
										<input type="hidden"  id="fProcess" value="${fProcess}" />
<%-- 											<%@include file="../../template/Empresa/ConfiguracionEmpresa.jsp"%> --%>
<!-- 										</div> -->
<!-- 										<div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab"> -->
<!-- 											<br/> -->

											<%@include file="../../template/Usuario/ConfiguracionPassword.jsp"%>
											
											
<!-- 											<br/> -->
<!-- 										</div> -->
										<div>
											<button class="btn btn-primary btnconf ladda-button"   type="button" id="btnRegUser" data-style="expand-right">Guardar</button>
<!-- 											<button class="btn btn-primary btnconf editar ladda-button"  type="button" id="btnModf" data-style="expand-right">Modificar</button> -->
											<button type="button" class="btn btn-danger" id="btnSalir" name="btnSalir">Salir</button>
										</div>
<!-- 									</div> -->
								</div>
								
							</div>
						</div>
					</div>
					<!-- /page content -->
					<!-- footer content -->
				</div>
				</div>
				<footer>
					<div class="pull-right">
						Juntos Buscandote 2019 - Todos los derechos reservados
					</div>
					<div class="clearfix"></div>
				</footer>
				<!-- /footer content -->
			
		</div>
	</div>
	<%@include file="../Global/footer.jsp"%>
    <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <script src="../resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="../resources/v1/UsuarioController.js"></script>
<%--<%@include file="../Global/ubigeo.jsp"%>--%>
	

<script type="text/javascript">
			$(document).on('ready', function() {
				var usuario = new UsuariosValidaruc();
				usuario.init();
			});
		</script>    
		
<script type="text/javascript">
			$(document).on('ready', function() {
				var usuarios = new UsuariosCrud();
				usuarios.init();
			});
		</script>

</body>
</html>