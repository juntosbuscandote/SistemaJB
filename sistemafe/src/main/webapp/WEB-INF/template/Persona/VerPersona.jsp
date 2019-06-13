<div class="x_panel">
	<div class="x_title">
		<h4>Datos Generales de Persona</h4>
	</div>
	<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-6 col-md-6 col-xs-12 form-group"> -->
<!-- 				<label class="radio-inline">  -->
<!-- 				<input type="radio" value="1" id="frmTipoPersonNatural" name="frmTipoPerson" checked>Persona natural</label>  -->
<!-- 				<label class="radio-inline">  -->
<!-- 				<input type="radio" value="2" id="frmTipoPersonLegal" name="frmTipoPerson">Persona jurídica</label> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<form id="frmDocumento" name="frmDocumento">
			<div class="col-lg-6 col-md-4 col-xs-12 form-group" id="tipDocSelect">
							<img src="../resources/img/RENIEC.png" id="imgreniec" >					
				</div>
			<div class="row">
				<div class="col-lg-6 col-md-4 col-xs-12 form-group" id="tipDocSelect">
					<label class="control-label" for="empr_vdoctype">Tipo de Documento:</label> 
					<input type="text" class="form-control solo-numero"  id="pers_vdoctype" name="pers_vdoctype" placeholder="Número de RUC" value="${tipodoc}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc">N° de Documento:</label> 
					<input type="text" class="form-control solo-numero"  id="pers_vnumdoc" name="pers_vnumdoc" placeholder="Número de RUC" value="${numdoc}" readonly="readonly" />
				</div>
			</div>
		</form>
		<form id="frmNaturalPersona" name="frmNaturalPersona">
			<div id="personNatural">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vname">Nombres:</label> 
						<input type="text" class="form-control" id="natural_vname" name="natural_vname" placeholder="Nombres"  value="${naturalName}" readonly="readonly" />
					</div>
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vlastnamefather">Apellido Paterno:</label> 
						<input type="text" class="form-control" id="natural_vlastnamefather" name="natural_vlastnamefather" placeholder="Apellido Paterno"  value="${naturalLastnamefather}" readonly="readonly" />
					</div>
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vlastnamemother">Apellido Materno:</label> 
						<input type="text" class="form-control" id="natural_vlastnamemother" name="natural_vlastnamemother" placeholder="Apellido Materno"  value="${naturalLastnameMother}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vmail">Nombre Comercial:</label> 
						<input type="text" class="form-control" id="natural_vtradename" name="natural_vtradename" placeholder="Nombre Comercial"  value="${naturalTradename}" readonly="readonly" />
					</div>
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vphone">Tipo Persona:</label>
						<input type="text" class="form-control solo-numero"  id="natural_vtipoPerson" name="natural_vtipoPerson" placeholder="Número de RUC" value="${tipoPersona}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vmail">Email:</label> 
						<input type="text" class="form-control" id="natural_vmail" name="natural_vmail" placeholder="Correo electrónico"  value="${naturalMail}" readonly="readonly" />
					</div>
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vphone">Telefono:</label>
						<input type="text" class="form-control" id="natural_vphone" name="natural_vphone" placeholder="Celular" maxlength="15" value="${naturalPhone}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
						<label class="control-label" for="natural_vpais">Nacionalidad:</label>
						<input type="text" class="form-control" id="natural_vpais" name="natural_vpais" placeholder="País"  value="${naturalCountry}" readonly="readonly" />
					</div>
					<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
						<label class="control-label" for="natural_vdepartamento">Localidad:</label>
						<input type="text" class="form-control" id="natural_vlocalidad" name="natural_vlocalidad" placeholder="Localidad"  value="${naturalLocalidad}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="natural_vaddress">Dirección Legal:</label> 
						<input type="text" class="form-control" id="natural_vaddress" name="natural_vaddress" placeholder="Dirección Legal"  value="${naturalAddress}" readonly="readonly" />
					</div>
				</div>
			</div>
		</form>
		<form id="frmLegalPersona" name="frmLegalPersona">
		<div id="personLegal" >
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vbusiname">Razón Social:</label> 
					<input type="text" class="form-control" id="legal_vbusiname" name="legal_vbusiname" placeholder="Razón Social"  value="${legalBusiname}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vtradename">Nombre Comercial:</label> 
					<input type="text" class="form-control" id="legal_vtradename" name="legal_vtradename" placeholder="Nombre Comercial"  value="${legalTradename}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vphone">N° Telefono:</label> 
					<input type="text" class="form-control" id="legal_vphone" name="legal_vphone" placeholder="Número de teléfono"  maxlength="15" value="${legalPhone}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="legal_vpais">Nacionalidad:</label>
					<input type="text" class="form-control" id="legal_vpais" name="legal_vpais" placeholder="Localidad"  value="${legalCountry}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vdepartamento">Localidad:</label>
					<input type="text" class="form-control" id="legal_vlocalidad" name="legal_vlocalidad" placeholder="Localidad"  value="${legalLocalidad}" readonly="readonly" />
				</div>

			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="legal_vmail">Email:</label> 
					<input type="text" class="form-control" id="legal_vmail" name="legal_vmail" placeholder="Correo Electrónico"  value="${legalEmail}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="legal_vaddress">Dirección Legal:</label> 
					<input type="text" class="form-control" id="legal_vaddress" name="legal_vaddress" placeholder="Dirección Legal"  value="${legalAddress}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="legal_vtipoPerson">Tipo Persona:</label>
					<input type="text" class="form-control" id="legal_vtipoPerson" name="legal_vtipoPerson" placeholder="Localidad"  value="${legaltipoPerson}" readonly="readonly" />
				</div>
			</div>
		</div>
		</form>
	</div>
</div>
