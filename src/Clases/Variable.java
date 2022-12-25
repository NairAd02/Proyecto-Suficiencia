package Clases;

public abstract class Variable implements TipoValidable {
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
	

}
