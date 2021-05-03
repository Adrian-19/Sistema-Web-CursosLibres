/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.teacherRegistration;

import cursosLibres.logic.Usuario;
import cursosLibres.logic.Profesor;
import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(name = "teacherRegistrationControl", urlPatterns = {"/presentation/teacherRegistration/show", "/presentation/teacherRegistration/register", "/presentation/teacherRegistration/search"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/teacherRegistration/register":
                viewUrl = this.register(request);
                break;
            case "/presentation/teacherRegistration/show":
                viewUrl = this.showRegister(request);
                break;
            case "/presentation/teacherRegistration/search":
                viewUrl = this.search(request);
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
            errores.put("telefonoProFld", "Telefono requerido");
        }
        if (request.getParameter("nombreProFld").isEmpty()) {
            errores.put("nombreProFld", "Nombre requerido");
        }
        if (request.getParameter("especProFld").isEmpty()) {
            errores.put("especProFld", "Especialidad requerida");
        }

        return errores;
    }

    void updateModelRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getUprofesor().setCedula(request.getParameter("cedulaProFld"));
        model.getUprofesor().setClave(request.getParameter("claveProFld"));

        model.getProfesor().setId(request.getParameter("cedulaProFld"));
        model.getProfesor().setNombre(request.getParameter("nombreProFld"));
        String telefono =request.getParameter("telefonoProFld");
        telefono = telefono.replaceAll(" ","");
        telefono = telefono.replaceAll("-","");
        model.getProfesor().setTelefono(telefono);
        model.getProfesor().setEspecialidad(request.getParameter("especProFld"));
        model.getProfesor().setCorreo(request.getParameter("correoProFld"));

    }

    private String registerAction(HttpServletRequest request) {

        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        HttpSession session = request.getSession(true);

        String cedula = model.getUprofesor().getCedula();
        String clave = model.getUprofesor().getClave();
        Usuario nuevo = new Usuario(cedula, clave, 1);

        String telefono = model.getProfesor().getTelefono();
        String nombre = model.getProfesor().getNombre();
        String espec = model.getProfesor().getEspecialidad();
        String correo = model.getProfesor().getCorreo();
        Profesor nueProfesor = new Profesor(cedula, nombre, telefono, espec, correo);

        try {
            service.add(nuevo, correo);
            service.addProfesor(nueProfesor);


        } catch (Exception ex) {
            List<Profesor> list = (List<Profesor>) session.getAttribute("profesores");
            model.setProfesores(list);
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaProFld", "Este Profesor ya existe ");
            return "/presentation/teacherRegistration/View.jsp";
        }
        
        List<Profesor> list = (List<Profesor>) session.getAttribute("profesores");
        list.add(nueProfesor);
        session.setAttribute("profesores",list);
        model.setProfesores(list);
          
        return "/presentation/teacherRegistration/show";
    }

    public String showRegister(HttpServletRequest request) {
        return this.showActionRegister(request);
    }

    public String showActionRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        
        HttpSession session = request.getSession(true);
        List<Profesor> list = service.getListaProfesores();
        for(Profesor p: list){
            try {
                Usuario u = service.getUsuario(Integer.parseInt(p.getId()));
                p.setCorreo(u.getCorreo());
            } catch (Exception ex) {
              
            }
        }
        session.setAttribute("profesores",list);
  
        model.setProfesores(list);
        model.getUprofesor().setCedula("");
        model.getUprofesor().setClave("");
        model.getProfesor().setId("");
        model.getProfesor().setNombre("");
        model.getProfesor().setTelefono("");
        model.getProfesor().setEspecialidad("");
        model.getProfesor().setCorreo("");

        return "/presentation/teacherRegistration/View.jsp";
    }

    private String search(HttpServletRequest request) {
        try {

            this.updateModelSearch(request);
            return this.searchAction(request);

        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }

    }

    void updateModelSearch(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.setCodigoBusqueda(request.getParameter("busProFld"));
    }

    private String searchAction(HttpServletRequest request) {

        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
         HttpSession session = request.getSession(true);
        try {
            Profesor profesor = service.getProfesor(model.getCodigoBusqueda());
            List<Profesor> list = new ArrayList();
            Usuario u = service.getUsuario(Integer.parseInt(profesor.getId()));
                profesor.setCorreo(u.getCorreo());
            
            list.add(profesor);
            model.setProfesores(list);
            model.getUprofesor().setCedula("");
            model.getUprofesor().setClave("");
            return "/presentation/teacherRegistration/View.jsp";

        } catch (Exception ex) {
            List<Profesor> list = (List<Profesor>) session.getAttribute("profesores");
            model.setProfesores(list);
            
            model.getUprofesor().setCedula("");
            model.getUprofesor().setClave("");
            return "/presentation/teacherRegistration/View.jsp";
        }
    }

}
