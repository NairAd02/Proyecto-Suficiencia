package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.*;

public class ConfirmarSalida extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblSalir;
	private JLabel lblTexto;
	private JPanel panelSalir;
	private JPanel panelCancelar;
	private Principal pe;


	/**
	 * Create the frame.
	 */
	
	
	public ConfirmarSalida(Principal p) {
		pe=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 432, 224);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTexto = new JLabel("Desea salir del programa?");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Dialog", Font.BOLD, 19));
		lblTexto.setBounds(10, 38, 412, 46);
		contentPane.add(lblTexto);
		
		panelSalir = new JPanel();
		panelSalir.setBounds(49, 135, 138, 55);
		panelSalir.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panelSalir);
		panelSalir.setLayout(null);
		
		lblSalir = new JLabel("Aceptar");
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(18, 7, 113, 40);
		panelSalir.add(lblSalir);
		lblSalir.setFont(new Font("Dialog", Font.BOLD, 19));
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		
		panelCancelar = new JPanel();
		panelCancelar.setBounds(239, 135, 138, 55);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panelCancelar);
		panelCancelar.setLayout(null);
		
		JLabel lblCancelar = new JLabel("   Cancelar");
		lblCancelar.setBounds(14, 7, 120, 40);
		panelCancelar.add(lblCancelar);
		lblCancelar.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelCancelar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelCancelar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});

		
		
		
		
		
	}


	public JLabel getLblTexto() {
		return lblTexto;
	}


	public void setTextoLblTexto(String texto) {
		this.lblTexto.setText(texto);
	}

}
