<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <script src="${webappRoot}/ves_extranet/resources/Scripts/ves.js"></script>

    <script src="${webappRoot}/ves_extranet/resources/plugins/iCheck/icheck.min.js"></script>
    <script src="${webappRoot}/ves_extranet/resources/plugins/select2/select2.min.js" ></script>
    
    <style type="text/css">
    
	.register-box {
	  width: 760px;
	  margin: 7% auto;
	}
	@media (max-width: 768px) {
	  .register-box {
	    width: 90%;
	    margin-top: 20px;
	  }
	}
    
    </style>
</head>
<body class="hold-transition register-page">






<div class="register-box">
  <div class="login-logo">
    <img src="${webappRoot}/ves_extranet/resources/dist/img/logo_sernanp.png" alt="Logo" />
  </div>
<!-- <form id="frmRegistro" >  -->

<!--   <input type="hidden" name="intTipSolicitante" value="6" /> -->
  <div class="register-box-body">
	
	
	
	
	
	
	<jsp:include page="${partial}"></jsp:include>
<%-- 	<jsp:include page="/ves_extranet/ administrado/solicitud_alta_persona_natural/nuevo"></jsp:include> --%>
	
	
	
    <a href="/ves_extranet/" class="text-center">Ya estoy registrado</a>
    
    
  </div>
<!--   </form> -->
  <!-- /.form-box -->
</div>








<script src="${webappRoot}/ves_extranet/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/dist/js/app.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/Scripts/bootbox.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/fastclick/fastclick.js"></script>
<script src="${webappRoot}/ves_extranet/resources/plugins/jsPDF/jspdf.min.js"></script>

<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery.validate.js"></script>
<script src="${webappRoot}/ves_extranet/resources/Scripts/jquery-validate.bootstrap-tooltip.js"></script>

<script src="${webappRoot}/ves_extranet/resources/plugins/datepicker/bootstrap-datepicker.js"></script>

<script type="text/javascript">
/*
    $.ajaxSetup({
        cache: false
    });
    
    $(document).ready(function () {
        $('.icheckNotElect, .icheckAcepto').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
            increaseArea: '20%'
        });
        $('input[type=password]').keyup(function (e) {
        	validarPassword();
        });
        $('select[name=intTipDocumento]').change(function (e) {
        	$('#divNomCompleto').children('div input[type=text]').val('');
        	$('#divApeNombre').children('div input[type=text]').val('');
        	if ($(this).val() == 2) { //DNI
        		$('#btnObtener').show();
        		$('#divNomCompleto').show();
        		if (!$('#divNomCompleto').children('div input[type=text]').hasClass('disabled'))
        			$('#divNomCompleto').children('div input[type=text]').addClass('disabled').attr('disabled', 'disabled');
        		$('#divApeNombre').hide();
        	} else if ($(this).val() == 3) { //RUC
        		$('#btnObtener').show();
        		$('#divNomCompleto').show();
        		if (!$('#divNomCompleto').children('div input[type=text]').hasClass('disabled'))
        			$('#divNomCompleto').children('div input[type=text]').addClass('disabled').attr('disabled', 'disabled');
        		$('#divApeNombre').hide();
        	} else { //CE
        		$('#btnObtener').hide();
        		$('#divApeNombre').show();
        		$('#divNomCompleto').hide();
        	}
        	verificarNroDocumento();
        });
        
        $('input[name=varUsuario]').keyup(function (e) {
        	validarUsuario();
        });
        
        $('button#btnRegistrar').click(function (e) {
        	registrarSolicitante();
        });
        
        $('#btnVerificar').click(function (e) {
        	verificarCorreo();
        });
        
        $('input[name=varApePaterno], input[name=varApeMaterno], input[name=varNombre]').keyup(function (e) {
        	$('input[name=varNomCompleto]').val(ves.string.format('{0} {1} {2}',
        			$('input[name=varApePaterno]').val(),
        			$('input[name=varApeMaterno]').val(),
        			$('input[name=varNombre]').val()));
        });
        
        $('input[name=varNumDocumento]').keyup(function (e) {
        	verificarNroDocumento();
        });
        
        $('#btnObtener').click(function (e) {
        	bootbox.alert('No se puede obtener los datos desde un origen externo, debe ingresar sus datos manualmente.',
        			function () {
            	$('#divApeNombre').show();
        		$('#divNomCompleto').hide();
        	});
        });
        
        $('#btnDDJJ').click(function (e) {
        	generarDDJJ();
        });
        
    });
    
//     var generarDDJJ = function () {
//     	var d = new Date();
//     	var fecha = ves.string.format('{0}/{1}/{2}', d.getDate(), d.getMonth()+1, d.getFullYear());
    	
// 		var tpl = '<p> </p><p style="font-size:1.2em; font-weight: bold">Declaración Jurada</p>'
// 		+ '<p> </p><p> </p><p style="text-align:justify"> Yo, ' + $('input[name=varNomCompleto]').val() + ' con ' +  $('select[name=intTipDocumento] option:selected').data('nombre')
// 		+ ' N° '+ $('input[name=varNumDocumento]').val() +', domiciliado en '+ $('input[name=varDireccion]').val() +'.</p>'
// 		+ '<p> </p><p> </p><p style="text-align:justify">Solicito la creación de una cuenta en la Ventanilla Electrónica de Servicios del SERNANP, vinculada a la siguiente información.</p>'
// 		+ '<p> </p><p> </p>'
// 		+ ves.string.format('<div><b>Correo Electrónico:</b> {0}</div>', $('input[name=varCorreo]').val())
// 		+ ves.string.format('<p></p><div><b>Usuario:</b> {0}</div>', $('input[name=varUsuario]').val())
// 		+ ves.string.format('<p></p><div><b>Notificación:</b> {0}</div>', ($('input.icheckNotElect:checked').val() == 'true' ? 'Electrónica' : 'Física'))
// 		+ '<p> </p><p> </p><p style="text-align:justify">Me afirmo y me ratifico en los expresado, en señal de lo cual firmo el presente documento en la fecha '+ fecha +' </p>'
// 		+ '<p><i></i> </p><i></i><p> </p><div style="width:100%" >______________________________________'
// 		+ '<br />' + $('input[name=varNomCompleto]').val() + '<br />'+ $('select[name=intTipDocumento] option:selected').html() +' : ' + $('input[name=varNumDocumento]').val() + '</div>';
		
// 		console.log(tpl);
// 		var pdf = new jsPDF('p', 'pt', 'letter')
// 		//, source = $('#reportDDJJ')[0]
// 		, source = tpl
// 		, specialElementHandlers = {
// 		    '#bypassme': function(element, renderer){
// 		        return true
// 		    }
// 		}
		
// 		margins = {
// 		    top: 80,
// 		    bottom: 60,
// 		    left: 40,
// 		    width: 522
// 		  };
// 		pdf.fromHTML(
// 		    source // HTML string or DOM elem ref.
// 		    , margins.left // x coord
// 		    , margins.top // y coord
// 		    , {
// 		        'width': margins.width // max width of content on PDF
// 		        , 'elementHandlers': specialElementHandlers
// 		    },
// 		    function (dispose) {
// 		        pdf.save('DDJJ.pdf');
// 		      },
// 		    margins
// 		  )

//     };
    
    var verificarNroDocumento = function () {
    	var DocRegex = new RegExp("^(?=.*[0-9]).*$", "g");
    	var nro = $('input[name=varNumDocumento]');
  	    var error = $('#list-valid-nrodoc').children('li');
  	    var tipoDoc = $('select[name=intTipDocumento] option:selected').val();
  	    
  	    switch (Number(tipoDoc)) {
		case 2: 
			if (!DocRegex.test(nro.val())) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).hide();
				$(error[1]).hide();
				$(error[2]).show();
				$(error[3]).hide();
			} else if (nro.val().length != 8) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).children('span').html('<i class="fa fa-times-circle-o"></i> El número de documento debe tener 8 dígitos.');
				$(error[0]).show();
				$(error[1]).hide();
				$(error[2]).hide();
				$(error[3]).hide();
			} else {
				$.ajax({
	                url : ves.string.format('/ves_extranet/registrar/validarNroDoc/{0}/{1}', tipoDoc, nro.val()),
	                type : "GET",
	                data : {},
	                dataType: "json",
	                beforeSend : function (data) {
	                    ves.wait.append('mensajes');
	                },
	                complete: function (data) {
	                    ves.wait.remove('mensajes');
	                },
	                success: function (data) {
	                	if (data) {
	                		if (nro.parent('div').hasClass('has-error')) nro.parent('div').removeClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).hide();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	} else {
	                		if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).show();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	}
	                },
	                error: function (data) {
	                    console.log(data);
	                }
	            });
			}
			
			break;
		case 3:
			if (!DocRegex.test(nro.val())) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).hide();
				$(error[1]).hide();
				$(error[2]).show();
				$(error[3]).hide();
			} else if (nro.val().length != 11) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).children('span').html('<i class="fa fa-times-circle-o"></i> El número de documento debe tener 11 dígitos.');
				$(error[0]).show();
				$(error[1]).hide();
				$(error[2]).hide();
				$(error[3]).hide();
			} else if (!validarRUC(nro.val())) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).hide();
				$(error[1]).hide();
				$(error[2]).hide();
				$(error[3]).show();
			} else {
				$.ajax({
	                url : ves.string.format('/ves_extranet/registrar/validarNroDoc/{0}/{1}', tipoDoc, nro.val()),
	                type : "GET",
	                data : {},
	                dataType: "json",
	                beforeSend : function (data) {
	                    ves.wait.append('mensajes');
	                },
	                complete: function (data) {
	                    ves.wait.remove('mensajes');
	                },
	                success: function (data) {
	                	if (data) {
	                		if (nro.parent('div').hasClass('has-error')) nro.parent('div').removeClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).hide();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	} else {
	                		if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).show();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	}
	                },
	                error: function (data) {
	                    console.log(data);
	                }
	            });
			}
			break;
		case 4:
			if (!DocRegex.test(nro.val())) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).hide();
				$(error[1]).hide();
				$(error[2]).show();
				$(error[3]).hide();
			} else if (nro.val().length != 12) {
				if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
				$(error[0]).children('span').html('<i class="fa fa-times-circle-o"></i> El número de documento debe tener 12 dígitos.');
				$(error[0]).show();
				$(error[1]).hide();
				$(error[2]).hide();
				$(error[3]).hide();
			} else {
				$.ajax({
	                url : ves.string.format('/ves_extranet/registrar/validarNroDoc/{0}/{1}', tipoDoc, nro.val()),
	                type : "GET",
	                data : {},
	                dataType: "json",
	                beforeSend : function (data) {
	                    ves.wait.append('mensajes');
	                },
	                complete: function (data) {
	                    ves.wait.remove('mensajes');
	                },
	                success: function (data) {
	                	if (data) {
	                		if (nro.parent('div').hasClass('has-error')) nro.parent('div').removeClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).hide();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	} else {
	                		if (!nro.parent('div').hasClass('has-error')) nro.parent('div').addClass('has-error');
	                		$(error[0]).hide();
	                		$(error[1]).show();
	                		$(error[2]).hide();
	                		$(error[3]).hide();
	                	}
	                },
	                error: function (data) {
	                    console.log(data);
	                }
	            });
			}
			break;
		}
    };
    
    var validarPassword = function () {
    	 var pass = $('input[name=passNuevo]');
    	 var passConfirm = $('input[name=passConfirm]');
   	     var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$", "g");
   	     var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
   	     var enoughRegex = new RegExp("(?=.{6,}).*", "g");
   	     var error = $('#list-valid-pass').children('li');
   	  	 var errorconfirm = $('#list-valid-confirmpass').children('li');
   	     
   	     if (false == enoughRegex.test(pass.val())) {
   	         if (!pass.parent('div').hasClass('has-error')) pass.parent('div').addClass('has-error');
   	         $(error[0]).show();
   	         $(error[1]).show();
   	         $(error[2]).show();
   	         $(error[3]).show();
   	     } else if (strongRegex.test(pass.val())) {
   	    	 if (pass.parent('div').hasClass('has-error')) pass.parent('div').removeClass('has-error');
   	    	 $(error[0]).hide();
   	         $(error[1]).hide();
   	         $(error[2]).hide();
   	         $(error[3]).hide();
   	     } else if (mediumRegex.test(pass.val())) {
   	    	 if (!pass.parent('div').hasClass('has-error')) pass.parent('div').addClass('has-error');
   	    	 $(error[0]).hide();
   	         $(error[1]).show();
   	         $(error[2]).show();
   	         $(error[3]).show();
   	     } else {
   	    	 if (!pass.parent('div').hasClass('has-error')) pass.parent('div').addClass('has-error');
   	    	 $(error[0]).show();
   	         $(error[1]).show();
   	         $(error[2]).show();
   	         $(error[3]).show();
   	     }
   	     
   	     if (pass.val() == passConfirm.val()) {
   	    	if (passConfirm.parent('div').hasClass('has-error')) passConfirm.parent('div').removeClass('has-error');
   	    	 $(errorconfirm[0]).hide();
   	     } else {
   	    	if (!passConfirm.parent('div').hasClass('has-error')) passConfirm.parent('div').addClass('has-error');
   	    	 $(errorconfirm[0]).show();
   	     }
    };
    
    var validarUsuario = function () {
    	var enoughRegex = new RegExp("(?=.{6,}).*", "g");
    	var error = $('#list-valid-user').children('li');
    	var user = $('input[name=varUsuario]');
    	
    	if (false == enoughRegex.test(user.val())) {
    		if (!user.parent('div').hasClass('has-error')) user.parent('div').addClass('has-error');
    		$(error[0]).show();
  	        $(error[1]).hide();
    	} else {
    		$.ajax({
                url : ves.string.format('/ves_extranet/registrar/validar/{0}', user.val()),
                type : "GET",
                data : {},
                dataType: "json",
                beforeSend : function (data) {
                    ves.wait.append('mensajes');
                },
                complete: function (data) {
                    ves.wait.remove('mensajes');
                },
                success: function (data) {
                	if (data) {
                		if (user.parent('div').hasClass('has-error')) user.parent('div').removeClass('has-error');
                		$(error[0]).hide();
              	        $(error[1]).hide();
                	} else {
                		if (!user.parent('div').hasClass('has-error')) user.parent('div').addClass('has-error');
                		$(error[0]).hide();
              	        $(error[1]).show();
                	}
                },
                error: function (data) {
                    console.log(data);
                }
            });
    	}
    };
    
    var verificarCorreo = function () {
    	var correo = $('input[name=varCorreo]').val();
    	if (correo != '' && /^\w+([\.\+\-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(correo)) {
    		$.ajax({
                url : '/ves_extranet/registrar/verificarCorreo/'+ $('input[name=varCorreo]').val(),
                type : "GET",
                data : {},
                dataType: "json",
                beforeSend : function (data) {
                    ves.wait.append('mensajes');
                },
                complete: function (data) {
                    ves.wait.remove('mensajes');
                },
                success: function (data) {
                	if (data.exito) {
                		$('input[name=varCodVerificacion]').val(data.codigo);
                		$('input[name=ingresoCorreo]').val(data.correo);
                	}
                	bootbox.alert('Se le ha enviado un correo con un código de verificación, el cual debe ingresar en el campo correspondiente para considerar su correo como un correo válido. CODIGO = ' + data.codigo);
                },
                error: function (data) {
                    console.log(data);
                }
            });
    	} else {
    		bootbox.alert('Debe ingresar un correo electrónico válido.');
    	}
    };
    
    var validarRUC = function (ruc) {
	    var factores = new String("5432765432");
	    var ultimoIndex = ruc.length - 1;
	    var sumaTotal = 0, residuo = 0;
	    var ultimoDigitoRUC = 0, ultimoDigitoCalc = 0;
	    
	    for(var i=0;i<ultimoIndex;i++) {
	        sumaTotal += (parseInt(ruc.charAt(i)) * parseInt(factores.charAt(i)));
	    }
	    residuo = sumaTotal%11;
	    
	    ultimoDigitoCalc = (residuo == 10) ? 0: ((residuo == 11) ? 1:(11 - residuo)%10);
	    ultimoDigitoRUC = parseInt(ruc.charAt(ultimoIndex));
	    
	    return ultimoDigitoRUC == ultimoDigitoCalc;
    };
    
    var registrarSolicitante = function () {
		
		verificarNroDocumento();
		if($('div.has-error').length > 0) return;
		//validarUsuario();
		if($('div.has-error').length > 0) return;
		validarPassword();
		if($('div.has-error').length > 0) return;
		
		if ($('input[name=fileDDJJ]').val() == '') {
			bootbox.alert('Debe adjuntar su declaración jurada firmada para proceder con su solicitud de registro.');
			return;
		}
		
		if ($('input[name=varDireccion]').val() == '' || $('input[name=varNomCompleto]').val() == '') {
			bootbox.alert('Debe asegurarse de llenar todos los campos obligatorios.');
			return;
		}
		
		if ($('.icheckAcepto').parent('div').attr('aria-checked') != 'true') {
			bootbox.alert('Debe aceptar los Terminos y Condiciones para proceder con su solicitud de registro.');
			return;
		}
		
    	if ($('.icheckAcepto').parent('div').attr('aria-checked') == 'true') {
        	$.ajax({
                url : '/ves_extranet/registrar',
                type : "POST",
                data : $('#frmRegistro').serialize(),
                cache: false,
                beforeSend : function (data) {
                    ves.wait.append('mensajes');
                },
                complete: function (data) {
                    ves.wait.remove('mensajes');
                },
                success: function (data) {
                	window.location = '/ves_extranet/registrar/confirmacion';
                },
                error: function (data) {
                    console.log(data);
                }
            });
    	}
    };
    */
</script>

</body>
</html>
