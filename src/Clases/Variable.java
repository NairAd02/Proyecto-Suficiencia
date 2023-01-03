package Clases;

import java.io.Serializable;

public abstract class Variable implements TipoValidable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String tipoDato;
	
	
	public Variable(String tipoDato) {
		
		this.setTipoDato(tipoDato);;
	}
	
	
	public boolean validarTipo() {
		return false;
	}
	
	
	public String getTipoDato() {
		return this.tipoDato;
	}
	
	
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	protected boolean equalsTipoDato(Variable v){
		boolean verificador = false;
		
		if(this.tipoDato.equals(v.getTipoDato()))
			verificador = true;
		
		return verificador;
	}
	

}
