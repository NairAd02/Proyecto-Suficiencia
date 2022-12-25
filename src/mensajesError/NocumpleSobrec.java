package mensajesError;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import javax.swing.border.LineBorder;

public class NocumpleSobrec extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JFrame pe;

	private JPanel panelOK;
	private JLabel label_1;
	private JLabel lblElMtodoNo;


	/**
	 * Create the frame.
	 */
	public NocumpleSobrec(JFrame p) {
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
		
		panelOK = new JPanel();
		panelOK.setLayout(null);
		panelOK.setBackground(SystemColor.inactiveCaptionBorder);
		panelOK.setBounds(128, 78, 138, 55);
		panelOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				panelOK.setBackground(new Color(104,137,148));
			}
			public void mouseExited(MouseEvent e){
				panelOK.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelOK);
		
		JLabel label = new JLabel("OK");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 19));
		label.setBounds(10, 8, 113, 40);
		panelOK.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(NocumpleSobrec.class.getResource("/images/warning.png")));
		label_1.setBounds(10, 21, 50, 50);
		contentPane.add(label_1);
		
		lblElMtodoNo = new JLabel("El m\u00E9todo no cumple con la sobrecarga.");
		lblElMtodoNo.setFont(new Font("Dialog", Font.BOLD, 17));
		lblElMtodoNo.setBounds(58, 26, 318, 41);
		contentPane.add(lblElMtodoNo);
	}
}
