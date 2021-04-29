/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.EstudiantesDeGrupo;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Model {
    Grupo current;
    List<Estudiante> estudiantes;
    
    public Model(){
        this.reset();
    }
    
    public void reset(){
        estudiantes = new ArrayList<>();
        current = new Grupo();
    }
    
    public Grupo getGrupo() {
        return current;
    }

    public void setGrupo(Grupo grupo) {
        this.current = grupo;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}
