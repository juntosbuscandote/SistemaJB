<div class="modal fade" id="modalBuscarFactura" tabindex="-1"
	role="dialog" data-keyboard="true">
	<div class="modal-dialog modal-lg" role="document"
		style="width: 70% !important">
		<div class="modal-content">
			<form class="form-horizontal form-label-left input_mask"
				id="frmFactBuscar" name="frmFactBuscar" method="post" action="">
				<div class="modal-header">
					<h4 class="modal-title">Comprobante</h4>
				</div>
				<!-- 				<div class="modal-body"> -->
				<input type="hidden" value id="codipro" name="codipro">
				<!-- <div class="row"> -->

				<div class="col-md-12 col-sm-12 col-xs-12" style="width: 100%">
					<fieldset class="fielset-filtros">
						<div class="row">
<!-- 							<div class="col-md-3 col-sm-4 col-xs-12 form-group"> -->
<!-- 								<label class="control-label">Tipo Comprobante:</label> <select -->
<!-- 									style="width: 100%" -->
<!-- 									class="form-control" -->
<!-- 									id="listaComprobantefacbol" name="listaComprobantefacbol"> -->
<!-- 									<option value="">Selecione...</option> -->
<!-- 									<option value="01">FACTURA</option> -->
<!-- 									<option value="03">BOLETA DE VENTA</option> -->
									
<!-- 								</select> -->
<!-- 							</div> -->
							<div class="col-md-3 col-sm-4 col-xs-12 form-group">
								<label class="control-label">Fecha Emisión:</label> <input
									class="form-control" id="fechaEmiComprafacbol"
									value="${fechademovimiento}" name="fechaEmiComprafacbol">
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 form-group ctd">
								<label class="control-label">Serie:</label> <input
									class="form-control" id="serieComprafacbol" value="${VentaSerie}"
									name="serieComprafacbol" type="text">
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 form-group ctd">
								<label class="control-label">Nro. CP:</label> <input
									class="form-control" value="${VentaNroDoc}" id="nroCompComprafacbol"
									name="nroCompComprafacbol" type="text">
							</div>
						</div>
						<div class="row">

							<div class="col-md-8 col-sm-5 col-xs-12 form-group">
								<label class="control-label"> Proveedor:</label> <select
									class="form-control select2-single" id="proveedorComprafacbol"
									name="proveedorComprafacbol">
									<option value="">Selecione...</option>
									<c:forEach items="${filtrarProveedorNroP}"
										var="filtrarVendedorNros">
										<option attr-tipdoc="${filtrarVendedorNros.persVdoctype}"
											attr-numdoc="${filtrarVendedorNros.persVnumdoc}"
											attr-nombre="${filtrarVendedorNros.nombres}"
											value="${filtrarVendedorNros.nombres}">${filtrarVendedorNros.persVnumdoc}-${filtrarVendedorNros.nombres}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3 col-sm-4 col-xs-12 search-btn ">
								<br />
								<!-- 												<br /> -->

								<button type="button" class="btn btn-primary"
									data-spinner-color="#ffffff" title="Filtrar" id="btn_searchfiltrofacbol">
									<i class="fa fa-search"></i>
								</button>
								<button type="reset" class="btn btn-success"
									title="Limpiar Filtro" id="btn_cleanfac">
									<i class="fa fa-trash"></i>
								</button>

							</div>
						</div>
					</fieldset>




					<!-- <div class="x_content"> -->
					<div class="container_fluid">
						<div class="table-responsive">
							<table id="lstExploradorVentaDetalles"
								name="lstExploradorVentaDetalles"
								class="table table-striped table-bordered bulk_action nowrap col-md-12 col-sm-12 col-xs-12"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Acciones</th>
										<th>Cod. Reg.</th>
										<th>Tipo CP</th>
										<th>Fecha</th>
										<th>Serie</th>
										<th>Nro CP</th>
										<th>Monto</th>
										<th>Moneda</th>
										<th>Proveedor</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</form>
<!-- 			<div class="x_panel" > -->
				<input type="hidden" value="${idcodCompra}" id="idCompra" name="idCompra">
				<input type="hidden" value="12" id="idCompraparaNotC" name="idCompraparaNotC">
				<input type="hidden" value="" id="aqui" name="aqui">
				<input type="hidden" value="" id="idDetalle" name="idDetalle">
				<div class="x_content">
		<div class="container_fluid" id="PanelDetalle" style="display:none">

				
			<div class="table-responsive">
				<table id="lstGrillaCompras" name="lstGrillaCompras"
					class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
					cellspacing="0" width="100%">
					<thead>
						<tr>
<!--  							<th></th>  -->
 <th><input type="checkbox" id="check-all" class="flat"></th>
							<th>Item</th>
							<th>Codigo comercial</th>
							<th>Concepto</th>
							<th>Unidad de Medida</th>
							<th>Cantidad</th>
							<th>V. unitaria</th>
							<th>Valor compra</th>
							<th>ISC</th>
							<th>ISC Total</th>
							<th>IGV unitario</th>
<!--  							<th>IGV</th>  -->
							<th>Precio unitario</th>
							<th>Base imponible</th>
							<th>IGV total</th>
							<th>Total bruto</th>
							<th>Otros tributos y Cargos</th>
							<th>Total neto</th>
							<th>Indicador Afecto</th>
							<th>Tipo cambio</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Observacion</th>
							<th>Cod. Detalle</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
				<div class="modal-footer text-center">
				<button type="button" class="btn btn-primary" id="mostrarSel" style="display: none">Seleccionar</button>
				<button type="button" class="btn btn-primary" id="btnAgregafac">Terminar</button>
					<button type="reset" class="btn btn-success" id="btnSalirfacbol">Salir</button>
				</div>
			</div>
<!-- 		</div> -->
	</div>
</div>