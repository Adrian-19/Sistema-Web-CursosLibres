/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author adria
 */
public class UsuarioDao {
    
    // Talvez que al insertar un usuario en la tabla devuelve el id del usuario (auto incremental)
    // Se tendra que modificar las variables de la clase Usuario para que calce con la tabla de Usuario
    public void create(Usuario u) throws Exception{
        String sql="insert into Logins (id, clave, tipo, correo) "+
                "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        stm.setString(3, String.valueOf(u.getTipo()));
        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente ya existe");
        }
    }
    
    
//    public Usuario read(String id) throws Exception{
//        String sql="select * from Logins where id=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, id);
//        ResultSet rs =  Database.instance().executeQuery(stm);           
//        if (rs.next()) {
//            return from(rs);
//        }
//        else{
//            throw new Exception ("Cliente no Existe");
//        }
//    }
//    
//    
//    public Usuario from (ResultSet rs){
//        try {
//            Usuario r= new Usuario();
//            r.setId(rs.getString("id"));
//            r.setNombre(rs.getString("nombre"));
//            return r;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
    
    public  void close(){
    }
}
