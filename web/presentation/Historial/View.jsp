<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<%@page import="cursosLibres.historial.Model"%>
<%@page import="cursosLibres.logic.Matricula"%>
<%@page import="cursosLibres.logic.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/presentation/Head.jsp" %>

    <title>Login Page</title>
</head>
<body>
    <%@ include file="/presentation/Header.jsp" %>
    <% Model model = (Model) request.getAttribute("model"); %>
    <%List<Matricula> historial = model.getHistorial();%>
    <%Estudiante estudiante = model.getEstudiante();%>

    <div class="mb-5">
        <div class="container-fluid" > 
            <div class="position-relative">
                <span class="d-block border-bottom border-primary" >
                    <h1 class="display-6 text-primary text-center">Datos</h1>
                </span>
            </div>
            <span class="d-block mw-100 h-auto border-bottom border-primary " >
                <dl class="row text-center">
                    <dt class="col-sm-3">ID</dt>
                    <dd class="col-sm-9 text-left"> <%=estudiante.getId()%></dd>
                    <dt class="col-sm-3">Telefono</dt>
                    <dd class="col-sm-9 text-left"> <%=estudiante.getTelefono()%></dd>
                    <dt class="col-sm-3">Correo</dt>
                    <dd class="col-sm-9 text-left"> <%=estudiante.getCorreo()%></dd>
                    <dt class="col-sm-3">Fecha</dt>
                    <dd class="col-sm-9 text-left"> <%=LocalDate.now()%>  </dd>
                </dl>
            </span>
            <div class="position-relative">
                <span class="d-block border-bottom border-primary" >
                    <h1 class="display-6 text-primary text-center">Historial Academico de <%=model.getEstudiante().getNombre()%></h1>
                </span>
            </div>
        </div>
        <div class="containerTabPro  text-center">
            <table class="table table-hover table-primary table-striped">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Nota</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (Matricula m : historial) {%>
                    <tr >
                        <th scope="row"><%=m.getIdCurso()%></th>
                        <td><%=m.getNombreCurso()%></td>
                        <td><%=m.getNota()%></td>
                    </tr>            
                    <%}%>

                </tbody>
            </table>                                      
        </div>   
        <div class="d-flex justify-content-center h-25">
            <a class="btn btn-primary" href="/Sistema-Web-CursosLibres/presentation/Historial/pdf" role="button">Ver PDF</a>
        </div> 
        <div class="d-block h-25">

        </div>

    </div>
                    
    <div class="d-block h-25">
        <span class="mh-100"></span>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>


</body>

