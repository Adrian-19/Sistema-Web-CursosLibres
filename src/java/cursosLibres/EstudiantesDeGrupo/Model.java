/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.EstudiantesDeGrupo;

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
    List<Estudiante> estudiantes;
    
    public Model(){
        this.reset();
    }
    
    public void reset(){
        estudiantes = new ArrayList<>();
        current = new Curso();
    }
    
    public Curso getCurso() {
        return current;
    }

    public void setCurso(Curso curso) {
        this.current = curso;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}
