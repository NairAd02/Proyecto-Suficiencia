package mensajesError;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Interfaz.Principal;
import javax.swing.border.LineBorder;


public class AlmenosDos extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private Principal pe;
	private JLabel label;
	private JLabel lblDebeCrearAl;
	private JPanel panelOk;


	/**
	 * Create the frame.
	 */
	public AlmenosDos(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 393, 155);
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
		panelOk.setBounds(128, 79, 138, 55);
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
		
		JLabel lblOk = new JLabel("OK");
		lblOk.setBounds(10, 8, 113, 40);
		panelOk.add(lblOk);
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Dialog", Font.BOLD, 19));
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AlmenosDos.class.getResource("/images/warning.png")));
		label.setBounds(10, 22, 50, 50);
		contentPane.add(label);
		
		lblDebeCrearAl = new JLabel("Debe crear al menos dos clases.");
		lblDebeCrearAl.setFont(new Font("Dialog", Font.BOLD, 17));
		lblDebeCrearAl.setBounds(58, 27, 318, 41);
		contentPane.add(lblDebeCrearAl);
		
		
	}

}
