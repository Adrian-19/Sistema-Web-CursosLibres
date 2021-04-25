<%-- 
    Document   : View
    Created on : Apr 25, 2021, 11:19:36 AM
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
                <% for(int i = 0; i<10; i++) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=i%></td>
                    <td>Adrian</td> 
                    <td>22222222</td> 
                    <td>adrian@gmail.com</td> 
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
