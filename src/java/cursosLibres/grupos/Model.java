/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.grupos;

import cursosLibres.logic.Curso;
import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Model {
    Curso current;
    List<Grupo> listaGrupos;
    Estudiante estudiante;

    public Model(Curso current, List<Grupo> listaGrupos, Estudiante estudiante) {
        this.current = current;
        this.listaGrupos = listaGrupos;
        this.estudiante = estudiante;
    }

    public Model(){
        this.current = new Curso();
        this.listaGrupos = new ArrayList<>();
        this.estudiante = new Estudiante();
    }
    
    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }

    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
