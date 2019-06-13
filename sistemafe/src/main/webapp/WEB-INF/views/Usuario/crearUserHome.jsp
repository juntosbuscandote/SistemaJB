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
<link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css">

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
<%-- 			<%@include file="../Global/nav.jsp"%> --%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row" id="modalCrearUsuario">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Configuración</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<%@include file="../../template/Persona/ConfiguracionPersona.jsp"%>
									<div class="x_panel">
										<div class="x_title">
											<h4>Configuracion de usuario</h4>
										</div>
										<div id="datoUsuario"class="col-lg-10 col-md-10  col-lg-offset-1">
											<input type="hidden" id="perfil"   value="${perfil}"   />
											<input type="hidden" id="busibident"   value="${busibident}"   />
											<form id="frmUser" name="frmUser">
												
												<div class="row">
													<div class="col-lg-6 col-md-6 col-xs-12 form-group"
														id="tipDocSelect">
														<label class="control-label" for="empr_vdoctype">Perfil:</label>
														<select style="width: 100%" class="form-control filter-single" id="listaProfile" name="listaProfile" disabled />
															<c:forEach items="${listaProfile}" var="profil">
																<option value="${profil.profBident}">${profil.profVname}</option>
															</c:forEach>
														</select>
													</div>
													<div class="col-lg-6 col-md-6 col-xs-12 form-group">
														<label class="control-label" for="pers_vnumdoc">Usuario:</label>
														<input type="text" class="form-control" id="user_vuser" name="user_vuser" placeholder="Usuario" value="${userUser}" readonly="readonly" />
													</div>
												</div>
												<!--  <div class="row" id="vstBussines">
													<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
														<label class="control-label" for="usu_sucursal">Sucursal:</label>
														<select class="form-control select2-enabled section2" name="usu_sucursal" id="usu_sucursal" value="${sucursal}" disabled>
															<option></option>
															<c:forEach items="${lstTBussines}" var="lstTBussines">
																<option value="${lstTBussines.offiBident}">${lstTBussines.offiVname}</option>
															</c:forEach>
														</select>
													</div>
													
												</div>
												
												
												<div class="row" id="vstBussiness">
													<div class="col-lg-6 col-md-6 col-xs-12 form-group">
														<label class="control-label" for="usu_x_sucursal">sucursal:</label>
														<input class="form-control" id="usu_x_sucursal" name="sucursal" value="${lstsucursal}" readonly="readonly" />
													</div>
												</div>
												-->
												<div class="row" id="vstPassword">
													<div class="col-lg-6 col-md-6 col-xs-12 form-group">
														<label class="control-label" for="pers_vnumdoc">Contraseña:</label>
														<input type="password" class="form-control" id="user_vpassword" name="user_vpassword" placeholder="Contraseña"  value="${userPassw}" readonly="readonly" />
													</div>
													<div class="col-lg-6 col-md-6 col-xs-12 form-group">
														<label class="control-label" for="pers_vnumdoc">Confirmar Contraseña:</label> 
														<input type="password" class="form-control" id="user_vRepassword" name="user_vRepassword" placeholder="Confirmar Contraseña"  value="${userPassw}"  readonly="readonly" />
													</div>
												</div>
											</form>
										</div>
									</div>
									<div class="progress-demo">
										<button class="btn btn-primary ladda-button"data-style="expand-right" type="button" id="btnRegUser">
											<span>Guardar</span>
										</button>
										<button type="button" class="btn btn-success" id="btnSalir" name="btnSalir">Salir</button>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
   <!-- jQuery -->
    <script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../resources/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../resources/vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../resources/vendors/moment/min/moment.min.js"></script>
    <script src="../resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- Ion.RangeSlider -->
    <script src="../resources/vendors/ion.rangeSlider/js/ion.rangeSlider.min.js"></script>
    <!-- Bootstrap Colorpicker -->
    <script src="../resources/vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
    <!-- jquery.inputmask -->
    <script src="../resources/vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
    <!-- jQuery Knob -->
    <script src="../resources/vendors/jquery-knob/dist/jquery.knob.min.js"></script>
    <!-- Cropper -->
    <script src="../resources/vendors/cropper/dist/cropper.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../resources/build/js/custom.min.js"></script>
    <!-- Datatables -->
    <script src="../resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../resources/vendors/jszip/dist/jszip.min.js"></script>
    <script src="../resources/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../resources/vendors/pdfmake/build/vfs_fonts.js"></script>
    <!-- datepicker -->
    <script src="../resources/vendors/bootstrap-datepicker/js/jquery-ui.min.js"></script>
    <!-- azevallos agregando bootbox    -->
    <script src="../resources/js/bootbox.min.js"></script>
    <script src="../resources/js/jquery.validate.js"></script>
    <script src="../resources/vendors/global.js"></script>
    
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script src="<c:url value='../resources/v1/UsuarioController.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='../resources/v1/PersonaController.js'/>"
		type="text/javascript"></script>
	<script src="../resources/js/util/global.js"></script>
<!-- 	<script type="text/javascript" src="../resources/v1/vue.js"></script> -->
<!-- 	<script type="text/javascript" src="../resources/v1/axios.js"></script> -->
<!-- 	<script type="text/javascript" src="../resources/v1/app.js"></script> -->
	<script type="text/javascript">
		$(document).on('ready', function() {
			var personaController = new PersonaController();
			personaController.init();
			var usuario = new Usuario();
			usuario.objPerson = personaController;
			usuario.init();
		});
	</script>
</body>
</html>