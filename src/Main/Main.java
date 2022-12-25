package Main;

import java.awt.EventQueue;

import Clases.Diagrama;
import Interfaz.Principal;

public class Main {

	
	
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {		

			public void run() {
				try {
					Principal frame = new Principal(new Diagrama());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
