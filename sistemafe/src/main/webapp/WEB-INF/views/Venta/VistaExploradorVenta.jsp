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
<link href="../resources/vendors/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
<link href="../resources/vendors/datatables/css/fixedColumns.dataTables.min.css" rel="stylesheet">
<%@include file="../Global/header.jsp"%>
<script src="../resources/vendors/bootstrap-datepicker/js/jquery-ui.js"></script>
<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
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
					<div class="title_left"></div>
					<input type="hidden" id="tipoCambio" value="<c:out value='${venta}' />" />
					<div class="title_right"></div>
				</div>
				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<form method="GET" id="frm_filtrarVenta" name="frm_filtrarVenta"
								action="" novalidate>
								<div class="col-md-12 col-sm-12 col-xs-12" style="width: 100%">
									<fieldset class="fielset-filtros">
										<div class="row">
											<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPFiltrosSucursal" class="control-label">Sucursal:</label> <select style="width: 100%"
													class="form-control filter-single input-sm select2-single"
													id="frmCPFiltrosSucursal" name="frmCPFiltrosSucursal">
													<option value="">Ver Todos</option>
													<c:forEach items="${listaSucursal}" var="listcatcomp">
														<option value="${listcatcomp.offiBident}">${listcatcomp.offiname}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPFiltrosTipo" class="control-label">Tipo
													de CP:</label> 
												 <select style="width: 100%"
													class="form-control filter-single input-sm select2-single"
													id="frmCPFiltrosTipo" name="frmCPFiltrosTipo">
													<option value="">Ver Todos</option>
													<c:forEach items="${listaCatDetTipoCPE}" var="listcatcomp">
														<option value="${listcatcomp.catdCident}">${listcatcomp.catdVdescription}</option>
													</c:forEach>
												</select>			
											</div>
											<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPEFiltrosNro" class="control-label">Nro.
													de CP:</label> <input type="text" name="frmCPEFiltrosNro"
													id="frmCPEFiltrosNro"
													class="form-control input-sm filter-single" value=""
													maxlength="30">
											</div>
											<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPEFiltrosRUC" class="control-label">Nro
													Doc Cliente:</label> <input type="text" name="frmCPEFiltrosRUC"
													id="frmCPEFiltrosRUC"
													class="form-control input-sm filter-single" value=""
													maxlength="15">
											</div>
											<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPEFiltrosRazSoc" class="control-label">Cliente:</label>
												<input type="text" name="frmCPEFiltrosRazSoc"
													id="frmCPEFiltrosRazSoc"
													class="form-control input-sm filter-single" value=""
													maxlength="200">
											</div>
												<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label for="frmCPEFiltrosNro" class="control-label">Nro.
													de Serie:</label> <input type="text" name="frmCPEFiltrosSre"
													id="frmCPEFiltrosSre"
													class="form-control input-sm filter-single" value=""
													maxlength="30">
											</div>
											<!-- 					                                                            <div class="col-md-2 col-sm-4 col-xs-12 form-group"> -->
											<!-- 					                                                                <label for="frmCPEFiltrosMontoTotal" class="control-label">Monto Total:</label> -->
											<!-- 					                                                                <input type="number" name="frmCPEFiltrosMontoTotal" id="frmCPEFiltrosMontoTotal" class="form-control input-sm filter-single" value="" maxlength="30"> -->
											<!-- 					                                                            </div> -->
											

										</div>
										<div class="row">
											<div class="col-md-4 col-sm-4 col-xs-12">
												<label class="control-label text-center">Intervalo
													de Fecha de Emisión:</label><br />
												<div class="input-prepend input-group">
													<span class="add-on input-group-addon"><i
														class="glyphicon glyphicon-calendar fa fa-calendar"></i></span> <input
														type="text" name="frmCPEFiltrosfecIniFecFinexplorador"
														id="frmCPEFiltrosfecIniFecFinexplorador"
														class="form-control input-sm filter-single" value="">
												</div>
											</div>
										<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Periodo:</label>
												<select style="width: 100%"
													class="form-control filter-single input-sm select2-single"
													id="listaCatDetPeriod" name="listaCatDetPeriod">
													<option value="">Ver Todos</option>
													<c:forEach items="${lstCatPeriodo}" var="listcatcomp">
														<option value="${listcatcomp.catdCident}">${listcatcomp.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
												<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Estado:</label> 
												<select style="width: 100%"
													class="form-control filter-single input-sm select2-single"
													id="listaAnulado" name="listaAnulado">
													<option value="">Ver Todos</option>
													<c:forEach items="${lstCatEstadoVenta}" var="lstCatEstadoVenta">
														<option value="${lstCatEstadoVenta.catdCident}">${lstCatEstadoVenta.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
												<div class="col-md-2 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Moneda:</label>
												 <select
													style="width: 100%" class="form-control filter-single input-sm select2-single"
													id="listaMoneda" name="listaMoneda">
													<option value="">Ver Todos</option>
													<c:forEach items="${listaCatDetMoneda}" var="listcatmoneda">
													<option value="${listcatmoneda.catdCident}">${listcatmoneda.catdVshortname}</option>
													</c:forEach>
												</select>
												
												
											</div>
											<div class="col-md-2 col-sm-4 col-xs-12 search-btn ">
												<br />
												
													<button type="button" class="btn btn-primary"
												
													data-spinner-color="#ffffff" title="Filtrar" id="btn_search">
													<i class="fa fa-search"></i>
												</button> 									
												<button type="reset" class="btn btn-success" title="Limpiar Filtro" id="btn_clean"><i class="fa fa-trash"></i></button>
                                                          <!-- id="btn_exportarDropdown" -->
														<button type="button" id="exportExcel"
															class="btn btn-info dropdown-toggle has-tooltip" 
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false" id="" data-placement="top"
															title="Exportar">
															<i class="fa fa-file-excel-o"></i> 
														</button>
											</div>
										</div>
									</fieldset>

								</div>


							</form>
							<div class="x_content">
								<%@include
									file="../../template/RegistroVenta/GrillaExploradorVenta.jsp"%>
							</div>
							<form class="form-horizontal form-label-left input_mask">
							<%@include file="../../template/Pie/DatosResultadoCuentas.jsp"%>
							</form>
						</div>
					</div>
				</div>
				<input type="hidden" value id="idAlmacen" name="idAlmacen">
				<div class="modal fade" id="frmmodalMostrarDetalle" tabindex="-1"
					role="dialog" data-keyboard="true">
					<div class="modal-dialog modal-lg" role="document"
						style="width: 95% !important">
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
										file="../../template/RegistroVenta/GrillaRegistroVenta.jsp"%>
								<div class="modal-footer text-center">
									<button type="reset" class="btn btn-primary" id="Salir">Salir</button>
								</div>
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
	<script src="<c:url value='../resources/v1/RegistroVenta.js'/>"type="text/javascript"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
	<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
    <script	src="../resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script src="../resources/vendors/jszip/dist/jszip.min.js"></script>
	<script src="../resources/vendors/pdfmake/build/pdfmake.min.js"></script>	
	<script	src="../resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script	src="../resources/vendors/datatables.net-buttons/js/buttons.colVis.min.js"></script>
	<script src="../resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="../resources/vendors/pdfmake/build/vfs_fonts.js"></script>
	<script src="../resources/vendors/moment/moment.js"></script>
			<script src="../resources/vendors/moment/min/moment-with-locales.js"></script>
			<script src="../resources/vendors/moment/locale/es.js"></script>
	<script src="../resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script src="../resources/vendors/datatables/js/dataTables.fixedColumns.js"></script>
<!--<script src="../resources/vendors/datatables/js/jquery.dataTables.min.js"></script> --> 
<!--<script src="../resources/vendors/datatables/js/jquery-3.3.1.js"></script> -->
	
<script type="text/javascript">
	            $(document).on('ready', function () {
	                var registroventa = new RegistroVenta();
	                registroventa.init(); 
	            });
	            </script>
</body>
</html>