package Logica;

import java.util.Comparator;

import Clases.Clase;

public class CantMetodosComparatorMenor implements Comparator<Clase> {

	@Override
	public int compare(Clase clase1, Clase clase2) {
		
		return clase2.cantMetodos()-clase1.cantMetodos();
	}

}
