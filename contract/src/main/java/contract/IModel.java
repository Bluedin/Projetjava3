package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the world.
	 *
	 * @return the world sous forme de tableau de strng
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
	
	void move_global(ControllerOrder direction);

	void animate();

	
}
