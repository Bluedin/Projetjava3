package model;

public class Gold extends Element implements IDisappear {

	private int valeur;

	public Gold(int X, int Y) {
		super(X, Y, "/sprite/purse.png");
		valeur = 100;
		// TODO Auto-generated constructor stub
	}

	public void disappear() {
		// TODO Auto-generated method stub

	}

	public void disappear(Hero hero) {
		// TODO Auto-generated method stub
		this.X = -5;
		this.Y = -5;
		hero.gainScore(this.valeur);
	}

	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub

	}

}
