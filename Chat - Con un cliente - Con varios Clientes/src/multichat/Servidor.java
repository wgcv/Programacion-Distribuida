/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        int numPuerto = 5050;
        int id=0;
        while (true) {
            try {// TODO code application logic here
          
                ServerSocket socketConexion = new ServerSocket(numPuerto);
                while (true) {
                    MiSocketStream socketDatos = new MiSocketStream(socketConexion.accept());
                 id+=1;
                    Thread enviar
                            = new Thread(new HiloServidorchatEnviar(socketDatos,id));
				enviar.start();
                  Thread recibir = new Thread(new HiloServidorchatRecibir(socketDatos,id));
				recibir.start();
                    /*
                    
*/
                   //socketDatos.close();
                } 
            } // fin de try
            /*
             while(true){
             try  {// TODO code application logic here
             ServerSocket socketConexion = new ServerSocket(numPuerto);
             MiSocketStream socketDatos = new MiSocketStream(socketConexion.accept());
                    
             while(true){
             System.out.print("Sevidor: ");
             enviado = br.readLine();
             }
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);
             recibido = socketDatos.recibeMensaje();
             System.out.println("Cliente: "+ recibido);
             enviado = "Mensaje 1";
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);
             recibido = socketDatos.recibeMensaje();
             System.out.println("Cliente: "+ recibido);
             enviado = "Mensaje 2";
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);
             recibido = socketDatos.recibeMensaje();
             System.out.println("Cliente: " + recibido);
             enviado = "Mensaje 3";
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);
             recibido = socketDatos.recibeMensaje();
             System.out.println("Cliente: "+ recibido);
             enviado = "Mensaje 4";
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);
             recibido = socketDatos.recibeMensaje();
             System.out.println("Cliente: "+ recibido);
             enviado = "Mensaje 5";
             socketDatos.enviaMensaje(enviado);
             System.out.println("Servidor: "+ enviado);

             socketDatos.close();
             } // fin de try*/ catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }  
}
