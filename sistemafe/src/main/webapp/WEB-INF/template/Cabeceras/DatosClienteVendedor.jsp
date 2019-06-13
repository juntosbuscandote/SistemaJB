<form class="form-horizontal form-label-left input_mask" id="frmDatosClienteVendedor" name="frmDatosClienteVendedor">

	<div id="" class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-5 col-sm-5 col-xs-12 form-group">
				<label class="control-label">Persona:</label>
				<div class="input-group"> 
				<select class="form-control select2-single" id="filtrarClienteNroC" name="filtrarClienteNroC">
					<c:forEach items="${filtrarClienteNroC}" var="filtrarClienteNros">
																<option  attr-tipdoc="${filtrarClienteNros.persVdoctype}" attr-numdoc="${filtrarClienteNros.pers_vnumdoc}" attr-nombre="${filtrarClienteNros.nombre}" attr-email="${filtrarClienteNros.mailVmail}" attr-direccion="${filtrarClienteNros.direccionUbigeoPais}"  value="${filtrarClienteNros.clieBident}">${filtrarClienteNros.pers_vnumdoc} - ${filtrarClienteNros.nombre}</option>
					</c:forEach>
				</select>
				<span class="input-group-btn">
						<button type="button" class="btn btn-primary" id="cliente" title="Crear Cliente">
							<i class="fa fa-plus-circle"></i>
						</button>
					</span>
				</div>
			</div>

			<div class="col-md-7 col-sm-7 col-xs-12">
				<input type="hidden" id="fProcessCliente" value="save" /> 
				<input type="hidden" id="newClienteRG" value="new" /> 
				<label class="control-label">Direccion:</label>
				<input
					class="form-control" disabled="true" id="filtrarClienteDireccion"
					name="filtrarClienteDireccion" type="text"
					value="" placeholder="Dirección de Cliente">
<!-- 				<div class="input-group"> -->
					<input class="form-control" disabled="true" id="filtrarClienteRazonSocialCliente" name="filtrarClienteRazonSocialCliente" value="" type="text" placeholder="Razón Soc./Nom. y Apellidos" style="display: none"> 
<!-- 					<span class="input-group-btn"> -->
<!-- 						<button type="button" class="btn btn-primary" id="cliente" title="Crear Cliente"> -->
<!-- 							<i class="fa fa-plus-circle"></i> -->
<!-- 						</button> -->
<!-- 					</span> -->
<!-- 				</div> -->
			</div>
		</div>

		<div class="row">
			<div class="col-md-5 col-sm-5 col-xs-12 form-group vendNota">
				<label class="control-label"> Nro o Nombre de Vendedor:</label> 
				<div class="input-group">
				<select class="form-control select2-single" id="filtrarVendedorNroV" name="filtrarVendedorNroV">
					<c:forEach items="${filtrarVendedorNroV}" var="filtrarVendedorNros">
						<option attr-tipdoc="${filtrarVendedorNros.persVdoctype}" attr-numdoc="${filtrarVendedorNros.persVnumdoc}" attr-nombre="${filtrarVendedorNros.nombres}" value="${filtrarVendedorNros.empl_bident}">${filtrarVendedorNros.persVnumdoc} - ${filtrarVendedorNros.nombres}</option>
					</c:forEach>
				</select>
				<span class="input-group-btn">
						<button type="button" class="btn btn-primary"  id="CrearVendedor" title="Crear Vendedor">
							<i class="fa fa-plus-circle"></i>
						</button>	
					</span>
				</div>
			</div>
			<div id="divObs" class="col-md-7 col-xs-12 form-horizontal form-label-left input_mask">
				<label class="control-label"> Obs.: </label> 
				<input class="form-control" value="${ObsCabecera}" id="frmMovVentaObs" name="frmMovVentaObs" type="text">
			</div>
					<input class="form-control" disabled="true" id="filtrarVendedorNombre" value="${RazVendedor}" name="filtrarVendedorNombre" type="text" placeholder="Nom. y Apellidos" style="display: none"> 

		</div>
		
		<div class="row">
			<div class="col-md-5 col-sm-5 col-xs-12 form-group">
		<div class="form-group">
      <label for="usr">Orden de Compra:</label>
      <input type="text" class="form-control" value id="frmMovVentaOrdenCompra" name="frmMovVentaOrdenCompra">
  </div>
		   </div>
	<div class="col-md-7 col-xs-12 form-horizontal form-label-left input_mask">
      <label for="comment">Guia:</label>
      <input type="text" type="text" class="form-control" id="frmMovVentaguia" name="frmMovVentaguia" maxlength="500"> 
	</div>
		
			</div>
		</div>
	</div>
</form>
<!-- <div id="divObs" class="col-md-12 col-xs-12 form-horizontal form-label-left input_mask"> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-12 col-sm-12 col-xs-12" > -->
<!-- 			<label class="control-label"> Obs.: </label>  -->
<%-- 			<input class="form-control" value="${ObsCabecera}" id="frmMovVentaObs" name="frmMovVentaObs" type="text"> --%>
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<form class="form-horizontal form-label-left input_mask" id="frmDatosObservacion" name="frmDatosObservacion">
<div id="divObsNota" class="col-md-12 col-xs-12" style="display: none">
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12" >
			<label class="control-label"> Obs.: </label> 
			<input class="form-control" value="${ObsCabecera}" id="frmMovVentaObsNota" name="frmMovVentaObsNota" type="text">
		</div>
	</div>
</div>
</form>







