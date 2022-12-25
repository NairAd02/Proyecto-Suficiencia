package mensajesError;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Interfaz.Principal;

import javax.swing.border.LineBorder;


public class AlmenosUna extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private Principal pe;
	private JLabel labelMensaje;
	private JLabel labelOk;
	private JPanel panelOk;
	private JLabel label;


	/**
	 * Create the frame.
	 */
	public AlmenosUna(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 403, 157);
		setUndecorated(true);
		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelOk = new JPanel();
		panelOk.setLayout(null);
		panelOk.setBackground(SystemColor.inactiveCaptionBorder);
		panelOk.setBounds(121, 82, 138, 55);
		panelOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				panelOk.setBackground(new Color(104,137,148));
			}
			public void mouseExited(MouseEvent e){
				panelOk.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelOk);
		
		labelOk = new JLabel("OK");
		labelOk.setHorizontalAlignment(SwingConstants.CENTER);
		labelOk.setFont(new Font("Dialog", Font.BOLD, 19));
		labelOk.setBounds(10, 8, 113, 40);
		panelOk.add(labelOk);
		
		labelMensaje = new JLabel("Debe crear al menos una clase primero.");
		labelMensaje.setFont(new Font("Dialog", Font.BOLD, 17));
		labelMensaje.setBounds(58, 30, 318, 41);
		contentPane.add(labelMensaje);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AlmenosUna.class.getResource("/images/warning.png")));
		label.setBounds(10, 25, 50, 50);
		contentPane.add(label);
		
		
	}

}
