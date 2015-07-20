package Daytime.conconexion.cliente;

import java.net.*;
import java.io.*;

/**
 *    Una clase de envoltura de Socket que contiene 
 *    m�todos para mandar y recibir mensajes.
 *    @author M. L. Liu
 */
public class MiSocketStream extends Socket {
	private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    MiSocketStream(String maquinaAceptadora, int puertoAceptador ) 
    		throws SocketException, IOException{
    	socket = new Socket(maquinaAceptadora, puertoAceptador );
    	establecerFlujos( );
    }

    MiSocketStream(Socket socket) throws IOException {
    	this.socket = socket;
    	establecerFlujos( );
    }

    private void establecerFlujos( ) throws IOException{
    	// obtiene un flujo de salida para leer del socket de datos
    	InputStream flujoEntrada = socket.getInputStream();
    	entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
    	OutputStream flujoSalida = socket.getOutputStream();
    	// crea un objeto PrintWriter para salida en modo car�cter
    	salida = new PrintWriter(new OutputStreamWriter(flujoSalida));
    }

    public void enviaMensaje(String mensaje) throws IOException {
    	salida.println(mensaje);
    	// La subsiguiente llamada al m�todo flush es necesaria para que
    	// los datos se escriban en el flujo de datos del socket antes
    	// de que se cierre el socket.
    	salida.flush();
    } // fin de enviaMensaje

    public String recibeMensaje( ) throws IOException {
    	// lee una l�nea del flujo de datos
    	String mensaje = entrada.readLine( );
    	return mensaje;
    } // fin de recibeMensaje

} //fin de class