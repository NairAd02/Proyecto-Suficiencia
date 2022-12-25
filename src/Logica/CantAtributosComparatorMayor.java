package Logica;

import java.util.Comparator;

import Clases.Clase;

public class CantAtributosComparatorMayor implements Comparator<Clase>{

	@Override
	public int compare(Clase clase1, Clase clase2) {
		
		return clase1.cantAtributos()-clase2.cantAtributos();
	}

}
