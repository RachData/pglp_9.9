package fr.uvsq.pglp.Exercice9_9.CreationFigure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.uvsq.pglp.Exercice9_9.Allfigure.*;

/**
 * contients toutes les figures creés par l'utilisateurs
 * @author root
 *
 */
public class ContAllFig {

	private static final Map<String, allfigure> figures = new HashMap<>();

	/**
	 * Ajoute une figure
	 * @param name le nom de la figure
	 * @param fig la figure
	 */
	public static void add(String name, allfigure fig)
	{	
		figures.put(name, fig);
	}

	/**
	 * retourne un element des figure crées
	 * @param name le nom de la figure
	 * @return la figure
	 */
	public static allfigure get(String name) {
		return figures.get(name);
	}

	/**
	 * retourne une liste de toute les figures crées
	 * @return une liste
	 */
	public static List<allfigure> getAll() {
		List<allfigure> fig =new ArrayList<allfigure>();
		for (String name : figures.keySet())  
			fig.add(figures.get(name));
		return fig;
	}


}
