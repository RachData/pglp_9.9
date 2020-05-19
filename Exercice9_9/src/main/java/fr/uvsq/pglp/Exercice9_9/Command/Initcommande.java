package fr.uvsq.pglp.Exercice9_9.Command;
import fr.uvsq.pglp.Exercice9_9.Command.*;

public class Initcommande {


	private static Generic genericProg;
	private static GenericCommands quitprog;

	private static CommandeCercle createCercle;
	private static CommandRectangle createRectangle;
	private static CommandTriangle createTriangle;
	private static CommandGroupe createGroupe;	
	private static CommandCarre createCarrer;
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

		createCercle = new CommandeCercle(receiver);

		createRectangle = new CommandRectangle(receiver);

		createTriangle = new CommandTriangle(receiver);
		
		createGroupe = new CommandGroupe(receiver);
		
		createCarrer = new CommandCarre(receiver);

		move = new CommandMove(receiver);

		affich = new CommandAffichage(receiver);

		inter.register("quit", quitprog);
		inter.register("cercle", createCercle);
		inter.register("rectangle", createRectangle);
		inter.register("carre", createCarrer);
		inter.register("triangle", createTriangle);
		inter.register("groupe", createGroupe);
		inter.register("move", move);
		inter.register("affiche", affich);

		return inter;
	}

}
