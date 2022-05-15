<%-- 
    Document   : registro
    Created on : 3/05/2022, 04:35:36 PM
    Author     : santi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesion</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/estilos-registro.css">
</head>
<body>

        <main>
            
            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Inicia sesión para entrar en la página</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Regístrarse</button>
                        
                    </div>
                </div>

                <!--Formulario de Login y registro-->
                <div class="contenedor__login-register">
                    <!--Login-->
                    <form action="${pageContext.request.contextPath}/controlador?accion=login" method="POST" class="formulario__login">
                        <h2>Iniciar Sesión</h2>
                        <input type="text" name="correo" placeholder="Usuario">
                        <input type="password" name="contrasena" placeholder="Contraseña">
                        <button type="submit">Entrar</button>
                        <a href="../index.jsp">Regresar a Inicio</a>
                        
                    </form>
                    
                    <!--Register-->
                    <form action="${pageContext.request.contextPath}/controlador?accion=registrar" method="POST" class="formulario__register">
                        
                        <h2>Regístrarse</h2>
                        <input type="text" name="nombreCompleto" placeholder="Nombre Completo">
                        <input type="text" name="tipoDocumento" placeholder="Tipo de Documento">
                        <input type="text" name="numeroDocumento"  placeholder="Identificación">
                        <input type="text" name="telefono"  placeholder="Telefono">
                        <input type="text" name="correo" placeholder="Correo Electronico">    
                        <input type="password" name="contrasena" placeholder="Contraseña">
                        <input name="perfil" value="Paciente" type="hidden"/> 
                        <input class="btn btn-success" type="submit">
                        <br><br>
                        <a href="../index.jsp">Regresar a Inicio</a>
                    </form>
                        
                        
                </div>
            </div>

        </main>

        <script src="../Scripts/script-registro.js"></script>
</body>
</html>
