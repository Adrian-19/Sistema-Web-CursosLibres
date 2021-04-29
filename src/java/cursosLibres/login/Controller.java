/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.login;

import cursosLibres.logic.Usuario;
import cursosLibres.logic.Estudiante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "loginController", urlPatterns = {"/presentation/login/show", "/presentation/login/login", "/presentation/login/logout", "/presentation/login/register","/presentation/login/showRegister"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/login/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/login/login":
                viewUrl = this.login(request);
                break;
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
            case "/presentation/login/register":
                viewUrl = this.register(request);
                break;
            case "/presentation/login/showRegister":
                viewUrl = this.showRegister(request);
                break;

        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/login/View2.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()) {
            errores.put("cedulaFld", "Cedula requerida");
        }

        if (request.getParameter("claveFld").isEmpty()) {
            errores.put("claveFld", "Clave requerida");
        }
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().setClave(request.getParameter("claveFld"));
    }

    public String loginAction(HttpServletRequest request) {

        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        HttpSession session = request.getSession(true);
        try {
            Usuario real = domainModel.usuarioFind(model.getCurrent().getCedula(), model.getCurrent().getClave());
            System.out.println("Real: " + real.getCedula() + " | " + real.getClave());
            service.add(real);

            session.setAttribute("usuario", real);
//            String viewUrl = "";
//            switch (real.getTipo()) { // Para que es esto?
//                case 2:
//                    viewUrl = "/presentation/Index.jsp";
//                    break;
//                case 1:
//                    viewUrl = "/presentation/Index.jsp";
//                    break;
//                case 0:
//                    viewUrl = "/presentation/Index.jsp";
//                break;
//            }
            return "/presentation/VerCursos/View.jsp";
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Usuario o clave incorrectos");
            errores.put("claveFld", "Usuario o clave incorrectos");
            return "/presentation/login/View2.jsp";
        }

    }

    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/VerCursos/View.jsp";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        return "/presentation/login/View2.jsp";
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
                return "/presentation/login/viewRegister.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }

    }

    Map<String, String> validarRegistro(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()) {
            errores.put("cedulaFld", "Cedula requerida");
        }
        if (request.getParameter("claveFld").isEmpty()) {
            errores.put("claveFld", "Clave requerida");
        }
        if (request.getParameter("correoFld").isEmpty()) {
            errores.put("correoFld", "Correo requerido");
        }
        if (request.getParameter("telefonoFld").isEmpty()) {
            errores.put("telefonoFld", "Telefono requerido");
        }
        if (request.getParameter("nombreFld").isEmpty()) {
            errores.put("nombreFld", "Nombre requerido");
        }

        return errores;
    }
        void updateModelRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        model.getCurrent().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().setClave(request.getParameter("claveFld"));
        
        model.getEstudiante().setId(request.getParameter("cedulaFld"));
        model.getEstudiante().setCorreo(request.getParameter("correoFld"));
        model.getEstudiante().setNombre(request.getParameter("nombreFld"));
        model.getEstudiante().setTelefono(request.getParameter("telefonoFld"));
    }

    private String registerAction(HttpServletRequest request) {
   
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Model domainModel = cursosLibres.logic.Model.instance();//cambiar por service
        HttpSession session = request.getSession(true);
        try {
            if(!domainModel.existeUsuario(model.getCurrent().getCedula())){
            String cedula =   model.getCurrent().getCedula();
            String clave = model.getCurrent().getClave(); 
            Usuario nuevo = new Usuario(cedula,clave,2);
            String telefono = model.getEstudiante().getTelefono();
            String nombre = model.getEstudiante().getNombre();
            String correo = model.getEstudiante().getCorreo();
            Estudiante estudianteNue = new Estudiante(cedula,nombre,telefono,correo,new ArrayList<>());
            
            
            domainModel.agregarEstudiante(estudianteNue); //
            domainModel.agregarUsuario(nuevo);           //
            session.setAttribute("usuario", domainModel.usuarioFind(cedula,clave));
            return "/presentation/VerCursos/View.jsp";
            }else{
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Este Usuario ya existe ");
            return "/presentation/login/viewRegister.jsp";
            }
            
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Usuario o clave incorrectos");
            errores.put("claveFld", "Usuario o clave incorrectos");
            return "/presentation/login/viewRegister.jsp";
        }
    }
    public String showRegister(HttpServletRequest request) {
        return this.showActionRegister(request);
    }

    public String showActionRegister(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        return "/presentation/login/viewRegister.jsp";
    }

}

