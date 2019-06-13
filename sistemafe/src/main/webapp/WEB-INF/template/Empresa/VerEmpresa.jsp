<form class="form-horizontal form-label-left" id="frmbussines" name="frmbussines">
	<div class="x_panel">
		<div class="x_title">
			<h4>Datos Generales</h4> 
		</div>
		<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
			<div class="row">
				<div class="col-lg-6 col-md-4 col-xs-12 form-group" id="tipDocSelect">
					<label class="control-label" for="empr_vdoctype">Tipo de Documento:</label> 
					<input type="text" class="form-control solo-numero" id="empr_vdoctype" name="empr_vdoctype" value="${empPersVNumDoc}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc">N° de Documento:</label>
					<input type="text" class="form-control solo-numero" id="pers_vnumdoc" name="pers_vnumdoc" placeholder="Número de RUC" maxlength="11" required="" value="${empPersVNumDoc}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="lega_businame">Razón Social:</label>
					<input type="text" class="form-control" id="lega_businame" name="lega_businame" placeholder="Razón Social"  value="${legalPersLegaBusiname}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vtradename">Nombre Comercial:</label>
					<input type="text" class="form-control" id="pers_vtradename" name="pers_vtradename" placeholder="Nombre Comercial" value="${empPersVtradename}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="phon_vphone">N° Telefono:</label>
					<input type="text" class="form-control" id="phon_vphone" name="phon_vphone" placeholder="Número de teléfono"  value="${legalPersPhone}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vpais">Nacionalidad:</label>
					<input type="text" class="form-control solo-numero" id="legal_vpais" name="legal_vpais" value="${empPersCountry}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vdepartamento">Localidad:</label>
					<input type="text" class="form-control solo-numero" id="legal_vlocalidad" name="legal_vlocalidad" value="${empPersUbigeo}" readonly="readonly" />
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="mail_vmail">Email:</label>
					<input type="text" class="form-control" id="mail_vmail" name="mail_vmail" placeholder="Correo Electrónico"  required="" value="${legalPersEmail}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="addr_vaddress">Dirección Legal:</label>
					<input type="text" class="form-control" id="addr_vaddress" name="addr_vaddress" placeholder="Dirección Legal"  required="" value="${legalPersAddress}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="legal_vtipoPerson">Tipo Persona:</label>
					<input type="text" class="form-control solo-numero" id="legal_vtipoPerson" name="legal_vtipoPerson" value="${empPersTipoPers}" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<div class="x_panel">
		<div class="x_title">
			<h4>Representante Legal</h4>
		</div>
		<div id="datoRepresentanteLegal" class="col-lg-10 col-md-10 col-lg-offset-1">

			<div class="row">
				<div class="col-lg-6 col-md-4 col-xs-12 form-group" id="tipDocRLSelect">
					<label class="control-label" for="pers_vdoctype">Tipo de Documento:</label> 
					<input type="text" class="form-control solo-numero" id="pers_vdoctype" name="pers_vdoctype" value="${repLegalTipoNumDoc}" readonly="readonly"/>
				</div>
				<div class="col-lg-6 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc_repleg">N° de Documento:</label> 
					<input type="text" class="form-control" id="pers_vnumdoc_repleg" name="pers_vnumdoc_repleg" placeholder="Número de documento" required="" value="${repLegalVNumDoc}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vdocty">Nombres:</label> 
					<input type="text" class="form-control" id="natu_vname" name="natu_vname" placeholder="Nombres"  required="" value="${repLegalName}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vdoctype">Apellido Paterno:</label> 
					<input type="text" class="form-control" id="natu_vlastnamefather" name="natu_vlastnamefather" placeholder="Apellido Paterno"  required="" value="${repLegalLastnamefather}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vdoctype">Apellido Materno:</label> 
					<input type="text" class="form-control" id="natu_vlastnamemother" name="natu_vlastnamemother" placeholder="Apellido Materno"  required="" value="${repLegalLastnameMother}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vmail">Nombre Comercial:</label> 
						<input type="text" class="form-control" id="natural_vtradename" name="natural_vtradename" placeholder="Nombre Comercial"  value="${repPersVtradename}" readonly="readonly" />
					</div>
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vphone">Tipo Persona:</label>
						<input type="text" class="form-control solo-numero" id="natural_vtipoPerson" name="natural_vtipoPerson" value="${repLegalTipoPers}" readonly="readonly"/>
					</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="legal_vpais">Nacionalidad:</label>
					<input type="text" class="form-control solo-numero" id="natural_vpais" name="natural_vpais" value="${repLegalCountry}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vdepartamento">Localidad:</label>
					<input type="text" class="form-control solo-numero" id="natural_vlocalidad" name="natural_vlocalidad" value="${repLegalUbigeo}" readonly="readonly" />
				</div>

			</div>	
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="mail_vmail_repleg">Email:</label>
					<input type="text" class="form-control" id="mail_vmail_repleg" name="mail_vmail_repleg" placeholder="Correo electrónico"  required="" value="${repLegalEmail}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="phon_vphone_repleg">Celular:</label>
					<input type="text" class="form-control" id="phon_vphone_repleg" name="phon_vphone_repleg" placeholder="Celular"  required="" value="${repLegalPhone}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-xs-12 form-group">
					<label class="control-label" for="mail_vmail_repleg">Dirección:</label>
					<input type="text" class="form-control" id="addr_vaddress_repleg" name="addr_vaddress_repleg" placeholder="Dirección"  required="" value="${repLegalAddress}" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
</form>


