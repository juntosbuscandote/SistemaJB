<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<script src="../resources/vendors/jquery/dist/jquery.min.js"></script>
<link href="../resources/build/css/custom.min.css" rel="stylesheet">
<link href="../resources/dist/css/screen.css" rel="stylesheet">
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
                                <h3>Usuarios </h3>
                            </div>
                            <div class="title_right">
<!--                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Ingresar ... ">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button">Buscar!</button>
                                        </span>
                                    </div>
                                </div>-->
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title" > <!--style="display: none"--> 
                                        <h2>NO TIENE PERMISO DEBIDO A SU PERFIL</h2>

                                        <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                    
		                   
                </div>
                <!-- /page content -->
 
              </div>
        	   </div>
            </div>
           </div>
          </div>
         </div>
        </div>

        <%@include file="../Global/footer.jsp" %>


        <script>

        </script>
        <!-- /Datatables -->
        <script>

        </script>

        <script src="<c:url value='../resources/v1/UsuarioController.js'/>" type="text/javascript"></script>
        <script type="text/javascript">
			$(document).on('ready', function() {
				var usuario = new Usuario();
				usuario.init();
			});
		</script>	
			<script type="text/javascript">
// 			$(document).on('ready', function() {
// 				var usuarioss = new UsuarioProccess();
// 				usuarioss.init();
// 			});
		</script>	
    </body>
</html>
