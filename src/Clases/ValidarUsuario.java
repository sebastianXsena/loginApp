/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class ValidarUsuario {

    // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        
        try {
            db.conectar();
            String query = "SELECT * FROM usuarios WHERE username = ? AND clave = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           db.desconectar();
        }
       
    }
}
