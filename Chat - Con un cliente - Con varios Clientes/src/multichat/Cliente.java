/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Estudiante
 */
public class Cliente {

    public static void main(String[] args) {
        String enviado;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        boolean seguir=true;
        String recibido;
        // TODO code application logic here
        
        try {
           
          
                    MiSocketStream miSocket = new MiSocketStream("localhost", 5050);
               seguir=true;
                    while (seguir) {
                         recibido = miSocket.recibeMensaje();
                        System.out.println("Servidor: " + recibido);
                    
                        System.out.print("Cliente: ");
                        enviado = br.readLine();
                        miSocket.enviaMensaje(enviado);
                       
                        if (enviado.equalsIgnoreCase("exit()")) {
                            seguir = false;
                        }
                        }
                    
            /*String mensaje = miSocket.recibeMensaje();
            
            System.out.println("Servidor: " + mensaje);
            System.out.print("Cliente: ");
            enviado = br.readLine();
            //enviado="Gracias soy un cliente";
            miSocket.enviaMensaje(enviado);
            mensaje = miSocket.recibeMensaje();

            System.out.println("Servidor: " + mensaje);
            System.out.print("Cliente: ");
            enviado = br.readLine();
            miSocket.enviaMensaje(enviado);
            mensaje = miSocket.recibeMensaje();
            System.out.println("Servidor: " + mensaje);
            System.out.print("Cliente: ");
            enviado = br.readLine();
            miSocket.enviaMensaje(enviado);
            mensaje = miSocket.recibeMensaje();
            System.out.println("Servidor: " + mensaje);
            System.out.print("Cliente: ");
            enviado = br.readLine();

            miSocket.enviaMensaje(enviado);

            mensaje = miSocket.recibeMensaje();
            System.out.println("Servidor: " + mensaje);
            System.out.print("Cliente: ");
            enviado = br.readLine();
            miSocket.enviaMensaje(enviado);
            mensaje = miSocket.recibeMensaje();
            System.out.println("Servidor: " + mensaje);
            miSocket.close();*/
            
        } // fin de try
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
