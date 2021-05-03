/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.verCursos;


import cursosLibres.logic.Curso;
import cursosLibres.logic.Usuario;
import cursosLibres.verCursos.Model; 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;



/**
 *
 * @author DS
 */
@WebServlet(name = "ControllerC", urlPatterns = {"/presentation/VerCursos/buscar", "/presentation/VerCursos/show" })
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
    private boolean ban = false; 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl = "";

        switch (request.getServletPath()) {
             case "/presentation/VerCursos/show": 
                viewUrl = this.show(request); //se llama al método show para mostrar
                break;
             case "/presentation/VerCursos/buscar":
                 viewUrl = this.search(request); //se llama al método show para mostrar
                break;
                 
                 
        }
        
        request.getRequestDispatcher(viewUrl).forward( request, response); 

        
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

    private String show(HttpServletRequest request) {
       return this.showAction(request); //llama al método de abajo

    }
    
    private String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model"); 
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance(); 

        try{
            List<Curso> list = service.getListaCursos(); 
            model.setListaCursos(list);             

            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.setUsuario(usuario);
            

        } catch(Exception e){
            return "/presentation/Error.jsp";
        }
        
        return "/presentation/VerCursos/View.jsp";
    }

    private String search(HttpServletRequest request) {
        
        try {
            this.updateModelSearch(request); 
            return this.searchAction(request); 
              
        } catch (Exception e){
            return "/presentation/Error.jsp"; 
        }
    }

    private void updateModelSearch(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model"); 
        model.setStringBusqueda(request.getParameter("busqCursos")); 
        System.out.println(model.getStringBusqueda()); //
    }
    
    private String searchAction(HttpServletRequest request){
        
        Model model = (Model) request.getAttribute("model"); 
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance(); 
        

        try{
            String nom = model.getStringBusqueda(); 
            List<Curso> busquedaCursos =  service.getLikeCursos(nom); 
            model.setListaCursos(busquedaCursos);           

            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.setUsuario(usuario);

        } catch(Exception e){
            return "/presentation/Error.jsp";
        }
        
        return "/presentation/VerCursos/View.jsp";        
        
    }
    
    


}
