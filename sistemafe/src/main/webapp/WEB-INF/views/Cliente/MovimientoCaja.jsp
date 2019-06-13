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
<script src="../resources/vendors/bootstrap-datepicker/js/jquery-ui.js"></script>
<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
<link rel="stylesheet" href="../resources/vendors/bootstrap-datepicker/css/jquery-ui.css">
<link rel="stylesheet" href="../resources/vendors/nprogress/support/style.css">
<link rel="stylesheet" href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<!-- Mustache para renderizar Json-->


<%@include file="../Global/header.jsp"%>
<body class="nav-md">

	<jsp:include page="../mustache/cajaTemplate.jsp" />
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<input type="hidden" id="dataVentas" value="<c:out value='${dataVentas}' />" />															
							<input type="hidden" value="${idcodVenta}" id="idAlmacen" name="idAlmacen">
<%-- 							<input type="hidden" value="${data}" id="dataCp"> --%>
							<input type="hidden" id="dataCp" value="<c:out value='${data}' />" />
							<c:set var="listaSucursal" value="${listaSucursal}" />
							<input type="hidden" id="dataPc" value="<c:out value='${dataPC}' />" />
							<input type="hidden" id="dataCajaSuc" value />

						</div>
						<div class="title_right"></div>
					</div>

					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">
									<form class="form-horizontal form-label-left input_mask"
										id="frmMovimientoCaja" name="frmMovimientoCaja">
										<div class="x_panel" >
											<div class="row" >
													<div id="" class="col-md-12 col-xs-12 form-group">
														<div class="col-md-2 col-sm-4 col-xs-12 form-group">
															<label class="control-label">Ejercicio:</label> <select
																style="width: 100%" class="form-control filter-single inputConData"
																id="lstMovCajaEjercicio" name="lstMovCajaEjercicio">
																<c:forEach items="${listaAnio}" var="listcatperiod">
																	<c:if test="${listcatperiod.estado}">
																		<option selected value="${listcatperiod.opcAnio}">${listcatperiod.opcAnio}</option>
																	</c:if>
																	<c:if test="${listcatperiod.estado==false}">
																		<option value="${listcatperiod.opcAnio}">${listcatperiod.opcAnio}</option>
																	</c:if>
																</c:forEach>
															</select>
														</div>
														<div class="col-md-2 col-sm-4 col-xs-12 form-group">
															<label class="control-label">Periodo:</label> <select
																style="width: 100%" class="form-control filter-single inputConData"
																id="lstMovCajaPeriodo" name="lstMovCajaPeriodo">
																<c:forEach items="${listaCatDetPeriod}" var="listcatperiod">
																	<c:if test="${listcatperiod.estado}">
																		<option selected value="${listcatperiod.opcion.catdCident}">${listcatperiod.opcion.catdVdescription}</option>
																	</c:if>
																	<c:if test="${listcatperiod.estado==false}">
																		<option value="${listcatperiod.opcion.catdCident}">${listcatperiod.opcion.catdVdescription}</option>
																	</c:if>
																</c:forEach>
															</select>
														</div>
														<div class="col-md-3 col-sm-6 col-xs-12 form-group">
															<label class="control-label">Sucursal:</label> <SELECT
																class="form-control inputConData" id="lstMovCajaSucursal"
																name="lstMovCajaSucursal">
																<c:forEach items="${listaSucursal}" var="listaSucursal">
																	<option value="${listaSucursal.offiBident}">${listaSucursal.offiname}</option>
																</c:forEach>
															</SELECT>
														</div>
														<div class="col-md-3 col-sm-4 col-xs-12 form-group">
															<label class="control-label">Fecha Registro:</label> 
															<input class="form-control" id="frmMovCajaFecRegistro" value="${fechademovimiento}" name="frmMovVentaFecMovNota" >
														</div>
														<div class="col-md-2 col-sm-4 col-xs-12 form-group">
															<label class="control-label">Código de Registro:</label> <input
																class="form-control col-md-9 col-sm-5 col-xs-12" disabled="disabled"
																value="" id="frmMovCajaCodRegistro" name="frmMovCajaCodRegistro"
																type="text">
														</div>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12 form-group">
														<div class="col-md-2 col-sm-4 col-xs-12 form-group">
															<label class="control-label">Moneda:</label> 
															<select class="form-control inputConData" id="lstMovCajaMoneda" name="lstMovCajaMoneda">
																<c:forEach items="${listaCatDetMoneda}" var="listcatmoneda">
																	<option value="${listcatmoneda.catdCident}" attr-sym="${listcatmoneda.catdVsymbol}" attr-color="${listcatmoneda.catdVkey1}"
																	attr-moneda="${listcatmoneda.catdVshortname}">${listcatmoneda.catdVshortname}</option>
																</c:forEach>
															</select>
														</div>
														<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="comboTipCambio">
															<label class="control-label">Tipo de Cambio:</label> <SELECT
																class="form-control inputConData" id="lstMovCajaTipCambio" name="lstMovCajaTipCambio">
																<option value="${Ident}" attr-venta="${venta}">V: ${venta}</option>
																<option value="${Ident}" attr-compra="${compra}">C: ${compra}</option>
																<option value="${Ident}" attr-promedio="${promedio}">P: ${promedio}</option>
															</SELECT>
														</div>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12 form-group">
														<div class="form-group">
															<div class="col-lg-6 col-md-6 col-xs-12 form-group">
																<label class="radio-inline"> 
																<input type="radio" value="1" id="frmRadioMovCajaCliente" name="frmRadioMovCaja" checked>Cliente</label> 
																<label class="radio-inline"> 
																<input type="radio" value="2" id="frmRadioMovCajaProveedor" name="frmRadioMovCaja">Proveedor</label>
															</div>
														</div>
<!-- 														<label class="control-label">Cliente/Proveedor/Otros:</label> -->
														<div class="form-group" id="divCliente">
															<select class="form-control select2-single" id="lstMovCajaCliente" name="lstMovCajaCliente">
																<c:forEach items="${filtrarClienteNroC}" var="filtrarClienteNros">
																	<option  attr-tipdoc="${filtrarClienteNros.persVdoctype}" attr-numdoc="${filtrarClienteNros.pers_vnumdoc}" attr-nombre="${filtrarClienteNros.nombre}" attr-email="${filtrarClienteNros.mailVmail}" attr-direccion="${filtrarClienteNros.direccionUbigeoPais}"  value="${filtrarClienteNros.clieBident}">${filtrarClienteNros.pers_vnumdoc} - ${filtrarClienteNros.nombre}</option>
																</c:forEach>
															</select>
														</div>
														<div class="form-group"  style="display: none;" id="divProveedor">
															<select class="form-control select2-single" id="lstMovCajaProveedor" name="lstMovCajaProveedor">
																<c:forEach items="${filtrarProveedorNroP}" var="filtrarVendedorNros">
																	<option attr-tipdoc="${filtrarVendedorNros.persVdoctype}" attr-numdoc="${filtrarVendedorNros.persVnumdoc}" attr-nombre="${filtrarVendedorNros.nombres}" value="${filtrarVendedorNros.prov_bident}">${filtrarVendedorNros.persVnumdoc} - ${filtrarVendedorNros.nombres}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12 form-group">
														<label class="control-label"> Obs.: </label> 
														<input class="form-control" value="${ObsCabecera}" id="frmMovCajaObservacion" name="frmMovCajaObservacion" type="text">
													</div>
											</div>
										</div>
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnCrearCP"><span>Crear CP</span></button>
										<button class="btn btn-danger ladda-button" data-style="expand-right" type="button" id="btnCambiarCab" style="display: none"><span>Cambiar Cabecera</span></button>
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnAgregarCP" style="display: none" ><span>Añadir CP</span></button>
<%-- 										<%@include file="../../template/Caja/AgregarCP.jsp"%> --%>
<!-- 										<div id="primerCP" class="form-group"></div> -->
										
										<div id="divAgrCP" class=""></div>
										<div class="form-group">
											<label class="control-label col-md-9 col-sm-9 col-xs-12">Total a Pagar:<output id="labelTotalPagar"></output></label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input class="form-control" id="frmMovCajaTotalPagar"
													name="frmMovCajaTotalPagar" type="text" value="${modfTotalNeto}" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-1 col-sm-1 col-xs-12 text-info">SON:
											</label>
											<div class="col-md-11 col-sm-11 col-xs-12">
												<input class="form-control" id="frmMovCajaMonto"
													name="frmMovCajaMonto" type="text" value="${modfTotalenLetras}" readonly>
											</div>
										</div>
									</form>
								</div>
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnGuardar"><span>Guardar</span></button>
										<button class="btn btn-success ladda-button" data-style="expand-right" type="button" id="btnSalirCaja"><span>Cancelar</span></button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<%-- 					<%@include file="../../template/Caja/AgregarPagoCaja.jsp"%> --%>
		
		
		
			<%@include file="../Global/footer.jsp" %>
			<!-- /Datatables -->
			<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
			<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
			<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
			<script src="../resources/js/util/global.js"></script>
			<script src="../resources/vendors/moment/moment.js"></script>
			<script src="../resources/vendors/moment/min/moment-with-locales.js"></script>
			<script src="../resources/vendors/moment/locale/es.js"></script>
			<script src="<c:url value='../resources/v1/CajaController.js'/>" type="text/javascript"></script>
			<!-- Include Date Range Picker -->
			<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
			<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
			
<style>
output {
    display: inline;
}
</style>
		 
			
			<script type="text/javascript">
	            $(document).on('ready', function () {
	                var caja = new Caja();
	                caja.init(); 
	            });
	            </script>
</body>
</html>
