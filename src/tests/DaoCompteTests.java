package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ynovm.service.Compte;
import ynovm.stockage.DaoCompte;
import ynovm.utilitaire.Profile;

class DaoCompteTests {
	private DaoCompte jpa;

	public DaoCompteTests() {
		jpa = new DaoCompte();
	}

	@Test
	void testLireTous() {
		assertEquals(3, jpa.lireTous().size());
		assertEquals("admin", jpa.lireTous().get(0).getlogin());
	}

	@Test
	void testLire() {
		assertTrue(true);
	}

	@Test
	void testInsererUpdateEffacer() {
		int cleInseree;
		List<Compte> res = null;
		res = jpa.lireTous();
		assertEquals(3, res.size());
		
		// INSERER
		Compte tmp = new Compte();
		tmp.setlogin("test");
		tmp.setmdp("test");
		tmp.setProfile(Profile.ADMINISTRATEUR);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(4, res.size());
		assertEquals("test", res.get(3).getlogin());
		assertEquals("test", res.get(3).getmdp());
		
		// UPDATE
		cleInseree = res.get(3).getId();
		tmp = jpa.lire(cleInseree);
		tmp.setmdp("test1");
		jpa.update(cleInseree, tmp);
		res = jpa.lireTous();
		assertEquals(4, res.size());
		assertEquals("test", res.get(3).getlogin());
		assertEquals("test1", res.get(3).getmdp());
		
		// EFFACER
		jpa.effacer(cleInseree);
		res = jpa.lireTous();
		assertEquals(3, res.size());
	}

}
