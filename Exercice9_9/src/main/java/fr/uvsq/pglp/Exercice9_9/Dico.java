package fr.uvsq.pglp.Exercice9_9;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Verifie le format de syntaxe ecris par l'user
 * et effectue au le split des formats valide
 * @author root
 *
 */
public class Dico {
	
	private static int TYPE;
	
	/**
	 * format generale pour la creation de figure nom = commande
	 */
	private static final String regex = ".+=.+";
	private static final Pattern pattern = Pattern.compile(regex);

	/**
	 * format generale cercle nom = commande((nombre,nombre),nombre)
	 */
	private static final String regexcercle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
			+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern patterncercle = Pattern.compile(regexcercle);

	/**
	 * format generale rectangle et carre nom = commande((nombre,nombre),(nombre,nombre))
	 */
	private static final String regexrectcarre = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*"
			+ ",\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\."
			+ "?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternrectcarre = Pattern.compile(regexrectcarre);

	/**
	 * format generale triangle nom = commande((nombre,nombre),(nombre,nombre),(nombre,nombre))
	 */
	private static final String regextriangle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patterntriangle = Pattern.compile(regextriangle);

	private static final String regexmove = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]+)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*,"
			+ "\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternmove = Pattern.compile(regexmove);
	
	private static final String regexaffiche = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-])+\\s*\\)";
	private static final Pattern patternaffiche = Pattern.compile(regexaffiche);

	/**
	 * Verifie le format du text entrer par l'user
	 * @param text format enter par l'user
	 * @return true or false
	 */
	public static boolean isMatching(String text)  {
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches()) {//verifie si cest une creation
			TYPE = 1;
			matcher = patterncercle.matcher(text);
			if(matcher.matches())
				return true;
			else {
				matcher = patternrectcarre.matcher(text);
				if(matcher.matches())
					return true;
				else {
					matcher = patterntriangle.matcher(text);
					if(matcher.matches())
						return true;
				}
			}

		}else {
			matcher = patternmove.matcher(text);
			if(matcher.matches()){
				TYPE = 0;
				return true;
			}else {
				TYPE = 0;
				matcher = patternaffiche.matcher(text);
				if(matcher.matches())
					return true;
			}
		}
		return false;
	}


	/**
	 * Recupere le nom et la commande et les arguments de la commande
	 * ecrite par l'utilisateur dans Str
	 * @param Str
	 */
	public static List<String> stringsplit(String Str) {
		List<String> lst = new ArrayList<String>();
		Str = Str.replaceAll("\\s","");
		Str = Str.replaceAll("=","#");
		Str = Str.replaceAll("\\(","#");
		Str = Str.replaceAll("\\)","#");
		Str = Str.replaceAll(",","#");


		for (String val: Str.split("#"))
			if(!val.equals("")) {
				lst.add(val);
			}
		return lst;
	}
	
	/**
	 * retourne le type de la commande saisie par l'utilisateur
	 * @return TYPE
	 */
	public static int gettypeString() {
		return TYPE;
	}

}
