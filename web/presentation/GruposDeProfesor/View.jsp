<%-- 
    Document   : View
    Created on : Apr 25, 2021, 10:01:14 AM
    Author     : adria
--%>

<%@page import="java.util.HashMap"%>
<%@page import="cursosLibres.logic.Grupo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cursosLibres.gruposDeProfesor.Model"%>
<%
  Model model = (Model) request.getAttribute("model");
 HashMap<String, List<Grupo>> grupos = model.getGrupos();
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
            <h2>Mis Grupos</h2>
            
            <table class = "table table-primary table-striped table-hover">
                <tr>
                    <th>ID del Grupo</th>
                    <th>Nombre del Curso</th>
                    <th>Horario</th>
                    <th> </th>
                </tr>
                <% for(String s : grupos.keySet()) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <%List<Grupo> actual = grupos.get(s);%>
                <% for(Grupo g : actual){%>
                <tr>
                    <td><%=g.getId()%></td>
                    <td><%=s%></td> 
                    <td><%=g.getHorario()%></td>
                    <td>
                        <a href = "/Sistema-Web-CursosLibres/presentation/EstudiantesDeGrupo/show?grupoID=<%=g.getId()%>&nombreCurso=<%=s%>" class = "btn btn-default" role = "button">Ver lista de estudiantes</a>
                    </td>
                </tr>
                <% } %>
                <%}%>
            </table>
        </div>
    </body>
</html>
