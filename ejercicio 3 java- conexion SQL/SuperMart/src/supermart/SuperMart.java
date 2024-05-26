/*Autora: Antonella Alares*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermart;
import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author anto_
 */
public class SuperMart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*DATOS GLOBALES PARA SER UTILIZADOS A LO LARGO DEL MAIN*/
        Timestamp now = new Timestamp(System.currentTimeMillis()); /*Creamos un objeto de Timestamp llamado "now" para poder utilizarlo como valor de fechaCreacion cada vez que creas una Persona*/
        LocalDateTime localDateTime = now.toLocalDateTime();
       
        LocalDateTime localDateTime1 = now.toLocalDateTime().plus(1, ChronoUnit.DAYS);
        LocalDateTime localDateTime2 = now.toLocalDateTime().plus(5, ChronoUnit.DAYS);
        Timestamp estadoEnviado = Timestamp.valueOf(localDateTime1);
        Timestamp estadoRecibido = Timestamp.valueOf(localDateTime2);
        
        /*Para obtener la fechaEntrega del Pedido, utilizamos la misma fecha del Timestamp del estadoRecibido*/
        LocalDate fechaEntrega = localDateTime2.toLocalDate(); /*aquí obtenemos el Date del Timestamp de estadoRecibido*/
        /*aquí convertimos el Date de estadoRecibido a String para poder insertarlo como dato al crear un Pedido*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaEntregaString = fechaEntrega.format(formatter);
        
        /*Para obtener la fechaPedido del Pedido, utilizamos la misma fecha del Timestamp del estadoProcesando, que sería now*/
        LocalDate fechaPedido = localDateTime.toLocalDate(); /*aquí obtenemos el Date del Timestamp de estadoProcesando, que sería now*/
        /*aquí convertimos el Date de estadoProcesando a String para poder insertarlo como dato al crear un Pedido*/
        String fechaPedidoString = fechaPedido.format(formatter);
        
        
        /*PERSONAS*/
        
        /*Personas insertadas- están comentadas para que no se generen de nuevo cada vez que runneemos y/o den error*/
        /*Al crearse una persona, según el tipo (Usuario o Administrador, automáticamente se incorpora su id a la tabla correspondiente de Usuarios o Administradores*/
        
        /*Persona nuevaPersona1 = new Persona(1, "Juan", "Pérez", "Usuario", "12345678A", "juan@example.com", 123456789, "contrasena123", "1990-05-15", "Calle Principal 123");
        Persona nuevaPersona2 = new Persona(2,"María", "Gómez", "Usuario", "98765432B", "maria@example.com", 987654321, "password456", "1995-10-20", "Avenida Central 456");
        Persona nuevaPersona3 = new Persona(3,"Antonella", "Alares", "Administrador", "89015647J", "antonella@example.com", 876123456, "mysecretpassword123", "1991-04-30", "Avenida de la Estación 739");
        Persona nuevaPersona4 = new Persona(4, "Luis", "Martínez", "Usuario", "56789012C", "luis@example.com", 567890123, "pass123word", "1988-03-25", "Plaza Mayor 789");
        Persona nuevaPersona5 = new Persona(5, "Ana", "Sánchez", "Usuario", "34567890D", "ana@example.com", 345678901, "securepass", "1992-12-10", "Callejón Secreto 321");
        Persona nuevaPersona6 = new Persona(6, "Pedro", "Rodríguez", "Usuario", "90123456E", "pedro@example.com", 901234567, "mysecretpass", "1985-07-08", "Ronda de los Olivos 654");
        Persona nuevaPersona7 = new Persona(7,"Laura", "López", "Usuario", "23456789F", "laura@example.com", 234567890, "password123", "1987-09-30", "Avenida del Parque 987");
        Persona nuevaPersona8 = new Persona(8, "Carlos", "García", "Usuario", "78901234G", "carlos@example.com", 789012345, "pass1234", "1993-02-18", "Calle de las Flores 123");
        Persona nuevaPersona9 = new Persona(9, "Sofía", "Fernández", "Usuario", "67890123H", "sofia@example.com", 678901234, "mysecurepassword", "1998-06-05", "Paseo del Río 456");
        Persona nuevaPersona10 = new Persona(10, "David", "Hernández", "Usuario", "45678901I", "david@example.com", 456789012, "securepassword123", "1994-11-12", "Calle Mayor 456");
        Persona nuevaPersona11 = new Persona(11,"Elena", "Pérez",  "Usuario","89012345J", "elena@example.com", 890123456, "mysecretpassword123", "1991-04-28", "Avenida de la Estación 789");
        Persona nuevaPersona12 = new Persona(12,"Victor", "Martínez", "Administrador", "89018647J", "victor@example.com", 876122156, "mysecretpassword123", "1991-04-12", "Avenida de la Estación 29");*/
        
         PersonaDAO.printPersonaDetails();
        /*Date sqlDate = Date.valueOf("1991-02-20");
        System.out.println(sqlDate);*/ /*esta opción sería en caso que cada vez que crees una persona, en el dato FechaNacimiento quisieras poner una fecha, y no un String!*/
        
       
            
       /*Para eliminar Personas por su id*/
            //PersonaDAO.deletePersonaById(9);
       
       /*Para seleccionar el correo de una persona en concreto*/
            //nuevaPersona3.getCorreo();
       
       /*Para modificar el correo de una persona en concreto*/
            //nuevaPersona3.setCorreo("nuevomailejemplo@gmail.com");
       
       /*PRODUCTOS*/
       ProductoDAO.printProductoDetails();
       
       /*Productos insertados- están comentados para que no se generen de nuevo cada vez que runneemos y/o den error*/
            //Producto nuevoProducto1= new Producto("Crema Hidratante Boost", "Cuidado facial", 10.99, 40, now, "2025-07-15");
            //Producto nuevoProducto2= new Producto("Mascarilla Capilar Reparadora", "Cuidado del cabello", 15.99, 49, now, "2025-09-02");
     
       
       /*Para eliminar Productos por su id*/
           //ProductoDAO.deleteProductoById(18);
       
       /*Para seleccionar el precio de un producto en concreto*/
            //nuevoProducto2.getPrecio();
       
       /*Para modificar el precio de un producto en concreto*/
            //nuevoProducto2.setPrecio(14.99);
       
       /*USUARIOS*/
       UsuarioDAO.printUsuarioDetails();
            
       /*Para eliminar Usuarios por su id*/
            //UsuarioDAO.deleteUsuarioById(11);
       
            
       /*ADMINISTRADORES*/    
       
       AdministradorDAO.printAdministradorDetails();
       
       /*Para eliminar Administradores por su id*/
            //AdministradorDAO.deleteAdministradorById(15);
           
       
      /*PROMOCIONES*/
     
       /*Promociones insertadas- están comentadas para que no se generen de nuevo cada vez que ejecutemos y/o den error*/
            //Promocion nuevaPromocion1 = new Promocion(12, "Oferta especial: ¡compra 1 y lleva 2 en productos de protector solar!", 0.50, "2024-06-05", "2024-07-03"); 
      
            
       /*Para modificar el precio de descuento de una promoción en concreto - cuidado aquí se accede desde la clase y no la instancia!*/
            //PromocionDAO.updatePromocionPrecioDescuento(0.30, 15);
            
            
      /*Para eliminar Promociones por su id*/
            //PromocionDAO.deletePromocionById(20);
         
            
       /*Para seleccionar el texto de las promociones hechas por un administrador en concreto*/
            //PromocionDAO.getPromocionTextoByAdministrador(12);
            
       /*Para seleccionar el texto de una promoción en concreto*/
           //nuevaPromocion1.getTextoPromocion();
    
        PromocionDAO.printPromocionDetails();
           
       /*TARJETAS*/
        TarjetaDAO.printTarjetaDetails();
        
        /*Tarjetas insertadas- están comentadas para que no se generen de nuevo cada vez que ejecutemos y/o den error*/
            //Tarjeta nuevaTarjeta1 = new Tarjeta(2, "2345678901234578", 2345, "2026-06-01");  
        
        
        /*Para eliminar Tarjetas por su id*/
            //TarjetaDAO.deleteTarjetaById(8);
        
        
        /*Para seleccionar el numero de tarjeta de una tarjeta en concreto por su id de usuario*/
           //nuevaTarjeta1.getNumero();    
        
        /*Para modificar la fecha de Caducidad de una tarjeta en concreto*/
            //nuevaTarjeta1.setFechaCaducidad("2026-06-20");
            
            
    /*NOTIFICACIONES de las promociones - se envían por defecto del sistema a todos los usuarios*/
     
     /*Notificaciones creadas- están comentadas para que no se generen de nuevo cada vez que ejecutemos y/o den error*/
            //Notificacion nuevaNotificacion1 = new Notificacion(11, "¡Aprovecha nuestro descuento del 10% en productos de protector solar!", "2024-05-21"); 
     
     /*Para eliminar Notificaciones por su id*/
            //NotificacionDAO.deleteNotifacionById(9);
    
    /*Para modificar el texto de una Notificación en concreto*/
            //nuevaNotificacion1.setTexto("nuevo texto de Notificación");
    
    /*Para seleccionar la fecha de una notificación en concreto*/
            //nuevaNotificacion1.getFecha();
            
    /*Para seleccionar la fecha de una notificación en concreto por su ID*/        
             //nuevaNotificacion1.getFechaById(11);
            
    NotificacionDAO.printNotificacionDetails();
    
     /*PEDIDOS*/
     
     PedidoDAO.printPedidoDetails();
     
     
     /*Para eliminar Pedidos por su id*/
            //PedidoDAO.deletePedidoById(13); /*cuidado! para poder eliminar un pedido, no ha debido estar procesado, por ejemplo si deseamos eliminar el pedido con id = 14, no nos dejará!*/
     
    
    /*Se crea 1 pedido*/
            //Pedido pedido1 = new Pedido(2, 2); /* guía para construir pedido: (idUsuario, idTarjeta)- este pedido tiene id = 14*/
    
    /*Se añaden los productos al pedido que se ha creado con id = 14*/
         /* Pedido.anadirProductoPedido(14, 0, 3, 4); // guía para rellenar los campos(id_pedido, id_promocion, id_producto, cantidad)
            Pedido.anadirProductoPedido(14, 0, 9, 4);
            Pedido.anadirProductoPedido(14, 0, 2, 1);
            Pedido.anadirProductoPedido(14, 0, 5, 8);*/
    
    /*Una vez creado el Pedido, y añadido los productos, se pasa a procesar el pedido, en el cual se añaden la cantidad total de productos del pedido (suma de las cantidades de cada producto) y el precio total del pedido(suma y multiplicación de los respectivos precios de cada producto del pedido)*/       
    
    /*Para procesar el pedido con id = 14 - se ha de poner un id de un pedido que ya exista (en este caso utilizamos el creado anteriormente)!*/        
            //Pedido.procesarPedido(14);
            
    /*Para confirmar el envío del pedido con id = 14*/        
            //Pedido.confirmarEnviado(14);
            
    /*Para confirmar la entrega del pedido con id = 14*/
            //Pedido.confirmarEntrega(14);
            
    /*Para cancelar el pedido con id = 14* ---aquí te ha de decir que no se puede cancelar ya que se ha confirmado la entrega!*/
            //Pedido.cancelarPedido(14);
    
            /*Pedido.procesarPedido(15);- no te crea el pedido porque aquí solo updatea el pedido, primero se tendría que crear el pedido con id = 15.Cuidado aquí con la lógica:  no confundir el carrito de compra con el pedido(no es lo mismo) */
           PedidoDAO.printPedidoDetails();
            
    
    
    /*REPORTES - cada reporte se realiza únicamente por 1 pedido*/
    
    /*Para realizar un reporte sobre un pedido (únicamente sobre un Pedido que ya ha sido finalizado, es decir, ya ha sido entregado)*/
      // guía para rellenar campos y crear reporte: Reporte.realizarReporte(id_reporte, id_pedido, id_administrador, nombre, tipo, texto);
      //Reporte.realizarReporte(1, 14, 3, "Reporte del pedido con id 14", "Ventas", "Informe de las ventas realizadas en el pedido 14");
      Reporte.realizarReporte(2, 11, 12, "Reporte del pedido con id 13", "Ventas", "Informe de las ventas realizadas en el pedido 13");; /*aquí no se puede realizar reporte de este pedido, porque aún no ha sido recibido!*/
      
    
     /*Para eliminar Reportes por su id*/
            //ReporteDAO.deleteReporteById(12);
      
     /*Para modificar el texto de un Reporte en concreto*/
            //nuevoReporte1.setTexto("nuevo texto de Reporte");
     
     /*Para seleccionar el nombre del Reporte en concreto*/
            //nuevoReporte1.getNombre(); 
            
      
     
      ReporteDAO.printReporteDetails();
    }
    
}
