<%-- 
    Document   : solCita
    Created on : 3/05/2022, 05:02:46 PM
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Recuerden siempre que se vaya a redireccionar a alguna pagina colocar el ${pageContext.request.contextPath} para
        obtener la ruta relativa y que no vayan a suceder errores-->
        <link rel="stylesheet" href="../estilos/estilos-registro.css ">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <title>Solicitar Cita</title>
    </head>
    <body>
      
        
        <!--Encabezado-->
        <div id="cabecera">
            <ul class="nav justify-content-end"> 
                <li class="nav-item">
                    <a id="letras" class="nav-link active" aria-current="page" href="../index.jsp" method="POST"">
                        
                        Volver a perfil
                    </a>


                </li> 
               
        </div>


        <div class="container">

            <div class="container rounded bg-white mt-5 mb-5">

                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="data:image/png;base64,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"><span class="font-weight-bold">Paciente</span>

                    <div class="row">
                        <div class="col">
                            <div class="d-flex flex-column align-items-center text-center p-2 py-5">

                                <form class="form-horizontal" action="${pageContext.request.contextPath}/controlador" method="POST" enctype="multipart/form-data">
                                    <fieldset>

                                        <!-- Form Name -->
                                        <legend>Solicitud de Cita</legend>

                                        <!-- Text input-->
                                        <div class="form-group">


                                        </div>

                                        <!-- Text input-->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="product_name">Nombre Completo</label>  
                                            <div class="col-md-12">
                                                <input id="nombre" name="nombrecompleto" placeholder="" class="form-control input-md" required="" type="text">

                                            </div>
                                        </div>
                                        
                                        <!-- Text input-->
                                         <div class="form-group">
                                            <label class="col-md-4 control-label" for="product_name">Identificacion</label>  
                                            <div class="col-md-12">
                                                <input id="nombre" name="nombrecompleto" placeholder="" class="form-control input-md" required="" type="text">

                                            </div>
                                        </div>

                                        <!-- Text input-->
                                        <div class="form-group">
                                            <label class="col-md-5 control-label" for="product_name_fr">Correo</label>
                                            <br>
                                            <div class="col-md-12">
                                                <input id="nombre" name="correo" placeholder="" class="form-control input-md" required="" type="text">

                                            </div>
                                        </div>

    
                                         <br>
                                        <div class="form-group">  
                                            <label class="col-md-4 control-label" for="available_quantity">Fecha</label>
                                                <input id="" name="fecha" type="date" />
                                        </div>
                                         
                                         
                                         
                                            <br>
                                          <div class="form-group">
                                       

                                            <select name="medico" class="form-select" aria-label="Default select example">
                                                <br>
                                                <option selected>Medico</option>  
                                                <option value="" ></option>  
                                                <option value="" ></option> 
                                                <option value="" ></option> 
                                                <option value="" ></option>
                                                
                                            </select>
                                              <br>
                                              
                                        <!-- Text input-->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="available_quantity">Sede</label>  
                                            <div class="col-md-12">
                                                <input id="pegi" name="sede" placeholder="Santa Lucia" class="form-control input-md" required="" type="int">

                                            </div>
                                        </div>


                                        <!-- Textarea -->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="product_description">Descripcion</label>
                                            <div class="col-md-12">                     
                                                <textarea class="form-control" id="descripcion" name="descripcion"></textarea>
                                            </div>
                                        </div>




                                        <!-- Button -->
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="singlebutton"></label>
                                            <div class="col-md-12">
                                                <input id="accion" name="accion" class="btn btn-success" type="submit" value="Agregar">
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="singlebutton"></label>
                                    <div class="col-md-12">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
