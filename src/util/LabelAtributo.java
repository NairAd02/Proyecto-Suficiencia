package util;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class LabelAtributo extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	 public LabelAtributo(String cadena, PanelClase p){
	 	setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
	 	addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mousePressed(MouseEvent e) {
	 			pe.getPe().getPanelHerramDesp().setVisible(false);
	 			pe.getPe().getPanelArchivoDesp().setVisible(false);
	 			pe.setLabelSeleccionado((LabelAtributo) e.getComponent());
	 		}
	 	});
		 pe = p;
		 setText(cadena);
		 setComponentPopupMenu(new MenuContextualAtributo(pe));
		 
		 
		 
		 
		 
	 }

}
