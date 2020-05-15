package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;
import fr.uvsq.pglp.Exercice9_9.exceptions.RectangleException;

/**
 * Receiver pour la creation des figures
 * @author root
 *
 */
public class Specific {

	/**
	 * creer une instance de figure 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getFig(List<String> arg){
		ContAllFig.add(arg.get(0), FigFactory.getFigure(arg));
	}
	
	/**
	 * Deplace une figure ou un groupe de figure
	 * @param arg
	 */
	public void move(List<String> arg) {
		
		allfigure fig = ContAllFig.get(arg.get(1));
		fig.move(Double.parseDouble(arg.get(2)), Double.parseDouble(arg.get(3)));
	}

}