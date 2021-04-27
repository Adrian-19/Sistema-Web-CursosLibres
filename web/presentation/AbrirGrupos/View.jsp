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
        <title>Abrir grupo</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        
        <div  class="jumbotron bg-transparent" >
            <div class="text-center" class = "container" >
                <h1>Abrir un nuevo grupo </h1>
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
                        <label for="inputId" class="form-label">Horario</label>
                        <input type="text" class="form-control" id="inputCodigo">
                      </div>
                        
                        <div class="col-auto my-6">
                          <label class="mr-sm-2" for="inlineFormCustomSelect">Profesor</label>
                          <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                          </select>
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

