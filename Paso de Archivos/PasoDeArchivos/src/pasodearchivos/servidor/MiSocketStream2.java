package pasodearchivos.servidor;

import pasodearchivos.cliente.*;
import java.net.*;
import java.io.*;

/**
 *    Una clase de envoltura de Socket que contiene 
 *    m�todos para mandar y recibir mensajes.
 *    @author M. L. Liu
 */
public class MiSocketStream2 extends Socket {
	private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;

    MiSocketStream2(String maquinaAceptadora, int puertoAceptador ) 
    		throws SocketException, IOException{
    	socket = new Socket(maquinaAceptadora, puertoAceptador );
    	establecerFlujos( );
    }

    MiSocketStream2(Socket socket) throws IOException {
    	this.socket = socket;
    	establecerFlujos( );
    }

    private void establecerFlujos( ) throws IOException{
    	// obtiene un flujo de salida para leer del socket de datos
    	InputStream flujoEntrada = socket.getInputStream();
        entrada = new DataInputStream(flujoEntrada);
        
    	//entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
    	OutputStream flujoSalida = socket.getOutputStream();
        salida = new DataOutputStream(flujoSalida);
    	// crea un objeto PrintWriter para salida en modo car�cter
    	//salida = new PrintWriter(new OutputStreamWriter(flujoSalida));}
    }

    public void enviaMensaje(int mensaje) throws IOException {
        salida.write(mensaje);
    	// La subsiguiente llamada al m�todo flush es necesaria para que
    	// los datos se escriban en el flujo de datos del socket antes
    	// de que se cierre el socket.
    	salida.flush();
    } // fin de enviaMensaje

    public int recibeMensaje( ) throws IOException {
    	// lee una l�nea del flujo de datos
    	int mensaje = entrada.read();
    	return mensaje;
    } // fin de recibeMensaje

} //fin de class