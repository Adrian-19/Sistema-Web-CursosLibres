/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Estudiante;
import cursosLibres.logic.Grupo;
import cursosLibres.logic.Matricula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class MatriculaDao {
  
    
    public List<Matricula> findByGrupo(String id){
        List<Matricula> r = new ArrayList<>();
        String sql = "select * from matriculas where idGrupo=?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setInt(1, Integer.valueOf(id));   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    } 
    
    public Matricula from(ResultSet rs){
        try{
            Matricula m = new Matricula();
            m.setIdGrupo(String.valueOf(rs.getInt("idGrupo")));
            m.setIdEstudiante(String.valueOf(rs.getInt("idEstudiante")));
            m.setNota((double)rs.getInt("calificacion"));
            return m;
        }catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Matricula> findByEstudiante(String id){
        List<Matricula> r = new ArrayList<>();
        String sql = "select * from matriculas where idEstudiante=?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setInt(1, Integer.valueOf(id));   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    } 
    
    
}
