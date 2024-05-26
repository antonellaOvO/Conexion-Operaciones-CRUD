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
import java.text.SimpleDateFormat;


/**
 *
 * @author anto_
 */
public class NotificacionDAO {
   
    public static void printNotificacionDetails() {
   String query = "SELECT * FROM Notificaciones;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_notificacion");
       int idPromocion = rs.getInt("id_promocion");
       String texto = rs.getString("texto_notificacion");
       Date fechaNotificacion = rs.getDate("fecha_notificacion");
       
       System.out.println("ID de la notificacion " + id + ", Id de la promoción: " + idPromocion + ", Texto de la Notificación: " + texto + ", con fecha de: " + fechaNotificacion);
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
     public static void insertNotificacion(int idPromocion, String texto, String fechaNotificacion) {
  String query = "INSERT INTO Notificaciones(id_promocion, texto_notificacion, fecha_notificacion) VALUES (?, ?, ?);";
  try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
      
       Date sqlDate = Date.valueOf(fechaNotificacion);
      
      pstmt.setInt(1,idPromocion); /*1 de campo 1 de la query*/
      pstmt.setString(2, texto); /*2 de campo 2 de la query*/
      pstmt.setDate(3,sqlDate);
      
      pstmt. executeUpdate();
      System.out.println("Nueva Notificacion creada - con el siguiente contenido: " + texto);
      
  }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    }  
  }
     
     public static void deleteNotifacionById(int id) {
    String query = "DELETE FROM Notificaciones WHERE id_notificacion =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
     
      public static void updateTexto(String texto, int idPromocion, String fecha){
     String query = "UPDATE Notificaciones SET texto_notificacion = ? WHERE id_promocion = ? AND fecha_notificacion = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setString(1,texto);
         pstmt.setInt(2, idPromocion);
          pstmt.setString(3, fecha);
         pstmt.executeUpdate();
         System.out.println("Nuevo texto de la Notificacion " + texto + " actualizado");
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
      
     public static String getfechaNotificacion(int idPromocion, String texto){ /*MODIFICAR de modo que en la query sea id_notificacion por la que se busque!*/
        Date fecha = null;
        String fechaString = "";
        String query = "SELECT fecha_notificacion FROM Notificaciones WHERE id_promocion = ? AND texto_notificacion  = ?;"; /*se podría hacer con MAX(fecha_notificacion)*/
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setInt(1,idPromocion);
                pstmt.setString(2,texto);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                fecha = rs.getDate("fecha_notificacion");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fechaString = formatter.format(fecha);
                System.out.println("La notificación de la promoción con id :" + idPromocion + " cuya fecha es de: " + fecha );
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return fechaString;  
    }
     
      public static String getfechaNotificacionById(int id_notificacion){ /*MODIFICAR de modo que en la query sea id_notificacion por la que se busque!*/
        Date fecha = null;
        String fechaString = "";
        String query = "SELECT fecha_notificacion FROM Notificaciones WHERE id_notificacion = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setInt(1,id_notificacion);
               

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                fecha = rs.getDate("fecha_notificacion");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fechaString = formatter.format(fecha);
                System.out.println("La notificación con id :" + id_notificacion + " cuya fecha es de: " + fecha );
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return fechaString;  
    }
    
}
