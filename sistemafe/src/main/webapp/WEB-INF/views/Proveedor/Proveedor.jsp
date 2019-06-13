<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">

<link rel="stylesheet" href="../resources/vendors/bootstrap-datepicker/css/jquery-ui.css">
<link rel="stylesheet" href="../resources/vendors/nprogress/support/style.css">
<link rel="stylesheet" href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet" href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
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
						</div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">
									<!-- Button trigger modal -->
									<a href="../proveedor/crearproveedor">
									<button type="button" class="btn btn-primary"
									id="btningempresa">Crear Proveedor</button>
									</a>
							<div class="row">
                                        			<div class= "container_fluid">
														<br/>
					                                    <form method="GET" id="frm_filtrarProveedor" name="frm_filtrarProveedor" action="" novalidate>
					                                            <div class="row">
					                                                <div class="col-md-12 col-sm-12 col-xs-12" id="dropdown_filtro_filtrosBasicos">
					                                                    <fieldset class="fielset-filtros">
					                                                        <div class="row">
					                                                        <div class="col-md-12 col-sm-12 col-xs-12 form-group">
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frmProveedorFiltroRazSocial" class="control-label">R.Social / Nombres:</label>
					                                                                <input type="text" name="frmProveedorFiltroRazSocial" id="frmProveedorFiltroRazSocial" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frmProveedorFiltroNroDoc" class="control-label">RUC:</label>
					                                                                <input type="text" name="frmProveedorFiltroNroDoc" id="frmProveedorFiltroNroDoc" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frmProveedorFiltroEstado" class="control-label">Estado:</label>
					                                                                 <select style="width: 100%"
																						class="form-control filter-single input-sm select2-single"
																						id="frmProveedorFiltroEstado" name="frmProveedorFiltroEstado">
																						<option value="">Ver Todos</option>
																						<c:forEach items="${listaCatDetEstado}" var="listaCatDetEstado">
																							<option value="${listaCatDetEstado.catdCident}">${listaCatDetEstado.catdVdescription}</option>
																						</c:forEach>
																					</select>
					                                                            </div>
																	<div class="col-md-3 col-sm-6 col-xs-12 search-btn text-right">
																	<br/>
																		<button type="button" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_search"><span class="ladda-label">Buscar</span></button>
					                                                    <button type="reset" class="btn btn-success" id="btn_clean">Limpiar</button>
					                                                </div>
					                                                        </div>
					                                                        </div>
					                                                    </fieldset>
					                                                </div>
					                                            </div>
					                                    </form>
<!-- 					                                </div> -->
					                    
					                      
					                    
					                </div>
									<div class= "container_fluid">
									<div class="table-responsive">
									
									<table id="lstProveedor" name="lstProveedor"
										class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th><input type="checkbox" id="check-all" class="flat"></th>
												<th>Tipo de Doc.</th>
												<th>Nro. de Doc.</th>
												<th>Razón Social/Nombres Completos</th>
												<th>Dirección</th>
												<th>Teléfono</th>
												<th>Correo</th>
												<th>Estado</th>
												<th>Acciones</th>					
											</tr>

										</thead>
									</table>
				
								</div>
							</div>
					</div>
				</div>
				</div>
				<!-- Modal -->
									<div class= "container_fluid">
									<div class="table-responsive"> 
									<div class="modal fade" id="frmmodalDetalleProveedor"
										tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog modal-lg" role="document">
											<div class="modal-content">
												<div class="x_panel">
													<div class="x_title">
														<h2>
															Proveedor
														</h2>
														<div class="clearfix"></div>
													</div>
													<div class="x_content">
														<%@include file="../../template/Persona/VerPersona.jsp"%>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12" align="center">
														<div class="clearfix"></div>
								                                                   <button type="button" class="btn btn-success" data-dismiss="modal">Salir</button>
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
		 <%@include file="../Global/ubigeo.jsp" %>
		<script src="<c:url value='../resources/v1/ProveedorController.js'/>"
		type="text/javascript"></script>
		 <script src="<c:url value='../resources/v1/ProveedorController.js'/>" type="text/javascript"></script>
        <script src="<c:url value='../resources/v1/PersonaController.js'/>" type="text/javascript"></script>	   
        <script src="../resources/vendors/dist/spin.min.js"></script>
		<script src="../resources/vendors/dist/ladda.min.js"></script>
		<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.10.3/sweetalert2.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	    <script src="../resources/js/jquery.validate.js"></script>
	    <script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
	<!--                 <script src="../resources/vendors/select2/docs/vendor/js/bootstrap.min.js"></script> -->
	    <script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>   
	  	<script src="../resources/js/util/global.js"></script>              
               
		<script type="text/javascript">
		$(document).on('ready', function() {
			var personaController = new PersonaController();
			personaController.init();
			var proveedor = new Proveedor();
			proveedor.objPerson=personaController;
			proveedor.init();
		});
	</script>			
</body>
</html>