package mensajesError;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import Interfaz.AgregarMetodo;
import Interfaz.ModificarMetodo;

import javax.swing.border.LineBorder;

public class AbstractoAConcreta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JFrame pe;
	private JLabel label;
	private JLabel lblEstIntentandoAgregar;
	private JPanel panelSi;
	private JLabel lblSi;
	private JPanel panelNo;
	private JLabel lblNo;


	/**
	 * Create the frame.
	 */
	public AbstractoAConcreta(JFrame p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 424, 188);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AbstractoAConcreta.class.getResource("/images/warning.png")));
		label.setBounds(8, 11, 50, 50);
		contentPane.add(label);
		
		lblEstIntentandoAgregar = new JLabel("Est\u00E1 intentando agregar un m\u00E9todo abstracto");
		lblEstIntentandoAgregar.setFont(new Font("Dialog", Font.BOLD, 17));
		lblEstIntentandoAgregar.setBounds(58, 32, 366, 23);
		contentPane.add(lblEstIntentandoAgregar);
		
		JLabel lblAUnaClase = new JLabel("a una clase concreta. Desea cambiarla a abstracta?");
		lblAUnaClase.setFont(new Font("Dialog", Font.BOLD, 17));
		lblAUnaClase.setBounds(10, 50, 404, 41);
		contentPane.add(lblAUnaClase);
		
		panelSi = new JPanel();
		panelSi.setLayout(null);
		panelSi.setBackground(SystemColor.inactiveCaptionBorder);
		panelSi.setBounds(30, 110, 138, 55);
		panelSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(pe instanceof AgregarMetodo){
				((AgregarMetodo) pe).getPe().getLblNombreclase().setFont(new Font("Segoe Script", Font.PLAIN, 16));
				try {
					((AgregarMetodo) pe).getPe().getPe().getDiagrama().modificarClase(((AgregarMetodo) pe).getPe().getLblNombreclase().getText());
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				try {
					((AgregarMetodo) pe).addMetodoDiagrama();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((AgregarMetodo) pe).addMetodoUml();
				}
				else if (pe instanceof ModificarMetodo){
					((ModificarMetodo) pe).getPe().getLblNombreclase().setFont(new Font("Segoe Script", Font.PLAIN, 16));
					try {
						((ModificarMetodo) pe).getPe().getPe().getDiagrama().modificarClase(((ModificarMetodo) pe).getPe().getLblNombreclase().getText());
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					try {
						((ModificarMetodo) pe).modificarMetodoDiagrama();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					((ModificarMetodo) pe).modificarMetodoUml();
					
				}
				pe.setEnabled(true);
				pe.dispose();
				
				dispose();
				
				
			}
			public void mouseEntered(MouseEvent e) {
				panelSi.setBackground(new Color(104,137,148));
			}
			public void mouseExited(MouseEvent e){
				panelSi.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelSi);
		
		lblSi = new JLabel("SI");
		lblSi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSi.setFont(new Font("Dialog", Font.BOLD, 19));
		lblSi.setBounds(10, 8, 113, 40);
		panelSi.add(lblSi);
		
		panelNo = new JPanel();
		panelNo.setLayout(null);
		panelNo.setBackground(SystemColor.inactiveCaptionBorder);
		panelNo.setBounds(253, 110, 138, 55);
		panelNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				panelNo.setBackground(new Color(104,137,148));
			}
			public void mouseExited(MouseEvent e){
				panelNo.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panelNo);
		
		lblNo = new JLabel("NO");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNo.setBounds(10, 8, 113, 40);
		panelNo.add(lblNo);
	}
}
