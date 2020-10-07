package Test;

import org.junit.Test;

import junit.framework.TestCase;
import Puissance4_avec_IA.Pion;

public class PionTest extends TestCase {
	
	private Pion p1;
	private Pion p2;

	public PionTest(String testMethodName) {
		super(testMethodName);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		this.p1 = new Pion(0);
		this.p2 = new Pion(1);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		this.p1 = null;
		this.p2 = null;
	}
	
	@Test
	public void testPion() {
		assertNotNull("L'instance n'a pas été créée", this.p1);
		assertNotNull("L'instance n'a pas été créée", this.p2);		
	}
	
	@Test
	public void testGetCouleur() {
		assertEquals("La couleur du pion p1 n'est pas bonne", 0, this.p1.getCouleur());
		assertEquals("La couleur du pion p1 n'est pas bonne", 1, this.p2.getCouleur());
	}
	
	@Test
	public void testToString() {
		assertEquals("La représentation textuelle du pion p1 n'est pas correcte", "o ", this.p1.toString());
		assertEquals("La représentation textuelle du pion p2 n'est pas correcte", "x ", this.p2.toString());
	}
}
