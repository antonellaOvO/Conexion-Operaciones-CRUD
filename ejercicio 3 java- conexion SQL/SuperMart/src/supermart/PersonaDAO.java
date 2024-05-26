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
public class PersonaDAO {
    
    public static void printPersonaDetails() {
   String query = "SELECT * FROM Personas;";
   try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query)){
       
       while(rs.next()) {
       int id = rs.getInt("id_persona");
       String nombrePersona = rs.getString("nombre_persona");
       String apellidoPersona = rs.getString("apellido_persona");
       String dniPersona = rs.getString("DNI");
       String correoPersona = rs.getString("correo_persona");
       int telefonoPersona = rs.getInt("telefono_persona");
       String contrasenaPersona = rs.getString("contrasena_persona");
       Date fechaNacimientoPersona = rs.getDate("fechaNacimiento_persona");
       String direccionPersona = rs.getString("direccion_persona");
       Timestamp fechaCreacionPersona = rs.getTimestamp("fechaCreacion_persona");
       
       System.out.println("ID: " + id + ", nombre persona: " + nombrePersona + ", apellido persona: " + apellidoPersona + ", dni persona: " + dniPersona + ", correo persona: " + correoPersona + ", telefono persona: " + telefonoPersona + ", contraseña persona: " + contrasenaPersona + ", fecha de Nacimiento persona: " + fechaNacimientoPersona + ", direccion de persona: " + direccionPersona + ", fecha de Creación de persona: " + fechaCreacionPersona );
       
       }
   
   } catch(SQLException e){
       e.printStackTrace();
    }        
   
   } 
    
    
     public static void insertPersona(int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion) {
  String query = "INSERT INTO Personas (id_persona, nombre_persona, apellido_persona, tipo, DNI, correo_persona, telefono_persona, contrasena_persona, fechaNacimiento_persona, direccion_persona) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
  try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
      
       Date sqlDate = Date.valueOf(fechaNacimiento);
      
      pstmt.setInt(1,id_persona);
      pstmt.setString(2,nombre); /*1 de campo 1 de la query*/
      pstmt.setString(3, apellido); /*2 de campo 2 de la query*/
      pstmt.setString(4, tipo);
      pstmt.setString(5, dni); /*3 de campo 3 de la query*/
      pstmt.setString(6, correo);
      pstmt.setInt(7, telefono);
      pstmt.setString(8, contrasena);
      pstmt.setDate(9, sqlDate);
      pstmt.setString(10, direccion);
      
      
      pstmt. executeUpdate();
      System.out.println("Nueva persona insertada: ");
      
  }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    }  
  }
     
  public static String getTipo(int id_persona){
        String tipo = "";
        String query = "SELECT tipo FROM Personas WHERE id_persona = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setInt(1,id_persona);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                tipo = rs.getString("tipo");
                System.out.println(" Persona de tipo: " + tipo );
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return tipo;  
    }
  
  
     
    
    public static void insertPersonaEnTablaCorrecta(int id_persona){ 
    
    String tipo = PersonaDAO.getTipo(id_persona);
    
    if("Usuario".equals(tipo)){
    UsuarioDAO.insertUsuario(id_persona);
    System.out.println("La persona con id: " + id_persona + " se ha insertado como Usuario con id: " + id_persona);
    }else{
    AdministradorDAO.insertAdministrador(id_persona);
    System.out.println("La persona con id: " + id_persona + " se ha insertado como Administrador con id: " + id_persona);
    }
    
    }
    
   public static void CrearAsignarPersona(int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion){
   PersonaDAO.insertPersona(id_persona, nombre, apellido, tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }
     
     
     
    public static void deletePersonaById(int id) {
    String query = "DELETE FROM Personas WHERE id_persona =?;";
    try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }catch(SQLException e){
          e.printStackTrace();
       } 
         
 }
    
    public static void updatePersonaCorreo(String nombre, String apellido, String correo){
     String query = "UPDATE Personas SET correo_persona = ? WHERE nombre_persona = ? AND apellido_persona = ?;";
     try(Connection conn = DatabaseConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query)){
         pstmt.setString(1,correo);
         pstmt.setString(2, nombre);
          pstmt.setString(3, apellido);
         pstmt.executeUpdate();
         System.out.println("Nuevo correo " + correo + " actualizado");
     
     }catch(SQLException e){
       e.printStackTrace(); /*aquí te daría el error que te daría en SQL*/
    } 
     
 }
    
    public static String getPersonaCorreo(String nombre, String apellido){
        String email = "";
        String query = "SELECT correo_persona FROM Personas WHERE nombre_persona = ? AND apellido_persona = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){

                pstmt.setString(1,nombre);
                pstmt.setString(2,apellido);

                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                email = rs.getString("correo_persona");
                System.out.println(" email: " + email );
                }        

        }catch(SQLException e){
            e.printStackTrace();
        }
                 return email;  
    }
    
    
    
}
