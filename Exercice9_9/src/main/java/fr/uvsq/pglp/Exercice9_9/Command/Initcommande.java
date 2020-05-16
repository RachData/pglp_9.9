package fr.uvsq.pglp.Exercice9_9.Command;

public class Initcommande {
	

	private static Generic genericProg;
	private static GenericCommands quitprog;

	private static SpecificCommands createFig;
	private static Specific receiver;
	private static CommandMove move;
	private static CommandAffichage affich;
	
	/**
	 * Initialise les commandes
	 */
	public static Interpreteur init() {
		Interpreteur inter = new Interpreteur();

		genericProg=new Generic();
		quitprog = new CommandQuit(genericProg);

		receiver = new Specific();

		createFig = new CommandeCreateFig(receiver);

		move = new CommandMove(receiver);

		affich = new CommandAffichage(receiver);

		inter.register("quit", quitprog);
		inter.register("cercle", createFig);
		inter.register("rectangle", createFig);
		inter.register("carre", createFig);
		inter.register("triangle", createFig);
		inter.register("groupe", createFig);
		inter.register("move", move);
		inter.register("affiche", affich);

		return inter;
	}

}
