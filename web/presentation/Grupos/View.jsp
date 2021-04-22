<%-- 
    Document   : View
    Created on : Apr 18, 2021, 2:30:22 PM
    Author     : adria
--%>

<!-- Pedir al model del MVC si existe un usuario logeado -->
<!-- Recibir el nombre del curso  -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        
        <%@ include file="/presentation/Head.jsp" %>
        <title>Grupos</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <hr>
        <div class = "container">
            <h1 class = "page-header">Grupos del curso <!-- Nombre del curso seleccionado --></h1>
        </div>
        <div class = "container">
            <table class = "table table-primary table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Profesor</th>
                    <th>Horario</th>
                    <th> </th>
                </tr>
                <% for(int i = 0; i<10; i++) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=i%></td>
                    <td>Adrian</td> 
                    <td>12:30 - 4:20</td>
                    <td>
                        <button class = "btn btn-primary">Matricular</button>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
