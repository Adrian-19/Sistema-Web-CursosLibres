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
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
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
    public void add(Usuario u) throws Exception{
        usuarioDao.create(u);
    }
    
    // ------------ CURSOS ------------- 
    public List<Curso> getListaCursos() {
       return cursoDao.findAll();   
    }
    public Curso getCurso(String codigo) throws Exception{
        return cursoDao.read(codigo);
    }
    
    public boolean existeCurso(String stringBusqueda) throws Exception {
        if (cursoDao.read(stringBusqueda) != null) {
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
    // ------------ PROFESORES -------------
    
    public Profesor get(Usuario u) throws Exception{
        return profesorDao.read(u.getCedula());
    }
    
    // ------------ ESTUDIANTES -------------
    
    public Estudiante getEstudiante(String id) throws Exception{
        return estudianteDao.read(id);
    }
    // ------------ GRUPOS -------------
    
    public HashMap search(Profesor p){
        return grupoDao.findByProfesor(p);
    }
    
    public Grupo getGrupo(String id) throws Exception{
        return grupoDao.read(id);
    }
    
    public List<Grupo> getGruposByCurso(Curso c) throws Exception{
        return grupoDao.findByCurso(c);
    }
    
    
    // ---------- MATRICULAS -------------
    public void add(Matricula m) throws Exception{
        matriculaDao.create(m);
    }
    
    public List<Matricula> findByGrupo(Grupo g){
        return matriculaDao.findByGrupo(g.getId());
    }
    
    public void updateNota(Matricula m) throws Exception{
        matriculaDao.updateNota(m);
    }
    
    public List<Matricula> findByEstudiante(Estudiante e){
        return matriculaDao.findByEstudiante(e);
    }
}