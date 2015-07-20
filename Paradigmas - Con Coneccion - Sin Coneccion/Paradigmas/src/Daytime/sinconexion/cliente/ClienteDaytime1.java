package Daytime.sinconexion.cliente;

import java.io.*;


/**
 * Este m�dulo contiene la l�gica de presentaci�n de un ClienteDaytime.
 * @author M. L. Liu
 */
public class ClienteDaytime1 {
	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
        	System.out.println("Bienvenido al cliente Daytime.\n" +
        			           "�Cu�l es el nombre de la m�quina servidora?");
        	String nombreMaquina = br.readLine( );
        	if (nombreMaquina.length() == 0) // si el usuario no introduce un nombre
        		nombreMaquina = "localhost"; // usa el nombre de m�quina por defecto
        	System.out.println("�Cu�l es el n� de puerto de la m�quina servidora?");
        	String numPuerto = br.readLine();
        	if (numPuerto.length () == 0)
        		numPuerto = "13"; // n�mero de puerto por defecto
        	System.out.println("Aqu� est� la marca de tiempo recibida del servidor: "
        						+ ClienteDaytimeAuxiliar1.obtenerMarcatiempo(nombreMaquina,numPuerto));
        } // fin de try
        catch (Exception ex) {
        	ex.printStackTrace( );
        } // fin de catch
	} // fin de main
} // fin de class
