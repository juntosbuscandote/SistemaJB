<script type="text/template" id="divAgregarCP">
<div>
    <div class="x_panel cp_new">
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			</li>
			<li><a class="close-link"><i class="fa fa-close cerrar"></i></a></li>
		</ul>
		<div class="x_content addCP" style="display: block;">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12 form-group">
					<label class="control-label">Tipo Mov:</label> 
						<SELECT class="form-control inputConData classListaCajaTipMov" id="listaCajaTipMov" name="listaCatDetSucursal">
								{{#tipoMoviCaja}}
                        			<option value="{{catdCident}}">{{catdVdescription}}</option>
                   				{{/tipoMoviCaja}}
 						</SELECT>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12 form-group">
					<label class="control-label ">Origen de CP:</label> 
					<SELECT class="form-control inputConData classListaCajaOrigenCP" id="listaCajaOrigenCP" name="listaCajaOrigenCP">
							<option value="" data-type="{{type}}">Seleccione..</option>
						{{#origenCaja}}
                        	<option value="{{catdCident}}">{{catdVdescription}}</option>
                   		{{/origenCaja}}
					</SELECT>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12 form-group">
					<label class="control-label">CP:</label> <SELECT
					class="form-control inputConData select2-single classlistaCajaCP" id="listaCajaCP"
					name="listaCajaCP">
					</SELECT>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12 form-group">
					<label class="control-label">Fecha del CP:</label>
					<input class="form-control classfrmCajaFechaCP" id="frmCajaFechaCP" value="" name="frmCajaFechaCP" disabled>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4 col-sm-8 col-xs-12">Total CP:<output class="classLabelTotalCP"></output></label>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input class="form-control classfrmCajaTotalCP" id="frmCajaTotalCP"
						name="frmCajaTotalCP" type="text" value="" readonly>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-4 col-sm-8 col-xs-12">Total disponible a pagar:<output class="classLabelDispPagar"></output></label>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<input class="form-control classfrmCajaDisponiblePagar" id="frmCajaDisponiblePagar"
						name="frmCajaDisponiblePagar" type="text" value="" readonly>
				</div>
			</div>
			<button class="btn btn-success ladda-button btnAgregarPagoCaja" data-style="expand-right" type="button" ><span>Añadir Pago a Caja</span></button>
			<div class="form-group divAgrPagoCaja"></div>
		</div>
	</div>
</div>
</script>
<script type="text/template" id="divAgregarPagoCaja">
<div class="x_panel pc_new">
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			</li>
			<li><a class="close-link"><i class="fa fa-close cerrarPC"></i></a></li>
		</ul>
	<div class="x_content addPago" style="display: block;">
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12 form-group">
				<label class="control-label">Caja / Cta Corriente:</label> <SELECT
				class="form-control inputConData classlistaCajaCtaCorriente" id="listaCajaCtaCorriente"
				name="listaCajaCtaCorriente">
					{{#toption}}
    					<option value="{{id}}" data-type="{{type}}">{{des}} {{banco}}</option>
    				{{/toption}}
				</SELECT>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12 form-group">
				<label class="control-label">Forma de Pago:</label> <SELECT
				class="form-control inputConData classlistaCajaFormaPago" id="listaCajaFormaPago"
				name="listaCajaFormaPago">
					{{#toptionFP}}
    					<option value="{{id}}" data-type="{{type}}">{{des}}</option>
    				{{/toptionFP}}
				</SELECT>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12 form-group">
				<label class="control-label">Nro. de Operacion:</label>
				<input class="form-control classfrmCajaNroOperacion" id="frmCajaNroOperacion" value="" name="frmCajaNroOperacion" >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3 col-sm-6 col-xs-12 pagoTotal">
			<input type="checkbox" class="cantidadPagoTotal" id="radioMovCajaTipPagoTotal" name="radioMovCajaTipPago" >
			Pago Total:<output class="classLabelPagoTotal"></output></label>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<input class="form-control classfrmCajaPagoTotal" id="frmCajaPagoTotal"
					name="frmCajaPagoTotal" type="text" value="${modfBIMGG}" readonly>
			</div>
			<label class="control-label col-md-3 col-sm-6 col-xs-12 pagoAcuenta">
			<input type="checkbox" class="cantidadPagoAcuenta" id="radioMovCajaTipPagoAcuenta" name="radioMovCajaTipPago" >
			A cuenta:<output class="classLabelAcuenta"></output></label>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<input class="form-control classfrmCajaAcuenta" id="frmCajaAcuenta"
					name="frmCajaAcuenta" type="text" value="" attr-aux="0" disabled>
			</div>
		</div>
	</div>
</div>
</script>

<script type="text/template" id="cboCajaMovCaja">
    {{#toptionMovCaja}}
    <option value="{{id}}" data-type="{{type}}">{{des}}</option>
    {{/toptionMovCaja}}
</script>

<script type="text/template" id="cboCajaOriCaja">
    {{#toptionOriCaja}}
    <option value="{{id}}" data-type="{{type}}">{{des}}</option>
    {{/toptionOriCaja}}
</script>

<script type="text/template" id="cboCajaCP">
    {{#toption}}
    <option value="{{id}}" attr-serie="{{serie}}" attr-nro="{{nro}}" attr-tipo="{{tipo}}" 
	attr-fecha="{{fecha}}" attr-total="{{total}}" attr-disponible="{{disponible}}" 
	attr-moneda="{{moneda}}">{{serie}}-{{nro}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboCajaFP">
    {{#toptionFP}}
    <option value="{{id}}" data-type="{{type}}">{{des}}</option>
    {{/toptionFP}}
</script>

<script type="text/template" id="cboCajaCtaCorriente">
    {{#toption}}
    <option value="{{id}}" data-type="{{type}}">{{des}} {{banco}}</option>
    {{/toption}}
</script>

<script type="text/template" id="cboMasterTipCambio">
    {{#toption}}
        <option value="{{id}}" attr-venta="{{venta}}">v: {{venta}}</option>
		<option value="{{id}}" attr-compra="{{compra}}">c: {{compra}}</option>
		<option value="{{id}}" attr-promedio="{{promedio}}">p: {{promedio}}</option>
    {{/toption}}
</script>