


<div class="modal fade" id="modalDocAnticipo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="x_panel">
                <div class="x_title">
                    <h2> VENTAS: Documentos Anticipos </h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Settings 1 </a>
                                </li>
                                <li><a href="#">Settings 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a id="close-link" data-dismiss="modal"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form class="form-horizontal form-label-left input_mask" id="frmProNuePrec" name="frmProNuePrec">
                        <div class="x_panel">
                            <div class="col-md-4 col-xs-6">
                                <label class="control-label" >Fecha Movimiento:</label>
                                <input class="form-control input-sm" id="frmMovVentaFecMov" name="frmMovVentaFecMov" type="date">
                            </div>
                            <div class="col-md-4 col-xs-6">
                                <label class="control-label" >Busqueda:</label>
                                <SELECT class="form-control input-sm" id="frmMovVentaPeriodo" name="frmMovVentaPeriodo">
                                    <OPTION>    </OPTION>
                                </SELECT>
                                <label class="control-label" >Filtro:</label>
                                <SELECT class="form-control input-sm" id="frmMovVentaPeriodo" name="frmMovVentaPeriodo">
                                    <OPTION>    </OPTION>
                                </SELECT>
                            </div>
                            <div class="col-md-2 col-xs-12">
                                <button type="button" class="btn btn-success btn-lg"><i class="fa fa-search"></i></button>
                                <label>Buscar</label>                            
                            </div>
                            <div class="col-md-2 col-xs-12">
                                <button type="button" class="btn btn-success btn-lg"><i class="fa fa-file-text"></i></button>
                                <label>Exportar</label>                            
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-5 col-xs-12">
                                <label class="control-label col-md-6 col-xs-6">
                                    <input type="radio" value="1" id="frmMovVentaOpcOP" name="frmMovVentaOpc" onchange="habilitar(this.value);">Ver Todos
                                </label>
                                <label class="control-label col-md-6 col-xs-6">
                                    <input type="radio" checked value="2" id="frmMovVentaOpcVta" name="frmMovVentaOpc" onchange="habilitar(this.value);">Ver Cliente
                                </label>
                            </div>
                            <div class="col-md-2 col-xs-6">
                                <SELECT class="form-control input-sm" id="frmMovVentaPeriodo" name="frmMovVentaPeriodo">
                                    <OPTION>    </OPTION>
                                </SELECT>
                            </div>
                            <div class="col-md-2 col-xs-6">
                                <SELECT class="form-control input-sm" id="frmMovVentaPeriodo" name="frmMovVentaPeriodo">
                                    <OPTION>    </OPTION>
                                </SELECT>
                            </div>
                            <div class="col-md-3 col-xs-6">
                                <input class="form-control input-sm" id="frmMovVentaFecMov" name="frmMovVentaFecMov" type="date">
                            </div>
                        </div>
                        <div class= "container_fluid">
									<div class="table-responsive">  
                                        <table id="lstEmpresa" name="lstEmpresa"
										class="table table-striped table-bordered nowrap col-md-12 col-sm-12 col-xs-12" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th><input type="checkbox" id="check-all" class="flat"></th>
												<th>COD DE VENTA</th>
												<th>FECHA DE MOVIMIENTO </th>
												<th>SERIE</th>
												<th>DOCUMENTO</th>
												<th>NUMERO DE DOC</th>
												<th>COD MONEDA</th>
												<th>MONEDA</th>
												<th>TIPO DE CAMPO</th>
												<th>COD CLIENTE </th>
												<th>NUM DOC CLIENTE</th>
												<th>NOMBRE CLIENTE</th>
												<th>BIM</th>
												<th>IGV</th>
												<th>TOTAL</th>

											</tr>

										</thead>
										<tbody>
										</tbody>
									</table>
									</div>
									</div>
                        
                    </form>
                    <div class="ln_solid"></div>
                    <!--BOTONES -->
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-primary">Guardar</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div> 
                    <!--BOTONES -->
                </div>
            </div>
        </div>
    </div>
</div>