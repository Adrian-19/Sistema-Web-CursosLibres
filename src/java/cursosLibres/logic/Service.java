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
    
    public boolean existeGrupo(){
        
        return true; 
    }

    
    
    // ---------- MATRICULAS -------------
    public List<Matricula> findByGrupo(Grupo g){
        return matriculaDao.findByGrupo(g.getId());
    }
    
    public void updateNota(Matricula m) throws Exception{
        matriculaDao.updateNota(m);
    }
}