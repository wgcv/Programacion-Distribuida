package Daytime.sinconexion.cliente;

import java.net.*;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de aplicaci�n 
 * de un cliente de Daytime.
 * @author M. L. Liu
 */
public class ClienteDaytimeAuxiliar1 {

	public static String obtenerMarcatiempo(String nombreMaquina, String numPuerto) {

      String marcaTiempo = "";
      try {
    	  InetAddress serverHost = InetAddress.getByName(nombreMaquina);
    	  int serverPort = Integer.parseInt(numPuerto);
    	  // instancia un socket datagrama para tanto los datos de
    	  // emisi�n como los de recepci�n
    	  MiSocketDatagramaCliente miSocket = new MiSocketDatagramaCliente();
    	  miSocket.enviaMensaje( serverHost, serverPort, "");
    	  // ahora recibe la marca de tiempo
    	  marcaTiempo = miSocket.recibeMensaje();
    	  miSocket.close( );
      	} // fin de  try
      	catch (Exception ex) {
      		ex.printStackTrace( );
      	} // fin de catch
      return marcaTiempo;
	} //fin de main
} // fin de class