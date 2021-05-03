/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.historial;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import cursosLibres.logic.Curso;
import cursosLibres.logic.Usuario;
import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import cursosLibres.logic.Matricula;
import java.awt.Font;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RecordsController", urlPatterns = {"/presentation/Historial/showRecord", "/presentation/Historial/pdf"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/Historial/showRecord":
                viewUrl = this.showRecord(request);
                
                break;
            case "/presentation/Historial/pdf":
                viewUrl = this.print(request, response);
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

    public String showRecord(HttpServletRequest request) {
        return this.showActionRecords(request);
    }

    public String showActionRecords(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        List<Matricula> matriculas = service.findByEstudiante(usuario.getCedula()); 
        
        for(Matricula m :matriculas ){
            try {
                Grupo g = service.getGrupo(m.getIdGrupo());
                String id = String.valueOf(g.getCodigoCurso());
                Curso c = service.getCurso(id);
                m.setIdCurso(c.getId());
                m.setNombreCurso(c.getNombre());
            } catch (Exception ex) {  
            }
        }
        
        Estudiante estudiante = new Estudiante();
        try {
            estudiante = service.getEstudiante(usuario.getCedula());
        } catch (Exception ex) {
        }
        
        estudiante.setCorreo(usuario.getCorreo());
        
        model.setEstudiante(estudiante);
        model.setHistorial(matriculas);
        session.setAttribute("matriculas", matriculas);

        return "/presentation/Historial/View.jsp";
    }

    private String print(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        cursosLibres.logic.Service service = cursosLibres.logic.Service.instance();
        
        Estudiante estudiante = new Estudiante();
        try {
            estudiante = service.getEstudiante(usuario.getCedula());
        } catch (Exception ex) {
        }
        
        estudiante.setCorreo(usuario.getCorreo());
        
        
        //Model model = (Model) request.getAttribute("model");
        
        

        try {
            List<Matricula> historial =(List<Matricula>) session.getAttribute("matriculas");

            Document document = new Document();

            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            Paragraph titulo = new Paragraph("                           Cursos Libres",
                    FontFactory.getFont("arial",
                            22,
                            Font.BOLD,
                            BaseColor.BLUE
                    )
            );
            document.add(titulo);
            titulo = new Paragraph("  ");
            document.add(titulo);
            titulo = new Paragraph("  ");
            document.add(titulo);
            
            titulo = new Paragraph("Datos del Estudiante:",
                    FontFactory.getFont("arial",
                            14,
                            Font.BOLD,
                            BaseColor.BLUE
                    )
            );
            document.add(titulo);
            titulo = new Paragraph("  ");
            document.add(titulo);

            titulo = new Paragraph("Nombre            :                    "+ estudiante.getNombre(),
                    FontFactory.getFont("arial",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            document.add(titulo);

            titulo = new Paragraph("ID                      :                    " + estudiante.getId(),
                    FontFactory.getFont("arial",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            document.add(titulo);

            titulo = new Paragraph("Telefono           :                    " + estudiante.getTelefono(),
                    FontFactory.getFont("arial",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            document.add(titulo);


            titulo = new Paragraph("Correo              :                    "+ estudiante.getCorreo(),
                    FontFactory.getFont("arial",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            document.add(titulo);

            titulo = new Paragraph("  ");
            document.add(titulo);
            titulo = new Paragraph("  ");
            document.add(titulo);
            
            titulo = new Paragraph("Historial Academico del " + LocalDate.now(),
                    FontFactory.getFont("arial",
                            14,
                            Font.BOLD,
                            BaseColor.BLUE
                    )
            );
            document.add(titulo);
            titulo = new Paragraph("  ");
            document.add(titulo);

            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(3);

            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("ID");
            table.addCell("Nombre");
            table.addCell("Nota");

            for (Matricula m : historial) {
                table.addCell(m.getIdCurso());
                table.addCell(m.getNombreCurso());
                table.addCell(String.valueOf(m.getNota()));
            }
            // Agregamos la tabla al documento            
            document.add(table);

            document.close();
            
            session.removeAttribute("matriculas");
            session.invalidate();

            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "inline");
            return null;

        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }

    }

}
