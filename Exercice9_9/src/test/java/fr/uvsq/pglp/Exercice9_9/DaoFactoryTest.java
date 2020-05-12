package fr.uvsq.pglp.Exercice9_9;
import fr.uvsq.pglp.Exercice9_9.DaoFig.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DaoFactoryTest {
	
	
	CerlcleDAO cdao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		cdao = DaoFactory.getCerlcleDAO();
	}

}
