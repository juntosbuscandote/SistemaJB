
<style type="text/css">
body {
	background: url("../resources/img/plataforma.jpeg");
}
</style>
<script>
	var menuC = JSON.parse($('#menu').val());
	var tm = menuC.modulos.length;
	console.log('ver: ' + menuC);
</script>
<body class="hold-transition skin-blue layout-top-nav">
	<div class="wrapper">

		<header class="main_container">
			<!--       <nav class="navbar navbar-static-top"> -->
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="../dashboard/" class="site_title"> <span></span> <img
							src="../resources/img/logoIconJB.jpg"></a>
					</div>

					<div class="clearfix">
						<div class="profile-clearfix">
							<div class="pull-left image">
								<div class="pull-left info"></div>
							</div>
							<!--              </div> -->
							<br> <br> <br> <br> <abbr></abbr>
							<div class="profile clearfix">
								<div class="profile_pic">
									<img src="../resources/img/perfilJB.png" alt="..."
										class="img-circle profile_img">
								</div>
								<div class="profile_info">
									<span>Bienvenido</span>
									<h2>${usuarioFilter.nombres}</h2>
									<a href="#"><i class="fa fa-circle text-success"></i>
										Online</a>
								</div>
							</div>
						</div>
					</div>
					<!-- menu profile quick info -->

					<br />
					<script>
					var usuario = '<%= session.getAttribute("usuario") %>';
					
					console.log("ver: "+ usuario);
	
				</script>

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						
						<c:forEach items="${menu}" var="modulo">
							<div class="menu_section" >
								<!-- <h3>${modulo.getLabel()}</h3>  -->
								<h3>JUNTOS BUSCANDOTE</h3>
								<ul class="nav side-menu">
									<c:forEach items="${modulo.getCabMenu()}" var="menus">
										<li class="" ><a><i class="${menus.getIcono()}"></i>${menus.getEtiqueta()}<span
												class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">

												<c:forEach items="${menus.getDetalleMenu()}" var="smenus">
													<li><a href="${smenus.getUrlMenu()}">${smenus.getEtiqueta()}</a></li>
												</c:forEach>

											</ul></li>
									</c:forEach>
								</ul>
								
								
							</div>
						</c:forEach>
					</div>
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
							<br>
						<!-- 	<li><font size=4 color=white>${NombreVentana}</font></li> -->
						</ul>
					</div>
					<ul class="nav navbar-nav navbar-right">


						<!--                 <li class=""> -->

						<!-- 														</li> -->
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="../resources/img/perfilJB.png"
								alt=""><b>${usuario.userVuser}</b> <span
								class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<!-- menu profile quick info -->


								<div class="profile clearfix">
									<div class="profile_pic">
										<img src="../resources/img/perfilJB.png" alt="..."
											class="img-circle profile_img">
									</div>
									<div class="u-text">
										<br>
										<h4>${usuarioFilter.profVdescription}</h4>
										<p class="text-muted">${usuarioFilter.nombres}</p>
										<%-- 			            <span class="label label-success label-rounded">${usuarioFilter.legaBusiname}</span> --%>
									</div>
								</div>
								<li role="separator" class="divider" class="responsive"></li>
								<li>&nbsp; &nbsp; &nbsp; &nbsp;<i class="fa fa-building"></i>
									${usuarioFilter.legaBusiname}
								</li>
								<li role="separator" class="divider"></li>
								<li><a target="_blank"
									href="/SistemaFE/resources/1.manual%20de%20acceso[640]/manual%20de%20usuario_userFinal.pdf"><i
										class="fa fa-book"></i> Ayuda</a></li>
								<li role="separator" class="divider"></li>
								<li><a class="active"> <i class="fa fa-cog fa-spin"></i>
										Configuración de la cuenta
								</a></li>
								<li role="separator" class="divider"></li>
								<li><a
									href="/SistemaFE/logout"
									class="active" ><i class="fa fa-power-off"></i> Cerrar
										sesión</a></li>
							</ul></li>
						<br>
						<li><font size=4 color=white>${usuarioFilter.legaBusiname}</font></li>
					</ul>
				</div>
				<!-- /menu profile quick info -->

			</div>
		</header>
	</div>
</body>


