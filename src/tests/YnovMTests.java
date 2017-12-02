package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ynovm.modele.technique.ConnexionException;
import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.TypeStation;
import ynovm.vue.YnovM;

class YnovMTests {
	private YnovM y;

	@BeforeEach
	void setUp() throws Exception {
		y = new YnovM();
	}

	@Test
	void testRedemarrer() throws ProfileException {
		try {
			y.redemarrer(1);
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.redemarrer(100);
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testSupprimer() throws ProfileException {
		try {
			y.redemarrer(1);
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.redemarrer(100);
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testRechercherParID() throws ProfileException {
		try {
			y.rechercherParID(1);
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.rechercherParID(100);
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testRechercherParNom() throws ProfileException {
		try {
			y.rechercherParNom("Paris");
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.rechercherParNom("");
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testRechercherParLoc() throws ProfileException {
		try {
			y.rechercherParLoc("Paris");
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.rechercherParLoc("");
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testRechercherParEtat() throws ProfileException {
		try {
			y.rechercherParEtat(EtatStation.values()[1]);
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.rechercherParEtat(EtatStation.values()[100]);
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testRechercherParType() throws ProfileException {
		try {
			y.rechercherParType(TypeStation.values()[1]);
			assertTrue(true);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.rechercherParType(TypeStation.values()[100]);
			fail("Aurait dû lever une StationException");
		} catch (StationException e) {
			assertEquals("Aucune station disponible", e.getMessage());
		}
	}

	@Test
	void testConnect() {
		try {
			y.connect("admin", "admin");
			assertTrue(true);
		} catch (ConnexionException e) {
			fail("N'aurait pas dû lever une exception");
		}
		try {
			y.connect("", "");
			fail("Aurait dû lever une StationException");
		} catch (ConnexionException e) {
			assertEquals("Echec de connexion", e.getMessage());
		}
    }

}
