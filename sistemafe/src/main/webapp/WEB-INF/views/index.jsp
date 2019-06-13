<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="Global/header.jsp" %>
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
       <%@include file="Global/nav.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Form advanced</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>
            <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Plus Table Design</small></h2>
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
                    <p class="text-muted font-13 m-b-30">
                      DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>
                    </p>
                         <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="agregar">
                      Crear Empresa
                    </button>
                    <table id="lstEmpresa" name="lstEmpresa" class="table table-striped table-bordered bulk_action">
                      <thead>
                        <tr>
                          <th><input type="checkbox" id="check-all" class="flat"></th>
                          <th>RUC</th>
                          <th>Razón Social</th>
                          <th>Dirección</th>
                          <th>Teléfono</th>
                          <th>Controles</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${DtoEmpresa}" var="oDtoEmpresa">
                        <tr>
                          <td><input type="checkbox" class="flat" name="table_records"></td>
                          <td>${oDtoEmpresa.ruc}</td>
                          <td>${oDtoEmpresa.rsocial}</td>
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
               
                    
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="x_panel">
                                <div class="x_title">
                                  <h2>Form Design <small>different form elements</small></h2>
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
                                     <li><a id="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                  </ul>
                                  <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                  <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                    <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                      <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Home</a>
                                      </li>
                                      <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Profile</a>
                                      </li>
                                      <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Profile</a>
                                      </li>
                                    </ul>
                                    <div id="myTabContent" class="tab-content">
                                      <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                                         <br />
                                            <form class="form-horizontal form-label-left input_mask">
                                              <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input type="text" class="form-control has-feedback-left" id="inputSuccess2" placeholder="RUC">
                                                <span class="fa fa-asterisk form-control-feedback left" aria-hidden="true"></span>
                                              </div>

                                              <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input type="text" class="date-picker form-control" id="inputSuccess3" placeholder="Fecha Inicio">
                                                <span class="fa fa-calendar form-control-feedback right" aria-hidden="true"></span>
                                              </div>

                                              <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input type="text" class="form-control has-feedback-left" id="inputSuccess4" placeholder="Email">
                                                <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                              </div>

                                              <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input type="text" class="form-control" id="inputSuccess5" placeholder="Phone">
                                                <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                              </div>
                                               
                                               <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                                                <input type="text" class="form-control has-feedback-left" id="inputSuccess6" placeholder="Phone">
                                                <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>  
                                              </div>
                                                
                                              <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Default Input</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                  <input type="text" class="form-control" placeholder="Default Input">
                                                </div>
                                              </div>
                                              <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Disabled Input </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                  <input type="text" class="form-control" disabled="disabled" placeholder="Disabled Input">
                                                </div>
                                              </div>
                                              <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Read-Only Input</label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                  <input type="text" class="form-control" readonly="readonly" placeholder="Read-Only Input">
                                                </div>
                                              </div>
                                              <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                                                </label>
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                  <input class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                                </div>
                                              </div>
                                              <div class="ln_solid"></div>
                                              <div class="form-group">
                                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                  <button type="submit" class="btn btn-primary">Cancel</button>
                                                  <button type="submit" class="btn btn-success">Submit</button>
                                                </div>
                                              </div>
                                            </form>
                                      </div>
                                      <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                                        <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo
                                          booth letterpress, commodo enim craft beer mlkshk aliquip</p>
                                      </div>
                                      <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                                        <p>xxFood truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo
                                          booth letterpress, commodo enim craft beer mlkshk </p>
                                      </div>
                                    </div>
                                  </div>

                                </div>
                            </div>
                            
                            
                            
                          <!--  <div class="x_panel">
                                <div class="x_title">
                                  <h2>Form Design <small>different form elements</small></h2>
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
                                    <li><a id="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                  </ul>
                                  <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                  <br />
                                  <form class="form-horizontal form-label-left input_mask">
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                      <input type="text" class="form-control has-feedback-left" id="inputSuccess2" placeholder="First Name">
                                      <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                      <input type="text" class="form-control" id="inputSuccess3" placeholder="Last Name">
                                      <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                      <input type="text" class="form-control has-feedback-left" id="inputSuccess4" placeholder="Email">
                                      <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                      <input type="text" class="form-control" id="inputSuccess5" placeholder="Phone">
                                      <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="form-group">
                                      <label class="control-label col-md-3 col-sm-3 col-xs-12">Default Input</label>
                                      <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" placeholder="Default Input">
                                      </div>
                                    </div>
                                    <div class="form-group">
                                      <label class="control-label col-md-3 col-sm-3 col-xs-12">Disabled Input </label>
                                      <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" disabled="disabled" placeholder="Disabled Input">
                                      </div>
                                    </div>
                                    <div class="form-group">
                                      <label class="control-label col-md-3 col-sm-3 col-xs-12">Read-Only Input</label>
                                      <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" readonly="readonly" placeholder="Read-Only Input">
                                      </div>
                                    </div>
                                    <div class="form-group">
                                      <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                                      </label>
                                      <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                      </div>
                                    </div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                      <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <button type="submit" class="btn btn-primary">Cancel</button>
                                        <button type="submit" class="btn btn-success">Submit</button>
                                      </div>
                                    </div>
                                  </form>
                                </div>
                            </div>-->
                            
                            
                            
                        </div>
                      </div>
                    </div>
                    <!-- End Modal -->
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
    
         <%@include file="Global/footer.jsp" %>
    
    
     <script>
      $(document).ready(function() {
        var table=$('#lstEmpresa').DataTable();
        $( "#close-link" ).click(function() {
           $('#myModal').modal('toggle');
        });
         $( "#edit" ).click(function() {
           $("#inputSuccess2").val("124521458745");
            alert(table.cell(this).data());
        });
        var handleDataTableButtons = function() {
          if ($("#datatable-buttons").length) {
            $("#datatable-buttons").DataTable({
              dom: "Bfrtip",
              buttons: [
                {
                  extend: "copy",
                  className: "btn-sm"
                },
                {
                  extend: "csv",
                  className: "btn-sm"
                },
                {
                  extend: "excel",
                  className: "btn-sm"
                },
                {
                  extend: "pdfHtml5",
                  className: "btn-sm"
                },
                {
                  extend: "print",
                  className: "btn-sm"
                },
              ],
              responsive: true
            });
          }
        };

        TableManageButtons = function() {
          "use strict";
          return {
            init: function() {
              handleDataTableButtons();
            }
          };
        }();

        $('#datatable').dataTable();

        $('#datatable-keytable').DataTable({
          keys: true
        });

        $('#datatable-responsive').DataTable();

        $('#datatable-scroller').DataTable({
          ajax: "js/datatables/json/scroller-demo.json",
          deferRender: true,
          scrollY: 380,
          scrollCollapse: true,
          scroller: true
        });

        $('#datatable-fixed-header').DataTable({
          fixedHeader: true
        });

        var $datatable = $('#datatable-checkbox');

        $datatable.dataTable({
          'order': [[ 1, 'asc' ]],
          'columnDefs': [
            { orderable: false, targets: [0] }
          ]
        });
        $datatable.on('draw.dt', function() {
          $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green'
          });
        });

        TableManageButtons.init();
      });
    </script>
    <!-- /Datatables -->
  </body>
</html>