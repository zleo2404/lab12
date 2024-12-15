package it.unibo.es3;

import java.util.Set;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	void hit();
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();

	Set<Pair<Integer,Integer>> positions();

}
