package util;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import Clases.Diagrama;
import Interfaz.DiagramasAbrir;
import Interfaz.FrameDecisor;
import Interfaz.Principal;
import Logica.ManejoDirectorios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LabelArchivoGuardado extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal pe;
	private DiagramasAbrir di;
	
	
	public Principal getPe() {
		return pe;
	}

	public DiagramasAbrir getDi() {
		return di;
	}

	public LabelArchivoGuardado(String nombre, Principal p, DiagramasAbrir d){
		pe = p;
		di = d;
		setOpaque(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(95, 158, 160));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(153, 204, 204));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(ManejoDirectorios.comprobarEstadoDeGuardado(pe.getDiagrama())){
					cargarArchivo();
				}
				else{
					FrameDecisor decisor = new FrameDecisor(di, LabelArchivoGuardado.this);
					decisor.setVisible(true);
					di.setEnabled(false);
				}
			}
		});
		setHorizontalAlignment(SwingConstants.LEFT);
		setText(nombre);
		setBackground(new Color(153, 204, 204));
		setFont(new Font("Dialog", Font.BOLD, 24));
		setVisible(true);

	}

	public void cargarArchivo(){
		Diagrama diagrama = null;
		try {
			diagrama = (Diagrama) ManejoDirectorios.recuperarArchivo(getText());
			System.out.println(diagrama.getLienzo());
			Diagrama.setInstance(diagrama);
			pe.setDiagrama(diagrama);
			pe.setLienzo(diagrama.getLienzo());	
			pe.getScrollPane().setViewportView(pe.getLienzo());
			pe.actualizarAccionesLienzo();
			pe.habilitarPrograma();
			pe.getLienzo().repaint();
			pe.getLienzo().revalidate();
			pe.repaint();
			pe.revalidate();
			pe.setEnabled(true);
			di.dispose();
			


		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}


}
