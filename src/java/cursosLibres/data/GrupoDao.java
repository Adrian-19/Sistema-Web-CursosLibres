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
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author adria
 */
public class GrupoDao {
    public void create(Grupo g, Curso c) throws Exception{
        CursoDao cd = new CursoDao();
        String sql = "insert into Grupos(horario, idProfesor, codigoCurso)"
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
    
    public HashMap findByProfesor(Profesor p){
        CursoDao cursoDao = new CursoDao();
        HashMap<String, List<Grupo>> hm = new HashMap();
        List<Grupo> actual = new ArrayList<>();
        String sql = "select * from Grupos where idProfesor=?";
        try{
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, p.getId());
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while(rs.next()){
                Curso c = cursoDao.read(String.valueOf(rs.getInt("codigoCurso")));
                if(hm.containsKey(c.getNombre())){
                    actual = hm.get(c.getNombre());
                    actual.add(from(rs));
                    hm.put(c.getNombre(), actual);
                }
                else{
                    actual.add(from(rs));
                    hm.put(c.getNombre(), actual);
                }
            }
            return hm;
            
        }catch (Exception ex) { }
        return hm;
    }
    
    public Grupo read(String id) throws Exception{
        String sql = "select * from Grupos where id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, Integer.valueOf(id));
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {
            return from(rs);
        }
        else{
            throw new Exception ("Grupo no Existe");
        }
    }
    
    public Grupo from(ResultSet rs){
        ProfesorDao profe = new ProfesorDao();
        try{
            Grupo g = new Grupo();
            g.setId(String.valueOf(rs.getInt("id")));
            g.setHorario(rs.getString("horario"));
            g.setProfesor(profe.read(String.valueOf(rs.getInt("idProfesor"))));
            System.out.println(g.getId() + " " +g.getHorario() + " " + g.getProfesor().getId());
            return g;
        }catch(Exception ex){
            return null;
        }
    }
}
