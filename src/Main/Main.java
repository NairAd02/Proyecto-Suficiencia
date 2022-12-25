package Main;

import java.awt.EventQueue;

import Clases.Diagrama;
import Interfaz.Principal;

public class Main {

	
	
	public static void main(String[] args) {

		System.out.println("Me");
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
