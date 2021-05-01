package cursosLibres.logic;

<<<<<<< HEAD

=======
>>>>>>> 0261d0f6e30c5a8c526f3dc9eb3a2c32643ddae7
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
<<<<<<< HEAD

    //* Cursos y Grupos 
    private CursoDao cursoDao; 
    private GrupoDao grupoDao; 
    
=======
    
    //* Cursos y Grupos 
    private CursoDao cursoDao; 
    private GrupoDao grupoDao; 
>>>>>>> 0261d0f6e30c5a8c526f3dc9eb3a2c32643ddae7
    private MatriculaDao matriculaDao;
    private EstudianteDao estudianteDao;

    public Service(){
 
<<<<<<< HEAD
=======
        cursoDao = new CursoDao(); 
>>>>>>> 0261d0f6e30c5a8c526f3dc9eb3a2c32643ddae7
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
        grupoDao = new GrupoDao();
        matriculaDao = new MatriculaDao();
        estudianteDao = new EstudianteDao();
<<<<<<< HEAD
        cursoDao = new CursoDao(); 
        
=======
>>>>>>> 0261d0f6e30c5a8c526f3dc9eb3a2c32643ddae7
    }

    // ------------ USUARIO ------------- 
    public void add(Usuario u) throws Exception{
        usuarioDao.create(u);
    }
    
    // ------------ CURSOS ------------- 
    public List<Curso> getListaCursos() {
       return cursoDao.findAll();   
    }
    
<<<<<<< HEAD
   
    
=======
>>>>>>> 0261d0f6e30c5a8c526f3dc9eb3a2c32643ddae7
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
    
}