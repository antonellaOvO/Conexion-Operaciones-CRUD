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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author anto_
 */
public class PedidoDAO {
    
    public static void printPedidoDetails() {
   String query = "SELECT * FROM Pedidos;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int idPedido = rs.getInt("id_pedido");
       int idUsuario = rs.getInt("id_usuario");
       int idTarjeta = rs.getInt("id_tarjeta");
       int cantidad = rs.getInt("cantidad_pedido");
       String precioTotalPedido = rs.getString("precioTotal_pedido");
       Timestamp estadoProcesando = rs.getTimestamp("estadoProcesando_pedido");
       Timestamp estadoEnviado = rs.getTimestamp("estadoEnviado_pedido");
       Timestamp estadoRecibido = rs.getTimestamp("estadoRecibido_pedido");
       Timestamp estadoCancelado = rs.getTimestamp("estadoCancelado_pedido");
       Date fechaPedido = rs.getDate("fecha_pedido");
       Date fechaEntregaPedido = rs.getDate("fechaEntrega_pedido");
       
       System.out.println("ID del pedido: " + idPedido + ", ID del usuario: " + idUsuario + ", ID de la tarjeta: " + idTarjeta +", Cantidad del Pedido: " + cantidad + ", Precio Total del Pedido: " + precioTotalPedido + ", Estado Procesando del pedido: " + estadoProcesando + ", Estado Enviado del pedido: " + estadoEnviado + ", Estado Recibido del pedido: " + estadoRecibido + ", Estado Cancelado del pedido: " + estadoCancelado + ", Fecha del pedido: " + fechaPedido + ", Fecha Entrega del pedido: " + fechaEntregaPedido);
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   }
    
    public static void insertPedido(int idUsuario, int idTarjeta) {
  String query = "INSERT INTO Pedidos (id_usuario, id_tarjeta) VALUES (?,?);";
  try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
      
      pstmt.setInt(1,idUsuario); /*1 de campo 1 de la query*/
      pstmt.setInt(2, idTarjeta); /*2 de campo 2 de la query*/
      
      pstmt. executeUpdate();
      System.out.println("Nuevo pedido creado!");
      
  }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    }  
  } 
    
    public static void deletePedidoById(int id) {
    String query = "DELETE FROM Pedidos WHERE id_pedido =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    public static void anadirProcuctoPedido(int id_pedido, int id_promocion, int id_producto, int cantidad){
        String query = "INSERT INTO producto_promocion_pedido(id_producto, id_promocion, id_pedido, cantidad) VALUES (?,?,?, ?); ";
        try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setInt(1, id_producto);
            pstmt.setInt(2, id_promocion);
            pstmt.setInt(3, id_pedido);
            pstmt.setInt(4, cantidad);
            pstmt.executeUpdate();        
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
        
        
    }
    
    
    
    public static int calcularCantidadPedido(int id_pedido){
        int cantidad = 0;
        String query = "SELECT sum(cantidad) as cantidad from producto_promocion_pedido where id_pedido = ? group by id_pedido;";
          try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
              
              pstmt.setInt(1, id_pedido);
              
              ResultSet rs = pstmt.executeQuery();
              
              while(rs.next()){
                  cantidad = rs.getInt("cantidad");
                  System.out.println("Pedido con id "+ id_pedido + " tiene una cantidad de productos de: "+ cantidad);
              }
              
              
              
        }catch(SQLException e){
          e.printStackTrace();
       } 
        return cantidad;
        
    }
    
    
   
    
    
    
    public static double calcularPrecioPedido(int id_pedido){
        double precio_total = 0;
        String query = "SELECT sum(t1.precio_total) as precio_final, t1.id_pedido from( SELECT ((ta.cantidad*tb.precio_producto)-(ta.cantidad*tb.precio_producto*tc.precioDescuento_promocion)) as precio_total, ta.id_pedido from producto_promocion_pedido ta inner join productos tb on ta.id_producto = tb.id_producto inner join promociones tc on ta.id_promocion = tc.id_promocion where id_pedido = ?) as t1 group by id_pedido;";
        
        try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
              
              pstmt.setInt(1, id_pedido);
              
              ResultSet rs = pstmt.executeQuery();
              
              while(rs.next()){
                  precio_total = rs.getInt("precio_final");
                  System.out.println("Pedido con id "+ id_pedido + " tiene un precio final de: "+ precio_total);
              }         
              
        }catch(SQLException e){
          e.printStackTrace();
       } 
        return precio_total;
           
    }
        
   
    
    
    public static void procesarPedido(int id_pedido){
        String query = "UPDATE pedidos SET cantidad_pedido = ?, precioTotal_pedido = ?, estadoProcesando_pedido = ? where id_pedido = ?; ";
        
        int cantidad = PedidoDAO.calcularCantidadPedido(id_pedido);
        double precio_total = PedidoDAO.calcularPrecioPedido(id_pedido);
        
        Timestamp now = new Timestamp(System.currentTimeMillis());   
        
        try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
          
            pstmt.setInt(1,cantidad);
            pstmt.setDouble(2, precio_total);
            pstmt.setTimestamp(3, now);
            pstmt.setInt(4, id_pedido);
            pstmt.executeUpdate();
            
            System.out.println("Pedido con id: " + id_pedido + " procesado!");
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
        
          
    }
    
    
    public static void confirmarEnviado(int id_pedido){
        String query = "UPDATE pedidos SET estadoEnviado_pedido = ? where id_pedido = ?; ";
        
        Timestamp now = new Timestamp(System.currentTimeMillis());   
       
        LocalDateTime localDateTime2 = now.toLocalDateTime().plus(1, ChronoUnit.DAYS);
        Timestamp estadoEnviado = Timestamp.valueOf(localDateTime2);
        
        
         try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setTimestamp(1, estadoEnviado);
            pstmt.setInt(2, id_pedido);
            
            pstmt.executeUpdate();
            
            System.out.println("Pedido con id: " + id_pedido + " se confirma que se ha enviado con fecha de: " + estadoEnviado);
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
        
        }
    
    public static void confirmarEntrega(int id_pedido){
        String query = "UPDATE pedidos SET estadoRecibido_pedido = ?  where id_pedido = ?; ";
        
        Timestamp now = new Timestamp(System.currentTimeMillis());   
        
        LocalDateTime localDateTime = now.toLocalDateTime().plus(5, ChronoUnit.DAYS);
        Timestamp estadoRecibido = Timestamp.valueOf(localDateTime);
        
        
         try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setTimestamp(1, estadoRecibido);
            pstmt.setInt(2, id_pedido);
            
            pstmt.executeUpdate();
            
            System.out.println("Pedido con id: " + id_pedido + " se confirma entrega con fecha: " + estadoRecibido);
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
        
        }
    
    
    
    
    public static void updateEstadoRecibido(int id_pedido) {
    String query = "UPDATE pedidos SET estadoRecibido_pedido = ? where id_pedido = ?; "; 
   /*todo modificar*/ 
    Timestamp estadoRecibido = null;
      
        
         try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setTimestamp(1, estadoRecibido);
            pstmt.setInt(2, id_pedido);
            pstmt.executeUpdate();
            
            System.out.println("Pedido con id: " + id_pedido + " se cancela con fecha de : " + estadoRecibido);
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
    
    }
    
    public static void updateEstadoCancelado(int id_pedido) {
    String query = "UPDATE pedidos SET estadoCancelado_pedido = ? where id_pedido = ?; "; 
   /*todo modificar*/ 
    Timestamp estadoCancelado = new Timestamp(System.currentTimeMillis());
      
        
         try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setTimestamp(1, estadoCancelado);
            pstmt.setInt(2, id_pedido);
            pstmt.executeUpdate();
            
            System.out.println("Pedido con id: " + id_pedido + " se cancela con fecha de : " + estadoCancelado);
            
        }catch(SQLException e){
          e.printStackTrace();
       } 
    
    }
    
    public static Timestamp getEstadoEnviado(int id_pedido){
       Timestamp estadoEnviado = null;
        String query = "SELECT estadoEnviado_pedido FROM Pedidos WHERE id_pedido = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

               
                pstmt.setInt(1,id_pedido);
              

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                estadoEnviado = rs.getTimestamp("estadoEnviado_pedido");
                
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return estadoEnviado; 
    
    }
    
    public static Timestamp getEstadoRecibido(int id_pedido){
       Timestamp estadoRecibido = null;
        String query = "SELECT estadoRecibido_pedido FROM Pedidos WHERE id_pedido = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

               
                pstmt.setInt(1,id_pedido);
              

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                estadoRecibido = rs.getTimestamp("estadoRecibido_pedido");
                
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return estadoRecibido; 
    
    }
    
    
    
    public static void cancelarPedido(int id_pedido){ 
    Timestamp estadoEnviado = PedidoDAO.getEstadoEnviado(id_pedido);
    if(estadoEnviado == null){
    PedidoDAO.updateEstadoCancelado(id_pedido);
    System.out.println("El pedido con id: " + id_pedido + " ha sido cancelado!");
    }else{
    System.out.println("Lo sentimos, pero tu pedido ya ha sido enviado. Cuando lo recibas, por favor realiza una devolución.");
    }
    
    }
    
    
    
    
   
    
}
