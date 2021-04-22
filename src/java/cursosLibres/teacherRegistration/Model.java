/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.teacherRegistration;


import cursosLibres.logic.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Usuario> usuarios;
    Usuario profesor;


    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Usuario> rows = new ArrayList<>();         
        this.setUsuarios(rows);
        setProfesor(new Usuario());   
    }
    
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios =usuarios;    
    }

     public List<Usuario> getUsuarios() {
        return usuarios;
    }
         
    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

   
    
}
