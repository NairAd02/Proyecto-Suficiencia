package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import Clases.Diagrama;

public class ManejoDirectorios {

	public static void guardarArchivo(Object objeto) throws FileNotFoundException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String stringJson = mapper.writeValueAsString(objeto);
		
		System.out.println(stringJson);
		
		FileWriter writer = new FileWriter("Salvas Diagrama/"+ ((Diagrama) objeto).getNombre()+ ".json");
		writer.write(stringJson);
		writer.flush();
		writer.close();
		
		
	}

	public static Object recuperarArchivo(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException{
		Object objetoArecuperar = null;
		ObjectMapper mapper = new ObjectMapper();
		
		objetoArecuperar = mapper.readValue(new File("Salvas Diagrama/" + ruta ), Diagrama.class);
		 System.out.println(((Diagrama) objetoArecuperar).getNombre());

		return objetoArecuperar;
	}
	
	
	
	public static boolean isSameName(String name){
	       File rutaSalvas = new File("Salvas Diagrama");
	       boolean issameName = false;
			
			String[] list = rutaSalvas.list();
			
			for (String s : list) {
				if(s.equals(name))
					issameName = true;
			}
			
			return issameName;
		}
	
	public static boolean comprobarEstadoDeGuardado(Diagrama diagramaActual){
		boolean isGuardado = false;
		if(diagramaActual != null){
		
			
			Diagrama d;
			try {
				d = (Diagrama) ManejoDirectorios.recuperarArchivo(diagramaActual.getNombre()+".json");
				if(d.equals(diagramaActual))
					isGuardado = true;
			} catch (FileNotFoundException e) {
				isGuardado = false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		}
		else
			isGuardado = true;
		
		return isGuardado;	
	}

}
