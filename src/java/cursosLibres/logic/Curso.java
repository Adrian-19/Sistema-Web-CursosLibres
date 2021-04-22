/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;

import java.util.List;

/**
 *
 * @author adria
 */
public class Curso{
    String id;
    String nombre;
    Double costo;
    String logo;
    String tematica;
    List<Grupo> grupoList;
    
    public Curso(String id, String nombre, Double costo, String logo, String tematica, List<Grupo> grupoList) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.logo = logo;
        this.tematica = tematica;
        this.grupoList = grupoList;
    }
    
    public Curso() {
        this.id = "";
        this.nombre = "";
        this.costo = 0.0;
        this.logo = "";
        this.tematica = "";
        this.grupoList = null;
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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }
    
    
}
