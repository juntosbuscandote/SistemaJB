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
									<a href="../vendedor/crearvendedor">
									<button type="button" class="btn btn-primary"
									id="btningempresa">Crear Vendedor</button>
									</a>
<!-- 									<br/> -->
							<div class="row">
<!-- 							<div class="table-responsive">                                                -->
                                        			<div class= "container_fluid">
                                        			
									<!-- Filter Producto-->
									<!--
					                    <div class="container-fluid" id="filterSection">
					                        <div class="filter-block ">
					                            <div class="dropdown" id="dropdown_f">
					                                <button id="btnBuscar" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-success" aria-expanded="false">Buscar</button>
					                                <div class="dropdown-menu dropdown_filtro" aria-labelledby="dLabel" aria-expanded="true" style="width:290px">
					                                    <form method="GET" id="frm_filtrarEmpresa" name="frm_filtrarEmpresa" action="" novalidate>
					                                        <div>
					                                            <div class="row">
					                                                <div class="col-md-12" id="dropdown_filtro_filtrosBasicos">
					                                                    <fieldset class="fielset-filtros">
					                                                        <legend>Filtros de Empresa</legend>
					                                                        <div class="row">
					                                                        <div class="col-md-12 form-group">
					                                                            <div class="col-md-12 form-group">
					                                                                <label for="frmEmpFiltroRazSocial" class="control-label">Razón Social</label>
					                                                                <input type="text" name="frmEmpFiltroRazSocial" id="frmEmpFiltroRazSocial" class="form-control input-sm filter-single" value="" maxlength="200">
					                                                            </div>
					                                                            <div class="col-md-12 form-group">
					                                                                <label for="frmEmpFiltroRuc" class="control-label">Ruc</label>
					                                                                <input type="text" name="frmEmpFiltroRuc" id="frmEmpFiltroRuc" class="form-control input-sm filter-single" value="" maxlength="11">
					                                                            </div>
					                                                            <div class="col-lg-12 col-md-12 col-xs-12 form-group">
					                                                                <label for="frmEmpFiltroEstado" class="control-label">Estado</label>
					                                                                <select style="width:100%" class="form-control filter-single" id="frmEmpFiltroEstado" name="frmEmpFiltroEstado">
					                                                                    <option value="">Ver Todos</option>
					                                                                    <option value="1">Activo</option>
					                                                                    <option value="2">Inactivo</option>
					                                                                </select>
					                                                            </div>
					
					                                                        </div>
					                                                        </div>
					                                                    </fieldset>
					
					
					                                                </div>
					                                                
					                                            </div>
					                                            <div class="row">
					                                                <div class="col-md-5 col-sm-6 form-group">
					                                                </div>
					                                                <div class="col-md-7 col-sm-6 search-btn text-right">
					                                                    <button type="reset" class="btn btn-default" id="btn_clean">Limpiar</button>
					                                                    <button type="button" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_search"><span class="ladda-label">Aplicar</span></button>
					                                                </div>
					                                            </div>
					                                        </div>
					                                    </form>
					                                </div>
					                            </div>
					                        </div>
					                    </div> 
					                    -->
					                    <!-- ./Filtro Producto --> 
<!-- 					                    			<div class="x_panel"> -->
														<br/>
					                                    <form method="GET" id="frm_filtrarVendedor" name="frm_filtrarVendedor" action="" novalidate>
					                                            <div class="row">
					                                                <div class="col-md-12 col-sm-12 col-xs-12" id="dropdown_filtro_filtrosBasicos">
					                                                    <fieldset class="fielset-filtros">
<!-- 					                                                        <legend>Filtros de Empresa</legend> -->
					                                                        <div class="row">
					                                                        <div class="col-md-12 col-sm-12 col-xs-12 form-group">
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frm_filtrarVendedor_NroDoc" class="control-label">Nro. Documento:</label>
					                                                                <input type="text" name="frm_filtrarVendedor_NroDoc" id="frm_filtrarVendedor_NroDoc" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frm_filtrarVendedor_Nom" class="control-label">Nombre:</label>
					                                                                <input type="text" name="frm_filtrarVendedor_Nom" id="frm_filtrarVendedor_Nom" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                            <div class="col-md-3 col-sm-6 col-xs-12 form-group">
					                                                                <label for="frm_filtrarVendedor_Estadogfd" class="control-label">Estado:</label>
					                                                                 <select style="width: 100%"
																						class="form-control filter-single input-sm select2-single"
																						id="frm_filtrarVendedor_Estado" name="frm_filtrarVendedor_Estado">
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
<!-- 					                <input style="display: none" type="hidden" id="pers_bidentUser"  -->
<%-- 										name="pers_bidentUser" required="" value="${usuario.persBident}" /> --%>
									<div class= "container_fluid">
									<div class="table-responsive">                                               
<!--                  				<div class="row"> -->
									
									<table id="lstVendedor" name="lstVendedor"
										class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th><input type="checkbox" id="check-all" class="flat"></th>
												<th>Tipo de Doc.</th>
												<th>Nro. de Doc.</th>
												<th>Nombres Completos</th>
												<th>Dirección</th>
												<th>Teléfono</th>
												<th>Correo</th>
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
									<div class= "container_fluid">
									<div class="table-responsive">  
									<div class="modal fade" id="modalVerVendedor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog modal-lg" role="document">
											<div class="modal-content">
												<div class="x_panel">
													<div class="x_title">
														<h2>
															Vendedor 
														</h2>
														<div class="clearfix"></div>
													</div>
													<div class="x_content">
														<%@include file="../../template/Persona/VerPersona.jsp"%>
													</div>
													<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-5">
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
		<script src="<c:url value='../resources/v1/VendedorController.js'/>"
			type="text/javascript"></script>
		<script src="../resources/js/bootbox.min.js"></script>

		

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
				var vendedor = new Vendedor();
				vendedor.init();
			});
		</script>						
</body>
</html>




