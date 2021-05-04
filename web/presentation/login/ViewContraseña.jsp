<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cursosLibres.login.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <%@ include file="/presentation/Head.jsp" %>
    <link rel="stylesheet" href = "/Sistema-Web-CursosLibres/css/registros.css">

    <title>Login Page</title>
</head>
<body>
    <%@ include file="/presentation/Header.jsp" %>
    <% Model model = (Model) request.getAttribute("model");%>
    <% String clave = model.getCurrent().getClave();%>    
    <!-- Main Content -->
    <div class="container-fluid">
        <div class="row main-content bg-success text-center">
            <div class="col-md-4 text-center company_info">
                <h4 class="company_title">Cursos Libres</h4>
            </div>
            <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
                <div class="container-fluid">
                    <div class="row pb-4 pt-2">
                        <h1 class="text-primary">Te has registrado en CursosLibres</h1>
                    </div>

                    <div class="row">
                        <p class="fs-4"> Gracias por elegir CursosLibres para sus estudios. CursosLibres tiene muchos cursos sobre distintas temáticas a los cuales se puede inscribir.</p>

                    </div>
                    <div class="row">
                        <p class="fs-4"> Para acceder a tu cuenta en futuras ocasiones necesitaras usar la siguiente clave: </p>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-md-auto">
                            <h3><%=clave%></h3>
                        </div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div>
                            <a class="btn btnRL" href="/Sistema-Web-CursosLibres/presentation/VerCursos/show" role="button">Ir la pagina principal</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>