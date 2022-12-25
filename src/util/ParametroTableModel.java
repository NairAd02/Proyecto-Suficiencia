package util;

import javax.swing.table.DefaultTableModel;

import Clases.Parametro;

public class ParametroTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public ParametroTableModel(){

		String[] columnNames = {"Parámetro"};    
		this.setColumnIdentifiers(columnNames); 
		

	}
	
	public void adicionar(Parametro p){
		Object[] newRow = new Object[]{p.getTipoDato()};
		addRow(newRow);
	}
	
	
	

}
