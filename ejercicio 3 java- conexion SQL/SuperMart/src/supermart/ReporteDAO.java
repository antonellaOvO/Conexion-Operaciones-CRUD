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
public class ReporteDAO {
   
    public static void printReporteDetails() {
   String query = "SELECT * FROM Reportes;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_reporte");
       int idAdministrador = rs.getInt("id_administrador");
       String nombre = rs.getString("nombre_reporte");
       String tipo = rs.getString("tipo_reporte");
       String texto = rs.getString("texto_reporte");
       
       System.out.println("ID del reporte: " + id + ", ID del administrador que ha hecho el reporte: " + idAdministrador + ", Nombre del reporte: " + nombre + ", Tipo del reporte: " + tipo + ", Texto del reporte: " + texto);
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
     public static void insertReporte(int id_reporte, int idAdministrador, String nombre, String tipo, String texto) {
  String query = "INSERT INTO Reportes (id_reporte, id_administrador, nombre_reporte, tipo_reporte, texto_reporte) VALUES (?, ?, ?, ?, ?);";
  try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
     
      
      pstmt.setInt(1,id_reporte);
      pstmt.setInt(2,idAdministrador); 
      pstmt.setString(3, nombre); 
      pstmt.setString(4, tipo); 
      pstmt.setString(5, texto);
      
      pstmt. executeUpdate();
      System.out.println("Nuevo Reporte insertado: " + " con nombre: " + nombre);
      
  }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    }  
  }
     
     public static void deleteReporteById(int id) {
    String query = "DELETE FROM Reportes WHERE id_reporte =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
     
     
     public static void updateTexto(String texto, String nombre, String tipo){
     String query = "UPDATE Reportes SET texto_reporte = ? WHERE nombre_reporte = ? AND tipo_reporte = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setString(1,texto);
         pstmt.setString(2, nombre);
          pstmt.setString(3, tipo);
         pstmt.executeUpdate();
         System.out.println("Reporte con nombre: " + nombre + " actualizado con el siguiente texto: "+ texto);
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
     
     public static String getNombreReporte(String tipo, String texto){
        String nombre = "";
        String query = "SELECT nombre_reporte FROM Reportes WHERE tipo_reporte = ? AND texto_reporte = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

               
                pstmt.setString(1,tipo);
                pstmt.setString(2,texto);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                nombre = rs.getString("nombre_reporte");
                System.out.println(" Nombre del Reporte: " + nombre );
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return nombre;  
    }
     
     public static void anadirPedidoReporte(int id_reporte, int id_pedido, int id_administrador){
        String query = "INSERT INTO pedido_reporte(id_reporte, id_pedido, id_administrador) VALUES (?,?,?); ";
        try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setInt(1, id_reporte);
            pstmt.setInt(2, id_pedido);
            pstmt.setInt(3, id_administrador);
            pstmt.executeUpdate();        
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
        
        
    }
     
     
    public static void realizarReporte(int id_reporte, int id_pedido, int id_administrador, String nombre, String tipo, String texto){ 
    
    Timestamp estadoRecibido = PedidoDAO.getEstadoRecibido(id_pedido);
    
    if(estadoRecibido != null){
    ReporteDAO.insertReporte(id_reporte, id_administrador, nombre, tipo, texto);
    ReporteDAO.anadirPedidoReporte(id_reporte, id_pedido, id_administrador);
    System.out.println("Se ha creado un reporte con id : " + id_reporte + " del pedido cuyo id es: " + id_pedido + " realizado por el administrador con id: " + id_administrador);
    }else{
    System.out.println("Lo sentimos, pero no se puede realizar un reporte de este pedido, ya que aún no ha sido recibido.");
    }
    
    }
     
    
}
