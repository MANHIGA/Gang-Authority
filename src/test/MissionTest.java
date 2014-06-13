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
	public void testGetMissions(){
		List<Mission> m = Mission.getMissions();
		assertEquals(m.size(), 5);
		assertEquals(m.get(0).getDifficulte(), "Facile");
	}

}
