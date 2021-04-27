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
    List<Curso> cursoList;
    
    List<Profesor> profesorList;
    List<Estudiante> estudianteList;
    
    List<Grupo> grupoListA ;
    List<Grupo> grupoListB ;
    
    private Model() {
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111", "111", 0));

        usuarios.put("222", new Usuario("222", "222", 1));
        usuarios.put("333", new Usuario("333", "333", 1));
        usuarios.put("444", new Usuario("444", "444", 2));
        usuarios.put("555", new Usuario("555", "555", 3));


        profesores = new HashMap();
        profesores.put("222", new Profesor("222", "Javier Antonio", "8876-7645", "Ingles","javier@gmail.com"));
 
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
        estudiantes.put("555", new Estudiante("555","Melany","8989-8989","melany@gmail.com",historial));
        //HashMap<String,List<String>> favoritas;
        favoritas = new HashMap();
        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
        favoritas.put("222", Arrays.asList(new String[]{"1-111-11", "1-222-22"}));
        
        profesorList = new ArrayList<>();
        profesorList.add(new Profesor("222", "Mario", "1111111", "Artes", "mario@gmail.com"));
        profesorList.add(new Profesor("333", "Pedro", "2222222", "Mate", "pedro@gmail.com"));
        
        estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante("444", "Roberto", "3333333","roberto@gmail.com",new ArrayList<>()));
        estudianteList.add(new Estudiante("555", "Ashley", "4444444","ashley@gmail.com",new ArrayList<>()));
        
        grupoListA = new ArrayList<>();
        grupoListA.add(new Grupo("1","12:00 - 1:30", profesorList.get(0), estudianteList));
        grupoListA.add(new Grupo("2","12:00 - 1:30", profesorList.get(1), estudianteList));
        
        grupoListB = new ArrayList<>();
        grupoListA.add(new Grupo("3","12:00 - 1:30", profesorList.get(0), estudianteList));
        grupoListA.add(new Grupo("4","12:00 - 1:30", profesorList.get(1), estudianteList));
        
        cursoList = new ArrayList<>();
        
        cursoList.add(new Curso("111","Pintura en Tela", 1500, "logo", "arte", grupoListA, "En oferta"));
        
        cursoList.add(new Curso("222","Programacion", 3500, "logo", "mate", grupoListB, "En oferta"));
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
        
        
        public Profesor profesorFind(Usuario u) throws Exception{
        Profesor p = null;
        for(int i = 0; i<profesorList.size(); i++)
        {
            p = profesorList.get(i);
            if(p.getId().equals(u.getCedula())){
                return p;
                
            }
        }
        return p;
        }
        
        public List<Grupo> gruposFind(Profesor p){
            List<Grupo> grupos = new ArrayList<>();
            
            for(int i = 0; i<cursoList.size(); i++)
            {
                Curso c = cursoList.get(i);
                System.out.println("size: " + c.getGrupoList().size());
                for(int j = 0; j<c.getGrupoList().size(); j++)
                {
                    Grupo g = c.getGrupoList().get(j);
                    //System.out.println("profesor: " + g.getProfesor().getId());
                    if(g.getProfesor().getId().equals(p.getId()))
                    {
                        // En el ID del grupo, setea el nombre del curso en el que esta el grupo;
                        c.getGrupoList().get(j).setId(c.getNombre());
                        grupos.add(c.getGrupoList().get(j));
                    }
                }
            }
            
            return grupos;
        }
}
