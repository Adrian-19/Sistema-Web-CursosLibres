<%-- 
    Document   : View
    Created on : Apr 19, 2021, 11:09:40 AM
    Author     : DS
--%>

<%@page import="cursosLibres.registrarCursos.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de cursos</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <% Model model = (Model) request.getAttribute("model"); %>
         <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>

        <div  class="jumbotron bg-transparent" >
            <div class="text-center" class = "container" >
                <h1>Registro de cursos </h1>
            </div>
        </div>

        <div  class="container main-content bg-dark">
             <form method="post" enctype="multipart/form-data" name="RegistroCursos" action="/Sistema-Web-CursosLibres/presentation/RegistrarCursos/register"  class="container row g-3 text-white form-horizontal m-4">


              <div class="form-group col-md-6 text-center" class="form-group">
                  <br>
                <label class="form-label">Nombre del curso</label>
                <input type="text" class="form-control" name="nombreCurso" id="nombreCurso" value="<%=form.get("nombreCurso")[0]%>" title="<%=title("nombreCurso", errores)%>"  class="form_input <%=erroneo("nombreCurso", errores)%>">
              </div>


               <div class="form-group col-md-6 text-center" class="form-group">
                   <br>
                <label  class="form-label">Tematica</label>
                <input type="text" class="form-control" name="inputTematica" id="inputTematica" value="<%=form.get("inputTematica")[0]%>" title="<%=title("inputTematica", errores)%>"  class="form_input <%=erroneo("inputTematica", errores)%>" >
               </div>


              <div class="form-group col-md-6 text-center" class="form-group">
                <label class="form-label">Costo</label>
                <input type="text" class="form-control" name="inputCosto" id="inputCosto" value="<%=form.get("inputCosto")[0]%>"  title="<%=title("inputCosto", errores)%>"  class="form_input <%=erroneo("inputCosto", errores)%>" >
              </div>


                 <div class="form-group col-md-12" class="form-group">
                  <label for="LogoFile">Logo del curso</label>
                  <input type="file" class="form-control-file" name="logoFile" id="logoFile">
                </div>    
                 
                 <!-- Estado -->
                <div class="form-group col-md-2 text-center" class="form-group">
                    <br>
                    <label class="form-label">Estado</label> <br>
                    
                      <select class="form-select" id="estado" name="estado" id="estado" value="<%=form.get("estado")[0]%> "   title="<%=title("estado", errores)%>"  class="form_input <%=erroneo("estado", errores)%>" >
                        <option selected>Seleccionar...</option>
                        <option value="En oferta">En oferta</option>
                        <option value="Deshabilitado">Deshabilitado</option>
                      </select>
                </div>



              <div class="form-group col-12 text-center" class="form-group">
                  <br><br>
                <button type="submit" class="btn btn-primary">Guardar</button>
                 <br><br>
              </div>
            </form>           

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
        values.put("nombreCurso", new String[]{model.getCurrentCurso().getNombre() });
        values.put("inputTematica", new String[]{model.getCurrentCurso().getTematica()});
        values.put("inputCosto", new String[]{String.valueOf(model.getCurrentCurso().getCosto() ) });
        values.put("estado", new String[]{model.getCurrentCurso().getTematica()});
// imagen? 
        return values;
    }


%> 