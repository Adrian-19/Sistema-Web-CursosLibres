<%-- 
    Document   : View
    Created on : Apr 19, 2021, 11:09:40 AM
    Author     : DS
--%>

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
        
        <div  class="jumbotron bg-transparent" >
            <div class="text-center" class = "container" >
                <h1>Registro de cursos </h1>
            </div>
        </div>

        <div class="container main-content bg-dark">
             <form class="container row g-3 text-white form-horizontal m-4">


              <div class="form-group col-md-6 text-center">
                  <br>
                <label for="inputNombre" class="form-label">Nombre del curso</label>
                <input type="text" class="form-control" id="inputNombre">
              </div>


               <div class="form-group col-md-6 text-center">
                   <br>
                <label for="inputTematica" class="form-label">Tematica</label>
                <input type="text" class="form-control" id="inputTematica">
               </div>


              <div class="form-group col-md-6 text-center">
                <label class="form-label">Costo</label>
                <input type="text" class="form-control" id="inputCosto">
              </div>


                 <div class="form-group col-md-12">
                  <label for="LogoFile">Logo del curso</label>
                  <input type="file" class="form-control-file" id="LogoFile">
                </div>                       

                <div class="form-group col-md-6">
                    <br>

                    <div class="form-check">
                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="habilitado">
                      <label class="form-check-label" for="habilitado">
                        Habilitado
                      </label>
                    </div>

                    <br>

                    <div class="form-check">
                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="deshabilitado" checked>
                      <label class="form-check-label" for="deshabilitado">
                        Deshabilitado
                      </label>
                    </div>  

                </div>                         


              <div class="form-group col-12 text-center" >
                  <br><br>
                <button type="submit" class="btn btn-primary">Guardar</button>
                 <br><br>
              </div>
            </form>           

        </div>

    </body>
</html>
