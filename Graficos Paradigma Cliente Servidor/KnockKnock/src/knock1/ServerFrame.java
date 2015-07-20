package knock1;
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


public class ServerFrame extends JFrame {
	   public ServerFrame()
	   {  
		   // Use helper methods
	      createPuertoField();
	      createMensajeArea();
	      createLimpiarButton();
	      createConectarButton();
	      createPanel();

	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   }

	   public void createPuertoField()
	   {
	      puertoLabel = new JLabel("Puerto: ");
	      final int FIELD_WIDTH = 10;
	      puertoField = new JTextField(FIELD_WIDTH);
	   }

	   public void createMensajeArea()
	   {
	      mensajeLabel = new JLabel("Estado: ");
	      final int AREA_ROWS = 10;
	      final int AREA_COLUMNS = 35;

	     mensajeArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
	     mensajeArea.setEditable(false);
	      scrollPane = new JScrollPane(mensajeArea);
              
	   }

	   public void createLimpiarButton()
	   {  
	      limpiarButton = new JButton("Limpiar");

	      class LimpiarListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
	        	 puertoField.setText("");
                         
	        	 mensajeArea.setText("");
	         }            
	      }

	      ActionListener listener = new LimpiarListener();
	      limpiarButton.addActionListener(listener);
	   }

	   public void createConectarButton()
	   {  
	      conectarButton = new JButton("Conectar");

	      class ConectarListener implements ActionListener
	      {
	         public void actionPerformed(ActionEvent event)
	         {
                    
	        	  srv = new KnockKnockServer(mensajeArea,conectarButton, Integer.parseInt(puertoField.getText()));

	        	
					srv.start();
					
                               
                         
	         }            
	      }

	      ActionListener listener = new ConectarListener();
	      conectarButton.addActionListener(listener);
	   }

	   public void createPanel()
	   {
	      JPanel northPanel = new JPanel();
	      northPanel.add(puertoLabel);
	      northPanel.add(puertoField);
	      
	      JPanel centerPanel = new JPanel();
	      centerPanel.add(mensajeLabel);
	      centerPanel.add(scrollPane);
	      
	      JPanel southPanel = new JPanel();
	      southPanel.add(limpiarButton);
	      southPanel.add(conectarButton);
	      
	      add(northPanel,BorderLayout.NORTH);
	      add(centerPanel,BorderLayout.CENTER);
	      add(southPanel,BorderLayout.SOUTH);
	   }

	   private JLabel puertoLabel;
	   private JLabel mensajeLabel;
	   private JTextField puertoField;
	   private JTextArea mensajeArea;
	   private JButton limpiarButton;
	   private JButton conectarButton;
	   private JScrollPane scrollPane;
	   
	   private KnockKnockServer srv;

	   private static final int FRAME_WIDTH = 500;
	   private static final int FRAME_HEIGHT = 200;
}
