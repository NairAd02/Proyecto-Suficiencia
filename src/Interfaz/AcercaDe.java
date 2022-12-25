package Interfaz;

import java.awt.*;

import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AcercaDe extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel labelTitulo;
	private Principal pe;
	private JLabel labelSalir;
	private JLabel labelImg;
	private JSeparator separator;
	private JPanel panelSalir;
	private JTextArea area;


	/**
	 * Create the frame.
	 */
	public AcercaDe(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 316, 314);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel("Desarrollado por:");
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 19));
		labelTitulo.setBounds(70, 12, 190, 38);
		contentPane.add(labelTitulo);
		
		labelImg = new JLabel("");
		labelImg.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/information2.png")));
		labelImg.setBounds(10, 0, 50, 50);
		contentPane.add(labelImg);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 316, 2);
		contentPane.add(separator);
		
		panelSalir = new JPanel();
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(new Color(0, 89, 134));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(new Color(153, 204, 204));
			}
		});
		panelSalir.setBounds(266, 0, 50, 50);
		panelSalir.setBackground(new Color(153, 204, 204));
		contentPane.add(panelSalir);
		panelSalir.setLayout(null);
		
		labelSalir = new JLabel("");
		labelSalir.setBounds(0, 0, 50, 50);
		panelSalir.add(labelSalir);
		labelSalir.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/cross1.png")));
		
		area = new JTextArea("Estudiantes de 1er a�o de la \nfacultad de "
				+ "Ingenier�a \nInform�tica de la CUJAE. \n\n"
				+ "Dar�o Gonz�lez Morando \n"
				+ "Adri�n Su�rez Padr�n \n"
				+ "Kendry Est�vez Rodriguez \n\n"
				+ "Como evaluaci�n de suficiencia \npara algunas de las "
				+ "asignaturas\ndel curso.");
		area.setEditable(false);
		area.setFont(new Font("Courier New", Font.BOLD, 15));
		area.setBackground(new Color(153, 204, 204));
		area.setBounds(10, 61, 296, 242);
		contentPane.add(area);
		
		
		
		
	}
}
