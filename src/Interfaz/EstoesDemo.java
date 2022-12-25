package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EstoesDemo extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JFrame pe;
	private JLabel labelok;
	private JPanel panelOK;
	private JTextArea textArea;
	private JLabel lblNewLabel;


	/**
	 * Create the frame.
	 */
	public EstoesDemo(JFrame p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 401, 264);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelOK = new JPanel();
		panelOK.setLayout(null);
		panelOK.setBackground(SystemColor.inactiveCaptionBorder);
		panelOK.setBounds(135, 210, 111, 37);
		panelOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				pe.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelOK.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelOK.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelOK);

		labelok = new JLabel("OK");
		labelok.setHorizontalAlignment(SwingConstants.CENTER);
		labelok.setFont(new Font("Dialog", Font.BOLD, 19));
		labelok.setBounds(0, 0, 111, 37);
		panelOK.add(labelok);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EstoesDemo.class.getResource("/images/200x210.png")));
		lblNewLabel.setBounds(108, 11, 181, 102);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea("El programa de creaci�n de diagramas \n"
				+ "UML se encuentra actualmente en desarrollo.\n"
				+"Funcionalidades como esta se "
				+ "implementar�n\nen futuras versiones.");
		textArea.setFont(new Font("Courier New", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBackground(new Color(153, 204, 204));
		textArea.setBounds(8, 124, 389, 72);
		contentPane.add(textArea);
	}
}
