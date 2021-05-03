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
 
    <head>
         <%@ include file="/presentation/Head.jsp" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cursos </title>
    </head>
    
        <%@ include file="/presentation/Header.jsp" %>
        <% Model model = (Model) request.getAttribute("model"); %>
        <%List<Curso> cursos = model.getListaCursos();%>
        
        
        <div  class="jumbotron bg-transparent" >
            <div class="text-center" class = "container" >
                <h1>Descubra nuestros cursos</h1>
                
                <%-- Search bar --%>
                
               
                <div class="p-4 bg-transparent main-content">
                   <form action="/Sistema-Web-CursosLibres/presentation/VerCursos/buscar"  method="post" class="form-inline">
                   <input type="text" class="form-control" placeholder="Buscar cursos" name="busqCursos"  id="busqCursos">
                   <button type="submit" class=" btn-outline-primary" >Search</button>                       
                   </form>
                   

                </div>


            </div>
        </div>
        
        <br>  
        
        <!<!-- curso 1 -->
        <div class="container main-content">
            
            <div class="row">
                <%for (Curso c: model.getListaCursos()){ %>
                    <div class="container card">
                        <div class="main-content">
                          <img src="/Sistema-Web-CursosLibres/presentation/RegistrarCursos/image?cursoId=<%=c.getId()%>" class="card-img-top" alt="...">  
                        </div>
                        
                          <table class="container p-4 m-5">
                              <tbody>
                                  <tr>
                                   <th scope="row"> <% c.getNombre(); %> </th>   
                                   <td> <%=c.getId()%> </td> 
                                   <td> <%=c.getNombre() %> </td> 
                                   <%--revisar referencia --%>
                                   <td>
                                    <a href="/Sistema-Web-CursosLibres/presentation/Grupos/show?cursoId=<%=c.getId()%>"> Ver grupos </a> 
                                   </td>
                                   
                                   <%if(model.getUsuario() != null && model.getUsuario().getTipo() == 0){ %>
                                        <td>
                                         <a href="/Sistema-Web-CursosLibres/presentation/AbrirGrupos/show?cursoId=<%=c.getId()%>"> Abrir grupos </a> 
                                         
                                        </td>

                                   <%}%>
                                   
                                  </tr>                              
                              </tbody>                        
                          </table>                            
                       
                    </div>      
                      
                <%}%>
            </div>
 
            <br>
    
        </div><!-- fin -->
        
