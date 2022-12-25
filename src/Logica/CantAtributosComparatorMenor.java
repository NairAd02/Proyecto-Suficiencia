package Logica;

import java.util.Comparator;

import Clases.Clase;

public class CantAtributosComparatorMenor implements Comparator<Clase>{

	@Override
	public int compare(Clase clase1, Clase clase2) {
		// TODO Auto-generated method stub
		return clase2.cantAtributos()-clase1.cantAtributos();
	}

}
