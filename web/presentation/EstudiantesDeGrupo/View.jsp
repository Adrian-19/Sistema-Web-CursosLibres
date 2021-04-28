<%-- 
    Document   : View
    Created on : Apr 25, 2021, 11:19:36 AM
    Author     : adria
--%>


<%@page import="cursosLibres.logic.Matricula"%>
<%@page import="cursosLibres.logic.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import = "cursosLibres.EstudiantesDeGrupo.Model" %>
<%
    Model model = (Model) request.getAttribute("model");
    List<Estudiante> estudiantes = model.getEstudiantes();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div class = "container">
            <hr>
            <table class = "table table-warning table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Teléfono</th>
                    <th>Correo</th>
                    <th>Calificación</th>
                    <th> </th>
                </tr>
                <% for(Estudiante e : estudiantes) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=e.getId()%></td>
                    <td><%=e.getNombre()%></td> 
                    <td><%=e.getCorreo()%></td>
                    <%for(Matricula h : e.getHistorial()){%>
                    <%if(h.getNombreCurso().equals(model.getCurso().getNombre())){%>
                        <td><%=h.getNota()%></td> 
                    <%}%>
                    <%}%>
                    
                    <td> </td>
                    <td>
                        <!--Pendiente-->
                        <a href = "/Sistema-Web-CursosLibres/presentation/Calificacion/View.jsp" class = "btn btn-default" role = "button">Poner calificación</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
