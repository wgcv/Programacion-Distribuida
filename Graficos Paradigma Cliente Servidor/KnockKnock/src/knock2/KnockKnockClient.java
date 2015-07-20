package knock2;

import java.io.*;
import java.net.*;

public class KnockKnockClient {

    Socket kkSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String fromServer;
    String fromUser;
	  KnockKnockClient(String host, int puerto) throws IOException{   

    
    try {
      kkSocket = new Socket(host, puerto);
      out = new PrintWriter(kkSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host: manis.csi.ull.es.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to: manis.csi.ull.es.");
      System.exit(1);
    }
    fromServer = in.readLine();
	  }
/*

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromServer;
    String fromUser;

    while ((fromServer = in.readLine()) != null) {
      System.out.println("Server: " + fromServer);
      if (fromServer.equals("Bye."))
        break;
        
      fromUser = stdIn.readLine();
      if (fromUser != null) {
        System.out.println("Client: " + fromUser);
        out.println(fromUser);
      }
    }

    out.close();
    in.close();
    stdIn.close();
    kkSocket.close();
 }*/
	 
		public void initClient(String msj) throws IOException{

	          //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

	          //while ((fromServer = in.readLine()) != null) {
	              
	            //fromUser = stdIn.readLine();
	            fromUser = msj;
	            //System.out.println(msj);
	            if (fromUser != null) {
	              //System.out.println("Client: " + fromUser);
	              out.println(fromUser);
	            }

	            fromServer = in.readLine();
	            //System.out.println("Server: " + fromServer);
	            if (fromServer.equals("Bye."))
	              //break;
	            	return;
	            
	            
	            //}

	          /*out.close();
	          in.close();
	          //stdIn.close();
	          kkSocket.close();*/
	    	
	    }
	}

