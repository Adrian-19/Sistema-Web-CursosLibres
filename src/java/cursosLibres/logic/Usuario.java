/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;


import java.util.Objects;

public class Usuario  implements java.io.Serializable {


     private String cedula;
     private String clave;
     private Integer tipo;
     private String correo;
     private String telefono;
     


    public Usuario() {
    }

	
    public Usuario(String cedula) {
        this.cedula = cedula;
    }

    public Usuario(String cedula, String clave, Integer tipo, String correo, String telefono) {
        this.cedula = cedula;
        this.clave = clave;
        this.tipo = tipo;
        this.correo = correo;
        this.telefono = telefono;
    }

   
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    
    

}