package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * Affichage
 * @author root
 *
 */
public class AfficheFig {

	/**
	 * Afiche une figure ou un groupe de figure
	 * @param allfig la ou les grouprs a afficher
	 */
	public static void affich (allfigure allfig) {
		ItteratorFigure affich = new ItteratorFigure(allfig);
		Iterator grouptIter = affich.getIterator();
		while (grouptIter.HasNext()) {
			allfigure nextValue=grouptIter.Next();
			//try {
				System.out.println(nextValue.toString());
			//} catch (Exception e) {
				// TODO: handle exception
			//}
			
		}

	}
}
