/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emanuelle
 */
public class Model {

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    HashMap<String, Usuario> usuarios;
    HashMap<String, List<String>> favoritas;

    private Model() {
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111", "111", 0, "juan.@gmail.com", "123-123"));
        usuarios.put("222", new Usuario("222", "222", 1, "maria.@gmail.com", "123-321"));
        usuarios.put("333", new Usuario("333", "333", 2, "luis.@gmail.com", "123-444"));

        //HashMap<String,List<String>> favoritas;
        favoritas = new HashMap();
        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
        favoritas.put("222", Arrays.asList(new String[]{"1-111-11", "1-222-22"}));
    }
    
    public void agregarUsuario(Usuario usuario){
    if(usuario!=null){
    usuarios.put(usuario.getCedula(),usuario);
    usuarios.toString();
    }
    
    
    
    }
    public Usuario usuarioFind(String cedula, String clave) throws Exception {
        if (usuarios.get(cedula) != null) {
            if (usuarios.get(cedula).getClave().equals(clave)) {
                return usuarios.get(cedula);
            } else {
                throw new Exception("La clave es incorrecta");
            }

        } else {
            throw new Exception("Usuario no existe");
        }
    }

    public boolean existeUsuario(String cedula) {
        if (usuarios.get(cedula) != null) {
            return true;

        } else {
            return false;
        }
    }
    
        public List<Usuario> teachersFind() throws Exception{
        List<Usuario> result = new ArrayList();
        for(Usuario u: usuarios.values()){
            if(u.getTipo().equals(1)){
                result.add(u);
            }
        }
        return result;
    }

}
