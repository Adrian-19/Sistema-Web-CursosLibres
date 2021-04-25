<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursosLibres.login.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
      
	<title>Login Page</title>
</head>
<body>
      <%@ include file="/presentation/Header.jsp" %>
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
	<!-- Main Content -->
	<div class="container-fluid">
		<div class="row main-content bg-success text-center">
			<div class="col-md-4 text-center company_info">
				<h4 class="company_title">Cursos Libres</h4>
			</div>
			<div class="col-md-8 col-xs-12 col-sm-12 login_form ">
				<div class="container-fluid">
					<div class="row">
						<h2>Registrar Usuario</h2>
					</div>
					<div class="row">
						<form method="post" name="Inicio" action="/Sistema-Web-CursosLibres/presentation/login/register" class="form-group">
							<div class="row">
								<input type="text" name="cedulaFld" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld",errores)%>" class="form_input <%=erroneo("cedulaFld",errores)%>" placeholder="ID">
							</div>
							<div class="row">
								<input type="password" name="claveFld" value="<%=form.get("claveFld")[0]%>"  title="<%=title("claveFld",errores)%>" class="form_input <%=erroneo("claveFld",errores)%>" placeholder="Contraseña">
							</div>
                                                        <div class="row">
								<input type="text" name="telefonoFld" value="<%=form.get("telefonoFld")[0]%>"  title="<%=title("telefonoFld",errores)%>" class="form_input <%=erroneo("telefonoFld",errores)%>" placeholder="Telefono">
							</div>
                                                        <div class="row">
								<input type="text" name="correoFld" value="<%=form.get("correoFld")[0]%>"  title="<%=title("correoFld",errores)%>" class="form_input <%=erroneo("claveFld",errores)%>" placeholder="Correo">
							</div>
                                                        
                                                        
							<div class="row">
								<input type="submit" value="Registrarse" class="btn btnRL">
							</div>
						</form>
					</div>
	
				</div>
			</div>
		</div>
	</div>

</body>

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
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("claveFld", new String[]{model.getCurrent().getClave()});
       values.put("correoFld", new String[]{model.getCurrent().getCorreo()});
       values.put("telefonoFld", new String[]{model.getCurrent().getTelefono()});
       return values;
    }



%>