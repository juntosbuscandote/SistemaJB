<div class="modal fade" id="modalNotaBuscarDoc"
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
<!-- 									class="form-control filter-single" -->
<!-- 									id="listaComprobantefacbol" name="listaComprobantefacbol"> -->
<!-- 									<option value="">Seleccione...</option> -->
<!-- 									<option value="01">Factura</option> -->
<!-- 									<option value="03">Boleta</option> -->
<!-- 								</select> -->
<!-- 							</div> -->
							<div class="col-md-3 col-sm-4 col-xs-12 form-group">
								<label class="control-label">Fecha Movimiento:</label> <input
									class="form-control" id="fechaMovVentafacbol"
									value="${fechademovimiento}" name="fechaMovVentafacbol">
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 form-group ctd">
								<label class="control-label">Serie:</label> <input
									class="form-control" id="serieVentafacbol" value="${VentaSerie}"
									name="serieVentafacbol" type="text">
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 form-group ctd">
								<label class="control-label">Nro. CP:</label> <input
									class="form-control" value="${VentaNroDoc}" id="nroCompVentafacbol"
									name="nroCompVentafacbol" type="text">
							</div>
						</div>
						<div class="row">

							<div class="col-md-8 col-sm-5 col-xs-12 form-group">
								<label class="control-label"> Cliente:</label>
								 <select
									class="form-control select2-single" id="clienteVentafacbol"
									name="clienteVentafacbol">
									<option value="">Seleccione...</option>
									<c:forEach items="${filtrarClienteNroC}"
										var="filtrarVendedorNros">
										<option attr-tipdoc="${filtrarVendedorNros.persVdoctype}"
<%-- 											attr-numdoc="${filtrarVendedorNros.pers_vnumdoc}" --%>
											attr-nombre="${filtrarVendedorNros.nombre}"
											value="${filtrarVendedorNros.pers_vnumdoc}">${filtrarVendedorNros.pers_vnumdoc}
											- ${filtrarVendedorNros.nombre}</option>
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
									title="Limpiar Filtro" id="btn_clean">
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
										<th>Tipo CP</th>
										<th>Fecha</th>
										<th>Serie</th>
										<th>Nro CP</th>
										<th>Monto</th>
										<th>Moneda</th>
										<th>Cliente</th>
										<th>Estado sunat</th>
										<th>baja</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</form>
<!-- 			<div class="x_panel" > -->
				<input type="hidden" value="" id="idCompra" name="idCompra">
				<input type="hidden" value="" id="idCompraparaNotC" name="idCompraparaNotC">
				<div class="x_content">
		<div class="container_fluid" id="PanelDetalle" style="display:none">

			<div class="table-responsive">
				<table id="lstGrillaCompras" name="lstGrillaCompras"
					class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12"
					cellspacing="0" width="100%">
					<thead>
						<tr>
<!-- 							<th>Acciones</th> -->
						<th><input type="checkbox" id="check-all" class="flat"></th>
								<th>ACCIONES</th>
								<th>NUMERO</th>
								<th>CODIGO</th>
								<th>CODIGO PRESENTACION</th>
								<th>CODIGO COMERCIAL</th>
								<th>CONCEPTO</th>
								<th>UNIDAD MEDIDA</th>
								<th>CANTIDAD</th>
<!-- 								<th>INCLUYE IGV</th> -->
								<th>V. VENTA UNITARIA</th>
								<th>IGV UNITARIO</th>
								<th>PRECIO UNITARIO</th>
								<th>VALOR VENTA</th>
								<th>IGV</th>
								<th>PRECIO DE VENTA</th>
								<th>% DSCTO. UNIT.</th>
								<th>IMP. DSCTO TOTAL</th>
								<th>V. VTA. TOTAL CON DSCTO </th>
								<th>IGV TOTAL CON DSCTO</th>
								<th>PRECIO VENTA CON DSCTO</th>
								<th>BASE IMPONIBLE</th>								
								<th>IGV TOTAL</th>
								<th>TOTAL BRUTO</th>
								<th>TOTAL NETO</th>
								<th>INDICADOR AFECTO</th>
								<th>T. DE INDICADOR AFECTO</th>
								<th>T. MONEDA ORIGEN</th>
								<th>T. MONEDA DESTINO</th>
								<th>TIPO CAMBIO</th>
								<th>TRANSFERENCIA GRATUITA</th>
								<th>OBSERVACION</th>
								<th>TIPO</th> 
								<th>CODIGO ALMACEN</th> 
								<th>NOM CORTO</th> 
								<th>DESCRIPCION</th> 
								<th>PRECIO DESCRIPCION PRODUCTO</th> 
								<th>PRECIO PRINCIPAL</th> 
								<th>NOMBRE MARCA</th> 
								<th>NOMBRE CORTO MARCA</th> 
								<th>NOMBRE DESCRIPCION MARCA</th>
								<th>PRECIO DESCRIPCION</th>
								<th class="codigoDetVen">ID DETALLE VENTA</th>
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
				<button type="reset" class="btn btn-success" id="SalirFacBol">Salir</button>
				</div>
			</div>
<!-- 		</div> -->
	</div>
</div>