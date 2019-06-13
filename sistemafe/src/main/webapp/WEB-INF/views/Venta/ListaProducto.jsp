<div class="modal fade" id="modalLstProducto" role="dialog" data-keyboard="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form method="post" action="" id="frm_insert_producto" name="frm_insert_producto">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    	<h4 class="modal-title">Agregar producto</h4>
					</div>
					<div class="modal-body">
						<div class="row">	            						
							<div class="col-md-12 col-sm-12 col-xs-12">
								<label class="control-label">Producto:</label>
								<select class="form-control select2-single" id="listaProducto" name="listaProducto">
									<option value="">seleccionar</option>
									<c:forEach items="${listaProducto}" var="listProducto">
										<option  value="${listProducto.prodBident}">${listProducto.prodVmainName} - ${listProducto.prodBcod1}</option>
				 					</c:forEach>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
							</div>
							<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Unidad de Medida:</label>
								<select style="width: 100%" class="form-control filter-single" id="listaUniMedida" name="listaUniMedida">
									<option value=""></option>
								</select>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Stock:</label>
								<input class="form-control" type="text" value="" placeholder="0.00" id="frmStock" name="frmStock" disabled>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Precio:</label>
								<select style="width: 100%" class="form-control filter-single" id="listaPrecio" name="listaPrecio">
										<option value=""></option>
								</select>
								<label> <input type="checkbox" class="select-checkbox"
				id="frmEditarPrecio"  name="frmEditarPrecio" > Editar Precio
			</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Cantidad:</label>
								<input class="form-control" type="text" value="" placeholder="0.00" id="frmCantidad" name="frmCantidad">
							</div>
						</div>
						<div class="row" id="nuevoPrecio" style="display: none">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<label class="control-label">Nuevo Precio:</label>
								<input class="form-control" type="text" value="" placeholder="0.00" id="frmPrecioNuevo" name="frmPrecioNuevo" disabled>
<!-- 								<span class="label label-default"><a href="url">ver detalle</a></span> -->
							</div>
						</div>
						<br> 
						 <div class="row">
                              <div class="col-md-12 col-sm-12 col-xs-12">
                                   <label class="control-label"> Observación:</label>
                                   <input class="form-control" id="frmMovVentaObsProd" name="frmMovVentaObsProd" type="text">
                               </div>
                         </div>
					</div>
						<!--BOTONES -->
					<div class="modal-footer text-center">
							<button type="button" class="btn btn-primary ladda-button"  data-style="expand-right" id="frmAgregarProducto" ><span class="ladda-label">Agregar Producto</span></button>
							<button type="button" class="btn btn-success"  id="TerminarInsertProd" name="TerminarInsertProd" data-dismiss="modal" ><span>Terminar</span></button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<SCRIPT type="text/javascript">
function crit_busqueda() {
  var input=document.getElementById('texto_busqueda').value.toLowerCase();
  var output=document.getElementById('id_textos').options;
  for(var i=0;i<output.length;i++) {
    if(output[i].value.indexOf(input)==0){
      output[i].selected=true;
      }
    if(document.forms[0].texto_busqueda.value==''){
      output[0].selected=true;
      }
  }
}
</SCRIPT>