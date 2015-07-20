/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

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
        boolean seguir = true;
        while (true) {
            try {// TODO code application logic here
                String recibido;
                String enviado;
                ServerSocket socketConexion = new ServerSocket(numPuerto);
                while (true) {
                    MiSocketStream socketDatos = new MiSocketStream(socketConexion.accept());
                    InputStreamReader is = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(is);
                    seguir = true;
                    while (seguir) {
                        System.out.print("Sevidor: ");
                        enviado = br.readLine();
                        socketDatos.enviaMensaje(enviado);
                        recibido = socketDatos.recibeMensaje();
                        System.out.println("Cliente: " + recibido);
                        if (recibido.equalsIgnoreCase("exit()")) {
                            seguir = false;
                        }
                          if (enviado.equalsIgnoreCase("exit()")) {
                            seguir = false;
                        }
                    }

                    socketDatos.close();
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
