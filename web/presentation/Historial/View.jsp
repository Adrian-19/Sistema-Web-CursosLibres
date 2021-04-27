<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDate"%>
<%@page import="cursosLibres.historial.Model"%>
<%@page import="cursosLibres.logic.Matricula"%>
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





    <div >
        <div class="mw-100 mh-100" > 
            <span class="mw-100 mh-100 border-bottom border-primary" >
            <h1 class="display-6 text-primary text-center align-middle">Historial Academico de <%=model.getEstudiante().getNombre()%></h1>
        </span>
        </div>
        <div >
            <dl class="row text-center">
                <dt class="col-sm-3">ID</dt>
                <dd class="col-sm-9 text-left"> <%=model.getEstudiante().getId()%></dd>
                <dt class="col-sm-3">Telefono</dt>
                <dd class="col-sm-9 text-left"> <%=model.getEstudiante().getTelefono()%></dd>
                <dt class="col-sm-3">Correo</dt>
                <dd class="col-sm-9 text-left"> <%=model.getEstudiante().getCorreo()%></dd>
                <dt class="col-sm-3">Fecha</dt>
                <dd class="col-sm-9 text-left"> <%=LocalDate.now()%>  </dd>

            </dl>

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
    </div>

</body>

