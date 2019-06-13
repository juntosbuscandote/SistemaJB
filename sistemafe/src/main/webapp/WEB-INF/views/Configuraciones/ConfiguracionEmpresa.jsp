<%-- 
    Document   : ConfiguracionEmpresa
    Created on : 21-sep-2017, 18:20:15
    Author     : Usuario
--%>

<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--    <title>Gentelella Alela! | </title>-->
        <title> JB </title>
        <!-- Bootstrap -->
        <link href="../resources/vendors/sweetalert/sweet-alert.css">
        <link rel="stylesheet" href="../resources/vendors/dist/ladda-themeless.min.css" />
        <link href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
        <link href="../resources/vendors/animate.css/animate.min.css" rel="stylesheet">
		<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Custom Theme Style -->
        <link href="../resources/build/css/custom.min.css" rel="stylesheet">
        <!-- validator -->
<!--         <link href="../resources/dist/css/cmxform.css" rel="stylesheet"> -->
<!-- 	    <link href="../resources/dist/css/cmxformTemplate.css" rel="stylesheet"> -->
<!-- 	    <link href="../resources/dist/css/core.css" rel="stylesheet"> -->
<!-- 	    <link href="../resources/dist/css/reset.css" rel="stylesheet"> -->
	    <link href="../resources/dist/css/screen.css" rel="stylesheet">
        
    <body class="login">

        <div class="login_wrapper">
            <div>
                <section class="login_content" >
                <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Empresa<small></small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                        <div >
                            <br/>
                            <div id="busiEmpresa" > 
                            	<form id="frmbussines" name="frmbussines">
	                                <input style="display: none" type="hidden"  id="busi_bcod" name="busi_bcod" placeholder="Codigo Empresa" required="" />
	                                <input type="text" class="form-control" id="busi_vbusiname" name="busi_vbusiname" placeholder="Razón Social" required="" value="${oDtoEmpresa.busiVbusiname}" />
	                                <input type="text" class="form-control" id="busi_vruc" name="busi_vruc" placeholder="Ruc" required="" value="${oDtoEmpresa.busiVruc}"  />
	                                <input type="text" class="form-control" id="busi_vaddress" name="busi_vaddress" placeholder="Dirección" required="" value="${oDtoEmpresa.busiVaddress}"/>
	                                <input type="email"class="form-control" id="busi_vemail" name="busi_vemail" placeholder="Correo Electronico" required="" value="${oDtoEmpresa.busiVemail}" />
	                                <input type="text" class="form-control" id="busi_vphone" name="busi_vphone" placeholder="Telefono / Celular" required="" value="${oDtoEmpresa.busiVphone}					" />
	                                <br/>
                                </form>
                           
                            </div>
                            
                            <div align="center">
                                <button class="btn btn-primary btnconf ladda-button"  type="button" id="btnconfiguracion" data-style="expand-right"  >Guardar</button>
                            </div>

                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                    
                </section>
            </div>  </div>  

        <script src="../resources/js/bootbox.min.js"></script>
        <script src="../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="../resources/vendors/dist/spin.min.js"></script>
		<script src="../resources/vendors/dist/ladda.min.js"></script>
		<script src="../resources/vendors/global.js"></script>
	    <script src="../resources/js/jquery.validate.js"></script>
		<script type="text/javascript" src="../resources/v1/EmpresaController.js"></script>
		<script  type="text/javascript">
            $(document).ready(function () {
                $("#Homeini").click(function (e) {
                    location.href = "../#signin/";
                });
            });
        </script>
       
       
      	
        
        	<script type="text/javascript">
			$(document).on('ready',function() {
				var	empresainsert = new EmpresaInsert();
				empresainsert.init();
			});
		</script>
                <script type="text/javascript">
                    $(document).ready(function () {
        
                        $("#check1").click(function () {
                            if ($(this).is(':checked')) {
                                document.getElementById("busiPNatural").style.display = "none";
                                document.getElementById("busiEmpresa").style.display = "block";
                            } else {
                                document.getElementById("busiEmpresa").style.display = "none";
                                document.getElementById("busiPNatural").style.display = "block";
                            }
                        });
                        $("#check2").click(function () {
                            if ($(this).is(':checked')) {
                                document.getElementById("busiPNatural").style.display = "block";
                                document.getElementById("busiEmpresa").style.display = "none";
                            } else {
                                document.getElementById("busiEmpresa").style.display = "none";
                                document.getElementById("busiPNatural").style.display = "block";
                            }
                        });
                    });
        
                </script>





    </body>

</html>
