package com.umariana.conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class gestionarTutoriales 
{             
    public Connection establecerConexion ()
    {               
        String url = "jdbc:mysql://localhost:3306/tutoriales";
        String user = "root";
        String password = "";      
        Connection conn = null;
        
        try {            
            // Carga del driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecimiento de la conexión
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("Conexion exitosa");              
            }
        } catch (Exception e){
            System.out.println("error de conexion"+e.getMessage());
        }
        return conn;
    }  

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public boolean eliminarTutorial(int idTutorial) {
        Connection conn = establecerConexion();
        if (conn != null) {
            try {
                CallableStatement stmt = conn.prepareCall("{call eliminarTutorial(?)}");
                stmt.setInt(1, idTutorial);
                stmt.execute();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
   
    }


