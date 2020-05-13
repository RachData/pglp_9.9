package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Command.*;

public class CommandsTest {
	Generic genericProg;
	GenericCommands quitprog;
	Interpreteur interprete;

	@Before
	public void setUp() throws Exception {
		interprete = new Interpreteur();
		genericProg=new Generic();
		quitprog = new Quit(genericProg);
		interprete.register("quit", quitprog);
	}

	@Test
	public void quitTest() {
		
		interprete.execute("quit");
		
	}

}
