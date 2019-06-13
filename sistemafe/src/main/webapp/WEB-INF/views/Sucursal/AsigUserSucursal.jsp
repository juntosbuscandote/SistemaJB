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
<link rel="stylesheet" href="../resources/jstree/themes/default/style.min.css" />
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
									<h2>Usuarios por sucursales</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content"><input type="hidden"
										id="fProcess" value="${fProcess}" />
										<form method="GET" id="frm_filtrarUsuario" name="frm_filtrarUsuario" action="" novalidate>
										<input type="hidden" value="" id="idSucursal" name="idSucursal"> 
										<input type="hidden" value="" id="idMostrarDetVenta" name="idMostrarDetVenta">
										<input type="hidden" value="" id="idModificar" name="idModificar">
										<div class="row">
											<div class="col-md-3 col-sm-3 col-xs-3"></div>
											<div class="col-md-6 col-sm-6 col-xs-6">
												<div class="x_panel">
													<div class="row">
														<div class="col-lg-12 col-md-12 col-xs-12 form-group">
															<label class="control-label" for="natural_vname">Sucursales:</label> 
															 <select style="width:100%" class="form-control filter-single input-sm" id="grupocom_vmodule" name="grupocom_vmodule" disabled="disabled">
<!-- 																<option value="">Ver Todos</option> -->
																<c:forEach items="${listaSucursales}" var="modu">
																	<option value="${modu.offiBident}">${modu.offiVname}</option>
																</c:forEach>
															</select>
														</div>
													</div>
<!-- 													<button class="btn btn-primary ladda-button" -->
<!-- 											data-style="expand-right" type="button" id="btnUsuarioListar"> -->
<!-- 											<span>Listar Usuarios</span> -->
<!-- 										</button> -->
												</div>
											</div>
											</div>
											
											
											<div class="row">
											<div class="col-md-3 col-sm-3 col-xs-3"></div>
											<div class="col-md-6 col-sm-6 col-xs-6">
												<div class="x_panel">
<!-- 												<label class="control-label" for="natural_vname">Usuarios:</label>  -->
													<div class="row">

<!-- 													<br/> -->
															<div class="col-md-4 col-sm-4 col-xs-12 form-group">
															
					 			   <label for="frmUserFiltroUsuario" class="control-label">Usuario:</label>
				           			   <input type="text" name="frmUserFiltroUsuario" id="frmUserFiltroUsuario" class="form-control input-sm filter-single" value="" maxlength="45">
				           			</div>
				           			<div class="col-md-4 col-sm-4 col-xs-12 form-group">
					 			   <label for="frmUserFiltroNombre" class="control-label">Nombres:</label>
				           			   <input type="text" name="frmUserFiltroNombre" id="frmUserFiltroNombre" class="form-control input-sm filter-single" value="" maxlength="150">
				           			</div>
				           			<br/>
                                       <div class="col-md-4 col-sm-4 col-xs-12 form-group">
				           			<button type="button" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_search"><i class="fa fa-search"></i></button>
					                <button type="reset" class="btn btn-success" id="btn_clean"><i class="fa fa-trash"></i></button>
                                                      </div>
													</div>
												</div>
											</div>  
<!-- 											<div class="col-md-3 col-sm-3 col-xs-3"></div> -->
										</div>
										
										</form>
					</div>
									<%@include file="../../template/Usuario/GrillaUsuario.jsp"%>
									<div class="progress-demo">
										<button class="btn btn-primary ladda-button"
											data-style="expand-right" type="button" id="btnSucursalxUsuario">
											<span>Guardar</span>
										</button>
										<button type="button" class="btn btn-success" id="btnSalirUserSucursal"
											name="btnSalirUserSucursal">Salir</button>
									</div>
								</div>
							</div>
						</div>
					</div> 
					<!-- /page content -->
				</div>
			</div>
		</div>
<!-- 	</div> -->

	<%@include file="../Global/footer.jsp"%>
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<script src="../resources/js/jquery.validate.js"></script>
	<script src="../resources/jstree/jstree.js"></script>
	
	<script type="text/javascript"
		src="../resources/v1/GrupoComercialController.js"></script>
		<script type="text/javascript"
		src="../resources/v1/SucursalController.js"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			var grupoComercial = new GrupoComercial();
			grupoComercial.init();
			grupoComercial.listModulos();
		});
		
		$(document).on('ready', function() {
			var sucursal = new Sucursal();
			sucursal.init();
		});
		
	</script>
</body>
</html>