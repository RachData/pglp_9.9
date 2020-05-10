package fr.uvsq.pglp.Exercice9_9;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Verifie si la syntaxe saisie par l'utilisateur respect la norme
 * Nom_figure = figure ( centre
 * @author root
 *
 */
public class Dico {
	private static final String regex = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\d*.?\\d+?\\s*\\)";
	private static final Pattern pattern = Pattern.compile(regex);
	
	public static boolean isMatching(String text)  {
	    Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
	
	
	/**
	 * Recupere le nom et la commande et les arguments de la commande
	 * ecrite par l'utilisateur dans Str
	 * @param Str
	 */
	public static void Stringsplit(String Str) {
		List<String> lst = new ArrayList<String>(5);
		Str = Str.replaceAll("\\s","");
		Str = Str.replaceAll("=","#");
		Str = Str.replaceAll("\\(","#");
		Str = Str.replaceAll("\\)","#");
		Str = Str.replaceAll(",","#");
        for (String val: Str.split("#"))
            	if(!val.equals("")) {
            		System.out.println(val);
            		lst.add(val);
            	}
	}

}
