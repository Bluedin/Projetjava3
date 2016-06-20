package model;

public class Gold extends Element implements IDisappear, IPermeable {

	private int valeur;
	private Permeability permeability = Permeability.PENETRABLE;

	public Gold(int X, int Y) {
		super(X, Y, "sprite/purse.png");
		valeur = 100;
	}

	public void disappear() {

	}

	public void disappear(Hero hero) {
		this.X = -5;
		this.Y = -5;
		hero.gainScore(this.valeur);
	}

	public void disappear(ExitDoor exitDoor) {

	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}

}
