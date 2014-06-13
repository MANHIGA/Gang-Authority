package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import model.AppFactory;
import model.Construire;
import model.Joueur;
import model.TypeBatiment;

import org.hibernate.Session;
import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

	@Before
	public void setUp() throws Exception {
		Session s = AppFactory.getSessionFactory().openSession();
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
	public void testGetMesBatiments(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		assertEquals(j.getMesBatiments(), null);
	}
	
	@Test
	public void testCreerBatiment() {
		List <TypeBatiment> mesTypesBatiments = TypeBatiment.getTypesBatiments();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		Set<Construire> mb = j.getMesBatiments();

		int nbBatiments;
		
		if(mb == null){
			nbBatiments = 0;
		}else{
			System.out.println(mb.getClass());
			//nbBatiments = mb.size();
		}
		
		//j.creerBatiment(mesTypesBatiments.get(0));
		//assertEquals(j.getMesBatiments().size(),nbBatiments + 1);		
	}

	@Test
	public void testAmeliorerBatiment() {
		fail("Not yet implemented"); // TODO
	}
}
