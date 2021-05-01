/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.grupos;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import cursosLibres.logic.Matricula;
import cursosLibres.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adria
 */
@WebServlet(name = "GruposController", urlPatterns = {"/presentation/Grupos/show", "/presentation/Grupos/matricular"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/Grupos/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/Grupos/matricular":
              viewUrl = this.matricular(request);
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }
    
    public String matricular(HttpServletRequest request){
        try{
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
            if(usuario==null){
                throw new Exception();
            }
            model.setEstudiante(domainModel.estudianteFind(usuario.getCedula()));
            //this.verificar(model.getEstudiante(), request);
            return "";
        }
        catch(Exception e){
            System.out.println("no hay un usuario logeado! tirando excepcion...");
            return "/presentation/login/View2.jsp";
        }
    }
    
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        try{
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.setCurrent(domainModel.cursoFind(request.getParameter("nombreCurso")));
            model.setListaGrupos(model.getCurrent().getGrupoList());
            if(usuario != null){
                Estudiante e = domainModel.estudianteFind(usuario.getCedula());
                if(e == null){return "/presentation/Grupos/View.jsp";}
                model.setListaGrupos(this.listaFinal(e, request));
            }
            return "/presentation/Grupos/View.jsp";
        }catch(Exception ex){
            return "";
        }
    }
    
    // Elimina los grupos en los que ya el estudiante esta matriculado
    public List<Grupo> listaFinal(Estudiante est, HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        List<Grupo> listaFin =  model.getListaGrupos();
        for(Matricula m : est.getHistorial()){
            String grupo = m.getIdGrupo();
            for(Grupo a : listaFin){
                if(a.getId().equals(grupo)){
                    listaFin.remove(a);
                    break;
                }
            }
        }
        return listaFin;
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
