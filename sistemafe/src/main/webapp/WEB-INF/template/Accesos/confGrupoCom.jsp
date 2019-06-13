<div class="x_panel">
	<div class="x_title">
		<h4>Crear Grupo Comercial</h4>
	</div>
	<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
		<form id="frmGrupoComercial" name="frmGrupoComercial">
			<input style="display: none" type="hidden" id="grupoComer_id" name="grupoComer_id" required="" value="${idGrupoCom}" />
			<div id="grupoComercial">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="natural_vname">Nombre:</label> 
						<input type="text" class="form-control" id="grupocom_vname" name="grupocom_vname" placeholder="Nombres"  value="${nombreGrupoCom}" maxlength="100" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="natural_vname">Descripción:</label> 
<%-- 						<input type="text" class="form-control" id="grupocom_vdescrip" name="grupocom_vdescrip" placeholder="Descripcion"  value="${descrGrupoCom}" maxlength="250"/> --%>
						<textarea maxlength="250" id="grupocom_vdescrip" name="grupocom_vdescrip" class="form-control valid" rows="4" style="resize: none;" aria-invalid="false" ><c:out value="${descrGrupoCom}" /></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>