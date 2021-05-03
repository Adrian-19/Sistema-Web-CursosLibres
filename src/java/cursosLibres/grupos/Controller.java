/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.grupos;

import cursosLibres.logic.Grupo;
import cursosLibres.logic.Matricula;
import cursosLibres.logic.Usuario;
import java.io.IOException;
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
            if(usuario==null){
                return "/presentation/login/show";
            }
            cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
            
            model.setEstudiante(service.getEstudiante(usuario.getCedula()));
            String grupoId = request.getParameter("grupoID");
            Matricula m = new Matricula();
            m.setIdEstudiante(model.getEstudiante().getId());
            m.setIdGrupo(grupoId);
            service.add(m);
            String URL = "/presentation/Grupos/show?cursoId="+request.getParameter("cursoId");
            System.out.println(URL);
            return URL;
        }
        catch(Exception e){
            return "";
        }
    }
    
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        try{
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.setCurrent(service.getCurso(request.getParameter("cursoId")));
            List<Grupo> lista = service.getGruposByCurso(model.getCurrent());
            
            if(usuario != null){
                // si usuario es estudiante
                if(usuario.getTipo() == 2){
                    model.setEstudiante(service.getEstudiante(usuario.getCedula()));
                    List<Matricula> matriculas = service.findByEstudiante(model.getEstudiante());
                    for(Matricula m : matriculas){
                        for(Grupo g : lista){
                            if(m.getIdGrupo().equals(g.getId())){
                                model.setMatriculado(1);
                                break;
                            }
                        } 
                    }
                }
                else{
                    model.setMatriculado(1);
                }
            }
            model.setListaGrupos(lista);
            return "/presentation/Grupos/View.jsp";
        }catch(Exception ex){
            return "";
        }
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
