package fr.uvsq.pglp.Exercice9_9.CreationFigure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;

/**
 * contients toutes les figures creés par l'utilisateurs
 * @author root
 *
 */
public class ContFig {

	private static Allfigure figures;
	private static String name= "";

	/**
	 * Ajoute une figure
	 * @param name le nom de la figure
	 * @param fig la figure
	 */
	public static void add(String namefig, Allfigure fig)
	{	if(fig != null) {
		figures= fig;
		name = namefig;
	}

	}

	/**
	 * retourne un element des figure crées
	 * @param name le nom de la figure
	 * @return la figure
	 */
	public static Allfigure get() {
			return figures;
	}



}
