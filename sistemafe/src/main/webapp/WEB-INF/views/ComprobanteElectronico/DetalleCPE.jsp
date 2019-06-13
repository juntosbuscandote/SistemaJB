<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="../Global/header.jsp" %>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="../Global/nav.jsp" %>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Comprobante Electrónico</h3>
                            </div>
                            <div class="title_right">




                                <!--                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                                                    <div class="input-group">
                                                                        <input type="text" class="form-control" placeholder="Search for...">
                                                                        <span class="input-group-btn">
                                                                            <button class="btn btn-default" type="button">Go!</button>
                                                                        </span>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </div>

                        
                        
                        
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Comprobante<small>Detalles</small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">

                                        
                                                        
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
											value=""  readonly="readonly" />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="clie_bcod">Razon Social :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="email" class="form-control" id="clie_bcod"
											name="clie_bcod" placeholder="Razon Social"
											required="" value="" readonly="readonly"  />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_temitiondate">Fecha de Emision :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_temitiondate"
											name="vouc_temitiondate" placeholder="Fecha de Emision"
											required="" value="${oDtoComprobante.voucTemitiondate}" readonly="readonly" />
										</div>
										</div>
                                           <div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_dmonto">Monto :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_dmonto"
											name="vouc_dmonto" placeholder="Monto"
											required="" value="${oDtoComprobante.voucDmonto}" readonly="readonly"   />
										</div>
										</div>
										<div class="form-group">
										<label class="control-label col-md-4 col-sm-4 col-xs-12" for="vouc_vstate">Estado de comprobante :</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="vouc_vstate"
											name="vouc_vstate" placeholder="Estado de Comprobante"
											required="" value="${oDtoComprobante.voucVstate}" readonly="readonly"  />
										</div>
										</div>  

                                                                            
                                							</form>
                                							<!--BOTONES -->
                                                                        <div class="ln_solid"></div>
                                                                        <div class="form-group">
                                                                            <div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-5">
                                                                                <button type="button" class="btn btn-primary" id="btnSalirDet" name="btnSalirDet">Salir</button>
                                                                            </div>
                                                                        </div> 
                                                                        <!--BOTONES -->
                            
                                                        </div>
                                                        
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /page content -->
                <!-- footer content -->
                <footer>
                    <div class="pull-right">
                       - Todos los derechos reservados
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>
        <%@include file="../Global/footer.jsp" %>
<!--        <script src="<c:url value='../resources/v1/EmpresaController.js'/>" type="text/javascript"></script>-->
       <script src="<c:url value='../resources/v1/ComprobanteElectronicoController.js'/>" type="text/javascript"></script>
        
        <script type="text/javascript">
			$(document).on('ready',function() {
				var	detalleCPE = new Comprobante();
				detalleCPE.init();
			});
		</script>



    </body>
</html>