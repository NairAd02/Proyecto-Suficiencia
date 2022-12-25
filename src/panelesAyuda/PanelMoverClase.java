package panelesAyuda;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelMoverClase extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelMoverClase() {
		setBackground(new Color(153, 204, 204));
		setLayout(null);
		
		JTextPane txtpnParaRealizarLa = new JTextPane();
		txtpnParaRealizarLa.setEditable(false);
		txtpnParaRealizarLa.setText("Para realizar la acci\u00F3n de mover una clase por el diagrama, basta con situarse con el mouse sobre la clase y aparecer\u00E1 en el cursor un s\u00EDmbolo correspondiente que indicar\u00E1 la acci\u00F3n de mover, de click, mantengalo y sueltelo en el lugar donde quiera que la clase est\u00E9.");
		txtpnParaRealizarLa.setBounds(10, 50, 420, 70);
		txtpnParaRealizarLa.setBackground(new Color(153, 204, 204));
		add(txtpnParaRealizarLa);
		
		JLabel lblMoverClase = new JLabel("Mover Clase");
		lblMoverClase.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMoverClase.setBounds(10, 11, 112, 28);
		add(lblMoverClase);
	}
}
