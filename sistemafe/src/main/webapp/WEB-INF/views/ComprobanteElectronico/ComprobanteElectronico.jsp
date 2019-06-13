<%@page import="pe.am.spring.controller.ComprobanteElectronicoController"%>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2.min.css">
<link rel="stylesheet"	href="../resources/vendors/select2/dist/css/select2-bootstrap.css">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<%@include file="../Global/header.jsp" %>
<body class="nav-md">
        <div class="container body">
	<div class="main_container">
                <%@include file="../Global/nav.jsp" %>
                <!-- page content -->               
                <div class="right_col" role="main">               
                    <div class="">
                        <div class="page-title">  
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Documentos Emitidos<small></small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
<!--                                     
<!--                                        	<div class="row"> -->
										<div class="table-responsive">                                               
                                        <div class= "container_fluid">
					                        
					                                    <form method="GET" id="frm_filtrarComprobante" name="frm_filtrarComprobante" action="" novalidate>
					                                                <div class="col-md-12 col-sm-12 col-xs-12">
					                                                    <fieldset class="fielset-filtros">
					                                                    <div class="row">
					                                                            <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosTipo" class="control-label">Tipo de CPE:</label>  
											                                  <select class="form-control filter-single input-sm select2-single" id="frmCPEFiltrosTipo" name="frmCPEFiltrosTipo"/>
																				  <option value="">Ver Todos</option>
																				  <c:forEach items="${listaCatDetTipoCPE}" var="listaCatDetTipoCPE"> 
																				  <option  	value="${listaCatDetTipoCPE.catdCident}">${listaCatDetTipoCPE.catdVdescription}</option>
																				  </c:forEach> 
																			   </select>
																					 
											                               </div>
					                                                            <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosNro" class="control-label">Nro. de CPE:</label>
					                                                                <input type="text" name="frmCPEFiltrosNro" id="frmCPEFiltrosNro" class="form-control input-sm filter-single" value="" maxlength="30">
					                                                            </div>
					                                                            <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosRUC" class="control-label">RUC:</label>
					                                                                <input type="text" name="frmCPEFiltrosRUC" id="frmCPEFiltrosRUC" class="form-control input-sm filter-single" value="" maxlength="11">
					                                                            </div>
					                                                            <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosRazSoc" class="control-label">Razón Social:</label>
					                                                                <input type="text" name="frmCPEFiltrosRazSoc" id="frmCPEFiltrosRazSoc" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                           
					                                                            
					              
					                                                    
					                                                     <div class="col-md-4 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosObs" class="control-label">Descripción:</label>
					                                                                <input type="text" name="frmCPEFiltrosObs" id="frmCPEFiltrosObs" class="form-control input-sm filter-single" value="" maxlength="100">
					                                                            </div>
					                                                    					
					                                                        </div>
					                                                    <div class="row">
					                                                    
					                                                  <!--  <div class="col-md-2 col-sm-4 col-xs-12">
					                                                    	<label for="frmCPEFiltrosResulSunat" class="control-label">Respuesta Sunat:</label>
													                        <select class="form-control filter-single input-sm select2-single" id="frmCPEFiltrosResulSunat" name="frmCPEFiltrosResulSunat"/>
																				  <option value="">Ver Todos</option>
																				  <c:forEach items="${lstCatRptasunat}" var="lstCatRptasunat"> 
																				  <option  	value="${lstCatRptasunat.catdCident}">${lstCatRptasunat.catdVdescription}</option>
																				  </c:forEach> 
																			  </select>
					                                                    </div>
					                                                    
					                                                    		 <div class="col-md-2 col-sm-4 col-xs-12 form-group">
					                                                                <label for="frmCPEFiltrosMontoTotal" class="control-label">Monto Total:</label>
					                                                                <input type="number" name="frmCPEFiltrosMontoTotal" id="frmCPEFiltrosMontoTotal" class="form-control input-sm filter-single" value="" maxlength="30">
					                                                            </div>	
					                                                   
					                                                   
					                                                                                                 <div class="col-md-4 col-sm-4 col-xs-12">
					                                                    	<label class="control-label text-center">Intervalo de Fecha de Emisión:</label><br/>
					                                                    		<div class="input-prepend input-group">
                                  												<span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
					                                                    		<input type="text" name="frmCPEFiltrosfecIniFecFin" id="frmCPEFiltrosfecIniFecFin" class="form-control input-sm filter-single" value="">
                                												</div>
					                                                    </div>
					                                                   -->
					                                                <div class="col-md-4 col-sm-4 col-xs-12 search-btn text-right">
					                                                <br/>
					                                                	<button type="button" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" id="btn_search"><span class="ladda-label">Buscar</span></button>
					                                                    <button type="reset" class="btn btn-success" id="btn_clean">Limpiar</button>
					                                                    <button type="reset" class="btn btn-dark" id="btn_descarga" title="Defina intervalo de fecha antes de descargar"><i class="fa fa-download"></i> Descargar</button>
					                                                </div>
					                                            </div>
					                                                        
					                                                        
					                                                    </fieldset>
					                                               
					                                                </div>
					                                            
					                                    </form>
					                                
					                        <!--  Fin Filter Comprobante -->
					                        
					                    </div>
					                    <br/>					                    
					                    <div class= "container_fluid">
										<div class="table-responsive">                                                  
                                        <table id="lstComprobante" name="lstComprobante"
											class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">

                                            <thead>
                                                <tr>
                                                	<th><input type="checkbox" id="check-all" class="flat"></th>
                                                    <th>Tipo Doc. Electr.</th>
                                                    <th>Nro Doc. Electr.</th>
                                                    <th>Tipo de Doc.</th>
                                                    <th>Nro de Doc.</th>
                                                    <th>Nombre</th>
                                                    <th>Descripción</th>
                                                    <th>Fecha Emisión</th>
                                                   <!--   <th>Moneda</th>-->
                                                    <th>Monto Total</th>
                                                    <th>Estado Interno</th>
                                                   <!--  <th>Enviado a Sunat</th>
                                                    <th>Respuesta Sunat</th>
                                                     -->
                                                     
                                                    <th>XML</th>
                                                    <th>PDF</th>
                                                    <th>CDR</th>
                                                    
                                                    
                                                    
                                                    <th>Opciones</th>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                               
                                            </tbody>
                                        </table>
                                        <!-- Modal -->
                                        <div class="modal fade" id="modalVerDetFact" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="x_panel">
                                                        <div class="x_title">
                                                            <h2>Detalle del Comprobante Electr.</h2>
                                                            <ul class="nav navbar-right panel_toolbox">
                                                                <li><a class="collapse-link" ><i class="fa fa-chevron-up"></i></a>
                                                                </li>
                                                                <li class="dropdown">
                                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                                    <i class="fa fa-wrench"></i></a>
<!--                                                                     <ul class="dropdown-menu" role="menu"> -->
<!--                                                                         <li><a href="#">Settings 1 </a> -->
<!--                                                                         </li> -->
<!--                                                                         <li><a href="#">Settings 2</a> -->
<!--                                                                         </li> -->
<!--                                                                     </ul> -->
                                                                </li>
                                                                <li><a id="close-link" data-dismiss="modal"><i class="fa fa-close"></i></a>
                                                                </li>
                                                            </ul>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                        <div class="x_content">
                            								<form class="form-horizontal form-label-left input_mask" id="frmDetalleFE" name="frmDetalleFE" >
                            								
                            								<input style="display: none" type="hidden" id="vouc_bcod"
											name="vouc_bcod" required="" value="${oDtoComprobante.voucBcod}" />
											
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_vtypdocvou">Tipo de comprobante :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_vtypdocvou"
											name="vouc_vtypdocvou" placeholder="Tipo de comprobante" required=""
											value="${oDtoComprobante.voucVtypdocvou}"  readonly="readonly" /> 
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_vnro">Nro de Comprobante :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text"
											class="form-control" id="vouc_vnro" name="vouc_vnro"
											placeholder="Nro Comprobante" required="" maxlength="11" value="${oDtoComprobante.voucVnro}"  readonly="readonly" />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_vrucemisor">Ruc :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_vrucemisor"
											name="vouc_vrucemisor" placeholder="Ruc Emisor" required=""
											value="${oDtoComprobante.clieVrucemisor}"  readonly="readonly" />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="clie_bcod">Razon Social :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="email" class="form-control" id="clie_bcod"
											name="clie_bcod" placeholder="Razon Social"
											required="" value="${oDtoComprobante.clieBcod}" readonly="readonly"  />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_temitiondate">Fecha de Emisión :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_temitiondate"
											name="vouc_temitiondate" placeholder="Fecha de Emision"
											required="" value="${oDtoComprobante.voucTemitiondate}" readonly="readonly" />
										</div>
										</div>
                                      <!-- 	<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_dmonto">Monto :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_dmonto"
											name="vouc_dmonto" placeholder="Monto"
											required="" value="${oDtoComprobante.voucDmonto}" readonly="readonly"   />
										</div>
										</div>
										-->
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" >Estado en el Sistema :</label>
										<div class="col-md-6 col-sm-6 col-xs-12" >
										<label class="form-control" id="vouc_vstateSystem"
											 ></label>
										</div>
										</div>  
										
						<%--  			<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" >¿Enviado a Sunat?</label>
										<div class="col-md-6 col-sm-6 col-xs-12" >
										<label class="form-control" id="vouc_venviadoSunat"
											 ></label>
										</div>
										</div> 
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" >Respuesta de Sunat :</label>
										<div class="col-md-6 col-sm-6 col-xs-12" >
										<label class="form-control" id="vouc_vstate"
											 ></label>
										</div>
										</div> 
                              
                                							</form>
                                							--%>	
                                							<!--BOTONES -->
                                                                        <div class="ln_solid"></div>
                                                                        <div class="form-group">
                                                                            <div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-5">
                                                                                <button type="button" class="btn btn-success" data-dismiss="modal">Salir</button>
                                                                            </div>
                                                                        </div> 
                                                                     
                                                                          
                                                                        <!--BOTONES -->
                            
                                                        </div>
                                                        
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>
                                        <!-- Fin Modal -->
                                        
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
        
        <%@include file="../Global/footer.jsp" %>
        <script src="<c:url value='../resources/v1/ComprobanteElectronicoController.js'/>" type="text/javascript"></script>
        <script src="../resources/vendors/select2/dist/js/select2.full.js"></script>
		<script src="../resources/vendors/select2/docs/vendor/js/anchor.min.js"></script>
        <%@include file="../Global/modalSunat.jsp" %>
        <%@include file="../Global/ubigeo.jsp" %>

        
        <script type="text/javascript">
			$(document).on('ready',function() {
				var	comprobante = new Comprobante();
				comprobante.init();
			});
		</script>

<!-- <STYLE type="text/css">
table thead {
  color: #fff;
  background-color: #5499C7;
}
table th {
  color: #fff;
  background-color: #5499C7;
}
</STYLE> -->

        <!--        <script>
                    $(function () {
                        $('#datepicker1').datepicker();
                    });
                </script>-->

        <!--        <script>
                    $(document).ready(function () {
                        $('#example1').datepicker({
                            dateFormat: "yy"
                        });
                    });
                </script>-->

        <script>
//            $(function () {
//                $('input[name="daterange"]').daterangepicker();
//            });
        </script>
        
        <!--<script>	
            $(document).ready(function () {
                $('#lstFactElect').DataTable({
                     "scrollX": true
                });
            });
        </script>-->

<!--        <script>
            $(document).ready(function () {
                $('#lstFactElect').DataTable({
                    "scrollX": true
                });
            });
        </script>-->

        <!--        <script>
        //        $("#single_cal3").daterangepicker({singleDatePicker:!0,singleClasses:"picker_4"},
        //        function(a,b,c){console.log(a.toISOString(),b.toISOString(),c)})	
                </script>-->

<!-- <STYLE type="text/css">
input#frmCPEFiltrosNro {
border-radius: 7px;
	
}
</STYLE> -->



    </body>
</html>