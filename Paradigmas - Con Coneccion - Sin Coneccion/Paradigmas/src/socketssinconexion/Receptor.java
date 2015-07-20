package socketssinconexion;

 import java.net.*;
 import java.io.*;

  /**
  *    Este ejemplo ilustra las llamadas de m�todo b�sicas para sockets
  *    datagrama sin conexi�n.
  *    @author M. L. Liu
  */
  public class Receptor {
  
  //  Una aplicaci�n  que recibe un mensaje utilizando un socket datagrama 
  //  sin conexi�n.
  //  Se espera un argumento de l�nea de mandato:
  //  <n�mero de puerto del socket del receptor>
  //  Nota: se deber�a especificar el mismo n�mero de puerto 
  //  en los argumentos de l�nea de mandato del emisor.

    public static void main(String[] args) {
      /*if (args.length != 1)
        System.out.println
          ("Este programa requiere un argumento de l�nea de mandato.");
      else {*/
       
    	int puerto = Integer.parseInt("4000");
        final int MAX_LON = 10;
        // Esta es la longitud m�xima asumida en octetos 
        // del datagrama que se va a recibir.
        try {
          DatagramSocket miSocket = new DatagramSocket(puerto);
          // instancia un socket datagrama para recibir los datos 
          byte[ ] almacen = new byte[MAX_LON];
          DatagramPacket datagrama =
            new DatagramPacket(almacen, MAX_LON);
          miSocket.receive(datagrama);
          String mensaje = new String(almacen);
          System.out.println(mensaje);
          miSocket.close( );
        } // fin de try
        catch (Exception ex) {
          ex.printStackTrace( );
        } // fin de catch
      //} // fin de else
    } // fin de main
  } // fin de class
