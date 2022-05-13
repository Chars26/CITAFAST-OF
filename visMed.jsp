<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/estilos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <title>Inicio</title>
    </head>
    <body>

       <!--Encabezado-->
      
    <div id="cabecera">
        
       <ul class="nav justify-content-end"> 
        
        <li class="nav-item">
            <a id="letrasc" class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/controlador?accion=logout">Cerrar Sesion</a>
          </li>
        
      </ul>
    </div>

        <div class="container">

            <div class="container rounded bg-white mt-5 mb-5">

                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="data:image/png;base64,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"><span class="font-weight-bold">Medico</span>
        
                    <div class="row mt-2">                                 
                        <div class="col-md-6">
                            <label class="labels">Nombre</label>
                            <input type="text" class="form-control" placeholder="Nombre" disabled="true">
                        </div>                                 
                        <div class="col-md-6">
                            <label class="labels">Correo</label>
                            <input type="text" class="form-control" placeholder="Correo" disabled="true">
                        </div>                             </div>
                                    
                </div>
                
                <c:forEach var="c" items="${citas}">
                <div id="containercar" >
                    <div class="card">
                        <div class="row">
                            <div class="col-md-8 cart">
                                <div class="title">
                                    <div class="row">
                                        <div class="col">
                                            <h4><b>Agenda</b></h4>
                                        </div>
                                        
                                </div>
                                <div class="row border-top border-bottom">
                                    <div class="row main align-items-center">
                                        <div class="col-2"><img class="img-fluid" src="https://i0.wp.com/hipertextual.com/wp-content/uploads/2021/05/GTA-5-1-scaled.jpg?fit=25"></div>
                                        <div class="col">
                                            <div class="row text-muted">CITA</div>
                                            <div class="row text-muted"> Sede: ${c.getSede()}</div>
                                            <div class="row text-muted">Medico: ${c.getMedico().getNombreCompleto()}</div>
                                            <div class="row"> Paciente: ${c.getPaciente().getNombreCompleto()}</div>
                                            
                                        </div>
                                        <div class="col"></div>
                                        <div class="col"><select class="form-select" aria-label="Default select example">
                                            <option selected>Estado de cita</option>
                                            <option value="1">Asistido</option>
                                            <option value="2">En espera</option>
                                            
                                          </select><button class="btn">Aceptar</button>
                                          <button class="btn">Agendar</button></div>
                                    </div>
                                </div>
                               
                               
         
         
            
          
              </div>
                </c:forEach>
                

<br><br>
<div class="container">

    </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
    </body>
</html>
