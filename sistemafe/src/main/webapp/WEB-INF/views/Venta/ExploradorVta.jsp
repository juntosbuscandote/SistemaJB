<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">

<link rel="stylesheet"
	href="../resources/vendors/bootstrap-datepicker/css/jquery-ui.css">
<link rel="stylesheet"
	href="../resources/vendors/nprogress/support/style.css">
<link rel="stylesheet"
	href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet"
	href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<%@include file="../Global/header.jsp"%>
<script src="../resources/vendors/bootstrap-datepicker/js/jquery-ui.js"></script>
<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>

<style type="text/css" class="init">
td.details-control {
	background: url('../resources/img/details_open.png') no-repeat center
		center;
	cursor: pointer;
}

tr.shown td.details-control {
	background: url('../resources/img/details_close.png') no-repeat center
		center;
}
</style>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="page-title">
					<div class="title_left">
					</div>
					<div class="title_right"></div>
				</div>
				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>Explorador Venta</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<%@include
									file="../../template/RegistroVenta/GrillaRegistroVenta.jsp"%>
							</div>
						</div>
					</div>
				</div>
				<input type="hidden"
					value id="idAlmacen" name="idAlmacen">
				<div class="modal fade" id="frmmodalMostrarDetalle" tabindex="-1"
					role="dialog" data-keyboard="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<form class="form-horizontal form-label-left input_mask"
								id="frmDetVenta" name="frmDetVenta" method="POST" action="">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">Detalle Venta</h4>
								</div>

								<div class="x_panel">
									<%@include
										file="../../template/RegistroVenta/GrillaRegistroVentaDetalle.jsp"%>
								</div>
												<div class="modal-footer text-center">
													<button type="reset" class="btn btn-primary" id="Salir">Salir</button>
												</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	<%@include file="../Global/footer.jsp"%>
	<script src="<c:url value='../resources/v1/RegistroVenta.js'/>" type="text/javascript"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
	<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>

	<script type="text/javascript">
		$(document).on('ready', function() {
			var explorador = new ExploradorVenta();
			explorador.init();

		});
	</script>
</body>
</html>