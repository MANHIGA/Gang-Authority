package test;

import static org.junit.Assert.*;

import java.util.List;

import model.AppFactory;
import model.Joueur;
import model.TypeBatiment;

import org.hibernate.Session;
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
	public void testGetJoueurByPseudoMdp() {
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		assertEquals(j.getPseudo(), "Shioon");
		assertEquals(j.getMdp(), "gaju");
	}
	
	@Test
	public void testCreerBatiment() {	
		List <TypeBatiment> mesTypesBatiments = TypeBatiment.getTypesBatiments();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int nbBatiments = j.getMesBatiments().size() + 1;
		
		j.creerBatiment(mesTypesBatiments.get(0));
		assertEquals(j.getMesBatiments().size(),nbBatiments);		
	}

	@Test
	public void testAmeliorerBatiment() {
		fail("Not yet implemented"); // TODO
	}
}
