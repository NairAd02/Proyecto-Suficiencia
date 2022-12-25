package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import panelesAyuda.PanelMoverClase;

import javax.swing.border.LineBorder;

public class Ayuda extends JFrame {
	static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Principal pe;
	private JLabel labelTitulo;
	private JLabel label;
	private JLabel labelSalir;
	private JPanel panelSalir;
	private JSeparator separator;
	private JPanel panelAgregarClase;
	private JLabel lblNewLabel;
	private JSeparator separator_1;
	private JLabel lblMoverClase;
	private JPanel paneMoverClase;
	private JLabel lblModificarClase;
	private JPanel panelModificar;
	private JLabel lblEliminarClase;
	private JPanel panelEliminarClase;
	private JLabel lblAadirAtributo;
	private JPanel panelAnadirAtributo;
	private JSeparator separator_5;
	private JSeparator separator_4;
	private JSeparator separator_3;
	private JSeparator separator_2;
	private JPanel panelModificarAtributo;
	private JSeparator separator_6;
	private JPanel panelEliminarAtributo;
	private JSeparator separator_7;
	private JPanel panelAnadirMetodo;
	private JPanel panelModificarMetodo;
	private JPanel panelEliminarMetodo;
	private JPanel panelZoom;
	private JPanel panelEstadisticas;
	private JLabel lblEstadsticasDelDiagrama;
	private JLabel lblZoomDelDiagrama;
	private JLabel lblEliminarMtodos_1;
	private JLabel lblEliminarMtodos;
	private JLabel lblModificarMtodos;
	private JLabel lblEliminarAtributo;
	private JLabel lblModificarAtributo;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JPanel pantallalAgregarClase;
	private boolean AgregarClaseisPressed, MoverClaseisPressed, ModificarlaseisPressed, EliminarClaseisPressed, AnadirAtributoisPressed,
	ModificarAtributoisPressed, EliminarAtributoisPressed, AnadirMetodoisPressed, ModificarMetodoisPressed, EliminarMetodoisPressed, ZoomisPressed,
	EstadisticaisPressed;
	private JTextPane txtpnLaAccinDe;
	private PanelMoverClase pantallaMoverClase;


	/**
	 * Create the frame.
	 */
	public Ayuda(Principal p) {
		pe = p;
		pantallaMoverClase = new PanelMoverClase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 654, 532);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Ayuda.class.getResource("/images/question1.png")));
		label.setBounds(40, 0, 50, 50);
		contentPane.add(label);
		
		labelTitulo = new JLabel("Panel de Ayuda");
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 19));
		labelTitulo.setBounds(99, 11, 190, 38);
		contentPane.add(labelTitulo);
		
		panelSalir = new JPanel();
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(new Color(0, 89, 134));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(new Color(153, 204, 204));
			}
		});
		panelSalir.setLayout(null);
		panelSalir.setBackground(new Color(153, 204, 204));
		panelSalir.setBounds(604, 0, 50, 50);
		contentPane.add(panelSalir);
		
		labelSalir = new JLabel("");
		labelSalir.setIcon(new ImageIcon(Ayuda.class.getResource("/images/cross1.png")));
		labelSalir.setBounds(0, 0, 50, 50);
		panelSalir.add(labelSalir);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 654, 2);
		contentPane.add(separator);
		
		panelAgregarClase = new JPanel();
		panelAgregarClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = true;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				contentPane.remove(pantallaMoverClase);
				pantallalAgregarClase.setBounds(214, 50, 440, 481);
				contentPane.add(pantallalAgregarClase);
				panelAgregarClase.setBackground(new Color(153,204,204));
				repaint();
				revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!AgregarClaseisPressed)
					panelAgregarClase.setBackground(new Color(153,204,204));
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!AgregarClaseisPressed)
					panelAgregarClase.setBackground(new Color(95, 158, 160));
				
			}
		});
		panelAgregarClase.setForeground(new Color(0, 0, 0));
		panelAgregarClase.setBackground(new Color(95, 158, 160));
		panelAgregarClase.setBounds(0, 52, 212, 38);
		contentPane.add(panelAgregarClase);
		panelAgregarClase.setLayout(null);
		
		lblNewLabel = new JLabel("Agregar clase");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 0, 192, 38);
		panelAgregarClase.add(lblNewLabel);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(0, 90, 212, 2);
		contentPane.add(separator_1);
		
		paneMoverClase = new JPanel();
		paneMoverClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = true;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				paneMoverClase.setBackground(new Color(153,204,204));
				contentPane.remove(pantallalAgregarClase);
				pantallaMoverClase.setBounds(214, 50, 440, 481);
				contentPane.add(pantallaMoverClase);
				repaint();
				revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!MoverClaseisPressed)
					paneMoverClase.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!MoverClaseisPressed)
					paneMoverClase.setBackground(new Color(95, 158, 160));
			}
		});
		paneMoverClase.setForeground(new Color(0, 0, 0));
		paneMoverClase.setLayout(null);
		paneMoverClase.setBackground(new Color(95, 158, 160));
		paneMoverClase.setBounds(0, 92, 212, 38);
		contentPane.add(paneMoverClase);
		
		lblMoverClase = new JLabel("Mover clase");
		lblMoverClase.setBackground(new Color(153, 204, 204));
		lblMoverClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoverClase.setForeground(new Color(0, 0, 0));
		lblMoverClase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMoverClase.setBounds(10, 0, 192, 38);
		paneMoverClase.add(lblMoverClase);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(0, 130, 212, 2);
		contentPane.add(separator_2);
		
		panelModificar = new JPanel();
		panelModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = true;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelModificar.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!ModificarlaseisPressed)
					panelModificar.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!ModificarlaseisPressed)
					panelModificar.setBackground(new Color(95, 158, 160));
			}
		});
		panelModificar.setForeground(new Color(0, 0, 0));
		panelModificar.setLayout(null);
		panelModificar.setBackground(new Color(95, 158, 160));
		panelModificar.setBounds(0, 132, 212, 38);
		contentPane.add(panelModificar);
		
		lblModificarClase = new JLabel("Modificar clase");
		lblModificarClase.setBackground(new Color(153, 204, 204));
		lblModificarClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarClase.setForeground(new Color(0, 0, 0));
		lblModificarClase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificarClase.setBounds(10, 0, 192, 38);
		panelModificar.add(lblModificarClase);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(0, 170, 212, 2);
		contentPane.add(separator_3);
		
		panelEliminarClase = new JPanel();
		panelEliminarClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = true;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelEliminarClase.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!EliminarClaseisPressed)
					panelEliminarClase.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!EliminarClaseisPressed)
					panelEliminarClase.setBackground(new Color(95, 158, 160));
			}
		});
		panelEliminarClase.setForeground(new Color(0, 0, 0));
		panelEliminarClase.setLayout(null);
		panelEliminarClase.setBackground(new Color(95, 158, 160));
		panelEliminarClase.setBounds(0, 172, 212, 38);
		contentPane.add(panelEliminarClase);
		
		lblEliminarClase = new JLabel("Eliminar clase");
		lblEliminarClase.setBackground(new Color(153, 204, 204));
		lblEliminarClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarClase.setForeground(new Color(0, 0, 0));
		lblEliminarClase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarClase.setBounds(10, 0, 192, 38);
		panelEliminarClase.add(lblEliminarClase);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(0, 210, 212, 2);
		contentPane.add(separator_4);
		
		panelAnadirAtributo = new JPanel();
		panelAnadirAtributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = true;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelAnadirAtributo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!AnadirAtributoisPressed)
					panelAnadirAtributo.setBackground(new Color(153,204,204));
					
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!AnadirAtributoisPressed)
					panelAnadirAtributo.setBackground(new Color(95, 158, 160));
			}
		});
		panelAnadirAtributo.setForeground(new Color(0, 0, 0));
		panelAnadirAtributo.setLayout(null);
		panelAnadirAtributo.setBackground(new Color(95, 158, 160));
		panelAnadirAtributo.setBounds(0, 212, 212, 38);
		contentPane.add(panelAnadirAtributo);
		
		lblAadirAtributo = new JLabel("A\u00F1adir atributo");
		lblAadirAtributo.setBackground(new Color(153, 204, 204));
		lblAadirAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirAtributo.setForeground(new Color(0, 0, 0));
		lblAadirAtributo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirAtributo.setBounds(10, 0, 192, 38);
		panelAnadirAtributo.add(lblAadirAtributo);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(0, 250, 212, 2);
		contentPane.add(separator_5);
		
		panelModificarAtributo = new JPanel();
		panelModificarAtributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = true;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelModificarAtributo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!ModificarAtributoisPressed)
					panelModificarAtributo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!ModificarAtributoisPressed)
					panelModificarAtributo.setBackground(new Color(95, 158, 160));
			}
		});
		panelModificarAtributo.setForeground(new Color(0, 0, 0));
		panelModificarAtributo.setLayout(null);
		panelModificarAtributo.setBackground(new Color(95, 158, 160));
		panelModificarAtributo.setBounds(0, 252, 212, 38);
		contentPane.add(panelModificarAtributo);
		
		lblModificarAtributo = new JLabel("Modificar atributo");
		lblModificarAtributo.setBackground(new Color(153, 204, 204));
		lblModificarAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAtributo.setForeground(new Color(0, 0, 0));
		lblModificarAtributo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificarAtributo.setBounds(10, 0, 192, 38);
		panelModificarAtributo.add(lblModificarAtributo);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.WHITE);
		separator_6.setBounds(0, 290, 212, 2);
		contentPane.add(separator_6);
		
		panelEliminarAtributo = new JPanel();
		panelEliminarAtributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = true;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelEliminarAtributo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!EliminarAtributoisPressed)
					panelEliminarAtributo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!EliminarAtributoisPressed)
					panelEliminarAtributo.setBackground(new Color(95, 158, 160));
			}
		});
		panelEliminarAtributo.setForeground(new Color(0, 0, 0));
		panelEliminarAtributo.setLayout(null);
		panelEliminarAtributo.setBackground(new Color(95, 158, 160));
		panelEliminarAtributo.setBounds(0, 292, 212, 38);
		contentPane.add(panelEliminarAtributo);
		
		lblEliminarAtributo = new JLabel("Eliminar atributo");
		lblEliminarAtributo.setBackground(new Color(153, 204, 204));
		lblEliminarAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarAtributo.setForeground(new Color(0, 0, 0));
		lblEliminarAtributo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarAtributo.setBounds(10, 0, 192, 38);
		panelEliminarAtributo.add(lblEliminarAtributo);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.WHITE);
		separator_7.setBounds(0, 330, 212, 2);
		contentPane.add(separator_7);
		
		panelAnadirMetodo = new JPanel();
		panelAnadirMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = true;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelAnadirMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!AnadirMetodoisPressed)
					panelAnadirMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!AnadirMetodoisPressed)
					panelAnadirMetodo.setBackground(new Color(95, 158, 160));
			}
		});
		panelAnadirMetodo.setForeground(new Color(0, 0, 0));
		panelAnadirMetodo.setLayout(null);
		panelAnadirMetodo.setBackground(new Color(95, 158, 160));
		panelAnadirMetodo.setBounds(0, 332, 212, 38);
		contentPane.add(panelAnadirMetodo);
		
		lblModificarMtodos = new JLabel("A\u00F1adir m\u00E9todo");
		lblModificarMtodos.setBackground(new Color(153, 204, 204));
		lblModificarMtodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarMtodos.setForeground(new Color(0, 0, 0));
		lblModificarMtodos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificarMtodos.setBounds(10, 0, 192, 38);
		panelAnadirMetodo.add(lblModificarMtodos);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(Color.WHITE);
		separator_8.setBounds(0, 370, 212, 2);
		contentPane.add(separator_8);
		
		panelModificarMetodo = new JPanel();
		panelModificarMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = true;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelModificarMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!ModificarMetodoisPressed)
					panelModificarMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!ModificarMetodoisPressed)
					panelModificarMetodo.setBackground(new Color(95, 158, 160));
			}
		});
		panelModificarMetodo.setForeground(new Color(0, 0, 0));
		panelModificarMetodo.setLayout(null);
		panelModificarMetodo.setBackground(new Color(95, 158, 160));
		panelModificarMetodo.setBounds(0, 373, 212, 38);
		contentPane.add(panelModificarMetodo);
		
		lblEliminarMtodos = new JLabel("Modificar m\u00E9todo");
		lblEliminarMtodos.setBackground(new Color(153, 204, 204));
		lblEliminarMtodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarMtodos.setForeground(new Color(0, 0, 0));
		lblEliminarMtodos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarMtodos.setBounds(10, 0, 192, 38);
		panelModificarMetodo.add(lblEliminarMtodos);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(Color.WHITE);
		separator_9.setBounds(0, 411, 212, 2);
		contentPane.add(separator_9);
		
		panelEliminarMetodo = new JPanel();
		panelEliminarMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = true;
				ZoomisPressed = false;
				EstadisticaisPressed = false;
				panelEliminarMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!EliminarMetodoisPressed)
					panelEliminarMetodo.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!EliminarMetodoisPressed)
					panelEliminarMetodo.setBackground(new Color(95, 158, 160));
			}
		});
		panelEliminarMetodo.setForeground(new Color(0, 0, 0));
		panelEliminarMetodo.setLayout(null);
		panelEliminarMetodo.setBackground(new Color(95, 158, 160));
		panelEliminarMetodo.setBounds(0, 413, 212, 38);
		contentPane.add(panelEliminarMetodo);
		
		lblEliminarMtodos_1 = new JLabel("Eliminar m\u00E9todo");
		lblEliminarMtodos_1.setBackground(new Color(153, 204, 204));
		lblEliminarMtodos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarMtodos_1.setForeground(new Color(0, 0, 0));
		lblEliminarMtodos_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarMtodos_1.setBounds(10, 0, 192, 38);
		panelEliminarMetodo.add(lblEliminarMtodos_1);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(Color.WHITE);
		separator_10.setBounds(0, 451, 212, 2);
		contentPane.add(separator_10);
		
		panelZoom = new JPanel();
		panelZoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = true;
				EstadisticaisPressed = false;
				panelZoom.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!ZoomisPressed)
					panelZoom.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!ZoomisPressed)
					panelZoom.setBackground(new Color(95, 158, 160));
			}
		});
		panelZoom.setForeground(new Color(0, 0, 0));
		panelZoom.setLayout(null);
		panelZoom.setBackground(new Color(95, 158, 160));
		panelZoom.setBounds(0, 453, 212, 38);
		contentPane.add(panelZoom);
		
		lblZoomDelDiagrama = new JLabel("Zoom del diagrama");
		lblZoomDelDiagrama.setBackground(new Color(153, 204, 204));
		lblZoomDelDiagrama.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoomDelDiagrama.setForeground(new Color(0, 0, 0));
		lblZoomDelDiagrama.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblZoomDelDiagrama.setBounds(10, 0, 192, 38);
		panelZoom.add(lblZoomDelDiagrama);
		
		separator_11 = new JSeparator();
		separator_11.setForeground(Color.WHITE);
		separator_11.setBounds(0, 491, 212, 2);
		contentPane.add(separator_11);
		
		panelEstadisticas = new JPanel();
		panelEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setAllfalse();
				AgregarClaseisPressed = false;
				MoverClaseisPressed = false;
				ModificarlaseisPressed = false;
				EliminarClaseisPressed = false;
				AnadirAtributoisPressed = false;
				ModificarAtributoisPressed = false;
				EliminarAtributoisPressed = false;
				AnadirMetodoisPressed = false;
				ModificarMetodoisPressed = false;
				EliminarMetodoisPressed = false;
				ZoomisPressed = false;
				EstadisticaisPressed = true;
				panelEstadisticas.setBackground(new Color(153,204,204));
				
			}

			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!EstadisticaisPressed)
					panelEstadisticas.setBackground(new Color(153,204,204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(!EstadisticaisPressed)
					panelEstadisticas.setBackground(new Color(95, 158, 160));
			}
		});
		panelEstadisticas.setForeground(new Color(0, 0, 0));
		panelEstadisticas.setLayout(null);
		panelEstadisticas.setBackground(new Color(95, 158, 160));
		panelEstadisticas.setBounds(0, 493, 212, 38);
		contentPane.add(panelEstadisticas);
		
		lblEstadsticasDelDiagrama = new JLabel("Estad\u00EDsticas generales");
		lblEstadsticasDelDiagrama.setBackground(new Color(153, 204, 204));
		lblEstadsticasDelDiagrama.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticasDelDiagrama.setForeground(new Color(0, 0, 0));
		lblEstadsticasDelDiagrama.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEstadsticasDelDiagrama.setBounds(10, 0, 192, 38);
		panelEstadisticas.add(lblEstadsticasDelDiagrama);
		
		pantallalAgregarClase = new JPanel();
		pantallalAgregarClase.setBackground(new Color(153, 204, 204));
		pantallalAgregarClase.setBounds(214, 50, 440, 481);
		contentPane.add(pantallalAgregarClase);
		pantallalAgregarClase.setLayout(null);
		
		txtpnLaAccinDe = new JTextPane();
		txtpnLaAccinDe.setEnabled(true);
		txtpnLaAccinDe.setEditable(false);
		txtpnLaAccinDe.setBackground(new Color(153, 204, 204));
		txtpnLaAccinDe.setText("La acci\u00F3n de agregar una clase puede ser realizada de dos formas:\r\n\u2022 Presione click en el boton superior del conjunto de botones de la izquiera o presione clik derecho sobre la pantalla y en el menu contextual que se abre presione el bot\u00F3n de agregar clase");
		txtpnLaAccinDe.setBounds(10, 50, 420, 127);
		pantallalAgregarClase.add(txtpnLaAccinDe);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Ayuda.class.getResource("/images/AgregarClaseButton.PNG")));
		lblNewLabel_1.setBounds(10, 297, 92, 77);
		pantallalAgregarClase.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Ayuda.class.getResource("/images/AgregarClaseContextual.PNG")));
		lblNewLabel_2.setBounds(162, 297, 92, 26);
		pantallalAgregarClase.add(lblNewLabel_2);
		
		JLabel lblAgregarClase = new JLabel("Agregar Clase");
		lblAgregarClase.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAgregarClase.setBounds(10, 11, 112, 28);
		pantallalAgregarClase.add(lblAgregarClase);
		
		
		
	}
	
	private void setAllfalse() {
		panelAgregarClase.setBackground(new Color(95, 158, 160));
		paneMoverClase.setBackground(new Color(95, 158, 160));
		panelModificar.setBackground(new Color(95, 158, 160));
		panelEliminarClase.setBackground(new Color(95, 158, 160));
		panelAnadirAtributo.setBackground(new Color(95, 158, 160));
		panelModificarAtributo.setBackground(new Color(95, 158, 160));
		panelEliminarAtributo.setBackground(new Color(95, 158, 160));
		panelAnadirMetodo.setBackground(new Color(95, 158, 160));
		panelModificarMetodo.setBackground(new Color(95, 158, 160));
		panelEliminarMetodo.setBackground(new Color(95, 158, 160));
		panelZoom.setBackground(new Color(95, 158, 160));
		panelEstadisticas.setBackground(new Color(95, 158, 160));
	}
}
