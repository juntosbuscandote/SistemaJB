<form class="form-horizontal form-label-left input_mask" id="frmDatosCabeceraCompra" name="frmDatosCabeceraCompra">
<div class="x_panel">
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label">Ejercicio:</label> <select
			style="width: 100%" class="form-control filter-single inputConData"
			id="listaEjercicioCompra" name="listaEjercicioCompra">
			<c:forEach items="${listaAnio}" var="listcatperiod">
				<c:if test="${listcatperiod.estado}">
					<option selected value="${listcatperiod.opcAnio}">${listcatperiod.opcAnio}</option>
				</c:if>
				<c:if test="${listcatperiod.estado==false}">
					<option value="${listcatperiod.opcAnio}">${listcatperiod.opcAnio}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="PeriodoCrea" style="display:block">
		<label class="control-label">Periodo:</label> <select
			style="width: 100%" class="form-control filter-single inputConData"
			id="listaPeriodo" name="listaPeriodo">
			<c:forEach items="${listaCatDetPeriod}" var="listcatperiod">
				<c:if test="${listcatperiod.estado}">
					<option selected value="${listcatperiod.opcion.catdCident}">${listcatperiod.opcion.catdVdescription}</option>
				</c:if>
				<c:if test="${listcatperiod.estado==false}">
					<option value="${listcatperiod.opcion.catdCident}">${listcatperiod.opcion.catdVdescription}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="PeriodoUpdate" style="display:none">
		<label class="control-label">Periodo:</label> <select
			style="width: 100%" class="form-control filter-single"
			id="listaPeriodos" name="listaPeriodos"><option value="">Ver Todo</option>
													<option value="1">ENER</option>
													<option value="2">FEBRERO</option>
													<option value="3">MARZO</option>
													<option value="4">ABRIL</option>
													<option value="5">MAYO</option>
													<option value="6">JUNIO</option>
													<option value="7">JULIO</option>
													<option value="8">AGOSTO</option>
													<option value="9">SEPTIEMBRE</option>
													<option value="10">OCTUBRE</option>
													<option value="11">NOVIEMBRE</option>
													<option value="12">DICIEMBRE</option>
			</select>
	</div>
	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
		<label class="control-label">Sucursal:</label> 
		<SELECT class="form-control inputConData" id="listaSucursal" name="listaSucursal">
			<c:forEach items="${listaSucursal}" var="listaSucursal">
			<option value="${listaSucursal.offiBident}">${listaSucursal.offiname}</option>
		</c:forEach>
		</SELECT>
	</div>
	<div class="col-md-3 col-sm-6 col-xs-12 form-group">
		<label class="control-label">Almacen:</label> 
		<SELECT class="form-control inputConData" id="listAlmacenCompra" name="listAlmacenCompra">
<!-- 			<option value="">V</option> -->
		</SELECT>
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="comboTipCambio">
		<label class="control-label">Código de Registro:</label> <input
			class="form-control col-md-9 col-sm-5 col-xs-12" value="${CodRegCompra}"
			id="codigoRegistro" name="codigoRegistro" type="text" disabled="disabled">
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label">Forma de Pago:</label> <SELECT
			class="form-control select2-single" id="listaFormaPago"
			name="listaFormaPago">
			<c:forEach items="${listaCatDetFormadepa}" var="listcatformadepa">
				<option Text="OpenPopup" value="${listcatformadepa.catdCident}"
					atrr-shortName="${listcatformadepa.catdVshortname}">${listcatformadepa.catdVdescription}</option>
			</c:forEach>
		</SELECT>
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label">Moneda:</label> <select
			class="form-control inputConData" id="listaMoneda" name="listaMoneda">
			<c:forEach items="${listaCatDetMoneda}" var="listcatmoneda">
				<option value="${listcatmoneda.catdCident}" attr-sym="${listcatmoneda.catdVsymbol}" attr-color="${listcatmoneda.catdVkey1}">${listcatmoneda.catdVshortname}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="comboTipCambio">
		<label class="control-label ">Tipo de Cambio:</label>
			<select style="width: 100%" class="form-control inputConData" id="listaTipCambio" name="listaTipCambio">
								</select>
		
	</div>
</div>
<div class="x_panel">
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label ">Fecha Movimiento:</label> <input
			class="form-control inputConData" id="fechaMovCompra"
			value="${fechademovimiento}" name="fechaMovCompra" >
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label">Fecha Emisión:</label> <input
			class="form-control inputConData" id="fechaEmiCompra"
			value="${fechademovimiento}" name="fechaEmiCompra" >
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="idFecVenc" style="display: none;">
		<label class="control-label">Fecha Vencimiento:</label><input
			class="form-control" id="frmMovVentaFecCad" value=""
			name="frmMovVentaFecCad" disabled="disabled">
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group">
		<label class="control-label ">Tipo Comprobante:</label> <select
			style="width: 100%" class="form-control filter-single select2-single inputConData"
			id="listaComprobante" name="listaComprobante">
			<option value=""></option>
			<c:forEach items="${listaCatDetCompras}" var="listcatcomp">
				<option value="${listcatcomp.catdCident}">${listcatcomp.catdVdescription}</option>
			</c:forEach>
		</select>
	</div>
<!-- 	<div class="col-md-6 col-sm-6 col-xs-12 form-group ctdc"> -->
	<div class="col-md-2 col-sm-4 col-xs-12 form-group ctd" id="divSerie">
		<label class="control-label ">Serie:</label> <input
			class="form-control" id="serieCompra" value="${modfSerie}" onkeyup="myFunction()" 
			name="serieCompra" type="text">
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group ctd">
		<label class="control-label ">Nro. CP:</label> <input
			class="form-control" value="${modfNroDoc}"
			id="nroCompCompra" name="nroCompCompra"
			type="text">
	</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group ctd" id="divDua" style="display: none">
												<label class="control-label">Aduana:</label> <select style="width: 100%"
													class="form-control filter-single select2-single"
													id="duaCompra" name="duaCompra">
													<c:forEach items="${listaCatDetAD}"														var="listcatindicadorad">
														<option value="${listcatindicadorad.catdCident}">${listcatindicadorad.catdVdescription}</option>
													</c:forEach>
												</select>
											</div>
	<div class="col-md-2 col-sm-4 col-xs-12 form-group ctd" id="divAnioDua" style="display: none">
		<label class="control-label">Año Dua:</label> <input value=""
			class="form-control" id="anioDuaCompra" value="${VentaSerie}"
			name="anioDuaCompra" type="text">
	</div>
<!-- 	<div class="col-md-3 col-sm-3 col-xs-12 form-group" id="divDua" style="display: none"> -->
<!-- 		<label class="control-label">DUA:</label> <input -->
<%-- 			class="form-control" value="" --%>
<!-- 			id="duaCompra" name="duaCompra" -->
<!-- 			type="text"> -->
<!-- 	</div> -->
<!-- 	</div> -->
	
</div>
</form>
<script>
function myFunction() {
    var x = document.getElementById("serieCompra");
    x.value = x.value.toUpperCase();
}
</script>