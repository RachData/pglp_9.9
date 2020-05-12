package fr.uvsq.pglp.Exercice9_9.Allfigure;

import java.util.ArrayList;
import java.util.List;

/**
 * creer une instance de l'itterator
 * @author root
 *
 */
public class ItteratorFigure {
	
	private ArrayList<allfigure> grpfig=new ArrayList<allfigure>();
	
	/**
	 * initialise ItteratorFigure
	 * @param root
	 */
	public ItteratorFigure (allfigure root) {
		this.grpfig.add(root);
	}
	
	/**
	 * creer la liste d'un groupe
	 * @author root
	 *
	 */
	private class groupIterator implements Iterator{
		int index=0;
		
		/**
		 * initialise la liste
		 */
		public groupIterator() {
			int verifier=0;
			while(verifier<grpfig.size()) {
				if(grpfig.get(verifier) instanceof GroupFig) {
					GroupFig test=(GroupFig)grpfig.get(verifier);
					int i=0;
					List<allfigure> arrlist = test.gettab(); 
					while(i<arrlist.size()) {
						grpfig.add(arrlist.get(i));
						i++;
					}
					
				
				}
				verifier++;
			}
		}
		
		/**
		 * verifirie s'il y'a des elements dans la liste
		 */
		@Override
		public boolean HasNext() {
			if(index<grpfig.size())
				return true;
			// TODO Auto-generated method stub
			return false;
		}
		
		/**
		 * retourne la figure dans la liste
		 */
		@Override
		public allfigure Next() {
			if(this.HasNext()) {
				index++;
				return grpfig.get(index-1);
			}
				
			return null;
		}
		
	}
	
	/**
	 * retourne l'instance de l'itteration
	 * @return
	 */
	public Iterator getIterator() {
		return new groupIterator();
		
	}

}
