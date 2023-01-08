package Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Concreta extends Clase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Concreta(String nombre, int posicionX, int posicionY) throws Exception {
		super(nombre, posicionX, posicionY);


	}

	public void addMetodo(Metodo metodo) throws Exception{
		if(this.validarMetodo(metodo)){
			if(!metodo.isAbstracto())
				this.metodos.add(metodo);
			else
				throw new Exception("Metodo Abstracto");	

		}
		else{
			
			throw new Exception("No cumple sobreCarga");
		}
	}
	
	public void modificarMetodo(String nombreMetodo, ArrayList<String> parametros, Metodo metodo) throws Exception{
		int posicionAModificar = this.buscarMetodoPosicion(nombreMetodo, parametros);
		if(posicionAModificar!=-1){
			if(this.validarMetodo(metodo, posicionAModificar))
				if(!metodo.isAbstracto())
				this.metodos.set(posicionAModificar, metodo);
				else
					throw new Exception("Metodo Abstracto");
					
			else
				throw new Exception("No cumple sobreCarga");
		}
		else{
			throw new IllegalArgumentException();
		}
	}

}
