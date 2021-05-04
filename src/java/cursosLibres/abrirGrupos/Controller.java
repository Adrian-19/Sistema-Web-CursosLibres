/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cursosLibres.abrirGrupos; 

import cursosLibres.logic.Curso;
import cursosLibres.logic.Grupo;
import cursosLibres.logic.Profesor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DS
 */

@WebServlet(name = "Controller", urlPatterns = {"/presentation/AbrirGrupos/show", "/presentation/AbrirGrupos/register"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.

     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("model", new Model());
        
        String viewUrl = "";
        
        switch (request.getServletPath()) {
             case "/presentation/AbrirGrupos/show": 
                viewUrl = this.show(request); //se llama al método show para mostrar
                break;
            case "/presentation/AbrirGrupos/register": 
                viewUrl = this.guardarGrupo(request); //para guardar un nuevo grupo
                break;  
        }
        
        request.getRequestDispatcher(viewUrl).forward(request, response); 

    
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

    /*
    * Desarrollo de la acción "show"
    */
    public String show(HttpServletRequest request) {
        return this.showAction(request); //llama al método de abajo
    }
       
    public String showAction(HttpServletRequest request) { //muestra todo vacío
        Model model = (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true); // sesión 
        
        model.getCurrentGrupo().setId("");
        model.getCurrentGrupo().setHorario("");
        model.getCurrentGrupo().setProfesor(null); 
        model.getCurrentGrupo().setEstudianteList(null);
        
        model.setIdCurso(request.getParameter("cursoId"));
        session.setAttribute("cursoId", model.getIdCurso());
        
  
        return "/presentation/AbrirGrupos/View.jsp";
    }
     
    
    /*
    * Desarrollo de la acción "guardarGrupo"
    * registra un nuevo grupo 
    */
    private String guardarGrupo(HttpServletRequest request) {
        try{
            Map<String, String> errores = this.validarRegistro(request); 
            if(errores.isEmpty()) {
                this.updateModelRegister(request); 
                return this.registerAction(request);  
            } else {
                request.setAttribute("errores", errores); 
                return "/presentation/AbrirGrupos/View.jsp"; 
            }
        } catch (Exception e) {
            return "/presentation/AbrirGrupos/show"; 
        }
 
    }
    
   
     Map<String, String> validarRegistro(HttpServletRequest request) throws Exception {
         Map<String, String> errores = new HashMap<>();
         cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
         HttpSession session = request.getSession(true); // sesión 

         //Validación para el profesor:
            //** Si el espacio está vacío
         if (request.getParameter("idProfesor").isEmpty()) {
            errores.put("idProfesor", "Dato requerido"); 
        }
            //** si el profesor no existe
        if(service.readProfesor(request.getParameter("idProfesor")) == null){
            errores.put("idProfesor", "El profesor no está registrado"); 
        }
        
//        Validación para la hora: 
//            ** validar espacios vacíos
        if (request.getParameter("inputHorarioInic").isEmpty()) {
            errores.put("errorHora", "Dato requerido");
        }
        if (request.getParameter("inputHorarioFin").isEmpty()) {
            errores.put("errorHora", "Dato requerido");  
        }

        //Validación para el id del curso 
        if(service.getCurso((String) session.getAttribute("cursoId")) == null){
            errores.put(request.getParameter("cursoId"), "El curso no existe"); // revisar, este se pasa por método get
        }

        return errores; 
         
     }
     
     
    void updateModelRegister(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model"); 
        
        //ID = auto increment
        
        //Horario
        String inic = request.getParameter("inputHorarioInic"); 
        String fin = request.getParameter("inputHorarioFin"); 
        model.getCurrentGrupo().setHorario(inic + " - " + fin); //un solo string
        
        //Profesor. Solo actualiza la cédula 
        model.getCurrentGrupo().getProfesor().setId(request.getParameter("idProfesor"));
        
        //lista de estudiantes - se debe de actualizar ? Se actualiza cada vez que se inscribe alguien
        
        //codigo ? 
        model.setIdCurso(request.getParameter("cursoId"));
        
    }

    
    private String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance(); 
        HttpSession session = request.getSession(true); // sesión 
        

        String idCurso = (String) session.getAttribute("cursoId"); 

        
        try {
                //Crear horario: 
                String inic = request.getParameter("inputHorarioInic"); 
                String fin = request.getParameter("inputHorarioFin"); 
                String horario = inic + " - " + fin; 
                
                //Buscar profesor en la base de datos para gardarlo
                Profesor prof = service.readProfesor(request.getParameter("idProfesor")); 
                
                // Guardar en la base de datos:
                //Crear grupo
                Grupo g = new Grupo(); 
                g.setHorario(horario);
                g.setProfesor(prof);
                g.setEstudianteList(new ArrayList<>());  
                //id ?? 

                Curso c = service.getCurso(idCurso); 
                
                service.addGrupo(g, c);
                

                return "/presentation/AbrirGrupos/View.jsp"; 
            
            
        } catch (Exception e){
            return "/presentation/Error.jsp"; 
        }

    }

}
