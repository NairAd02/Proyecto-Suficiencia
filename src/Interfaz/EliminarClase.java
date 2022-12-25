package Interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import util.PanelClase;

import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class EliminarClase extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private PanelClase pe;
	private JPanel panelConfirmar;
	private JLabel labelConfirmar;
	private JLabel labelCancelar;
	private JPanel panelCancelar;
	private JLabel labelMensaje;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EliminarClase(PanelClase p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 415, 219);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelMensaje = new JLabel("Desea eliminar la clase seleccionada?");
		labelMensaje.setFont(new Font("Dialog", Font.BOLD, 19));
		labelMensaje.setBounds(22, 41, 366, 41);
		contentPane.add(labelMensaje);

		panelConfirmar = new JPanel();
		panelConfirmar.setLayout(null);
		panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
		panelConfirmar.setBounds(42, 121, 138, 55);
		panelConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pe.getPe().getLienzo().eliminarRelaciones(pe.getLblNombreclase().getText());
				pe.getPe().getDiagrama().eliminarClase(pe.getClaseSeleccionada().getLblNombreclase().getText());
				pe.getPe().getLienzo().remove(pe.getClaseSeleccionada());
				pe.getPe().getLienzo().repaint();
				pe.getPe().getLienzo().revalidate();			
				pe.getPe().setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelConfirmar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelConfirmar);

		labelConfirmar = new JLabel("Confirmar");
		labelConfirmar.setFont(new Font("Dialog", Font.BOLD, 19));
		labelConfirmar.setBounds(18, 7, 113, 40);
		panelConfirmar.add(labelConfirmar);

		panelCancelar = new JPanel();
		panelCancelar.setLayout(null);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		panelCancelar.setBounds(232, 121, 138, 55);
		panelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.getPe().getLienzo().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				pe.getPe().setEnabled(true);
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
		});
		contentPane.add(panelCancelar);

		labelCancelar = new JLabel("  Cancelar");
		labelCancelar.setFont(new Font("Dialog", Font.BOLD, 19));
		labelCancelar.setBounds(18, 7, 113, 40);
		panelCancelar.add(labelCancelar);


	}
}
