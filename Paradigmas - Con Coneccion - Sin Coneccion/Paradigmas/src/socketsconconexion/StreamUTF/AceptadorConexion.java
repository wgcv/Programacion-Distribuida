package socketsconconexion.StreamUTF;

import java.net.*;


/**
*    Este ejemplo ilustra la sintaxis b�sica del socket
*    en modo stream.
*    @author M. L. Liu
*/
public class AceptadorConexion {

// Una aplicaci�n que recibe un mensaje usando un socket en modo stream.
//  Se esperan dos argumentos de l�nea de mandato, en orden:
//  <n�mero de puerto del socket de servidor utilizado en este proceso>
//  <mensaje, una cadena, para mandar>

  public static void main(String[] args) {
    /*if (args.length != 2)
      System.out.println
      ("Este programa requiere dos argumentos de l�nea de mandato");
    else {*/
      try {
        args = new String[2];
        args[0] = "5000";
        args[1] = "hola mundo";
    	int numPuerto = Integer.parseInt(args[0]);
        String mensaje = args[1];

    for(int i=0;i<3;i++){
         // instancia un socket para aceptar la conexi�n
        ServerSocket socketConexion = new ServerSocket(numPuerto);
/**/
           System.out.println("preparado para aceptar una conexi�n");
        // espera una petici�n de conexi�n, instante en el cual
        // se crea un socket de datos
        MiSocketStream socketDatos =
          new MiSocketStream(socketConexion.accept());
/**/    System.out.println("conexi�n aceptada");
        socketDatos.enviaMensaje(mensaje);

/**/    System.out.println("mensaje enviado");
        socketDatos.close( );
/**/    System.out.println("socket de datos cerrado");
        socketConexion.close( );
/**/    System.out.println("socket de conexi�n cerrado");
}
      } // fin de try
      catch (Exception ex) {
        ex.printStackTrace( );
      } // fin de catch
    //} // fin de else
  } // fin de main
} // fin de class