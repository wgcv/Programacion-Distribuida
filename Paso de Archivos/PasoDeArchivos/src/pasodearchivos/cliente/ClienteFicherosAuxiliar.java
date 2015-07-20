package pasodearchivos.cliente;

import pasodearchivos.cliente.MiSocketStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Esta clase es un m�dulo que proporciona la l�gica de aplicaci�n
 * para un cliente Daytime que utiliza un socket en modo stream para IPC.
 * @author M. L. Liu
 */
public class ClienteFicherosAuxiliar {

	public static String obtenerInfoFichero(String nombreMaquina,
										    String numPuerto) throws Exception {

		String infoFichero = "";

		int puertoServidor = Integer.parseInt(numPuerto);
		// instancia un socket en modo stream y espera a que se haga 
		// una conexi�n al puerto servidor
	    /**/System.out.println("Petici�n de conexi�n realizada");
	    //MiSocketStream miSocket = new MiSocketStream(nombreMaquina, puertoServidor);
	    MiSocketStream2 miSocket2 = new MiSocketStream2(nombreMaquina, puertoServidor);
            /*
            String directorio = miSocket.recibeMensaje();
            File f = new File(directorio);
            String[] contenido = f.list();
            for (int i=0; i<contenido.length; i++)
                System.out.println(contenido[i]);
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String fichero = br.readLine();
	    miSocket.enviaMensaje(fichero);
	    // ahora espera hasta recibir la info del fichero
	    infoFichero = miSocket.recibeMensaje();
                    */
            String directorio = "C:\\Users\\Estudiante\\Documents\\";
            String fichero = "prueba.txt";
            File input = new File(directorio+fichero);
            FileInputStream inputs = new FileInputStream(input);
            int leido;
            while ((leido=inputs.read())!=-1){
                miSocket2.enviaMensaje(leido);
            }
	    miSocket2.close( ); // implica la desconexi�n
            inputs.close();
	    return infoFichero;
    } // fin
} // fin de class