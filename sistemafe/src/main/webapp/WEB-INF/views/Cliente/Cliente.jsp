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
							<!-- 							<h3>Servicio</h3> -->
						</div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">
									<!-- Button trigger modal -->
									<a href="../cliente/crearcliente">
										<button type="button" class="btn btn-primary"
											id="btningempresa"> Nueva Persona </button>
									</a>
									<!-- 									<br/> -->
									<div class="row">
										<!-- 							<div class="table-responsive">                                                -->
										<div class="container_fluid">
											<br />
											<form method="GET" id="frm_filtrarCliente"
												name="frm_filtrarCliente" action="" novalidate>
												<div class="row">
													<div class="col-md-12 col-sm-12 col-xs-12"
														id="dropdown_filtro_filtrosBasicos">
														 <fieldset class="fielset-filtros">
															<!-- 					                                                        <legend>Filtros de Empresa</legend> -->
															<div class="row">
																<div class="col-md-12 col-sm-12 col-xs-12 form-group">
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmCodComercial" class="control-label">Nombres:</label> <input type="text"
																			name="frmUserFiltroRasSocial"
																			id="frmUserFiltroRasSocial"
																			class="form-control input-sm filter-single" value=""
																			maxlength="100">
																	</div>
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmNomProducto" class="control-label">DNI:</label>
																		<input type="text" name="frmUserFiltroNroDoc"
																			id="frmUserFiltroNroDoc"
																			class="form-control input-sm filter-single" value=""
																			maxlength="100">
																	</div>
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmProdFiltroEstado" class="control-label">Estado:</label>
																		<select style="width: 100%"
																			class="form-control filter-single input-sm select2-single"
																			id="frmUserFiltroEstado" name="frmUserFiltroEstado">
																			<option value="">Ver Todos</option>
																			<c:forEach items="${listaCatDetEstado}"
																				var="listaCatDetEstado">
																				<option value="${listaCatDetEstado.catdCident}">${listaCatDetEstado.catdVdescription}</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div
																		class="col-md-3 col-sm-6 col-xs-12 search-btn text-right">
																		<br />
																		<button type="button"
																			class="btn btn-info ladda-button" data-size="s"
																			data-style="expand-right"
																			data-spinner-color="#ffffff" id="btn_search">
																			<span class="ladda-label">Buscar</span>
																		</button>
																		<button type="reset" class="btn btn-success"
																			id="btn_clean">Limpiar</button>
																	</div>
																</div>
															</div>
														</fieldset> 
													</div>
												</div>
											</form>
											<!-- 					                                </div> -->



										</div>
										<!-- 					                <input style="display: none" type="hidden" id="pers_bidentUser"  -->
										<%-- 										name="pers_bidentUser" required="" value="${usuario.persBident}" /> --%>
										<div class="container_fluid">
											<div class="table-responsive">
												<!--                  				<div class="row"> -->

												<table id="lstCliente" name="lstCliente"
													class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
													cellspacing="0" width="100%">
													<thead>
														<tr>
															<th><input type="checkbox" id="check-all"
																class="flat"></th>
															
															<th>N° Documento</th>
															<th>Nombre Completo</th>
															<th>Foto</th>
															<th>Localidad</th>
															<th>Sexo</th>
															
                                                  			 <th>Edad</th>
                                                  			 <th>Fecha Ult. Visto</th>
                                                  			 <th>Estado</th>
                                                  			 <th>Contacto</th>
                                                  			 <th>Detalle</th>
                                                  			 
															
														</tr>

													</thead>
													<!-- 										<tbody> -->
													<!-- 										</tbody> -->
												</table>

											</div>
										</div>
										<!-- 						</div> -->
									</div>
								</div>
							</div>
							<!-- Modal -->
							<div class="container_fluid">
								<div class="table-responsive">
									<div class="modal fade" id="frmmodalEditarCliente"
										tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog modal-lg" role="document">
											<div class="modal-content">
												<div class="x_panel">
													<div class="x_title">
														<h2>
															Persona <small>Detalle</small>
														</h2>
														<div class="clearfix"></div>
													</div>
													<div class="x_content">
												<%-- 	<%@include file="../../template/Cliente/Cliente.jsp"%>  --%>
														<%@include file="../../template/Persona/VerPersona.jsp"%>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-5">
														<button type="button" class="btn btn-success"
															data-dismiss="modal">Salir</button>
															
													</div>
												</div>
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
		</div>
	</div>

	<%@include file="../Global/footer.jsp"%>
	<script src="<c:url value='../resources/v1/ClienteController.js'/>"
		type="text/javascript"></script>


	<script src="../resources/js/jquery.validate.js"></script>
	<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
	<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>

	<script src="../resources/js/util/global.js"></script>
	
	
	<script type="text/javascript">
		$(document).on('ready', function() {
			var cliente = new Cliente();
			cliente.init();
		});
	</script>
</body>
</html>




