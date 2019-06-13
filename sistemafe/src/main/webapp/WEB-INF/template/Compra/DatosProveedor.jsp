<form class="form-horizontal form-label-left input_mask" id="frmDatosProveedor" name="frmDatosProveedor">

	<div id="" class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-5 col-sm-5 col-xs-12 form-group">
				<label class="control-label"> Proveedor:</label> 
				<select class="form-control select2-single" id="proveedorCompra" name="proveedorCompra">
					<c:forEach items="${filtrarProveedorNroP}" var="filtrarVendedorNros">
						<option attr-tipdoc="${filtrarVendedorNros.persVdoctype}" attr-numdoc="${filtrarVendedorNros.persVnumdoc}" attr-nombre="${filtrarVendedorNros.nombres}" value="${filtrarVendedorNros.prov_bident}">${filtrarVendedorNros.persVnumdoc} - ${filtrarVendedorNros.nombres}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-7 col-sm-7 col-xs-12">
				<input type="hidden" id="fProcessVendedor" value="save" /> 
				<input type="hidden" id="newVendedorRG" value="new" /> 
				<label class="control-label">Nombre o Razón Social:</label>
				<div class="input-group">
					<input class="form-control" disabled="true" id="nombreProveedor" value="${modfRazProveinput}" name="nombreProveedor" type="text" placeholder="Nom. y Apellidos"> 
					<span class="input-group-btn">
						<button type="button" class="btn btn-primary"  id="CrearProveedor" title="Crear Proveedor">
							<i class="fa fa-plus-circle"></i>
						</button>	
					</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<label class="control-label"> Obs.: </label> 
				<input class="form-control" value="${modfObsCabecera}" id="observacionCompra" name="observacionCompra" type="text">
			</div>
		</div>
	</div>
</form>







