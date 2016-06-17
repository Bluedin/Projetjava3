package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	Object getWorld();

	/**
	 * Load the message.
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

	int positionSpellX();

	int positionSpellY();
	
	void shoot();
	
	void move_global(ControllerOrder direction);
	
}
