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
	 * et donne la main a l'interpreteur si la syntaxe est bonne
	 * @param text la saisie de l'utilisateur
	 */
	public void nextCommand(String text) {

		String Commandename = "";
		if(Dico.isMatching(text)) {
			this.args = Dico.stringsplit(text);
			Commandename= this.args.get(Dico.gettypeString());
			interprete.execute(Commandename.toLowerCase(),this.args);
			if ( Dico.gettypeString() == 1) {
				this.affich("affiche");
			}
			
		}else {
			System.out.println("Exceptions a gerer erreur de syntaxe");
		}

	}

	/**
	 * afficher un dessin.
	 */
	public void affich(String name) {
		args = this.args.subList(0, 1);
		args.add(args.get(0));
		interprete.execute(name,args);
	}

}
