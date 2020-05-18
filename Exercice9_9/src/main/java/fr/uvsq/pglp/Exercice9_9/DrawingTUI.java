package fr.uvsq.pglp.Exercice9_9;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Allfigure.AfficheFig;
import fr.uvsq.pglp.Exercice9_9.Command.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.ContFig;

/**
 * l'interaction avec l’utilisateur
 * 
 * @author root
 *
 */
public class DrawingTUI {

	private List<String> args;
	private Interpreteur interprete = Initcommande.init();

	/**
	 * Analyse le texte saisi par l’utilisateur et donne la main a l'interpreteur si
	 * la syntaxe est bonne
	 * 
	 * @param text la saisie de l'utilisateur
	 */
	public Commands nextCommand(String text) {

		String Commandename = "";
		if (Dico.isMatching(text)) {
			this.args = Dico.stringsplit(text);
			Commandename = this.args.get(Dico.gettypeString());
			return interprete.execute(Commandename.toLowerCase());

		} else {
			System.out.println("Exceptions a gerer erreur de syntaxe");
		}
		return null;
	}

	/**
	 * afficher un dessin.
	 */
	public void affich() {
		if (args.get(0).toLowerCase().contentEquals("affiche") == false
				&& args.get(0).toLowerCase().contentEquals("quit") == false) {
			this.args = this.args.subList(0, 1);
			this.args.add(this.args.get(0));
			AfficheFig.affich(ContFig.get());
		}
	}

}
