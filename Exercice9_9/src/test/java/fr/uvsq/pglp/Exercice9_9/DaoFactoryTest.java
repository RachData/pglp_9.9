package fr.uvsq.pglp.Exercice9_9;
import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.DaoFig.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DaoFactoryTest {

	Point2D centre;
	Cercle c1;
	Cercle c2;
	CerlcleDAO cdao;

	@Before
	public void setUp() throws Exception {
		centre = new Point2D(1, 5);
		c1 = new Cercle("C2",centre, 8);
	}


	@Test
	public void Createtest() {
		cdao = DaoFactory.getCerlcleDAO();
		cdao.create(new Cercle("C1", centre, 8));
		assertTrue(cdao.create(c1));
	}

	@Test
	public void Readtest() {
		cdao = DaoFactory.getCerlcleDAO();
		c2 = cdao.read("C1");
		System.out.println(c2.toString());
	}

	@Test
	public void Updatetest() {
		cdao = DaoFactory.getCerlcleDAO();
		c2 = new Cercle("C2",new Point2D(1, 0), 8);
		assertTrue(cdao.update(c2));
	}

	@Test
	public void Deletetest() {
		cdao = DaoFactory.getCerlcleDAO();
		assertTrue(cdao.delete(c1));
	}

}
