/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

import cursosLibres.logic.Curso;
import cursosLibres.logic.Grupo;
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
public class GrupoDao {
    
    public void create(Grupo g, Curso c) throws Exception{
        CursoDao cd = new CursoDao();
        String sql = "insert into Grupo(horario, idProfesor, codigoCurso)"
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, g.getHorario());
        stm.setInt(2, Integer.parseInt(g.getProfesor().getId()));
        stm.setString(3, cd.findByNombre(c.getNombre()).getId());
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Grupo ya existe");
        }
    }
    
    public Grupo from(ResultSet rs){
        
        try{
            Grupo g = new Grupo();
            g.setId(String.valueOf(rs.getInt("id")));
            g.setHorario(rs.getString("horario"));
            // Insertar profesor con profesorDao?
           
//            Profesor prof = new Profesor();
//            g.setProfesor(prof.setId(rs.getInt("idProfesor")));
            return g;
        }catch(SQLException ex){
            return null;
        }
    }
}
