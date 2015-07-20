package Echo.sinconexion.servidor;

import java.net.*;
/**
 * Una clase para utilizar con MiSocketDatagramaServidor para
 * devolver un mensaje y la direcci�n del emisor
 * @author M. L. Liu
 */
public class MensajeDatagrama{
	private String mensaje;
	private InetAddress direccionEmisor;
    private int puertoEmisor;
    public void fijaValor(String mensaje, InetAddress dir, int puerto) {
    	this.mensaje = mensaje;
    	this.direccionEmisor = dir;
    	this.puertoEmisor = puerto;
    }

    public String obtieneMensaje( ) {
    	return this.mensaje;
    }

    public InetAddress obtieneDireccion( ) {
    	return this.direccionEmisor;
    }

    public int obtienePuerto( ) {
    	return this.puertoEmisor;
    }
} //fin de class