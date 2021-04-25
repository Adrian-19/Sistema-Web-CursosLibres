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
}
