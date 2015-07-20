package Echo.sinconexion.servidor;

import java.net.*;
import java.io.*;

/**
 * Una subclase de DatagramSocket que contiene
 * m�todos para mandar y recibir mensajes 
 * @author M. L. Liu
 */
public class MiSocketDatagramaServidor extends DatagramSocket {
	static final int MAX_LON = 100;
    MiSocketDatagramaServidor(int numPuerto) throws SocketException{
    	super(numPuerto);
    }
    public void enviaMensaje(InetAddress maquinaReceptora,
    						 int puertoReceptor,
    						 String mensaje) throws IOException {
      byte[ ] almacenEnvio = mensaje.getBytes( );
      DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length,
    		  										maquinaReceptora, puertoReceptor);
      this.send(datagrama);
    } // fin de enviaMensaje

    public String recibeMensaje( ) throws IOException {
    	byte[ ] almacenRecepcion = new byte[MAX_LON];
    	DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, MAX_LON);
    	this.receive(datagrama);
    	String mensaje = new String(almacenRecepcion);
    	return mensaje;
    } //fin de recibeMensaje

    public MensajeDatagrama recibeMensajeYEmisor( ) throws IOException {
    	byte[ ] almacenRecepcion = new byte[MAX_LON];
    	DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, MAX_LON);
    	this.receive(datagrama);
    	// crea un objeto MensajeDatagrama, para contener
    	// el mensaje recibido y la direcci�n del emisor
    	MensajeDatagrama valorDevuelto = new MensajeDatagrama( );
    	valorDevuelto.fijaValor(new String(almacenRecepcion),
    							datagrama.getAddress( ),
    							datagrama.getPort( ));
    	return valorDevuelto;
    } //fin de recibeMensaje
} //fin de class