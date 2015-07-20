package pasodearchivos.servidor;

import java.io.File;
import java.io.FileOutputStream;
import java.net.*;


/**
 * Este m�dulo contiene la l�gica de aplicaci�n de un servidor Daytime
 * que utiliza un socket orientado a conexi�n para IPC.
 * Se requiere un argumento de l�nea de mandato para el puerto del servidor
 * @author M. L. Liu
 */
public class ServidorFicheros {
	public static void main(String[] args) {
		int puertoServidor = 5000; // puerto por defecto
		if (args.length == 1 )
			puertoServidor = Integer.parseInt(args[0]);
		try {
			// instancia un socket stream para aceptar
                ServerSocket miSocketConexion = new ServerSocket(puertoServidor);

			// las conexiones
			System.out.println("El servidor Ficheros est� listo.");
			while (true) { // bucle infinito

				// espera para aceptar una conexi�n 
				    System.out.println("Espera una conexi�n.");
                                MiSocketStream2 miSocketDatos = new MiSocketStream2(miSocketConexion.accept( ));

				/*
				// Nota: no hay necesidad de leer una petici�n - la
				// petici�n es impl�cita.
				
                                System.out.println("Un cliente ha hecho una conexi�n.");
				
				String directorio = "C:\\Users\\Estudiante\\Documents\\";
				miSocketDatos.enviaMensaje(directorio);
                                String fichero = miSocketDatos.recibeMensaje();
                                File f = new File(directorio+fichero);
				String respuesta = "";
				if (f.exists())
					if (!f.isDirectory())
						respuesta = fichero + " es un archivo";
					else
						respuesta = fichero + " es un directorio";
				// ahora manda la respuesta al solicitante.
				miSocketDatos.enviaMensaje(respuesta);
                                */
                                String directorio = "C:\\Users\\Estudiante\\Documents\\";
                                String fichero = "prueba2.txt";
                                File output = new File(directorio+fichero);
                                FileOutputStream outputs = new FileOutputStream(output);
                                int leido;
                                while((leido=miSocketDatos.recibeMensaje())!=-1){
                                    outputs.write(leido);
                                }
                                outputs.close();
				miSocketDatos.close( );
			} // fin de while
		} // fin de try
		catch (Exception ex) {
			ex.printStackTrace( );
		}
    } // fin de main
} // fin de class