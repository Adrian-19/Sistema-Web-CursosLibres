/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.abrirGrupos;

import cursosLibres.logic.Grupo;


/**
 *
 * @author DS
 * 
 */
public class Model {
    
    Grupo current; 
    
    public Model(){
        this.reset(); 
    }
    
    public void reset(){
        setCurrent(new Grupo()); 
    }

   
}