/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;

/**
 *
 * @author adria
 */
public class Matricula {
    String idCurso;
    String nombreCurso;
    double nota;

    public Matricula(String idCurso, String nombreCurso, double nota) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.nota = nota;
    }
    
    public Matricula() {
        this.idCurso = "";
        this.nombreCurso = "";
        this.nota = 0.0;
    }
    
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
