<form class="form-horizontal form-label-left" id="frmPass" name="frmPass">
<div class="x_panel">
    	<div class="x_title" >
            <h4> Informacion de Usuario </h4>
       </div>
    <div class="x_content" >
<!--     <div class="form-group" id="Vuser" style="display: block" > -->
<!-- 			<label class="control-label col-md-4 col-sm-4 col-xs-12" -->
<!-- 				for="pers_vnumdocUser">Número de Documento :</label> -->
<!-- 			<div class="col-md-4 col-sm-4 col-xs-12"> -->
<!-- 				<input type="text" class="form-control" id="pers_vnumdocUser" -->
<%-- 					name="pers_vnumdocUser" required="" value="${userPersNumdocUser}"  /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="form-group" id="Vpass" >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="userPassw">Contraseña Actual :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="text" class="form-control" id="userPassw"
					name="userPassw" required="" value="${userPassw}"  />
			</div>
		</div>
		<div class="form-group" id="Vpassnew" >
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="userPasswNew">Contraseña Nueva :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="userPasswNew"
					name="userPasswNew" required="" value="${userPasswNew}"  />
			</div>
		</div>
		<div class="form-group" id="Vrpassnewrep">
			<label class="control-label col-md-4 col-sm-4 col-xs-12"
				for="userPasswNewRep">Confirmar Contraseña Nueva :</label>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<input type="password" class="form-control" id="userPasswNewRep"
					name="userPasswNewRep" required="" value="${userPasswNewRep}" />
			</div>
		</div>	
		
			
	</div>
</div>

</form>