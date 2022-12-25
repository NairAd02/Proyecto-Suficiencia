package Logica;

import java.util.Comparator;

import Clases.Clase;

public class NombreComparatorMenor implements  Comparator<Clase> {

	@Override
	public int compare(Clase clase1, Clase clase2) {
		
		return clase2.getNombre().compareTo(clase1.getNombre());
	}

}
