package Interfaz;

import java.awt.Color;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;



import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Bienvenida extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private Principal pe;
	private JLabel label_1;
	private JPanel panel;
	private JLabel label;
	private JLabel lblBienvenidoUsuario;
	private JSeparator separator;

	private JTextComponent area;

	/**
	 * Create the frame.
	 */
	public Bienvenida(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 458, 385);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		setUndecorated(true);
		Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
		
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Bienvenida.class.getResource("/images/home.png")));
		label.setBounds(25, 0, 50, 50);
		contentPane.add(label);
		
		lblBienvenidoUsuario = new JLabel("Bienvenido usuario !!!");
		lblBienvenidoUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBienvenidoUsuario.setBounds(96, 11, 223, 38);
		contentPane.add(lblBienvenidoUsuario);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(408, 0, 50, 50);
		contentPane.add(panel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Bienvenida.class.getResource("/images/cross1.png")));
		label_1.setBounds(0, 0, 50, 50);
		panel.add(label_1);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 458, 2);
		contentPane.add(separator);
		
		area = new JTextArea(
				"Bienvenido a nuestro programa de desarrollo de \ndiagramas UML. "
				+ "Para comenzar, si no está fami- \nliarizado con este software "
				+ "es recomendable que \nprimero acceda a la pestaña de Ayuda. "
				+ "En ella \nencontrará de manera breve y clara los aspectos \n"
				+ "fundamentales a tener en cuenta para el correcto \nuso de este "
				+ "programa.\n"
				+ "Nuestro software se encuentra actualmente en des- \narrollo, por lo "
				+ "que funcionalidades como Guardar,\no Abrir nuevo diagrama, no se "
				+ "encuentran disponi-\nbles. Sin embargo, la versión actual está orien-\ntada "
				+ "a funciones de creación de un diagrama UML, \ninteractuar con las clases, "
				+ "establecer relaciones\nde herencia, entre otras características.\n"
				+ "Esperamos sea de su agrado !");
		area.setEditable(false);
		area.setFont(new Font("Courier New", Font.BOLD, 15));
		area.setBackground(new Color(153, 204, 204));
		area.setBounds(10, 61, 448, 313);
		contentPane.add(area);
	}
}
