/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.registrarCursos;

import cursosLibres.logic.Curso;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ESCINF
 */

@WebServlet(name = "ControllerRegCursos", urlPatterns = {"/presentation/RegistrarCursos/show", "/presentation/RegistrarCursos/register", "/presentation/RegistrarCursos/image"})
@MultipartConfig(location="C:/AAA/images")


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
        
        String viewUrl = "";
        //la página de guardar un nuevo grupo tiene como acciones guardar y mostrar *
        switch (request.getServletPath()) {
             case "/presentation/RegistrarCursos/show": 
                viewUrl = this.show(request); //se llama al método show para mostrar
                break;
             case "/presentation/RegistrarCursos/register" :
                viewUrl = this.register(request); 
                break; 
             case "/presentation/RegistrarCursos/image": 
                 viewUrl = this.image(request, response); 
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
        return this.showAction(request);
    }

    private String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model"); 
        model.getCurrentCurso().setCosto(0);
        model.getCurrentCurso().setEstado("");
        model.getCurrentCurso().setId("");
        model.getCurrentCurso().setGrupoList(null);
        model.getCurrentCurso().setLogo("");
        model.getCurrentCurso().setNombre("");
        model.getCurrentCurso().setTematica("");
        
        //
        Curso curso = new Curso();
        request.setAttribute("curso", curso);
        
        return "/presentation/RegistrarCursos/View.jsp"; 
    }

    
    //** Desarrollo de registrar curso:
    
    private String register(HttpServletRequest request) {
       try {
           Map<String, String> errores = this.validarRegistro(request); 
           if(errores.isEmpty()){
               this.updateModelRegister(request); 
               return this.registerAction(request); 
           } else{
               request.setAttribute("errores", errores);
               return "/presentation/RegistrarCursos/show"; 
           }
       }catch(Exception e){
           return "/presentation/Error.jsp";
       }
        
    }

    private Map<String, String> validarRegistro(HttpServletRequest request) {
        
        Map<String, String> errores = new HashMap<>();
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        
        //Validación nombre
        if(request.getParameter("nombreCurso").isEmpty()){
            errores.put("nombreCurso", "Nombre del curso vacío"); 
        }
        //Validación temática
        if(request.getParameter("inputTematica").isEmpty()){
            errores.put("inputTematica", "Espacio vacío"); 
        }
        //Validación costo
        if(request.getParameter("inputCosto").isEmpty()){
            errores.put("inputCosto", "Espacio vacío"); 
        }
        //Validación estado
        if(request.getParameter("estado").isEmpty()){
            errores.put("estado", "Espacio vacío"); 
        }
        return errores;
    }

    private void updateModelRegister(HttpServletRequest request) throws IOException, ServletException {
        Model model = (Model) request.getAttribute("model");

        model.getCurrentCurso().setNombre(request.getParameter("nombreCurso"));
        model.getCurrentCurso().setTematica(request.getParameter("inputTematica")); 
        model.getCurrentCurso().setCosto(Integer.parseInt(request.getParameter("inputCosto")));
        model.getCurrentCurso().setEstado(request.getParameter("estado"));
        
    }

    private String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance(); 
        
        try {
            String nombre = request.getParameter("nombreCurso"); 
            String tematica = request.getParameter("inputTematica"); 
            int costo = Integer.parseInt(request.getParameter("inputCosto")); 
            String estado = request.getParameter("estado"); 

            Curso c = new Curso();
            c.setNombre(nombre);
            c.setCosto(costo);
            c.setTematica(tematica);
            c.setEstado(estado);
            
            service.addCurso(c); 

            final Part image; 
            image = request.getPart("logoFile"); 
            image.write(service.getCursoNom(c.getNombre()).getId()); //nombre del logo = id de la BD
            
            
            return "/presentation/RegistrarCursos/show"; 
            
        } catch (Exception e){
            return "/presentation/Error.jsp"; 
        }
        
    }

    private String image(HttpServletRequest request, HttpServletResponse response) {
        try {
            cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
            
            String codigo = request.getParameter("cursoId");
            
//            //crear el directorio
            File directorio = new File("C:/AAA/images");
            if (!directorio.exists()) {
                directorio.mkdirs(); 
            } 
//            // then ... crear el path 
            Path path = FileSystems.getDefault().getPath("C:/AAA/images", codigo);
            try (OutputStream out = response.getOutputStream()) {
                Files.copy(path, out);
                out.flush();
            } catch (IOException e) {
                // handle exception
            }            
            
            return null;
 
        } catch (Exception ex) {
             return null;
        }
    }

}
