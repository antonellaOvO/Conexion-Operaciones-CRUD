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
public class AdministradorDAO {
    
    public static void printAdministradorDetails() {
   String query = "SELECT * FROM Administradores;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_administrador");
       
       System.out.println("ID de administrador: " + id);
       
       }  } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
    
    public static void insertAdministrador(int id){
    String query = "INSERT INTO Administradores (id_administrador) VALUES (?);";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

        pstmt.setInt(1,id); /*1 de campo 1 de la query*/

        pstmt. executeUpdate();
        System.out.println("Nuevo administrador insertado ");

    }catch(SQLException e){
         e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
      }  
        
    }
    
    public static void deleteAdministradorById(int id) {
    String query = "DELETE FROM Administradores WHERE id_administrador =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
}
