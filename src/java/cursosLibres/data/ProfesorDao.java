/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adria
 */
public class ProfesorDao {
    
    public void create(Profesor o) throws Exception{
        
//        String sql="insert into Profesor (id, nombre, especialidad, telefono) "+
//                "values(?,?,?)";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, o.getId());
//        stm.setString(2, o.getNombre());        
//        stm.setString(3, o.getPais().getCodigo());
//        System.out.println(o.getId() + " "+ o.getNombre() + " " + o.getPais().getCodigo());
//        int count=Database.instance().executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente ya existe");
//        }
    }
    
    public Profesor read (String id) throws Exception{
        String sql = "select * from Profesores where id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.valueOf(id));
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {
            return from(rs);
        }
        else{
            throw new Exception ("Profesor no Existe");
        }
    }
    
    public Profesor from (ResultSet rs){
        try {
            Profesor r= new Profesor();
            r.setId(String.valueOf(rs.getInt("id")));
            r.setNombre(rs.getString("nombre"));
            r.setEspecialidad(String.valueOf(rs.getString("especialidad")));
            r.setTelefono(String.valueOf(rs.getInt("telefono")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }
}
