<!-- mtoledo 08/03/2019 CWA-591 -->
<div class="modal fade" id="modalLstAnticipo" role="dialog" data-keyboard="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form method="post" action="" id="frm_insert_anticipo" name="frm_insert_anticipo">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Anticipos</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6 col-sm-12 col-xs-12">
							<label class="control-label">Tipo CP :</label> 
							<input class="form-control" type="text" value=""  disabled="true" id="txtTipoCPAnticipo" name="txtTipoCPAnticipo">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Serie - Numero:</label>
							 <select style="width: 100%" class="form-control filter-single" id="lstSerieAnticipo" name="lstSerieAnticipo">
								<option value=""></option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Fecha Anticipo:</label> 
							<input class="form-control" type="text" value="" disabled="true" id="txtFechaAnticipo" name="txtFechaAnticipo">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Total Anticipo:</label> 
							<input class="form-control" type="text" value="" disabled="true" id="txtTotalAnticipo" name="txtTotalAnticipo">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Monto Disponible:</label> 
							<input class="form-control" type="text" value="" disabled="true" id="txtMontoDisponibleAnticipo" name="txtMontoDisponibleAnticipo">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Monto a Utilizar:</label> 
							<input class="form-control" type="text" value="" 	id="txtMontoUtilizarAnticipo" name="txtMontoUtilizarAnticipo">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Saldo final:</label> 
							<input class="form-control" type="text" value="" disabled="true"  id="txtSaldoFinalAnticipo" name="txtSaldoFinalAnticipo">
						</div>
					</div>

				</div>
				<!--BOTONES -->
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary ladda-button" data-style="expand-right" id="btnAgregarAnticipo">Agregar Servicio</button>
					<button type="button" class="btn btn-success" id="btnEndAnticipos" name="btnEndAnticipos" data-dismiss="modal"> 
						<span>Terminar</span>
					</button>

				</div>
			</form>
		</div>
	</div>
</div>