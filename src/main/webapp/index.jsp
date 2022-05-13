<%-- 
    Document   : index
    Created on : 3/05/2022, 03:27:55 PM
    Author     : santi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/estilos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <title>CITAFAST</title>
    </head>
    <body>

       <!--Encabezado-->
      
      <div id="cabecera">
        
       <ul class="nav justify-content-end"> 
        <li class="nav-item">
          <a id="letrasc" class="nav-link active" aria-current="page" href="Vistas/registro.jsp">Iniciar sesión</a>
        </li>
        <li class="nav-item">
          <a id="letrasc" class="nav-link active" aria-current="page" href="Vistas/registro.jsp">Registrarse</a>
        </li>
        
      </ul>
    </div>

    <!--Barra de busqueda-->
    <div id="containerBusqueda">

    <nav class="navbar navbar-expand-lg navbar-light ">
      <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <div class="container-fluid">
                <a  id="letrasnav" class="navbar-brand" href="#">
                  <img src="https://raw.githubusercontent.com/CharsMA/Marketplace-SCANG/main/Sin%20t%C3%ADtulo-4.png" alt="" width="50" height="50" class="">
                  CITAFAST
                </a>
              </div>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="#" id="letrasnav">Home </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" id="letrasnav" >Sobre Nosotros</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="" id="letrasnav" >Contactanos</a>
            </li>
            
          </ul>
          <a class="btn btn-primary" href="Vistas/solCita.jsp" role="button">Pide tu cita aqui</a>
          
        </div>
      </div>
    </nav>

  </div>
<br>
        <!--Contenido de Pagina-->
        
        <div class="container">

          <!--Categorias-->
         
            
            <!--Carrusel-->
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                  <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                  <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                  <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                  <div class="carousel-item active" data-bs-interval="50">
                    <img src="https://lobbyfix.com/wp-content/uploads/2020/12/businessman-planning-events-deadlines-agenda_74855-6274.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img src="" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5></h5>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img src="https://www.appointlet.com/wp-content/uploads/2021/05/img_60a2556338077.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>

              <br><br>
              <!--Tarjetas -->
              <div class="card-group">
                <div class="card border-light mb-3">
                  <img class="card-img-top" id="timage2" src="https://www.webconsultas.com/sites/default/files/styles/wc_adaptive_image__medium/public/media/2020/06/05/adulto_con_telefono.jpg" alt="Card image cap">
                  <div class="card-body text-primary ">
                    <h5 class="card-title">Facil de Usar</h5>
                    <p class="card-text">Cita fast cuenta con un diseño agradable para la vista donde permite ver todo lo que ofrece con solo 1 click </p>
                   
                  </div>
                </div>
                <div class="card border-light mb-3">
                  <img class="card-img-top" id="timage" src="https://us.123rf.com/450wm/deagreez/deagreez1903/deagreez190300779/119387794-primer-plano-retrato-de-pelo-gris-%C3%A9l-su-abuelo-bebida-caliente-mano-brazo-d%C3%ADgale-a-los-ni%C3%B1os-estado-.jpg?ver=6" alt="Card image cap">
                  <div class="card-body text-primary ">
                    <h5 class="card-title">Rapido</h5>
                    <p class="card-text">Solicita tu cita a la velocidad de la luz a solo un par de clicks</p>
                    
                  </div>
                </div>
                <div class="card border-light mb-3">
                  <img class="card-img-top" id="timage" src="https://www.rockandpop.com.ar/wp-content/uploads/sites/6/2021/12/4MD6XY3VBFH2XF2FDDOH6ODOVA.jpg" alt="Card image cap">
                  <div class="card-body text-primary ">
                    <h5 class="card-title">Seguro</h5>
                    <p class="card-text">No hace falta salir de casa para agendar una cita, hazlo desde la comodidad de tu casa.</p>
                    
                  </div>
                </div>
              </div>
              <!-- Sobre Nosotros-->
              <br><br>
              
              <div class="card text-white bg-primary mb-3">
                <div class="card-body "">
                  <h5 class="card-title-bold">Sobre Nosotros</h5>
                  <p class="card-text">Citafast está enfocada en el manejo fácil y rapido de las citas médicas de los pacientes por medio de una pagina web y nuestro objetivo es facilitar y agilizar   el proceso por el cual una cita médica es asignada utilizando un diseño fácil y amigable a la vista del cliente además de simplificar todo el proceso por el que debe pasar una persona al momento de registrarse para obtener su cita médica.</p>
                  
                </div>
                <img class="card-img-bottom" src="https://hospitaldeolhos.net/wp-content/uploads/2018/06/historia-hospital-dos-olhos.jpg" alt="Card image cap">
              </div>
             

              
              
                


                <br><br>
          <br><br>
         <!-- Footer -->
<footer class="page-footer font-small blue pt-4" id="footer" >

  <!-- Footer Links -->
  <div class="container-fluid text-center text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-6 mt-md-0 mt-3">

        <!-- Content -->
        <h5 id="letraslogo" class="text-uppercase">CONTACTANOS</h5>
        <p id="letraslogo">Aqui puedes encontrar nuestras diferentes lineas de atencion en las redes sociales. </p>

      </div>
      <!-- Grid column -->

      <hr class="clearfix w-100 d-md-none pb-3">

      <!-- Grid column -->
     
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 id="letraslogo" class="text-uppercase">Links</h5>

        <ul class="list-unstyled">
          <li>
            <a href="#!" id="letraslogo" >Facebook</a>
          </li>
          <li>
            <a href="#!" id="letraslogo">Youtube</a>
          </li>
          <li>
            <a href="#!" id="letraslogo">Instragram</a>
          </li>
        </ul>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

  <!-- Copyright -->
  <div id="letraslogo" class="footer-copyright text-center py-3">© 2022 Copyright:
    <a href="#" class="text-warning"> CITAFAST </a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
        

<br><br>
        

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
    </body>
</html>
