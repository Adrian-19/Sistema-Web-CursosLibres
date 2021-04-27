/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emanuelle
 */
public class Model {

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    HashMap<String, Usuario> usuarios;
    HashMap<String, Profesor> profesores;
    HashMap<String, Estudiante> estudiantes;
    HashMap<String, List<String>> favoritas;

    private Model() {
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111", "111", 0));
        usuarios.put("222", new Usuario("222", "222", 2));
        usuarios.put("333", new Usuario("333", "333", 3));

        profesores = new HashMap();
        profesores.put("222", new Profesor("222", "Javier Antonio", "8876-7645", "Ingles"));
 
        Matricula m1 = new Matricula("Mat01","Calculo",90.00);
        Matricula m2 = new Matricula("Mat02","Calculo I",90.00);
        Matricula m3 = new Matricula("Mat03","Calculo II",90.00);
        Matricula m4 = new Matricula("Mat04","Calculo III",90.00);
        Matricula m5 = new Matricula("Mat05","Algebra Lineal",90.00);
        List<Matricula> historial = new ArrayList<>();
        historial.add(m1);
        historial.add(m2);
        historial.add(m3);
        historial.add(m4);
        historial.add(m5);
        
        
        estudiantes = new HashMap();
        estudiantes.put("333", new Estudiante("333","Melany","8989-8989","melany@gmail.com",historial));
        //HashMap<String,List<String>> favoritas;
        favoritas = new HashMap();
        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
        favoritas.put("222", Arrays.asList(new String[]{"1-111-11", "1-222-22"}));
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.put(usuario.getCedula(), usuario);
            usuarios.toString();
        }
    
    }

    public void agregarProfesor(Profesor profe) {
        if (profe != null) {
            profesores.put(profe.getId(), profe);
            profesores.toString();
        }

    }
    
    public void agregarEstudiante(Estudiante estu) {
        if (estu != null) {
            estudiantes.put(estu.getId(), estu);
            estudiantes.toString();
        }

    }

    public Usuario usuarioFind(String cedula, String clave) throws Exception {
        if (usuarios.get(cedula) != null) {
            if (usuarios.get(cedula).getClave().equals(clave)) {
                return usuarios.get(cedula);
            } else {
                throw new Exception("La clave es incorrecta");
            }

        } else {
            throw new Exception("Usuario no existe");
        }
    }
    
    public Estudiante estudianteFind(String cedula) throws Exception {
        if (estudiantes.get(cedula) != null) {
            return estudiantes.get(cedula);
        } else {
            throw new Exception("Estudiante no existe");
        }
    }

    public boolean existeUsuario(String cedula) {
        if (usuarios.get(cedula) != null) {
            return true;

        } else {
            return false;
        }
    }

    public List<Profesor> teachersFind() throws Exception {
        List<Profesor> result = new ArrayList();
        for (Profesor p : profesores.values()) {
            result.add(p);
        }
        return result;
    }

}
