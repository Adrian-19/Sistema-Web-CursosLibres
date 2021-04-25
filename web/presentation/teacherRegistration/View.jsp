<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursosLibres.teacherRegistration.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/presentation/Head.jsp" %>

    <title>Login Page</title>
</head>
<body>
    <%@ include file="/presentation/Header.jsp" %>
    <% Model model = (Model) request.getAttribute("model"); %>
    <%List<Usuario> usuarios = model.getUsuarios();%>
    <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
    <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>
    <!-- Main Content -->
    <div class="container-fluid">
        <div class="row main-content bg-success text-center">
            <div class="col-md-4 text-center company_info">
                <h4 class="company_title">Cursos Libres</h4>
            </div>
            <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
                <div class="container-fluid">
                    <div class="row">
                        <h2>Registrar Profesor</h2>
                    </div>
                    <div class="row">
                        <form method="post" name="RegistroPro" action="/Sistema-Web-CursosLibres/presentation/teacherRegistration/register" class="form-group">
                            <div class="row">
                                <input type="text" name="cedulaProFld" value="<%=form.get("cedulaProFld")[0]%>" title="<%=title("cedulaProFld", errores)%>" class="form_input <%=erroneo("cedulaProFld", errores)%>" placeholder="ID">
                            </div>
                            <div class="row">
                                <input type="password" name="claveProFld" value="<%=form.get("claveProFld")[0]%>"  title="<%=title("claveProFld", errores)%>" class="form_input <%=erroneo("claveProFld", errores)%>" placeholder="Contraseña">
                            </div>
                            <div class="row">
                                <input type="text" name="telefonoProFld" value="<%=form.get("telefonoProFld")[0]%>"  title="<%=title("telefonoProFld", errores)%>" class="form_input <%=erroneo("telefonoProFld", errores)%>" placeholder="Telefono">
                            </div>
                            <div class="row">
                                <input type="text" name="correoProFld" value="<%=form.get("correoProFld")[0]%>"  title="<%=title("correoProFld", errores)%>" class="form_input <%=erroneo("claveProFld", errores)%>" placeholder="Correo">
                            </div>
                            <div class="row">
                                <input type="text" name="especProFld" placeholder="Especialidades" class="form_input">
                            </div>


                            <div class="row">
                                <input type="submit" value="Registrar" class="btn btnRL">
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div class="text-center">
        <h2>Lista de profesores</h2>
    <div class="containerTabPro  text-center">
        <table class="table table-hover table-primary table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Clave</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Correo</th>
                </tr>
            </thead>
            <tbody>
               <% for(Usuario u:usuarios){%>
                <tr >
                    <th scope="row"><%=u.getCedula()%></th>
                    <td><%=u.getClave()%></td>
                    <td><%=u.getTelefono()%></td>
                    <td><%=u.getCorreo()%></td>
                </tr>            
                <%}%>
                
            </tbody>
        </table>                                      
    </div>                                       
</div>

</body>

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
        values.put("cedulaProFld", new String[]{model.getProfesor().getCedula()});
        values.put("claveProFld", new String[]{model.getProfesor().getClave()});
        values.put("correoProFld", new String[]{model.getProfesor().getCorreo()});
        values.put("telefonoProFld", new String[]{model.getProfesor().getTelefono()});
        return values;
    }


%>