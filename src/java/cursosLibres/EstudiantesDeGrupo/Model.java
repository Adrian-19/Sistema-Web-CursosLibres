/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.EstudiantesDeGrupo;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import cursosLibres.logic.Matricula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Model {
    Grupo current;
    List<Estudiante> estudiantes;
    Matricula matricula;
    List<Matricula> listaMatriculas;
    
    public Model(){
        this.reset();
    }
    
    public void reset(){
        estudiantes = new ArrayList<>();
        current = new Grupo();
        matricula = new Matricula();
        listaMatriculas = new ArrayList<>();
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Matricula> getListaMatriculas() {
        return listaMatriculas;
    }

    public void setListaMatriculas(List<Matricula> listaMatriculas) {
        this.listaMatriculas = listaMatriculas;
    }
    
    
}
