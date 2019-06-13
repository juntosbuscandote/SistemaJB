<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="../Global/header.jsp" %>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="../Global/nav.jsp" %>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Facturación Electrónica</h3>
                            </div>
                            <div class="title_right">




                                <!--                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                                                    <div class="input-group">
                                                                        <input type="text" class="form-control" placeholder="Search for...">
                                                                        <span class="input-group-btn">
                                                                            <button class="btn btn-default" type="button">Go!</button>
                                                                        </span>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </div>

                        
                        
                        
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Documentos Emitidos<small></small></h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <div class="form-group">
                                            <label class="control-label col-md- col-sm-1 col-xs-12">RESUMEN:
                                            </label>
                                            <div class="col-md-4 col-sm-4 col-xs-12">
                                            </div>
                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                <SELECT class="form-control" required="required" id="frmClienteTipDoc" name="frmClienteTipDoc">
                                                    <OPTION> Enero </OPTION>
                                                    <OPTION> Febrero </OPTION>
                                                    <OPTION> Marzo </OPTION>
                                                    <OPTION> Abril </OPTION>
                                                    <OPTION> Mayo </OPTION>
                                                    <OPTION> Junio </OPTION>
                                                    <OPTION> Julio </OPTION>
                                                    <OPTION> Agosto </OPTION>
                                                    <OPTION> Setiembre </OPTION>
                                                    <OPTION> Octubre </OPTION>
                                                    <OPTION> Noviembre </OPTION>
                                                    <OPTION> Diciembre </OPTION>
                                                </SELECT>
                                            </div>
                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                <SELECT class="form-control" required="required" id="frmClienteTipDoc" name="frmClienteTipDoc">
                                                    <OPTION> 2015 </OPTION>
                                                    <OPTION> 2016 </OPTION>
                                                    <OPTION> 2017 </OPTION>
                                                    <OPTION> 2018 </OPTION>
                                                    <OPTION> 2019 </OPTION>
                                                    <OPTION> 2020 </OPTION>
                                                    <OPTION> 2021 </OPTION>
                                                    <OPTION> 2022 </OPTION>
                                                    <OPTION> 2023 </OPTION>
                                                    <OPTION> 2024 </OPTION>
                                                    <OPTION> 2025 </OPTION>
                                                    <OPTION> 2026 </OPTION>
                                                    <OPTION> 2027 </OPTION>
                                                    <OPTION> 2028 </OPTION>
                                                    <OPTION> 2029 </OPTION>
                                                    <OPTION> 2030 </OPTION>
                                                </SELECT>
                                            </div>
                                            <div class="col-md-1 col-sm-1 col-xs-12">
                                            </div>
                                            <button type="button" class="btn btn-round btn-danger" id="frmClienteGrabar"><i class="fa fa-search"></i> Buscar</button>

                                        </div>


                                        <!--                                        <p class="text-muted font-13 m-b-30">
                                                                                    DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>
                                                                                </p>-->
                                        <!-- Button trigger modal -->
                                        <!--                                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modalEmpresa" id="agregar">
                                                                                    Crear Empresa
                                                                                </button>-->
                                        <table id="lstFactElect" name="lstFactElect" class="table table-striped table-bordered bulk_action">
                                            <thead>
                                                <tr>
                                                    <th><input type="checkbox" id="check-all" class="flat"></th>
                                                    <th>Tipo CPE</th>
                                                    <th>Codigo CPE</th>
                                                    <th>Aceptados</th>
                                                    <th>Rechazados</th>
                                                    <th>Observados</th>
                                                    <th>Baja</th>
                                                    <th>Pendiente</th>
                                                    <th>Excepcion</th>
                                                    <th>Error</th>
                                                    <th>Emitidos</th>
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
                </div>
                <!-- /page content -->
                <!-- footer content -->
                <footer>
                    <div class="pull-right">
                        Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>
        <%@include file="../Global/footer.jsp" %>
<!--        <script src="<c:url value='../resources/v1/EmpresaController.js'/>" type="text/javascript"></script>-->
<!--        <script src="<c:url value='../resources/v1/FacturacionElectronicaController.js'/>" type="text/javascript"></script>-->
        <%@include file="../Global/modalSunat.jsp" %>
        <%@include file="../Global/ubigeo.jsp" %>



    </body>
</html>