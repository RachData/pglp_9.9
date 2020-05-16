package fr.uvsq.pglp.Exercice9_9;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Command.*;

/**
 * l'interaction avec l’utilisateur
 * @author root
 *
 */
public class DrawingTUI {

	private List<String> args;

	private Generic genericProg;
	private GenericCommands quitprog;

	private SpecificCommands createCercle;
	private Specific receiver;
	private CommandMove move;
	private CommandAffichage affich;

	private Interpreteur interprete = this.init();

	/**
	 * Initialise les commandes
	 */
	private Interpreteur init() {
		Interpreteur inter = new Interpreteur();

		genericProg=new Generic();
		quitprog = new CommandQuit(genericProg);

		receiver = new Specific();

		createCercle = new CommandeCreateFig(receiver);

		move = new CommandMove(receiver);

		affich = new CommandAffichage(receiver);

		inter.register("quit", quitprog);
		inter.register("cercle", createCercle);
		inter.register("move", move);
		inter.register("affiche", affich);

		return inter;
	}


	/**
	 * Analyse le texte saisi par l’utilisateur
	 * @param text la saisie de l'utilisateur
	 */
	public void nextCommand(String text) {
		String Commandename = new String();
		if(Dico.isMatching(text)) {
			this.args = Dico.stringsplit(text);
			Commandename= this.args.get(Dico.gettypeString());
			interprete.execute(Commandename,this.args);

		}else {
			System.out.println("Exceptions a gerer");
		}

	}

	/**
	 * afficher un dessin.
	 */
	public void affich() {

	}

	public void execute() {

	}

}
