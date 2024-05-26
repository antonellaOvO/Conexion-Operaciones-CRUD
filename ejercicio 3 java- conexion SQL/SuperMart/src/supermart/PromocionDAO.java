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
public class PromocionDAO {
    
    
     public static void printPromocionDetails() {
   String query = "SELECT * FROM Promociones;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_promocion");
       int idAdministrador = rs.getInt("id_administrador");
       String textoPromocion = rs.getString("texto_promocion");
       double precioDescuento = rs.getDouble("precioDescuento_promocion");
       Date fechaInicio = rs.getDate("fechaInicio_promocion");
       Date fechaFinal = rs.getDate("fechaFinal_promocion");
       
       System.out.println("ID promoción: " + id + ", ID Administrador: " + idAdministrador + ", Texto de la promoción: " + textoPromocion + ", Precio descuento de la promoción: " + precioDescuento + ", Fecha Inicio de la promoción: " + fechaInicio + ", Fecha Final de la promoción: " + fechaFinal);
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   } 
    
     public static void insertPromocion(int idAdministrador, String textoPromocion, double precioDescuento, String fechaInicio, String fechaFinal) {
    String query = "INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) VALUES (?, ?, ?, ?, ?);";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

         Date sqlDate1 = Date.valueOf(fechaInicio);
         Date sqlDate2 = Date.valueOf(fechaFinal);

        pstmt.setInt(1,idAdministrador); /*1 de campo 1 de la query*/
        pstmt.setString(2, textoPromocion); /*2 de campo 2 de la query*/
        pstmt.setDouble(3, precioDescuento); /*3 de campo 3 de la query*/
        pstmt.setString(4, fechaInicio);
        pstmt.setString(5, fechaFinal);

        pstmt. executeUpdate();
        System.out.println("Nueva promoción insertada: " + textoPromocion);

    }catch(SQLException e){
         e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
      }  
  } 
     
     
     
    public static void deletePromocionById(int id) {
    String query = "DELETE FROM Promociones WHERE id_promocion =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    public static void updatePromocionPrecioDescuento(double precioDescuento, int idPromocion){
     String query = "UPDATE Promociones SET precioDescuento_promocion = ? WHERE id_promocion = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setDouble(1, precioDescuento);
         pstmt.setInt(2, idPromocion);
         pstmt.executeUpdate();
         System.out.println("Nuevo Precio Descuento " + precioDescuento + " actualizado, en la promoción con id: " + idPromocion);
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
    
    public static String getPromocionTextoByAdministrador(int idAdministrador){
        String textoPromocion = "";
        String query = "SELECT texto_promocion FROM Promociones WHERE id_administrador = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setInt(1,idAdministrador);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                textoPromocion = rs.getString("texto_promocion");
                System.out.println("Texto de la Promoción: " + textoPromocion);
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return textoPromocion;  
    }
    
    public static String getPromocionTexto(String fechaInicio, String fechaFinal){
        String textoPromocion = "";
        String query = "SELECT texto_promocion FROM Promociones WHERE fechaInicio_promocion = ? AND fechaFinal_promocion = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setString(1,fechaInicio);
                 pstmt.setString(2,fechaFinal);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                textoPromocion = rs.getString("texto_promocion");
                System.out.println("Texto de la Promoción: " + textoPromocion);
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return textoPromocion;  
    }
    
}
