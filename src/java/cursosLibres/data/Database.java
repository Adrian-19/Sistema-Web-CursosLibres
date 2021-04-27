/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.data;

/**
 *
 * @author adria
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Database {
    private static Database theInstance;
    public static Database instance(){
        if (theInstance==null){ 
            theInstance=new Database();
        }
        return theInstance;
    }
    public static final String PROPERTIES_FILE_NAME="/db.properties";        
    Connection cnx;
    public Database(){
        cnx=this.getConnection();            
    }
    public Connection getConnection(){
        try {
            System.out.println("1");
            Properties prop = new Properties();
            System.out.println("2");
            URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);
            System.out.println("3");
            File file = new File(resourceUrl.toURI());
            System.out.println("4");
            prop.load(new BufferedInputStream(new FileInputStream(file)));
            System.out.println("5");
            String driver = prop.getProperty("database_driver");
            System.out.println("6");
            String server = prop.getProperty("database_server");
            System.out.println("7");
            String port = prop.getProperty("database_port");
            System.out.println("8");
            String user = prop.getProperty("database_user");
            System.out.println("9");
            String password = prop.getProperty("database_password");
            System.out.println("10");
            String database = prop.getProperty("database_name");
            System.out.println("11");
            String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+
<<<<<<< HEAD
                    database+"?user="+user+"&password="+password+"&serverTimezone=UTC&useSSL=False ";            
=======
                    database+"?user="+user+"&password="+password+"&serverTimezone=UTC&useSSL=false";  
            System.out.println("12");
>>>>>>> a187b2ba38cc2c0b8795a7a8772a367b7f5e4a72
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
        return null;
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }    
}