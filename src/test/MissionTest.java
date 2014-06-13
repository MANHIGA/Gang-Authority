package test;

import static org.junit.Assert.*;

import java.util.List;

import model.Mission;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MissionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMission() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testMissionIntegerIntegerStringIntegerIntegerInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIdMission() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetIdMission() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDureeMission() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDureeMission() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecompenseArgent() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRecompenseArgent() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDifficulte() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDifficulte() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecompensePointsAutorites() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRecompensePointsAutorites() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTempsApparitionBase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetTempsApparitionBase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetNbMiniSbiresRequis() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetNbMiniSbiresRequis() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testGetMissions(){
		List<Mission> m = Mission.getMissions();
		assertEquals(m.size(), 5);
		assertEquals(m.get(0).getDifficulte(), "Facile");
	}

}
