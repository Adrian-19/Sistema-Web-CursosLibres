/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.login;

import cursosLibres.logic.Usuario;
import cursosLibres.logic.Estudiante;

public class Model {
    Usuario current;
    Estudiante estudiante;
    

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());  
        setEstudiante(new Estudiante());
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
   
}

