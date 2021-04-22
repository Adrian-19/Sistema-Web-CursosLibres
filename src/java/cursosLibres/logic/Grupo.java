/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Grupo {
    String id;
    String horario;
    Profesor profesor;
    List<Estudiante> estudianteList;

    public Grupo(String id, String horario, Profesor profesor, List<Estudiante> estudianteList) {
        this.id = id;
        this.horario = horario;
        this.profesor = profesor;
        this.estudianteList = estudianteList;
    }
    
    public Grupo() {
        this.id = "";
        this.horario = "";
        this.profesor = new Profesor();
        this.estudianteList = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }
    
    
    
}
