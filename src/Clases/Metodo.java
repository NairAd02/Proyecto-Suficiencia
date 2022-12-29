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
	
	
    
}
