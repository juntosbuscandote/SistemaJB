<div class="modal fade" id="modalAgregarProducto" role="dialog" data-keyboard="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form class="form-horizontal form-label-left input_mask" id="frmAgregarProd" name="frmAgregarProd" method="post" action="">
				<div class="modal-header">
					<h4 class="modal-title">Producto</h4>
				</div>
				<div class="modal-body">
			<input type="hidden" value id="codipro" name="codipro"> 
					<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
								<label class="control-label">Producto:</label>
								<select class="form-control select2-single" id="listaProducto" name="listaProducto">
									<option value=""></option>
									<c:forEach items="${listaProducto}" var="listProducto">
										<option  value="${listProducto.prodBident}"  attr-nombre="${listProducto.prodBident}">${listProducto.prodVmainName} - ${listProducto.prodBcod1}</option>
				 					</c:forEach>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12">
								<label class="control-label">Presentación:</label>
								<select style="width: 100%" class="form-control filter-single" id="listaUniMedida" name="listaUniMedida">
								</select>	
							</div>
					</div>
					<div class="row">
											<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Stock :</label> 
							<input class="form-control" value="${StockTotal}" id="frmAgregaProdStock" name="frmAgregaProdStock" placeholder="Stock" readonly="readonly">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6" style="display:none">
							<label class="control-label">Stock oculto :</label>
							<input class="form-control" id="frmAgregarNewStockCant" name="frmAgregarNewStockCant" type="text"  placeholder="Cantidad">
						</div>
                        <div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Cantidad :</label>
							<input class="form-control" id="frmAgregaProdCant" name="frmAgregaProdCant" type="text"  placeholder="Cantidad">
						</div>
						<input type="hidden" value="" id="NomCortoCP" name="NomCortoCP">
						<input type="hidden" value="" id="DescoCP" name="DescoCP">
					</div>
<!-- 					<h5 >Costo :</h5> -->
					<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">ISC :</label> 
							<input class="form-control" value="0.00" id="frmAgregaProdISC" name="frmAgregaProdISC" placeholder="ISC">
						</div>						
						
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Base Imponible Unitario:</label>
							 <input class="form-control" id="frmAgregaProdBasImp" name="frmAgregaProdBasImp" placeholder="Base Imponible">
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
							<input class="form-control" id="frmAgregaProdIGV" name="frmAgregaProdIGV" placeholder="IGV" >
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Precio con IGV Unitario:</label> 
							<input class="form-control" id="frmAgregaProdPreIGV" name="frmAgregaProdPreIGV" placeholder="Precio con IGV">
						</div>
					</div>
					<div class="row">
						
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Otros tributos y cargos :</label> 
							<input class="form-control" value="0.00" id="frmAgregaProdOtrosAtrib" name="frmAgregaProdOtrosAtrib" placeholder="Otros tributos y cargos">
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<label class="control-label">Total :</label> 
							<input class="form-control" id="frmAgregaProdTotal" name="frmAgregaProdTotal" readonly="readonly" placeholder="Total">
						</div>
					</div>
			
					 <div class="row">
                              <div class="col-md-12 col-sm-12 col-xs-12">
                                   <label class="control-label"> Observación:</label>
                                   <input class="form-control" id="frmMovVentaObsProd" name="frmMovVentaObsProd" type="text">
                               </div>
                         </div>
                         	</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary" id="AgregarProd">Agregar</button>
					<button type="button" class="btn btn-success" id="btnSalirProd" name="btnSalirProd">Terminar</button>
				</div>
			</form>
		</div>
	</div>
</div>




