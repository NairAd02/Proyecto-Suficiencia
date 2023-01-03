package util;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.ModificarAtributo;
import Logica.Operaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextualAtributo  extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	
	private PanelClase pe;
	public MenuContextualAtributo(PanelClase p, JLabel l){
		pe = p;
		label = l;
		
		JMenuItem mntmEliminaratributo = new JMenuItem("EliminarAtributo");
		mntmEliminaratributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pe.getPe().getDiagrama().eliminarAtributo(pe.getClaseSeleccionada().getLblNombreclase().getText(),
						Operaciones.obtenerNombreLabelAtributo(label.getText()));
				pe.getPanelAtributos().remove(label);
				pe.getPanelAtributos().repaint();
				pe.getPanelAtributos().revalidate();
			}
		});
		
		JMenuItem mntmModificarAtributo = new JMenuItem("Modificar Atributo");
		mntmModificarAtributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				ModificarAtributo modiAtri = new ModificarAtributo(pe,label);
				modiAtri.setVisible(true);
				pe.getPe().setEnabled(false);
			}
		});
		add(mntmModificarAtributo);
		add(mntmEliminaratributo);
		
		
	}
	


}
