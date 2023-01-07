package Interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInicio extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal pe;

	public PanelInicio(Principal p) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pe.getPanelHerramDesp().setVisible(false);
				pe.setDesplegadoHerram(false);
				pe.getPanelArchivoDesp().setVisible(false);
				pe.setDesplegadoArchivo(false);
			}
		});
		pe = p;
		setBorder(null);
		setBackground(SystemColor.textHighlightText);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pe.getPanelHerramDesp().setVisible(false);
				pe.setDesplegadoHerram(false);
				pe.getPanelArchivoDesp().setVisible(false);
				pe.setDesplegadoArchivo(false);
				FrameNuevoDiagrama nuevoDiagrama = new FrameNuevoDiagrama(pe);
				nuevoDiagrama.setVisible(true);
				pe.setEnabled(false);
			}
		});
		
				JLabel lblCrearNuevoDiagrama = new JLabel("Crear nuevo diagrama");
				lblCrearNuevoDiagrama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblCrearNuevoDiagrama.setHorizontalAlignment(SwingConstants.CENTER);
				lblCrearNuevoDiagrama.setFont(new Font("Dialog", Font.BOLD, 18));
				lblCrearNuevoDiagrama.setBounds(264, 324, 295, 25);
				add(lblCrearNuevoDiagrama);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(PanelInicio.class.getResource("/images/500x500.png")));
		lblNewLabel.setBounds(213, 125, 423, 224);
		add(lblNewLabel);

	}
}
