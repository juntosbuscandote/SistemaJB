<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<%@include file="../Global/header.jsp"%>

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
								<div class="x_title">
									<h2>
										Sucursal<small></small>
									</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<!-- Button trigger modal -->
									<a href="../sucursal/crearsucursal">
										<button type="button" class="btn btn-primary" id="btnsucursal">Crear Sucursal</button>
									</a>
									<div class="row">
										<div class="container_fluid">
											<br />
											<form method="GET" id="frm_filtrarSucursal" name="frm_filtrarSucursal" action="" novalidate>
												<div class="row">
													<div class="col-md-12 col-sm-12 col-xs-12" id="dropdown_filtro_filtrosBasicos">
														<fieldset class="fielset-filtros">
															<!-- 					                                                        <legend>Filtros de Empresa</legend> -->
															<div class="row">
																<div class="col-md-12 col-sm-12 col-xs-12 form-group">
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmEmpFiltroRazSocial" class="control-label">Código:</label> 
																		<input type="text" name="frmEmpFiltroCodigo" id="frmEmpFiltroCodigo" class="form-control input-sm filter-single" value=""maxlength="100">
																	</div>
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmEmpFiltroRuc" class="control-label">Nombre:</label>
																		<input type="text" name="frmEmpFiltroNombre" id="frmEmpFiltroNombre" class="form-control input-sm filter-single" value="" maxlength="11">
																	</div>
																	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
																		<label for="frmEmpFiltroEstado" class="control-label">Estado:</label>
																		<select style="width: 100%" class="form-control filter-single input-sm select2-single" id="frmEmpFiltroEstado" name="frmEmpFiltroEstado">
																			<option value="">Ver Todos</option>
																			<c:forEach items="${TlCatalogueDet}" var="TlCatalogueDet">
																				<option value="${TlCatalogueDet.catdCident}" >${TlCatalogueDet.catdVdescription}</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="col-md-3 col-sm-6 col-xs-12 search-btn text-right">
																		<br />
																		<button type="button" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_searchSucursal">
																			<span class="ladda-label"><i class="fa fa-search"></i></span>
																		</button>
																		<button type="reset" class="btn btn-success" id="btn_cleanSucursal"><i class="fa fa-trash"></i></button>
																	</div>
																</div>
															</div>
														</fieldset>
													</div>
												</div>
											</form>
										</div>
										<div class="container_fluid">
											<div class="table-responsive">
												<table id="lstSucursal" name="lstSucursal" class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
													<thead>
														<tr>
															<th><input type="checkbox" id="check-all" class="flat"></th>
															<th>Código</th>
															<th>Nombre</th>
															<th>Nombre Corto</th>
															<th>Teléfono</th>
															<th>Dirección</th>
															<th>Estado</th>
															<th>Acción</th>
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
							<!-- Modal -->
							<div class="modal fade" id="frmmodalSucursal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog modal-lg" role="document">
									<div class="modal-content">
										<div class="x_panel">
											<div class="x_title">
												<h2>
													Empresa <small>Detalles</small>
												</h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<%@include file="../../template/Sucursal/ConfiguracionSucursal.jsp"%>
											</div>
											<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-5">
												<button type="button" class="btn btn-success" data-dismiss="modal">Salir</button>
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
	<script src="<c:url value='../resources/v1/SucursalController.js'/>" type="text/javascript"></script>
	<script src="../resources/js/bootbox.min.js"></script>
	<script type="text/javascript">
			$(document).on('ready', function() {
				var sucursal = new Sucursal();
				sucursal.init();
			});
		</script>
</body>
</html>




