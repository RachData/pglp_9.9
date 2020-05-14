package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;

public class InstanceFig {
	
	public void getCercle(List<String> arg) {
		ContAllFig.add(arg.get(0), FigFactory.getCercle(arg));
	}

}
