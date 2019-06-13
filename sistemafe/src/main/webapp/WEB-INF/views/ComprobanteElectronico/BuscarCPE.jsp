<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="en">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Juntos Buscandote</title>
<link rel="shortcut icon" href="../resources/img/iconJB_1.jpg">


<%@include file="../Global/header.jsp"%>
</head>
<body class="login">
	<div class="main_container">
	<div class="row">
		<div class="x_panel">
		<div class="col-md-6 col-sm-6 col-xs-12 ">
		<div align="center">
		<br>
			<img src="../resources/img/log1.jpg" width="585px" height="739px" id="imgMsj">
		<br>
		</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12 ">
		
		<input  type="hidden" id="empresa" value="<c:out value='${empresa}' />" />
		
			<div class="x_content">
				<div class="col-md-2 col-sm-2 col-xs-12 "></div>
				<div class="col-md-8 col-sm-8 col-xs-12 " align="center">
<!-- 					<img src="../resources/img/logoFinal.png" width="200" height="100"> -->
					<img class="w-full p-b-34" src="../resources/img/log2.jpg">
					<br>
					<br>
					<form class="form-horizontal form-label-left" id="frmBuscarCPE"
						name="frmBuscarCPE">
<!-- 						<div class="form-group"> -->
<!-- 							<div class="container-login100-form-btn progress-demo" > -->
<!-- 								<label class="control-label col-md-5 col-sm-5 col-xs-12" -->
<!-- 								for="frmBuscarCPERUC">Empresa:</label> -->
<!-- 								<div class="col-md-7 col-sm-7 col-xs-12"> -->
<!-- 									<select style="width: 100%" class="form-control filter-single" -->
<!-- 										id="listaEmpreCPE" name="listaEmpreCPE"> -->
<%-- 										<c:forEach items="${empresasprueba}" var="empresasprueba"> --%>
<%-- 											<option value="${empresasprueba.empresaConsulta}">${empresasprueba.empresaConsulta}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
								<button class="btn btn-info "
									data-style="expand-down" type="button">
									<span>Consultar Persona </span>
								</button></a>
<br><br>
							
						<div class="form-group">
							<label class="control-label col-md-5 col-sm-5 col-xs-12"
								for="listaEmpreCPE">DNI :</label>
							<div class="col-md-7 col-sm-7 col-xs-12">
								<input type="text" class="form-control"
									id="listaEmpreCPE" name="listaEmpreCPE"
									required=""
									value="" maxlength="11"/>
							</div>
						</div>
												
					<div class="form-group">
							<label class="control-label col-md-5 col-sm-5 col-xs-12"
								for="frmBuscarCPEFecEmi">Desde:</label>
							<div class="col-md-7 col-sm-7 col-xs-12">
								<input type="text" class="form-control" id="frmBuscarCPEFecEmi"
									name="frmBuscarCPEFecEmi" placeholder="Fecha1"
								 required="" value="" />
							</div>
						</div>
					
						<div class="form-group">
							<label class="control-label col-md-5 col-sm-5 col-xs-12"
								for="frmBuscarCPEFecEmi">Hasta:</label>
							<div class="col-md-7 col-sm-7 col-xs-12">
								<input type="text" class="form-control" id="frmBuscarCPEFecEmi"
									name="frmBuscarCPEFecEmi" placeholder="Fecha2"
								 required="" value="" />
							</div>
						</div>
						
					
						
						
						<div class="separator">
							<div class="clearfix"></div>
<!-- 							<div class="g-recaptcha" -->
<!-- 								data-sitekey="6LcePAATAAAAAGPRWgx90814DTjgt5sXnNbV5WaW"></div> -->
							</br>
							<div class="progress-demo">
								<button class="btn btn-primary ladda-button"
									data-style="expand-right" type="button" id="btn_explorar">
									<span>Buscar</span>
								</button>
							</div>
						</div>
					</form>
					<a href="../"><button class="btn btn-warning ladda-button"
									data-style="expand-right" type="button" id="btn_volver_login">
									<span>Regresar a Login</span>
								</button></a>
				</div>
			</div>

			<div class="x_content" id="mostrarLstExploradorCPE" style="display: none">
<!-- 				<div class="col-md-3 col-sm-3 col-xs-12 "></div> -->
				<div class="col-md-12 col-sm-12 col-xs-12 ">
					<div class="clearfix"></div>
					<div class="table-responsive">
						<div class="container_fluid">
							<table id="lstExploradorCPE" name="lstExploradorCPE"
								class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Fecha Perdida</th>
										<th>Estado</th>
										<th>PDF</th>
										<th>CDR</th>
									</tr>

								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		</div>
	</div>
	</div>

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
    
	<script src='https://www.google.com/recaptcha/api.js?hl=es'></script>

	<script type="text/javascript"
		src="../resources/v1/ExploradorCPEController.js"></script>

	<script type="text/javascript">
		$(document).on('ready', function() {
			var exploradorCPE = new ExploradorCPE();
			exploradorCPE.init();
		});
	</script>
	
	
<STYLE type="text/css">
	img {
    max-width: 100%;
    height: auto;
    width: auto/9; /* Bug de ie8 */
	}

</STYLE>

</body>
</html>


