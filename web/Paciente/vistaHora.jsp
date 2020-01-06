<%@page import="modelo.DetalleDoctorSucu"%>
<%@page import="modelo.DetalleEspecialidad"%>
<%@page import="modelo.Horas"%>
<%@page import="mantenedor.ManHora"%>
<%@page import="modelo.Especialidad"%>
<%@page import="modelo.Doctor"%>
<%@page import="modelo.Sucursal"%>
<%@page import="mantenedor.ManDoctor"%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.Prevision"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManUsuario"%>
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
            
            int rutPx = Integer.valueOf(usu);
            
            /*Datos Tomados de IngresarHora*/
            String centroMedico = request.getParameter("centro");
            String rutDoctor = request.getParameter("rutDoc");
            String espeMedico = request.getParameter("especialida");
            String horaMedica = request.getParameter("hora");
            /**/
            int rutDoctor2 = Integer.valueOf(rutDoctor);
            int centroMedico2 = Integer.valueOf(centroMedico);
            int espeMedico2 = Integer.valueOf(espeMedico);
            /**/
             /*Mantenedor Prevision que llama para listar sus datos*/
        ManUsuario listp = new ManUsuario();
        ArrayList<Prevision> Lpre = listp.ListPrevision();
         ArrayList<Persona> Lpers = listp.ListPersona();
        //Mantenedor Doctor que llama para listar sus datos*/
        ManDoctor listd = new ManDoctor();
        ArrayList<Sucursal> Lsu = listd.ListSucursal();
        ArrayList<Doctor> Ldo = listd.ListDoctor();
        ArrayList<Especialidad> Les = listd.LisEsp();
        /**/
        ManHora listH = new ManHora();
        ArrayList<Horas> Lh = listH.ListHoras();
        ArrayList<DetalleEspecialidad> Ldd = listH.ListDetEsp();
        ArrayList<DetalleDoctorSucu> Ldt = listH.ListDetDoctSuc();
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
					<li><a  data-toggle="modal" ><span class="glyphicon glyphicon-user" aria-hidden="true"></span>¡ Bienvenid@ Paciente !</a></li>
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
							<li class="menu__item menu__item--current"><a href="Telefono.jsp" class="menu__link">Telefonos y horarios</a></li> 
							<li class="menu__item"><a href="Quienes.jsp" class="menu__link">¿Quiénes Somos?</a></li> 
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
            
            <h1>Vista General de su Hora</h1>
		<div class="bs-docs-example">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th> </th>
                          <th>Rut Doctor</th>
                          <th>Nombre Doctor</th>
                          <th>Especialidad</th>
                          <th>Sucursal </th>
                        </tr>
                      </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <%
                                 for(Persona tmpe:Lpers)
                                    {
                                       for(Especialidad tma:Les) 
                                       {
                                        for(Sucursal tmep:Lsu)
                                            {
                                                if(rutDoctor2==tmpe.getRut())
                                                  {
                                                    if(tmep.getId_Sucursal()==centroMedico2)
                                                        {
                                                            if(tma.getId_Espe()==espeMedico2)
                                                            {
                                                                   
                             %>
                                 <td><%=tmpe.getRut()%> - <%=tmpe.getVerificador()%></td>
                                 <td><%=tmpe.getNombres()%> <%=tmpe.getApellidoPaterno()%> <%=tmpe.getApellidoMaterno()%></td>
                                 <td><%=tma.getNombre_Esp()%></td>
                                 <td><%=tmep.getNom_Sucursal()%></td>
                             <%
                                                            }        
                                                        }
                                                  }

                                            }
                                       }
                                    }

                             %>
                          </tr>
                          <tr>
                            <th> </th>
                            <th>Rut Paciente</th>
                            <th>Nombre Paciente</th>
                            <th>Prevision</th>
                            <th>Correo Electronico</th>
                          </tr>
                          <tr>
                              <td>2</td>
                              <%
                                 for(Persona tmpx:Lpers)
                                 {
                                     for(Prevision tmk:Lpre)
                                     {
                                        if(tmpx.getRut()==rutPx)
                                        {
                                           if(tmk.getId_Prevision()==tmpx.getPrevision_Id())
                                           {
                              %>
                            <td><%=tmpx.getRut()%> - <%=tmpx.getVerificador()%></td>
                            <td><%=tmpx.getNombres()%> <%=tmpx.getApellidoPaterno()%> <%=tmpx.getApellidoMaterno()%></td>
                            <td><%=tmk.getNombre()%></td>
                            <td><%=tmpx.getMail()%></td>
                            <%          
                                           }
                                        }
                                     }
                                  }
                            
                            %>
                          </tr>
                          <tr>
                            <th> </th>
                            <th>Hora</th>
                            <th>Costo Final</th>
                            <th></th>
                            <th></th>
                          </tr>
                          <tr>
                              <td>3</td>
                              <td><%=horaMedica%></td>
                              <%
                                 for(Sucursal tml:Lsu)
                                 {
                                     for(Especialidad tmq:Les)
                                     {
                                         for(DetalleEspecialidad tme:Ldd)
                                         {
                                             for(DetalleDoctorSucu tmw:Ldt)
                                             {
                                                      //DetalleDoctorSuc                //DetalleEspecialidad
                                                 if(tmw.getDoctor_Rut()==rutDoctor2 && tme.getDoctorRut()==rutDoctor2)
                                                 {          //Sucursal                              //Especialidad
                                                     if(tml.getId_Sucursal()==centroMedico2 && tmq.getId_Espe()==espeMedico2)
                                                     {                                              //Sucursal           //Especialidad
                                                         /*int precioBase = 15000;
                                                         int comisiones = ((tml.getCoste_Comicion()+tmq.getCoste_Comision())/100);
                                                         int PrecioFinal = (precioBase + (precioBase * comisiones ));*/
                                                         
                                                         double PrecioFinal = 15000 + (double)(15000 * (double)(((double)tml.getCoste_Comicion()+(double)tmq.getCoste_Comision())/100));
                              %>
                                        <td>$ <%=(int)PrecioFinal%></td>
                              <%
                                                     }
                                                 }
                                             }
                                         }
                                     }
                                 }
                              %>
                              <td></td>
                              <td></td>
                          </tr>
                        </tbody>
                   </table>
          </div>
         <div class="sign-up">
            <div class="content">
                <div class="container">
                    <div id="book" class="col-md-4 content_middle wow flipInY" data-wow-duration="1.0s" data-wow-delay="0.3s">                   
                        <div class="sign-up">
                            <input type="submit" name="btnLogear" value="CONFIRMAR HORA" >
                        </div>
                    </div>
                </div>
            </div>
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
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>