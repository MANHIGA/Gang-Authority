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
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {
	
	private Joueur j;
	
	@Before
	public void setUp() throws Exception {
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		j = new Joueur("JUnit_JoueurTest", "emailTest", "mdpTest","JUnit_GangTest");
		
		session.save(j);
		tx.commit();
		session.close();
	}

	@After
	public void tearDown() throws Exception {
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(j);
		tx.commit();
		session.close();
	}

	@Test
	public void testGetJoueurByPseudoMdp() {
		Joueur joueur = Joueur.getJoueurByPseudoMdp("JUnit_JoueurTest", "mdpTest");
		assertEquals(joueur.getPseudo(), "JUnit_JoueurTest");
		assertEquals(joueur.getMdp(), "mdpTest");
	}
	
	@Test
	public void testCreerBatiment() {	
		List <TypeBatiment> mesTypesBatiments = TypeBatiment.getTypesBatiments();
		
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
		
		List<Construire>mb = j.getMesBatiments();
		
		j.creerBatiment(mesTypesBatiments.get(0));
		j.ameliorerBatiment(mb.get(mb.size()-1));
		
		assertEquals(mb.get(mb.size()-1).getNiveau(),new Integer(2));
				
	}
	
	@Test
	public void testRecruterTypeSbire(){
		List <TypeSbire> mesTypesSbires = TypeSbire.getTypesSbires();
		
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
		assertEquals(j.getMissionsDisponibles().size(),Mission.getMissions().size());
	}
	
	@Test
	public void testRealiserMission(){
		
		List<Mission> missionsDisponibles = j.getMissionsDisponibles();
		
		int nbMissionsDisponibles = missionsDisponibles.size();
		j.realiserMission(missionsDisponibles.get(0), missionsDisponibles.get(0).getNbMiniSbiresRequis());
		
		assertNotSame(nbMissionsDisponibles,j.getMissionsDisponibles().size());
	}
	
	@Test
	public void testGetJoueursConnectes(){
		
		int nbJoueursConnectes = j.getJoueursConnectes().size();
		
		Joueur adversaire = Joueur.getJoueurByPseudoMdp("Shiwoon", "gaju");
		adversaire.setJoueurConnecte(true);
		
		assertNotSame(nbJoueursConnectes,j.getJoueursConnectes().size());
	}
	
	@Test
	public void testCombattreJoueur(){
		
		Joueur adversaire = Joueur.getJoueurByPseudoMdp("Shiwoon", "gaju");
		j.combattreJoueur(adversaire, 5);
		
		Session session = AppFactory.getSessionFactory().openSession();
		Query query = session.createQuery("From Combattre where Combattre_idCompte_Attaquant = " + j.getIdCompte());
		
		assertEquals(query.list().size(), 1);	
	}
	
	@Test
	public void testGetMesCombats(){
		
		Joueur adversaire = Joueur.getJoueurByPseudoMdp("Shiwoon", "gaju");
		j.combattreJoueur(adversaire, 5);
		
		int nbCombats = j.getMesCombats().size();
		
		assertEquals(1,nbCombats);
		
	}
}
