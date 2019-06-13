+<div class="modal fade" id="modalPersona" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="x_panel">	
				<div class="x_title" id="titlecliente">
					<h2>Crear Cliente</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a id="close-link" data-dismiss="modal"> <i
								class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_title" id="titlevendedor">		
					<h2>Crear Vendedor</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a id="close-link" data-dismiss="modal"> <i
								class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_title" id="titleproveedor" style="display: none">
					<h2>Crear Proveedor</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a id="close-link" data-dismiss="modal"> <i
								class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<input type="hidden" id="fProcessCliente" value="${fProcessCliente}" />
					<%@include file="../../template/Persona/ConfiguracionPersona.jsp"%>
					<div class="form-group" id="grbcliente">
						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3">
							<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnClienteGuardar">Guardar</button>
							<button type="button" class="btn btn-success" data-dismiss="modal" id="btnSalirCliente">Salir</button>
						</div>
					</div>
					<div class="form-group" id="grbvendedor">
					<div id="datoEmpresa"class="col-lg-10 col-md-10  col-lg-offset-1">
							<input type="hidden" id="idEmpr"   value="${idEmpr}"   />
							<form id="frmEmpresa" name="frmEmpresa">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-xs-12 form-group select2-parent">
										<label class="control-label" for="emp_empresa">Empresa:</label>
										<select class="form-control select2-enabled section2" name="emp_empresa" id="emp_empresa" disabled>
											<c:forEach items="${lstTBussines}" var="lstTBussines">
												<option value="${lstTBussines.busibident}">${lstTBussines.legaBusiname}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3">
							<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProccessVendedor">
											<span>Guardar</span>
							</button>
							<button type="button" class="btn btn-success" data-dismiss="modal" id="btnSalirCliente">Salir</button>
						</div>
					</div>
					<div class="form-group" id="grbproveedor" style="display: none">
						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3">
							<button class="btn btn-primary ladda-button" data-style="expand-right" type="button" id="btnProveedorGuardar">
											<span>Guardar</span>
							</button>
							<button type="button" class="btn btn-success" data-dismiss="modal" id="btnSalirCliente">Salir</button>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>



<script src="<c:url value='../resources/v1/ClienteController.js'/>" type="text/javascript"></script>
<script src="<c:url value='../resources/v1/PersonaController.js'/>" type="text/javascript"></script>
<script src="<c:url value='../resources/v1/VendedorController.js'/>" type="text/javascript"></script>
<script src="<c:url value='../resources/v1/ProveedorController.js'/>" type="text/javascript"></script>
<script type="text/javascript">
	$(document).on('ready', function() {
		var personaController = new PersonaController();
		personaController.init();
		var cliente = new Cliente();
		cliente.objPerson=personaController;
		cliente.init();
		
		var vendedorproccess = new VendedorProccess();
		vendedorproccess.objPerson=personaController;
		vendedorproccess.init();
		
		var proveedor = new Proveedor();
		proveedor.objPerson=personaController;
		proveedor.init();
		
	});
</script>