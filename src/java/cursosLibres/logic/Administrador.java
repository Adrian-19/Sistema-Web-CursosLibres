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
public class Administrador {
    int id;
    String nombre;

    public Administrador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Administrador() {
        this.id = 0;
        this.nombre = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
