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
public class Tarjeta {
    private int idUsuario;
    private String numero;
    private int clave;
    private String fechaCaducidad;
    
    public Tarjeta(int idUsuario, String numero, int clave, String fechaCaducidad){
    this.idUsuario = idUsuario;
    this.numero = numero;
    this.clave = clave;
    this.fechaCaducidad = fechaCaducidad;
    
    TarjetaDAO.insertTarjeta(this.idUsuario, this.numero, this.clave, this.fechaCaducidad);
    }

    public String getNumero() {
        System.out.println("Tarjetas del usuario con id " + this.idUsuario);
        return TarjetaDAO.getNumeroTarjeta(this.idUsuario);
    }

    public void setFechaCaducidad(String nuevaFechaCaducidad) {
        TarjetaDAO.updateFechaCaducidad(nuevaFechaCaducidad, this.numero);
    }
    
    
    
    
    
    
}


