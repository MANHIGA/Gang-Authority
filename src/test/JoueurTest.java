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
	public void testGetIdCompte() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetIdCompte() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetPseudo() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getPseudo(), "Eren");
	}

	@Test
	public void testSetPseudo() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setPseudo("Mikasa");
		assertEquals(j.getPseudo(), "Mikasa");
	}

	@Test
	public void testGetEmail() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getEmail(), "Eren@Kyojin.com");
	}

	@Test
	public void testSetEmail() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setEmail("Reiner@Kyojin.com");
		assertEquals(j.getEmail(), "Reiner@Kyojin.com");
	}

	@Test
	public void testGetMdp() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getMdp(), "titan");
	}

	@Test
	public void testSetMdp() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setMdp("yamete");
		assertEquals(j.getMdp(), "yamete");
	}

	@Test
	public void testGetPointAutorite() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getPointAutorite(), new Integer(1234));
	}

	@Test
	public void testSetPointAutorite() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setPointAutorite(12345);
		assertEquals(j.getPointAutorite(), new Integer(12345));
	}

	@Test
	public void testGetNbMorts() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getNbMorts(), new Integer(0));
	}

	@Test
	public void testSetNbMorts() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setNbMorts(42);
		assertEquals(j.getNbMorts(), new Integer(42));
	}

	@Test
	public void testGetNbTues() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getNbTues(), new Integer(123));
	}

	@Test
	public void testSetNbTues() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setNbTues(3);
		assertEquals(j.getNbTues(), new Integer(3));
	}

	@Test
	public void testGetArgent() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getArgent(), new Integer(12345));
	}

	@Test
	public void testSetArgent() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setArgent(4312);
		assertEquals(j.getArgent(), new Integer(4312));
	}

	@Test
	public void testGetNomGang() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		assertEquals(j.getNomGang(), "Survey Corps");
	}

	@Test
	public void testSetNomGang() {
		Joueur j = new Joueur("Eren", "Eren@Kyojin.com", "titan", 1234, 0, 123, 12345, "Survey Corps");
		j.setNomGang("Konoha");
		assertEquals(j.getNomGang(), "Konoha");
	}

	@Test
	public void testEtreJoueur() {
		assertTrue(Joueur.etreJoueur("Shioon", "gaju"));
	}

	@Test
	public void testCreerBatiment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAmeliorerBatiment() {
		fail("Not yet implemented"); // TODO
	}

}
