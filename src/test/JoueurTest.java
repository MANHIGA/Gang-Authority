package test;

import static org.junit.Assert.*;
import model.Joueur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getJoueurByPseudoMdp() {
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		assertEquals(j.getPseudo(), "Shioon");
		assertEquals(j.getMdp(), "gaju");
	}
	
	@Test
	public void test

	@Test
	public void testCreerBatiment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAmeliorerBatiment() {
		fail("Not yet implemented"); // TODO
	}

}
