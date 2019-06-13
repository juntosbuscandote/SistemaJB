<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<link href="../resources/vendors/sweetalert/sweet-alert.css">
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/cmxform.css" rel="stylesheet">
<link href="../resources/dist/css/cmxformTemplate.css" rel="stylesheet">
<link href="../resources/dist/css/reset.css" rel="stylesheet">
<link rel="stylesheet"
	href="../resources/vendors/dist/ladda-themeless.min.css">
<!-- <link href="../resources/style.css" rel="stylesheet"> -->

<STYLE type="text/css">
.error {
	display: block;
	margin-top: 5px;
	margin-bottom: 10px;
	color: #d33535;
}
</STYLE>

<%@include file="../Global/header.jsp"%>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row" id="modalCrearEmpresa">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Configuracion</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content"><input type="hidden"
										id="fProcess" value="${fProcess}" />
									<%@include file="../../template/Accesos/confGrupoCom.jsp"%>
									<div class="progress-demo">
										<button class="btn btn-primary ladda-button"
											data-style="expand-right" type="button" id="btnProccess">
											<span>Guardar</span>
										</button>
										<button type="button" class="btn btn-success" id="btnSalir"
											name="btnSalir">Salir</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /page content -->
				</div>
			</div>
		</div>
	</div>

	<%@include file="../Global/footer.jsp"%>
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="../resources/v1/GrupoComercialController.js"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			var grupoComercial = new GrupoComercial();
			grupoComercial.init();
		});
	</script>
</body>
</html>