<form class="form-horizontal form-label-left input_mask" id="frmSeries" name="frmSeries">
	<div class="x_panel">
		<div class="x_title">
			<h4>Datos Generales</h4> 
		</div>

		<input type=hidden id="validEmpr" name="validEmpr" value="${validBussines}" /> 
		<input type=hidden id="seriId" name="seriId" value="${seriId}" />
		<input type=hidden id="sucursal" name="sucursal" value="${sucursal}" />
		<input type=hidden id="tipoDoc" name="tipoDoc" value="${tipoDoc}" />
		<input type=hidden id="seriId2" name="seriId2" value="${seriId2}" />
		<input type=hidden id="busiBident" name="busiBident" value="${busiBident}" />
		<input type="hidden" id="proccess"   value="${proccess}" />

		<div id="datoGenerales" class="col-lg-6 col-md-6 col-xs-12 col-md-offset-3">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					<label class="control-label">Tipo Comprobante:</label>
					 <select
						style="width: 100%" class="form-control filter-single "
						id="listaCatDetComp" name="listaCatDetComp">
						<c:forEach items="${listaCatDetCPE}" var="listcatindicadorbs">
							<option value="${listcatindicadorbs.catdCident}">${listcatindicadorbs.catdVdescription}</option>
						</c:forEach>
					 </select>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-xs-12 form-group">
					<label class="control-label" for="serie">Serie:</label>					
					<input type="text" class="form-control" id="serieNro" name="serieNro" placeholder="serie"  onkeyup="myFunction()" value="${serie}" maxlength="4" />
				</div>
			</div>
		</div>
	</div>
	<div class="x_panel">
		<div class="x_title">
			<h4>Asociar Sucursal</h4> 
		</div>
		<div id="datoGenerales" class="col-lg-10 col-md-10  col-lg-offset-1">
			<div class="row">	
				<div class="col-lg-12 col-md-12 col-xs-12 form-group select2-parent">
					<label class="control-label" >Sucursal:</label>
					<select class="form-control select2-enabled section2" name="sucu_empr" id="sucu_empr" >
						<c:forEach items="${TlBranch}" var="TlBranch">
							<option value="${TlBranch.offiBident}">${TlBranch.offiVname}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>	
</form>
<script>
function myFunction() {
    var x = document.getElementById("serieNro");
    x.value = x.value.toUpperCase();
}
</script>
