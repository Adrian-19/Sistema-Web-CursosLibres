package cursosLibres.logic;

<<<<<<< HEAD
import cursosLibres.data.CursoDao;
import cursosLibres.data.GrupoDao;
import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;
=======
import cursosLibres.data.EstudianteDao;
import cursosLibres.data.GrupoDao;
import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;
import cursosLibres.data.MatriculaDao;
import java.util.HashMap;
>>>>>>> e9f95ae02a2539b31b93a9d3298153fea50c845e
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
<<<<<<< HEAD
    
    //* Cursos y Grupos 
    private CursoDao cursoDao; 
    private GrupoDao grupoDao; 
    

    public Service(){
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
        
        //cursos y grupos 
        cursoDao = new CursoDao(); 
        grupoDao = new GrupoDao(); 
 
=======
    private GrupoDao grupoDao;
    private MatriculaDao matriculaDao;
    private EstudianteDao estudianteDao;
    
    public Service(){
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
        grupoDao = new GrupoDao();
        matriculaDao = new MatriculaDao();
        estudianteDao = new EstudianteDao();
>>>>>>> e9f95ae02a2539b31b93a9d3298153fea50c845e
    }

    // ------------ USUARIO ------------- 
    public void add(Usuario u) throws Exception{
        usuarioDao.create(u);
    }
    
<<<<<<< HEAD
    // ------------ CURSOS ------------- 
    public List<Curso> getListaCursos() {
       return cursoDao.findAll();   
    }
    
    
    // ------------ GRUPOS ------------- 
    public boolean existeGrupo(){
        
        return true; 
    }
=======
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
    
    // ------------ CURSOS -------------
    
    public Curso get(Grupo g) throws Exception{
        return new Curso();
    }
    
    // ---------- MATRICULAS -------------
    
    public List<Matricula> findByGrupo(Grupo g){
        return matriculaDao.findByGrupo(g.getId());
    }
    
>>>>>>> e9f95ae02a2539b31b93a9d3298153fea50c845e
}