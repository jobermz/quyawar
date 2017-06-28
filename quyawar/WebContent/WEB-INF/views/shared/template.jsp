<%@page import="pe.gob.sernanp.ves.constantes.TipoMiembroConstante"%>
<%@page import="pe.gob.sernanp.ves.constantes.TipoSolicitanteConstante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${titulo} - Ventanilla Electrónica de Servicios del SERNANP</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.6 -->
	
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<!-- Theme style -->
	
	<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
		  page. However, you can choose any other skin. Make sure you
		  apply the skin class to the body tag so the changes take effect.
	-->
	

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<link href="${webappRoot}/ves_extranet/resources/plugins/iCheck/square/green.css" rel="stylesheet" />
	<link href="${webappRoot}/ves_extranet/resources/plugins/select2/select2.min.css" rel="stylesheet" />
	<link href="${webappRoot}/ves_extranet/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/dist/css/AdminLTE.min.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/dist/css/ves.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet"/>

	<link href="${webappRoot}/ves_extranet/resources/plugins/datepicker/datepicker3.css" rel="stylesheet"/>

	<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery-1.10.2.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/Scripts/ves.js" charset="UTF-8"></script>

	<script src="${webappRoot}/ves_extranet/resources/plugins/iCheck/icheck.min.js" ></script>
	<script src="${webappRoot}/ves_extranet/resources/plugins/select2/select2.min.js" ></script>
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS		 | skin-blue							   |
|			   | skin-black							  |
|			   | skin-purple							 |
|			   | skin-yellow							 |
|			   | skin-red								|
|			   | skin-green							  |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed								   |
|			   | layout-boxed							|
|			   | layout-top-nav						  |
|			   | sidebar-collapse						|
|			   | sidebar-mini							|
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="/Home/Index" class="logo" style="padding-left: 0px">
				<!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">
					<img src="${webappRoot}/ves_extranet/resources/dist/img/logo_sernanp_b.png" alt="Logo" />
				</span>
				<!-- logo for regular state and mobile devices -->
				<span class="logo-lg">
					<img src="${webappRoot}/ves_extranet/resources/dist/img/logo_sernanp_a.png" alt ="Logo" />
				</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
					<span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Notifications Menu -->
						<li class="dropdown notifications-menu hidden">
							<!-- Menu toggle button -->
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-bell-o"></i>
								<span class="label label-danger">2</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">Usted tiene 2 notificaciones nuevas</li>
								<li>
									<!-- Inner Menu: contains the notifications -->
									<ul class="menu">
										<li>
											<!-- start notification -->
											<a href="#">
												<i class="fa fa-times-circle text-danger"></i> Plazo Vencido (Exp-123-2016)
											</a>
										</li>
										<li>
											<!-- start notification -->
											<a href="#">
												<i class="fa fa-gears text-success"></i> Observaciones (Exp-123-2016)
											</a>
										</li>
										<!-- end notification -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul>
						</li>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button -->
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<!-- The user image in the navbar-->
<%--								 <img src="${webappRoot}/ves_extranet/resources/dist/img/perfil.png" class="user-image" alt="User Image" /> --%>
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${solicitante.getStrCorreo()}</span>
								
							</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
<!--								 <li class="user-header"> -->
<%--									 <img src="${webappRoot}/ves_extranet/resources/dist/img/perfil.png" class="img-circle" alt="User Image" /> --%>
<!--									 <p> -->
<%--										 ${solicitante.getStrCorreo()} --%>
<!--										 <small></small> -->
<!--									 </p> -->
<!--								 </li> -->
								<!-- Menu Body -->
<!--								 <li class="user-body"> -->
									<!--<div class="row">
									  <div class="col-xs-4 text-center">
										<a href="#">Followers</a>
									  </div>
									  <div class="col-xs-4 text-center">
										<a href="#">Sales</a>
									  </div>
									  <div class="col-xs-4 text-center">
										<a href="#">Friends</a>
									  </div>
									</div>-->
									<!-- /.row -->
<!--								 </li> -->
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<!--<a href="#" class="btn btn-default btn-flat">Profile</a>-->
									</div>
									<div class="pull-right">
										<a href="/ves_extranet/" class="btn btn-default btn-flat">Salir</a>
									</div>
								</li>
							</ul>
						</li>
						<!-- Control Sidebar Toggle Button -->
						
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel (optional) -->
<!--				 <div class="user-panel"> -->
<!--					 <div class="pull-left image"> -->
<%--						 <img src="${webappRoot}/ves_extranet/resources/dist/img/perfil.png" class="img-circle" alt="User Image" /> --%>
<!--					 </div> -->
<!--					 <div class="pull-left info"> -->
<%--						 <p>${solicitante.getStrCorreo()}</p> --%>
						<!-- Status -->
<!--						 <a href="#"><i class="fa fa-circle text-success"></i> En línea</a> -->
<!--					 </div> -->
<!--				 </div> -->
				<!-- search form (Optional) -->
				
				<!-- /.search form -->
				<!-- Sidebar Menu -->
				<ul class="sidebar-menu menu-lateral">
					
					<li class="header">MI CUENTA</li>
					<!-- Optionally, you can add icons to the links -->
					<%--
					<li>
						<a href="/ves_extranet/cuenta/notificacion/index" data-title="Notificaciones">
							<i class="fa fa-envelope"></i> <span>Notificaciones</span>
						</a>
					</li>
					--%>
					<li>
						<a href="/ves_extranet/principal">
							<i class="fa fa-user"></i> <span>Gestionar Cuenta</span>
						</a>
					</li>
					
					<li class="header">MIS TRÁMITES</li>
					<li class="treeview">
						<a href="#">
							<i class="fa fa-inbox"></i> <span>Bandeja de Trámites</span>
							<span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
						<ul class="treeview-menu">
							<li><a href="/ves_extranet/bandeja_tramites/borradores">Borradores</a></li>
							<li><a href="/ves_extranet/bandeja_tramites/enviados">Enviados</a></li>
							<li><a href="/ves_extranet/bandeja_tramites/cerrados">Cerrados</a></li>
						</ul>
					</li>
					<%-- --%>
					<li>
<!--					 	<a href="/ves_extranet/solicitud_tupa01/nuevo"> -->
						<a href="/ves_extranet/procedimiento/nuevo">
							<i class="fa fa-pencil-square-o"></i> <span>Solicitar Trámite</span>
						</a>
					</li>
					<%--
					<li>
						<a href="/ves_extranet/ampliacion/nuevo">
							<i class="fa fa-calendar-plus-o"></i> <span>Solicitar Ampliación</span>
						</a>
					</li>
					--%>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>
		
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					${titulo}
					<small>${titulo_descripcion}</small>
				</h1>
				
			</section>

			<!-- Main content -->
			<section class="content">
				<input type="hidden" name="sessionIdTipoSolicitante" value="${solicitante.getIdTipoSolicitante().getSrlIdTabla()}" />
				
				<input type="hidden" name="<%=TipoSolicitanteConstante.COMUNIDAD.toString()%>" value="<%=TipoSolicitanteConstante.COMUNIDAD.getId()%>"/>
				<input type="hidden" name="<%=TipoSolicitanteConstante.CONSORCIO.toString()%>" value="<%=TipoSolicitanteConstante.CONSORCIO.getId()%>"/>
				<input type="hidden" name="<%=TipoSolicitanteConstante.PERSONA_JURIDICA.toString()%>" value="<%=TipoSolicitanteConstante.PERSONA_JURIDICA.getId()%>"/>
				<input type="hidden" name="<%=TipoSolicitanteConstante.PERSONA_NATURAL.toString()%>" value="<%=TipoSolicitanteConstante.PERSONA_NATURAL.getId()%>"/>
				
				<input type="hidden" name="TIPOMIEMBRO_<%=TipoMiembroConstante.PERSONA_NATURAL.toString()%>" value="<%=TipoMiembroConstante.PERSONA_NATURAL.getId()%>"/>
				<input type="hidden" name="TIPOMIEMBRO_<%=TipoMiembroConstante.PERSONA_JURIDICA.toString()%>" value="<%=TipoMiembroConstante.PERSONA_JURIDICA.getId()%>"/>

				<jsp:include page="${partial}"></jsp:include>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="pull-right hidden-xs">
				Versión 1.0.0
			</div>
			<!-- Default to the left -->
			Servicio Nacional de Áreas Naturales Protegidas por el Estado.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane active" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript::;">
								<i class="menu-icon fa fa-birthday-cake bg-red"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
							</a>
						</li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript:;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design
									<span class="label label-danger pull-right">70%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger" style="width: 70%"></div>
								</div>
							</a>
						</li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading">
								Report panel usage
								<input type="checkbox" class="pull-right" checked>
							</label>

							<p>
								Some information about this general settings option
							</p>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
			 immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	<!-- REQUIRED JS SCRIPTS -->
	<!-- jQuery 2.2.0 -->
	
	<!-- Bootstrap 3.3.6 -->
	
	<!-- AdminLTE App -->
<script src="${webappRoot}/ves_extranet/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/dist/js/app.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/Scripts/bootbox.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/fastclick/fastclick.js"></script>

<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery.validate.js"></script>
<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery-validate.bootstrap-tooltip.js"></script>

<script src="${webappRoot}/ves_extranet/resources/plugins/datepicker/bootstrap-datepicker.js"></script>



<script type="text/javascript">
	$.ajaxSetup({
		cache: false
	});
</script>

</body>
</html>






































