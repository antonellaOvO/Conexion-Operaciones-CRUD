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
public class Pedido {
    private int idPedido;
    private int idUsuario;
    private int idTarjeta;
    private int cantidad_pedido;
    private double precioTotalPedido;
    private Timestamp estadoProcesando;
    private Timestamp estadoEnviado;
    private Timestamp estadoRecibido;
    private Timestamp estadoCancelado;
    private String fechaPedido;
    private String fechaEntrega;

    public Pedido(int idUsuario, int idTarjeta) {
        this.idUsuario = idUsuario;
        this.idTarjeta = idTarjeta;
      
        
        PedidoDAO.insertPedido(idUsuario, idTarjeta);
    }
    
    public Timestamp getEstadoEnviado(){
    return PedidoDAO.getEstadoEnviado(this.idPedido);
    }
    
    public Timestamp getEstadoRecibido(){
    return PedidoDAO.getEstadoRecibido(this.idPedido);
    }
    
    
    public static void anadirProductoPedido(int id_pedido, int id_promocion, int id_producto, int cantidad){
        PedidoDAO.anadirProcuctoPedido(id_pedido, id_promocion, id_producto, cantidad);
        System.out.println("Producto con id: " + id_producto + " añadido al pedido con id: " + id_pedido + " con la promoción id: " + id_promocion + " con la cantidad de " + cantidad + " productos.");
        
    }
    
    
    public static int calcularCantidadPedido(int id_pedido){
        return PedidoDAO.calcularCantidadPedido(id_pedido);
    }
    
    public static double calcularPrecioPedido(int id_pedido){
        return PedidoDAO.calcularPrecioPedido(id_pedido);

    }
    
    
    public static void procesarPedido(int id_pedido){
        PedidoDAO.procesarPedido(id_pedido);
    }
    
    
    public static void confirmarEnviado(int id_pedido){
    PedidoDAO.confirmarEnviado(id_pedido);
    }
      
    
    public static void confirmarEntrega(int id_pedido){
    PedidoDAO.confirmarEntrega(id_pedido);
    }
    
  
    public static void cancelarPedido(int id_pedido){
    PedidoDAO.cancelarPedido(id_pedido);
    }
    
}

