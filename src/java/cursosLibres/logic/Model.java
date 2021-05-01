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
    List<Estudiante> estudianteListB; 
    List<Grupo> grupoListA ;
    List<Grupo> grupoListB ;
    
    private Model() {
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111", "111", 0));

        usuarios.put("222", new Usuario("222", "222", 1));
        usuarios.put("333", new Usuario("333", "333", 1));
        usuarios.put("444", new Usuario("444", "444", 2));
        usuarios.put("555", new Usuario("555", "555", 2));


        profesores = new HashMap();
        profesores.put("222", new Profesor("222", "Javier Antonio", "8876-7645", "Ingles","javier@gmail.com"));
// 
////        Matricula m1 = new Matricula("Mat01","Calculo",90.00, "1");
////        Matricula m2 = new Matricula("Mat02","Calculo I",90.00, "2");
////        Matricula m3 = new Matricula("Mat03","Calculo II",90.00, "3");
////        Matricula m4 = new Matricula("Mat04","Calculo III",90.00, "4");
////        List<Matricula> historial = new ArrayList<>();
////        historial.add(m1);
////        historial.add(m2);
////        historial.add(m3);
////        historial.add(m4);
//        
//        
//        estudiantes = new HashMap();
//        estudiantes.put("555", new Estudiante("555","Melany","8989-8989","melany@gmail.com",historial));
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
        
        estudianteListB = new ArrayList<>();
        
        grupoListA = new ArrayList<>();
        grupoListA.add(new Grupo("1","12:00 - 1:30", profesorList.get(0), estudianteList));
        grupoListA.add(new Grupo("2","12:00 - 1:30", profesorList.get(1), estudianteList));
        
        grupoListB = new ArrayList<>();
        grupoListB.add(new Grupo("3","12:00 - 1:30", profesorList.get(0), estudianteListB));
        grupoListB.add(new Grupo("4","12:00 - 1:30", profesorList.get(1), estudianteListB));
        
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
    
        public boolean existeProfesor(String cedula) {
        if (profesores.get(cedula) != null) {
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
    
    public Profesor profesorFind(String cedula) throws Exception {
        if (profesores.get(cedula) != null) {
            return profesores.get(cedula);
        } else {
            throw new Exception("Estudiante no existe");
        }
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
        
        // Hashmap con nombre del curso como llave y lista de grupos como valor.
        public HashMap gruposFind(Profesor p){
            System.out.println("Buscando a profesores con id: " + p.getId());
            HashMap<String, List<Grupo>> cursoGrupos = new HashMap();
            for(int i = 0; i<cursoList.size(); i++)
            {
                List<Grupo> grupos = new ArrayList<>();
                Curso c = cursoList.get(i);
                System.out.println("Curso: " + c.getNombre());
                for(int j = 0; j<c.getGrupoList().size(); j++)
                {
                    Grupo g = c.getGrupoList().get(j);
                    if(g.getProfesor().getId().equals(p.getId()))
                    {
                        System.out.println("Profesor " + g.getProfesor().getId() +"; " + g.getProfesor().getNombre() +" da un curso llamado " + c.getNombre());
                        grupos.add(g);
                    }
                }
                if(!grupos.isEmpty())
                {
                    cursoGrupos.put(c.getNombre(), grupos);
                }
            }
            
            return cursoGrupos;
        }
        

        public Grupo grupoFind(String nombreCurso, String grupoID) throws Exception{
            for(Curso c : cursoList){
                if(c.getNombre().equals(nombreCurso)){
                    for(Grupo g : c.getGrupoList()){
                        if(g.getId().equals(grupoID)){
                            return g;
                        }
                    }
                }
            }
            throw new Exception("Grupo no existe");
        }

       
        public Curso cursoFind(String curso){
            for(Curso c : cursoList){
                if(c.getNombre().equals(curso)){
                    return c;
                }
            }
            return null;
        }



// --- IMPLEMENTAR 
    
    //verifica si ya existe un grupo en un curso 
    public boolean existeGrupo(String cursoId, String grupoId) {
        for(Curso curso: cursoList){ //buscar el curso por su id
            if(curso.getId() == cursoId){
                for(Grupo g : curso.getGrupoList()){
                    if(g.getId() == grupoId) return true; 
                }
            }
        } 
        return false; 
    }
    
    //verifica que el profesor exista / retorna al profesor si lo encuentra
<<<<<<< HEAD
    public Profesor profesorFindd(String cedula)  throws Exception { //
        for(Profesor p : profesorList){
            if(p.getId() == cedula){
                return p; 
            }else {
                throw new Exception("Profesor no existe");
            }
        }
        return null;
 
    }    
=======
//    public Profesor profesorFind(String cedula) throws Exception {
//        for(Profesor p : profesorList){
//            if(p.getId() == cedula){
//                return p; 
//            }else {
//                throw new Exception("Profesor no existe");
//            }
//        }
//        return null;
//    }    
>>>>>>> e9f95ae02a2539b31b93a9d3298153fea50c845e
    
    //retorna una lista de grupos de un curso
    public List<Grupo> gruposFind(String id) throws Exception {
        for(Curso curso: cursoList){ //buscar el curso por su id
            if(curso.getId() == id){
                return curso.getGrupoList();
            }
        }
        return null;
    }
    
    //obtener cursos para la vista de cursos 
    public List<Curso> getCursosList(){
        return cursoList; 
    }
}
