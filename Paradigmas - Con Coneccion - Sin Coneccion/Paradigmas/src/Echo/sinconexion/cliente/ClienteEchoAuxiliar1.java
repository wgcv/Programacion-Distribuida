package Echo.sinconexion.cliente;

import java.net.*;
import java.io.*;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de aplicaci�n 
 * para un cliente Echo utilizando un socket datagrama sin conexi�n.
 * @author M. L. Liu
 */
public class ClienteEchoAuxiliar1 {
	private MiSocketDatagramaCliente miSocket;
    private InetAddress maquinaServidora;
    private int puertoServidor;

    ClienteEchoAuxiliar1(String nombreMaquina, String numPuerto)
    		throws SocketException, UnknownHostException {
    	this.maquinaServidora = InetAddress.getByName(nombreMaquina);
    	this.puertoServidor = Integer.parseInt(numPuerto);
    	// instancia un socket datagrama para mandar
    	// y recibir datos
    	this.miSocket = new MiSocketDatagramaCliente();
    }

    public String obtenerEco(String mensaje)
    		throws SocketException, IOException {
    	String eco = "";
    	miSocket.enviaMensaje( maquinaServidora, puertoServidor, mensaje);
        // ahora recibe el eco
        eco = miSocket.recibeMensaje();
        return eco;
    } // fin de obtenerEco

    public void hecho( ) throws SocketException {
    	miSocket.close( );
    } // fin de hecho

} // fin de class