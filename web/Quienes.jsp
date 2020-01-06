<%@page import="modelo.Sexo"%>
<%@page import="modelo.Prevision"%>
<%@page import="modelo.Sexo"%>
<%@page import="mantenedor.ManUsuario"%>
<%@page import="modelo.Comuna"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManComuna"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>¿Quiénes Somos?</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Infirmary Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet" href="css/swipebox.css">
<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<!-- //js -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>

	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
	<!-- start-smoth-scrolling -->

	<!-- swipe box js -->
	<script src="js/jquery.swipebox.min.js"></script> 
	    <script type="text/javascript">
			jQuery(function($) {
				$(".swipebox").swipebox();
			});
	</script>
<!-- //swipe box js -->
<!--start-date-piker-->
	<script src="js/jquery-ui.js"></script>
		<script>
			$(function() {
				$( "#datepicker,#datepicker1" ).datepicker();
			});
		</script>
<!--/End-date-piker-->
	<script src="js/responsiveslides.min.js"></script>
			<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->

</head>
<body>
     <%
         /*Mantenedor Comuna que llama para listar sus datos*/
        ManComuna comm = new ManComuna();
        ArrayList<Comuna> lComm = comm.ListComuna();
        /*Mantenedor Usuario que llama para listar el tipo de sexo que tiene*/
        ManUsuario list = new ManUsuario();
        ArrayList<Sexo> Lsex = list.ListSexo();
        /*Mantenedor Usuario que llama para listar las provisiones que existen en la BD*/
        ManUsuario listp = new ManUsuario();
        ArrayList<Prevision> Lpre = listp.ListPrevision();
        
    %>
<!-- header -->
<div class="header wow zoomIn">
	<div class="container">
		<div class="header_left" data-wow-duration="2s" data-wow-delay="0.5s">
			<ul>
				<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+569 95786552</li>
				<li><a href="Telefono.jsp"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>informacion@centrogalenos.com</a></li>
			</ul>
		</div>
		<div class="header_right">
			<div class="login">
				<ul>
					<li><a href="#" data-toggle="modal" data-target="#myModal4"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Login</a></li>
					<li><a href="Registrar.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Registrar</a></li>
					
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //header -->
<div class="header-bottom ">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
					<div class="logo grid">
						<div class="grid__item color-3">
							<h1><a class="link link--nukun" href="index.html"><i></i>CENTRO<span>MÉDICO</span>GALENOS</a></h1>
						</div>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					<nav class="menu menu--horatio">
						<ul class="nav navbar-nav menu__list">
							<li class="menu__item"><a href="index.jsp" class="menu__link">Inicio</a></li>
							<li class="menu__item"><a href="Especialista.jsp" class="menu__link">Especialistas</a></li> 
							<li class="menu__item"><a href="Telefono.jsp" class="menu__link">Telefonos y horarios</a></li> 
							<li class="menu__item menu__item--current"><a href="Quienes.jsp" class="menu__link">¿Quiénes Somos?</a></li> 
							<li class="menu__item"><a href="Ayuda.jsp" class="menu__link">Ayuda en Linea</a></li>
						</ul>
					</nav>
				</div>
			</nav>
		</div>
	</div>
<!-- banner -->
<div class="banner">

				<script>
						// You can also use "$(window).load(function() {"
						$(function () {
						 // Slideshow 4
						$("#slider3").responsiveSlides({
							auto: true,
							pager: true,
							nav: false,
							speed: 500,
							namespace: "callbacks",
							before: function () {
						$('.events').append("<li>before event fired.</li>");
						},
						after: function () {
							$('.events').append("<li>after event fired.</li>");
							}
							});
						});
				</script>
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider3">
				<li>
					<div class="banner1">
						<div class="container">
							<div class="banner-info">
								
							</div>
						</div>
					</div>
				</li> 
				<li>
					<div class="banner2">
						<div class="container">
							<div class="banner-info2 text-center">
								
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="banner1">
						<div class="container">
							<div class="banner-info">
								
							</div>
						</div>
					</div>
				</li> 
				<li>
					<div class="banner2">
						<div class="container">
							<div class="banner-info2 text-center">
								
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
</div>
<!-- //banner -->
<!-- gallery -->
<div class="map_contact">
	<div class="container">
		
		<h3 class="tittle">¿Quiénes Somos?</h3>
		<div class="contact-grids">
			<div class="col-md-6 contact-left-map ">
				<p>"Lorem Ipsum"is the common name dummy text often used in the design, printing, and type setting industriescommon name dummy text often used in the design, printing, and type setting industries Lorem Ipsum"is the common name dummy text often used in the design, printing, and type setting industries "</p>
				<ul class="contact-list">
					<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>756 global Place, New York.</li>
					<li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="mailto:example@mail.com">mail@example.com</a></li>
					<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+123 2222 222</li>
				</ul>
			</div>						
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //gallery -->
<!-- contact -->
<div class="contact">
	<div class="container">
		
		<div class="col-md-6 contact-right wow fadeIn animated animated" data-wow-delay="0.1s" data-wow-duration="2s">
			<h3>Teléfonos y Horarios</h3>
			<div class="strip"></div>
			<ul class="con-icons">
				<li><span class="glyphicon glyphicon-phone" aria-hidden="true"></span>+569 95786552</li>
				<li><a href="Telefono.jsp"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>informacion@centrogalenos.com</a></li>
			</ul>
			<ul class="fb_icons">
				<li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
			</ul>
		</div>
		<div class="col-md-6 contact-left wow fadeIn animated animated" data-wow-delay="0.1s" data-wow-duration="2s">
			<h2>Information</h2>
			<div class="strip"></div>
			<p class="para">At vero eos et accusamus et iusto odio dignissimos
			ducimus qui blanditiis praesentium voluptatum deleniti at
			que corrupti quos dolores et quas molestias excepturi sint
			occaecati cupiditate non provident, similique sunt.</p>
			<p class="copy-right">© 2016 Infirmary. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //contact -->
<!-- login -->
			<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" >
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
									
									<div class="login-right">
										<h3>Iniciar Sesion</h3>
										<form action="Login" method="post">
											<div class="sign-in">
												<h4>Rut :</h4>
												<input type="text" name="txtRut" maxlength="8" style="WIDTH: 100px; " value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Rut';}" required="">
                                                                                                <input type="text" name="txtDig" maxlength="1" value="" style="WIDTH: 50px; " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'DV';}" required="">
											</div>	
											<div class="sign-in">
												<h4>Contraseña :</h4>
												<input type="password" name="txtPass" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Contrasena';}" required="">
												<a href="#">Contraseña Perdida?</a>
											</div>
											<div class="sign-in">
                                                                                            <input type="submit" value="Entrar" name="btnLogear" >
											</div>
										</form>
									</div>
									
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- //login -->
 <!-- login -->
			<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" >
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
									<div class="login-bottom" >
										<h3>Registrar Usuario</h3>
										<form action="Registrar" method="post">
											<div class="sign-up">
												<h4>Rut :</h4>
                                                                                               <input type="text" name="txtRut" maxlength="8" style="WIDTH: 100px; " value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
                                                                                                <input type="text" name="txtVeri" maxlength="1" value="" style="WIDTH: 50px; " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
												
											</div>
											<div class="sign-up">
												<h4>Nombres  :</h4>
                                                                                                <input type="text" name="txtNombres" value=""  required="">
												
											</div>
                                                                                        <div class="sign-up">
												<h4>Apellido Paterno :</h4>
                                                                                                <input type="text" name="txtApePa" value=""  required="">
												
											</div>
                                                                                        <div class="sign-up">
												<h4>Apellido Materno :</h4>
                                                                                                <input type="text" name="txtApeMa" value=""  required="">
												
											</div>
                                                                                        <div class="sign-up">
                                                                                             <h4>Fecha de Nacimiento :</h4>
												<input type="date" name="txtFech">
											</div>
                                                                                        <div class="sign-up">
                                                                                            <h4>Mail :</h4>
                                                                                                <input type="text" name="txtMail" value="" required="">
                                                                                        </div>
                                                                                    
                                                                                    <div class="sign-up">
                                                                                            <h4>Dirección :</h4>
                                                                                                <input type="text" name="txtDire" value=""  required="">
											</div>
                                                                                    <div class="sign-up">
                                                                                            <h4>Celular:</h4>
                                                                                                <input type="text" name="txtCel" value=""  required="">
											</div>
                                                                                    <div class="sign-up">
                                                                                            <h4>Telefono Casa:</h4>
                                                                                                <input type="text" name="txtCas" value=""  required="">
											</div>
                                                                                    <div class="sign-up">
                                                                                            <h4>Contraseña:</h4>
                                                                                            <input type="password" name="txtCont" value=""  required="">
											</div>
                                                                                         <div class="sign-up">
                                                                                            <div class="content">
                                                                                                <div class="container">
                                                                                                        <div id="book" class="col-md-4 content_middle wow flipInY" data-wow-duration="1.0s" data-wow-delay="0.3s">
                                                                                                                        <h4>Sexo :</h4>
                                                                                                                     
                                                                                                                        <select id="country"  name="cbxSex" class="frm-field required sect">
                                                                                                                    <option value="#">Seleccione su opcion</option>
                                                                                                                         <%
                                                                                                                          for(Sexo tmep:Lsex)
                                                                                                                          {

                                                                                                                        %>
                                                                                                                        <option value="<%=tmep.getId_Sexo()%>"><%=tmep.getNombre()%></option>
                                                                                                                        <%

                                                                                                                         }
                                                                                                                        %>                                                                                                     
                                                                                                           </select>
                                                                                                                        <h4>Comuna :</h4>
                                                                                                            <select id="country"  name="cbxCom" class="frm-field required sect">
                                                                                                                        <option value="#">Seleccione su opcion</option>
                                                                                                                        <%
                                                                                                                          for(Comuna tmp:lComm)
                                                                                                                          {

                                                                                                                        %>
                                                                                                                        <option  value="<%=tmp.getId_Comu()%>"><%=tmp.getNombre()%></option>
                                                                                                                        <%

                                                                                                                         }
                                                                                                                        %>  									
                                                                                                            </select>
                                                                                                                                    <h4>Prevision :</h4>
                                                                                                            <select id="country"  name="cbxPre" class="frm-field required sect">
                                                                                                                    <option value="#">Seleccione su Prevision</option>
                                                                                                                        <%
                                                                                                                          for(Prevision tmap:Lpre)
                                                                                                                          {

                                                                                                                        %>
                                                                                                                        <option  value="<%=tmap.getId_Prevision()%>"><%=tmap.getNombre()%></option>
                                                                                                                        <%

                                                                                                                         }
                                                                                                                        %> 
                                                                                                            </select>
                                                                                                                        
                                                                                                                        
												
                                                                                                        </div>
                                                                                                        <div class="clearfix"></div>
                                                                                                </div>
                                                                                            </div> 
												
												
											
											</div>
                                                                                        
                                                                                        
                                                                                    
                                                                                    
											<div class="sign-up">
                                                                                            <input type="submit" name="btnCrear" value="REGISTRAR" >
											</div>	
                                                                                </form>
			</div>
                                                                                                                             
											
										
                                                                       
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- //login -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>
