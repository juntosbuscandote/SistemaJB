<div class="x_panel form-horizontal form-label-left input_mask">
	<!-- mtoledo 08/03/2019 CWA-591 
	<div class="form-group" id="divVentaAnticipo" style="display: none">
		<label class="control-label col-md-9 col-sm-9 col-xs-12">Anticipo:</label>
		<div class="col-md-3 col-sm-3 col-xs-12">
			<input class="form-control" id="frmResultadoVentaAnticipo" name="frmResultadoVentaAnticipo" type="text" value="${RestultadoAnticipo}" readonly>
		</div>
	</div>
	<div class="form-group">
			<div class="col-md-1 col-sm-1 col-xs-12"></div>
			<label class="control-label col-md-1 col-sm-1 col-xs-12">BIM: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="frmResultadoBIM"
					name="frmResultadoBIM" type="text" value="${ResultadoBIM}" readonly>
			</div>
			<label class="control-label col-md-1 col-sm-1 col-xs-12">Exonerado: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="frmResultadoExonerado"
					name="frmResultadoExonerado" value="${ResultadoEXONERADO}" type="text" readonly>
			</div>

			<label class="control-label col-md-2 col-sm-2 col-xs-12">Venta
				Gratuita:<output id="simbMonedavtagratuita"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="frmResultadoVentaGratuita"
					name="frmResultadoVentaGratuita" type="text" value="${ResultadoGRATUITA}" readonly>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-1 col-sm-1 col-xs-12"></div>
			<label class="control-label col-md-1 col-sm-1 col-xs-12">INF: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="frmResultadoINF"
					name="frmResultadoINF" type="text" value="${ResultadoINF}" readonly>
			</div>
			<label class=" control-label col-md-1 col-sm-1 col-xs-12">Exportación: </label>
			<div class="col-md-2 col-sm-2 col-xs-12">
				<input class="form-control" id="frmResultadoExportacion"
					name="frmResultadoExportacion" value="${ResultadoEXPORTACION}" title="Porcentaje"
					type="text" readonly>

			</div>
			<label class="control-label col-md-2 col-sm-2 col-xs-12">
				Valor Total:<output id="simbMonedavatot"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="frmResultadoValorTotal"
					name="frmResultadoValorTotal" type="text" value="${ResultadoValorNeto}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12">Descuentos:<output id="simbMonedades"></output>
			</label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="frmResultadoImpDescTot"
					name="frmResultadoImpDescTot" type="text" value="${ResultadoDSCTO}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12">
				Sub Total:<output id="simbMonedatot"></output></label>
			<div class="col-md-3 col-sm-3 col-xs-12 ">
				<div class="input-group">
					<input class="form-control" id="frmResultadoNeto"
					name="frmResultadoNeto" type="text" value="${ResultadoNETO}" readonly>
					<span class="input-group-btn">
						<button type="button" class="btn btn-primary"  id="btnCalcular" title="Ajuste">
							<i class="fa fa-calculator"></i>
						</button>	
					</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12">IGV:<output id="simbMonedaigv"></output>
			</label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="frmResultadoIGV"
					name="frmResultadoIGV" type="text" value="${ResultadoIGV}" readonly>
			</div>
		</div>
		<div class="form-group">
		
		<h2 class="control-label col-md-3 col-sm-3 col-xs-12">Importe a Cobrar:
			<output id="simbMoneda"></output></h2>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control input-lg" id="frmResultadoTotalView"
					name="frmResultadoTotalView" type="text" value="${ResultadoTOTAL}"  readonly>
			</div>

			<label class="control-label col-md-3 col-sm-3 col-xs-12 text-info">Total:
			<output id="simbMonedas"></output>			
			</label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control" id="frmResultadoTotal"
					name="frmResultadoTotal" type="text" value="${ResultadoTOTAL}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-9 col-sm-9 col-xs-12 text-info" id="viewSoles">CONVERSIÓN:
			<output id="conversion1"></output>	
			</label>
			<label class="control-label col-md-9 col-sm-9 col-xs-12 text-success" id="viewDollar" style="display: none">CONVERSIÓN:
			<output id="conversion2">/</output>	
			</label>
			<div class="col-md-3 col-sm-3 col-xs-12">
				<input class="form-control confondo" id="frmResultadoConver"
					name="frmResultadoConver" type="text" value="${ResultadoCONVERS}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-1 col-sm-1 col-xs-12 text-info">SON:
			</label>
			<div class="col-md-11 col-sm-11 col-xs-12">
				<input class="form-control" id="frmResultadoMonto"
					name="frmResultadoMonto" type="text" value="${ResultadoSON}" readonly>
			</div>



		</div>

</div>

-->
<style>
output {
    display: inline;
}
</style>




