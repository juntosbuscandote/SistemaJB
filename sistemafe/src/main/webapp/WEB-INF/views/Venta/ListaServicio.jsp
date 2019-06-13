<div class="modal fade" id="modalLstServicio"  role="dialog" data-keyboard="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
           <form method="post" action="" id="frm_insert_servicio" name="frm_insert_servicio">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    	<h4 class="modal-title">Agregar servicio</h4>
					</div>
					<div class="modal-body">
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
								<select style="width: 100%" class="form-control filter-single" id="listaUniMedidas" name="listaUniMedidas">
									<option value=""></option>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div> 
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Cantidad:</label>
								<input class="form-control" type="text" value="" placeholder="0.0000" id="frmCantidads" name="frmCantidads">
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Precio:</label>
								<select style="width: 100%" class="form-control filter-single" id="listaPrecios" name="listaPrecios">
										<option value=""></option>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
<label> <input type="checkbox" class="select-checkbox"
				id="frmEditarPrecioServicio"  name="frmEditarPrecioServicio" > Editar Precio
			</label>
							</div>
							
							<div class="row" id="nuevoPrecioSer" style="display: none">
						<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Nuevo Precio:</label>
								<input class="form-control" type="text" value="" placeholder="0.00" id="frmPrecioNuevoServicio" name="frmPrecioNuevoServicio" disabled>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
						</div>
							
						</div>
						
						
						 <div class="row">
                              <div class="col-md-12 col-sm-12 col-xs-12">
                                   <label class="control-label"> Observación:</label>
                                   <input class="form-control" id="frmMovVentaObsServ" name="frmMovVentaObsServ" type="text">
                               </div>
                         </div>
						
						
					</div>
						<!--BOTONES -->
					<div class="modal-footer text-center">
							<button type="button" class="btn btn-primary ladda-button"  data-style="expand-right" id="frmAgregarServicio">Agregar Servicio</button>
							<button type="button" class="btn btn-success" id="TerminarInsertProd" name="TerminarInsertProd" data-dismiss="modal" ><span>Terminar</span></button>
							
					</div>
				</form>
			</div>
		</div>
	</div>