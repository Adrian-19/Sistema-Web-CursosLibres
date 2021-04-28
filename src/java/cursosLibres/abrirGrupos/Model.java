/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.abrirGrupos;

import cursosLibres.logic.Grupo;
import cursosLibres.logic.Usuario;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DS
 * 
 */
public class Model {

    List<Grupo> grupos; 
    Grupo currentGrupo; 

    
    public Model(){
        this.reset(); 
    }
    
    public void reset(){
       List<Grupo> rows = new ArrayList<>(); 
       this.setGrupos(rows); 
       setCurrentGrupo(new Grupo()); 

    }
    
    //lista de grupos
    public List<Grupo> getGrupos() {
        return grupos;
    }
        
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }   
 
    //grupo actual 
    public Grupo getCurrentGrupo() {
        return currentGrupo;
    }

    public void setCurrentGrupo(Grupo current) {
        this.currentGrupo = current;
    }
    
}