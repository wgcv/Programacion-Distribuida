package ArchivosSockets.cliente;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de aplicaci�n
 * para un cliente Daytime que utiliza un socket en modo stream para IPC.
 * @author M. L. Liu
 */
public class ClienteDaytimeAuxiliar2 {

	public static String obtenerMarcaTiempo(String nombreMaquina,
     String numPuerto) throws Exception {

		String marcaTiempo = "";

		int puertoServidor = Integer.parseInt(numPuerto);
		// instancia un socket en modo stream y espera a que se haga 
		// una conexi�n al puerto servidor
	    /**/System.out.println("Petici�n de conexi�n realizada");
	    MiSocketStream miSocket = new MiSocketStream(nombreMaquina, puertoServidor);
            miSocket.enviaMensaje("c:\\");
	    // ahora espera hasta recibir la marca de tiempo
	    marcaTiempo = miSocket.recibeMensaje();
	    miSocket.close( ); // implica la desconexi�n
	    return marcaTiempo;
    } // fin
} // fin de class