package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ynovm.controleur.Manager;
import ynovm.modele.technique.ConnexionException;
import ynovm.modele.technique.ProfileException;
import ynovm.modele.technique.StationException;
import ynovm.stockage.DaoJPA;
import ynovm.utilitaire.EtatStation;
import ynovm.utilitaire.Profile;
import ynovm.utilitaire.TypeStation;

class ManagerTests {

	@Test
	void testGetInstance() {
		Manager m = null;
		m = Manager.getInstance();
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
		assertEquals(m, Manager.getInstance());
	}

	@Test
	void testRedemarrer() {
		Manager m = null;
		m = Manager.getInstance();
		try {
			m.redemarrer(0);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(EtatStation.REDEMARRAGE, m.getPOJOs().get(0).getEtat());
	}

	@Test
	void testAjouter() throws ProfileException {
		DaoJPA jpa = null;
		int nb = 0;
		nb = jpa.lireTous().size();
		Manager m = null;
		m = Manager.getInstance();
		m.ajouter(0, 0, 0, "", "", 0, 0, 0, 0, 0, "", TypeStation.AUTONOME);
		assertEquals(nb + 1, jpa.lireTous().size());		
	}

	@Test
	void testSupprimer(int id) throws ProfileException {
		DaoJPA jpa = null;
		int nb = 0;
		nb = jpa.lireTous().size();
		Manager m = null;
		m = Manager.getInstance();
		try {
			m.supprimer(1);
		} catch (StationException e) {
			fail("N'aurait pas dû lever une exception");
		}
		assertEquals(nb - 1, jpa.lireTous().size());
	}

	@Test
	void testConnexion() {
		Manager m = null;
		m = Manager.getInstance();
		try {
			m.connexion("admin", "admin");
		} catch (ConnexionException e) {
			fail("N'aurait pas dû lever une exception");
		}
		assertEquals("admin", m.getUtilisateur().getlogin());
		assertEquals("admin", m.getUtilisateur().getmdp());
		assertEquals(Profile.ADMINISTRATEUR, m.getUtilisateur().getProfile());
	}

}
