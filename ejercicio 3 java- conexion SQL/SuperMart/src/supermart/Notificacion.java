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
public class Notificacion {
 private int idPromocion;
 private String texto;
 private String fecha;

    public Notificacion(int idPromocion, String texto, String fecha) {
        this.idPromocion = idPromocion;
        this.texto = texto;
        this.fecha = fecha;
        
        NotificacionDAO.insertNotificacion(this.idPromocion, this.texto, this.fecha);
    }

    public String getFecha() {
        return NotificacionDAO.getfechaNotificacion(this.idPromocion,this.texto);
    }

    public void setTexto(String nuevoTexto) {
        NotificacionDAO.updateTexto(nuevoTexto, this.idPromocion, this.fecha);
    }
    
    public String getFechaById(int id) {
        return NotificacionDAO.getfechaNotificacionById(id);
    }
 
 
 
}
