package Echo.conconexion.cliente;

import java.net.*;
import java.io.*;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de aplicaci�n
 * para un cliente Echo utilizando un socket en modo stream.
 * @author M. L. Liu
 */

public class ClienteEchoAuxiliar2 {

	static final String mensajeFin = ".";
    private MiSocketStream miSocket;
    private InetAddress maquinaServidora;
    private int puertoServidor;

    ClienteEchoAuxiliar2(String nombreMaquina, String numPuerto) 
    		throws SocketException, UnknownHostException, IOException {

    	this.maquinaServidora = InetAddress.getByName(nombreMaquina);
    	this.puertoServidor = Integer.parseInt(numPuerto);
    	// instancia un socket en modo stream y espera por una conexi�n.
    	this.miSocket = new MiSocketStream(nombreMaquina, this.puertoServidor);
    	/**/System.out.println("Petici�n de conexi�n hecha");
    } // fin de constructor

    public String obtenerEco( String mensaje) throws SocketException, IOException {
    	String eco = "";
    	miSocket.enviaMensaje( mensaje);
    	// ahora recibe el eco 
    	eco = miSocket.recibeMensaje();
    	return eco;
    } //fin de obtenerEco

    public void hecho( ) throws SocketException, IOException{
    	miSocket.enviaMensaje(mensajeFin);
    	miSocket.close( );
    } // fin de hecho
} // fin de class