package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.LabelArchivoGuardado;
import Logica.ManejoDirectorios;

public class FrameDecisor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSalir;
	private JLabel lblTexto;
	private JPanel panelSalir;
	private JPanel panelCancelar;
	private JFrame pe;
	private LabelArchivoGuardado la;
	private String nombreDiagrama;
	private JLabel lblnull;


	/**
	 * Create the frame.
	 */


	public FrameDecisor(JFrame p, LabelArchivoGuardado l) {
		pe = p;
		la = l;
		
		if(pe instanceof Principal)
			nombreDiagrama = ((Principal) pe).getDiagrama().getNombre();
		else if(pe instanceof DiagramasAbrir)
			nombreDiagrama = ((DiagramasAbrir) pe).getPe().getDiagrama().getNombre();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 509, 224);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTexto = new JLabel("Desea guardar los cambios efectuados en");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Dialog", Font.BOLD, 19));
		lblTexto.setBounds(10, 41, 489, 46);
		contentPane.add(lblTexto);

		panelSalir = new JPanel();
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSalir.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSalir.setBackground(SystemColor.inactiveCaptionBorder);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(pe instanceof Principal){
					try {
						ManejoDirectorios.guardarArchivo(((Principal) pe).getDiagrama());
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					
					System.exit(0);
				}
				else{
					try {
						ManejoDirectorios.guardarArchivo(((DiagramasAbrir) pe).getPe().getDiagrama());
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
					la.cargarArchivo();
				}

				
				dispose();
			}
		});
		panelSalir.setBounds(20, 135, 138, 55);
		panelSalir.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panelSalir);
		panelSalir.setLayout(null);

		lblSalir = new JLabel("Guardar");
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(18, 7, 113, 40);
		panelSalir.add(lblSalir);
		lblSalir.setFont(new Font("Dialog", Font.BOLD, 19));


		panelCancelar = new JPanel();
		panelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCancelar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
			}
			@Override
			public void mousePressed(MouseEvent e) {
               pe.setEnabled(true);
               dispose();
			}
		});
		panelCancelar.setBounds(361, 135, 138, 55);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panelCancelar);
		panelCancelar.setLayout(null);

		JLabel lblCancelar = new JLabel("   Cancelar");
		lblCancelar.setBounds(14, 7, 120, 40);
		panelCancelar.add(lblCancelar);
		lblCancelar.setFont(new Font("Dialog", Font.BOLD, 19));

		JPanel panelNoGuardar = new JPanel();
		panelNoGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(pe instanceof Principal)
					System.exit(0);
				else if(pe instanceof DiagramasAbrir){
					la.cargarArchivo();
				}
				
				dispose();
				
			}
		});
		panelNoGuardar.setLayout(null);
		panelNoGuardar.setBackground(SystemColor.inactiveCaptionBorder);
		panelNoGuardar.setBounds(190, 135, 138, 55);
		contentPane.add(panelNoGuardar);

		JLabel lblNoGuardar = new JLabel("No Guardar");
		lblNoGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoGuardar.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNoGuardar.setBounds(10, 11, 113, 33);
		panelNoGuardar.add(lblNoGuardar);
		
		lblnull = new JLabel("          \""+ nombreDiagrama +"\"");
		lblnull.setHorizontalAlignment(SwingConstants.LEFT);
		lblnull.setFont(new Font("Dialog", Font.BOLD, 19));
		lblnull.setBounds(10, 78, 489, 46);
		contentPane.add(lblnull);

	}


	public JLabel getLblTexto() {
		return lblTexto;
	}


	public void setTextoLblTexto(String texto) {
		this.lblTexto.setText(texto);
	}
}
