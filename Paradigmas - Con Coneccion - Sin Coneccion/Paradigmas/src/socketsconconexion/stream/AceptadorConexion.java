package socketsconconexion.stream;

import java.net.*;
import java.io.*;

/**
*    Este ejemplo ilustra la sintaxis b�sica del socket
*    en modo stream.
*    @author M. L. Liu
*/
public class AceptadorConexion {

//  Una aplicaci�n que acepta una conexi�n y recibe un mensaje
//     utilizando un socket en modo stream.
//  Se esperan dos argumentos de l�nea de mandato, en orden:
//  <n�mero de puerto del socket de servidor utilizado en este proceso>
//  <mensaje, una cadena, para mandar>

 public static void main(String[] args) {
   /*if (args.length != 2)
     System.out.println
     ("Este programa requiere dos argumentos de l�nea de mandato");
   else {*/
     try {
       args = new String[2];
       args[0] = "5000";
       args[1] = "hola mundo";
       int numPuerto = Integer.parseInt(args[0]);
       String mensaje = args[1];
       // instancia un socket para aceptar la conexi�n
       ServerSocket socketConexion = new ServerSocket(numPuerto);
/**/    System.out.println("preparado para aceptar una conexi�n");
       // espera una petici�n de conexi�n, instante en el cual
       // se crea un socket de datos
       Socket socketDatos = socketConexion.accept();
/**/    System.out.println("conexi�n aceptada");
       // obtiene un flujo de salida para escribir en el socket de datos
       OutputStream flujoSalida = socketDatos.getOutputStream();
       // crea un objeto PrintWriter para la salida en modo car�cter
       PrintWriter salidaSocket =
         new PrintWriter(new OutputStreamWriter(flujoSalida));
       // escribe un mensaje en el flujo de datos
       salidaSocket.println(mensaje);
       // La subsiguiente llamada al m�todo flush es necesaria para que
       // los datos se escriban en el flujo de datos del socket antes 
       // de que se cierre el socket.
       salidaSocket.flush();
/**/    System.out.println("mensaje enviado");
       socketDatos.close( );
/**/    System.out.println("socket de datos cerrado");
       socketConexion.close( );
/**/    System.out.println("socket de conexi�n cerrado");
     } // end try
     catch (Exception ex) {
         ex.printStackTrace( );
     } // fin de catch
   //} // fin de else
 } // fin de main
} // fin de class

