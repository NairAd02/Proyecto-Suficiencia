package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Nuevo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private Principal pe;
	private JLabel labelSi;
	private JPanel panelSi;
	private JPanel panelNo;
	private JLabel lblNo;

	private JPanel panelSalir;

	private JLabel lblSalir;


	/**
	 * Create the frame.
	 */
	public Nuevo(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 382, 167);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelSi = new JPanel();
		panelSi.setLayout(null);
		panelSi.setBackground(SystemColor.inactiveCaptionBorder);
		panelSi.setBounds(42, 103, 93, 35);
		panelSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EstoesDemo frame = new EstoesDemo(Nuevo.this);
				frame.setVisible(true);
				setVisible(false);
				setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSi.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSi.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelSi);
		
		labelSi = new JLabel("Si");
		labelSi.setHorizontalAlignment(SwingConstants.CENTER);
		labelSi.setFont(new Font("Dialog", Font.BOLD, 19));
		labelSi.setBounds(0, 5, 93, 24);
		panelSi.add(labelSi);
		
		panelNo = new JPanel();
		panelNo.setLayout(null);
		panelNo.setBackground(SystemColor.inactiveCaptionBorder);
		panelNo.setBounds(245, 103, 93, 35);
		panelNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelNo.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelNo.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelNo);
		
		lblNo = new JLabel("No");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNo.setBounds(0, 5, 93, 24);
		panelNo.add(lblNo);
		
		JLabel lblDeseaCrearNuevo = new JLabel("Desea guardar el proyecto actual?");
		lblDeseaCrearNuevo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDeseaCrearNuevo.setBounds(42, 48, 307, 35);
		contentPane.add(lblDeseaCrearNuevo);
		
		
		panelSalir = new JPanel();
		setLocationRelativeTo(null);
		panelSalir.setBounds(332, 0, 50, 48);
		contentPane.add(panelSalir);
		panelSalir.setBackground(new Color(153, 204, 204));
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(new Color(153, 204, 204));
			}
		});
		panelSalir.setLayout(null);

		lblSalir = new JLabel();
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBounds(0, 0, 50, 48);
		panelSalir.add(lblSalir);
		lblSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/cross.png")));
		
		
		
		
		
	}
}
