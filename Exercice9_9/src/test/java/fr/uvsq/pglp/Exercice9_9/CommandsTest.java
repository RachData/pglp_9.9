package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Allfigure;
import fr.uvsq.pglp.Exercice9_9.Command.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.ContFig;

public class CommandsTest {

	Interpreteur interprete;
	Commands command;
	List<String> arg;

	Allfigure fig;

	@Before
	public void setUp() throws Exception {
		arg = new ArrayList<String>();
		interprete = Initcommande.init();
	}
	
	@Test
	public void quitTest() {
		arg.add("quit");
		interprete.execute("quit");

	}
	
	@Test
	public void createCercleTest() {
		arg.add("Ctest");
		arg.add("cercle");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");
		interprete.execute(arg.get(1));
		assertTrue(ContFig.get() instanceof Triangle);

	}
	 
	@Test
	public void moveFigAndGroupTest() {
		arg.removeAll(arg);
		arg.add("move");
		arg.add("C2");
		arg.add("5");
		arg.add("5");
		interprete.execute(arg.get(0));
		fig = ContFig.get();
		System.out.println(fig);

	}

	@Test
	public void AfficheFigureTest() {

		arg.removeAll(arg);
		arg.add("affiche");
		arg.add("C1");
		interprete.execute(arg.get(0));
		System.out.println("fin affiche");

	}

}
