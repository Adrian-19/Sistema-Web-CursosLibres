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

    public void create(Usuario u) throws Exception {
        String sql = "insert into logins(id ,clave, tipo, correo)"
                + "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.parseInt(u.getCedula()));
        stm.setString(2, u.getClave());
        stm.setInt(3, u.getTipo());
        stm.setString(4, "hola@gmail");
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario ya existe");
        }
    }

    public void create(Usuario u, String correo) throws Exception {
        String sql = "insert into logins(id ,clave, tipo, correo)"
                + "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.parseInt(u.getCedula()));
        stm.setString(2, u.getClave());
        stm.setInt(3, u.getTipo());
        stm.setString(4, correo);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario ya existe");
        }
    }

    public Usuario read(int id) throws Exception {
        String sql = "select * from Logins where id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            return from(rs);
        } else {
            throw new Exception("Usuario no Existe");
        }
    }

    public Usuario from(ResultSet rs) {
        try {
            Usuario r = new Usuario();
            r.setCedula(String.valueOf(rs.getInt("id")));
            r.setTipo(rs.getInt("tipo"));
            r.setClave(rs.getString("clave"));
            r.setCorreo(rs.getString("correo"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
