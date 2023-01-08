package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Clases.Atributo;
import Clases.Concreta;
import Clases.Metodo;
import Clases.Parametro;

public class ConcretaTestCase {
	private Concreta concreta;
	@Before
	public void setUp() throws Exception {
		this.concreta = new Concreta("Animal",0,0);
	}

	@After
	public void tearDown() throws Exception {

	}
	//Tests Caja Blanca
	@Test
	public void testValidarAtributoCamino1() throws Exception {
		this.concreta.addAtributo(new Atributo("nombreX", "int", "public"));
		assertEquals(false, this.concreta.validarAtributo(new Atributo("nombreX", "int", "public")));
	}
	//
	@Test
	public void testValidarAtributoCamino2() throws Exception {
		this.concreta.addAtributo(new Atributo("nombreY", "int", "public"));
		assertEquals(true, this.concreta.validarAtributo(new Atributo("nombreX", "int", "public")));
	}

	@Test
	public void testValidarAtributoCamino4() throws Exception {	
		assertEquals(true, this.concreta.validarAtributo(new Atributo("nombreX", "int", "public")));
	}
	@Test
	public void testValidarAtributoCamino5() throws Exception {	
		assertEquals(false, this.concreta.validarAtributo(null));
	}
	@Test
	public void testValidarAtributoCamino6() throws Exception {	
		this.concreta.addAtributo(new Atributo("nombreY", "int", "public"));
		this.concreta.addAtributo(new Atributo("nombreZ", "int", "public"));
		assertEquals(true, this.concreta.validarAtributo(new Atributo("nombreX", "int", "public")));
	}

	// Fin Test Caja Blanca

	//Tests Caja Negra

	@Test
	public void testAgregarAtributoEscenario1()  {	
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addAtributo(new Atributo("numero", "int", "public"));
		} catch (Exception e) {
			veredicto = false;

		}

		if(veredicto)
			valorReal = "Atributo añadido existosamente";

		assertTrue("Atributo añadido existosamente".equals(valorReal));

	}

	@Test
	public void testAgregarAtributoEscenario2()  {	
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addAtributo(new Atributo(null, null, null));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Datos faltantes";

		}

		if(veredicto)
			valorReal = "Atributo añadido existosamente";

		assertTrue("Datos faltantes".equals(valorReal));

	}

	@Test
	public void testAgregarAtributoEscenario3() throws Exception  {
		this.concreta.addAtributo(new Atributo("numero", "int", "public"));
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addAtributo(new Atributo("numero", "int", "public"));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Ya existe un atributo con el mismo nombre";

		}

		if(veredicto)
			valorReal = "Atributo añadido existosamente";

		assertTrue("Ya existe un atributo con el mismo nombre".equals(valorReal));

	}

	@Test
	public void testAgregarMetodoEscenario1()   {
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(new Parametro("int"));
		parametros.add(new Parametro("int"));
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addMetodo(new Metodo("leer", "private", false, "void",parametros));
		} catch (Exception e) {
			veredicto = false;

		}

		if(veredicto)
			valorReal = "Método añadido con exito";

		assertTrue("Método añadido con exito".equals(valorReal));

	}

	@Test
	public void testAgregarMetodoEscenario2()   {
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(new Parametro("int"));
		parametros.add(new Parametro("int"));
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addMetodo(new Metodo(null, null, false, "void",parametros));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Datos faltantes";
		}

		if(veredicto)
			valorReal = "Método añadido con exito";

		assertTrue("Datos faltantes".equals(valorReal));

	}

	@Test
	public void testAgregarMetodoEscenario3() throws Exception   {
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add(new Parametro("float"));
		this.concreta.addMetodo(new Metodo("calcularAltura", "float", false, "void",parametros));
		boolean veredicto = true;
		String valorReal = null;

		try {
			this.concreta.addMetodo(new Metodo("calcularAltura", "float", false, "void",parametros));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Existe un método con mismo nombre y paramámetros";
		}

		if(veredicto)
			valorReal = "Método añadido con exito";

		assertTrue("Existe un método con mismo nombre y paramámetros".equals(valorReal));

	}

	@Test
	public void testEliminarAtributoEscenario1() throws Exception  {
		this.concreta.addAtributo(new Atributo("tamaño", "int", "public"));

		this.concreta.eliminarAtributo("tamaño");


		assertTrue(true);

	}

	@Test
	public void testEliminarMetodoEscenario1() throws Exception  {
		ArrayList<Parametro> parametros = new ArrayList<Parametro>();
		ArrayList<String> parametrosString = new ArrayList<String>() ;
		parametrosString.add("float");
		parametros.add(new Parametro("float"));
		this.concreta.addMetodo(new Metodo("calcularAltura", "float", false, "void",parametros));

		this.concreta.elminarMetodo("calcularAltura", parametrosString);


		assertTrue(true);

	}

	@Test
	public void testModificarAtributoEscenario1() throws Exception   {
		boolean veredicto = true;
		String valorReal = null;
		this.concreta.addAtributo(new Atributo("peso", "float", "private"));
		try {
			this.concreta.modificarAtributo("peso", new Atributo("altura", "float", "private"));
		} catch (Exception e) {
			veredicto = false;


		}

		if(veredicto)
			valorReal = "Se ha modificada exitosamente el atributo";
		assertTrue("Se ha modificada exitosamente el atributo".equals(valorReal));	
	}

	@Test
	public void testModificarAtributoEscenario2() throws Exception   {
		boolean veredicto = true;
		String valorReal = null;
		this.concreta.addAtributo(new Atributo("peso", "float", "private"));
		this.concreta.addAtributo(new Atributo("altura", "float", "private"));
		try {
			this.concreta.modificarAtributo("peso", new Atributo("altura", "float", "private"));
		} catch (Exception e) {
			veredicto = false;
			valorReal = "Existe un atributo con el mismo nombre";

		}

		if(veredicto)
			valorReal = "Se ha modificada exitosamente el atributo";
		assertTrue("Existe un atributo con el mismo nombre".equals(valorReal));	
	}

}
