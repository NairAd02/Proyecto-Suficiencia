package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import util.LabelArchivoGuardado;

import java.awt.FlowLayout;
import java.io.File;

public class DiagramasAbrir extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel labelTitulo;
	private Principal pe;
	private JLabel labelSalir;
	private JLabel labelImg;
	private JSeparator separator;
	private JPanel panelSalir;
	private JPanel panelSalvas;


	public Principal getPe() {
		return pe;
	}

	/**
	 * Create the frame.
	 */
	public DiagramasAbrir(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 446, 455);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel("Diagramas creados:");
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
		separator.setBounds(0, 50, 446, 2);
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
		panelSalir.setBounds(396, 0, 50, 50);
		panelSalir.setBackground(new Color(153, 204, 204));
		contentPane.add(panelSalir);
		panelSalir.setLayout(null);
		
		labelSalir = new JLabel("");
		labelSalir.setBounds(0, 0, 50, 50);
		panelSalir.add(labelSalir);
		labelSalir.setIcon(new ImageIcon(AcercaDe.class.getResource("/images/cross1.png")));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(0, 50, 446, 405);
		panelCentral.setBackground(new Color(153, 204, 204));
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		
		panelSalvas = new JPanel();
		panelSalvas.setBackground(new Color(153, 204, 204));
		scrollPane.setViewportView(panelSalvas);
		panelSalvas.setLayout(new BoxLayout(panelSalvas, BoxLayout.Y_AXIS));
		
		llenarPanel();
		
		
	}
	
	private void llenarPanel(){
		File rutaSalvas = new File("Salvas Diagrama");
		
		String[] list = rutaSalvas.list();
		
		for (String s : list) {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(new LabelArchivoGuardado(s, pe,DiagramasAbrir.this),BorderLayout.CENTER);
			panelSalvas.add(panel);
		}
		
	}
}
