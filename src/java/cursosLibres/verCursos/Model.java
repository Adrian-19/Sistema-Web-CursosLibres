/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.verCursos;

import cursosLibres.logic.Curso;
import cursosLibres.logic.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DS
 */
public class Model {
    List<Curso> cursos; 
    Curso currentCurso; 
    Usuario user; 
    
    public Model(){
        this.reset(); 
    }
    
    public void reset() {
        List<Curso> rows = new ArrayList<>(); 
        this.setListaCursos(rows); 
        setCurrentCurso(new Curso()); 
        
    }
    
    //Cursos list
    public List<Curso> getListaCursos(){
        return cursos; 
    }
    
    public void setListaCursos(List<Curso> c){
        cursos = c; 
    }
    
    //current curso
    public Curso getCurrentCurso(){
        return currentCurso; 
    }
    
    public void setCurrentCurso(Curso c){
        currentCurso = c; 
    }
    
    public void setUsuario(Usuario u){
        user =u; 
    }
    
    public Usuario getUsuario(){
        return user; 
    }
}
