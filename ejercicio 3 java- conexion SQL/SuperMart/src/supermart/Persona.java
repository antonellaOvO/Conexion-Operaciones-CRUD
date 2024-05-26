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
public class Persona {
    private int id_persona;
    private String nombre;
    private String apellido;
    private String tipo;
    private String dni;
    private String correo;
    private int telefono;
    private String contrasena;
    private String fechaNacimiento;
    private String direccion;
    private Timestamp fechaCreacion;
    
    
    public Persona (int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion){
    this.id_persona = id_persona;
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipo = tipo;
    this.dni = dni;
    this.correo = correo;
    this.telefono = telefono;
    this.contrasena = contrasena;
    this.fechaNacimiento = fechaNacimiento;
    this.direccion = direccion;
    
    PersonaDAO.CrearAsignarPersona(id_persona, nombre, apellido, tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
    //PersonaDAO.insertPersona(id_persona, nombre, apellido,tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
    
    }
    
    public String getCorreo(){
        return PersonaDAO.getPersonaCorreo(this.nombre, this.apellido);
    }
    
     public String getTipo(){
        return PersonaDAO.getTipo(this.id_persona);
    }
     
     
   
   public void setCorreo(String nuevoCorreo){
   PersonaDAO.updatePersonaCorreo(this.nombre,this.apellido, nuevoCorreo);
   }
   
   
   public static void CrearAsignarPersona(int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion){
   PersonaDAO.insertPersona(id_persona, nombre, apellido, tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }
   
   public static void insertPersonaEnTablaCorrecta(int id_persona){
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }
   
   
    
}
