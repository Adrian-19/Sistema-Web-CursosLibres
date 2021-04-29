<%-- 
    Document   : View
    Created on : Apr 18, 2021, 11:04:15 PM
    Author     : DS
--%>

<%@page import="cursosLibres.logic.Curso"%>
<%@page import="java.util.List"%>
<%@page import="cursosLibres.verCursos.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
         <%@ include file="/presentation/Head.jsp" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cursos </title>
    </head>
    <body >
        <%@ include file="/presentation/Header.jsp" %>
        <% Model model = (Model) request.getAttribute("model"); %>
        <%List<Curso> cursos = model.getListaCursos();%>

        
        
        <div  class="jumbotron bg-transparent" >
            <div class="text-center" class = "container" >
                <h1>Descubra nuestros cursos</h1>
                
                <%-- Search bar --%>
                <div class="input-group mb-3 p-4 bg-transparent main-content">
                  <input type="text" class="form-control" placeholder="Buscar cursos" aria-label="Buscar cursos" aria-describedby="button-addon2">
                  <button class="btn btn-outline-primary" type="button" id="button-addon2">Search</button>
                </div>
               

            </div>
        </div>
        
        <br>  
        
        <!<!-- curso 1 -->
        <div method="post" class="container main-content">
            
            <div class="row">
                <%for (Curso c: cursos){ %>
                    <div class="container card">
                        <div class="main-content">
                          <img src="/Tanteando/images/logo.jpg" class="card-img-top" alt="...">  
                        </div>
                        
                          <table class="container p-4 m-5">
                              <tbody>
                                  <tr>
                                   <th scope="row"> <% c.getNombre(); %> </th>   
                                   <td> <%=c.getId()%> </td> 
                                   <td> <%=c.getNombre() %> </td> 
                                   <%--revisar referencia --%>
                                   <td>
                                        <a href="/Sistema-Web-CursosLibres/presentation/GruposDeProfesor/show"> Ver grupos </a>
                                   </td>
                                   <th> <%c.getTematica(); %> </th> 
                                  </tr>                              
                              </tbody>                        
                          </table>                            
                       
                    </div>      
                      
                <%}%>
            </div>
 
            <br>
    
        </div><!-- fin -->
        
 
    </body>
</html>
