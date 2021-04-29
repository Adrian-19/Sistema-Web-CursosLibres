/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.teacherRegistration;


import cursosLibres.logic.Profesor;
import cursosLibres.logic.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Profesor> profesores;
    Profesor profesor;
    Usuario Uprofesor;
    String codigoBusqueda;
    


    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Profesor> rows = new ArrayList<>();         
        this.setProfesores(rows);
        setProfesor(new Profesor());   
        setUprofesor(new Usuario());
        setCodigoBusqueda("");
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Usuario getUprofesor() {
        return Uprofesor;
    }

    public void setUprofesor(Usuario Uprofesor) {
        this.Uprofesor = Uprofesor;
    }

    public String getCodigoBusqueda() {
        return codigoBusqueda;
    }

    public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }
    


   
    
}
