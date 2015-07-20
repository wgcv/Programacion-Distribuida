package socketssinconexionMod;

import java.net.*;
import java.io.*;



/**
 *    Este ejemplo ilustra las llamadas de m�todo b�sicas para sockets
 *    datagrama sin conexi�n
 *    @author M. L. Liu
 */
public class Emisor {

//  Una aplicaci�n que manda un mensaje utilizando un socket datagrama
//  sin conexi�n.
//  Se esperan tres argumentos de l�nea de mandato, en orden:
// <nombre del dominio o direcci�n IP del receptor>
// <n�mero del puerto del socket del receptor>
// <mensaje, una cadena, para mandar>

	public static void main(String[ ] args) {
      /*if (args.length != 3)
        System.out.println
          ("Este programa requiere 3 argumentos de l�nea de mandato");
      else {*/
     
         while(true){
   for(int x = 101; x < 150; x = x+1) {
       String a = "172.16.8."+x;
            try {
              InetAddress maquinaReceptora = InetAddress.getByName(a);


          int puertoReceptor = Integer.parseInt("4000");
          String mensaje = "ERROR 69";

          // instancia un socket datagrama para mandar los datos
          DatagramSocket miSocket = new DatagramSocket( );
          byte[ ] almacen = mensaje.getBytes( );
          DatagramPacket datagrama =
            new DatagramPacket(almacen, almacen.length,
              maquinaReceptora, puertoReceptor);
          miSocket.send(datagrama);
          miSocket.close( );
        } // fin de try
        catch (Exception ex) {
          ex.printStackTrace( );
        } // fin de catch
      //} // fin de else
        
    } // fin de main
            }}
  } // fin de class
