<%@page import="pe.am.spring.controller.EmpresaController"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<style>
.label {
    display: inline;
    padding: .2em .6em .3em;
    font-size: 150%;
    font-weight: 700;
    line-height: 1;
    color: #fff;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: .25em;
}
.quick-btn {
    background: #eee;
    -webkit-box-shadow: 0 0 0 1px #ea9431 inset, 0 0 0 1px #CCCCCC;
    box-shadow: 0 0 0 1px #F8F8F8 inset, 0 0 0 1px #CCCCCC;
    color: #444;
    display: inline-block;
    height: 120px;
    margin: 10px;
    padding-top: 18px;
    text-align: center;
    text-decoration: none;
    width: 130px;
    position: relative;
}
element.style {
}
.text-center {
    text-align: center;
    font-size: 10px;
}
user agent stylesheet
div {
    display: block;
}
.bg {
    background-color: #eee;
    color: #333 !important;
}
.quick-btn .label {
    position: absolute;
    right: -5px;
    top: -2px;
}
span { font-size: 14px; }

.panel-footer {
    padding: 0px 15px;
    background-color: #f5f5f5;
    border-top: 10px solid #ddd;
    border-bottom-right-radius: 3px;
    border-bottom-left-radius: 3px;
}
</style>


<html lang="en">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css" />
<%@include file="../Global/header.jsp"%>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../Global/nav.jsp"%>
			<!-- page content -->
			<div class="right_col" role="main">
				<!-- top tiles -->

				<input type="hidden" id="data" value="<c:out value='${json}' />" />
				<input type="hidden" id="dataAcep" value="<c:out value='${jsonAcep}' />" /> 
				<input type="hidden" id="dataRechaz" value="<c:out value='${jsonRechaz}' />" /> 
				<input type="hidden" id="dataNotVentxMes" value="<c:out value='${jsonNotVentxMes}' />" /> 
				<input type="hidden" id="dataNotVentxMesV" value="<c:out value='${jsonNotVentxMes}' />" /> 				
				<input type="hidden" id="dataFactxMes" value="<c:out value='${jsonFactxMes}' />" /> 
				<input type="hidden" id="dataBolxMes" value="<c:out value='${jsonBolxMes}' />" /> 
				<input type="hidden" id="dataNCredxMes" value="<c:out value='${jsonNCredxMes}' />" />
				<input type="hidden" id="dataNDebxMes" value="<c:out value='${jsonNDebxMes}' />" /> 
				<input type="hidden" id="dataCRetxMes" value="<c:out value='${jsonCRetxMes}' />" /> 
				<input type="hidden" id="dataNotVentMontoxMes" value="<c:out value='${jsonNotVentMontoxMes}' />" /> 
				<input type="hidden" id="dataFactMontoxMes" value="<c:out value='${jsonFactMontoxMes}' />" /> 
				<input type="hidden" id="dataBolMontoxMes" value="<c:out value='${jsonBolMontoxMes}' />" /> 
				<input type="hidden" id="dataNCredMontoxMes" value="<c:out value='${jsonNCredMontoxMes}' />" /> 
				<input type="hidden" id="dataNDebMontoxMes" value="<c:out value='${jsonNDebMontoxMes}' />" /> 
				<input type="hidden" id="dataCRetMontoxMes" value="<c:out value='${jsonCRetMontoxMes}' />" />
				<input type="hidden" id="dataTipoCambio" value="<c:out value='${flagTC}' />" />
				<input type="hidden" id="dataTipoCambioFecha" value="<c:out value='${fechaActual}' />" />
				
				<input type="hidden" id="userPerfil" value="${usuario.profBident}" />

				<div class="text-center">
             <!--    nota de venta-->
	              <a class="quick-btn">
	                <img src="../resources/img/factura (9).svg" width="50" height="50">
	                <span class="label label-danger" style="font-size:140%">${notvPorc}%</span>
	                <span><br>Total Personas Desaparecidas</span> <br>      
	                <div class="panel-footer back-footer-red bg-red1"  style="background-color: grey"><span>${totalnotaVentaV}</span></div> 
	              </a> 
	              
	    <%-- 
	        <!--    factura-->
	             <a class="quick-btn">
					<img src="../resources/img/factura (3).svg" width="50" height="50">
	                 <span class="label label-danger" style="font-size:140%">${factPorc}%</span>  
	                <span><br>Total Facturas</span>  <br>     
					<div class="panel-footer back-footer-red bg-red"><span>${totalFactura}</span></div>
	              </a>
	        <!--    boleta-->      
	              <a class="quick-btn">
	                <img src="../resources/img/factura (2).svg" width="50" height="50">
	                 <span class="label label-danger"style="font-size:140%">${bolPorc}%</span>  
	                <span><br>Total Boletas</span>   <br>    
					<div class="panel-footer back-footer-blue bg-orange"><span>${totalboleta}</span></div>
	              </a>
	         <!--    nota de credito-->     
    	          <a class="quick-btn">
	                <img src="../resources/img/factura (1).svg" width="50" height="50">
	                 <span class="label label-danger" style="font-size:140%">${notcPorc}%</span>  
	                <span><br>Total N. Credito</span>  <br>     
					<div class="panel-footer back-footer-blue bg-melon1"><span>${totalnotaCredito}</span></div>
	              </a>
	         <!--    nota de debito-->     
	              <a class="quick-btn">
	                <img src="../resources/img/factura (13).svg" width="50" height="50">
	                 <span class="label label-danger" style="font-size:140%">${notdPorc}%</span>  
	                <span><br>Total N. Debito</span>  <br>     
					<div class="panel-footer back-footer-blue bg-melon"><span>${totalnotaDebito}</span></div>
	              </a>
	         <!--    retencion-->     
	             <a class="quick-btn">
					<img src="../resources/img/papel-impreso.svg" width="50" height="50">
	                 <span class="label label-danger" style="font-size:140%">${notrPorc}%</span>  
	                <span><br>Total Retención</span>  <br>     
					<div class="panel-footer back-footer-red bg-dark-red"><span>${totalcomprobanteRentencion}</span></div>
	              </a>
	         <!--    total cpe-->     
	              <a class="quick-btn">
					 <img src="../resources/img/factura.svg " width="50" height="50">
	                 <span class="label label-danger" style="font-size:140%">100%</span>  
	                <span><br>Total Facturas</span>    <br>   
					<div class="panel-footer back-footer-brown bg-grey"><span>${totalcpe}</span></div>
	              </a> 
	              <br><br><br>
	              </div>				
				<!--     end -->
--%>
				<div class="row">

					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h5>
										Total Usuarios Registrados<small></small>
									</h5>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div id="canvas-container">								
										<canvas id="totalCPE" width="300" height="150"></canvas>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h5>
										Total Personas Encontrados<small></small>
									</h5>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div id="canvas-container">
										<canvas id="CPEAceptado" width="300" height="150"></canvas>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h5>
										Lista de Personas Perdidos<small></small>
									</h5>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div id="canvas-container">
										<canvas id="CPERechazado" width="300" height="150"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				
					</div>					

				<!-- 	<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h5>
										TOTAL DE COMPROBANTES TRIBUTARIO  POR MESES <small></small>
									</h5>

									<div class="clearfix"></div>
								</div>
								<div class="row">
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Moneda:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filTotalmoneda" name="filTotalmoneda" readonly="readonly" />
												<option value="USD">Dólares</option>
												<option value="PEN">Nuevos Soles</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Año:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filTotalAnio" name="filTotalAnio" readonly="readonly" />
												<option value="2018">2018</option>
												<option value="2017">2017</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<button class="btn btn-primary ladda-button" type="button" name="filTotalBuscar" id="filTotalBuscar" data-style="expand-right" style="margin-top: 23px;">
											<span class="ladda-label">Buscar</span>
										</button>
									</div>
								</div>
								<div class="x_content">
									<div id="canvas-container-totalCPExMes">
										<canvas id="totalCPExMes" width="300" height="150"></canvas>
									</div>
								</div>
							</div>
						</div>
						
					
						
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h5>
										TOTAL  DE COMPROBANTES NO TRIBUTARIO POR MESES<small></small>
									</h5>

									<div class="clearfix"></div>
								</div>
								<div class="row">
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Moneda:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filTotalmonedav" name="filTotalmonedav" readonly="readonly" />
												<option value="2">Dólares</option>
												<option value="1">Nuevos Soles</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Año:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filTotalAniov" name="filTotalAniov" readonly="readonly" />
												<option value="2018">2018</option>
												<option value="2017">2017</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<button class="btn btn-primary ladda-button" type="button" name="filTotalBuscarv" id="filTotalBuscarv" data-style="expand-right" style="margin-top: 23px;">
											<span class="ladda-label">Buscar</span>
										</button>
									</div>
								</div>
								<div class="x_content">
									<div id="canvas-container-totalCPEVxMes">
										<canvas id="totalCPEVxMes" width="300" height="150"></canvas>
									</div>
								</div>
							</div>
						</div>
						
					<div class="x_panel">
						<div class="x_title">
							<h5>
								MONTO POR TIPO DE COMPROBANTES<small></small>
							</h5>

							<div class="clearfix"></div>
						</div>
						<div class="row">
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Moneda:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filMontomoneda" name="filMontomoneda" readonly="readonly" />
												<option value="USD" >Dólares</option>
												<option value="PEN" >Nuevos Soles</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<label class="control-label" for="phon_vphone">Año:</label> 
										<select style="width: 100%" class="form-control filter-single" id="filMontoAnio" name="filMontoAnio" readonly="readonly" />
												<option value="2018">2018</option>
												<option value="2017">2017</option>
										</select>
									</div>
									<div class="col-lg-4 col-md-4 col-xs-12 form-group">
										<button class="btn btn-primary ladda-button" type="button" name="filMontoBuscar" id="filMontoBuscar" data-style="expand-right" style="margin-top: 23px;">
											<span class="ladda-label">Buscar</span>
										</button>
									</div>
								</div>
						<div class="x_content">
							<div id="canvas-container-montoTipCPE">
								<canvas id="montoTipCPE" width="300" height="150"></canvas>
							</div>

						</div>

					</div>
					
						 -->
					
					<!--                                                <div id="canvas-container" style="width:50%;"> -->
					<%--                                                <canvas id="myChart" width="400" height="400"></canvas> --%>
					<!--                                                </div> -->







				</div>
			</div>

		</div>
	</div>


	<script src="../resources/vendors/dist/spin.min.js"></script>
	<script src="../resources/vendors/dist/ladda.min.js"></script>
	<%@include file="../Global/footer.jsp"%>
	<script src="<c:url value='../resources/v1/DashboardController.js'/>"
		type="text/javascript"></script>
	<script src="../resources/js/bootbox.min.js"></script>
	
	<%@include file="../Global/modalSunat.jsp"%>
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
				var dashboard = new Dashboard();
				dashboard.init();
			});
		</script>
</body>
</html>




