package socketsconconexion.unilateral;

import java.net.*;


/**
*    Este ejemplo ilustra la sintaxis b�sica de los sockets datagrama
*    orientados a conexi�n.
*    @author M. L. Liu
*/
public class Receptor {

//  Una aplicaci�n que utiliza un socket datagrama orientado a conexi�n
//  para recibir m�ltiples mensajes, despu�s env�a uno.
//  Se esperan cuatro argumentos de l�nea de mandato, en orden:
//  <nombre de dominio o direcci�n IP del emisor>
//  <n�mero de puerto del socket datagrama del emisor>
//  <n�mero de puerto del socket datagrama de este proceso>
//  <mensaje, una cadena, para mandar>

 public static void main(String[ ] args) {
   /*if (args.length != 4)
     System.out.println
     ("Este programa requiere 4 argumentos de l�nea de mandato");
   else {*/
     try {
    	args = new String[4];
    	args[0] = "127.0.0.1";
    	args[1] = "5000";
    	args[2] = "4000";
    	args[3] = "Respuesta";
    	
       InetAddress maquinaEmisora = InetAddress.getByName(args[0]);
       int puertoEmisor = Integer.parseInt(args[1]);
       int miPuerto = Integer.parseInt(args[2]);
       String mensaje = args[3];
       // instancia un socket datagrama para recibir los datos
       MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
       // hace una conexi�n con el socket del emisor 
       miSocket.connect(maquinaEmisora, puertoEmisor);
       for (int i=0; i<10; i++)
         System.out.println(miSocket.recibeMensaje( ));
       // ahora manda un mensaje al otro extremo
       miSocket.enviaMensaje( maquinaEmisora, puertoEmisor, mensaje);
       miSocket.close( );
     } // fin de try
     catch (Exception ex) {
       ex.printStackTrace( );
     } // fin de catch
   //} // fin de else
 } // fin de main
} // fin de class

