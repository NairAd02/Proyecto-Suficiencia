package util;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.ModificarMetodo;
import Logica.Operaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextualMetodo extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	public MenuContextualMetodo(PanelClase p) {
		pe = p;
		JMenuItem mntmEliminarMetodo = new JMenuItem("Eliminar Metodo");
		mntmEliminarMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println(Operaciones.obtenerParamtrosLabel(pe.getLabelSeleccionado().getText()).size());

                pe.getPe().getDiagrama().eliminarMetodo(pe.getClaseSeleccionada().getLblNombreclase().getText(),
                		Operaciones.obtenerNombreLabelMetodo(pe.getLabelSeleccionado().getText()), Operaciones.obtenerParamtrosLabel(pe.getLabelSeleccionado().getText()));
				pe.getPanelMetodos().remove(pe.getLabelSeleccionado());
				pe.getPanelMetodos().repaint();
				pe.getPanelMetodos().revalidate();
			}
		});
		
		JMenuItem mntmModificarMetodo = new JMenuItem("Modificar Metodo");
		mntmModificarMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ModificarMetodo modiMetod = new ModificarMetodo(pe);
				modiMetod.setVisible(true);
				pe.getPe().setEnabled(false);
			}
		});
		add(mntmModificarMetodo);
		add(mntmEliminarMetodo);
	}

	



}
