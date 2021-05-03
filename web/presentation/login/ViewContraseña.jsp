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
        <% Model model= (Model) request.getAttribute("model"); %>
	<!-- Main Content -->
	<div class="container-fluid">
		<div class="row main-content bg-success text-center">
			<div class="col-md-4 text-center company_info">
				<h4 class="company_title">Cursos Libres</h4>
			</div>
			<div class="col-md-8 col-xs-12 col-sm-12 login_form ">
				<div class="container-fluid">
					<div class="row">
						<h2>Gracias por registrarte en cursos libres</h2>
					</div>
					<div class="row">
                                            

					</div>

				</div>
			</div>
		</div>
	</div>

</body>