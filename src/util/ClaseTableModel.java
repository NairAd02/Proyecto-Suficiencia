package util;

import javax.swing.table.DefaultTableModel;

import Clases.Clase;

public class ClaseTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	

	public ClaseTableModel(){

		String[] columnNames = {"Clase","N Atributos","N Métodos", "N Relaciones"};    
		this.setColumnIdentifiers(columnNames); 
		this.isCellEditable(getRowCount(), getColumnCount());

	}
	
	public void adicionar(Clase c){
		Object[] newRow = new Object[]{c.getNombre(), c.cantAtributos() , c.cantMetodos()};
		addRow(newRow);
	}
	
	
	public boolean isCellEditable(int row, int column){
		boolean x=false;
		if(column==3)
			x=true;
		else
			x=false;
		
		return x;
			
		
	}
	
}


	

