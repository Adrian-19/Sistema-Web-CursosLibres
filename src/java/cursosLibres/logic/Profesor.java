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
public class Profesor {
    String id;
    String nombre;
    String telefono; //cambiar en la base de datos
    String especialidad;
    String correo;

<<<<<<< HEAD
    public Profesor(String id, String nombre, String telefono, String especialidad) {
=======
    public Profesor(String id, String nombre, int telefono, String especialidad, String correo) {
>>>>>>> eb8f909a82caa9d45d0d68c37f3ae612d8752e9c
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.correo = correo;
    }
    
    public Profesor() {
        this.id = "";
        this.nombre = "";
        this.telefono = "";
        this.especialidad = "";
        this.correo = "";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
