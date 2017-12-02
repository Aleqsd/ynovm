package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ynovm.modele.metier.Station;
import ynovm.modele.technique.StationException;
import ynovm.utilitaire.EtatStation;

class StationTests {
	private Station s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Station();
	}

	@Test
	void testRedemarrer() {
		s.setEtat(EtatStation.EN_PANNE);
		try {
			s.redemarrer();
		} catch (StationException e) {
			assertEquals("Impossible de redémarrer : la station est en panne", e.getMessage());
		}		
		
		s.setEtat(EtatStation.EN_MARCHE);
		try {
			s.redemarrer();
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		assertEquals(EtatStation.REDEMARRAGE, s.getEtat());
	}

}
