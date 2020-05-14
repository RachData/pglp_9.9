package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle;
import fr.uvsq.pglp.Exercice9_9.Command.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.ContAllFig;

public class CommandsTest {
	Generic genericProg;
	GenericCommands quitprog;
	
	SpecificCommands createCercle;
	InstanceFig instfig;
	
	Interpreteur interprete;
	List<String> arg;
	
	@Before
	public void setUp() throws Exception {
		arg = new ArrayList<String>();
		interprete = new Interpreteur();
		genericProg=new Generic();
		quitprog = new Quit(genericProg);
		instfig = new InstanceFig();
		createCercle = new CreateCercle(instfig);
		interprete.register("quit", quitprog);
		interprete.register("cercle", createCercle);
	}
	/*
	@Test
	public void quitTest() {
		arg.add("quit");
		interprete.execute("quit",arg);
		
	}*/
	
	@Test
	public void createCercleTest() {
		arg.add("C1");
		arg.add("cercle");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");
		interprete.execute(arg.get(1),arg);
		assertTrue(ContAllFig.get("C1") instanceof Cercle);
		
	}

}
