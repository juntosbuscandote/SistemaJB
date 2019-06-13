
<%   
String rol = ((Long)request.getSession().getAttribute("role")+""); 
					boolean adminis=false;
					boolean userSistemas=false;
					boolean userSistemasfinal=false;
	
					if(rol.equals("3")){
						adminis=true;
                    }else if(rol.equals("1")){
						userSistemas=true;	
					}else if(rol.equals("2")){
						userSistemasfinal=true;	
					}
				%>
 <% if(adminis){ %>
<form class="form-horizontal form-label-left" id="frmUser" name="frmUser">
<div class="x_panel">
    	<div class="x_title">
            <h4> Informacion Personal </h4>
       </div>
    <div class="x_content">
	<div class="form-group" id="Vruc" style="display: block">
		<label class="control-label col-md-4 col-sm-4 col-xs-12"
			for="pers_vnumdoc">DNI :</label>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<input type="text" class="form-control" id="pers_vnumdoc"
				name="pers_vnumdoc" required="" value="${userPersNumdoc}" maxlength="11" />
		</div>
		<div class="col-md-3 col-sm-3 col-xs-12">
		     <button class="btn btn-primary ladda-button"  type="button" name="validRuc" id="validRuc" data-style="expand-right">Validar </button>
		</div>
	</div>

		<div class="form-group" id="ListaCatalogoDetalle">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vdoctype">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 <select style="width:100%" class="form-control filter-single" 
                   id="listaCatDet" name="listaCatDet" disabled="disabled">
                   <c:forEach items="${listaCatDet}" var="listcat"> 
				<option value="${listcat.catdCident}">${listcat.catdVdescription}</option>
					</c:forEach> 
				   </select>
			</div>
		</div>
		
		<div class="form-group" id="TipDoc" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="TipDocS">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="TipDocS"
					name="TipDocS" required="" value="${Tipodocumento}"  disabled="disabled" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vnumdocs">Número de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="pers_vnumdocs" maxlength="15"
					name="pers_vnumdocs" required="" value="${userPersNumdocUser}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vname">Nombres :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vname"
					name="natu_vname" required="" value="${userPersName}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamefather">Apellido Paterno :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamefather"
					name="natu_vlastnamefather" required="" value="${userPerslastfather}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamemother">Apellido Materno :</label>   
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamemother"
					name="natu_vlastnamemother" required="" value="${userPerslastmother}"   disabled="disabled"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="mail_vemail">Correo Electrónico :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="mail_vemail"
					name="mail_vemail" required="" value="${userPersemail}" disabled="disabled"  />
			</div>
		</div>
		<div class="form-group"  >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="phon_vphone">Telefono :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="phon_vphone" maxlength="15"
					name="phon_vphone" required="" value="${userPersphone}"  disabled="disabled" />
			</div>
		</div>
		<div class="form-group" style="display: none" >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_bident">Natubident :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_bident"
					name="natu_bident" required="" value="${natu_bident}" disabled="disabled"   />
			</div>
		</div>	
	</div>
</div>
<div class="x_panel" id="frmtitu2" >
    	<div class="x_title" >
            <h4> Informacion de Usuario </h4>
       </div>
    <di v class="x_content" >
		<div class="form-group" id="frmProf">
				<label class="control-label col-md-4 col-sm-4 col-xs-12"
					for="prof_vdescriptioninsert">Perfil :</label>
				<div class="col-md-4 col-sm-4 col-xs-12">
                   
                   <select style="width:100%" class="form-control filter-single" 
                   id="listaProfile" name="listaProfile" disabled="disabled" >
                   <c:forEach items="${listaProfile}" var="profil"> 
				<option value="${profil.profBident}">${profil.profVdescription}</option>
					</c:forEach> 
				   </select>
				
				</div>
			
		</div>
		<div class="form-group" id="Vuser" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vuser">Usuario :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="user_vuser"
					name="user_vuser" required="" value="${userUser}" disabled="disabled" />
			</div>
		</div>
		<div class="form-group" id="Vpass" style="display: block">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vpassword">Contraseña :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="user_vpassword"
					name="user_vpassword" required="" value="${userPassw}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group" id="Vrpass" style="display: block">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vRepassword">Confirmar Contraseña :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="user_vRepassword"
					name="user_vRepassword" required="" value="${userPassw}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group" id="Vperfil" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="prof_vdescription">Perfil :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="prof_vdescription"
					name="prof_vdescription" required="" value="${userUser}" disabled="disabled" />
			</div>
		</div>
		<div class="form-group" id="Vbussi" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="lega_businame">Empresa :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="lega_businame"
					name="lega_businame" required="" value="${userUser}" disabled="disabled" />
			</div>
		</div>
		<input  type="hidden" id="pers_bidentUser" 
		name="pers_bidentUser" required="" value="${usuario.persBident}" />				
	</div>
</div>
</form>
 <%    } %>
 <% if(userSistemas){ %>
<form class="form-horizontal form-label-left" id="frmUser" name="frmUser">
<div class="x_panel">
    	<div class="x_title">
            <h4> Informacion Personal </h4>
       </div>
    <div class="x_content">
	<div  class="form-group" id="VCodEmpresa" >
		<label class="control-label col-md-4 col-sm-4 col-xs-12"
			for="pers_vnumdocempresa" style="display: none">Codigo Empresa :</label>
		<div class="col-md-2 col-sm-2 col-xs-12">
			<input type="hidden" class="form-control" id="pers_vnumdocempresa"
				name="pers_vnumdocempresa" value="${usuarioFilter.legaBident}" maxlength="11" />
		</div>
	</div>
		<div class="form-group" id="ListaCatalogoDetalle">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vdoctype">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 <select style="width:100%" class="form-control filter-single" 
                   id="listaCatDet" name="listaCatDet" >
                   <c:forEach items="${listaCatDet}" var="listcat"> 
				<option value="${listcat.catdCident}">${listcat.catdVdescription}</option>
					</c:forEach> 
				   </select>
			</div>
		</div>
		
		<div class="form-group" id="TipDocUser" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="TipDocSUser">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="TipDocSUser"
					name="TipDocSUser" required="" value="${Tipodocumento}" disabled="disabled"  />
			</div>
		</div>
		<div class="form-group" id="NomUserCrea">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vnumdocUser">Número de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="pers_vnumdocUser" maxlength="15"
					name="pers_vnumdocUser" required="" />
			</div>
		</div>
		
			<div class="form-group" id="NomUserModf" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vnumdocUserModf">Número de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="pers_vnumdocUserModf" maxlength="15"
					name="pers_vnumdocUserModf" required="" value="${userPersNumdocUser}" disabled="disabled" />
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vname">Nombres :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vname"
					name="natu_vname" required="" value="${userPersName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamefather">Apellido Paterno :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamefather"
					name="natu_vlastnamefather" required="" value="${userPerslastfather}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamemother">Apellido Materno :</label>   
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamemother"
					name="natu_vlastnamemother" required="" value="${userPerslastmother}"   />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="mail_vemail">Correo Electrónico :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="mail_vemail"
					name="mail_vemail" required="" value="${userPersemail}"   />
			</div>
		</div>
		<div class="form-group"  >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="phon_vphone">Telefono :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="phon_vphone" maxlength="15"
					name="phon_vphone" required="" value="${userPersphone}"    />
			</div>
		</div>
		<div class="form-group" style="display: none" >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_bident">Natubident :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_bident"
					name="natu_bident" required="" value="${natu_bident}"    />
			</div>
		</div>	
			<input style="display: none" type="hidden" id="pers_bidentUser" 
		name="pers_bidentUser" required="" value="${usuario.persBident}" />		
	</div>
</div>
<div class="x_panel" id="frmtitu3" >
    	<div class="x_title" >
            <h4> Informacion de Usuario </h4>
       </div>
    <div class="x_content" >
		<div class="form-group" id="frmProf">
				<label class="control-label col-md-4 col-sm-4 col-xs-12"
					for="prof_vdescriptioninsert">Perfil :</label>
				<div class="col-md-4 col-sm-4 col-xs-12">
                   
                   <select style="width:100%" class="form-control filter-single" 
                   id="listaProfile" name="listaProfile"  >
                   <c:forEach items="${listaProfile}" var="profil"> 
				<option value="${profil.profBident}">${profil.profVdescription}</option>
					</c:forEach> 
				   </select>
				
				</div>
			</div>
		<div class="form-group" id="Vuser" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vuser">Usuario :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="user_vuser"
					name="user_vuser" required="" value="${userUser}" />
			</div>
		</div>
		<div class="form-group" id="Vpass" style="display: block">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vpassword">Contraseña :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="user_vpassword"
					name="user_vpassword" required="" value="${userPassw}" />
			</div>
		</div>
		<div class="form-group" id="Vrpass" style="display: block">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="user_vRepassword">Confirmar Contraseña :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="user_vRepassword"
					name="user_vRepassword" required="" value="${userPassw}" />
			</div>
		</div>
		<div class="form-group" id="Vperfil" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="prof_vdescription">Perfil :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="prof_vdescription"
					name="prof_vdescription" required="" value="${userUser}"  />
			</div>
		</div>
		<div class="form-group" id="Vbussi" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="lega_businame">Empresa :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="lega_businame"
					name="lega_businame" required="" value="${userUser}"  />
			</div>
		</div>
				
	</div>
</div>
			

</form>
  <%    } %>
 <% if(userSistemasfinal){ %>
 <form class="form-horizontal form-label-left" id="frmUser" name="frmUser">
<div class="x_panel">
    	<div class="x_title">
            <h4> Informacion Personal </h4>
       </div>
    <div class="x_content">
	<div  class="form-group" id="VCodEmpresa" >
		<label class="control-label col-md-4 col-sm-4 col-xs-12"
			for="pers_vnumdocempresa" style="display: none">Codigo Empresa :</label>
		<div class="col-md-2 col-sm-2 col-xs-12">
			<input type="hidden" class="form-control" id="pers_vnumdocempresa"
				name="pers_vnumdocempresa" value="${usuarioFilter.legaBident}" maxlength="11" />
		</div>
	</div> 
		<div class="form-group" id="ListaCatalogoDetalle">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vdoctype">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
		 <select style="width:100%" class="form-control filter-single" 
                   id="listaCatDet" name="listaCatDet" >
                   <c:forEach items="${listaCatDet}" var="listcat"> 
				<option value="${listcat.catdCident}">${listcat.catdVdescription}</option>
					</c:forEach> 
				   </select>
			</div>
		</div>
		
		<div class="form-group" id="TipDoc" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="TipDocS">Tipo de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="TipDocS"
					name="TipDocS" required="" value="${Tipodocumento}" disabled="disabled"  />
			</div>
		</div>
		<div class="form-group" id="NomUserCrea">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vnumdocUser">Número de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="pers_vnumdocUser" maxlength="15"
					name="pers_vnumdocUser" required="" value="${userPersNumdocUser}"/>
			</div>
		</div>
		
			<div class="form-group" id="NomUserModf" style="display: none">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="pers_vnumdocUserModf">Número de Documento :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="pers_vnumdocUserModf" maxlength="15"
					name="pers_vnumdocUserModf" required="" value="${userPersNumdocUser}"  />
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vname">Nombres :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vname"
					name="natu_vname" required="" value="${userPersName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamefather">Apellido Paterno :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamefather"
					name="natu_vlastnamefather" required="" value="${userPerslastfather}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_vlastnamemother">Apellido Materno :</label>   
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_vlastnamemother"
					name="natu_vlastnamemother" required="" value="${userPerslastmother}"   />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="mail_vemail">Correo Electrónico :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="mail_vemail"
					name="mail_vemail" required="" value="${userPersemail}"   />
			</div>
		</div>
		<div class="form-group"  >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="phon_vphone">Telefono :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="phon_vphone" maxlength="15"
					name="phon_vphone" required="" value="${userPersphone}"    />
			</div>
		</div> 
		
		
		
		<div class="form-group" style="display: none" >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="natu_bident">Natubident :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="natu_bident"
					name="natu_bident" required="" value="${natu_bident}"    />
			</div>
		</div>	
		<input style="display: none" type="hidden" id="pers_bidentUser" 
		name="pers_bidentUser" required="" value="${usuario.persBident}" />		
	</div>
</div>
</form>
<%    } %>

