package cursosLibres.logic;

import cursosLibres.data.ProfesorDao;
import cursosLibres.data.UsuarioDao;

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

    public Service(){
        usuarioDao = new UsuarioDao();
        profesorDao = new ProfesorDao();
    }

    // ------------ USUARIO ------------- 
    public void add(Usuario u) throws Exception{
        usuarioDao.create(u);
    }
}