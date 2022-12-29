package util;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import Clases.Diagrama;
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
	public LabelArchivoGuardado(String nombre, Principal p){
		pe = p;
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
				Diagrama diagrama = null;
				try {
					diagrama = (Diagrama) ManejoDirectorios.recuperarArchivo(getText());
					System.out.println(diagrama.getLienzo());
					Diagrama.setInstance(diagrama);
					pe.setDiagrama(diagrama);
					pe.setLienzo(diagrama.getLienzo());	
					pe.getScrollPane().setViewportView(pe.getLienzo());
					pe.getLienzo().repaint();
					pe.getLienzo().revalidate();
					pe.repaint();
					pe.revalidate();
					
								
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		setHorizontalAlignment(SwingConstants.CENTER);
		setText(nombre);
		setBackground(new Color(153, 204, 204));
		setFont(new Font("Dialog", Font.BOLD, 24));
		setVisible(true);

	}
}
