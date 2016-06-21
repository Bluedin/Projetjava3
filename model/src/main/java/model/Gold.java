package model;

public class Gold extends Element implements IDisappear, IPermeable {

	private int valeur;
	private Permeability permeability = Permeability.PENETRABLE;

	/**
	 * @param X
	 * @param Y
	 * this constructor of gold get the sprite of the purse and position of elements
	 */
	public Gold(int X, int Y) {
		super(X, Y, "sprite/purse.png");
		valeur = 100;
	}

	public void disappear() {

	}

	/**
	 * this method is when coordinates of hero and purse are the same the purse disapear and get point
	 */
	public void disappear(Hero hero) {
		this.X = -5;
		this.Y = -5;
		hero.gainScore(this.valeur);
	}

	public void disappear(ExitDoor exitDoor) {

	}
	
	/**
	 * this is the method to get the permeability of this element
	 */
	public Permeability getPermeability(){
		return this.permeability;
	}

}
