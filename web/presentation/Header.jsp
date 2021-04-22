<%-- 
    Document   : index
    Created on : Apr 16, 2021, 9:41:11 AM
    Author     : ESCINF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
      <%@ include file="/presentation/Head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                
              <a class="navbar-brand" href="/Sistema-Web-CursosLibres/presentation/Index.jsp">CursosLibres</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    
                    <!-- Pestaña de Login -->
                  <li class="nav-item">
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/Login/show">Login</a>
                  </li>
                  
                  
                  
                  <li class="nav-item">
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/Login ">Registrarse</a>
                  </li>      
                  
                  <li class="nav-item">
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/VerCursos/View.jsp">Cursos</a>
                  </li>
                  
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Otras opciones
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/teacherRegistration/View.jsp">Registrar Profesor</a></li> 
                     <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/RegistrarCursos/View.jsp">Registrar Cursos</a></li>

                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/Grupos/View.jsp">Ver Grupos</a></li>
                    </ul>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    </body>
</html>