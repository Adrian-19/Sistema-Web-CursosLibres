/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.registrarCursos;

import cursosLibres.logic.Curso;

/**
 *
 * @author ESCINF
 */
public class Model {
    Curso currentCurso; 
    
    public Model(){
        this.reset(); 
    }

    public void reset(){
       setCurrentCurso(new Curso()); 

    }

    public void setCurrentCurso(Curso c){
        currentCurso=c;
    }
    
    public Curso getCurrentCurso(){
        return currentCurso; 
    }
    
    
}
