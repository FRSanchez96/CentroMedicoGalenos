<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Telefono Centro Medico Galenos</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Infirmary Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="../css/jquery-ui.css" />
<link rel="stylesheet" href="../css/swipebox.css">
<link href="../css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/numscroller-1.0.js"></script>
<!-- //js -->
<script type="text/javascript" src="../js/bootstrap-3.1.1.min.js"></script>
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>

	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="../js/move-top.js"></script>
		<script type="text/javascript" src="../js/easing.js"></script>
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
	<script src="../js/jquery.swipebox.min.js"></script> 
	    <script type="text/javascript">
			jQuery(function($) {
				$(".swipebox").swipebox();
			});
	</script>
<!-- //swipe box js -->
<!--start-date-piker-->
	<script src="../js/jquery-ui.js"></script>
		<script>
			$(function() {
				$( "#datepicker,#datepicker1" ).datepicker();
			});
		</script>
<!--/End-date-piker-->
	<script src="../js/responsiveslides.min.js"></script>
			<!--animate-->
<link href="../css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="../js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->

</head>
<body>
      <%
             String usu= (String)session.getAttribute("usu");
            try
            {
           // usu =;
            if(usu.equals(""))
            {
                response.sendRedirect("../index.jsp");
            }
            }
            catch(Exception ex)
            {
                 response.sendRedirect("index.jsp");
            }
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
					<li><a  data-toggle="modal" ><span class="glyphicon glyphicon-user" aria-hidden="true"></span>� Bienvenid@ Paciente !</a></li>
					<li><a href="#" data-toggle="modal" onclick="location='.../Login?btnLogear=cerrar'"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Cerrar Sesion</a></li>
					
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
							<h1><a class="link link--nukun" href="index.html"><i></i>CENTRO<span>M�DICO</span>GALENOS</a></h1>
						</div>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					<nav class="menu menu--horatio">
						<ul class="nav navbar-nav menu__list">
							<li class="menu__item"><a href="index.jsp" class="menu__link">Inicio</a></li>
							<li class="menu__item"><a href="Especialista.jsp" class="menu__link">Especialistas</a></li> 
							<li class="menu__item menu__item--current"><a href="Telefono.jsp" class="menu__link">Telefonos y horarios</a></li> 
							<li class="menu__item"><a href="Quienes.jsp" class="menu__link">�Qui�nes Somos?</a></li> 
							<li class="menu__item"><a href="Ayuda.jsp" class="menu__link">Ayuda en Linea</a></li>
                                                        <li class="menu__item"><a href="Registro.jsp" class="menu__link">Registro de Hora</a></li>
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
		
		<h3 class="tittle">Tel�fonos y Horarios</h3>
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
		<h3 class="tittle">Ver Sucursal Central en el Mapa</h3>
		<div class="map">
			<iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d2482.432383990807!2d0.028213999961443994!3d51.52362882484525!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1423469959819" style="border:0"></iframe>
		</div>
	</div>
</div>
<!-- //gallery -->
<!-- contact -->
<div class="contact">
	<div class="container">
		
		<div class="col-md-6 contact-right wow fadeIn animated animated" data-wow-delay="0.1s" data-wow-duration="2s">
			<h3>Tel�fonos y Horarios</h3>
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
			<p class="copy-right">� 2016 Infirmary. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //contact -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>
