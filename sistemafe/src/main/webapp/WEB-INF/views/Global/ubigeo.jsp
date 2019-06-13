<div class="modal fade" id="modalUbigeo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Ubigeo <small></small></h2>
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
                        <li><a id="cerrarModalU" data-dismiss="modal"><i class="fa fa-close"></i></a>
                        </li>
<!--                        <li><a id="close-link"><i class="fa fa-close"></i></a>
                        </li>-->
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form class="form-horizontal form-label-left input_mask" id="frmUbigeo" name="frmUbigeo">
                        <div class="form-group">
                            <label class="control-label col-md-5 col-sm-5 col-xs-12">Departamento:<span class="required"></span>
                            </label>
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <SELECT class="form-control" required="required" id="frmUbigeoDep" name="frmUbigeoDep">
                                    <OPTION>      </OPTION>
                                    <OPTION>      </OPTION>
                                </SELECT>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-sm-5 col-xs-12">Provincia:<span class="required"></span>
                            </label>
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <SELECT class="form-control" required="required" id="frmUbigeoProv" name="frmUbigeoProv">
                                    <OPTION>      </OPTION>
                                    <OPTION>      </OPTION>
                                </SELECT>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-sm-5 col-xs-12">Distrito:<span class="required"></span>
                            </label>
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <SELECT class="form-control" required="required" id="frmUbigeoDist" name="frmUbigeoDist">
                                    <OPTION>      </OPTION>
                                    <OPTION>      </OPTION>
                                </SELECT>
                            </div>
                        </div>
                        <div class="ln_solid"></div> 
                        <!--BOTONES -->
                        <div class="form-group">
                            <div class="col-md-5 col-sm-5 col-xs-12 ">
                                <button type="button" class="btn btn-primary">Guardar</button>
                            </div>
                            <div class="col-md-5 col-sm-5 col-xs-12 ">
                                <button type="submit" class="btn btn-success" data-dismiss="modal">Cancelar</button>
                            </div>
                        </div> 
                        <!--BOTONES -->
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!--<script>
    $("#cerrarModalU").click(function () {
        $('#modalUbigeo').modal('toggle');
    });
</script>-->