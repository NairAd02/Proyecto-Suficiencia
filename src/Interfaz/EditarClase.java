package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.PanelClase;

import javax.swing.border.LineBorder;

import Clases.Clase;
import Clases.Diagrama;

public class EditarClase extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private PanelClase pe;

	private int mouseX;
	private int mouseY;
	private JLabel lblEditarClase;
	private JLabel labelNombre;

	private ButtonGroup bg;
	private JPanel panel_1;
	private JPanel panel;
	private JRadioButton rdbtnGris;
	private JRadioButton rdbtnColorAmarillo;
	private JRadioButton rdbtnColorAzul;

	/**
	 * Create the frame.
	 */
	public EditarClase(PanelClase p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 363, 173);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblEditarClase = new JLabel("Editar clase:");
		lblEditarClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEditarClase.setBounds(10, 11, 125, 37);
		contentPane.add(lblEditarClase);
		
		labelNombre = new JLabel("NombreClase");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		labelNombre.setBounds(135, 11, 125, 37);
		contentPane.add(labelNombre);
		
		JLabel lblSeleccioneElColor = new JLabel("Seleccione el color de la clase:");
		lblSeleccioneElColor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSeleccioneElColor.setBounds(20, 47, 250, 37);
		contentPane.add(lblSeleccioneElColor);
		
		rdbtnGris = new JRadioButton("Gris");
		rdbtnGris.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnGris.setBackground(new Color(153, 204, 204));
		rdbtnGris.setBounds(10, 90, 91, 23);
		contentPane.add(rdbtnGris);
		
		rdbtnColorAmarillo = new JRadioButton("Amarillo");
		rdbtnColorAmarillo.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnColorAmarillo.setBackground(new Color(153, 204, 204));
		rdbtnColorAmarillo.setBounds(135, 90, 91, 23);
		contentPane.add(rdbtnColorAmarillo);
		
		rdbtnColorAzul = new JRadioButton("Azul");
		rdbtnColorAzul.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnColorAzul.setBackground(new Color(153, 204, 204));
		rdbtnColorAzul.setBounds(254, 91, 91, 23);
		contentPane.add(rdbtnColorAzul);

		bg = new ButtonGroup();
		bg.add(rdbtnGris);
		bg.add(rdbtnColorAmarillo);
		bg.add(rdbtnColorAzul);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(37, 124, 98, 38);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				cambiarColorClase();
				pe.getPe().setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panel);
		
		JLabel lblEditar = new JLabel("    Editar");
		lblEditar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEditar.setBounds(10, 1, 82, 33);
		panel.add(lblEditar);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(222, 124, 98, 38);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.getPe().setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_1.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel(" Cancelar");
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(10, 1, 82, 33);
		panel_1.add(label_1);
		
		seleccionarRadioButton();


	}
	
	private void seleccionarRadioButton(){
		if(pe.getBackground().equals(SystemColor.info))
			rdbtnColorAmarillo.setSelected(true);
		else if (pe.getBackground().equals(SystemColor.activeCaption))
			rdbtnColorAzul.setSelected(true);
		else if (pe.getBackground().equals(SystemColor.control))
				rdbtnGris.setSelected(true);
	}
	
	private void cambiarColorClase(){
	Clase clase =Diagrama.getInstance().buscarClase(pe.getClaseSeleccionada().getLblNombreclase().getText());
		if(rdbtnColorAmarillo.isSelected()){
			pe.setBackground(SystemColor.info);
			pe.getPanelAtributos().setBackground(SystemColor.info);
			pe.getPanelMetodos().setBackground(SystemColor.info);
			clase.setColor("Amarillo");
			
		}
		else if(rdbtnColorAzul.isSelected()){
			pe.setBackground(SystemColor.activeCaption);
			pe.getPanelAtributos().setBackground(SystemColor.activeCaption);
			pe.getPanelMetodos().setBackground(SystemColor.activeCaption);
			clase.setColor("Azul");
			
		}
		else if(rdbtnGris.isSelected()){
			pe.setBackground(SystemColor.control);
			pe.getPanelAtributos().setBackground(SystemColor.control);
			pe.getPanelMetodos().setBackground(SystemColor.control);
			clase.setColor("Gris");
		}
		
		pe.repaint();
		pe.revalidate();
	}
}
