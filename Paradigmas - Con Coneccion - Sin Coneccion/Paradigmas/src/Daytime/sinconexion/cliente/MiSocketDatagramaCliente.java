package Daytime.sinconexion.cliente;


import java.net.*;
import java.io.*;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de servicios
 * Una subclase de DatagramSocket que contiene
 * m�todos para enviar y recibir mensajes
 * @author M. L. Liu
 */
public class MiSocketDatagramaCliente extends DatagramSocket {
	static final int MAX_LON = 100;
    MiSocketDatagramaCliente( ) throws SocketException{
    	super( );
    }

    MiSocketDatagramaCliente(int numPuerto) throws SocketException{
    	super(numPuerto);
    }

    public void enviaMensaje(InetAddress maquinaReceptora,
    						 int puertoReceptor, String mensaje) throws IOException {
    	byte[ ] almacenEnvio = mensaje.getBytes( );
    	DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length,
    												  maquinaReceptora, puertoReceptor);
      this.send(datagrama);
    } // fin de enviaMensaje

    public String recibeMensaje( ) throws IOException {
    	byte[ ] almacenRecepcion = new byte[MAX_LON];
    	DatagramPacket datagram = new DatagramPacket(almacenRecepcion, MAX_LON);
    	this.receive(datagram);
    	String mensaje = new String(almacenRecepcion);
    	return mensaje;
    } // fin de recibeMensaje
} // fin de class