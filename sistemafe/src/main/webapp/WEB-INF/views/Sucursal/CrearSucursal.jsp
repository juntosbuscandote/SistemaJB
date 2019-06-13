<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
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
						</div>
						<div class="title_right">
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Crear Sucursal</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<%@include file="../../template/Sucursal/ConfiguracionSucursal.jsp"%>
									<!--BOTONES -->
									<div class="ln_solid"></div>
									<div class="form-group">
										<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
											<button type="button" class="btn btn-primary ladda-button" data-style="expand-right" id="frmSucursalGuardar">Guardar</button>
											<button type="button" class="btn btn-success" id="btnSalir" data-dismiss="modal">Salir</button>
										</div>
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
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <script src="../resources/js/jquery.validate.js"></script>
	<script src="<c:url value='../resources/v1/SucursalController.js'/>" type="text/javascript"></script>
	<script type="text/javascript">
	   $(document).on('ready', function() {
	   	var sucursal = new Sucursal();
	   	sucursal.init();
	   });
	</script>
</body>
</html>