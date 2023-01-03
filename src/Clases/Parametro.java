package Clases;

import java.io.Serializable;

public class Parametro extends Variable implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Parametro( String tipoDato) {
		super(tipoDato);
		
	}
	
	public boolean equals(Parametro p){
		boolean verificador = false;
		
		if(this.equalsTipoDato(p))
			verificador = true;
		
		return verificador;
	}
	
}
