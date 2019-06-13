<input type="hidden" id="persBcodcountry" value="${PersBcodcountry}" />
<script>
function calcLong(txt, formul){
    var tipodoc=$("#frmVendedorTipDoc").val();
var largo;
var dni=8;
var ruc=11;
var carnet=12;
var pasaporte=12;
var ndomici=15;
var otros=15;
largo = formul[txt].value.length

if (tipodoc=="0"){
if (largo > otros )
formul[txt].value = formul[txt].value.substring(0,otros)

}else if (tipodoc=="1"){
	if (largo > dni )
	    formul[txt].value = formul[txt].value.substring(0,dni)

}else if (tipodoc=="4"){
	if (largo > carnet )
	    formul[txt].value = formul[txt].value.substring(0,carnet)
	
}else if (tipodoc=="6"){
	if (largo > ruc)
	    formul[txt].value = formul[txt].value.substring(0,ruc)

}else if (tipodoc=="7"){
	if (largo > pasaporte )
	    formul[txt].value = formul[txt].value.substring(0,pasaporte)

}else if (tipodoc=="10"){
	if (largo > ndomici )
	    formul[txt].value = formul[txt].value.substring(0,ndomici)

}

}
</script>
<form class="form-horizontal form-label-left input_mask" onKeyUp="calcLong('frmVendedorNroDoc', this)" id="frmVendedor" name="frmVendedor">
    <div id="" class="col-lg-10 col-md-10 col-xs-12 col-md-offset-1">
        <input style="display: none" type="hidden" id="pers_bidentUser" name="pers_bidentUser" required="" value="${usuario.persBident}" />
        <input type="hidden" class="form-control" id="pers_vnumdocempresa"
               name="pers_vnumdocempresa" value="${usuarioFilter.legaBident}" maxlength="11" />
        <input  type="hidden" id="codigoVendedor" 
                name="codigoVendedor" required="" value="${PersBident}" />

        <div class="row">
            <div class="col-lg-6 col-md-6 col-xs-12 form-group" id="selectTipDoc" style="display: block">
            	<label class="control-label">Tipo de Documento:</label>
                <SELECT class="form-control" required="required" id="frmVendedorTipDoc" name="frmVendedorTipDoc" value="${PersVdoctype}" disabled="disabled">
                    <c:forEach items="${listaCatDet}" var="listcat">
                        <option value="${listcat.catdCident}">${listcat.catdVdescription}</option>
                    </c:forEach>
                </SELECT>
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group" id="inputTipDoc" style="display: none">
            	<label class="control-label">Tipo de Documento:</label>
                <input class="form-control" id="frmVendedorTipDocVista" name="frmVendedorTipDocVista" type="text" maxlength="50" value="${PersVdoctype}" disabled="disabled">
            </div>
            <div class="col-lg-3 col-md-3 col-xs-12 form-group">
            	<label class="control-label">Nro. Documento:</label>
                <input class="form-control" id="frmVendedorNroDoc" name="frmVendedorNroDoc" type="text"  value="${PersVnumdoc}" placeholder="Número Documento">
            </div>
            <div class="col-lg-3 col-md-3 col-xs-12 form-group">
            	<button class="btn btn-primary ladda-button" type="button" name="btnValidVendedor" id="btnValidVendedor" data-style="expand-right" style="margin-top: 23px;">
						<span class="ladda-label">Validar Vendedor</span>
				</button>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-xs-12 form-group">
            	<label class="control-label">Apellido Paterno:</label>
                <input class="form-control" id="frmVendedorApePat" name="frmVendedorApePat" type="text" maxlength="50" value="${NatuVlastnamefather}" placeholder="Apellido Paterno" readonly="readonly">
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group">
            	<label class="control-label">Apellido Materno:</label>
                <input class="form-control" id="frmVendedorApeMat" name="frmVendedorApeMat" type="text" maxlength="50" value="${NatuVlastnamemother}" placeholder="Apellido Materno" readonly="readonly">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-xs-12 form-group">
            	<label class="control-label">Nombres:</label>
                <input class="form-control" id="frmVendedorNombre" name="frmVendedorNombre" type="text" maxlength="50" value="${NatuVname}" placeholder="Nombres" readonly="readonly">
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group" id="selectPais" style="display: block">
            	<label class="control-label">País:</label>
                <SELECT class="form-control select2-single select2-hidden-accessible" required="required" id="frmVendedorPais" name="frmVendedorPais" value="" disabled="disabled">
                    <c:forEach items="${listaPais}" var="listPais">
                        <option value="${listPais.counBident}">${listPais.counVname}</option>
                    </c:forEach>
                </SELECT>
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group" id="selectPaisEditar" style="display: none">
            	<label class="control-label">País:</label>
                <SELECT class="form-control" required="required" id="frmVendedorPaisEditar" name="frmVendedorPaisEditar" value="">
                    <c:forEach items="${listaPais}" var="listPais">
                        <option value="${listPais.counBident}">${listPais.counVname}</option>
                    </c:forEach>
                </SELECT>
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group" id="inputPais" style="display: none">
            	<label class="control-label">País:</label>
                <input class="form-control" id="frmVendedorPaisVista" name="frmVendedorPaisVista" type="text" maxlength="300" value="${PersBcodcountry}" disabled="disabled">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-xs-12 form-group">
            	<label class="control-label">Dirección:</label>
                <input class="form-control" id="frmVendedorDireccion" name="frmVendedorDireccion" type="text" maxlength="250" value="${AddrVaddress}" placeholder="Dirección" readonly="readonly">
            </div>
            <!--                                                                             <div class="col-md-2 col-sm-2 col-xs-12"> -->
            <!--                                                                                 <label> -->
            <!--                                                                                     <input type="checkbox" id="frmVendedorExtranjero" name="frmVendedorExtranjero"> Es Extranjero -->
            <!--                                                                                 </label> -->
            <!--                                                                             </div> -->
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-xs-12 form-group">
            	<label class="control-label">Teléfono:</label>
                <input class="form-control" id="frmVendedorTelefono" name="frmVendedorTelefono" type="text" maxlength="15" value="${PhonVphone}" placeholder="Teléfono" readonly="readonly">
            </div>
            <div class="col-lg-6 col-md-6 col-xs-12 form-group">
            	<label class="control-label">Correo:</label>
                <input class="form-control" id="frmVendedorCorreo" name="frmVendedorCorreo" type="text" maxlength="50" value="${MailVemail}" placeholder="Correo" readonly="readonly">
            </div>
        </div>
    </div>
</form>