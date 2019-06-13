<div class="x_panel form-horizontal form-label-left input_mask">
		<div class="form-group">
			<label class="control-label col-md-2 col-sm-2 col-xs-12">BIM GG: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="bimGGCompra"
					name="bimGGCompra" type="text" value="${modfBIMGG}" readonly>
			</div>
			<label class="control-label col-md-1 col-sm-1 col-xs-12">IGV: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="igvGGCompra"
					name="igvGGCompra" value="${modfIGVGG}" type="text" readonly>
			</div>
			<label class="control-label col-md-2 col-sm-2 col-xs-12">Valor Compra:
			<output id="simbMonedavalcompra"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="baseImponibleCompra"
					name="baseImponibleCompra" type="text" value="${modfValCompra}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2 col-sm-2 col-xs-12">BIM GGN: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="bimGGNCompra"
					name="bimGGNCompra" type="text" value="${modfBIMGGN}" readonly>
			</div>
			<label class=" control-label col-md-1 col-sm-1 col-xs-12">IGV: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="igvGGNCompra"
					name="igvGGNCompra" value="${modfIGVGGN}" title="Porcentaje"
					type="text" disabled="disabled">

			</div>
			<label class="control-label col-md-2 col-sm-2 col-xs-12">
				ISC: <output id="simbMonedaisc"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="icsCompra"
					name="icsCompra" type="text" value="${modfISC}" readonly>
			</div>
			
		</div>
		<div class="form-group">
			<label class="control-label col-md-2 col-sm-2 col-xs-12">BIM GN: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="bimGNCompra"
					name="bimGNCompra" type="text" value="${modfBIMGN}" readonly>
			</div>
			<label class=" control-label col-md-1 col-sm-1 col-xs-12">IGV: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="igvGNCompra"
					name="igvGNCompra" value="${modfIGVGN}" title="Porcentaje"
					type="text" disabled="disabled">

			</div>
			<label class="control-label col-md-2 col-sm-2 col-xs-12">
				IGV: <output id="simbMonedaigv"></output> </label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="igvCompra"
					name="igvCompra" type="text" value="${modfIGV}" readonly>
			</div>
<!-- 			<label class="control-label col-md-2 col-sm-2 col-xs-12"> -->
<!-- 				ISC: </label> -->
<!-- 			<div class="col-md-3 col-sm-3 col-xs-12"> -->
<!-- 				<input class="form-control" id="icsCompra" -->
<%-- 					name="icsCompra" type="text" value="${ResultadoNETO}" disabled="disabled"> --%>
<!-- 			</div> -->
<!-- 			<label class="control-label col-md-2 col-sm-2 col-xs-12">Total Bruto: -->
<!-- 			</label> -->
<!-- 			<div class="col-md-3 col-sm-3 col-xs-12"> -->
<!-- 				<input class="form-control" id="totalBrutoCompra" -->
<%-- 					name="totalBrutoCompra" type="text" value="${ResultadoDSCTO}" disabled="disabled"> --%>
<!-- 			</div> -->
		</div>
		<div class="form-group">
			<label class="control-label col-md-2 col-sm-2 col-xs-12">BIM N: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="bimNCompra"
					name="bimNCompra" type="text" value="${modfBIMN}" readonly>
			</div>
			<label class="control-label col-md-5 col-sm-5 col-xs-12">
				Total Bruto: <output id="simbMonedaTotalbruto"></output> </label>
						<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="totalBrutoCompra"
					name="totalBrutoCompra" type="text" value="${modfTotalBruto}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12">Otros tributos:
			<output id="simbMoneotrosatrib"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="otrosTributosCompra"
					name="otrosTributosCompra" type="text" value="${modfOtrosAtributos}" readonly>
			</div>
		</div>
		<div class="form-group">

			<label class="control-label col-md-9 col-sm-9 col-xs-12">Total Neto:
			<output id="simbMonedaTotNeto"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="totalNetoCompra"
					name="totalNetoCompra" type="text" value="${modfTotalNeto}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12" id="viewSoles">CONVERSIÓN:
			<output id="conversion1"></output>	
			</label>
			<label class="control-label col-md-9 col-sm-9 col-xs-12 text-success" id="viewDollar" style="display: none">CONVERSIÓN:
			<output id="conversion2"></output>	
			</label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="conversionCompra"
					name="conversionCompra" type="text" value="${modfConversion}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-1 col-sm-1 col-xs-12 text-info">SON:
			</label>
			<div class="col-md-11 col-sm-11 col-xs-12">
				<input class="form-control" id="montoCompra"
					name="montoCompra" type="text" value="${modfTotalenLetras}" readonly>
			</div>



		</div>

</div>

<style>
output {
    display: inline;
}
</style>



