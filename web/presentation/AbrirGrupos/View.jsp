<%-- 
    Document   : View
    Created on : Apr 19, 2021, 11:09:40 AM
    Author     : DS
--%>

<%@page import="cursosLibres.logic.Curso"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursosLibres.logic.Grupo"%>
<%@page import="java.util.List"%>
<%@page import="cursosLibres.abrirGrupos.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abrir grupo</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
         <% Model model = (Model) request.getAttribute("model"); %>

         <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>

        <!-- Main Content --> 
        <div  class="jumbotron bg-transparent text-center" >
            <h1>Abrir un nuevo grupo </h1>
        </div>

        <div class="container main-content bg-dark text-center p-4">
            
        <%-- inicio del form--%>           
            <form method="post" name="RegistroGrupos" action="/Sistema-Web-CursosLibres/presentation/AbrirGrupos/register" class="container form-horizontal text-white bg-dark col-9" >
                <br>
                      
         
                <%-- Input para el profesor --%>
                <div class="form-group">

                  <label class="mr-sm-2" for="inlineFormCustomSelect">Profesor</label>
                  <input type="text" class="form-control" name="idProfesor"  id="idProfesor" value="<%=form.get("idProfesor")[0]%>"  title="<%=title("idProfesor", errores)%>" class="form_input <%=erroneo("idProfesor", errores)%>" placeholder="Cédula del profesor">
                </div>  

                <div class="form-group"> <%-- hora inicio --%>
                  <br>
                <label for="inputId" class="form-label">Hora de inicio</label>
                <input type="time" class="form-control" name="inputHorarioInic" id="inputHorarioInic"  value="<%=form.get("inputHorarioInic")[0]%>"  title="<%=title("inputHorarioInic", errores)%>" class="form_input <%=erroneo("inputHorarioInic", errores)%>" >
              </div>    

              <div class="form-group"> <%--hora fin --%>
                  <br>
                <label for="inputId" class="form-label">Hora de finalización</label>
                <input type="time" class="form-control" name="inputHorarioFin"  id="inputHorarioFin"  value="<%=form.get("inputHorarioFin")[0]%>"  title="<%=title("inputHorarioFin", errores)%>" class="form_input <%=erroneo("inputHorarioFin", errores)%>">
              </div>

              <div class="form-group">
                  <br><br>
                <button type="submit" class="btn btn-primary" value="Registrar">Guardar</button>
                <br> <br> 
              </div>

              </div>
                      
            </form>
          
            <br> <br> <br> <br> 
        <%-- fin del form--%>  
        </div>
        
    </body>
</html>

<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<String, String[]>();
        values.put("idProfesor", new String[]{model.getCurrentGrupo().getId()});
        values.put("inputHorarioInic", new String[]{model.getCurrentGrupo().getHorario()});
        values.put("inputHorarioFin", new String[]{model.getCurrentGrupo().getHorario()});

//falta list de estudiantes? 

        return values;
    }


%> 