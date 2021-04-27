<%-- 
    Document   : View
    Created on : Apr 25, 2021, 10:01:14 AM
    Author     : adria
--%>

<%@page import="cursosLibres.logic.Grupo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cursosLibres.gruposDeProfesor.Model"%>
<%
  Model model = (Model) request.getAttribute("model");
  List<Grupo> grupos = model.getGrupos();
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
            <table class = "table table-primary table-striped table-hover">
                <tr>
                    <th>Nombre del Curso</th>
                    <th>Horario</th>
                    <th> </th>
                </tr>
                <% for(Grupo g:grupos) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=g.getId()%></td> 
                    <td><%=g.getHorario()%></td>
                    <td>
                        <a href = "#" class = "btn btn-default" role = "button">Ver lista de estudiantes</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
