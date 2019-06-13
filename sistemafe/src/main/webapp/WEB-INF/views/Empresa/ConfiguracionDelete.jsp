<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="../Global/header.jsp"%>
<link href="../resources/vendors/sweetalert/sweet-alert.css"> 
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/cmxform.css" rel="stylesheet">
<link href="../resources/dist/css/cmxformTemplate.css" rel="stylesheet">
<link href="resources/dist/css/reset.css" rel="stylesheet">
<!-- <link href="../resources/dist/css/screen.css" rel="stylesheet"> -->
<link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css" />

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Empresa</h3>
						</div>
						<div class="title_right"></div>
					</div>
					<div class="clearfix"></div>
					<div class="row" id="modalCrearEmpresa">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
<!-- 								<div class="x_title"> -->
<!-- 									<h2> -->
<!-- 										Configuracion General<small></small> -->
<!-- 									</h2> -->
<!-- 									<div class="clearfix"></div> -->
<!-- 								</div> -->
								<div class="x_content">

									<div id="myTabContent" class="tab-content">
										<div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
										<input type="hidden"  id="fProcesss" value="${fProcesss}" />
											<div class="modal fade" id="modalVista" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="x_panel">
                                                        <div class="x_content">
                                                        
                                                        
                                                      
                            											<form class="form-horizontal form-label-left" id="frmbussines" name="frmbussines">

										<input style="display: none" type="hidden" id="busi_bcod"
											name="busi_bcod" required="" value="${oDtoEmpresa.busiBcod}" />
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_vbusiname">Razón Social :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
								 		<input style="display: none" type="hidden" class="form-control" id="busi_vbusiname"
											name="busi_vbusiname" placeholder="Razón Social" required=""
											value="${oDtoEmpresa.busiVbusiname}" /> 
										</div>
										</div>
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_vruc">Ruc :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input style="display: none" type="hidden"
											class="form-control" id="busi_vruc" name="busi_vruc"
											placeholder="Ruc" required="" maxlength="11" value="${oDtoEmpresa.busiVruc}" />
										</div>
										</div>
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_vaddress">Dirección :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input style="display: none" type="hidden" class="form-control" id="busi_vaddress"
											name="busi_vaddress" placeholder="Dirección" required=""
											value="${oDtoEmpresa.busiVaddress}" />
										</div>
										</div>
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_vemail">Correo Electronico :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input style="display: none" type="hidden" class="form-control" id="busi_vemail"
											name="busi_vemail" placeholder="Correo Electronico"
											required="" value="${oDtoEmpresa.busiVemail}" />
										</div>
										</div>
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_vphone">Telefono / Celular :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input style="display: none" type="hidden" class="form-control" id="busi_vphone"
											name="busi_vphone" placeholder="Telefono / Celular"
											required="" value="${oDtoEmpresa.busiVphone}" />
										</div>
										</div>
										<div class="form-group">
<!-- 										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="busi_cstate">Estado :</label> -->
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input style="display: none" type="hidden" class="form-control" id="busi_cstate"
											name="busi_cstate" placeholder="Estado"
											value="${oDtoEmpresa.busiState}" />
										</div>
										</div>
										<div align="center">
										<p>ESCRIBE ALGO AQUI</p>
											<button class="btn btn-primary btnconf ladda-button"  type="button" id="btnProccess"  data-style="expand-right">Guardar</button>
										</div>     
									</form>
									  
                                							
                                							
                            
                                                        <div class="ln_solid"></div>

                                                        </div>
                                                        
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>
        
									
									
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /page content -->
					<!-- footer content -->
				</div>
				</div>
				<footer>
					<div class="pull-right">
						2019 - Todos los derechos reservados
					</div>
					<div class="clearfix"></div>
				</footer>
				<!-- /footer content -->
			
		</div>
	</div>
	<%@include file="../Global/footer.jsp"%>
    <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<script src="../resources/vendors/sweetalert/sweetalert2.all.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <script src="../resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="../resources/v1/EmpresaController.js"></script>
	

<script type="text/javascript">
		$(document).on('ready', function() {
			var empresaestado = new EmpresaEstado();
			empresaestado.init();
		});
	</script>
	

	
</body>
</html>