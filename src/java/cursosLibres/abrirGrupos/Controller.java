/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cursosLibres.abrirGrupos; 

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
        model.getCurrentGrupo().setId("");
        model.getCurrentGrupo().setHorario("");
        model.getCurrentGrupo().setProfesor(null); 
        model.getCurrentGrupo().setEstudianteList(null);
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
            return "/presentation/Error.jsp"; //??
        }
 
    }
    
   
     Map<String, String> validarRegistro(HttpServletRequest request) {
         Map<String, String> errores = new HashMap<>();

         if (request.getParameter("idProfesor").isEmpty()) {
            errores.put("idProfesor", "Dato requerido"); 
        }
         
        if (request.getParameter("inputHorarioInic").isEmpty()) {
            errores.put("errorHora", "Dato requerido"); //como poner esto para ints? 
        }
        if (request.getParameter("inputHorarioFin").isEmpty()) {
            errores.put("errorHora", "Dato requerido"); //como poner esto para ints? 
        }
        
        //calculando la hora del curso
        int horaInic = Integer.parseInt(request.getParameter("inputHorarioInic")) ; 
        int horaFin = Integer.parseInt(request.getParameter("inputHorarioFin")) ; 
       
        if(horaFin <= horaInic){
            errores.put("errorHora", "La hora del curso no está correcta.");         }
        //
        
        if(request.getParameter("nombreCurso").isEmpty() || request.getParameter("nombreCurso").equals("Seleccionar")){
            errores.put("nombreCurso", "Seleccionar"); 
        }
        
        return errores; 
         
     }
     
     
    void updateModelRegister(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model"); 
        
        //ID
        // en la base de datos?
        
        //Hora
        String inic = request.getParameter("inputHorarioInic"); 
        String fin = request.getParameter("inputHorarioFin"); 
        model.getCurrentGrupo().setHorario(inic + " - " + fin);
        
        //Profesor
        model.getCurrentGrupo().getProfesor().setId(request.getParameter("idProfesor"));
        
        //lista de estudiantes ?
        model.getCurrentGrupo().setEstudianteList(new ArrayList<>() );
        
    }

    
    private String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service domainModel = cursosLibres.logic.Service.instance(); 
        //cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        HttpSession session = request.getSession(true); // sesión 
        
        String id = "";
        
        try {
            //Programar: si no existe el grupo en ese curso, entonces agregarlo
            if(!domainModel.existeGrupo()){
                
            }
            
        } catch (Exception e){
            
        }
        
        
        return null;
    }

    

}
