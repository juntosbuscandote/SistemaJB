<div class="modal fade" id="modalExplVenta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog modal-lg" role="document" style="width:95% !important">
        <div class="modal-content">
            <div class="x_panel">
                <div class="x_title">
                    <h2> Explorador - Venta <small></small></h2>
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
                    <form class="form-horizontal form-label-left input_mask" id="frmExplVenta" name="frmExplVenta">
                        <div class="col-md-12 col-xs-12">
                        <div class= "x_panel">
<div class="col-md-2 col-sm-4 col-xs-12">
                                            <label>Desde:
                                            </label>
                                            <input class="form-control" id="frmExplVentaFecIni" name="frmExplVentaFecIni" type="date">
                                            <label>Hasta:
                                            </label>
                                            <input class="form-control" id="frmExplVentaFecFinal" name="frmExplVentaFecFinal" type="date">
                                        </div>
                            <div class="col-md-1 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success btn-lg"><i class="fa fa-refresh"></i></button>
                            <label>Actualizar</label>                            
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-12">
                                            <label>Columna:
                                            </label>
                                            <SELECT class="form-control" id="frmExplVentaTipBusq" name="frmExplVentaTipBusq">
                                                <OPTION>    </OPTION>
                                            </SELECT>
                                            <label>Filtro:
                                            </label>
                                            <input class="form-control" id="frmExplVentaNomBusq" name="frmExplVentaNomBusq" type="text">
                                        </div>
                                        <div class="col-md-1 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success btn-lg"><i class="fa fa-search"></i></button>
                            <label>Filtrar</label>                            
                            </div>
                            <div class="col-md-1 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success btn-lg"><i class="fa fa-edit"></i></button>
                            <label>Exportar</label>                            
                            </div>
                            <div class="col-md-1 col-sm-2 col-xs-12">
                            <label><input type="checkbox" id="frmMovVentaAnticipo" name="frmMovVentaAnticipo">Cabecera</label>
                            <label><input type="checkbox" id="frmMovVentaAnticipo" name="frmMovVentaAnticipo">Detalle</label>                           
                            </div>
                            <div class="col-md-1 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success"><i class="fa fa-mail-reply"></i></button>
                            <br>
                            <button type="button" class="btn btn-success"><i class="fa fa-mail-forward"></i></button>                           
                            </div>
                            <div class="col-md-1 col-sm-2 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success btn-lg"><i class="fa fa-print"></i></button>
                            <label>Reportar</label>                            
                            </div>
                            <div class="col-md-1 col-sm-2 col-xs-12">
                            <button type="button" class="btn btn-success btn-lg"><i class="fa fa-close"></i></button>
                            <label>Cerrar</label>                            
                            </div>
                        </div>
                        </div>
                        <div class="col-md-12 col-xs-12">
                            <div class="x_panel">
                            <br/><br/>
                            <div class= "container_fluid">
                                                            <div class="table-responsive">
                                <table id="lstEmpresa" name="lstEmpresa" class="table table-striped table-bordered bulk_action">
                                    <thead>
                                        <tr>
                                            <th><input type="checkbox" id="check-all" class="flat"></th>
                                            <th>Acept</th>
                                            <th>Ejercicio</th>
                                            <th>Periodo</th>
                                            <th>Reg. Ctb</th>
                                            <th>Fec. Mov</th>
                                            <th>Cod. Mot. I/S</th>
                                            <th>Tipo Doc.</th>
                                            <th>Nro Serie</th>
                                            <th>Nro Doc</th>
                                            <th>Cliente</th>
                                            <th>Fec. Emisión</th>
                                            <th>Fec. Vencimiento</th>
                                            <th>Moneda</th>
                                            <th>Camb. Moneda</th>
                                            <th>Observación</th>
                                            <th>Valor Neto</th>
                                            <th>Dscto Aplicado a</th>
                                            <th>Importe</th>
                                            <th>Dscto %</th>
                                            <th>Dscto Imp.</th>
                                            <th>INF</th>
                                            <th>EXO</th>
                                            <th>EXPO</th>
                                            <th>BIM</th>
                                            <th>IGV</th>
                                            <th>VTA Total</th>
                                            <th>Percepción</th>
                                            <th>Percep.%</th>
                                            <th>Total con Percep.</th>
                                            <th>Forma de Pago</th>
                                            <th>Fec. a Cobrar </th>
                                            <th>Cobrado</th>
                                            <th>Vendedor</th>
                                            <th>Area</th>
                                            <th>C. Costo</th>
                                            <th>Nombre C.C.</th>
                                            <th>S.C. Costo</th>
                                            <th>Nombre S.C.</th>
                                            <th>S.S.C. Costo</th>
                                            <th>Nombre S.S.</th>
                                            <th>DR. Cod. Vta</th>
                                            <th>DR. Fec. Emisión</th>
                                            <th>DR. Cod. TD</th>
                                            <th>DR. Nro Sre</th>
                                            <th>DR. Nro. Doc</th>
                                            <th>NroOP</th>
                                           <th>Fec. Registro</th>
                                            <th>Registrado por:</th>
                                            <th>Fec. Modificación</th>
                                            <th>Modificado por:</th>
                                            <th>FileAdd</th>
                                            <th>Anulado</th>
                                            <th>Remitente</th>
                                            <th>Destinatario</th>
                                            <th>Punto de Partida</th>
                                            <th>Punto de Entrega - Empresa</th>
                                            <th>Punto de Entrega - Cliente</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${DtoEmpresa}" var="oDtoEmpresa">
                                        <tr>
                                            <td><input type="checkbox" class="flat" name="table_records"></td>
                                            <td>${oDtoEmpresa.ruc}</td>
                                            <td>${oDtoEmpresa.rSocial}</td>
                                            <td>${oDtoEmpresa.direccion}</td>
                                            <td>${oDtoEmpresa.telef}</td>
                                            <td><button type="submit" class="fa fa-edit" data-toggle="modal" data-target="#myModal" id="edit"></button>
                                                <button type="submit" class="fa fa-trash-o" data-toggle="modal" data-target="#myModal"></button>
                                                <button type="submit" class="fa fa-eye" data-toggle="modal" data-target="#myModal"></button> 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-xs-12" id="detalles" style="display: block">
                                <div class="x_panel">
                                <div class= "container_fluid">
                                                            <div class="table-responsive">
                                    <table id="lstEmpresa" name="lstEmpresa" class="table table-striped table-bordered bulk_action">
                                        <thead>
                                            <tr>
                                                <th><input type="checkbox" id="check-all" class="flat"></th>
                                                <th>Item</th>
                                                <th>Código</th>
                                                <th>Cód. Comercial</th>
                                                <th>Producto</th>
                                                <th>Medida</th>
                                                <th>PU</th>
                                                <th>Cantidad</th>
                                                <th>Medida Secundaria</th>
                                                <th>Cantidad Secundaria</th>
                                                <th>Valor</th>
                                                <th>IMP</th>
                                               <th>Otros Imp. Afectos</th>
                                                <th>Otros Imp. Inafectos</th>
                                                <th>IGV</th>
                                                <th>Total</th>
                                                <th>Percep. %</th>
                                                <th>Percep. Imp</th>
                                                <th>Total Neto</th>
                                                <th>C. Costos</th>
                                                <th>S.C. Costos</th>
                                                <th>S.S.C. Costos</th>
                                                <th>Observación</th>
                                                <th>Almacen</th>
                                                <th>Ind. Afecto Vta.</th>
                                                <th>Costo Modificado por</th>
                                                <th>CU</th>
                                                <th>CU_ME</th>
                                                <th>Costo_ME</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${DtoEmpresa}" var="oDtoEmpresa">
                                            <tr>
                                                <td><input type="checkbox" class="flat" name="table_records"></td>
                                                <td>${oDtoEmpresa.ruc}</td>
                                                <td>${oDtoEmpresa.rSocial}</td>
                                                <td>${oDtoEmpresa.direccion}</td>
                                                <td>${oDtoEmpresa.telef}</td>
                                                <td><button type="submit" class="fa fa-edit" data-toggle="modal" data-target="#myModal" id="edit"></button>
                                                    <button type="submit" class="fa fa-trash-o" data-toggle="modal" data-target="#myModal"></button>
                                                    <button type="submit" class="fa fa-eye" data-toggle="modal" data-target="#myModal"></button> 
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    </div>
                                    </div>
                                </div>
                            </div> 
                        </div>                       

                    </form>                                                            
                </div>
            </div>
        </div>
    </div>
</div>
