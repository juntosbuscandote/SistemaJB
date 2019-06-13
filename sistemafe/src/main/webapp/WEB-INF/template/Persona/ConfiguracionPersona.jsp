<div class="x_panel">
	<div class="x_title">
		<h4>Datos Generales</h4>
	</div>
	<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-xs-12 form-group">
				<label class="radio-inline"> 
				<input type="radio" value="1" id="frmTipoPersonNatural" name="frmTipoPerson" checked>Persona natural</label> 
				<label class="radio-inline"> 
				<input type="radio" value="2" id="frmTipoPersonLegal" name="frmTipoPerson">Persona jurídica</label>
			</div>
		</div>
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
			
			<div class="panel panel-primary text-center border" id="consultarrENIEC" hidden>
				<div class="panel-footer back-footer-blue bg-grey">Consultado en RENIEC</div>
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
		<form id="frmDocumento" name="frmDocumento">
			<input type="hidden" id="proccess"   value="${proccess}"   />
			<input type="hidden" id="idpais" 	 value="${idpais}" 	   />
			<input type="hidden" id="idubigeo"   value="${idubigeo}"   />
			<input type="hidden" id="tipoPerson" value="${tipoPerson}" />
			<input type="hidden" id="idPerson" 	 value="${idPerson}"   />
			<input type="hidden" id="idtipodoc"  value="${idtipodoc}"  />
			<input type="hidden" id="domiciled"  value="${domiciled}"  />
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group" id="tipDocSelect">
					<label class="control-label" for="empr_vdoctype">Tipo de Documento:</label> 
					<select style="width: 100%" class="form-control filter-single tipodoc" id="pers_vdoctype" name="pers_vdoctype" disabled />
						<c:forEach items="${listaCatDet}" var="listcat">
							<option value="${listcat.catdCident}" cantidad="${listcat.catdVsymbol}">${listcat.catdVdescription}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="pers_vnumdoc">N° de Documento:</label> 
					<input type="text" class="form-control solo-numero" onfocus="this.value=''"  id="pers_vnumdoc" name="pers_vnumdoc" placeholder="Número de RUC" value="${numdoc}" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<button class="btn btn-primary ladda-button" type="button" name="btnValidNum" id="btnValidNum" data-style="expand-right" style="margin-top: 23px;">
						<span class="ladda-label">Buscar Persona</span>
					</button>
				</div>
			</div>
		</form>
		<form id="frmNaturalPersona" name="frmNaturalPersona">
			<div id="personNatural">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vname">Nombres:</label> 
						<input type="text" class="form-control" id="natural_vname" name="natural_vname" maxlength="50" placeholder="Nombres"  value="${naturalName}" readonly="readonly" />
					</div>
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vlastnamefather">Apellido Paterno:</label> 
						<input type="text" class="form-control" id="natural_vlastnamefather" name="natural_vlastnamefather" maxlength="50" placeholder="Apellido Paterno"  value="${naturalLastnamefather}" readonly="readonly" />
					</div>
					<div class="col-lg-4 col-md-4 col-xs-12 form-group">
						<label class="control-label" for="natural_vlastnamemother">Apellido Materno:</label> 
						<input type="text" class="form-control" id="natural_vlastnamemother" name="natural_vlastnamemother" maxlength="50" placeholder="Apellido Materno"  value="${naturalLastnameMother}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vmail">Nombre Comercial:</label> 
						<input type="text" class="form-control" id="natural_vtradename" name="natural_vtradename" maxlength="500" placeholder="Nombre Comercial"  value="${naturalTradename}" readonly="readonly" />
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
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vmail">Email:</label> 
						<input type="text" class="form-control" id="natural_vmail" name="natural_vmail" maxlength="50" placeholder="Correo electrónico"  value="${naturalMail}" readonly="readonly" />
					</div>
					<div class="col-lg-6 col-md-6 col-xs-12 form-group">
						<label class="control-label" for="natural_vphone">Telefono:</label>
						<input type="text" class="form-control" id="natural_vphone" name="natural_vphone" maxlength="15" placeholder="Celular" value="${naturalPhone}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
						<label class="control-label" for="natural_vpais">Nacionalidad:</label>
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
					<div class="col-lg-12 col-md-12 col-xs-12 form-group">
						<label class="control-label" for="natural_vaddress">Dirección Legal:</label> 
						<input type="text" class="form-control" id="natural_vaddress" name="natural_vaddress" maxlength="250" placeholder="Dirección Legal"  value="${naturalAddress}" readonly="readonly" />
					</div>
				</div>
			</div>
		</form>
		<form id="frmLegalPersona" name="frmLegalPersona">
		<div id="personLegal" >
			<div class="row">
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vbusiname">Razón Social:</label> 
					<input type="text" class="form-control" id="legal_vbusiname" name="legal_vbusiname" maxlength="500" placeholder="Razón Social"  value="${legalBusiname}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vtradename">Nombre Comercial:</label> 
					<input type="text" class="form-control" id="legal_vtradename" name="legal_vtradename" maxlength="500" placeholder="Nombre Comercial"  value="${legalTradename}" readonly="readonly" />
				</div>
				<div class="col-lg-4 col-md-4 col-xs-12 form-group">
					<label class="control-label" for="legal_vphone">N° Telefono:</label> 
					<input type="text" class="form-control" id="legal_vphone" name="legal_vphone" maxlength="15" placeholder="Número de teléfono" value="${legalPhone}" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
					<label class="control-label" for="legal_vpais">Nacionalidad:</label>
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
					<label class="control-label" for="legal_vmail">Email:</label> 
					<input type="text" class="form-control" id="legal_vmail" name="legal_vmail" maxlength="50" placeholder="Correo Electrónico"  value="${legalEmail}" readonly="readonly" />
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 form-group">
					<label class="control-label" for="legal_vaddress">Dirección Legal:</label> 
					<input type="text" class="form-control" id="legal_vaddress" name="legal_vaddress" maxlength="250" placeholder="Dirección Legal"  value="${legalAddress}" readonly="readonly" />
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
			</div>
		</div>
		</form>
	</div>
</div>
