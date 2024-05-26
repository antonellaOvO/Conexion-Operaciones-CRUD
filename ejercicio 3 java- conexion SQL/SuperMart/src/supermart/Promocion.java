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
public class Promocion {
    private int idAdministrador;
    private String textoPromocion;
    private double precioDescuento;
    private String fechaInicio;
    private String fechaFinal;
    
    public Promocion(int idAdministrador, String textoPromocion, double precioDescuento, String fechaInicio, String fechaFinal){
    this.idAdministrador = idAdministrador;
    this.textoPromocion = textoPromocion;
    this.precioDescuento = precioDescuento;
    this.fechaInicio = fechaInicio;
    this.fechaFinal = fechaFinal;
    
    PromocionDAO.insertPromocion(idAdministrador, textoPromocion, precioDescuento, fechaInicio, fechaFinal);
    }
    
    public String getTextoPromocion(){
        return PromocionDAO.getPromocionTexto(this.fechaInicio, this.fechaFinal);
    }
    
    
}