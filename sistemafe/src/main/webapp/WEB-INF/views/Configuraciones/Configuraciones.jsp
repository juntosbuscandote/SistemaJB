<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> <!-- language="java"--> --%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="../build/css/custom.css" rel="stylesheet">
        <link href="../build/css/custom.css" rel="stylesheet" type="text/css"/>
    
        <!--    <title>Gentelella Alela! | </title>-->
        <title> JB </title>

        <!-- Bootstrap -->
        <link href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
        <link href="../resources/vendors/animate.css/animate.min.css" rel="stylesheet">
		<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>

        <!-- Custom Theme Style -->
        <link href="../resources/build/css/custom.min.css" rel="stylesheet">
<!--         <script type="text/javascript"> -->
<!--  			$(document).on('ready',function() { -->
<!-- 			var	confEmpresa = new Empresa(); -->
<!-- 			confEmpresa.carg(); -->
<!--  			}); -->
<!-- 		</script> -->

    </head>
    <!-- Crear Funciones para mostrar -->



    <body class="login">

        <div class="login_wrapper">


            <div >
                <section  class="login_content">
                <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Configuracion<small></small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                    <form>
<!--                         <h1>Configuración</h1> -->
                        <%-- creamos los radio button--%>
                            <h4>Usuario - Contraseña (CLAVE SOL)</h4>
                            <div id="algo">
                                <br>
                                <input type="text" class="form-control" id="clie_vusersol" placeholder="Usuario" required="" />
                                <input type="password" class="form-control" id="clie_vkeysol" placeholder="Contraseña" required="" />

                            </div>
                            <h4>Ingrese su Certificado</h4>
                            <div class="buscarcertificado">
                                <form method="post" action="" enctype="multipart/form-data" >

                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                    <input class="btn btn-default " type="file" name="archivo" /><br/>
                                    </div>
                                    <input class="btn btn-primary" type="button" value="Ingresar Certificado" name="boton" /><br/>
                                    <%-- <button class="btn btn-default submit" type="button" id="btn_ingresarconfiguracion">Buscar Certificado</button>--%>
									

                            </div>
                            <div id="algo">
                                <br>
                                <input type="text" class="form-control" id="cert_vnamefile" placeholder="Archivo" required="" />
                                <input type="text" class="form-control" id="cert_filepfx" placeholder="Archivo.pfx" required="" />
                                

                            </div>

                            <h4>Servidor Envio Sunat</h4>
                            <div align="left">
                                <input type="radio" name="EnvioSunat" value="Prueba" id="prueEnvioSunat"  checked/>Prueba<br>
                                <input type="radio" name="EnvioSunat" value="Homologacion" id="homoEnvioSunat"  />Homologacion<br>
                                <input type="radio" name="EnvioSunat" value="Produccion"  id="prodEnvioSunat" />Produccion

                            </div>  <br>
                            <div>
                                <button class="btn btn-primary" type="button" id="confEmpresa">Atras</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary" type="submit" id="ConfEnvio">Siguiente</button>


                            </div><br>
                            <p  class="change_link">¿Desea Registrar Correo?<br>

                                <a class="to_register" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modalProducto"> Ingresar </a>
                            </p>
                    </form>
                    
                    </div>
                    </div>
                    </div>
                    </div>
                </section>
            </div>
        </div>


        <!--                                        <input name="checkbox" id="checkbox" type="checkbox" value="1" />  
                                                <input name="checkbox_comprobar" id="checkbox_comprobar" type="button" value="Comprobar" />  
                                                <input name="checkbox_activar" id="checkbox_activar" type="button" value="Activar" />  
                                                <input name="checkbox_desactivar" id="checkbox_desactivar" type="button" value="Desactivar" />-->

        <!-- Modal -->
        <!--cambiar el modal segun la pantalla de la aplicacion anteior-->
        <div class="modal fade" id="modalProducto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Nuevo Correo <small>Correo</small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                               
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
                            <form class="form-horizontal form-label-left input_mask" id="frmProducto" name="frmProducto">
<!--                                <div class="" role="tabpanel" data-example-id="togglable-tabs">

                                    <div id="myTabContent" class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">-->
                                            <div class="col-md-12 col-xs-12">
                                                <div class="x_panel">
                                                    <div class="x_title">
                                                        <h4> Información de Correo </h4>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                    <div class="x_content">

                                                        <div class="form-group">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12 text-danger" >Ruc (Empresa):<span class="required"></span>
                                                            </label>
                                                            <div class="col-md-8 col-sm-8 col-xs-12">
                                                                <input class="form-control" required="required" id="busi_vruc" name="busi_vruc">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12 text-danger">Usuario :
                                                            </label>
                                                            <div class="col-md-8 col-sm-8 col-xs-12">
                                                                <input class="form-control" id="clie_vuser" name="clie_vuser">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12 text-danger">Contraseña :
                                                            </label>
                                                            <div class="col-md-8 col-sm-8 col-xs-12">
                                                                <input type="password" class="form-control" id="clie_vpass" name="clie_vpass">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-4 col-sm-4 col-xs-12 text-danger">Correo Electronico :<span class="required"></span>
                                                            </label>
                                                            <div class="col-md-8 col-sm-8 col-xs-12">
                                                                <input class="form-control" required="required" id="clie_vemail" name="clie_vemail" name="Correo">
                                                            </div>
                                                        </div>


                                                    </div>
                                                </div>
                                        <div class="x_panel">
                                        <div class="x_title">
                                            <h4> Historial de correos: </h4>
                                            <div class="clearfix"></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12 col-xs-12">
<!--                                                <div class="x_panel">
                                                    <div class="x_content">-->
                                                        <table id="lstHistPrecio" class="table table-striped table-bordered bulk_action">
                                                            <thead>
                                                                <tr>
                                                                    
                                                                    <th>Ruc</th>
                                                                    <th>Usuario</th>
                                                                    <th>Contraseña</th>
                                                                    <th>Correo Electronico</th>
                                                                    <th>Opciones</th>

                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                                <tr>

                                                                    <td>20550629357</td>
                                                                    <td>ADMIN</td>
                                                                    <td>********</td>
                                                                    <td>ADMIN@HOTMAIL.COM</td>
                                                                     <td>
                                                                      <input type="button" onclick="Ruc" value="Editar"> 
                                                                      <form action="Proceso1"><input type="hidden" name="borramano" ><input type="submit" value="borrar" name="borrar"> </form>
                                                                     </td>
                                                                </tr>
                                                               
                                                            </tbody>
                                                        </table>
<!--                                                    </div>
                                                </div>-->
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </form>
                            <div class="ln_solid"></div>

                            <!--BOTONES -->
                            <div class="form-group">
                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-4">
                                    <button type="button" class="btn btn-primary">Guardar</button>
                                    <button type="submit" class="btn btn-success" data-dismiss="modal">Cancelar</button>
                                </div>
                            </div> 
                            <!--BOTONES -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Modal -->
        </div>





<!--         <script src="../resources/vendors/jquery/dist/jquery.min.js"></script> -->
<!--         <script src="../resources/js/bootbox.min.js"></script> -->
<!--         <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>    -->
		<script src="../resources/js/bootbox.min.js"></script>
        <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css" />
		<script src="../resources/vendors/dist/spin.min.js"></script>
		<script src="../resources/vendors/dist/ladda.min.js"></script>
		<script src="../resources/vendors/global.js"></script>
	    <script src="../resources/js/jquery.validate.js"></script>
		<script type="text/javascript" src="../resources/v1/EmpresaController.js"></script>
        <script  type="text/javascript">
            $(document).ready(function () {
            $("#ConfEnvio").click(function (e) {
            location.href = "../empresa/configuracionesenvio";
            }); });</script>
            <script type="text/javascript">
            $(document).ready(function(){
                $("#confEmpresa").click(function(e){
                    location.href = "../empresa/configuracion"
                })
            })
        </script>             
        <script type="text/javascript">
            $formatos = array('.jpg', '.png', '.doc', '.CER');
            if (isset($_POST['boton'])){
            //Nombre del archivo
            $nombreArchivo = $_FILES['archivo']['name']
                    $nombreTmpArchivo = $_FILES['archivo']['name']
            } //Extension del archivo
            $exten = substr($nombreArchivo, strrpos($nombreArchivo, '.'))

                    //Verificar si la extension esta en mis formatos validos
                    if (in_array($exten, $formatos)){
            if (move_uploaded_file($nombreTmpArchivo, "archivos/$nombreArchivo")){

            } else{

            }
            } else{

            }
        </script>
        
        <script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
    </body>
</html>


