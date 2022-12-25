package Logica;


import java.util.ArrayList;
import java.util.Collections;

import Clases.Clase;

public class Operaciones {
	
	public static String obtenerNombreLabelAtributo(String label){
		char[] labelChar = label.toCharArray();
		String retorno = "";
		
		for(int i=2; labelChar[i]!=':';i++){
			retorno+=labelChar[i];
		}
		
		return retorno;
	}
	
	
	public static String obtenerNombreLabelMetodo(String label){
		char[] labelChar = label.toCharArray();
		String retorno = "";

		for(int i=2; labelChar[i]!='(';i++){
			retorno+=labelChar[i];
		}

		return retorno;
	}

	public static ArrayList<String> obtenerParamtrosLabel(String label){
		char[] labelChar = label.toCharArray();
		String retorno = "";
		ArrayList<String> parametros = new ArrayList<String>();
		int posicion = posicionParentesis(labelChar);
		if(labelChar[posicion+1]!=')'){
			for(int i=posicion+1; labelChar[i]!=':';i++){
				if(labelChar[i]!=',' && labelChar[i]!=' ' && labelChar[i] !=')')
					retorno+= labelChar[i];
				else{
					if(labelChar[i]!=' '){
						parametros.add(retorno);
						retorno = "";
					}
				}


			}
		}

		return parametros;

	}

	private static int posicionParentesis(char[] labelChar){
		int posicion = -1;

		for(int i=0; i<labelChar.length && posicion==-1;i++){
			if(labelChar[i]=='(')
				posicion = i;

		}

		return posicion;


	}
	
	public static String obtenerTipoDatoLabel(String label){
		char[] labelChar = label.toCharArray();
		String retorno = "";
		int posicion = posicionDosPuntos(labelChar);
		 for(int i = posicion+2;i<labelChar.length;i++){
			 retorno+=labelChar[i];
		 }
		 
		 return retorno;
	}
	
	private static int posicionDosPuntos(char[] labelChar){
		int posicion = -1;
		
		for(int i=0; i<labelChar.length && posicion==-1;i++){
			if(labelChar[i]==':')
				posicion = i;

		}
		
		return posicion;
		
	}
	
	public static String obtenerModificadorAccesoAtributo(String label){
		return label.substring(0, 1);
		
	}
	
	public static boolean isNumeroPrimeraPosicion(String texto){
		boolean x = true;
		char[] textoChar = texto.toCharArray();
		
		if(Character.isDigit(textoChar[0]))
				x = false;
		
		return x ;
	}
	
	
	
	
	public static void ordenarClasesNombreMayor(ArrayList<Clase> clases){
		Collections.sort(clases,new NombreComparatorMayor());
	}

	public static void ordenarClasesNombreMenor(ArrayList<Clase> clases){
		Collections.sort(clases,new NombreComparatorMenor());
	}

	public static void ordenarCantidadAtributosMayor(ArrayList<Clase> clases){
		Collections.sort(clases,new CantAtributosComparatorMayor());
	}

	public static void ordenarCantidadAtributosMenor(ArrayList<Clase> clases){
		Collections.sort(clases,new CantAtributosComparatorMenor());
	}

	public static void ordenarCantidadMetodosMayor(ArrayList<Clase> clases){
		Collections.sort(clases,new CantMetodosComparatorMayor());
	}

	public static void ordenarCantidadMetodosMenor(ArrayList<Clase> clases){
		Collections.sort(clases,new CantMetodosComparatorMenor());
	}
	
	

}
