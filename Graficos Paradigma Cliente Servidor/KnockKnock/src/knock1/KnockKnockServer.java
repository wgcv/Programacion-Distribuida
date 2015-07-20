package knock1;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class KnockKnockServer  extends Thread{
    String inputLine, outputLine;
    String estado;
    int puerto;
    JTextArea mensajeArea;
    JButton botton;
    public KnockKnockServer(JTextArea mensajeArea,JButton botton, int puerto){
    this.puerto=puerto;
    this.mensajeArea =  mensajeArea;
    this.botton = botton;
}

      
    public void ejecutar() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puerto);
            estado = "estoy después de crear el socket\n";
	    System.out.println(estado);
                     mensajeArea.setText( mensajeArea.getText() +" "+ estado);

        } catch (IOException e) {
             mensajeArea.setText( mensajeArea.getText() +" "+ "Could not listen on port:" + puerto);
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            estado = "estoy después de aceptar un cliente \n";
             mensajeArea.setText( mensajeArea.getText() +" "+ estado);
	    System.out.println(estado);
        } catch (IOException e) {
            System.err.println("Accept failed.");
             mensajeArea.setText( mensajeArea.getText() +" "+ "Accept failed.\n");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
				new InputStreamReader(
				clientSocket.getInputStream()));
        //String inputLine, outputLine;
        KnockKnockProtocol kkp = new KnockKnockProtocol();

        outputLine = kkp.processInput(null);
        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
             outputLine = kkp.processInput(inputLine);
             out.println(outputLine);
             if (outputLine.equals("Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();	
        botton.setEnabled(true);

	}
  
    
    
          /*public String GetEstado(){
    return estado;
}*/

    public void run() {
        try {
            botton.setEnabled(false);

            ejecutar();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}