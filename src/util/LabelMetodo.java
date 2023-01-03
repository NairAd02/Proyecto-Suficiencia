package util;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class LabelMetodo extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	public LabelMetodo(String cadena, PanelClase p, boolean isAbstracto){
		setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pe.getPe().getPanelHerramDesp().setVisible(false);
	 			pe.getPe().getPanelArchivoDesp().setVisible(false);
				pe.setLabelSeleccionado((LabelMetodo) e.getComponent());
			}
		});
		pe = p;
		if(isAbstracto)
			setFont(new Font("Segoe Script", Font.PLAIN, 16));
		 setText(cadena);
		 
		 setComponentPopupMenu(new MenuContextualMetodo(pe, LabelMetodo.this));
	}

}
