/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adria
 */
public class EstudianteDao {
    
    public Estudiante read(String id) throws Exception{
        String sql = "select * from Estudiantes where id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.valueOf(id));
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {
            return from(rs);
        }
        else{
            throw new Exception ("Estudiantes no Existe");
        }
    }
    
    public Estudiante from(ResultSet rs){
        try{
            Estudiante e = new Estudiante();
            e.setId(String.valueOf(rs.getInt("id")));
            e.setNombre(rs.getString("nombre"));
            e.setTelefono(String.valueOf(rs.getInt("telefono")));
            return e;
        }catch (SQLException ex) {
            return null;
        }
    }
}
