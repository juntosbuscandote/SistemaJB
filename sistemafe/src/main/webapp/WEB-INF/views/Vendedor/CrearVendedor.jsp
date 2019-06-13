<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<!--   <link rel="stylesheet" href="css/gh-pages.css"> -->

<%@include file="../Global/header.jsp"%>
<style>
.custom-combobox {
	position: relative;
	display: inline-block;
}

.custom-combobox-toggle {
	position: absolute;
	top: 0;
	bottom: 0;
	margin-left: -1px;
	padding: 0;
}

.custom-combobox-input {
	margin: 0;
	padding: 5px 10px;
}
</style>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left"></div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">
									<!-- Modal -->
									<!--cambiar el modal segun la pantalla de la aplicacion anteior-->
									<input type="hidden" id="fProcessVendedor" value="${fProcessVendedor}" />
									<%@include file="../../template/Persona/ConfiguracionPersona.jsp"%>
									<div class="x_panel">
										<div class="x_title">
											<h4>Asociar a empresa</h4>
										</div>
										<div id="datoEmpresa"class="col-lg-10 col-md-10  col-lg-offset-1">
											<input type="hidden" id="idEmpr"   value="${idEmpr}"   />
											<form id="frmEmpresa" name="frmEmpresa">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
														<label class="control-label" for="emp_empresa">Empresa:</label>
														<select class="form-control select2-enabled section2" name="emp_empresa" id="emp_empresa" disabled>
															<option></option>
															<c:forEach items="${lstTBussines}" var="lstTBussines">
																<option value="${lstTBussines.busibident}">${lstTBussines.legaBusiname}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</form>
										</div>
									</div>
									<!--BOTONES -->
									<div class="ln_solid"></div>
									<div class="progress-demo">
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProccessVendedor">
											<span>Guardar</span>
										</button>
										<button type="button" class="btn btn-success" id="btnSalirVendedor" name="btnSalirVendedor">Salir</button>
									</div>
									<!--BOTONES -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
		</div>
	</div>
	<%@include file="../Global/footer.jsp"%>
	<script src="<c:url value='../resources/v1/VendedorController.js'/>" type="text/javascript"></script>
	<script src="<c:url value='../resources/v1/PersonaController.js'/>" type="text/javascript"></script>
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script src="../resources/js/util/global.js"></script>

	<script type="text/javascript">
			$(document).on('ready', function() {
				var personaController = new PersonaController();
				personaController.init();
				var vendedorproccess = new VendedorProccess();
				vendedorproccess.objPerson=personaController;
				vendedorproccess.init();
			});
	</script>
	<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
	<script src="../resources/vendors/select2/docs/vendor/js/bootstrap.min.js"></script>
	<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
</body>
</html>