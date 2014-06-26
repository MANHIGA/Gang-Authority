<<<<<<< HEAD
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import javax.persistence.Query;

import model.AppFactory;
import model.Construire;
import model.Entrainer;
import model.Joueur;
import model.Mission;
import model.TypeBatiment;
import model.TypeSbire;

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
		
		List<Construire> mb = j.getMesBatiments();
		int nbBatiments;
		
		if(mb == null){
			nbBatiments = 0;
		}else{
			nbBatiments = mb.size();
		}
		
		j.creerBatiment(mesTypesBatiments.get(0));
		assertEquals(j.getMesBatiments().size(), nbBatiments + 1);		
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
		assertEquals(j.getTypeSbireEntrainer(mesTypesSbires.get(0)).getNbSbire(), new Integer (nbSbires + 1));
	}
	
	@Test
	public void testAmeliorerTypeSbire(){
		
		List <TypeSbire> mesTypesSbires = TypeSbire.getTypesSbires();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int pointAttaque;
		int pointDefense;
		
		j.recruterTypeSbire(mesTypesSbires.get(0));
		Entrainer s = j.getTypeSbireEntrainer(mesTypesSbires.get(0));
		
		pointAttaque = s.getPointAttaque();
		pointDefense = s.getPointDefense();
		j.ameliorerTypeSbire(s);
		
		assertNotSame(s.getPointAttaque(),pointAttaque);
		assertNotSame(s.getPointDefense(),pointDefense);
	}
	
	@Test
	public void testRecompenserJoueur(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int argent = j.getArgent();
		int pa = j.getPointAutorite();
		
		j.recompenserJoueur(100, 4500);
		
		assertNotSame(j.getArgent(),argent);
		assertNotSame(j.getPointAutorite(),pa);
	}
	
	@Test
	public void testSignalerJoueur(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		String justification = "Test de signalement";
		j.signalerJoueur(j, justification);
		
		Session session = AppFactory.getSessionFactory().openSession();
		org.hibernate.Query q = session.createQuery("from Signalement where Signalement_idCompte = " + j.getIdCompte() + " AND justification = '" + justification + "'");
		
		assertEquals(q.list().isEmpty(),false);
		
		session.close();
	}
	
	@Test
	public void testGetMissionsDisponibles(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		assertNotSame(j.getMissionsDisponibles().size(),0);
	}
	
	@Test
	public void testRealiserMission(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int nbMissionsDisponibles = j.getMissionsDisponibles().size();
		j.realiserMission(j.getMissionsDisponibles().get(1), j.getMissionsDisponibles().get(1).getNbMiniSbiresRequis());
		
		assertNotSame(nbMissionsDisponibles,j.getMissionsDisponibles().size());
	}

}
=======
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import model.AppFactory;
import model.Construire;
import model.Entrainer;
import model.Joueur;
import model.Mission;
import model.TypeBatiment;
import model.TypeSbire;

import org.hibernate.Query;
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
		
		List<Construire> mb = j.getMesBatiments();
		int nbBatiments;
		
		if(mb == null){
			nbBatiments = 0;
		}else{
			nbBatiments = mb.size();
		}
		
		j.creerBatiment(mesTypesBatiments.get(0));
		assertEquals(j.getMesBatiments().size(), nbBatiments + 1);		
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
		assertEquals(j.getTypeSbireEntrainer(mesTypesSbires.get(0)).getNbSbire(), new Integer (nbSbires + 1));
	}
	
	@Test
	public void testAmeliorerTypeSbire(){
		
		List <TypeSbire> mesTypesSbires = TypeSbire.getTypesSbires();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int pointAttaque;
		int pointDefense;
		
		j.recruterTypeSbire(mesTypesSbires.get(0));
		Entrainer s = j.getTypeSbireEntrainer(mesTypesSbires.get(0));
		
		pointAttaque = s.getPointAttaque();
		pointDefense = s.getPointDefense();
		j.ameliorerTypeSbire(s);
		
		assertNotSame(s.getPointAttaque(),pointAttaque);
		assertNotSame(s.getPointDefense(),pointDefense);
	}
	
	@Test
	public void testRecompenserJoueur(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int argent = j.getArgent();
		int pa = j.getPointAutorite();
		
		j.recompenserJoueur(100, 4500);
		
		assertNotSame(j.getArgent(),argent);
		assertNotSame(j.getPointAutorite(),pa);
	}
	
	@Test
	public void testSignalerJoueur(){
		Session session = AppFactory.getSessionFactory().openSession();
		Query query = session.createQuery("select count(*) from Signalement");
		Object nb = query.list().get(0);
		session.close();
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		String justification = "Test de signalement";
		j.signalerJoueur(j, justification);
		
		Session session1 = AppFactory.getSessionFactory().openSession();
		Query query1 = session1.createQuery("select count(*) from Signalement");
		Object nb1 = query1.list().get(0);
		session1.close();
		assertNotSame(nb, nb1);
	}
	
	@Test
	public void testGetMissionsDisponibles(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		assertNotSame(j.getMissionsDisponibles().size(),0);
	}
	
	@Test
	public void testRealiserMission(){
		Joueur j = Joueur.getJoueurByPseudoMdp("Shioon", "gaju");
		
		int nbMissionsDisponibles = j.getMissionsDisponibles().size();
		j.realiserMission(j.getMissionsDisponibles().get(1), j.getMissionsDisponibles().get(1).getNbMiniSbiresRequis());
		
		assertNotSame(nbMissionsDisponibles,j.getMissionsDisponibles().size());
	}

}
>>>>>>> FETCH_HEAD
