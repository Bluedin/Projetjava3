package model;



/**
 * CLasse Background extending Element 
 * and implementing IPerleable
 *
 */
public class Background extends Element implements IPermeable{

	private Permeability permeability = Permeability.PENETRABLE;

	/**
	 * @param X
	 * @param Y
	 * Constructor of Background
	 * Has no sprite
	 */
	public Background(int X, int Y) {
		super(X, Y, null);
	}

	/**
	 * @see model.IPermeable#getPermeability()
	 * return the permeability of Background
	 */
	public Permeability getPermeability() {

		return this.permeability;

	}

}
