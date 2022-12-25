package Interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import util.ClaseTableModel;
import Clases.Clase;
import Logica.Operaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Estadisticas extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Principal pe;

	private JPanel panelSalir;

	private JLabel lblSalir;
	private JLabel labelImg;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblEs;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel lblOredenar;
	private JComboBox comboBoxOrdenar;
	private JLabel lblTotal;
	private JLabel lblClasesConcretas;
	private JLabel lblClaseslAbstractas;
	private JLabel lblMetodosAbstractos;
	private JLabel lblMetodosConcretos;
	private JLabel lblTotalMetodos;
	private JLabel lblTotalClases;
	private JLabel lblInformacionDeLos;
	private JLabel lblTotal_1;
	private JLabel lblTotalAtributos;
	private JLabel lblInformacionDeLos_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblTotalAbstractos;
	private JLabel lblTotalConcretos;
	private JSeparator separator_1;
	private JLabel lblInformacionesDeLos;
	private JSeparator separator;
	private JLabel lblInformacionDeLas;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel labelClaseMasRelaciones;


	/**
	 * Create the frame.
	 */
	public Estadisticas(Principal p) {
		pe = p;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 804, 629);
		setUndecorated(true);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelSalir = new JPanel();
		
		setLocationRelativeTo(null);
		panelSalir.setBounds(754, -1, 50, 48);
		contentPane.add(panelSalir);
		panelSalir.setBackground(new Color(153, 204, 204));
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pe.setEnabled(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(new Color(153, 204, 204));
			}
		});
		panelSalir.setLayout(null);

		lblSalir = new JLabel();
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBounds(0, 0, 50, 48);
		panelSalir.add(lblSalir);
		lblSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/cross.png")));

		labelImg = new JLabel("");
		labelImg.setIcon(new ImageIcon(Estadisticas.class.getResource("/images/leaderboardsSimple.png")));
		//labelImg.setIcon(new ImageIcon(Estadisticas.class.getResource("/images/leaderboardsSimple.png")));
		labelImg.setBounds(10, 5, 50, 50);
		contentPane.add(labelImg);

		lblEs = new JLabel("Estad\u00EDsticas de las clases");
		lblEs.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 19));
		lblEs.setBounds(70, 21, 257, 26);
		contentPane.add(lblEs);

		panel = new JPanel();
		panel.setBounds(10, 112, 372, 491);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new ClaseTableModel());
		actualizarTablaAlfameticamenteAsc();
		scrollPane.setViewportView(table);

		label3 = new JLabel("Total:");
		label3.setFont(new Font("Dialog", Font.BOLD, 14));
		label3.setBounds(420, 112, 50, 26);
		contentPane.add(label3);

		label4 = new JLabel("Concretas:");
		label4.setFont(new Font("Dialog", Font.BOLD, 14));
		label4.setBounds(419, 141, 90, 26);
		contentPane.add(label4);

		label5 = new JLabel("Abstractas:");
		label5.setFont(new Font("Dialog", Font.BOLD, 14));
		label5.setBounds(563, 141, 96, 26);
		contentPane.add(label5);

		lblOredenar = new JLabel("Oredenar por:");
		lblOredenar.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblOredenar.setBounds(14, 87, 85, 14);
		contentPane.add(lblOredenar);

		comboBoxOrdenar = new JComboBox();
		comboBoxOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxOrdenar.getSelectedIndex()==0)
					actualizarTablaAlfameticamenteAsc();
				else if (comboBoxOrdenar.getSelectedIndex()==1)
					actualizarTablaAlfameticamenteDesc();
				else if (comboBoxOrdenar.getSelectedIndex()==2)
					actualizarTablaCantMetodosAsc();
				else if (comboBoxOrdenar.getSelectedIndex()==3)
					actualizarTablaCantMetodosDesc();
				else if (comboBoxOrdenar.getSelectedIndex()==4)
					actualizarTablaCantAtributosAsc();
				else if (comboBoxOrdenar.getSelectedIndex()==5)
					actualizarTablaCantAtributosDesc();



			}
		});
		comboBoxOrdenar.setModel(new DefaultComboBoxModel(new String[] {"Alfab\u00E9ticamente Ascendente", "Alfab\u00E9ticamente Descendente", "Cantidad Metodos Ascendentes", "Cantidad Metodos Descendentes", "Cantidad Atributos Ascendentes", "Cantidad Atributos Descendentes"}));
		comboBoxOrdenar.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBoxOrdenar.setBounds(97, 85, 205, 20);
		contentPane.add(comboBoxOrdenar);
		
		lblInformacionDeLas = new JLabel("Informaci\u00F3n de las Clases");
		lblInformacionDeLas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInformacionDeLas.setBounds(491, 66, 205, 14);
		contentPane.add(lblInformacionDeLas);
		
		lblInformacionesDeLos = new JLabel("Informaci\u00F3n de los m\u00E9todos");
		lblInformacionesDeLos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInformacionesDeLos.setBounds(480, 200, 227, 14);
		contentPane.add(lblInformacionesDeLos);
		
		lblTotalAbstractos = new JLabel("Abstractos:");
		lblTotalAbstractos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotalAbstractos.setBounds(563, 288, 85, 14);
		contentPane.add(lblTotalAbstractos);
		
		lblTotalConcretos = new JLabel("Concretos:");
		lblTotalConcretos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotalConcretos.setBounds(420, 288, 90, 14);
		contentPane.add(lblTotalConcretos);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotal.setBounds(421, 263, 76, 14);
		contentPane.add(lblTotal);
		
		lblClasesConcretas = new JLabel(String.valueOf(pe.getDiagrama().cantClasesConcretas()));
		lblClasesConcretas.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblClasesConcretas.setBounds(507, 148, 46, 14);
		contentPane.add(lblClasesConcretas);
		
		lblClaseslAbstractas = new JLabel(String.valueOf(pe.getDiagrama().cantClasesAbstractas()));
		lblClaseslAbstractas.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblClaseslAbstractas.setBounds(650, 149, 46, 14);
		contentPane.add(lblClaseslAbstractas);
		
		lblMetodosAbstractos = new JLabel(String.valueOf(pe.getDiagrama().cantMetodosAbstractos()));
		lblMetodosAbstractos.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblMetodosAbstractos.setBounds(658, 290, 46, 14);
		contentPane.add(lblMetodosAbstractos);
		
		lblMetodosConcretos = new JLabel(String.valueOf(pe.getDiagrama().cantMetodosConcretos()));
		lblMetodosConcretos.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblMetodosConcretos.setBounds(507, 290, 46, 14);
		contentPane.add(lblMetodosConcretos);
		
		lblTotalMetodos = new JLabel(String.valueOf(pe.getDiagrama().totalMetodos()));
		lblTotalMetodos.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblTotalMetodos.setBounds(507, 263, 46, 14);
		contentPane.add(lblTotalMetodos);
		
		lblTotalClases = new JLabel(String.valueOf(pe.getDiagrama().totalClases()));
		lblTotalClases.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblTotalClases.setBounds(507, 118, 46, 14);
		contentPane.add(lblTotalClases);
		
		lblInformacionDeLos = new JLabel("Informaci\u00F3n de los atributos");
		lblInformacionDeLos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInformacionDeLos.setBounds(480, 345, 227, 14);
		contentPane.add(lblInformacionDeLos);
		
		lblTotal_1 = new JLabel("Total:");
		lblTotal_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotal_1.setBounds(420, 396, 76, 14);
		contentPane.add(lblTotal_1);
		
		lblTotalAtributos = new JLabel(String.valueOf(pe.getDiagrama().totalAtributos()));
		lblTotalAtributos.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblTotalAtributos.setBounds(507, 398, 46, 14);
		contentPane.add(lblTotalAtributos);
		
		lblInformacionDeLos_1 = new JLabel("Informaci\u00F3n de los par\u00E1metros");
		lblInformacionDeLos_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInformacionDeLos_1.setBounds(475, 421, 245, 26);
		contentPane.add(lblInformacionDeLos_1);
		
		label = new JLabel("Total:");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(420, 472, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel(String.valueOf(pe.getDiagrama().totalParametros()));
		label_1.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		label_1.setBounds(507, 474, 46, 14);
		contentPane.add(label_1);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(457, 87, 263, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(457, 225, 263, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(457, 370, 263, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(457, 452, 263, 2);
		contentPane.add(separator_3);
		
		JLabel labelReportes = new JLabel("Reportes");
		labelReportes.setHorizontalAlignment(SwingConstants.CENTER);
		labelReportes.setFont(new Font("Dialog", Font.BOLD, 16));
		labelReportes.setBounds(516, 503, 138, 26);
		contentPane.add(labelReportes);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(457, 534, 263, 2);
		contentPane.add(separator_4);
		
		JLabel lblClaseConMas = new JLabel("Clase con mas relaciones:");
		lblClaseConMas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblClaseConMas.setBounds(420, 557, 190, 14);
		contentPane.add(lblClaseConMas);
		
		labelMasRelaciones();



	}
	
	private void labelMasRelaciones(){
		String text = null;
		ArrayList<Clase> clasesMasRelaciones = pe.getDiagrama().claseMasRelaciones();
		
		if(clasesMasRelaciones.size()!=0 && clasesMasRelaciones.get(0).cantRelaciones() != 0)
			text = clasesMasRelaciones.get(0).getNombre();
		else
			text = "No existen relaciones";
		labelClaseMasRelaciones = new JLabel(text);
		labelClaseMasRelaciones.setFont(new Font("Dialog", Font.BOLD, 14));
		labelClaseMasRelaciones.setBounds(620, 557, 174, 14);
		contentPane.add(labelClaseMasRelaciones);
	}

	private void actualizarTablaAlfameticamenteAsc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		
		Operaciones.ordenarClasesNombreMayor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}

	private void actualizarTablaAlfameticamenteDesc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		Operaciones.ordenarClasesNombreMenor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}

	private void actualizarTablaCantAtributosAsc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		Operaciones.ordenarCantidadAtributosMayor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}

	private void actualizarTablaCantAtributosDesc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		Operaciones.ordenarCantidadAtributosMenor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}

	private void actualizarTablaCantMetodosAsc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		Operaciones.ordenarCantidadMetodosMayor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}

	private void actualizarTablaCantMetodosDesc(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		clases = pe.getDiagrama().getClases();
		Operaciones.ordenarCantidadMetodosMenor(clases);
		reiniciarTable();
		for(int i=0;i<pe.getDiagrama().getClases().size();i++){
			((ClaseTableModel) table.getModel()).adicionar(pe.getDiagrama().getClases().get(i));
		}
	}
	
	private void reiniciarTable(){
		
		for(int i=0;table.getRowCount()!=0;i++){
			i=0;
			((ClaseTableModel) table.getModel()).removeRow(i);
		}
	}
}
