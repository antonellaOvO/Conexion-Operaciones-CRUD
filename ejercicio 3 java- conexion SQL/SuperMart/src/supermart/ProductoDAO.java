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
public class ProductoDAO {
    
   public static void printProductoDetails() {
   String query = "SELECT * FROM Productos;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_producto");
       String nombre = rs.getString("nombre_producto");
       String categoria = rs.getString("categoria_producto");
       double precio = rs.getDouble("precio_producto");
       int cantidad = rs.getInt("cantidad_producto");
       Timestamp fechaCreacion = rs.getTimestamp("fechaCreacion_producto");
       Date fechaCaducidad = rs.getDate("fechaCaducidad_producto");
       
       System.out.println("ID de producto: " + id + ", Nombre producto: " + nombre + ", Categoría de producto: " + categoria + ", Precio de producto: " + precio + ", Cantidad de producto: " + cantidad + ", Fecha de Creación del producto: " + fechaCreacion + ", Fecha de Caducidad del producto: " + fechaCaducidad);
       
       }  } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
    
    public static void insertProducto(String nombre, String categoria, double precio, int cantidad, Timestamp fechaCreacion, String fechaCaducidad){
    String query = "INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) VALUES (?, ?, ?, ?, ?, ?);";
    try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

         Date sqlDate = Date.valueOf(fechaCaducidad);

        pstmt.setString(1,nombre); /*1 de campo 1 de la query*/
        pstmt.setString(2, categoria); /*2 de campo 2 de la query*/
        pstmt.setDouble(3, precio); /*3 de campo 3 de la query*/
        pstmt.setInt(4, cantidad);
        pstmt.setTimestamp(5, fechaCreacion);
        pstmt.setString(6, fechaCaducidad);

        pstmt. executeUpdate();
        System.out.println("Nuevo producto insertado ");

    }catch(SQLException e){
         e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
      }  
        
    }
    
    public static void deleteProductoById(int id) {
    String query = "DELETE FROM Productos WHERE id_producto =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
 public static double getProductoPrecio(String nombreProducto){
        double precio = 0.0;
        String query = "SELECT precio_producto FROM Productos WHERE nombre_producto = ?";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setString(1,nombreProducto);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                precio = rs.getDouble("precio_producto");
                System.out.println(" precio del producto: " + precio);
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return precio;  
    }
 
 public static void updateProductoPrecio(String nombre, String categoria, double precio){
     String query = "UPDATE Productos SET precio_producto = ? WHERE nombre_producto = ? AND categoria_producto = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setDouble(1,precio);
         pstmt.setString(2, nombre);
          pstmt.setString(3, categoria);
         pstmt.executeUpdate();
         System.out.println("Nuevo precio: " + precio + " del producto con Nombre: " + nombre + " y de Categoria: " + categoria + " actualizado.");
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
  
    
    
       
}
