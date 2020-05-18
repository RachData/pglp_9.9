package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.DaoFig.GetConnection;

public class GetconnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		GetConnection.dropCreateTables();
		System.out.println("fais");
	}

}
