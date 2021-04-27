/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.gruposDeProfesor;

import cursosLibres.logic.Profesor;
import cursosLibres.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControllerGruposDeProfesor", urlPatterns = {"/presentation/GruposDeProfesor/show"})
public class Controller extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/GruposDeProfesor/show":
              viewUrl = this.show(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        // En login action de Login se guarda el Usuario logeado en en un HttpSession.
        HttpSession session = request.getSession(true);
        // Se obtiene el usuario guardado en la sesion y se almacena en "usuario"
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Profesor profesor;
        try {
            // Busca el profesor de acuerdo con el usuario logeado
            profesor = domainModel.profesorFind(usuario);
        } catch (Exception ex) {
            profesor=null;
        }
        try {
            // Setea los grupos asociados con ese profesor.
            // Osea, buscar en la tabla de grupos los que tienen el
            // id del profesor seleccionado.
            // select * from Grupos where idProfesor = <profesor.getCedula()>;
            
            model.setGrupos(domainModel.gruposFind(profesor));
            return "/presentation/GruposDeProfesor/View.jsp";
        } catch (Exception ex) {
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
