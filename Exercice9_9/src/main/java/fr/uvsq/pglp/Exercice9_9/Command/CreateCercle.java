package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

public class CreateCercle implements SpecificCommands{
	
	private final InstanceFig inst; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CreateCercle(InstanceFig inst) {
		this.inst=inst;
		
	}
	
	/**
	 * excecution de la commande Quit
	 */
	@Override
	public void apply(List<String> arg) {
		inst.getCercle(arg);
		
	}

}
