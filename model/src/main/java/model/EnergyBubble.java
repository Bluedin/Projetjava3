package model;

/**
 * EnergyBubble class
 * extends Element
 * implements IDisappear and IPermeable
 *
 */
public class EnergyBubble extends Element implements IDisappear, IPermeable{
	
	/**
	 *  Permeability of the Element
	 *  Indicate if a mobile object can go through its coordinate
	 */
	private Permeability permeability = Permeability.PENETRABLE;
	
	/**
	 * constructor
	 * @param X
	 * @param Y
	 */
	public EnergyBubble(int X, int Y){
		super(X, Y, "sprite/crystal_ball.png");
	}

	/**
	 * @see model.IPermeable#getPermeability()
	 */
	public Permeability getPermeability(){
		return this.permeability;
	}

	/**
	 * @see model.IDisappear#disappear(model.ExitDoor)
	 */
	public void disappear(ExitDoor exitDoor) {
		this.X = -5;
		this.Y = -5;
		exitDoor.changeState();
	}

	/**
	 * @see model.IDisappear#disappear()
	 */
	public void disappear() {
		
	}

	/**
	 * @see model.IDisappear#disappear(model.Hero)
	 */
	public void disappear(Hero hero) {
		
	}
	
}
