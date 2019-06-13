<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
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
        <!-- Font Awesome -->
        <link href="../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- Animate.css -->
        <link href="../resources/vendors/animate.css/animate.min.css" rel="stylesheet">
        <link href="../resources/vendors/Timepicker/css/jquery.timepicker.css" rel="stylesheet" type="text/css"/>
        <!-- Custom Theme Style -->
        
        <link href="../resources/build/css/custom.min.css" rel="stylesheet">
    </head>
    <!-- Crear Funciones para mostrar -->



    <body  class="login">
      
            <div class="login_wrapper">


                <div>
                    
                    <section class="login_content">
                    <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Configuracion de Envio<small></small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                        <form>
<!--                             <h1>Configuracion</h1> -->
                            <%-- creamos los radio button--%>
                            <div>
                                <h3>Envio Automatico</h3>
                            <div align="left">
                                
                                 <input type="radio" name="EnvioSunat1" value="cliente" id="Prue" />Enviar comprobante electronico a correo de cliente<br>
                                <input type="radio" name="EnvioSunat1" value="sunat" id="Homo"  />Enviar comprobante electronico a Sunat<br>
                                </div>
<!--                                <h3>Envio Manual</h3>
                                  <div align="left">
                                 <input type="radio" name="EnvioSunat1" value="manual" id="manual" />Enviar comprobante y correo dependiendo del usuario<br>
                                 </div>-->
                                 <h3>Envio Programado</h3>
                                 <div align="left" >
                                     <div class="col-md-4 col-sm-4 col-xs-12">
                                     <input type="checkbox" name="EnvioSunat" value="fac" id="fac1" />Factura
                                     </div>
                                    
                                     <div class="col-md-4 col-sm-4 col-xs-12">
                                     <select name="Dias" >
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                 </select>
                                 </div>
                                      <div class="col-md-4 col-sm-4 col-xs-12 "> 
                                     <input id="Timer2" type="text" class="time ui-timepicker-input" autocomplement="off">
                                     </div> 
                                 </div> 
                                 <div align="left" >
                                 <div class="col-md-4 col-sm-4 col-xs-12">
                                 <input type="checkbox" name="EnvioSunat2" value="bol" id="bol1" />Boleta</div> 
                                  <div class="col-md-4 col-sm-4 col-xs-12">
                                 <select name="Dias" >
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                 </select></div> 
                                 <div class="col-md-4 col-sm-4 col-xs-12 "> 
                                 <input id="Timer3" type="text" class="time ui-timepicker-input" autocomplement="off">
                                 </div>  </div> 
                                  <div align="left" >
                                 <div class="col-md-4 col-sm-4 col-xs-12">
                                   <input type="checkbox" name="EnvioSunat3" value="nc" id="nc1" />N. de Cred.</div>
                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                   <select name="Dias">
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                 </select></div>
                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                        <input id="Timer4" type="text" class="time ui-timepicker-input" autocomplement="off"></div></div>
                                     <div align="left">
                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                    <input type="checkbox" name="EnvioSunat4" value="nd" id="nd1" />N. de Deb.</div>
                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                    <select name="Dias" >
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                    </select></div>
                                      <div class="col-md-4 col-sm-4 col-xs-12">      
                                          <input id="Timer5" type="text" class="time ui-timepicker-input" autocomplement="off">
                                    </div></div>
                                      <div align="left" >
                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                     <input type="checkbox" name="EnvioSunat5" value="ret" id="ret1" />Retencion</div>
                                     <div class="col-md-4 col-sm-4 col-xs-12">
                                     <select name="Dias" >
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                 </select></div>
                                         <div class="col-md-4 col-sm-4 col-xs-12">
                                             <input id="Timer6" type="text" class="time ui-timepicker-input" autocomplement="off"></div></div>
                                     <div align="left" >
                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                     <input type="checkbox" name="EnvioSunat6" value="per" id="per1" />Percepcion</div>
                                     <div class="col-md-4 col-sm-4 col-xs-12">
                                         
                                     <select name="Dias" >
                                     <option>Lunes</option>
                                     <option>Martes</option>
                                     <option>Miercoles</option>
                                     <option>Jueves</option>
                                     <option>Viernes</option>
                                     <option>Sabado</option>
                                     <option>Domingo</option>
                                 </select></div>
                                 <div class="col-md-4 col-sm-4 col-xs-12">
                                 <input id="Timer7" type="text" class="time ui-timepicker-input" autocomplement="off"></div></div>
                                 
                            </div>

                             
                            <br>
                            <div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary" type="button" id="configura" >Atras</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary" type="button" id="facelectronica" >Siguiente</button>
                            </div>
                            
                            <div class="clearfix"></div>

</form>
                        </div>
                        </div>
                        </div>
                        </div>
                    </section>
                            </div>
                </div>



      
                         <%@include file="../Global/footer.jsp" %>   
        <script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
        <script src="../resources/js/bootbox.min.js"></script>
        <script src="../resources/vendors/Timepicker/js/jquery.timepicker.js"></script>
        <script src="../resources/vendors/Timepicker/js/jquery.timepicker.min.js"></script>
        <script src="../resources/vendors/Timepicker/js/bootstrap-datepicker.js"></script>
         <script src="../resources/vendors/Timepicker/js/grunt.js"></script>
        <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
       
             <script  type="text/javascript">
            $(document).ready(function () {
                $("#configura").click(function (e) {
                    location.href="../empresa/configuraciones";
                    
                    });});   </script>
        
         <script  type="text/javascript">
            $(document).ready(function () {
                $("#facelectronica").click(function (e) {
                    location.href="../facturacionelectronica/";
                    
                    });});   </script>
        
         <script type="text/javascript">
                $(function() {
                    $('#Timer2').timepicker();
                });
            </script>

         <script type="text/javascript">
                $(function() {
                    $('#Timer3').timepicker();
                });
            </script>
 <script type="text/javascript">
                $(function() {
                    $('#Timer4').timepicker();
                });
            </script>

         <script type="text/javascript">
                $(function() {
                    $('#Timer5').timepicker();
                });
            </script>

        
         <script type="text/javascript">
                $(function() {
                    $('#Timer6').timepicker();
                });
            </script>

         <script type="text/javascript">
                $(function() {
                    $('#Timer7').timepicker();
                });
            </script>


        
        
        <script type="text/javascript">
            $(document).ready(function () {

                $("#check2").click(function () {
                    if ($(this).is(':checked')) {
                        document.getElementById("algo2").style.display = "block";
                    } else {
                        document.getElementById("algo2").style.display = "none";
                    }
                });
            });
        </script>


        
        <script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
    </body>
</html>


