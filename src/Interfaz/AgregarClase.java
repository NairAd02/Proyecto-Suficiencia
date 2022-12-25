package Interfaz;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.*;

import Logica.Operaciones;

import util.JTextFieldMejorado;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarClase extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private Principal pe;
	private JLabel labelNombre;
	private JLabel labelSelec;
	private JRadioButton radioConcreta;
	private JTextFieldMejorado textFieldNombreClase;
	private JRadioButton radioAbstracta;
    
	private ButtonGroup bg;
	private JPanel panelConfirmar;
	private JLabel labelConfirmar;
	private JPanel panelCancelar;
	private JLabel labelCancelar;
	private JLabel lblErrorTexto;
	private JLabel lblErrorRadio;

	/**
	 * Create the frame.
	 */
	public AgregarClase(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 262);
		setUndecorated(true);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelNombre = new JLabel("Ingrese el nombre de la clase a crear:");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNombre.setBounds(28, 22, 318, 38);
		contentPane.add(labelNombre);
		
		labelSelec = new JLabel("Seleccione el tipo de la clase:");
		labelSelec.setFont(new Font("Dialog", Font.BOLD, 16));
		labelSelec.setBounds(28, 125, 318, 23);
		contentPane.add(labelSelec);
		
		textFieldNombreClase = new JTextFieldMejorado();
		textFieldNombreClase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNombreClase.getSelectedText()==null)	
				textFieldNombreClase.setText(textFieldNombreClase.getText().trim());
				
			}
		});
		textFieldNombreClase.setLimite(40);
		textFieldNombreClase.setBounds(28, 61, 360, 34);
		contentPane.add(textFieldNombreClase);
		
		radioConcreta = new JRadioButton("Concreta");
		radioConcreta.setFont(new Font("Dialog", Font.BOLD, 15));
		radioConcreta.setBounds(28, 155, 109, 23);
		radioConcreta.setBackground(new Color(153, 204, 204));
		radioConcreta.setSelected(true);
		contentPane.add(radioConcreta);
		
		radioAbstracta = new JRadioButton("Abstracta");
		radioAbstracta.setFont(new Font("Dialog", Font.BOLD, 15));
		radioAbstracta.setBackground(new Color(153, 204, 204));
		radioAbstracta.setBounds(152, 155, 109, 23);
		contentPane.add(radioAbstracta);
		
		bg = new ButtonGroup();
		bg.add(radioConcreta);
		bg.add(radioAbstracta);
		
		panelConfirmar = new JPanel();
		panelConfirmar.setLayout(null);
		panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
		panelConfirmar.setBounds(62, 206, 109, 38);
		panelConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(isCorrecto()){
				pe.setNombreClase(textFieldNombreClase.getText());
				if(radioAbstracta.isSelected())
					pe.setRadioBotonTipoClase(radioAbstracta.getText());
				else if(radioConcreta.isSelected())
					pe.setRadioBotonTipoClase(radioConcreta.getText());
				
				pe.setEnabled(true);
				pe.getPant().setEnabled(true);
				pe.setInsertar(true);
				dispose();
				}
				else{
					if(textFieldNombreClase.getText().equals(""))
					lblErrorTexto.setVisible(true);
					if(!radioAbstracta.isSelected()&&!radioConcreta.isSelected())
					lblErrorRadio.setVisible(true);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelConfirmar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
				lblErrorRadio.setVisible(false);
				lblErrorTexto.setVisible(false);
			}
		});
		
		
		contentPane.add(panelConfirmar);
		
		labelConfirmar = new JLabel("    Confirmar");
		
		labelConfirmar.setBounds(0, 0, 109, 38);
		panelConfirmar.add(labelConfirmar);
		labelConfirmar.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panelCancelar = new JPanel();
		panelCancelar.setLayout(null);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		panelCancelar.setBounds(268, 206, 109, 38);
		panelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				pe.getPant().setEnabled(true);
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
		
		labelCancelar = new JLabel("     Cancelar");
		labelCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		labelCancelar.setBounds(0, 0, 109, 38);
		panelCancelar.add(labelCancelar);
		
		lblErrorTexto = new JLabel("Es necesario un nombre");
		lblErrorTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorTexto.setForeground(Color.RED);
		lblErrorTexto.setVisible(false);
		lblErrorTexto.setBounds(28, 99, 139, 23);
		contentPane.add(lblErrorTexto);
		
		lblErrorRadio = new JLabel("Seleccione una categor\u00EDa");
		lblErrorRadio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorRadio.setForeground(Color.RED);
		lblErrorRadio.setVisible(false);
		lblErrorRadio.setBounds(267, 155, 151, 23);
		contentPane.add(lblErrorRadio);
		
		
		
	}
	
	public boolean isCorrecto(){
		boolean x = false;
		if(!this.textFieldNombreClase.getText().equals("") && (this.radioAbstracta.isSelected()||
				this.radioConcreta.isSelected()) && Operaciones.isNumeroPrimeraPosicion(textFieldNombreClase.getText()))
			x = true;
		
		return x;
	}
}
