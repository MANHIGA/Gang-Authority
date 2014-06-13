package test;

import static org.junit.Assert.*;

import java.util.List;

import model.TypeBatiment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeBatimentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIdTypeBatiment() {
		fail("Not mplemented yet");
	}

	@Test
	public void testGetLibelleTypeBatiment() {
		TypeBatiment tb = new TypeBatiment("Casino", 123);
		assertEquals(tb.getLibelleTypeBatiment(), "Casino");
	}

	@Test
	public void testGetTempsCreationBatiment() {
		TypeBatiment tb = new TypeBatiment("Casino", 123);
		assertEquals(tb.getTempsCreationBatiment(), new Integer(123));
	}

	@Test
	public void testGetTypeSbire() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testGetTypesBatiments(){
		
		List <TypeBatiment> mesTypesBatiments = TypeBatiment.getTypesBatiments();
		assertEquals(mesTypesBatiments.size(),3);
	}
	
}
