package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import model.TypeSbire;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeSbireTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTypeSbire() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testTypeSbireStringIntegerIntegerTypeBatiment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIdTypeSbire() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetIdTypeSbire() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLibelleTypeSbire() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetLibelleTypeSbire() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCout() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetCout() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTempsApparition() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTempsApparition() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTypeBatiment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTypeBatiment() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testGetTypesSbires(){
		List<TypeSbire> ts = TypeSbire.getTypesSbires();
		assertEquals(ts.size(), 2);
		assertEquals(ts.get(0).getLibelleTypeSbire(), "Trafiquant");
		assertEquals(ts.get(1).getLibelleTypeSbire(), "Homme de main");
	}

}
