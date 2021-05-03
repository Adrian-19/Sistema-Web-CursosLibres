/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adria
 */
public class AdminDao {
    
    
    public Administrador read(String id) throws Exception{
        String sql="select * from Administradores where id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {
            return from(rs);
        }
        else{
            throw new Exception ("Admin no Existe");
        }
    }
    
    public Administrador from (ResultSet rs){
        try{
            Administrador a = new Administrador();
            a.setId(rs.getInt("id"));
            a.setNombre(rs.getString("nombre"));
            return a;
        }catch(SQLException ex){
            return null;
        }
    }
}
