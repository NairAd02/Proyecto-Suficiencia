package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldMejorado extends JTextField{
	
	public JTextFieldMejorado() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField) e.getSource();
				if (text.getText().length() == limite)
				e.consume();
				}
		});
	}
	
	private static final long serialVersionUID = 1L;
	
	private int limite = -1;
	
	public int getLimite() {
	return this.limite;
	}
	public void setLimite(int limite) {
	if (limite >= -1)
	this.limite = limite;
	}

}
