package Clases;

import java.io.Serializable;

public class Asociacion extends Clase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Concreta clase1;
	private Concreta clase2;

	public Asociacion(String nombre, Concreta clase1, Concreta clase2, int posicionX, int posicionY) throws Exception {
		super(nombre, posicionX, posicionY);
        this.setClase1(clase1);
        this.setClase2(clase2);

	}
	
	public Asociacion(){
		super();
	}

	public void setClase1(Concreta clase1) {
		if(clase1!=null && clase1 instanceof Concreta)
			this.clase1 = clase1;
		else
			throw new IllegalArgumentException();
	}

	public void setClase2(Concreta clase2) {
		if(clase1!=null && clase1 instanceof Concreta)
			this.clase2 = clase2;
		else
			throw new IllegalArgumentException();
	}

	public Concreta getClase1() {
		return clase1;
	}

	public Concreta getClase2() {
		return clase2;
	}

}
