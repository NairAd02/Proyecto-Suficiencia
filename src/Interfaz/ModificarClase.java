package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mensajesError.AbstractaAConcreta;
import mensajesError.ClasesMismoName;
import util.PanelClase;
import Clases.*;
import Logica.Operaciones;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class ModificarClase extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private PanelClase pe;
	private JLabel labelNombre;
	private JLabel labelSelec;
	private JRadioButton radioConcreta;
	private JTextField textFieldNombreClase;
	private JRadioButton radioAbstracta;

	private ButtonGroup bg;
	private JPanel panelConfirmar;
	private JLabel labelModificar;
	private JPanel panelCancelar;
	private JLabel labelCancelar;
	private JLabel lblErrorTexto;
	private JLabel lblErrorRadio;
	private JLabel lblNewLabel;
	private ArrayList<JLabel> metodosAbstractos;
	private boolean entrar;

	/**
	 * Create the frame.
	 */
	public ModificarClase(PanelClase p) {
		entrar = true;
		metodosAbstractos = new ArrayList<JLabel>();
		pe = p;
		pe.setMover(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 262);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelNombre = new JLabel("Modificar Clase:");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNombre.setBounds(20, 11, 131, 38);
		contentPane.add(labelNombre);

		labelSelec = new JLabel("Seleccione el tipo de la clase:");
		labelSelec.setFont(new Font("Dialog", Font.BOLD, 16));
		labelSelec.setBounds(28, 125, 318, 23);
		contentPane.add(labelSelec);

		textFieldNombreClase = new JTextField(pe.getLblNombreclase().getText());
		textFieldNombreClase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(entrar){
					textFieldNombreClase.setText("");
					textFieldNombreClase.setForeground(Color.black);
					entrar = false;
				}
				if(textFieldNombreClase.getSelectedText()==null)
				textFieldNombreClase.setText(textFieldNombreClase.getText().trim());
			}
		});
		textFieldNombreClase.setForeground(Color.LIGHT_GRAY);
		textFieldNombreClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(textFieldNombreClase.getText().equals(pe.getLblNombreclase().getText())){
					textFieldNombreClase.setText("");
					textFieldNombreClase.setForeground(Color.black);
				}
			}
		});

		textFieldNombreClase.setBounds(28, 61, 360, 34);
		contentPane.add(textFieldNombreClase);

		radioConcreta = new JRadioButton("Concreta");

		radioConcreta.setFont(new Font("Dialog", Font.BOLD, 15));
		radioConcreta.setBounds(28, 155, 109, 23);
		radioConcreta.setBackground(new Color(153, 204, 204));
		contentPane.add(radioConcreta);

		radioAbstracta = new JRadioButton("Abstracta");

		radioAbstracta.setFont(new Font("Dialog", Font.BOLD, 15));
		radioAbstracta.setBackground(new Color(153, 204, 204));
		radioAbstracta.setBounds(152, 155, 109, 23);
		contentPane.add(radioAbstracta);

		if(pe.getLblNombreclase().getFont().equals(new Font("Segoe Script", Font.PLAIN, 16)))
			radioAbstracta.setSelected(true);
		else if (pe.getLblNombreclase().getFont().equals(new Font("Microsoft YaHei", Font.PLAIN, 16)))
			radioConcreta.setSelected(true);

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
				boolean x = true;
				if(isCorrecto()){
					if(radioAbstracta.isSelected()){
						try {
							modificarClaseConcretaDiagrama();
						} catch (Exception e) {
							ClasesMismoName mismoName = new ClasesMismoName(ModificarClase.this);
							mismoName.setVisible(true);
							setEnabled(false);
                             x = false;
							
						}
					}
					else if (radioConcreta.isSelected()){
						if(tieneMetodosAbstractos()){
							AbstractaAConcreta a = new AbstractaAConcreta(ModificarClase.this);
							a.setVisible(true);
							setEnabled(false);
							x = false;
						}
						else{
							try {
								modificarClaseAbstractaDiagrama();
							} catch (Exception e) {
								ClasesMismoName mismoName = new ClasesMismoName(ModificarClase.this);
								mismoName.setVisible(true);
								setEnabled(false);
								 x = false;							
							}
						}
					}
					if(x){
						modificarClaseFlechas();
						
						if(radioAbstracta.isSelected())
							modificarClaseConcretaUml();
						else if (radioConcreta.isSelected())
							modificarClaseAbstractaUml();

					}
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

		labelModificar = new JLabel("    Modificar");

		labelModificar.setBounds(0, 0, 109, 38);
		panelConfirmar.add(labelModificar);
		labelModificar.setFont(new Font("Dialog", Font.BOLD, 16));

		panelCancelar = new JPanel();
		panelCancelar.setLayout(null);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		panelCancelar.setBounds(268, 206, 109, 38);
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

		labelCancelar = new JLabel("     Cancelar");
		labelCancelar.setFont(new Font("Dialog", Font.BOLD, 16));
		labelCancelar.setBounds(0, 0, 109, 38);
		panelCancelar.add(labelCancelar);

		lblErrorTexto = new JLabel("Es necesario un nombre");
		lblErrorTexto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorTexto.setForeground(Color.RED);
		lblErrorTexto.setVisible(false);
		lblErrorTexto.setBounds(28, 99, 156, 23);
		contentPane.add(lblErrorTexto);

		lblErrorRadio = new JLabel("Seleccione una categor\u00EDa");
		lblErrorRadio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorRadio.setForeground(Color.RED);
		lblErrorRadio.setVisible(false);
		lblErrorRadio.setBounds(267, 155, 151, 23);
		contentPane.add(lblErrorRadio);

		lblNewLabel = new JLabel(pe.getLblNombreclase().getText());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(152, 11, 266, 38);
		contentPane.add(lblNewLabel);



	}

	public boolean isCorrecto(){
		boolean x = false;
		if(!this.textFieldNombreClase.getText().equals("") && (this.radioAbstracta.isSelected()||
				this.radioConcreta.isSelected()) && Operaciones.isNumeroPrimeraPosicion(this.textFieldNombreClase.getText()))
			x = true;

		return x;
	}

	public boolean tieneMetodosAbstractos(){
		boolean x = false;

		Component[] componets = pe.getPanelMetodos().getComponents();


		for(int i = 0; i<componets.length;i++){
			if(((JLabel)componets[i]).getFont().equals(new Font("Segoe Script", Font.PLAIN, 16))){
				metodosAbstractos.add((JLabel)componets[i]);
				x = true;			
			}
		}

		return x;
	}

	public void convertirMetodosAbstractosAConcretosUml(){
		

		for(int i = 0; i<metodosAbstractos.size();i++){
			metodosAbstractos.get(i).setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
				
		}
	}

	public void modificarClaseAbstractaDiagrama() throws Exception{
		pe.getPe().getDiagrama().modificarClase(pe.getLblNombreclase().getText(), new Concreta(textFieldNombreClase.getText()));
	}

	public void modificarClaseConcretaDiagrama() throws Exception{
		pe.getPe().getDiagrama().modificarClase(pe.getLblNombreclase().getText(), new Abstracta(textFieldNombreClase.getText()));

	}

	public void modificarClaseAbstractaUml(){
		pe.getLblNombreclase().setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		modificarClaseUml();
	}

	public void modificarClaseConcretaUml(){
		pe.getLblNombreclase().setFont(new Font("Segoe Script", Font.PLAIN, 16));
		modificarClaseUml();
	}

	private void modificarClaseUml(){
		pe.getLblNombreclase().setText(textFieldNombreClase.getText());
		pe.getPe().repintarClase(pe);
		pe.repaint();
		pe.revalidate();
		pe.getPe().setEnabled(true);
		dispose();
	}

	public void cambiarMetodosAbstractosAConcretos(){
		pe.getPe().getDiagrama().CambiarMetodosAbstractosAConcretos(pe.getLblNombreclase().getText());
	}
	
	private void modificarClaseFlechas(){
		pe.getPe().getLienzo().modificarFlecha(pe.getLblNombreclase().getText(), textFieldNombreClase.getText());
	}

}
