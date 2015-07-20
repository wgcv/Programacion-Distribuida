package multichat;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Este m�dulo est� dise�ado para usarse con un servidor Echo concurrente.
 * Su m�todo run lleva a cabo la l�gica de una sesi�n de cliente.
 * @author M. L. Liu
 */
class HiloServidorchatRecibir implements Runnable {
	static final String mensajeFin = ".";
    MiSocketStream miSocketDatos;
    int id;

    HiloServidorchatRecibir (MiSocketStream miSocketDatos, int id) {
    	this.miSocketDatos = miSocketDatos;
        this.id = id;
    } // fin de constructor

    public void run( ) {
           boolean seguir = true;
                 String recibido;
                String enviado;
   InputStreamReader is = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(is);
    	try {
               seguir = true;
    		while (seguir) {
                        
                   
                        recibido = miSocketDatos.recibeMensaje();
                        System.out.println("Cliente"+id +" :"+ recibido);
                        if (recibido.equalsIgnoreCase("exit()")) {
                            seguir = false;
                        }
            
                    }
                miSocketDatos.close();
    	} // fin de try
    	catch (Exception ex) {
    		System.out.println("Excepci�n capturada en hilo: " + ex);
    	} // fin de catch
    } // fin de run
} // fin de class