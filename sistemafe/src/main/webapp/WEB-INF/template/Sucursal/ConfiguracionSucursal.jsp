<form class="form-horizontal form-label-left input_mask" id="frmSucursal" name="frmSucursal">
	<div class="x_panel">
		<div class="x_title">
			<h4>Datos Generales</h4> 
		</div>
		<input type=hidden id="validEmpr" name="validEmpr" value="${validBussines}" />
		<input type=hidden id="sucuId" name="sucuId" value="${sucuId}" />
		<input type=hidden id="almId" name="almId" value="${almId}" />
		<input type=hidden id="busiBident" name="busiBident" value="${busiBident}" />
		<input type="hidden" id="proccess"   value="${proccess}" />
		<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Codigo:</label>
					<input type="text" class="form-control" id="sucu_codigo" maxlength="2" name="sucu_codigo" placeholder="Código sucursal"  value="${sucuCodigo}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="pers_vtradename">Nombre:</label>
					<input type="text" class="form-control" id="sucu_nombre" maxlength="100" name="sucu_nombre" placeholder="Nombre sucursal" value="${sucuNombre}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Nombre Corto:</label>
					<input type="text" class="form-control" id="sucu_nombreCorto" maxlength="10" name="sucu_nombreCorto" placeholder="Nombre corto sucursal"  value="${sucuNombreCorto}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="pers_vtradename">Teléfono:</label>
					<input type="text" class="form-control" id="sucu_telefono" maxlength="15" name="sucu_telefono" placeholder="Teléfono Sucursal" value="${sucuTelefono}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Dirección:</label>
					<input type="text" class="form-control" id="sucu_direccion" maxlength="250" name="sucu_direccion" placeholder="Dirección sucursal"  value="${sucuDireccion}" readonly="readonly" />
				</div>
			</div>
			<div class="row">	
				<div class="col-lg-12 col-md-12 col-xs-12 form-group select2-parent">
					<label class="control-label" for="lega_businame">Empresa:</label>
<%-- 					<input type="text" class="form-control" id="sucu_empr" name="sucu_empr" placeholder="Empresa sucursal"  value="${legalPersLegaBusiname}" readonly="readonly" /> --%>
					<select class="form-control select2-enabled section2" name="sucu_empr" id="sucu_empr" disabled>
						<c:forEach items="${TlBussines}" var="TlBussines">
							<option value="${TlBussines.busibident}">${TlBussines.legaBusiname}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<div class="x_panel">
		<div class="x_title">
			<h4>Almacén</h4> 
		</div>
		<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Codigo:</label>
					<input type="text" class="form-control" id="alm_codigo" maxlength="2" name="alm_codigo" placeholder="Código almacén"  value="${almCodigo}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="pers_vtradename">Nombre:</label>
					<input type="text" class="form-control" id="alm_nombre" maxlength="100" name="alm_nombre" placeholder="Nombre almacén" value="${almNombre}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Nombre Corto:</label>
					<input type="text" class="form-control" id="alm_nombreCorto" maxlength="10" name="alm_nombreCorto" placeholder="Nombre corto de almacén"  value="${almNombreCorto}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="pers_vtradename">Teléfono:</label>
					<input type="text" class="form-control" id="alm_telefono" maxlength="50" name="alm_telefono" placeholder="Teléfono de almacén" value="${almTelefono}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Encargado:</label>
					<input type="text" class="form-control" id="alm_encargado" maxlength="250" name="alm_encargado" placeholder="Encargado del almacén"  value="${almEncargado}" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
</form>