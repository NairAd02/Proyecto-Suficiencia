package Clases;

import java.io.Serializable;

public class Atributo extends Variable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String visibilidad;
	
	public Atributo(String nombre, String tipoDato, String visibilidad) {
		super(tipoDato);
		this.setVisibilidad(visibilidad);
		this.setNombre(nombre);
	}

	public String getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(String visibilidad) {
		this.visibilidad = visibilidad;
	}
	
	public String getNombre() {

		return nombre;
	}
	
	public void setNombre(String nombre) {
	    if(nombre!=null && !nombre.equals(""))
		this.nombre = nombre;
	    else
	    	throw new IllegalArgumentException();
	    	
	}

	

}
