/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class listarTuto {
    public static List<Tutorial> listarTuto() throws SQLException {
    List<Tutorial> tutoriales = new ArrayList<>();
    gestionarTutoriales conexion = new gestionarTutoriales();
    
    try (Connection conn = conexion.establecerConexion();
         PreparedStatement statement = conn.prepareStatement("SELECT * FROM tutoriales.tutorial;");
         ResultSet resultSet = statement.executeQuery()) {
        
        while (resultSet.next()) {
            String idTutorial = resultSet.getString("IdTutorial");
            String nombre = resultSet.getString("Nombre");
            String prioridad = resultSet.getString("Prioridad");

            String url = resultSet.getString("Url");
            String estado = resultSet.getString("Estado");
            String categoria = resultSet.getString("Categori");
            
            Tutorial tutorial = new Tutorial(idTutorial, nombre, url, estado, categoria, prioridad);
            tutoriales.add(tutorial);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener los tutoriales: " + e.getMessage());
        throw e;
    }
    
    return tutoriales;
}

}
