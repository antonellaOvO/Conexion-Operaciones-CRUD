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
public class Reporte {
   private int idAdministrador;
   private String nombre;
   private String tipo;
   private String texto;

    public Reporte(int idAdministrador, String nombre, String tipo, String texto) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.tipo = tipo;
        this.texto = texto;
        
        
    }

    public String getNombre() {
        return ReporteDAO.getNombreReporte(this.tipo, this.texto);
    }

    public void setTexto(String nuevoTexto) {
        ReporteDAO.updateTexto(nuevoTexto, this.nombre, this.tipo);
    }
    
    public static void  anadirPedidoReporte(int id_reporte, int id_pedido, int id_administrador){
    ReporteDAO.anadirPedidoReporte(id_reporte, id_pedido, id_administrador);
    }
    
    public static void realizarReporte(int id_reporte, int id_pedido, int id_administrador, String nombre, String tipo, String texto){
    ReporteDAO.realizarReporte(id_reporte, id_pedido, id_administrador, nombre, tipo, texto);
    }
    
    
   
   
   
}
