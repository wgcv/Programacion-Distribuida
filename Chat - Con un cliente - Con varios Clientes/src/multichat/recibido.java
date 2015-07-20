package multichat;


/**
 * Este m�dulo est� dise�ado para usarse con un servidor Echo concurrente.
 * Su m�todo run lleva a cabo la l�gica de una sesi�n de cliente.
 * @author M. L. Liu
 */
class HiloServidorEcho implements Runnable {
	static final String mensajeFin = ".";
    MiSocketStream miSocketDatos;

    HiloServidorEcho (MiSocketStream miSocketDatos) {
    	this.miSocketDatos = miSocketDatos;
    } // fin de constructor

    public void run( ) {
    	boolean hecho = false;
    	String mensaje;
    	try {
    		while (!hecho) {
    			mensaje = miSocketDatos.recibeMensaje( );
    			/**/    System.out.println("mensaje recibido: "+ mensaje);
    			if ((mensaje.trim()).equals (mensajeFin)){
    				// se termina la sesi�n; cierra el socket de datos
    				/**/      System.out.println("Final de la sesi�n.");
    				miSocketDatos.close( );
    				hecho = true;
    			} //fin de if
    			else {
    				// Ahora manda el eco al solicitante
    				miSocketDatos.enviaMensaje(mensaje);
    			} // fin de else
    		} // fin de while !hecho
    	} // fin de try
    	catch (Exception ex) {
    		System.out.println("Excepci�n capturada en hilo: " + ex);
    	} // fin de catch
    } // fin de run
} // fin de class