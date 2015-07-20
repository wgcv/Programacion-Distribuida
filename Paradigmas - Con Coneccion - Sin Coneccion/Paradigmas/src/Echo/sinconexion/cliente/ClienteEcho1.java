package Echo.sinconexion.cliente;

import java.io.*;

/**
 * Este m�dulo contiene la l�gica de presentaci�n de un cliente Echo.
 * @author M. L. Liu
 */
public class ClienteEcho1 {
	static final String mensajeFin = ".";
    public static void main(String[ ] args) {
    	InputStreamReader is = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(is);
    	try {
    		System.out.println("Bienvenido al cliente Echo.\n" +
    						   "�Cu�l es el nombre de la m�quina servidora?");
    		String nombreMaquina = br.readLine();
    		if (nombreMaquina.length() == 0) // si el usuario no introdujo un nombre
    			nombreMaquina = "localhost"; // usa el nombre de m�quina por defecto
    		System.out.println("Introduzca el n� puerto de la m�quina servidora.");
    		String numPuerto = br.readLine( );
    		if (numPuerto.length() == 0)
    			numPuerto = "7"; // n�mero de puerto por defecto
    		ClienteEchoAuxiliar1 auxiliar = new ClienteEchoAuxiliar1(nombreMaquina, numPuerto);
    		boolean hecho = false;
    		String mensaje, eco;
    		while (!hecho) {
    			System.out.println("Introduzca una l�nea para recibir el eco "
    							   + "del servidor, o un �nico punto para terminar.");
    			mensaje = br.readLine( );
    			if ((mensaje.trim()).equals(mensajeFin)){
    				hecho = true;
    				auxiliar.hecho( );
    			}
    			else {
    				eco = auxiliar.obtenerEco(mensaje);
    				System.out.println(eco);
    			}
    		} // fin de while
    	} // fin de  try
    	catch (Exception ex) {
    		ex.printStackTrace( );
    	}
    } //fin de main
} // fin de class