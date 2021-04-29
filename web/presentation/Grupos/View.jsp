<%-- 
    Document   : View
    Created on : Apr 18, 2021, 2:30:22 PM
    Author     : adria
--%>

<%@page import="cursosLibres.logic.Grupo"%>
<%@page import="java.util.List"%>
<!-- Pedir al model del MVC si existe un usuario logeado -->
<!-- Recibir el nombre del curso  -->

<%@page import = "cursosLibres.Grupos.Model"%>
<%
    Model model = request.getAttribute("model");
    List<Grupo> grupos = model.getGrupos();
%>
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
                <% for(Grupo g : grupos) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=g.getId()%></td>
                    <td><%=g.getProfesor().getNombre()%></td> 
                    <td><%=g.getHorario()%></td>
                    <td>
                        <a href="/Sistema-Web-CursosLibres/presentation/Grupos/matricular?grupoID=<%=g.getId()%>" class = "btn btn-default" role ="button"> Matricularme </a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
