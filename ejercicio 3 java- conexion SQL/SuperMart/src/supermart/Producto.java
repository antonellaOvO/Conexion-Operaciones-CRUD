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
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;
    private Timestamp fechaCreacion;
    private String fechaCaducidad;
    
    public Producto (String nombre, String categoria, double precio, int cantidad, Timestamp fechaCreacion, String fechaCaducidad) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.precio = precio;
    this.cantidad = cantidad;
    this.fechaCreacion = fechaCreacion;
    this.fechaCaducidad = fechaCaducidad;
    
    ProductoDAO.insertProducto(nombre, categoria, precio, cantidad, fechaCreacion, fechaCaducidad);
     }
     
   
   public double getPrecio(){
        return ProductoDAO.getProductoPrecio(this.nombre);
   }
   
   public void setPrecio(double nuevoPrecio){
   ProductoDAO.updateProductoPrecio(this.nombre,this.categoria, nuevoPrecio);
   }
    
    
    
}
