package socketsconconexion.stream;

  import java.net.*;
  import java.io.*;

  /**
  *    Este ejemplo ilustra la sintaxis b�sica del socket
  *    en modo stream.
  *    @author M. L. Liu
  */
  public class SolicitanteConexion {

  //  Una aplicaci�n que solicita una conexi�n y manda un mensaje utilizando
  //  un socket en modo stream
  //  Se esperan dos argumentos de l�nea de mandato, en orden:
  //  <nombre de la m�quina del aceptador de la conexi�n>
  //  <n�mero de puerto del aceptador de la conexi�n>
    public static void main(String[] args) {
      /*if (args.length != 2)
        System.out.println
        ("Este programa requiere dos argumentos de l�nea de mandato");
      else {*/
        try {
          args = new String[2];
          args[0] = "localhost";
          args[1] = "5000";
          //optiene la direccion ip
          InetAddress maquinaAceptadora = InetAddress.getByName(args[0]);
          int puertoAceptador = Integer.parseInt(args[1]);
          // instancia un socket de datos 
          Socket miSocket = new Socket(maquinaAceptadora, puertoAceptador);
  /**/    System.out.println("Solicitud de conexi�n concedida");
          // obtiene un flujo de entrada para leer del socket de datos
          InputStream flujoEntrada = miSocket.getInputStream();
          // crea un objeto BufferedReader para la entrada en modo car�cter
          BufferedReader socketInput =
            new BufferedReader(new InputStreamReader(flujoEntrada));
  /**/    System.out.println("esperando leer");
          // lee una l�nea del flujo de datos
          String mensaje = socketInput.readLine( );
  /**/    System.out.println("Mensaje recibido:");
          System.out.println("\t" + mensaje);
          miSocket.close( );
  /**/    System.out.println("socket de datos cerrado");
        } // fin de try
        catch (Exception ex) {
          ex.printStackTrace( );
        } // fin de catch
     // } // fin de else
    } // fin de main
  } // fin de class
