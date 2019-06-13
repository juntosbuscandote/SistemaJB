<div class="col-md-12 col-sm-4.5 col-xs-6">
	<div class="panel panel-primary text-center border" id="consultarSunat" hidden>
		<div class="panel-footer back-footer-blue bg-grey">Consultado en Sunat</div>
		<div class="panel-body">
			<div class="col-lg-6 col-md-6 col-xs-12 form-group">
				<label class="control-label" for="natural_vmail">Estado:</label> 
				<div id="estadoSunat"></div>
			</div>
			<div class="col-lg-6 col-md-6 col-xs-12 form-group">
				<label class="control-label" for="natural_vmail">Condición:</label> 
				<div id="condicionSunat"> </div>
			</div>
		</div>
	</div>
</div>


<form class="form-horizontal form-label-left" id="frmbussines" name="frmbussines">
	<div class="x_panel">
		<div class="x_title">
			<h4>Datos Generales</h4> 
		</div>
		<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
			<input style="display: none" type="hidden" id="pers_bidentE" name="pers_bidentE" required="" value="${empPersBident}" /> 
			<input style="display: none" type="hidden" id="lega_bident" name="lega_bident" required="" value="${empPersBidentLP}" /> 
			<input style="display: none" type="hidden" id="pers_bidentUser" name="pers_bidentUser" required="" value="${usuario.persBident}" />
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group" id="tipDocSelect">
					<label class="control-label" for="empr_vdoctype">Tipo de Documento:</label> 
					<select style="width: 100%" class="form-control filter-single" id="empr_vdoctype" name="empr_vdoctype"/>
						<c:forEach items="${listaCatDet}" var="listcat">
							<option value="${listcat.catdCident}" cantidad="${listcat.catdVsymbol}">${listcat.catdVdescription}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group" id="tipDocInput" style="display: none">
					<label class="control-label" for="empr_vdoctypeView">Tipo de Documento:</label> 
					<input type="text" class="form-control" id="empr_vdoctypeView" name="empr_vdoctypeView" placeholder="Número de RUC" maxlength="11" required="" value="Registro Único de Contribuyentes" disabled="disabled"/>
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc">N° de Documento:</label>
					<input type="text" class="form-control solo-numero" id="pers_vnumdoc" name="pers_vnumdoc" placeholder="Número de RUC" maxlength="11" required="" value="${empPersVNumDoc}" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<button class="btn btn-primary ladda-button" type="button" name="validRucEmpresa" id="validRucEmpresa" data-style="expand-right" style="margin-top: 23px;">
						<span class="ladda-label">Validar Ruc</span>
					</button>
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
					<select class="form-control select2-enabled section2" name="legal_vpais" id="legal_vpais" disabled>
						<option></option>
						<c:forEach items="${lstCountry}" var="lstCountry">
							<option value="${lstCountry.counBident}">${lstCountry.counVname}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vdepartamento">Localidad:</label>
					<select class="form-control select2-enabled section2" name="legal_vlocalidad" id="legal_vlocalidad" disabled>
						<option></option>
						<c:forEach items="${lstUbigeo}" var="lstUbigeo">
							<option value="${lstUbigeo.ubigIident}">${lstUbigeo.ubigDepart}, ${lstUbigeo.ubigProvinc}, ${lstUbigeo.ubigDistrit}</option>
						</c:forEach>
					</select>
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
					<select class="form-control" name="legal_vtipoPerson" id="legal_vtipoPerson" disabled>
						<option></option>
						<option value="D">Domiciliado</option>
						<option value="ND">No Domiciliado</option>
					</select>
				</div>
				
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="legal_vgrupoCom">Grupo Comercial:</label>
					<select class="form-control select2-enabled section2" name="legal_vgrupoCom" id="legal_vgrupoCom" disabled>
						<option></option>
						<c:forEach items="${lstGrupoCom}" var="lstUbigeo">
							<option value="${lstUbigeo.busgrBident}">${lstUbigeo.busgrVname}</option>
						</c:forEach>
					</select>
				</div>
				
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-4.5 col-xs-6">
		<div class="panel panel-primary text-center border" id="consultarSunatRL" hidden>
			<div class="panel-footer back-footer-blue bg-grey">Consultado en Sunat</div>
			<div class="panel-body">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="natural_vmail">Estado:</label> 
					<div id="estadoSunatRL"></div>
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="natural_vmail">Condición:</label> 
					<div id="condicionSunatRL"> </div>
				</div>
			</div>
		</div>
	</div>
	<div class="x_panel">
		<div class="x_title">
			<h4>Representante Legal</h4>
		</div>
		<div id="datoRepresentanteLegal" class="col-lg-10 col-md-10 col-lg-offset-1">
			<input style="display: none" type="hidden" id="pers_bidentRL" name="pers_bidentRL" required="" value="${repLegalBident}" /> 
			<input style="display: none" type="hidden" id="natu_bident" name="natu_bident" required="" value="${repLegalBidentRL}" />

			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group" id="tipDocRLSelect">
					<label class="control-label" for="pers_vdoctype">Tipo de Documento:</label> 
					<select style="width: 100%" class="form-control filter-single" id="pers_vdoctype" name="pers_vdoctype" disabled>
						<c:forEach items="${listaCatDet}" var="listcat">
							<option value="${listcat.catdCident}">${listcat.catdVdescription}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group" id="tipDocRLInput" style="display: none">
					<label class="control-label" for="pers_vdoctypeView">Tipo de Documento:</label>
					<input type="text" class="form-control" id="pers_vdoctypeView" name="pers_vdoctypeView" placeholder="Número de documento" maxlength="15" required="" value="${repLegalVNumDoc}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc_repleg">N° de Documento:</label> 
					<input type="text" class="form-control" id="pers_vnumdoc_repleg" name="pers_vnumdoc_repleg" placeholder="Número de documento" required="" value="${repLegalVNumDoc}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<button type="button" id="buscar_repre_legal" class="btn btn-primary ladda-button" data-size="s" data-style="expand-right" data-spinner-color="#ffffff" style="margin-top: 23px;"> 
						<span class="ladda-label">Buscar</span>
					</button>
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
						<select class="form-control" name="natural_vtipoPerson" id="natural_vtipoPerson" disabled>
							<option></option>
							<option value="D">Domiciliado</option>
							<option value="ND">No Domiciliado</option>
						</select>
					</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="legal_vpais">Nacionalidad:</label>
					<select class="form-control select2-enabled section2" name="natural_vpais" id="natural_vpais" disabled>
						<option></option>
						<c:forEach items="${lstCountry}" var="lstCountry">
							<option value="${lstCountry.counBident}">${lstCountry.counVname}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="natural_vdepartamento">Localidad:</label>
					<select class="form-control select2-enabled section2" name="natural_vlocalidad" id="natural_vlocalidad" disabled>
						<option></option>
						<c:forEach items="${lstUbigeo}" var="lstUbigeo">
							<option value="${lstUbigeo.ubigIident}">${lstUbigeo.ubigDepart}, ${lstUbigeo.ubigProvinc}, ${lstUbigeo.ubigDistrit}</option>
						</c:forEach>
					</select>
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


