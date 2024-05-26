/*Autora: Antonella Alares*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermart;

import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anto_
 */
public class UsuarioDAO {
    public static void printUsuarioDetails() {
   String query = "SELECT * FROM Usuarios;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_usuario");
       
       System.out.println("ID de usuario: " + id);
       
       }  } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
    
    public static void insertUsuario(int id){
    String query = "INSERT INTO Usuarios (id_usuario) VALUES (?);";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

        pstmt.setInt(1,id); /*1 de campo 1 de la query*/

        pstmt. executeUpdate();
        System.out.println("Nuevo usuario insertado ");

    }catch(SQLException e){
         e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
      }  
        
    }
    
    public static void deleteUsuarioById(int id) {
    String query = "DELETE FROM Usuarios WHERE id_usuario =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    
}
