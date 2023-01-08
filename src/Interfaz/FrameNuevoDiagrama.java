package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mensajesError.ClasesMismoName;
import util.JTextFieldMejorado;
import util.LabelArchivoGuardado;
import Clases.Diagrama;
import Logica.ManejoDirectorios;
import Logica.Operaciones;

public class FrameNuevoDiagrama extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Principal pe;
	private JLabel labelNombre;
	private JTextFieldMejorado textFieldNombreDiagrama;
    
	private ButtonGroup bg;
	private JPanel panelConfirmar;
	private JLabel labelConfirmar;
	private JPanel panelCancelar;
	private JLabel labelCancelar;
	private JLabel lblErrorTexto;
	private JLabel lblDiagramaSameNameError;

	/**
	 * Create the frame.
	 */
	public FrameNuevoDiagrama(Principal p) {
		pe = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 232);
		setUndecorated(true);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelNombre = new JLabel("Ingrese el nombre del nuevo diagrama");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNombre.setBounds(28, 31, 318, 38);
		contentPane.add(labelNombre);
		
		textFieldNombreDiagrama = new JTextFieldMejorado();
		textFieldNombreDiagrama.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNombreDiagrama.getSelectedText()==null)	
				textFieldNombreDiagrama.setText(textFieldNombreDiagrama.getText().trim());
				
			}
		});
		textFieldNombreDiagrama.setLimite(40);
		textFieldNombreDiagrama.setBounds(28, 75, 360, 34);
		contentPane.add(textFieldNombreDiagrama);
		
		bg = new ButtonGroup();
		
		panelConfirmar = new JPanel();
		panelConfirmar.setLayout(null);
		panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
		panelConfirmar.setBounds(28, 167, 109, 38);
		panelConfirmar.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelConfirmar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);				
				lblErrorTexto.setVisible(false);
				lblDiagramaSameNameError.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!textFieldNombreDiagrama.getText().equals("") && !ManejoDirectorios.isSameName(textFieldNombreDiagrama.getText()) && ManejoDirectorios.comprobarEstadoDeGuardado(pe.getDiagrama())){
					crearNuevoDiagrama();	
				}
				else if(ManejoDirectorios.isSameName(textFieldNombreDiagrama.getText())){
					lblDiagramaSameNameError.setVisible(true);
				}
				else if(!ManejoDirectorios.comprobarEstadoDeGuardado(pe.getDiagrama())){
					System.out.println("No esta guardado");
				}
				else{
					lblErrorTexto.setVisible(true);
				}
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
		panelCancelar.setBounds(279, 167, 109, 38);
		panelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
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
		lblErrorTexto.setBounds(28, 120, 139, 23);
		contentPane.add(lblErrorTexto);
		
		lblDiagramaSameNameError = new JLabel("Ya existe un diagrama con el mismo nombre");
		lblDiagramaSameNameError.setVisible(false);
		lblDiagramaSameNameError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagramaSameNameError.setForeground(Color.RED);
		lblDiagramaSameNameError.setBounds(28, 21, 390, 14);
		contentPane.add(lblDiagramaSameNameError);
		
		
		
	}
	
	public void actualizarLienzo(){
		pe.setLienzo(new Lienzo());	
		pe.getScrollPane().setViewportView(pe.getLienzo());
		pe.actualizarAccionesLienzo();
		pe.getLienzo().repaint();
		pe.getLienzo().revalidate();
		pe.repaint();
		pe.revalidate();
	}
	
	
	
	public void crearNuevoDiagrama(){
		
		Diagrama.setInstance(null);
		pe.setDiagrama(Diagrama.getInstance(textFieldNombreDiagrama.getText()));
		actualizarLienzo();
		pe.habilitarPrograma();
		pe.setEnabled(true);
		dispose();
	}
	
}
