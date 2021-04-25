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
public class Estudiante {
    
    String id;
    String nombre;
    int telefono;
    String correo;
    List<Matricula> historial;

    public Estudiante(String id, String nombre, int telefono, String correo, List<Matricula> historial) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.historial = historial;
    }

    public Estudiante() {
        this.id = "";
        this.nombre = "";
        this.telefono = 0;
        this.correo = "";
        this.historial = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Matricula> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Matricula> historial) {
        this.historial = historial;
    }

    
    
    
}
