<div class="col-md-2 col-sm-4 col-xs-12 form-group">
	<label class="control-label">Ejercicio:</label> <select
		style="width: 100%" class="form-control filter-single inputConData"
		id="listaEjercicioVenta" name="listaEjercicioVenta">
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
<div class="col-md-2 col-sm-4 col-xs-12 form-group">
	<label class="control-label">Periodo:</label> <select
		style="width: 100%" class="form-control filter-single inputConData"
		id="listaCatDetPeriod" name="listaCatDetPeriod">
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
<div class="col-md-3 col-sm-6 col-xs-12 form-group">
	<label class="control-label">Sucursal:</label> <SELECT
		class="form-control inputConData" id="listaCatDetSucursal"
		name="listaCatDetSucursal">
		<c:forEach items="${listaSucursal}" var="listaSucursal">
			<option value="${listaSucursal.offiBident}">${listaSucursal.offiname}</option>
		</c:forEach>
	</SELECT>
</div>
<div class="col-md-3 col-sm-6 col-xs-12 form-group">
	<label class="control-label">Almacen:</label> <SELECT
		class="form-control inputConData" id="listAlmacenVenta"
		name="listAlmacenVenta">
			<option value="${almacenCod}">${almacenNombre}</option>
	</SELECT>
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group">
	<label class="control-label">Código de Registro:</label> <input
		class="form-control col-md-9 col-sm-5 col-xs-12" disabled="disabled"
		value="" id="frmMovVentaCodReg" name="frmMovVentaCodReg"
		type="text">
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group">
	<label class="control-label">Forma de Pago:</label> <SELECT
		class="inputConData form-control select2-single" id="listaFormaPago"
		name="listaFormaPago">
		<c:forEach items="${listaCatDetFormadepa}" var="listcatformadepa">
			<option Text="OpenPopup" value="${listcatformadepa.catdCident}"
				atrr-shortName="${listcatformadepa.catdVshortname}">${listcatformadepa.catdVdescription}</option>
		</c:forEach>
	</SELECT>
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group">
	<label class="control-label">Moneda:</label> <select
		class="form-control inputConData" id="listaCatDetMoneda" name="listaCatDetMoneda">
		<c:forEach items="${listaCatDetMoneda}" var="listcatmoneda">
			<option value="${listcatmoneda.catdCident}" attr-sym="${listcatmoneda.catdVsymbol}" attr-color="${listcatmoneda.catdVkey1}">${listcatmoneda.catdVshortname}</option>
		</c:forEach>
	</select>
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="comboTipCambio">
	<label class="control-label">Tipo de Cambio:</label> <SELECT
		class="form-control inputConData" id="listaTipCambio" name="listaTipCambio">
		<option value="${Ident}" attr-venta="${venta}">V: ${venta}</option>
		<option value="${Ident}" attr-compra="${compra}">C: ${compra}</option>
		<option value="${Ident}" attr-promedio="${promedio}">P:
			${promedio}</option>
	</SELECT>
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group" id="labelTipCambio"
	style="display: none;">
	<label class="control-label">Tipo de Cambio</label> <input
		class="form-control col-md-9 col-sm-5 col-xs-12" disabled="disabled"
		value="${tipCambio}" id="frmTipCa" name="frmTipCa" type="text">
</div>
<div class="col-md-2 col-sm-4 col-xs-12 form-group"
	style="display: none" id="tip" style="display: none;">
	<label class="control-label">Tipo de Cambio</label> <input
		class="form-control col-md-9 col-sm-5 col-xs-12" disabled="disabled"
		value="${tipCambioident}" id="frmTipCaIdent" name="frmTipCaIdent"
		type="text">
</div>

