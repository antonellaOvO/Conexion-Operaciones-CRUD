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
public class TarjetaDAO {
    public static void printTarjetaDetails() {
   String query = "SELECT * FROM Tarjetas;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_tarjeta");
       int idUsuario = rs.getInt("id_usuarioTarjeta");
       String numero = rs.getString("numero_tarjeta");
       int clave = rs.getInt("clave_tarjeta");
       Date fechaCaducidad = rs.getDate("fechaCaducidad_tarjeta");
       
       System.out.println("ID de la tarjeta: " + id + ", Id del usuario: " + idUsuario + ", Número de la tarjeta: " + numero + ", Clave de la tarjeta: " + clave + ", Fecha de Caducidad de la tarjeta: " + fechaCaducidad);
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
    
    public static void insertTarjeta(int idUsuario, String numero, int clave, String fechaCaducidad) {
  String query = "INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) VALUES (?, ?, ?, ?);";
  try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
      
       Date sqlDate = Date.valueOf(fechaCaducidad);
      
      pstmt.setInt(1,idUsuario); /*1 de campo 1 de la query*/
      pstmt.setString(2, numero); /*2 de campo 2 de la query*/
      pstmt.setInt(3, clave);
      pstmt.setDate(4, sqlDate);
      
      pstmt. executeUpdate();
      System.out.println("Nueva tarjeta insertada - con numero: " + numero);
      
  }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    }  
  } 
    
    public static void deleteTarjetaById(int id) {
    String query = "DELETE FROM Tarjetas WHERE id_tarjeta =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    public static String getNumeroTarjeta(int idUsuario){
        String numeroTarjeta = "";
        String query = "SELECT numero_tarjeta FROM Tarjetas WHERE id_usuarioTarjeta = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setInt(1,idUsuario);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                numeroTarjeta = rs.getString("numero_tarjeta");
                System.out.println("Número de la tarjeta: " + numeroTarjeta);
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return numeroTarjeta;  
    }
    
     public static void updateFechaCaducidad(String fechaCaducidad, String numero){
     String query = "UPDATE Tarjetas SET fechaCaducidad_tarjeta = ? WHERE numero_tarjeta = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setString(1,fechaCaducidad);
         pstmt.setString(2, numero);

         pstmt.executeUpdate();
         System.out.println("Nueva fecha de Caducidad: " + fechaCaducidad + " actualizada");
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
    
}
