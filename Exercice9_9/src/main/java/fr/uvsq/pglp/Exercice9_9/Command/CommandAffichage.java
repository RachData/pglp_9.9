package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * Commande concrete pour l'affichage des figure ou des groupe de figure
 * @author root
 *
 */
public class CommandAffichage implements SpecificCommands {

	private final Specific fig; 
	/**
	 * initialise le receiver pour la commande d'affiche
	 * @param quit
	 */
	public CommandAffichage(Specific fig) {
		this.fig=fig;

	}

	/**
	 * excecution de la commande Affiche
	 */
	@Override
	public void apply(List<String> arg){

		try {
			fig.affiche(arg.get(1));
		} catch (Exception e) {
			System.out.println("exception dans commande affiche a gerer");
		}
	}

}
