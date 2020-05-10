package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class dicoTest {
	
	String Str;
	
	@Before
	public void setUp() throws Exception {
		Str = new String("c1=Cercle((1.1,11.00),5)");
	}

	@Test
	public void test() {
		
		if(Dico.isMatching(Str)) {
			Dico.Stringsplit(Str);
		}
		
	}

}
