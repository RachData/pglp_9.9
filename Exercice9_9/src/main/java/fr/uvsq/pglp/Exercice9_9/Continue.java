package fr.uvsq.pglp.Exercice9_9;

/**
 * Demarre l'application
 * @author root
 *
 */
public class Continue {
	
	private static boolean switchOn = true;

	/**
	 * retourn
	 * @return
	 */
	public static boolean isOn() {
		return switchOn;
	}
	
	public static void turnOff() {
		switchOn = false;
	}	

}
