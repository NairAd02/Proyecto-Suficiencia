package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Clases.Abstracta;
import Clases.Clase;
import Clases.Concreta;
import Clases.Diagrama;

public class DiagramaTestCase {
 private Diagrama diagrama;
	@Before
	public void setUp() throws Exception {
		diagrama = Diagrama.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		diagrama = null;
	}
	//Prueba caja blanca Buscar Método
	@Test
	public void testBuscarClaseCaminoBasico1() throws Exception {
		diagrama.addClase(new Abstracta("Animal"));
		diagrama.addClase(new Concreta("Perro"));
		diagrama.addClase(new Concreta("León"));
		
		assertEquals(null,diagrama.buscarClase("Robot") );
		
	}

	@Test
	public void testBuscarClaseCaminoBasico2() throws Exception {	
		assertEquals(null,diagrama.buscarClase("Robot") );
		
	}
	
	@Test
	public void testBuscarClaseCaminoBasico3() throws Exception {
		diagrama.addClase(new Abstracta("Animal"));
		diagrama.addClase(new Concreta("Perro"));
		diagrama.addClase(new Concreta("León"));
		
		assertEquals(this.diagrama.getClases().get(1),diagrama.buscarClase("Perro") );
		
	}
	
	@Test
	public void testBuscarClaseBucle1() throws Exception {
		diagrama.addClase(new Abstracta("Animal"));
		diagrama.addClase(new Concreta("Perro"));
		diagrama.addClase(new Concreta("León"));
		
		assertEquals(this.diagrama.getClases().get(0),diagrama.buscarClase("Animal") );
		
	}
	
	@Test
	public void testBuscarClaseBucle2() throws Exception {
		diagrama.addClase(new Abstracta("Animal"));
		diagrama.addClase(new Concreta("Perro"));
		diagrama.addClase(new Concreta("León"));
		assertEquals(this.diagrama.getClases().get(2),diagrama.buscarClase("León") );
		
	}
	
	//Fin de prueba
	
	//Pruebas Caja Negra 
	@Test
	public void testAgregarClaseEscenario1()  {
		boolean veredicto = true;
		String valorReal = null;
		try {
			this.diagrama.addClase(new Abstracta("Animal"));
		} catch (Exception e) {
			veredicto = false;
			
		}
		
		if(veredicto)
			valorReal = "Clase añadida exitosamente";
		
		assertTrue("Clase añadida exitosamente".equals(valorReal));
		
	}
	
	@Test
	public void testAgregarClaseEscenario2() throws Exception  {
		this.diagrama.addClase(new Abstracta("Animal"));
		boolean veredicto = true;
		String valorReal = null;
		try {
			this.diagrama.addClase(new Abstracta("Animal"));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Ya existe una clase con el mismo nombre";
		}
		
		if(veredicto)
			valorReal = "Clase añadida exitosamente";
		
		assertTrue("Ya existe una clase con el mismo nombre".equals(valorReal));
		
	}
	
	@Test
	public void testEliminarClaseEscenario1() throws Exception  {
		this.diagrama.addClase(new Concreta("Perro"));
			
		this.diagrama.eliminarClase("Perro");
			
		assertTrue(true);
		
	}
	
	
	

}
