package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;
import fr.uvsq.pglp.Exercice9_9.Command.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.ContFig;

public class CommandsTest {
	Generic genericProg;
	GenericCommands quitprog;

	SpecificCommands createCercle;
	Specific receiver;
	CommandMove move;
	CommandAffichage affich;

	Interpreteur interprete;
	List<String> arg;

	allfigure fig;

	@Before
	public void setUp() throws Exception {
		arg = new ArrayList<String>();
		interprete = Initcommande.init();

		genericProg=new Generic();
		quitprog = new CommandQuit(genericProg);

		receiver = new Specific();

		createCercle = new CommandeCercle(receiver);

		move = new CommandMove(receiver);

		affich = new CommandAffichage(receiver);
		/*
		interprete.register("quit", quitprog);
		interprete.register("cercle", createCercle);
		interprete.register("move", move);
		interprete.register("affiche", affich)*/;
	}
	/*
	@Test
	public void quitTest() {
		arg.add("quit");
		interprete.execute("quit",arg);

	}*/
	/*
	@Test
	public void createCercleTest() {
		arg.add("tri");
		arg.add("triangle");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");
		interprete.execute(arg.get(1),arg);
		System.out.println(ContAllFig.get("tri"));
		assertTrue(ContAllFig.get("tri") instanceof Triangle);

	}
	 */
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
