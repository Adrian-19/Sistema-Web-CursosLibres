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
  
    public void create(Matricula m) throws Exception{
        String sql = "insert into matriculas (idEstudiante, idGrupo)"
                + "values(?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.valueOf(m.getIdEstudiante()));
        stm.setInt(2, Integer.valueOf(m.getIdGrupo()));
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Curso ya existe");
        }
    }
    
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
    
    public List<Matricula> findByEstudiante(Estudiante e){
        List<Matricula> r = new ArrayList<>();
        String sql = "select * from matriculas where idEstudiante=?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setInt(1, Integer.valueOf(e.getId()));   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    public void updateNota(Matricula m) throws Exception{
        String sql = "update Matriculas set calificacion=? where idGrupo=? and idEstudiante=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, (int)m.getNota());
        stm.setInt(2, Integer.valueOf(m.getIdGrupo()));
        stm.setInt(3, Integer.valueOf(m.getIdEstudiante()));
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Matricula no existe");
        }
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
}
