package util;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.ModificarMetodo;
import Logica.Operaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextualMetodo extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	
	private PanelClase pe;
	private JLabel label;
	public MenuContextualMetodo(PanelClase p, JLabel l) {
		pe = p;
		label = l;
		JMenuItem mntmEliminarMetodo = new JMenuItem("Eliminar Metodo");
		mntmEliminarMetodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

                pe.getPe().getDiagrama().eliminarMetodo(pe.getClaseSeleccionada().getLblNombreclase().getText(),
                		Operaciones.obtenerNombreLabelMetodo(label.getText()), Operaciones.obtenerParamtrosLabel(label.getText()));
				pe.getPanelMetodos().remove(label);
				pe.getPanelMetodos().repaint();
				pe.getPanelMetodos().revalidate();
			}
		});
		
		JMenuItem mntmModificarMetodo = new JMenuItem("Modificar Metodo");
		mntmModificarMetodo.addMouseListener(new MouseAdapter()  {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ModificarMetodo modiMetod = new ModificarMetodo(pe,label);
				modiMetod.setVisible(true);
				pe.getPe().setEnabled(false);
			}
		});
		add(mntmModificarMetodo);
		add(mntmEliminarMetodo);
	}

	



}
