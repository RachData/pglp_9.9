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
	private Interpreteur interprete = Initcommande.init();

	/**
	 * Analyse le texte saisi par l’utilisateur
	 * @param text la saisie de l'utilisateur
	 */
	public void nextCommand(String text) {

		String Commandename = new String();
		if(Dico.isMatching(text)) {
			this.args = Dico.stringsplit(text);
			Commandename= this.args.get(Dico.gettypeString());
			if(Commandename != "affiche")
				interprete.execute(Commandename.toLowerCase(),this.args);
			else
				this.affich(Commandename);

		}else {
			System.out.println("Exceptions a gerer erreur de syntaxe");
		}

	}

	/**
	 * afficher un dessin.
	 */
	public void affich(String name) {

		interprete.execute(name,this.args);
	}

	public void execute() {

	}

}
