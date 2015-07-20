package socketsconconexion.stream2capas;

import java.net.*;
import java.io.*;

/**
*    Este ejemplo ilustra la sintaxis b�sica del socket
*    en modo stream.
*    @author M. L. Liu
*/
public class SolicitanteConexion {

//  Una aplicaci�n que manda un mensaje usando un socket en modo stream.
//  Se esperan dos argumentos de l�nea de mandato, en orden:
//
//  <nombre de la m�quina del aceptador de la conexi�n>
//  <n�mero de puerto del aceptador de la conexi�n>

  public static void main(String[] args) {
    /*if (args.length != 2)
      System.out.println
      ("Este programa requiere dos argumentos de l�nea de mandato");
    else {*/
      try {
        args = new String[2];
        args[0] = "localhost";
        args[1] = "5000";
    	  String maquinaAceptadora = args[0];
        int puertoAceptador = Integer.parseInt(args[1]);
        // instancia un socket de datos
        MiSocketStream miSocket =
          new MiSocketStream(maquinaAceptadora, puertoAceptador);
/**/    System.out.println("Solicitud de conexi�n concedida");
        String mensaje = miSocket.recibeMensaje( );
/**/    System.out.println("Mensaje recibido:");
        System.out.println("\t" + mensaje);
        miSocket.close( );
/**/    System.out.println("socket de datos cerrado");
      } // fin de try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    //} // fin de else
  } // fin de main
} // fin de class
