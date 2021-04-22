/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.teacherRegistration;

import cursosLibres.logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
 * @author jsanchez
 */
@WebServlet(name = "teacherRegistrationControl", urlPatterns = {"/presentation/teacherRegistration/show","/presentation/teacherRegistration/register"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
            case "/presentation/teacherRegistration/register":
                viewUrl = this.register(request);
                break;
            case "/presentation/teacherRegistration/show":
                viewUrl = this.showRegister(request);
                break;

        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }


    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/index.jsp";
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

    private String register(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validarRegistro(request);
            if (errores.isEmpty()) {
                this.updateModelRegister(request);
                return this.registerAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/teacherRegistration/View.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }

    }
//
    Map<String, String> validarRegistro(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedulaProFld").isEmpty()) {
            errores.put("cedulaProFld", "Cedula requerida");
        }
        if (request.getParameter("claveProFld").isEmpty()) {
            errores.put("claveProFld", "Clave requerida");
        }
        if (request.getParameter("correoProFld").isEmpty()) {
            errores.put("correoProFld", "Correo requerida");
        }
        if (request.getParameter("telefonoProFld").isEmpty()) {
            errores.put("telefonoProFld", "Telefono requerida");
        }
//        if (request.getParameter("especProFld").isEmpty()) {
//            errores.put("especProFld", "Especialidad requerida");
//        }

        return errores;
    }
        void updateModelRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getProfesor().setCedula(request.getParameter("cedulaProFld"));
        model.getProfesor().setClave(request.getParameter("claveProFld"));
        model.getProfesor().setTelefono(request.getParameter("telefonoProFld"));
        model.getProfesor().setCorreo(request.getParameter("correoProFld"));
    }

    private String registerAction(HttpServletRequest request) {
   
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        HttpSession session = request.getSession(true);
        try {

            if(!domainModel.existeUsuario(model.getProfesor().getCedula())){
            String cedula =   model.getProfesor().getCedula();
            String telefono = model.getProfesor().getTelefono();
            String correo = model.getProfesor().getCorreo();
            String clave = model.getProfesor().getClave(); 
            Usuario nuevo = new Usuario(cedula,clave,1,correo,telefono);
            domainModel.agregarUsuario(nuevo);
            List<Usuario> list = domainModel.teachersFind();
            model.setUsuarios(list);
            session.setAttribute("profesor", domainModel.usuarioFind(cedula,clave));
            return "/presentation/teacherRegistration/show";
            }else{            
            List<Usuario> list = domainModel.teachersFind();
            model.setUsuarios(list);
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaProFld", "Usuario ya existe ");
            return "/presentation/teacherRegistration/View.jsp";
            }
            
        } catch (Exception ex) {

            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaProFld", "Usuario o clave incorrectos");
            errores.put("claveProFld", "Usuario o clave incorrectos");
            return "/presentation/Error.jsp";
        }
    }
    public String showRegister(HttpServletRequest request) {
        return this.showActionRegister(request);
    }

    public String showActionRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        try {
            List<Usuario> list = domainModel.teachersFind();
            model.setUsuarios(list);
            model.getProfesor().setCedula("");
            model.getProfesor().setClave("");
            model.getProfesor().setCorreo("");
            model.getProfesor().setTelefono("");
        
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/presentation/teacherRegistration/View.jsp";
    }

}
