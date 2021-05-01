/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;


import cursosLibres.logic.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author adria
 */
public class CursoDao {
    
    public void create(Curso c) throws Exception{
        String sql = "insert into Cursos (nombre, tematica, costo, estado)"
                + "values(?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, c.getNombre());
        stm.setString(2, c.getTematica());
        stm.setInt(3, c.getCosto());
        stm.setString(4, c.getEstado());
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Curso ya existe");
        }
    }
    
    public Curso findByNombre(String nombre){
        Curso c = null;
        String sql ="select * from Cursos where nombre=?";
        sql = String.format(sql, nombre);
        try{
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, nombre);       
            ResultSet rs =  Database.instance().executeQuery(stm);
            if(rs.next()){c = from(rs);}
        }
        catch(SQLException ex){}
        return c;
    }
    
    public Curso from (ResultSet rs){
        try{
            Curso c = new Curso();
            c.setId(String.valueOf(rs.getInt("codigo")));
            c.setNombre(rs.getString("nombre"));
            c.setTematica(rs.getString("tematica"));
            c.setCosto(rs.getInt("costo"));
            c.setEstado(rs.getString("estado"));
            return c;
        }catch (SQLException ex) {
            return null;
        }
    }
    
    
    
    // 
    public List<Curso> findAll(){
        List<Curso> cursos = new ArrayList<>(); 
        String sql = "select * from cursos"; 
        
        try{
            PreparedStatement stm = Database.instance().prepareStatement(sql); 
            ResultSet rs = Database.instance().executeQuery(stm); 
            while(rs.next()){ cursos.add(from(rs)); }
        } catch (SQLException ex) { }
        
        return cursos; 
    }
}
