  <style type="text/css">
body {background:url("../resources/img/plataforma.jpeg");}
</style>  
 
 
 
 <body class="hold-transition skin-blue layout-top-nav">
    <div class="wrapper">
    
      <header class="main_container">
<!--       <nav class="navbar navbar-static-top"> -->
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="../dashboard/" class="site_title"> <span></span>
             <img src="../resources/img/JuntosLogo.jpg" ></a>
            </div>           
            
            <div class="clearfix">
            <div class="profile-clearfix">
             <div class="pull-left image">
<!--              <img src="../resources/img/avatar5.png" alt="..." class="img-circle profile_img">              -->
<!--              <span> Bienvenido </span>   -->
<%--              <h2>${usuario.userVuser}</h2>                                 --%>
               <div class="pull-left info">              
<!--                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>    -->
               </div>
             </div> 
<!--              </div> -->
           <br><br><br><br><abbr></abbr>
			 <div class="profile clearfix">
              <div class="profile_pic">
              <img src="../resources/img/perfilJB.png" alt="..." class="img-circle profile_img">       
              </div>
              <div class="profile_info">
                <span>Bienvenido</span>
                <h2>
                ${usuarioFilter.nombres}</h2>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
              </div>
            </div>
            </div>
             </div>
            <!-- menu profile quick info -->

            <br/>
            
            	<script>
				var usuario = '<%= session.getAttribute("usuario") %>';
				
				console.log("ver: "+ usuario);

				if (${usuario.profBident} == "1"){
					$("#navprof").val("Administrador")
				
				}else if (${usuario.profBident} == "2"){
					$("#navprof").val("Usuario Empresa")
				}else if (${usuario.profBident} == "3"){
					$("#navprof	").val("Usuario Final")
				}
			</script>
			<% String role = ((Long)request.getSession().getAttribute("role")+""); 
					boolean admin=false;
					boolean userSistema=false;
					boolean userFinal=false;
					if(role.equals("3")){
						admin=true;
						userSistema=true;
						userFinal=true;
					}else if(role.equals("1")){
						userSistema=true;
						userFinal=true;
					}else{
						userFinal=true;
					}
				%>

            <!-- sidebar menu -->
           <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Juntos Buscandote</h3>
                <ul class="nav side-menu">
                <% if(userFinal){%>
                <li><a><i class="fa fa-home"></i>Inicio<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../dashboard/">Panel de Control</a></li>
                      
<!--                       <li><a href="../empresa/configuraciongeneral">Configuracion General</a></li>                       -->
<!--                       <li><a href="index2.html">Dashboard2</a></li> -->
<!--                       <li><a href="index3.html">Dashboard3</a></li> -->
                    </ul>
                  </li>
                  <%  } %>
                <% if(admin){ %>
         <!--          <li><a><i class="fa fa-building-o"></i>Empresa<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../empresa/">Empresas</a></li>
<!--                       <li><a href="../empresa/configuraciongeneral">Configuracion General</a></li>                       -->
<!--                       <li><a href="index2.html">Dashboard2</a></li> -->
<!--                       <li><a href="index3.html">Dashboard3</a></li> -->
        <!--              </ul>
                  </li> -->
                  <%
                   } %>
                  <% if(userSistema){ %>
                  <li><a><i class="fa fa-users" aria-hidden="true"></i>Usuario<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../usuario/">Usuarios</a></li>
<!--                       <li><a href="../empresa/configuraciongeneral">Configuracion General</a></li>                       -->
<!--                       <li><a href="index2.html">Dashboard2</a></li> -->
<!--                       <li><a href="index3.html">Dashboard3</a></li> -->
                    </ul>
                  </li>
                  <%  } %>
<!--                   <li><a><i class="fa fa-unlock-alt"></i> Seguridad <span class="fa fa-chevron-down"></span></a> -->
<!--                     <ul class="nav child_menu"> -->
<!--                       <li><a href="form.html">Grupo Acceso</a></li> -->
<!--                       <li><a href="form_advanced.html">Grupo de Perfiles</a></li> -->
<!--                       <li><a href="../usuario/">Usuario</a></li> -->
<!--                       <li><a href="form_wizards.html">Creacion de Areas</a></li> -->
<!--                       <li><a href="form_upload.html">Areas por Usuario</a></li> -->
<!--                     </ul> -->
<!--                   </li> -->
<!--                   <li><a><i class="fa fa-money"></i> Ventas <span class="fa fa-chevron-down"></span></a> -->
<!--                     <ul class="nav child_menu"> -->
<!--                       <li><a href="../movimiento/">Movimientos</a></li> -->
<!-- <!--                      <li><a href="media_gallery.html">Explorador</a></li> -->
<!--                       <li><a href="typography.html">Consultas</a></li>-->
<!--                       <li><a href="../cliente/">Clientes</a></li> -->
<!--                       <li><a href="../vendedor/">Vendedores</a></li> -->
<!--                       <li><a href="../servicio/">Servicios</a></li> -->
<!-- <!--                      <li><a href="invoice.html">Grupo de Servicios</a></li> -->
<!--                       <li><a href="inbox.html">Importacion</a></li>--> 
<!--                       <li><a href="../producto/">Productos</a></li> -->
<!--                       <li><a href="../guiaremision/">Guia Remision</a></li> -->
<!--                       <li><a href="../transportista/">Transportistas</a></li> -->
<!--                       <li><a href="../ordenpedido/">Orden Pedido</a></li> -->
<!--                       <li><a href="../cotizacion/">Cotizacion</a></li> -->
<!--                     </ul> -->
<!--                   </li> -->
					<% if(userFinal){%>
                  <li><a><i class="fa fa-file-zip-o"></i>Comprobante<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="../comprobanteelectronico/">Comprobante Elect.</a></li>
<!--                           <li><a href="../comprobanteelectronico/cpeemitido">CPE's Emitidos</a></li> -->
<!--                           <li><a href="../comprobanteelectronico/cperecibido">CPE's Recibidos</a></li>   -->
<!--                           <li><a href="../empresa/configuraciongeneral">Configuracion General</a></li> -->
<!--                             <li><a href="../empresa/configuracionesenvio">Configuración Envio</a></li> -->
<!--                             <li><a href="../empresa/configuraciones">Configuración Usuario y Correo</a></li>  -->
                      </ul>
                  </li>
                  <% } %>
                  <% if(admin){ %>
	                <li><a><i class="fa fa-cog"></i>Configuracion<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                    <!--  <li><a href="../empresa/configuraciongeneral">Configuracion Empresa</a></li>-->
                      <li><a href="../usuario/administrarusuario">Configuracion Usuario</a></li>
<!--                       <li class="pass" attr="uts"><a href="../usuario/administrarpassword">Cambiar Contraseña </a></li> -->
<!--                       <li><a href="../empresa/configuraciongeneral#tab_content2">Configuracion General</a></li> -->
                    </ul>
                  </li>
                  <% } %>
                  </ul>
              </div>
              <% if(userSistema){%>
              <div class="menu_section">
               <!--  
               <h3>Punto de Venta</h3>
                <ul class="nav side-menu">
               	  <li><a><i class="fa fa-shopping-cart"></i>Compras<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                      <li><a href="../registrocompra/">Registro de Compra</a></li>
                      --> 
                      
<!--                           <li><a href="../producto/compras">Compras</a></li> -->
    <!--                     </ul>
                  </li>
                  
                  <li><a><i class="fa fa-money"></i>Ventas<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                      	  <li><a >Cotización</a></li>
                      	  <li><a >Orden de Pedido</a></li>
                          <li><a href="../registroventa/">Registro de Venta</a></li>
                          <li><a >Guía de Remisión</a></li>
                      </ul>
                  </li>
                  
                    -->
  <!--                <li><a><i class="fa fa-search"></i>Exploradores<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">  
                       --> 
<!--                           <li><a href="../cotizacion/exploradorcotizacion">E. Cotización</a></li> -->
<!--                           <li><a href="">E. Orden de Pedido</a></li> -->
<!-- 						  <li><a href="../registrocompra/exploradorcompra">E. Compras</a></li>
                          <li><a href="../registroventa/exploradorventa">E. Ventas</a></li>
                           -->
<!--                           <li><a href="">E. Guía Remisión</a></li> -->
<!-- 	
						  <li><a href="../movimiento/">Inventario</a></li>  -->
                      </ul>
                  </li>
                  <li><a><i class="fa fa-eye"></i>Vistas<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                      	  <li><a href="../cliente/">Cliente</a></li>
<!-- 						  <li><a href="../vendedor/">Vendedor</a></li>
						  <li><a href="../proveedor/">Proveedor</a></li>
						  
						   -->
<!--                           <li><a href="../sucursal/">Sucursal</a></li> -->

<!-- 
						  <li><a href="../producto/">Producto</a></li>
						  <li><a href="../servicio/">Servicio</a></li>
						  <li><a href="../marca/">Marca</a></li>
						  <li><a href="../tipocambio/">Tipo de Cambio</a></li>
                      </ul>
                  </li>
                  
                   -->
                  <li><a><i class="fa fa-cog"></i>Configuración<span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                      	  <li><a href="../cliente/crearcliente">Crear Persona</a></li>
                      	  
                      	
 <!--  						  <li><a href="../vendedor/crearvendedor">Crear Vendedor</a></li>   -->
		 <!--  				  <li><a href="../proveedor/crearproveedor">Crear Proveedor</a></li>  -->
<!--                           <li><a href="../sucursal/crearsucursal">Crear Sucursal</a></li> -->
<!--						  <li><a href="../producto/crearproducto">Crear Producto</a></li>  -->
<!--						  <li><a href="../servicio/crearservicio">Crear Servicio</a></li>  -->
<!--						  <li><a href="../marca/crearmarca">Crear Marca</a></li>    -->
<!-- 						  <li><a href="../tipocambio/creartipocambio">Crear Tipo de Cambio</a></li> -->
                      </ul>
                  </li>
<!--                <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="chartjs.html">Chart JS</a></li>
                      <li><a href="chartjs2.html">Chart JS2</a></li>
                      <li><a href="morisjs.html">Moris JS</a></li>
                      <li><a href="echarts.html">ECharts</a></li>
                      <li><a href="other_charts.html">Other Charts</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                      <li><a href="fixed_footer.html">Fixed Footer</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>Live On</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="e_commerce.html">E-commerce</a></li>
                      <li><a href="projects.html">Projects</a></li>
                      <li><a href="project_detail.html">Project Detail</a></li>
                      <li><a href="contacts.html">Contacts</a></li>
                      <li><a href="profile.html">Profile</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="page_403.html">403 Error</a></li>
                      <li><a href="page_404.html">404 Error</a></li>
                      <li><a href="page_500.html">500 Error</a></li>
                      <li><a href="plain_page.html">Plain Page</a></li>
                      <li><a href="login.html">Login Page</a></li>
                      <li><a href="pricing_tables.html">Pricing Tables</a></li>
                    </ul>
                  </li>-->
<!--                  <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="#level1_1">Level One</a>
                        <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                            </li>
                            <li><a href="#level2_1">Level Two</a>
                            </li>
                            <li><a href="#level2_2">Level Two</a>
                            </li>
                          </ul>
                        </li>
                        <li><a href="#level1_2">Level One</a>
                        </li>
                    </ul>
                  </li>                  
-->                  
<!-- 					<li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li> -->
                </ul>
              </div>
              <% } %>

            </div>       
            <!-- /sidebar menu -->

<!--             /menu footer buttons -->
<!--             <div class="sidebar-footer hidden-small"> -->
<!--               <a data-toggle="tooltip" data-placement="top" title="Settings"> -->
<!--                 <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> -->
<!--               </a> -->
<!--               <a data-toggle="tooltip" data-placement="top" title="FullScreen"> -->
<!--                 <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span> -->
<!--               </a> -->
<!--               <a data-toggle="tooltip" data-placement="top" title="Lock"> -->
<!--                 <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span> -->
<!--               </a> -->
<!--               <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html"> -->
<!--                 <span class="glyphicon glyphicon-off" aria-hidden="true"></span> -->
<!--               </a> -->
<!--             </div> -->
<!--             /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div> 
              <div class="center">
              <ul class="nav navbar-nav"> 
             <br><li><font size=4  color=white>${NombreVentana}</font></li>
              </ul>
               </div> 
              <ul class="nav navbar-nav navbar-right">
              
              
<!--                 <li class=""> -->

<!-- 														</li> -->
				  <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="../resources/img/perfil.png" alt=""><b>${usuario.userVuser}</b>
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                                     <!-- menu profile quick info -->
                                     
                                 
			            <div class="profile clearfix">
			              <div class="profile_pic">
			                <img src="../resources/img/perfil.png" alt="..." class="img-circle profile_img">
			              </div>
			              <div class="u-text"> 
			              <br>
			              <h4>${usuarioFilter.profVdescription}</h4>
			              <p class="text-muted">${usuarioFilter.nombres}</p>
<%-- 			            <span class="label label-success label-rounded">${usuarioFilter.legaBusiname}</span> --%>
			              </div>
			            </div>
                            <li role="separator" class="divider" class="responsive"></li>                 
						   <li>&nbsp; &nbsp; &nbsp; &nbsp;<i class="fa fa-building"></i> ${usuarioFilter.legaBusiname}</li>					
                            <li role="separator" class="divider"></li>
                            <li><a target="_blank" href="/SistemaFE/resources/1.manual%20de%20acceso[640]/manual%20de%20usuario_userFinal.pdf"><i class="fa fa-book"></i> Ayuda</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href= "/SistemaFE/usuario/EditarUsuario?nrodoc=${usuario.persBident}" class="active">
                            <i class="fa fa-cog fa-spin"></i> Configuración de la cuenta</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/SistemaFE/<%= session.getAttribute("empresa") %>" class="active"><i class="fa fa-power-off"></i> Cerrar sesión</a></li>
			           </ul>
			           </li>
			           <br><li><font size=4  color=white>${usuarioFilter.legaBusiname}</font></li>
			           </ul>
			            </div>
                         <!-- /menu profile quick info -->                   

          </div>
      </header>
    </div>
</body>


        