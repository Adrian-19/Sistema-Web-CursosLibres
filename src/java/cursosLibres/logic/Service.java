package cursosLibres.logic;

import cursosLibres.data.CursoDao;
import cursosLibres.data.GrupoDao;
import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;
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
    

    public Service(){
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
        
        //cursos y grupos 
        cursoDao = new CursoDao(); 
        grupoDao = new GrupoDao(); 
 
    }

    // ------------ USUARIO ------------- 
    public void add(Usuario u) throws Exception{
        usuarioDao.create(u);
    }
    
    // ------------ CURSOS ------------- 
    public List<Curso> getListaCursos() {
       return cursoDao.findAll();   
    }
    
    
    // ------------ GRUPOS ------------- 
    public boolean existeGrupo(){
        
        return true; 
    }
}