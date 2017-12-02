package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ynovm.service.StationPOJO;
import ynovm.stockage.DaoJPA;

class DaoJPATests {
	private DaoJPA jpa;

	public DaoJPATests() {
		jpa = new DaoJPA();
	}

	@Test
	void testLireTous() {
		assertEquals(3, jpa.lireTous().size());
		assertEquals("Paris", jpa.lireTous().get(0).getNom());
	}

	@Test
	void testLire() {
		assertTrue(true);
	}

	@Test
	void testInsererUpdateEffacer() {
		int cleInseree;
		List<StationPOJO> res = null;
		res = jpa.lireTous();
		assertEquals(3, res.size());
		
		// INSERER
		StationPOJO tmp = new StationPOJO();
		tmp.setX(123);
		tmp.setY(321);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(4, res.size());
		assertEquals(123, res.get(3).getX());
		assertEquals(321, res.get(3).getY());
		
		// UPDATE
		cleInseree = res.get(3).getId();
		tmp = jpa.lire(cleInseree);
		tmp.setX(999);
		jpa.update(cleInseree, tmp);
		res = jpa.lireTous();
		assertEquals(4, res.size());
		assertEquals(999, res.get(3).getX());
		assertEquals(321, res.get(3).getY());
		
		// EFFACER
		jpa.effacer(cleInseree);
		res = jpa.lireTous();
		assertEquals(3, res.size());
	}

}
