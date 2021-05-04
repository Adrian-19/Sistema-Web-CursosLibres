<%-- 
    Document   : index
    Created on : Apr 16, 2021, 9:41:11 AM
    Author     : ESCINF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cursosLibres.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<!DOCTYPE html>
<html lang="es">
    <head>
      <%@ include file="/presentation/Head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                
              <a class="navbar-brand" href="/Sistema-Web-CursosLibres/presentation/VerCursos/show">CursosLibres</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    

                  <%if(usuario == null){%> <!-- Si no hay un usuario logeado, puede hacer login -->
                  <li class="nav-item">
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/login/show">Login</a>
                  </li>
                  <%}%>
                 <% if (usuario!=null){ %>  <!-- Si hay un usuario logeado, puede hacer logout -->                 
                <li class="nav-item">
                    <%String nombre = (String) session.getAttribute("nombreUsuario");%>
                  <a class="nav-link disabled"  href="#"><%=nombre%></a>
                </li>
                
                <li class="nav-item">
                  <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/login/logout">Logout</a>
                </li>
                <!-- Despliegue de funcionalidades del administrador -->                
                <% if (usuario.getTipo()==0){ %>  <!-- Administrador es un usuario de tipo 0? -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Registro
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/teacherRegistration/show">Registro Profesores</a></li>
                      <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/RegistrarCursos/show">Registrar Cursos</a></li>
                      <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/VerCursos/show">Ver cursos</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                <% } %>
                
                <!-- Despliegue de funcionalidades del profesor -->
                <% if (usuario.getTipo()==1) {%> <!-- Profesor es un usuario de tipo 1? -->
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Gestión
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <!-- Por separado o en una sola pagina? -->
                      <li><a class="dropdown-item" href="/Sistema-Web-CursosLibres/presentation/GruposDeProfesor/show">Ver mis grupos</a></li>
                     
                    </ul>
                  </li>
                <%}%>
                <%if(usuario.getTipo() == 2){%> 
                  <li class="nav-item">
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/Historial/showRecord">Historial</a>
                  </li>
                <%}%>
                
                <% } %>
                

                  <%if (usuario == null){%> <!-- Si no hay un usuario logeado, puede registrarse -->
                  <li>
                    <a class="nav-link active" href="/Sistema-Web-CursosLibres/presentation/login/showRegister">Registrarse</a>
                  </li>  
                  <%}%>

                  <!-- Dropdown adicional... Se utilizara para algo en especifico? -->
                  <!--
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
                -->
                </ul>
              </div>
            </div>
          </nav>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    </body>
</html>