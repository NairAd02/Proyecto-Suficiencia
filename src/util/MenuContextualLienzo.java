package util;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Interfaz.AgregarClase;
import Interfaz.Principal;
import Interfaz.SeleccionClaseA;
import mensajesError.AlmenosDos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuContextualLienzo extends JPopupMenu {
	private static final long serialVersionUID = 1L;

	private Principal pe;
	private JMenuItem mntmCancelar;
	private JMenuItem mntmEstablecerRelacin;
	private JMenuItem mntmAgregarClase;
	public MenuContextualLienzo(Principal p){

		mntmAgregarClase = new JMenuItem("Agregar Clase");
		mntmAgregarClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AgregarClase cl = new AgregarClase(pe);
				cl.setVisible(true);
				pe.setEnabled(false);
				pe.getPant().setEnabled(false);

			}
		});
		add(mntmAgregarClase);

		mntmEstablecerRelacin = new JMenuItem("Establecer Relaci\u00F3n");
		mntmEstablecerRelacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pe.setEliminarPressed(false);
				pe.setEditarPressed(false);
				pe.setRelacionesPressed(true);
				if(pe.getLienzo().getComponentCount()>1) {
					pe.setHerencia(true);
					SeleccionClaseA sele = new SeleccionClaseA(pe);
					sele.setVisible(true);
					setEnabled(false);
					pe.setHerencia(true); 
					pe.setEditar(false); 
					pe.setInsertar(false); 
					pe.setEliminar(false); 
					mntmCancelar.setVisible(true);
					mntmEstablecerRelacin.setVisible(false);
				}
				else  {
					AlmenosDos dos = new AlmenosDos(pe);
					dos.setVisible(true);
					pe.setEnabled(false);
				}
				
			}
		});
		add(mntmEstablecerRelacin);

		mntmCancelar = new JMenuItem("Cancelar Relación");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pe.setHerencia(false);
				pe.setHerenciaClase1(false);	
				pe.setHerenciaClase2(false);	
				mntmCancelar.setVisible(false);
				mntmEstablecerRelacin.setVisible(true);
				pe.getLienzo().cancelarHerencia();
				pe.getLienzo().repaint();
				pe.getLienzo().revalidate();
			}
		});
		add(mntmCancelar);

		mntmCancelar.setVisible(false);
		pe = p;

	}
	public JMenuItem getMntmCancelar() {
		return mntmCancelar;
	}
	public JMenuItem getMntmEstablecerRelacin() {
		return mntmEstablecerRelacin;
	}
	
	



}
