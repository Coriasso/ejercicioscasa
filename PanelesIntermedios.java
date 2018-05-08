package com.iesvirgendelcarmen.ejercicios;

import java.awt.*;

import javax.swing.*;

public class PanelesIntermedios {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {


			public void run() {
				JFrame frame = new Ventana();
				frame.setVisible(true);

			}
		});


	}



}
@SuppressWarnings("serial")
class Ventana extends JFrame{

	private JTextArea jtextarea;
	private String texto;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JButton boton; 

	public Ventana() {
		texto = "JTabbedPane paneles = new JTabbedPane();/n"	+
				"JPanel panel1 = new JPanel();\n" + 
				"panel1.add(label1);\n" + 
				"JTextField text1 = new JTextField(10);\n"; 
		crearVentana();
		crearPanelPestanna();
	}


	private void crearPanelPestanna() {
		JTabbedPane paneles = new JTabbedPane();
		/*JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Panel 1");
		panel1.add(label1);
		JTextField text1 = new JTextField(10);
		panel1.add(text1);*/
		JSplitPane split = crearJsplitPane();
		paneles.addTab("Pestaña1", split);
		
		
		//Tool tip agrega una ventanita que aparecerá al dejar el ratón encima
		paneles.setToolTipTextAt(0, "Panel con label e input text");
		JScrollPane panel2 = crearJScrollPanel();
		JLabel label2 = new JLabel("Panel 2");
		panel2.add(label2);

		paneles.addTab("Pestaña 2",panel2);

		this.add(paneles);

	}




	private JSplitPane crearJsplitPane() {
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, crearJScrollPanel(), crearPanelDerecho());
		
		return split;
	}


	private JPanel crearPanelDerecho() {

		JPanel jPanel = new JPanel(new GridLayout(0,2,30,120));
		
		JLabel jLabelLogin = new JLabel("Login: ");
		
		jPanel.add(jLabelLogin);
		
		textLogin = new JTextField();
		
		jPanel.add(textLogin);
		
		jPanel.add(new JLabel("Password"));
		
		jPanel.add(textPassword = new JPasswordField());
		
		boton = new JButton("Aceptar");
		
		jPanel.add(boton);
		
		return jPanel;
	}


	private JScrollPane crearJScrollPanel() {

		
		jtextarea = new JTextArea(100,20);
		jtextarea.setText(texto);
		jtextarea.setEditable(false);
		JScrollPane scrollPannel = new JScrollPane();
		scrollPannel.setViewportView(jtextarea);

		return scrollPannel;
	}


	private void crearVentana() {

		this.setTitle("Ventana nueva");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);	
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}