package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Allfigure.AfficheFig;
import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;

/**
 * Les commandes Specific
 * @author root
 *
 */
public class Specific {

	/**
	 * creer une instance de figure 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getFig(List<String> arg) {
		ContAllFig.add(arg.get(0), FigFactory.getFigure(arg));
	}

	/**
	 * Deplace une figure ou un groupe de figure
	 * @param arg
	 */
	public void move(List<String> arg) {

		allfigure fig = ContAllFig.get(arg.get(1));
		if(fig != null)
			fig.move(Double.parseDouble(arg.get(2)), Double.parseDouble(arg.get(3)));
		else
			System.out.println("Exception a gerrer");
	}
	
	/**
	 * Afiche la description d'une figure ou en groupe de figure
	 * @param fig
	 */
	public void affiche(String fig) {
		
		allfigure allfig = ContAllFig.get(fig);
		if(allfig != null) 
			AfficheFig.affich(allfig);
		else {
			System.out.println("Exeception a gerer figure non exixtant");
		}
	}
	
	/**
	 * creer un instance de group
	 * @param arg
	 */
	public void getgroup(List<String> arg) {
		ContAllFig.add(arg.get(0), FigFactory.getFigure(arg));
	}

}
