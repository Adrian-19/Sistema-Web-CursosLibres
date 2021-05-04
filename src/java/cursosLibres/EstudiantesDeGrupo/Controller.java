/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.EstudiantesDeGrupo;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Matricula;
import cursosLibres.logic.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "EstudiantesDeGrupoController", urlPatterns = {"/presentation/EstudiantesDeGrupo/show", "/presentation/EstudiantesDeGrupo/calificar"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model());
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/EstudiantesDeGrupo/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/EstudiantesDeGrupo/calificar":
              viewUrl = this.calificar(request);
              break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        try{
            model.setGrupo(service.getGrupo(request.getParameter("grupoID")));
            List<Matricula> matriculas = service.findByGrupo(model.getGrupo());
            model.setListaMatriculas(matriculas);
            List<Estudiante> estudiantes = new ArrayList<>();
            for(Matricula m : matriculas){
                Estudiante e = service.getEstudiante(m.getIdEstudiante());
                Usuario u = service.getUsuario(Integer.valueOf(e.getId()));
                e.setCorreo(u.getCorreo());
                estudiantes.add(e);
            }
            model.setEstudiantes(estudiantes);
            return "/presentation/EstudiantesDeGrupo/View.jsp";
        }catch(Exception ex){
            return "";
        }
    }
    
    public String calificar(HttpServletRequest request){
        try{
            Map<String, String> errores = this.validarCalificacion(request);
            if(errores.isEmpty()){
                this.updateModel(request);
                return this.calificarAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/EstudiantesDeGrupo/View.jsp";
            }
        }catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }
    
    Map<String, String> validarCalificacion(HttpServletRequest request){
        Map<String, String> errores = new HashMap<>();
        if(request.getParameter("calificarFld").isEmpty()){
            errores.put("calificarFld", "Calificacion requerida");
            return errores;
        }
        double nota = Double.valueOf(request.getParameter("calificarFld"));
        if(nota<0){
            errores.put("calificarFld", "Nota invalida");
        }
        return errores;
    }
    
    void updateModel(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        
        String estudianteID = request.getParameter("estudianteID");
        String grupoID = request.getParameter("grupoID");
        try{
            model.setGrupo(service.getGrupo(grupoID));
            List<Matricula> matriculas = service.findByGrupo(model.getGrupo());
            model.setListaMatriculas(matriculas);
            List<Estudiante> estudiantes = new ArrayList<>();
            for(Matricula m : matriculas){
                Estudiante e = service.getEstudiante(m.getIdEstudiante());
                Usuario u = service.getUsuario(Integer.valueOf(e.getId()));
                e.setCorreo(u.getCorreo());
                estudiantes.add(e);
            }
            model.setEstudiantes(estudiantes);
            for(Matricula m : model.getListaMatriculas()){
                if(m.getIdEstudiante().equals(estudianteID)){
                    if(m.getIdGrupo().equals(grupoID)) {
                        m.setNota(Double.valueOf(request.getParameter("calificarFld")));
                        model.setMatricula(m);
                        break;
                    } 
                }
            }
        }catch (Exception e){
            
        }
    }
    
    private String calificarAction(HttpServletRequest request){
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        Model model = (Model) request.getAttribute("model");
        try{
            service.updateNota(model.getMatricula());
            return "/presentation/EstudiantesDeGrupo/View.jsp";
        }catch (Exception e){
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
