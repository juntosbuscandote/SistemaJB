<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<%@include file="../Global/header.jsp" %>
<body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="../Global/nav.jsp" %>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title" > <!--style="display: none"--> 
                                        <h2> Administrar Usuarios</h2>
                                        <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                        <a href="../usuario/administrarusuario"  id="agregar" name="agregar">
                                        </a>
		                   <div class="row">
                                        	<!-- ./Filtro  -->
                                        	
                                        	<!-- Filter usuario -->
                            <br/>			        
				        	<form method="GET" id="frm_filtrarUsuario" name="frm_filtrarUsuario" action="" novalidate>
				 			      <div class="row">
					 			<div class="col-md-2 col-sm-4 col-xs-12 form-group">
					 			   <label for="frmUserFiltroUsuario" class="control-label">Usuario:</label>
				           			   <input type="text" name="frmUserFiltroUsuario" id="frmUserFiltroUsuario" class="form-control input-sm filter-single" value="" maxlength="45">
				           			</div>
				           			<div class="col-md-2 col-sm-4 col-xs-12 form-group">
					 			   <label for="frmUserFiltroNombre" class="control-label">Nombre Completo:</label>
				           			   <input type="text" name="frmUserFiltroNombre" id="frmUserFiltroNombre" class="form-control input-sm filter-single" value="" maxlength="150">
				           			</div>
				           			<div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                   <label for="frmUserFiltroPerfil" class="control-label">Perfil:</label>
														<select style="width: 100%" class="form-control filter-single input-sm select2-single" id="frmUserFiltroPerfil" name="frmUserFiltroPerfil"/>
															<option value="">Ver Todos</option>
															<c:forEach items="${listaProfile}" var="profil">
																<option value="${profil.profBident}">${profil.profVname}</option>
															</c:forEach>
														</select>
					                               </div>
					                               <div class="col-md-2 col-sm-4 col-xs-12 form-group" id="InpEmpresa" hidden="true">
					                                  <label for="frmUserFiltroEmpresa" class="control-label">Contacto:</label>
					                                  <input type="text" name="frmUserFiltroEmpresa" id="frmUserFiltroEmpresa" class="form-control input-sm filter-single" value="" maxlength="100">
					                              </div>
					                              <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                   <label for="frmUserFiltroEstado" class="control-label">Estado:</label>  
					                                  <select class="form-control filter-single input-sm select2-single" id="frmUserFiltroEstado" name="frmUserFiltroEstado"/>
														  <option value="">Ver Todos</option>
														  <c:forEach items="${listaCatDetEstado}" var="listestado"> 
														  <option  	value="${listestado.catdCident}">${listestado.catdVdescription}</option>
														  </c:forEach> 
													   </select>
															 
					                               </div>
					                               <div class="col-md-2 col-sm-4 col-xs-12 search-btn text-right">
					                               <br/>
					                               <button type="button" class="btn btn-warning ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_search">Buscar</button>
					                               <button type="reset" class="btn btn-success" id="btn_clean">Limpiar</button>
					                           </div>
					
<!-- 					                           </div> -->
					                           </div>
<!-- 					                           </fieldset> -->
										
<!-- 					                        </div> -->
					                                                
					              </form>
					              
					              
					              <br/>
								  <!-- ./Filtro  -->
                                        	
                                       <%@include file="../../template/Usuario/GrillaUsuario.jsp"%>


                                        <!-- Modal registro de usuario -->
                                        <!-- Modal -->
									<div class="modal fade" id="frmmodalEditarUsuario"
										tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
										<div class="modal-dialog modal-lg" role="document">
											<div class="modal-content">
												<div class="x_panel">
													<div class="x_title">
														<h2>
															Usuario
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
                                        <!-- End Modal -->
                                    </div>
                                </div>	
<!--                             </div> -->
<!--                         </div> -->

                    </div>
                </div>
                <!-- /page content -->
 
              </div>
        	   </div>
            </div>
           </div>
          </div>
         </div>
        </div>

        <%@include file="../Global/footer.jsp" %>


        <script>

        </script>
        <!-- /Datatables -->
        <script>

        </script>

        <script src="<c:url value='../resources/v1/UsuarioController.js'/>" type="text/javascript"></script>
		<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
		<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
        <script type="text/javascript">
			$(document).on('ready', function() {
				var usuario = new Usuario();
				usuario.init();
				
			});
		</script>	
    </body>
</html>
