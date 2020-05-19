package fr.uvsq.pglp.Exercice9_9.Allfigure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Un groupe de figure
 * @author root
 *
 */
public class GroupFig extends Allfigure{

	private List<Allfigure> figures;

	/**
	 * initialise le nom du groupe
	 * @param name
	 */
	public GroupFig(String name) {
		super.name = name;
		figures = new ArrayList<Allfigure>();
	}

	/**
	 * retoure une liste immuable du groupe
	 * @return
	 */
	public List<Allfigure> gettab(){
		return Collections 
				.unmodifiableList(figures);
	}

	/**
	 * retourne le nom du groupe
	 * @return
	 */
	public String getName() {
		return super.name;
	}

	/**
	 * ajoute un element dans le groupe
	 * @param element
	 */
	public void add(Allfigure element) {
		figures.add(element);
	}

	/**
	 * supprime un element du goupe
	 * @param perso
	 */
	public void remove(Allfigure perso) {
		this.figures.remove(perso);
	}

	/**
	 * donne la description du groupe
	 */
	@Override
	public String toString() {
		return "Groupe " +
				"name = " + name;
	}

	/**
	 * Deplace tout les elements du groupe
	 */
	@Override
	public void move(double dx, double dy) {
		for (int i=0 ; i< figures.size();i++) {
			figures.get(i).move(dx, dy);
		}

	}

}
