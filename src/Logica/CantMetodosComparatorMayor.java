package Logica;

import java.util.Comparator;

import Clases.Clase;

public class CantMetodosComparatorMayor implements  Comparator<Clase> {

	@Override
	public int compare(Clase clase1, Clase clase2) {
		
		return clase1.cantMetodos()-clase2.cantMetodos();
	}

}
