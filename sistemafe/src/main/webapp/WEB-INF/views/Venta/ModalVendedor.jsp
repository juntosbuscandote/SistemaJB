<div class="modal fade" id="modalVendedor" role="dialog" aria-labelledby="myModalLabel" >
                                            <div class="modal-dialog modal-lg" role="document">
                                                <div class="modal-content">
                                                    <div class="x_panel">
                                                        <div class="x_title">
                                                            <h2>Vendedor</h2>
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
                                                            <%@include file="../../template/Vendedor/ConfiguracionVendedor.jsp"%>
                                                            <!--BOTONES -->
                                                            <div class="ln_solid"></div>
                                                            <div class="progress-demo">
											<button class="btn btn-primary ladda-button" data-style="expand-right"  type="button" id="btnProccessVendedor" ><span>Guardar</span></button>
											<button type="button" class="btn btn-success" id="btnSalirVendedor" name="btnSalirVendedor">Salir</button>
										</div>
                                                            <!--BOTONES -->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                                                            