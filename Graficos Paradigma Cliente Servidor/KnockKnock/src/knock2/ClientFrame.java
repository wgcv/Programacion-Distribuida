package knock2;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientFrame extends JFrame {
	   public ClientFrame()
	   {  
		   // Use helper methods
	      createIPField();
		  createPuertoField();
		  createRespuestaField();
	      createMensajeArea();
	      createConectarButton();
	      createEnviarButton();
	      createPanel();

	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   }

	   public void createIPField()
	   {
	      ipLabel = new JLabel("IP Servidor: ");
	      final int FIELD_WIDTH = 10;
	      ipField = new JTextField(FIELD_WIDTH);
	   }

	   public void createPuertoField()
	   {
	      puertoLabel = new JLabel("Puerto: ");
	      final int FIELD_WIDTH = 10;
	      puertoField = new JTextField(FIELD_WIDTH);
	   }

	   public void createRespuestaField()
	   {
	      respuestaLabel = new JLabel("Respuesta: ");
	      final int FIELD_WIDTH = 30;
	      respuestaField = new JTextField(FIELD_WIDTH);
	   }

	   public void createMensajeArea()
	   {
	      mensajeLabel = new JLabel("Joke: ");
	      final int AREA_ROWS = 7;
	      final int AREA_COLUMNS = 30;

	     mensajeArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
	     mensajeArea.setEditable(false);
	      scrollPane = new JScrollPane(mensajeArea);
	   }

	   public void createConectarButton()
	   {  
	      conectarButton = new JButton("Conectar");

	      class ConectarListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	   		  try {
				cli = new KnockKnockClient(ipField.getText(),Integer.parseInt(puertoField.getText()));
				mensajeArea.append("Server: "+cli.fromServer+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         }            
	      }

	      ActionListener listener = new ConectarListener();
	      conectarButton.addActionListener(listener);
	   }

	   public void createEnviarButton() 
	   {  
	      enviarButton = new JButton("Enviar");

	      class EnviarListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event) 
	         {
	        	 try {
					cli.initClient(respuestaField.getText());
					mensajeArea.append("Server: "+cli.fromServer+"\n");
					respuestaField.setText("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }            
	      }

	      ActionListener listener = new EnviarListener();
	      enviarButton.addActionListener(listener);
	   }

	   public void createPanel()
	   {
	      JPanel northPanel = new JPanel();
	      northPanel.add(ipLabel);
	      northPanel.add(ipField);	      
	      northPanel.add(puertoLabel);
	      northPanel.add(puertoField);
	      northPanel.add(conectarButton);
	      JPanel centerPanel = new JPanel();
	      centerPanel.add(mensajeLabel);
	      centerPanel.add(scrollPane);
	      JPanel southPanel = new JPanel();
	      southPanel.add(respuestaLabel);
	      southPanel.add(respuestaField);
	      southPanel.add(enviarButton);
	      add(northPanel,BorderLayout.NORTH);
	      add(centerPanel,BorderLayout.CENTER);
	      add(southPanel,BorderLayout.SOUTH);
	   }

	   private JLabel ipLabel;
	   private JLabel puertoLabel;
	   private JLabel respuestaLabel;
	   private JLabel mensajeLabel;
	   private JTextField ipField;
	   private JTextField puertoField;
	   private JTextField respuestaField;
	   private JTextArea mensajeArea;
	   private JButton enviarButton;
	   private JButton conectarButton;
	   private JScrollPane scrollPane;
	   
	   private KnockKnockClient cli;

	   private static final int FRAME_WIDTH = 800;
	   private static final int FRAME_HEIGHT = 200;
}
