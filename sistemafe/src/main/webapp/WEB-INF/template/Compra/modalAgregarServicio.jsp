<div class="modal fade" id="modalAgregarServicio" role="dialog" data-keyboard="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form class="form-horizontal form-label-left input_mask" id="frmAgregarServ" name="frmAgregarServ" method="post" action="">
				<div class="modal-header">
					<h4 class="modal-title">Servicio</h4>
				</div>
				<div class="modal-body">
			<input type="hidden" value id="codipro" name="codipro"> 
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
								<label class="control-label">Servicio:</label>
								<select class="form-control select2-single" id="listaServicio" name="listaServicio">
									<option value="">seleccione</option>
									<c:forEach items="${listaServicio}" var="listServicio">
										<option value="${listServicio.servBident}">${listServicio.servVsecondName} - ${listServicio.servVmainName}</option>
									</c:forEach>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
							</div>
							<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Unidad de Medida:</label>
								<select style="width: 100%" class="form-control filter-single" id="listaUniMedidas" readonly="readonly" name="listaUniMedidas">
									<option value=""></option>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div> 
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Cantidad:</label>
								<input class="form-control" type="text" value="" placeholder="0.0000" id="frmAgregarServCantidads" name="frmAgregarServCantidads">
							</div>
						</div>
							<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Base Imponible Unitario:</label>
							 <input class="form-control" id="frmAgregarServBasImp" name="frmAgregarServBasImp" placeholder="Base Imponible">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6" Style="display:none">
							<label class="control-label">Name Corto :</label>
							 <input class="form-control" id="filtrarCorto" name="filtrarCorto" >
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6" Style="display:none">
							<label class="control-label">Name Completo :</label>
							 <input class="form-control" id="filtrarCompleto" name="filtrarCompleto">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">IGV Unitario:</label> 
							<input class="form-control" id="frmAgregarStockIGV" name="frmAgregarStockIGV" placeholder="IGV" >
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Precio con IGV Unitario:</label> 
							<input class="form-control" id="frmAgregarServPreIGV" name="frmAgregarServPreIGV" placeholder="Precio con IGV">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Total :</label> 
							<input class="form-control" id="frmAgregarServTotal" name="frmAgregarServTotal" readonly="readonly" placeholder="Total">
						</div>
					</div>
						
						 <div class="row">
                              <div class="col-md-12 col-sm-12 col-xs-12">
                                   <label class="control-label"> Observación:</label>
                                   <input class="form-control" id="frmMovVentaObsServ" name="frmMovVentaObsServ" type="text">
                               </div>
                         </div>
                         </div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary" id="AgregarServ">Agregar</button>
					<button type="button" class="btn btn-success" id="btnSalirServ">Terminar</button>
				</div>
			</form>
		</div>
	</div>
</div>




