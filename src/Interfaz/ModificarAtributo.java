package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mensajesError.AtributosMismoName;
import util.PanelClase;
import Clases.Atributo;
import Logica.Operaciones;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class ModificarAtributo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private PanelClase pe;

	private JPanel panelCancelar;

	private JLabel labelCancelar;

	private JPanel panelConfirmar;

	private JLabel labelModificar;
	private JLabel labelTitulo;
	private JComboBox<String> comboBoxAcceso;
	private JLabel labelAccesos;
	private JLabel lblTipoDeDato;
	private JLabel labelNombre;
	private JTextField textFieldNombre;
	private JTextField textFieldTipoDato;

	private int mouseX;
	private int mouseY;
	private JLabel lblNewLabel;
	private JLabel lblRojo;
	private JLabel labelSeleccionado;


	/**
	 * Create the frame.
	 */
	public ModificarAtributo(PanelClase p, JLabel l) {
		pe = p;
		labelSeleccionado = l;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 391, 280);
		setUndecorated(true);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();

				setLocation(x - mouseX , y - mouseY );

			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY= e.getY();
			}
		});
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelConfirmar = new JPanel();
		panelConfirmar.setLayout(null);
		panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
		panelConfirmar.setBounds(42, 216, 98, 38);
		panelConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean x = true;
				String acceso = null;
				
				if(!textFieldNombre.getText().equals("") && !textFieldTipoDato.getText().equals("") && Operaciones.isNumeroPrimeraPosicion(textFieldNombre.getText()) && Operaciones.isNumeroPrimeraPosicion(textFieldTipoDato.getText())){
        
				try {
					pe.getPe().getDiagrama().modificarAtributo(pe.getClaseSeleccionada().getLblNombreclase().getText()
							,Operaciones.obtenerNombreLabelAtributo(labelSeleccionado.getText()),
							new Atributo(textFieldNombre.getText(), textFieldTipoDato.getText(), String.valueOf(comboBoxAcceso.getSelectedItem())));
				} catch (Exception e1) {
					AtributosMismoName sameName = new AtributosMismoName(ModificarAtributo.this);
					sameName.setVisible(true);
					setEnabled(false);
					x = false;
					
				}

				if(x){
					if(String.valueOf(comboBoxAcceso.getSelectedItem()).equals("private"))
						acceso = "-";
					else if (String.valueOf(comboBoxAcceso.getSelectedItem()).equals("public"))
						acceso = "+";
					else if (String.valueOf(comboBoxAcceso.getSelectedItem()).equals("protected"))
						acceso = "#";



					labelSeleccionado.setText(acceso+" "+textFieldNombre.getText()+
							":"+" "+textFieldTipoDato.getText());
					pe.getPe().repintarClase(pe);
					pe.getClaseSeleccionada().repaint();
					pe.getClaseSeleccionada().revalidate();
					pe.getPe().setEnabled(true);
					dispose();
				}
				}
				else{
					lblRojo.setVisible(true);
				}

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelConfirmar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
				lblRojo.setVisible(false);
			}
		});
		contentPane.add(panelConfirmar);

		labelModificar = new JLabel("Modificar");

		labelModificar.setBounds(10, 1, 82, 33);
		panelConfirmar.add(labelModificar);
		labelModificar.setFont(new Font("Dialog", Font.BOLD, 16));


		panelCancelar = new JPanel();
		panelCancelar.setLayout(null);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		panelCancelar.setBounds(254, 216, 98, 38);
		panelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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

		labelCancelar = new JLabel(" Cancelar");
		labelCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		labelCancelar.setBounds(10, 1, 82, 33);
		panelCancelar.add(labelCancelar);

		labelTitulo = new JLabel("Modificar Atributo:");
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		labelTitulo.setBounds(20, 11, 149, 38);
		contentPane.add(labelTitulo);

		comboBoxAcceso = new JComboBox<String>();
		comboBoxAcceso.setModel(new DefaultComboBoxModel(new String[] {"public", "private", "protected"}));
		if(Operaciones.obtenerModificadorAccesoAtributo(labelSeleccionado.getText()).equals("+"))
			comboBoxAcceso.setSelectedIndex(0);
		else if(Operaciones.obtenerModificadorAccesoAtributo(labelSeleccionado.getText()).equals("-"))
			comboBoxAcceso.setSelectedIndex(1);
		else if(Operaciones.obtenerModificadorAccesoAtributo(labelSeleccionado.getText()).equals("#"))
			comboBoxAcceso.setSelectedIndex(2);

		comboBoxAcceso.setFont(new Font("Dialog", Font.BOLD, 13));

		comboBoxAcceso.setBounds(199, 61, 119, 24);
		contentPane.add(comboBoxAcceso);

		labelAccesos = new JLabel("Modificador de acceso:");
		labelAccesos.setFont(new Font("Dialog", Font.BOLD, 14));
		labelAccesos.setBounds(20, 60, 187, 25);
		contentPane.add(labelAccesos);

		lblTipoDeDato = new JLabel("Tipo de Dato:");
		lblTipoDeDato.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipoDeDato.setBounds(16, 146, 124, 25);
		contentPane.add(lblTipoDeDato);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		labelNombre.setBounds(42, 110, 68, 25);
		contentPane.add(labelNombre);

		textFieldNombre = new JTextField(Operaciones.obtenerNombreLabelAtributo(labelSeleccionado.getText()));
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textFieldNombre.getSelectedText()==null)
				textFieldNombre.setText(textFieldNombre.getText().trim());
			}
		});
		textFieldNombre.setForeground(Color.LIGHT_GRAY);
		textFieldNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textFieldNombre.getText().equals(Operaciones.obtenerNombreLabelAtributo(labelSeleccionado.getText()))){
					textFieldNombre.setText("");
					textFieldNombre.setForeground(Color.black);
				}
				if(textFieldTipoDato.getText().equals("")){
					textFieldTipoDato.setText(Operaciones.obtenerTipoDatoLabel(labelSeleccionado.getText()));
					textFieldTipoDato.setForeground(Color.lightGray);
				}
			}
		});
		textFieldNombre.setBounds(154, 112, 164, 24);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldTipoDato = new JTextField(Operaciones.obtenerTipoDatoLabel(labelSeleccionado.getText()));
		textFieldTipoDato.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textFieldTipoDato.getSelectedText()==null)
				textFieldTipoDato.setText(textFieldTipoDato.getText().trim());
			}
		});
		textFieldTipoDato.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(textFieldTipoDato.getText().equals(Operaciones.obtenerTipoDatoLabel(labelSeleccionado.getText()))){
					textFieldTipoDato.setText("");
					textFieldTipoDato.setForeground(Color.black);
				}
				if(textFieldNombre.getText().equals("")){
					textFieldNombre.setText(Operaciones.obtenerNombreLabelAtributo(labelSeleccionado.getText()));
					textFieldNombre.setForeground(Color.lightGray);
				}
			}
		});
		textFieldTipoDato.setForeground(Color.LIGHT_GRAY);
		textFieldTipoDato.setColumns(10);
		textFieldTipoDato.setBounds(154, 148, 164, 24);
		contentPane.add(textFieldTipoDato);
		
		lblNewLabel = new JLabel(labelSeleccionado.getText());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(167, 19, 214, 23);
		contentPane.add(lblNewLabel);
		
		lblRojo = new JLabel("Es necesario completar ambos campos");
		lblRojo.setVisible(false);
		lblRojo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRojo.setForeground(Color.RED);
		lblRojo.setBounds(42, 191, 257, 14);
		contentPane.add(lblRojo);


	}
}
