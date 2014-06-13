package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Construire;
import model.Entrainer;
import model.Joueur;
import model.TypeBatiment;
import model.TypeSbire;

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
		
		List<Construire> mb = j.getMesBatiments();
		int nbBatiments;
		
		if(mb == null){
			nbBatiments = 0;
		}else{
			nbBatiments = mb.size();
		}
		
		j.creerBatiment(mesTypesBatiments.get(0));
		assertEquals(j.getMesBatiments().size(),nbBatiments + 1);		
	}

	@Test
	public void testAmeliorerBatiment() {
		List <TypeBatiment> mesTypesBatiments = TypeBatiment.getTypesBatiments();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		List<Construire>mb = j.getMesBatiments();
		
		j.creerBatiment(mesTypesBatiments.get(0));
		j.ameliorerBatiment(mb.get(mb.size()-1));
		
		assertEquals(mb.get(mb.size()-1).getNiveau(),new Integer(2));
				
	}
	
	@Test
	public void testRecruterTypeSbire(){
		List <TypeSbire> mesTypesSbires = TypeSbire.getTypesSbires();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		Entrainer s = j.getTypeSbireEntrainer(mesTypesSbires.get(0));
		int nbSbires;
		
		if(s == null){
			nbSbires = 0;
		}else{
			nbSbires = s.getNbSbire();
		}
		
		j.recruterTypeSbire(mesTypesSbires.get(0));
		assertEquals(j.getTypeSbireEntrainer(mesTypesSbires.get(0)),nbSbires + 1);
	}
}
