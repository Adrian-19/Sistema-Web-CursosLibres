<%-- 
    Document   : View
    Created on : Apr 25, 2021, 10:01:14 AM
    Author     : adria
--%>

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
            <table class = "table table-primary table-striped table-hover">
                <tr>
                    <th>ID del Grupo</th>
                    <th>Nombre del Curso</th>
                    <th>Horario</th>
                    <th> </th>
                </tr>
                <% for(int i = 0; i<10; i++) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=i%></td>
                    <td>Adrian</td> 
                    <td>12:30 - 4:20</td>
                    <td>
                        <a href = "/Sistema-Web-CursosLibres/presentation/EstudiantesDeGrupo/View.jsp" class = "btn btn-default" role = "button">Ver lista de estudiantes</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
