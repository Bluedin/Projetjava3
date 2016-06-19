package model;

import java.util.ArrayList;

import contract.ControllerOrder;

public class World {

	private ArrayList<Element> elementList;
	private int nbrEnnemy = 1;

	public World() {

	}

	public void getWorld() {

	}

	public void animate() {

	}

	public void generateMapString() {

	}

	public void addElement(String key, int X, int Y) {
		switch (key) {
		case "l":
			this.elementList.add(new Hero(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "e":
			this.elementList.add(new Ennemy(X, Y, "" + this.nbrEnnemy));
			this.elementList.add(new Background(X, Y));
			this.nbrEnnemy++;
			break;
		case "g":
			this.elementList.add(new Gold(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "b":
			this.elementList.add(new EnergyBubble(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "x":
			this.elementList.add(new ExitDoor(X, Y));
			break;
		case "h":
			this.elementList.add(new Wall(X, Y, "1"));
			break;
		case "v":
			this.elementList.add(new Wall(X, Y, "2"));
			break;
		case "c":
			this.elementList.add(new Wall(X, Y, "3"));
			break;
		case "f":
			this.elementList.add(new Background(X, Y));
			break;
		}

	}

	public int positionHeroX() {
		int i = 0;
		while (this.elementList.get(i).getClass() != Hero.class) {
			i++;
		}
		return this.elementList.get(i).getX();
	}

	public int positionHeroY() {
		int i = 0;
		while (this.elementList.get(i).getClass() != Hero.class) {
			i++;
		}
		return this.elementList.get(i).getY();
	}

	public boolean isPenetrable(int X, int Y) {
		int i = 0;
		while (this.elementList.get(i).getX() != X && this.elementList.get(i).getY() != Y
				&& this.elementList.get(i).getClass() == Hero.class
				&& this.elementList.get(i).getClass() == Spell.class
				&& this.elementList.get(i).getClass() == Ennemy.class) {
			i++;
		}
		
		
		
		return this.elementList.get(i) != null;
	}

	public boolean spellOrNot() {
		// TODO Auto-generated method stub
		return false;
	}

	public int positionSpellX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int positionSpellY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void shoot() {
		// TODO Auto-generated method stub

	}

	public void move_global(ControllerOrder direction) {
		// TODO Auto-generated method stub

	}

}
