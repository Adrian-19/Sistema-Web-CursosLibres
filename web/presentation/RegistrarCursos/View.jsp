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
        
        <br> 
        
        
        <div class="container">
            
            <div class="row">
 
                <div class="col bg-dark ">
                    
                    <form class="row g-3 text-white">
                        
                        
                      <div class="col-md-6">
                          <br>
                        <label for="inputName" class="form-label">Nombre del curso</label>
                        <input type="text" class="form-control" id="inputNombre">
                      </div>
                        
                      <div class="col-md-6">
                          <br>
                        <label for="inputId" class="form-label">Codigo del curso</label>
                        <input type="text" class="form-control" id="inputCodigo">
                      </div>
                        
                       <div class="col-md-6">
                        <label for="inputName" class="form-label">Tematica</label>
                        <input type="text" class="form-control" id="inputTematica">
                       </div>
   
                        
                      <div class="col-md-6">
                        <label class="form-label">Costo</label>
                        <input type="text" class="form-control" id="inputCosto">
                      </div>
                        

                        

                        <div class="col-12">
                            <br>
                            <label class="form-label">Logo</label>
                            <div class="input-group">
                              <input type="file" class="form-control"  id="inputGroupFile04">
                            </div>                 
                    
                            <br>
                        </div>
                        
                        <div class="col-md-6">
                            <br>
                            
                            <div class="form-check">
                              <input class="form-check-input" type="radio" name="flexRadioDefault" id="habilitado">
                              <label class="form-check-label" for="flexRadioDefault1">
                                Habilitado
                              </label>
                            </div>
                            
                            <br>
                            
                            <div class="form-check">
                              <input class="form-check-input" type="radio" name="flexRadioDefault" id="deshabilitado" checked>
                              <label class="form-check-label" for="flexRadioDefault2">
                                Deshabilitado
                              </label>
                            </div>  
                            
                        </div>                         
                        
                        
                      <div class="col-12" >
                          <br><br>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                      </div>
                    </form>
                    
                    <br>

                </div>
                
                
                
                
                
                <div class="col bg-transparent">
                    <h3>
                       
                      
                    </h3>                    

                </div>                  
             
                
            </div>
            
     
            <div class="row"> 
                <br><br>
            
            </div>
            
    
        </div>

    </body>
</html>
