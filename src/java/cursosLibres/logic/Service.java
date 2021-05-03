package cursosLibres.logic;
import cursosLibres.data.CursoDao;
import cursosLibres.data.EstudianteDao;
import cursosLibres.data.GrupoDao;
import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;
import cursosLibres.data.MatriculaDao;
import java.sql.SQLException;
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

    public Service(){

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


    public Curso getCurso(String codigo) throws Exception{
        return cursoDao.read(codigo);
    }
    
    public boolean existeCurso(String stringBusquedaNombre) throws Exception {
        if (cursoDao.read(stringBusquedaNombre) != null) {
            return true;

        } else {
            return false;
        }        
    }
    
    public Curso getCursoNom(String nom) throws Exception {
       return cursoDao.findByNombre(nom); 
      
    }
    
    
    public List<Curso> getLikeCursos(String nom) throws SQLException {
        return cursoDao.getLikeCursos(nom);
    }
    
    public void addCurso(Curso c) throws Exception {
        cursoDao.create(c);
    }

    // ------------ PROFESORES -------------
    public Profesor get(Usuario u) throws Exception {
        return profesorDao.read(u.getCedula());
    }
    


    public void addProfesor(Profesor p) throws Exception {
        profesorDao.create(p);
    }

    public List<Profesor> getListaProfesores() {
        return profesorDao.findAll();

    }

    public Profesor readProfesor (String id) throws Exception{
        return profesorDao.read(id); 
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
    public void addGrupo(Grupo g, Curso c) throws Exception{
        grupoDao.create(g, c);
    }
    public List<Grupo> getGruposByCurso(Curso c) throws Exception{
        return grupoDao.findByCurso(c);
    }


    // ---------- MATRICULAS -------------
    public List<Matricula> findByGrupo(Grupo g) {
       return matriculaDao.findByGrupo(g.getId());
    }
    
    public List<Matricula> findByEstudiante(String cedula) {
        return matriculaDao.findByEstudiante(cedula);
    }



    // ---------- MATRICULAS -------------
    public void add(Matricula m) throws Exception{
        matriculaDao.create(m);
    }

    
    public void updateNota(Matricula m) throws Exception{
        matriculaDao.updateNota(m);
    }
    
    public List<Matricula> findByEstudiante(Estudiante e){
        return matriculaDao.findByEstudiante(e);
    }


}
