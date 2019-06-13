<%@page import="pe.am.spring.controller.EmpresaController"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="en">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<%@include file="../Global/header.jsp"%>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Modulo Accesos<small></small>
									</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<!-- Button trigger modal -->
									<a href="../perfiles/crearPerfil">
									<button type="button" class="btn btn-primary"
									id="btningGrupoCom">Crear Perfil</button>
									</a>
<!-- 									<br/> -->
							<div class="row">
                                        			<div class= "container_fluid">
                                        			
														<br/>
					                                    <form method="GET" id="frm_filtrarPerfil" name="frm_filtrarPerfil" action="" novalidate>
					                                            <div class="row">
					                                                <div class="col-md-12 col-sm-12 col-xs-12" id="dropdown_filtro_filtrosBasicos">
					                                                    <fieldset class="fielset-filtros">
<!-- 					                                                        <legend>Filtros de Empresa</legend> -->
					                                                        <div class="row">
					                                                        <div class="col-md-12 col-sm-12 col-xs-12 form-group">
					                                                            <div class="col-md-4 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frmPerfilFiltroNombre" class="control-label">Perfil:</label>
					                                                                <input type="text" name="frmPerfilFiltroNombre" id="frmPerfilFiltroNombre" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                            <div class="col-md-4 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frmPerfilFiltroEstado" class="control-label">Estado:</label>

					                                                                <select style="width:100%" class="form-control filter-single input-sm" id="frmPerfilFiltroEstado" name="frmPerfilFiltroEstado">
																						<option value="">Ver Todos</option>
																						<c:forEach items="${listaCatDetEstado}" var="det">
																							<option value="${det.catdCident}">${det.catdVdescription}</option>
																						</c:forEach>
																					</select>
					                                                            </div>
																				<div class="col-md-4 col-sm-6 col-xs-12 search-btn text-right">
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
									
									<table id="lstPerfil" name="lstPerfil"
										class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>#</th>
												<th>Perfil</th>
												<th>Descripción</th>
												<th>Estado</th>
												<th>Acciones</th>
											</tr>

										</thead>
										<tbody>
										</tbody>
									</table>
				
								</div>
							</div>
<!-- 						</div> -->
					</div>
				</div>
				</div>
				<!-- Modal -->
									<div class="modal fade" id="frmmodalEditarEmpresa"
										tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
														<%@include file="../../template/Empresa/VerEmpresa.jsp"%>
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
		<script src="<c:url value='../resources/v1/PerfilController.js'/>"
			type="text/javascript"></script>
		<script src="../resources/js/bootbox.min.js"></script>
		<script src="../resources/jstree/jstree.js"></script>
	<%--  	<%@include file="../Global/modalSunat.jsp"%> --%>
		<%@include file="../Global/ubigeo.jsp"%>
		

<!--     FastClick -->
<!--     <script src="../resources/vendors/fastclick/lib/fastclick.js"></script> -->
<!--     NProgress -->
<!--     <script src="../resources/vendors/nprogress/nprogress.js"></script> -->
<!--     jQuery Smart Wizard -->
<!--     <script src="../resources/vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script> -->
<!--     Custom Theme Scripts -->
<!--     <script src="../resources/build/js/custom.min.js"></script> -->

		<script type="text/javascript">
			$(document).on('ready', function() {
				var perfiles = new Perfiles();
				perfiles.init();
			});
		</script>						
</body>
</html>




