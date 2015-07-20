package knock2;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class KKMultiServer  extends Thread {
	int SERVER_PORT;
    JTextArea mensajeArea;
    JButton botton;
 
    
    public KKMultiServer(JTextArea mensajeArea,JButton botton,int  puerto){
    	this.SERVER_PORT = puerto;
	    this.mensajeArea =  mensajeArea;
	    this.botton = botton;
     
    }
    
    private void setup() {
        System.out.println("Attempting to establish server.\n");
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + SERVER_PORT+"\n");
            mensajeArea.setText( mensajeArea.getText() +" "+ "Could not listen on port: " + SERVER_PORT+"\n");
            System.exit(-1);
        }
        System.out.println("Server online.\n");
        mensajeArea.setText( mensajeArea.getText() +" "+ "Server online\n");

    }
    
    private void handleRequest() {
        listening = true;
        while (listening) {
            try {
                System.out.println("Listening.");
                mensajeArea.setText( mensajeArea.getText() +" "+ "Listening...\n");

                Socket newConnection = serverSocket.accept();
                KKMultiServerThread newThread = new KKMultiServerThread(newConnection);
                newThread.start();
                System.out.println("One new thread spawned.");
                mensajeArea.setText( mensajeArea.getText() +" "+ "Se ejecuto un nuevo Thread\n");

            } catch (IOException ex) {
                Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Instance variables */
    private ServerSocket serverSocket;   
    private boolean listening;
    
    /* Constants */
   // private static final int SERVER_PORT = 4444;
    public void run() {
     
           botton.setEnabled(false);

           setup();
           handleRequest();
      
    }
}