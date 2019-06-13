<div class="modal fade" id="modalEditGriCompra" role="dialog" data-keyboard="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form class="form-horizontal form-label-left input_mask" id="frmEditarDetCompra" name="frmEditarDetCompra" method="post" action="">
				<div class="modal-header">
					<h4 class="modal-title">Editar Valores </h4>
				</div>
				<div class="modal-body">
			<input type="hidden" value id="codipro" name="codipro"> 
			<input type="hidden" value id="codipro2" name="codipro2"> 
			<input type="hidden" value id="codipro3" name="codipro3"> 
			<input type="hidden" value id="pdetbident" name="pdetbident"> 
			<input type="hidden" value id="codstore" name="codstore"> 
			<input type="hidden" value id="cantidadrestar" name="cantidadrestar"> 
			<input type="hidden" value id="codColum" name="codColum"> 
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Codigo Comercial:</label> 
							<input class="form-control" id="frmEditarCompraCodComercial" name="frmEditarCompraCodComercial"  placeholder="Codigo Comercial" readonly="readonly">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Concepto:</label> 
							<input class="form-control" value="${StockTotal}" id="frmEditarCompraConcepto" name="frmEditarCompraConcepto" placeholder="Concepto" readonly="readonly">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Unidad de medida:</label> 
							<input class="form-control" id="frmEditarCompraUnidadMedida" name="frmEditarCompraUnidadMedida"  placeholder="Unidad de Medida" readonly="readonly">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Cantidad :</label>
							<input class="form-control" id="frmEditarCompraCant" name="frmEditarCompraCant" type="text"  placeholder="Cantidad">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">V. Unitario:</label>
							 <input class="form-control" id="frmEditarValorVunit" name="frmEditarValorVunit" placeholder="Valor Unitario">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">V. Compra:</label> 
							<input class="form-control" id="frmEditarValorCompra" name="frmEditarValorCompra" placeholder="Valor Compra" readonly="readonly">
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">ISC:</label>
							 <input class="form-control" id="frmEditarISC" name="frmEditarISC" placeholder="ISC">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">ISC total:</label> 
							<input class="form-control" id="frmEditarISCtotal" name="frmEditarISCtotal" placeholder="ISC Total" readonly="readonly">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">IGV Unitario:</label> 
							<input class="form-control" id="frmEditarIGVUnitario" name="frmEditarIGVUnitario" placeholder="IGV Unitario">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Precio Unitario:</label>
							 <input class="form-control" id="frmEditarPrecioVunit" name="frmEditarPrecioVunit" placeholder="Precio Unitario">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Base Imponible:</label> 
							<input class="form-control" id="frmEditarBaseImp" name="frmEditarBaseImp" placeholder="Base imponible" readonly="readonly">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">IGV Total:</label> 
							<input class="form-control" id="frmEditarIGVTotal" name="frmEditarIGVTotal" placeholder="IGV Total" readonly="readonly">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Total Bruto:</label>
							 <input class="form-control" id="frmEditarTotalBruto" name="frmEditarTotalBruto" placeholder="Total Bruto" readonly="readonly">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Otros tributos cargos:</label> 
							<input class="form-control" id="frmEditarOtrosAtrib" name="frmEditarOtrosAtrib" placeholder="Otros atributos">
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<label class="control-label">Total Neto:</label> 
							<input class="form-control" id="frmEditarTotalNeto" name="frmEditarTotalNeto" placeholder="Total Neto" readonly="readonly">
						</div>
					</div>
					<div class="row">
						
						<div class="col-md-12 col-sm-6 col-xs-6">
							<label class="control-label">Observación:</label> 
							<input class="form-control" id="frmEditarCompraObserv" name="frmEditarCompraObserv"  placeholder="Observación">
						</div>
					</div>
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="GuardarEditarGrilla">Terminar</button>
					<button type="button" class="btn btn-success" id="btncancelareditar" name="btncancelareditar" >Cancelar</button></div>
			</form>
		</div>
	</div>
</div>




		