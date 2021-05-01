<%-- 
    Document   : View
    Created on : Apr 25, 2021, 11:19:36 AM
    Author     : adria
--%>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursosLibres.logic.Matricula"%>
<%@page import="cursosLibres.logic.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import = "cursosLibres.EstudiantesDeGrupo.Model" %>
<%
    Model model = (Model) request.getAttribute("model");
    List<Estudiante> estudiantes = model.getEstudiantes();
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
        <title>Mis Grupos</title>
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
                    <td><%=e.getTelefono()%></td>
                    <td><%=e.getCorreo()%></td>
                    <%for(Matricula m : model.getListaMatriculas()){%>
                        <%if(m.getIdEstudiante().equals(e.getId())){%>
                        <%model.setMatricula(m);%>
                            <td><%=m.getNota()%></td>
                        <%}%>
                    <%}%>
                    <td>
                        <form method ="post" name="Calificacion" action ="/Sistema-Web-CursosLibres/presentation/EstudiantesDeGrupo/calificar?grupoID=<%=model.getMatricula().getIdGrupo()%>&estudianteID=<%=model.getMatricula().getIdEstudiante()%>">
                            <input type ="text" name = "calificarFld" value="<%=form.get("calificarFld")[0]%>" title ="<%=title("calificarFld",errores)%>" class = "form_input <%=erroneo("calificarFld",errores)%>" placeholder="Agregar calificacion">
                            <button type ="submit" class ="btn btn-warning" value ="Calificar">Guardar</button>
                        </form>
                        <!--Pendiente
                        <a href = "/Sistema-Web-CursosLibres/presentation/Calificacion/View.jsp" class = "btn btn-default" role = "button">Poner calificación</a>
                        -->
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>

<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }
    
    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<String,String[]>();
       values.put("calificarFld", new String[]{String.valueOf(model.getMatricula().getNota())});
       return values;
    }
%>