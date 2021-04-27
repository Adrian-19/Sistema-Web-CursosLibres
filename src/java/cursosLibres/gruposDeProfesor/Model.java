/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.gruposDeProfesor;

import cursosLibres.logic.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Model {
    List<Grupo> grupos;
    Grupo seleccionado;
    
    public Model(){
        this.reset();
    }
    
    public void reset(){
        List<Grupo> rows = new ArrayList<>();
        seleccionado = null;
        setGrupos(rows);
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
