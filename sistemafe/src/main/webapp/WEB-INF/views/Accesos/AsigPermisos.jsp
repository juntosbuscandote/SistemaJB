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
									<h2>Configuracion</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content"><input type="hidden"
										id="fProcess" value="${fProcess}" />
										
										<div class="row">
											<div class="col-md-3 col-sm-3 col-xs-3"></div>
											<div class="col-md-6 col-sm-6 col-xs-6">
												<div class="x_panel">
													<div class="row">
														<div class="col-lg-12 col-md-12 col-xs-12 form-group">
															<label class="control-label" for="natural_vname">Nombre del Perfil:</label> 
															<input type="text" class="form-control" id="grupocom_vname" name="grupocom_vname" placeholder="Nombres"  value="${nombrePerfil}" maxlength="100" readonly="readonly" />
														</div>
													</div>
													<div class="row">
														<div class="col-lg-12 col-md-12 col-xs-12 form-group">
															<label class="control-label" for="natural_vname">Modulo:</label> 
															 <select style="width:100%" class="form-control filter-single input-sm" id="grupocom_vmodule" name="grupocom_vmodule">
																<option value="">Ver Todos</option>
																<c:forEach items="${listaModulos}" var="modu">
																	<option value="${modu.moduBident}">${modu.moduVlabel}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-12 col-md-12 col-xs-12 form-group">
															<label class="control-label" for="natural_vname">Descripción:</label> 
															<textarea maxlength="250" id="grupocom_vdescrip" name="grupocom_vdescrip" class="form-control valid" rows="4" style="resize: none;" aria-invalid="false" readonly="readonly" ><c:out value="${descrPerfil}" /></textarea>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-3 col-sm-3 col-xs-3"></div>
										</div>
					
									<%@include file="../../template/Accesos/confasigPerfiles.jsp"%>
									<div class="progress-demo">
										<button class="btn btn-primary ladda-button"
											data-style="expand-right" type="button" id="btnProccessMod">
											<span>Guardar</span>
										</button>
										<button type="button" class="btn btn-success" id="btnSalir"
											name="btnSalir">Salir</button>
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
		src="../resources/v1/PerfilController.js"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			var perfil = new Perfiles();
			perfil.init();
			perfil.listPerfiles();
		});
	</script>
</body>
</html>