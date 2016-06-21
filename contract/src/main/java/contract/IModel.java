package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 */
public interface IModel {

	/**
	 * Gets the world.
	 *
	 * @return the world as a tab of string
	 */
	String[][] getWorld();

	/**
	 * Load the world
	 *
	 * @param key
	 *            the key
	 */
	void loadWorld(int key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	int positionHeroX();

	int positionHeroY();

	boolean isPenetrable(int X, int Y);

	boolean spellOrNot();
	
	void shoot();
	
	boolean move_global(ControllerOrder direction);

	void animate();
	
	boolean heroIsAlive();

	
}
