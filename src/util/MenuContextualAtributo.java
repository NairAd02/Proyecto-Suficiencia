package util;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.ModificarAtributo;
import Logica.Operaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextualAtributo  extends JPopupMenu{
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	public MenuContextualAtributo(PanelClase p){
		pe = p;
		
		JMenuItem mntmEliminaratributo = new JMenuItem("EliminarAtributo");
		mntmEliminaratributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(Operaciones.obtenerNombreLabelAtributo(pe.getLabelSeleccionado().getText()));
				pe.getPe().getDiagrama().eliminarAtributo(pe.getClaseSeleccionada().getLblNombreclase().getText(),
						Operaciones.obtenerNombreLabelAtributo(pe.getLabelSeleccionado().getText()));
				pe.getPanelAtributos().remove(pe.getLabelSeleccionado());
				pe.getPanelAtributos().repaint();
				pe.getPanelAtributos().revalidate();
			}
		});
		
		JMenuItem mntmModificarAtributo = new JMenuItem("Modificar Atributo");
		mntmModificarAtributo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ModificarAtributo modiAtri = new ModificarAtributo(pe);
				modiAtri.setVisible(true);
				pe.getPe().setEnabled(false);
			}
		});
		add(mntmModificarAtributo);
		add(mntmEliminaratributo);
		
		
	}
	


}
