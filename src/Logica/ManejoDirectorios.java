package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Clases.Diagrama;

public class ManejoDirectorios {

	public static void guardarArchivo(Object objeto) throws FileNotFoundException, IOException{
		//System.out.println(((Diagrama)objeto).getLienzo().getComponentCount());
		ObjectOutputStream guardarObjeto = new ObjectOutputStream(new FileOutputStream("Salvas Diagrama/"+((Diagrama)objeto).getNombre() + ".dat"));

		guardarObjeto.writeObject(objeto);
		guardarObjeto.close();
	}

	public static Object recuperarArchivo(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException{
		Object objetoArecuperar = null;
		ObjectInputStream recuperarObjeto = new ObjectInputStream(new FileInputStream("Salvas Diagrama/" + ruta));

		objetoArecuperar = recuperarObjeto.readObject();

		recuperarObjeto.close();

		return objetoArecuperar;
	}

}
