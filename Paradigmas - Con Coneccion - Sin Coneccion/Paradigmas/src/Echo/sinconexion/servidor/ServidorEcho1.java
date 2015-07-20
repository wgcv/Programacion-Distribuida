package Echo.sinconexion.servidor;

/**
 * Este m�dulo contiene la l�gica de aplicaci�n de un servidor Echo
 * que utiliza un socket datagrama sin conexi�n para la comunicaci�n
 * entre procesos.
 * Se requiere un argumento de l�nea de mandato para el puerto del servidor.
 * @author M. L. Liu
 */

public class ServidorEcho1 {
	public static void main(String[] args) {
		int puertoServidor = 7; // n�mero de puerto por defecto
		if (args.length == 1 )
			puertoServidor = Integer.parseInt(args[0]);
		try {
			// instancia un socket datagrama para mandar
			// y recibir datos
			MiSocketDatagramaServidor miSocket = new MiSocketDatagramaServidor(puertoServidor);
			System.out.println("Servidor Echo listo.");
			while (true) { // bucle infinito
				MensajeDatagrama peticion = miSocket.recibeMensajeYEmisor();
				System.out.println("Petici�n recibida");
				String mensaje = peticion.obtieneMensaje( );
				System.out.println("mensaje recibido: "+ mensaje);
				// Ahora manda el eco al solicitador
				miSocket.enviaMensaje(peticion.obtieneDireccion( ),
									  peticion.obtienePuerto( ), mensaje);
			} //fin de  while
		} // fin de try
		catch (Exception ex) {
			ex.printStackTrace( );
		}
	} //fin de main
} // fin de class