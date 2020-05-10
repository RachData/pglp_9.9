package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class dicoTest {
	
	String Strcercle;
	String Strrectcarre;
	String Strtriangle;
	
	@Before
	public void setUp() throws Exception {
		Strcercle = new String("c1 = Cercle( (5.5 , 11.00) , 55)");
		Strrectcarre = new String("c1 = Rectangle( (5.5 , 11.00) , (55 , 66))");
		Strtriangle = new String("c1 = Triangle( (5.5  ,11.00), (2 , 3) , (55 , 66))");
	}

	@Test
	public void testcercle() {
		System.out.println("testcercle ...");
		if(Dico.isMatching(Strcercle)) {
			Dico.Stringsplit(Strcercle);
		}else {
			System.out.println("Erreur de syntaxe ....");
		}
	}
	
	@Test
	public void testrectcarre() {
		System.out.println("testrectcarre ...");
		if(Dico.isMatching(Strrectcarre)) {
			Dico.Stringsplit(Strrectcarre);
		}else {
			System.out.println("Erreur de syntaxe ....");
		}
	}
	
	@Test
	public void testtrinagle() {
		System.out.println("testtrinagle ...");
		if(Dico.isMatching(Strtriangle)) {
			Dico.Stringsplit(Strtriangle);
		}else {
			System.out.println("Erreur de syntaxe ....");
		}
	}

}
