package mensajesError;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Interfaz.ModificarClase;
import javax.swing.border.LineBorder;

public class AbstractaAConcreta extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JFrame pe;
	private JLabel label;
	private JLabel lblEstIntentandoAgregar;
	private JPanel panelSi;
	private JLabel lblSi;
	private JPanel panelNo;
	private JLabel lblNo;
	private JLabel lblDeseaContinuar;


	/**
	 * Create the frame.
	 */
	public AbstractaAConcreta(JFrame p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 427, 201);
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

		lblEstIntentandoAgregar = new JLabel("Al convertir la clase a Concreta, sus m\u00E9todos");
		lblEstIntentandoAgregar.setFont(new Font("Dialog", Font.BOLD, 17));
		lblEstIntentandoAgregar.setBounds(58, 32, 366, 23);
		contentPane.add(lblEstIntentandoAgregar);

		JLabel lblAUnaClase = new JLabel("abstractos tambi\u00E9n ser\u00E1n convertidos en concretos.");
		lblAUnaClase.setFont(new Font("Dialog", Font.BOLD, 17));
		lblAUnaClase.setBounds(10, 50, 414, 41);
		contentPane.add(lblAUnaClase);

		panelSi = new JPanel();
		panelSi.setLayout(null);
		panelSi.setBackground(SystemColor.inactiveCaptionBorder);
		panelSi.setBounds(30, 124, 138, 55);
		panelSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((ModificarClase) pe).cambiarMetodosAbstractosAConcretos();
               
               
               try {
				((ModificarClase) pe).modificarClaseAbstractaDiagrama();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               ((ModificarClase) pe).convertirMetodosAbstractosAConcretosUml();
               ((ModificarClase) pe).modificarClaseAbstractaUml();
               pe.setEnabled(false);
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
		panelNo.setBounds(253, 124, 138, 55);
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
		
		lblDeseaContinuar = new JLabel("Desea continuar con la conversi\u00F3n?");
		lblDeseaContinuar.setFont(new Font("Dialog", Font.BOLD, 17));
		lblDeseaContinuar.setBounds(8, 82, 404, 31);
		contentPane.add(lblDeseaContinuar);

	}
}
