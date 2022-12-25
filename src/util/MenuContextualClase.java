package util;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.ModificarClase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextualClase extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	public MenuContextualClase(PanelClase p){
		pe = p;
		
		JMenuItem mntmModificarClase = new JMenuItem("Modificar Clase");
		mntmModificarClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ModificarClase modiClase = new ModificarClase(pe);
				modiClase.setVisible(true);
				pe.getPe().setEnabled(false);
			}
		});
		add(mntmModificarClase);
		
		
		
		
		
	}

}
