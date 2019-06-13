<%-- 
    Document   : modalSunat
    Created on : 15-jul-2017, 16:32:41
    Author     : User
--%>
<%--<%@include file="../Global/header.jsp" %>
<%@include file="../Global/nav.jsp" %>--%>
<div class="modal fade" id="modalSunat" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  >
    <div class="modal-dialog" role="document" style="width:50% !important">
        <div class="modal-content">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Form Design <small>different form elements</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="cerrarModalS"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Settings 1</a>
                                </li>
                                <li><a href="#">Settings 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a id="cerrarModalS" data-dismiss="modal"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div style="width: 680px; height: 500px">
                        <iframe style="width: 100%; height: 100%" src="http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias"></iframe>
                    </div>
                    <div class="ln_solid"></div> 
                    <!--BOTONES -->
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-primary" id="frmEmpresaGuardar">Importar Información</button>
                            <button type="submit" class="btn btn-success" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div> 
                    <!--BOTONES -->
                </div>
            </div>
        </div>
    </div>
</div>
<%--<%@include file="../Global/footer.jsp" %>--%>
<script>
    
</script>