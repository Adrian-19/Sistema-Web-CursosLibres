/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.abrirGrupos;

import cursosLibres.logic.Curso;
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

    Grupo currentGrupo; 
    String cursoId; //? 
    List<Curso> listaCursos;  //para asociarlo a un curso 

    
    public Model(){
        this.reset(); 
    }
    
    public void reset(){
       List<Grupo> rows = new ArrayList<>(); 
       setCurrentGrupo(new Grupo()); 
       cursoId =""; 

    }
    
    //grupo actual 
    public Grupo getCurrentGrupo() {
        return currentGrupo;
    }

    public void setCurrentGrupo(Grupo current) {
        this.currentGrupo = current;
    }
    
    //Id del curso 
    // conseguir este string por el método get
    //se usa para buscar el curso al cual pertenece este grupo en el domain Model
    public String getIdCurso(){
        return cursoId; 
    }
    
    public void setIdCurso(String s){
        cursoId= s; 
    }
    
    //lista cursos 
    public List<Curso> getCursos(){
        return listaCursos; 
    }
    
    public void setListaCursos(List<Curso> c){
        listaCursos = c; 
    }
}