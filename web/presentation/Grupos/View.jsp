<%-- 
    Document   : View
    Created on : Apr 18, 2021, 2:30:22 PM
    Author     : adria
--%>

<%@page import="cursosLibres.logic.Grupo"%>
<%@page import="java.util.List"%>
<!-- Pedir al model del MVC si existe un usuario logeado -->
<!-- Recibir el nombre del curso  -->

<%@page import = "cursosLibres.grupos.Model"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Grupo> grupos = model.getListaGrupos();
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
            <div class = "row">
                <div class = "col-md-6">
                    <h1 class = "page-header">Grupos del curso <!-- Nombre del curso seleccionado --></h1>
                    <h3><%=model.getCurrent().getNombre()%></h3>
                </div>
                <div class ="col-md-6">
                    <%if(session.getAttribute("exitoso")!=null){%>
                    <%int criterio = (Integer) session.getAttribute("exitoso");%>
                    <%if(criterio == 1){%>
                        <div class="alert alert-success" role="alert">
                            Matricula exitosa!
                        </div>
                    <%session.setAttribute("exitoso", 0);%>
                    <%}%>
                    <%}%>
                </div>
            </div>
            <table class = "table table-primary table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Profesor(a)</th>
                    <th>Horario</th>
                    <% if(model.getMatriculado() != 1){%>
                    <th> </th>
                    <%}%>
                </tr>
                <% for(Grupo g : grupos) {%> <!-- Recorrer lista de grupos del curso seleccionado -->
                <tr>
                    <td><%=g.getId()%></td>
                    <td><%=g.getProfesor().getNombre()%></td> 
                    <td><%=g.getHorario()%></td>
                    <% if(model.getMatriculado() != 1){%>
                    <td>
                        <a href="/Sistema-Web-CursosLibres/presentation/Grupos/matricular?grupoID=<%=g.getId()%>&cursoId=<%=model.getCurrent().getId()%>" class = "btn btn-default" role ="button"> Matricularme </a>
                    </td>
                    <%}%>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
