package Echo.conconexion.servidor;

import java.net.*;

/**
 * Este m�dulo contiene la l�gica de aplicaci�n de un servidor Echo
 * que utiliza un socket en modo stream para comunicarse entre procesos.
 * Se requiere un argumento de l�nea de mandato para el puerto del servidor.
 * @author M. L. Liu
 */

public class ServidorEcho2 {
	static final String mensajeFin = ".";
    public static void main(String[] args) {
    	int puertoServidor = 7; // puerto por defecto
    	String mensaje;

    	if (args.length == 1 )
    		puertoServidor = Integer.parseInt(args[0]);
    	try {
    		// instancia un socket stream para aceptar
    		// las conexiones
    		ServerSocket miSocketConexion = new ServerSocket(puertoServidor);
    		/**/  System.out.println("Servidor Echo listo.");
    		while (true) { // bucle infinito
    			// espera para aceptar una conexi�n
    			/**/    System.out.println("Espera una conexi�n.");
    			MiSocketStream miSocketDatos = new MiSocketStream(miSocketConexion.accept( ));
    			/**/    System.out.println("conexi�n aceptada");
    			boolean hecho = false;
    			while (!hecho) {
    				mensaje = miSocketDatos.recibeMensaje( );
    				/**/      System.out.println("mensaje recibida: "+ mensaje);
    				if ((mensaje.trim()).equals (mensajeFin)){
    					// la sesi�n se termina, se cierra el socket de datos.
    					/**/        System.out.println("Final de la sesi�n.");
    					miSocketDatos.close( );
    					hecho = true;
    				} // fin de if
    				else {
    					// Ahora manda el eco al solicitante
    					miSocketDatos.enviaMensaje(mensaje);
    				} // fin de else
    			} // fin de while !hecho
    		} // fin de while infinito
    	} // fin de try
    	catch (Exception ex) {
    		ex.printStackTrace( );
    	} // fin de catch
    } // fin de main
} // fin de class