<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Ventanilla Electrónica de Servicios del SERNANP</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.6 -->
	
	<!-- Font Awesome -->
<!--	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"> -->
	<link rel="stylesheet" href="resources/utiles/font-awesome.min.css">
	
	<!-- Ionicons -->
<!--	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"> -->
	<link rel="stylesheet" href="resources/utiles/ionicons.min.css">
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
	<link href="${webappRoot}/ves_extranet/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/dist/css/AdminLTE.min.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet"/>
	<link href="${webappRoot}/ves_extranet/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet"/>

	<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery-1.10.2.js"></script>

	<script src="${webappRoot}/ves_extranet/resources/plugins/iCheck/icheck.min.js"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			
			<img src="${webappRoot}/ves_extranet/resources/dist/img/logo_sernanp.png" alt="Logo" />
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg"><b>Ventanilla Electrónica de Servicios del SERNANP</b></p>
			
			<div class="alert alert-danger alert-dismissible ${Error == null ? "hidden" : "" }">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
				<h4><i class="icon fa fa-ban"></i> Error!</h4>
				<label>${Error == null ? "" : Error}</label>
			</div>
			
			<form action="login" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="user" class="form-control" placeholder="Usuario">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="pass" class="form-control" placeholder="Contraseña">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button id="btnIngresar" type="submit" class="btn btn-success btn-block btn-flat">Ingresar</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<!-- /.social-auth-links -->

			<a href="/ves_extranet/registrar/recuperar" class="text-center">¿Olvidó su contraseña?</a><br />
			<a href="/ves_extranet/registrar/seleccionar" class="text-center">Registrar como nuevo usuario</a>

		</div>
		<!-- /.login-box-body -->
	</div>
	<script src="${webappRoot}/ves_extranet/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/dist/js/app.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/Scripts/bootbox.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="${webappRoot}/ves_extranet/resources/plugins/fastclick/fastclick.js"></script>

	<script type="text/javascript">
		$.ajaxSetup({
			cache: false
		});
		$(document).ready(function () {
			$('.icheck_tupa').iCheck({
				checkboxClass: 'icheckbox_square-green',
				radioClass: 'iradio_square-green',
				increaseArea: '20%'
			});
			if( ${redirect == null ? "false" : "true"} ) {
				//window.location = '/ves_extranet/cuenta/notificacion/index';
				window.location = '/ves_extranet/principal';
			}
		});
	</script>

</body>
</html>
