package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mensajesError.AbstractoAConcreta;
import mensajesError.NocumpleSobrec;
import Clases.*;
import Logica.Operaciones;


import util.JTextFieldMejorado;
import util.LabelMetodo;
import util.PanelClase;
import util.ParametroTableModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class AgregarMetodo extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private PanelClase pe;

	private JPanel panelCancelar;

	private JLabel labelCancelar;

	private JPanel panelConfirmar;

	private JLabel labelConfirmar;
	private JLabel labelTitulo;
	private JComboBox<String> comboBoxAcceso;
	private JLabel labelAccesos;
	private JLabel lblTipoDeRetorno;
	private JLabel labelNombre;
	private JTextFieldMejorado textFieldNombre;
	private JTextFieldMejorado textFieldTipoDato;
    private boolean x;
    private boolean isAbstracto;
  
	private int mouseX;
	private int mouseY;
	private JLabel lblParmetros;
	private JPanel panel;
	private JTextFieldMejorado textFieldParam;
	private JScrollPane scrollPane;
	private JLabel labelPlus;
	private JLabel labelMinus;
	private JPanel panelPlus;
	private JPanel panelMinus;
	private JTable table;
	private ButtonGroup bg;
	private JRadioButton rdbtnAbstracto;
	private JRadioButton rdbtnConcreto;
	private JLabel labelRojoCampos;
	private JLabel labelRojoParametros;
	private JSeparator separator;
	private JLabel lblTipoDeMtodo;
	private JLabel lblA;




	public void setX(boolean x) {
		this.x = x;
	}

	public PanelClase getPe() {
		return pe;
	}
	

	

	/**
	 * Create the frame.
	 */
	public AgregarMetodo(PanelClase p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 610, 266);
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
				table.setColumnSelectionAllowed(false);
				table.setCellSelectionEnabled(false);
				table.clearSelection();
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
		panelConfirmar.setBounds(338, 219, 98, 38);
		panelConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = true;
				isAbstracto = false;
				
				if(!textFieldNombre.getText().equals("")&&!textFieldTipoDato.getText().equals("")&&(rdbtnAbstracto.isSelected()||rdbtnConcreto.isSelected())
						&& Operaciones.isNumeroPrimeraPosicion(textFieldNombre.getText()) && Operaciones.isNumeroPrimeraPosicion(textFieldTipoDato.getText())){

					if (rdbtnAbstracto.isSelected()){
						
						isAbstracto = true;
					}

					try {
						addMetodoDiagrama();
					} catch (Exception e1) {
						if(e1.getMessage().equals("No cumple sobreCarga")){
						NocumpleSobrec no = new NocumpleSobrec(AgregarMetodo.this);
						no.setVisible(true);
						setEnabled(false);
						
						}
						else if (e1.getMessage().equals("Metodo Abstracto")){
							AbstractoAConcreta absCon = new AbstractoAConcreta(AgregarMetodo.this);
							absCon.setVisible(true);
							setEnabled(false);
										
						}
						x = false;
					}

					if(x){
						addMetodoUml();
					}

				}
				else{
					if(textFieldNombre.getText().equals("")||textFieldTipoDato.getText().equals(""))
						labelRojoCampos.setVisible(true);
					if(!rdbtnAbstracto.isSelected()&&!rdbtnConcreto.isSelected());
				}

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelConfirmar.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelConfirmar.setBackground(SystemColor.inactiveCaptionBorder);
				labelRojoCampos.setVisible(false);
			}
		});
		contentPane.add(panelConfirmar);

		labelConfirmar = new JLabel("  Agregar");

		labelConfirmar.setBounds(10, 1, 82, 33);
		panelConfirmar.add(labelConfirmar);
		labelConfirmar.setFont(new Font("Dialog", Font.BOLD, 16));


		panelCancelar = new JPanel();
		panelCancelar.setLayout(null);
		panelCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		panelCancelar.setBounds(490, 219, 98, 38);
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

		labelTitulo = new JLabel("Ingrese los datos del nuevo m\u00E9todo:");
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		labelTitulo.setBounds(25, 11, 318, 38);
		contentPane.add(labelTitulo);

		comboBoxAcceso = new JComboBox<String>();
		comboBoxAcceso.setModel(new DefaultComboBoxModel<String>(new String[] {"public", "private", "protected"}));
		comboBoxAcceso.setFont(new Font("Dialog", Font.BOLD, 13));
		comboBoxAcceso.setBounds(194, 123, 119, 24);
		contentPane.add(comboBoxAcceso);

		labelAccesos = new JLabel("Modificador de acceso:");
		labelAccesos.setFont(new Font("Dialog", Font.BOLD, 14));
		labelAccesos.setBounds(15, 122, 187, 25);
		contentPane.add(labelAccesos);

		lblTipoDeRetorno = new JLabel("     Tipo de Retorno:");
		lblTipoDeRetorno.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipoDeRetorno.setBounds(0, 194, 142, 25);
		contentPane.add(lblTipoDeRetorno);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		labelNombre.setBounds(71, 158, 68, 25);
		contentPane.add(labelNombre);

		textFieldNombre = new JTextFieldMejorado();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textFieldNombre.getSelectedText()==null)
				textFieldNombre.setText(textFieldNombre.getText().trim());
			}
		});
		textFieldNombre.setLimite(50);
		textFieldNombre.setBounds(149, 158, 164, 24);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldTipoDato = new JTextFieldMejorado();
		textFieldTipoDato.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textFieldTipoDato.getSelectedText()==null)
				textFieldTipoDato.setText(textFieldTipoDato.getText().trim());
			}
		});
		textFieldTipoDato.setLimite(50);
		textFieldTipoDato.setColumns(10);
		textFieldTipoDato.setBounds(149, 194, 164, 24);
		contentPane.add(textFieldTipoDato);

		lblParmetros = new JLabel("Nombre:");
		lblParmetros.setFont(new Font("Dialog", Font.BOLD, 12));
		lblParmetros.setBounds(439, 81, 113, 14);
		contentPane.add(lblParmetros);

		panel = new JPanel();
		panel.setBounds(338, 81, 91, 117);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				table.setColumnSelectionAllowed(false);
				table.setCellSelectionEnabled(false);
				table.clearSelection();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);
			}
		});
		table.setModel(new ParametroTableModel());
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		textFieldParam = new JTextFieldMejorado();
		textFieldParam.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textFieldParam.getSelectedText()==null)
				textFieldParam.setText(textFieldParam.getText().trim());
			}
		});
		textFieldParam.setLimite(30);
		textFieldParam.setBounds(439, 97, 122, 20);
		contentPane.add(textFieldParam);
		textFieldParam.setColumns(10);

		panelPlus = new JPanel();
		panelPlus.setBounds(519, 147, 50, 50);
		panelPlus.setBackground(new Color(153,204,204));
		panelPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textFieldParam.getText().equals("")){
					Parametro para = new Parametro(textFieldParam.getText());
					((ParametroTableModel) table.getModel()).adicionar(para);
					textFieldParam.setText("");
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelPlus.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelPlus.setBackground(new Color(153,204,204));
			}
		});
		contentPane.add(panelPlus);
		panelPlus.setLayout(null);

		labelPlus = new JLabel("");
		labelPlus.setBounds(0, 0, 50, 50);
		panelPlus.add(labelPlus);
		labelPlus.setIcon(new ImageIcon(AgregarMetodo.class.getResource("/images/plus.png")));

		panelMinus = new JPanel();
		panelMinus.setBounds(439, 147, 50, 50);
		panelMinus.setBackground(new Color(153,204,204));
		panelMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRowCount()!=0)
              elimniarParametros();
				else
					labelRojoParametros.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelMinus.setBackground(new Color(104,137,148));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelMinus.setBackground(new Color(153,204,204));
				labelRojoParametros.setVisible(false);
			}
		});
		contentPane.add(panelMinus);
		panelMinus.setLayout(null);

		labelMinus = new JLabel("");
		labelMinus.setBounds(0, 0, 50, 50);
		panelMinus.add(labelMinus);
		labelMinus.setIcon(new ImageIcon(AgregarMetodo.class.getResource("/images/minus.png")));

		rdbtnAbstracto = new JRadioButton("Abstracto");
		rdbtnAbstracto.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnAbstracto.setBackground(new Color(153,204,204));
		rdbtnAbstracto.setBounds(52, 81, 91, 23);
		contentPane.add(rdbtnAbstracto);

		rdbtnConcreto = new JRadioButton("Concreto");
		rdbtnConcreto.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnConcreto.setBackground(new Color(153,204,204));
		rdbtnConcreto.setBounds(158, 81, 91, 23);
		rdbtnConcreto.setSelected(true);
		contentPane.add(rdbtnConcreto);

		bg = new ButtonGroup();
		bg.add(rdbtnConcreto);
		bg.add(rdbtnAbstracto);
		
		labelRojoCampos = new JLabel("Es necesario completar ambos campos");
		labelRojoCampos.setVisible(false);
		labelRojoCampos.setForeground(Color.RED);
		labelRojoCampos.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelRojoCampos.setBounds(20, 230, 257, 14);
		contentPane.add(labelRojoCampos);
		
		labelRojoParametros = new JLabel("Primero seleccione el par\u00E1metro a remover");
		labelRojoParametros.setVisible(false);
		labelRojoParametros.setForeground(Color.RED);
		labelRojoParametros.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelRojoParametros.setBounds(338, 197, 273, 20);
		contentPane.add(labelRojoParametros);
		
		JLabel label = new JLabel("Remover:");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(439, 128, 61, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("A\u00F1adir:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(519, 128, 50, 20);
		contentPane.add(label_1);
		
		separator = new JSeparator();
		separator.setBounds(25, 72, 252, 2);
		contentPane.add(separator);
		
		lblTipoDeMtodo = new JLabel("Tipo de m\u00E9todo");
		lblTipoDeMtodo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipoDeMtodo.setBounds(95, 47, 119, 27);
		contentPane.add(lblTipoDeMtodo);
		
		lblA = new JLabel("A\u00F1adir Par\u00E1metro:");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblA.setBounds(338, 48, 250, 24);
		contentPane.add(lblA);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(336, 72, 252, 2);
		contentPane.add(separator_1);


	}

	public ArrayList<Parametro> obtenerParametrosTabla(){
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		int cantRows = ((ParametroTableModel)table.getModel()).getRowCount();

		for(int i=0 ;i<cantRows;i++ ){
			parametros.add(new Parametro(String.valueOf(((ParametroTableModel)table.getModel()).getValueAt(i, 0))));
			System.out.println((String.valueOf(((ParametroTableModel)table.getModel()).getValueAt(i, 0))));

		}

		return parametros;

	}

	public ArrayList<String> obtenerStringsTabla(){
		ArrayList<String> parametros = new ArrayList<String>();

		int cantRows = ((ParametroTableModel)table.getModel()).getRowCount();

		for(int i=0 ;i<cantRows;i++ ){
			parametros.add(String.valueOf(((ParametroTableModel)table.getModel()).getValueAt(i, 0)));

		}

		return parametros;


	}
	
	public void addMetodoUml(){
		String acceso = null;
		
		if(String.valueOf(comboBoxAcceso.getSelectedItem()).equals("private"))
			acceso = "-";
		else if (String.valueOf(comboBoxAcceso.getSelectedItem()).equals("public"))
			acceso = "+";
		else if (String.valueOf(comboBoxAcceso.getSelectedItem()).equals("protected"))
			acceso = "#";
		
	
		if(obtenerStringsTabla().size()!=0)
			pe.getClaseSeleccionada().getPanelMetodos().add(new LabelMetodo(acceso+" "+textFieldNombre.getText()+"("+mostrarParametros(obtenerStringsTabla())+")"+
					":"+" "+textFieldTipoDato.getText(),pe, isAbstracto));
		else
			pe.getClaseSeleccionada().getPanelMetodos().add(new LabelMetodo(acceso+" "+textFieldNombre.getText()+"()"+
					":"+" "+textFieldTipoDato.getText(),pe , isAbstracto));


		pe.getPe().repintarClase(pe);
		pe.getClaseSeleccionada().repaint();
		pe.getClaseSeleccionada().revalidate();
		pe.getPe().setEnabled(true);
		dispose();
	}
	
	public void addMetodoDiagrama() throws Exception{
		pe.getPe().getDiagrama().addMetodo( pe.getClaseSeleccionada().getLblNombreclase().getText(), 
				new Metodo(textFieldNombre.getText(),String.valueOf(comboBoxAcceso.getSelectedItem()),isAbstracto,
						textFieldTipoDato.getText(), obtenerParametrosTabla()));
	}
	

	public String mostrarParametros(ArrayList<String> parametros){
		String mostrar = "";

		for(int i = 0; i<parametros.size();i++){
			mostrar+=parametros.get(i) + ", ";
		}

		return mostrar.substring(0, mostrar.length()-2);

	}

	public void elimniarParametros(){
         
		for(int i=0;table.getSelectedRows().length!=0;i++){
			 System.out.println(table.getSelectedRows().length);
			i=0;	
			((ParametroTableModel)table.getModel()).removeRow(table.getSelectedRows()[i]);

		}

	}
}
