package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class figureTest {
	
	Cercle2D c1;
	Point2D centre;

	@Before
	public void setUp() throws Exception {
		centre = new Point2D(0, 5);
		c1 = new Cercle2D(centre, 5);
	}

	@Test
	public void test() {
		System.out.println(c1.toString());
		System.out.println(centre.toString());
	}

}
