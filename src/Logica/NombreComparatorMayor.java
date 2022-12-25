package Logica;

import java.util.Comparator;

import Clases.Clase;

public class NombreComparatorMayor implements  Comparator<Clase>{

	@Override
	public int compare(Clase clase1, Clase clase2) {
		
		return clase1.getNombre().compareTo(clase2.getNombre());
	}

}
