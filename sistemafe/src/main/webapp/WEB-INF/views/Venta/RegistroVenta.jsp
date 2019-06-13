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

	<jsp:include page="../mustache/mustacheTemplate.jsp" />
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<!--                                 <h3>Registro de Venta </h3> -->
							<input type="hidden" id="direccionEmpresa" value="<c:out value='${direccionEmpresa}' />" />
							<input type="hidden" id="emailEmpresa" value="<c:out value='${emailEmpresa}' />" />
							<input type="hidden" id="telefonoEmpresa" value="<c:out value='${telefonoEmpresa}' />" />
							<input type="hidden" id="nroRucEmpresa" value="<c:out value='${nroRucEmpresa}' />" />
							<input type="hidden" id="imagenLogo" value="<c:out value='${imagenLogo}' />" />
							
							<input type="hidden" id="dataTipoCambio" value="<c:out value='${flagTC}' />" />
							<input type="hidden" id="dataTipoCambioFecha" value="<c:out value='${fechaActual}' />" />
							<input type="hidden" id="dataVentas" value="<c:out value='${dataVentas}' />" />															
							<input type="hidden" value="${idcodVenta}" id="idAlmacen" name="idAlmacen">
							<input type="hidden" value="${cliente}" id="idCliente" name="idCliente">
							<input type="hidden" value="${vendedor}" id="idVendedor" name="idVendedor">
							<input type="hidden" value="${fechaderegistro}" id="idFecReg" name="idFecReg">
							<input type="hidden" value="${fechademovimiento}" id="idFecMov" name="idFecMov">
							<input type="hidden" value="${fechadevencimiento}" id="idFecVencimiento" name="idFecVencimiento">
							<input type="hidden" value="${fechadepago}" id="idFecPago" name="idFecPago">
							<input type="hidden" value="${formadepago}" id="idFormaPago" name="idFormaPago">
							<input type="hidden" value="${periodo}" id="idPeriodo" name="idPeriodo">
							<input type="hidden" value="${sucursal}" id="idSucursal" name="idSucursal">
							<input type="hidden" value="${tipdoc}" id="idTipCP" name="idTipCP">
							<input type="hidden" value="${moneda}" id="idMone" name="idMone">
							<input type="hidden" value="${indicador}" id="idIndi" name="idIndi">
							<input type="hidden" value="${indicadortipo}" id="idIndiTip" name="idIndiTip">
							<input type="hidden" value="${pdf}" id="idPdf" name="idPdf">
							<input type="hidden" value="" id="VerDet" name="VerDet">
							<input type="hidden" value="${editar}" id="EditDet" name="EditDet">
							<input type="hidden" value="" id="idVentaRef" name="idVentaRef">
							<input type="hidden" value="" id="idMostrarDetVenta" name="idMostrarDetVenta">
							<input type="hidden" value="" id="idMoneNota" name="idMoneNota">
							<input type="hidden" value="" id="idVistaPrevia" name="idVistaPrevia">
							<input type="hidden" value="${usuarioFilter.legaBusiname}" id="legabusi" name="legabusi">
                            <input type="hidden" value="" id="dataFacIndicadorAf" name="dataFacIndicadorAf">
							<input type="hidden" value="" id="dataFacIndicadorAfTipo" name="dataFacIndicadorAfTipo">
						</div>
						<div class="title_right"></div>
					</div>

					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">
									<form class="form-horizontal form-label-left input_mask"
										id="frmRegistroVenta" name="frmRegistroVenta">
										<div class="x_panel" >
											<div class="row" >
													<div id="" class="col-md-12 col-xs-12 col-md-offset-0">
															<%@include file="../../template/Cabeceras/DatosCabeceraPrincipal.jsp"%>
													</div>
													</div>
													</div>
												</form>

											</div>
											<div class="x_panel">
												<div class="col-md-2 col-sm-4 col-xs-12 form-group">
													<label class="control-label">Fecha Movimiento:</label> 
													<input class="form-control comment lengSpa inputConData " id="frmMovVentaFecMov" value="${fechademovimiento}" name="frmMovVentaFecMov">
												</div>
												<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="idFecVenc" style="display: none">
													<label class="control-label">Fecha Vencimiento:</label> 
													<input class="form-control" id="frmMovVentaFecCad" value="" name="frmMovVentaFecCad" disabled="disabled">
<!-- 													<input class="form-control" id="reportrange" name="reportrange"> -->
												</div>		


												
												<div class="col-md-3 col-sm-4 col-xs-12 form-group" id="divTipComprobante">
													<label class="control-label">Tipo Comprobante:</label> 
													<select style="width: 100%" class="form-control filter-single inputConData " id="listaCatDetComp" name="listaCatDetComp">
<!-- 														<option value=""></option> -->
														<c:forEach items="${listaCatDetComp}" var="listcatcomp">
															<option value="${listcatcomp.catdCident}">${listcatcomp.catdVdescription}</option>
														</c:forEach>
													</select>
												</div>
												
												<div class="col-md-3 col-sm-6 col-xs-12 form-group" id="divSerie">
													<label class="control-label">NRO SERIE:</label> <SELECT
														class="form-control inputConData " id="listSerieVenta"
														name="listSerieVenta">
													</SELECT>
												</div>
												<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="divNroComprobante">
													<label class="control-label">Nro. Comprobante:</label> 
													<input class="form-control inputConData " value="${VentaNroDoc}" id="frmMovVentaNroComprobante" name="frmMovVentaNroComprobante" type="text" disabled="disabled">
												</div>
											</div>
<!-- 										</div> -->
										<div class="x_panel" id="divNotaVenta" style="display: none">
									<div class="col-md-3 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Fecha Movimiento:</label> 
													<input class="form-control" id="frmMovVentaFecMovNota" value="${fechademovimiento}" name="frmMovVentaFecMovNota" disabled="disabled" >
											</div>
											
											<div class="col-md-3 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Tipo Comprobante:</label> <select style="width: 100%"
													class="form-control filter-single "
													id="frmMovVentaListaCompNota" name="frmMovVentaListaCompNota" disabled="disabled">
													<c:forEach items="${listaCatDetCPE}"
														var="listcatindicadorbs">
														<option value="${listcatindicadorbs.catdCident}">${listcatindicadorbs.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-md-3 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Serie:</label> 
													<input class="form-control" id="frmMovVentaSerieNota" value="${fechademovimiento}" name="frmMovVentaSerieNota" disabled="disabled">
											</div>
											<div class="col-md-3 col-sm-4 col-xs-12 form-group">
												<label class="control-label">Nro Comprobante:</label> 
													<input class="form-control" id="frmMovVentaNroComprNota" value="${fechademovimiento}" name="frmMovVentaNroComprNota" disabled="disabled" >
											</div>
								</div>
								
										<div class="x_panel">
											<div class="form-group">
												<%@include
													file="../../template/Cabeceras/DatosClienteVendedor.jsp"%>
											</div>
											<div id="" class="col-md-12 col-xs-12 col-md-offset-0">
												<div class="row">
													<!-- mtoledo 08/03/2019 CWA-591 -->
													<div class="col-md-2 col-sm-4 col-xs-12 form-group">
														<label class="control-label">Tipo Operación</label> 
														 <select style="width:100%" class="form-control filter-single inputConData" id="listaTipoOperacion" name="listaTipoOperacion">
															  <c:forEach items="${listaOperacion}" var="listaOperacion"> 
															  <option  	value="${listaOperacion.catdCident}">${listaOperacion.catdVdescription}</option>
															  </c:forEach> 
													    </select>
													</div>
													<div class="col-md-2 col-sm-4 col-xs-12 form-group">
														<label class="control-label">Indicador Afecto</label> 
														 <select style="width:100%" class="form-control filter-single inputConData" id="listaCatDetIndicador" name="listaCatDetIndicador">
															  <c:forEach items="${listaCatDetIndicador}" var="listcatindicador"> 
															  <option  	value="${listcatindicador.catdCident}">${listcatindicador.catdVdescription}</option>
															  </c:forEach> 
													    </select>
													</div>

													<div class="col-md-3 col-sm-4 col-xs-12 form-group">
														<label class="control-label">Tipo Indicador Afecto</label>
														<SELECT  style="width:100%" class="form-control filter-single inputConData" class=" form-control input-sm" id="listaCatDetIndicadortipo" name="listaCatDetIndicadortipo">
                                                    	</SELECT>
													</div>
													<div class="col-md-3 col-sm-4 col-xs-12 form-group" id="divMotivoCre" style="display: none">
												<label class="control-label">Motivo</label> <select
													style="width: 100%" class="form-control filter-single select2-single"
													id="listaMotivoCre" name="listaMotivoCre">
													<c:forEach items="${listaMotCre}"
														var="listcatmotivo">
														<option value="${listcatmotivo.catdCident}" attr-desc="${listcatmotivo.catdVdescription}" >${listcatmotivo.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-md-3 col-sm-4 col-xs-12 form-group" id="divMotivoDeb" style="display: none">
												<label class="control-label">Motivo</label> <select
													style="width: 100%" class="form-control filter-single select2-single"
													id="listaMotivoDeb" name="listaMotivoDeb">
													<c:forEach items="${listaMotDeb}"
														var="listcatmotivo">
														<option value="${listcatmotivo.catdCident}" attr-desc="${listcatmotivo.catdVdescription}">${listcatmotivo.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
													<br>
													<!-- mtoledo 08/03/2019 CWA-591 -->
													<div class="col-md-2 col-sm-2 col-xs-12" id="divventaGratis">
														<label>
														<input type="checkbox" name="movVentTitgrat" id="movVentTitgrat" /> Venta a titulo Gratuito
														</label>
													</div>
													<div class="col-md-2 col-sm-2 col-xs-12" id="divOperAnticipo" style="display: none">
														<label>
														<input type="radio" name="operAnticipo" value="1" checked> Anticipo<br>
<!-- 														<input type="checkbox" name="operAnticipo" id="operAnticipo"  /> Anticipo -->
														</label>
													</div>
													<div class="col-md-3 col-sm-2 col-xs-12" id="divRegulaAnticipo" style="display: none">
														<label>
														  <input type="radio" name="operAnticipo" value="2">  Regularización de anticipo<br>
<!-- 														<input type="checkbox" name="operRegulaAnticipo" id="operRegulaAnticipo"  /> -->
														</label>
													</div>
												</div>
											</div>
											<div class="x_panel" id="grillaAnticipos" style="display: none">
                                                    <div class="x_content">
                                                    	<div class="container_fluid">
                                                    		<div class="row">
																<div class="form-group">
			                                                    	<div class="col-md-2 col-sm-2 col-xs-12">
																		<button type="button" class="btn btn-primary" data-toggle="modal"  id="btnAnticipos">+ Anticipos</button>
																	</div>
																</div>
															</div>	
                                                    		<div class="table-responsive">
                                                    			<table id="lstAnticipos" name="lstAnticipos" class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
                                                    				<thead>
                                                    					<tr>
                                                    						<th><input type="checkbox" id="check-all" class="flat"></th>
                                                    						<th>ACCIONES</th>
                                                    						<th>Tipo de CP</th>
                                                    						<th>Serie de CP</th>
                                                    						<th>Numero de CP</th>
                                                    						<th>Fecha de CP</th>
                                                    						<th>Valor anticipo</th>
                                                    						<th>IGV anticipo</th>
                                                    						<th>Total anticipo</th>
                                                    						<th>Monto a utilizar</th>
                                                    						<th>Monto pendiente</th>
                                                    					</tr>
                                                    				</thead>
                                                    				<tbody>
                                                    				</tbody>
                                                    			</table>
                                                    		</div>
                                                    	</div>
                                                    </div>
                                            </div>        
											
																								
											<br>
											<%@include file="../../template/RegistroVenta/GrillaRegistroVenta.jsp"%>
											<%@include file="../../template/Pie/DatosResultado.jsp"%>
											
											
											<!-- /page content -->
										</div>
										
										
										
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProccess"><span>Guardar</span></button>
										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProccessCot" style="display: none"><span>Guardar</span></button>
										<button class="btn btn-danger ladda-button" data-style="expand-right" type="button" id="btnVistaPrevia"><span>Vista Previa</span></button>
										<button class="btn btn-success ladda-button" data-style="expand-right" type="button" id="btnSalirVta"><span>Salir</span></button>
<!-- 										<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProccess2"><span>Imprimir</span></button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			<%@include file="../Venta/ModalAnticipos.jsp"%>
			<%@include file="../Global/footer.jsp"%>
			<%@include file="../Venta/DocAnticipo.jsp"%>
			<%@include file="../Venta/FormaPago.jsp"%>
			<%@include file="../Venta/ListaProducto.jsp"%>
			<%@include file="../Venta/ListaServicio.jsp"%>
			<%@include file="../../template/RegistroVenta/modalNotaBuscarDoc.jsp"%>
			<%@include file="../../template/RegistroVenta/modalVistaPrevia.jsp"%>
			<%@include file="../Venta/ModalCliente.jsp"%>
			
			
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
			<script src="../resources/vendors/bootstrap-datepicker/js/jquery-ui.min.js"></script>
			<script src="<c:url value='../resources/v1/RegistroVenta.js'/>" type="text/javascript"></script>
<%-- 			<script src="<c:url value='../resources/v1/ClienteController.js'/>" type="text/javascript"></script> --%>
<%-- 			<script src="<c:url value='../resources/v1/CotizacionController.js'/>" type="text/javascript"></script> --%>
<%-- 			<script src="<c:url value='../resources/v1/VendedorController.js'/>" type="text/javascript"></script> --%>
			<!-- Include Date Range Picker -->
			<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
			<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
			

				<%@include file="../Venta/ModalEditarGrillaVenta.jsp"%>

<style type="text/css">
  .confondo {
   background-color: #def;
 }				
  </style>
		 
			
			<script type="text/javascript">
					$(document).on('ready', function () {
						var registroventa = new RegistroVenta();
		                registroventa.init(); 
		                
//		                var cotizacion = new Cotizacion();
//		                cotizacion.init(); 
		                
//		                cotizacion.lstDataTableProductoVenta = registroventa.lstDataTableProductoVenta;
		            });
	            </script>
</body>
</html>
