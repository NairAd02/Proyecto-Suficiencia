package Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Metodo implements TipoValidable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String modificadorAcceso;
	private boolean abstracto;
	private String tipoRetorno;
	private ArrayList<Parametro> parametros;




	public Metodo(String nombre, String modificadorAcceso, boolean abstracto,
			String tipoRetorno, ArrayList<Parametro> parametros) {

		this.setNombre(nombre);
		this.setModificadorAcceso(modificadorAcceso);
		this.setParametros(parametros);
		this.setTipoRetorno(tipoRetorno);
		this.setAbstracto(abstracto);
	}
	
	public Metodo(){}





	public String getModificadorAcceso() {
		return modificadorAcceso;
	}





	public void setModificadorAcceso(String modificadorAcceso) {
		this.modificadorAcceso = modificadorAcceso;
	}





	public String getTipoRetorno() {
		return tipoRetorno;
	}





	public ArrayList<Parametro> getParametros() {
		return parametros;
	}

	public int cantParametros(){
		return this.parametros.size();
	}

	public void setParametros(ArrayList<Parametro> parametros) {
		if(parametros!=null)
			this.parametros = parametros;
		else
			throw new IllegalArgumentException();
	}

	public void setNombre(String nombre) {
		if(nombre!=null && !nombre.equals(""))
			this.nombre = nombre;
		else
			throw new IllegalArgumentException();

	}

	public void setTipoRetorno(String tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}


	public boolean isAbstracto() {
		return abstracto;
	}

	public void setAbstracto(boolean abstracto) {
		this.abstracto = abstracto;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean validarTipo() {

		return false;
	}

	public boolean comprobarParametros(ArrayList<String> parametros){
		boolean x = true;

		if(parametros.size()==this.parametros.size()){

			for(int i=0; i<this.parametros.size() && x==true;i++){
				if(!parametros.get(i).equals(this.parametros.get(i).getTipoDato()))
					x = false;

			}
		}
		else{
			x = false;
		}

		return x;
	}

	public boolean equals(Metodo m){
		boolean verificador = false;
		if(this.equalsNombre(m) && this.equalsModificadorAcceso(m) && this.equalsisAbstracta(m) && this.equalsTipoRetorno(m) && this.equalsParametros(m))
			verificador = true;

		return verificador;
	}


	private boolean equalsNombre(Metodo m){
		boolean verificador = false;

		if(m.getNombre().equals(this.nombre))
			verificador = true;

		return verificador;
	}

	private boolean equalsModificadorAcceso (Metodo m){
		boolean verificador = false;

		if(m.getModificadorAcceso().equals(this.modificadorAcceso))
			verificador = true;

		return verificador;
	}

	private boolean equalsisAbstracta (Metodo m){
		boolean verificador = false;

		if(m.isAbstracto() == this.isAbstracto())
			verificador = true;

		return verificador;
	}

	private boolean equalsTipoRetorno (Metodo m){
		boolean verificador = false;

		if(m.getTipoRetorno().equals(this.tipoRetorno))
			verificador = true;

		return verificador;
	}

	private boolean equalsParametros (Metodo m){
		boolean verificador = true;
		ArrayList<Parametro> p = m.getParametros();
		if(this.parametros.size() == p.size()){
			for (int i = 0; i < this.parametros.size() && verificador; i++) {
				if(!this.parametros.get(i).equals(p.get(i)))
					verificador = false;
			}
		}
		else
			verificador = false;


		return verificador;
	}


}
