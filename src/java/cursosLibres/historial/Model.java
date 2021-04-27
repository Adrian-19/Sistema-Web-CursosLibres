/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.historial;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Matricula;
import java.util.ArrayList;
import java.util.List;

public class Model {

    Estudiante estudiante;
    List<Matricula> historial;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Matricula> matriculas = new ArrayList<>();   
        setEstudiante(new Estudiante());
        setHistorial(matriculas);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Matricula> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Matricula> historial) {
        this.historial = historial;
    }

}
