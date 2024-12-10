package it.unibo.es2;

import java.util.List;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	boolean hit(Pair<Integer,Integer> x);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();

}
