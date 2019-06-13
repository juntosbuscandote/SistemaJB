<div class="x_panel">
	<div class="x_title">
		<h4>Crear Perfil</h4>
	</div>
	<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
		<form id="frmPerfil" name="frmPerfil">
			<input style="display: none" type="hidden" id="perfil_id" name="perfil_id" required="" value="${perfilId}" />
			<div id="grupoComercial">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="perfil_vname">Nombre:</label> 
						<input type="text" class="form-control" id="perfil_vname" name="perfil_vname" placeholder="Nombres"  value="${nombrePerfil}" maxlength="30" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="perfil_vdescrip">Descripción:</label> 
<%-- 						<input type="text" class="form-control" id="grupocom_vdescrip" name="grupocom_vdescrip" placeholder="Descripcion"  value="${descrGrupoCom}" maxlength="250"/> --%>
						<textarea maxlength="150" id="perfil_vdescrip" name="perfil_vdescrip" class="form-control valid" rows="4" style="resize: none;" aria-invalid="false" ><c:out value="${descrPerfil}" /></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>