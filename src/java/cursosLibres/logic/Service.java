package cursosLibres.logic;

import cursosLibres.data.CursoDao;
import cursosLibres.data.EstudianteDao;
import cursosLibres.data.GrupoDao;
import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;
import cursosLibres.data.MatriculaDao;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adria
 */
public class Service {

    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    private UsuarioDao usuarioDao;
    private ProfesorDao profesorDao;

    //* Cursos y Grupos 
    private CursoDao cursoDao;
    private GrupoDao grupoDao;
    private MatriculaDao matriculaDao;
    private EstudianteDao estudianteDao;

    public Service() {

        cursoDao = new CursoDao();
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
        grupoDao = new GrupoDao();
        matriculaDao = new MatriculaDao();
        estudianteDao = new EstudianteDao();
    }

    // ------------ USUARIO ------------- 
    public void add(Usuario u, String c) throws Exception {
        usuarioDao.create(u, c);
    }
//    public int numID(String correo) throws Exception{
//    return usuarioDao.numero_cuenta(correo);
//    }

    public Usuario getUsuario(int id) throws Exception {
        return usuarioDao.read(id);

    }

    // ------------ CURSOS ------------- 
    public List<Curso> getListaCursos() {
        return cursoDao.findAll();
    }
    public Curso getCurso(String id) throws Exception{
    return cursoDao.read(id);
    
    }

    // ------------ PROFESORES -------------
    public Profesor get(Usuario u) throws Exception {
        return profesorDao.read(u.getCedula());
    }
    
    public Profesor getProfesor(String cedula) throws Exception {
        return profesorDao.read(cedula);
    }

    public void addProfesor(Profesor p) throws Exception {
        profesorDao.create(p);
    }

    public List<Profesor> getListaProfesores() {
        return profesorDao.findAll();

    }
    // ------------ ESTUDIANTES -------------

    public void addEstudiante(Estudiante e) throws Exception {
        estudianteDao.create(e);
    }

    public Estudiante getEstudiante(String id) throws Exception {
        return estudianteDao.read(id);
    }

//    public int numeroCuentaEst(String num) throws Exception{
//      return estudianteDao.numero_cuenta(num);
//    
//    }
    // ------------ GRUPOS -------------
    public HashMap search(Profesor p) {
        return grupoDao.findByProfesor(p);
    }

    public Grupo getGrupo(String id) throws Exception {
        return grupoDao.read(id);
    }

    public boolean existeGrupo() {

        return true;
    }

    // ---------- MATRICULAS -------------
    public List<Matricula> findByGrupo(Grupo g) {
       return matriculaDao.findByGrupo(g.getId());
    }
    
    public List<Matricula> findByEstudiante(String cedula) {
        return matriculaDao.findByEstudiante(cedula);
    }

}
