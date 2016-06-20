package model;

import java.util.ArrayList;

import contract.ControllerOrder;

public class World {

	private ArrayList<Element> elementList;
	private ArrayList<IPermeable> immobileList;
	private ArrayList<IMobile> mobileList;
	private ArrayList<IDisappear> erasableList;
	private ArrayList<Ennemy> ennemyList;
	private ExitDoor exitDoor;
	private Hero hero;
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
		Background background = new Background(X, Y);
		switch (key) {
		case "l":
			this.hero = new Hero(X, Y);
			this.mobileList.add(this.hero.getSpell());
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case "e":
			this.ennemyList.add(new Ennemy(X, Y, "" + this.nbrEnnemy));
			this.immobileList.add(background);
			this.elementList.add(background);
			this.nbrEnnemy++;
			break;
		case "g":
			Gold gold = new Gold(X, Y);
			this.erasableList.add(gold);
			this.immobileList.add(gold);
			this.elementList.add(gold);
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case "b":
			EnergyBubble energyBubble = new EnergyBubble(X, Y);
			this.erasableList.add(energyBubble);
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case "x":
			this.exitDoor = new ExitDoor(X, Y);
			break;
		case "h":
			Wall wall1 = new Wall(X, Y, "1");
			this.immobileList.add(wall1);
			this.elementList.add(wall1);
			break;
		case "v":
			Wall wall2 = new Wall(X, Y, "2");
			this.immobileList.add(wall2);
			this.elementList.add(wall2);
			break;
		case "c":
			Wall wall3 = new Wall(X, Y, "3");
			this.immobileList.add(wall3);
			this.elementList.add(wall3);
			break;
		case "f":
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		}

	}

	public int positionHeroX() {
		return this.hero.getX();
	}

	public int positionHeroY() {
		return this.hero.getY();
	}

	public boolean isPenetrable(int X, int Y) {
		int i = 0;
		int j = 0;
		while (this.elementList.get(i).getX() != X && this.elementList.get(i).getY() != Y
				&& this.elementList.get(i).getClass() == Hero.class
				&& this.elementList.get(i).getClass() == Spell.class
				&& this.elementList.get(i).getClass() == Ennemy.class) {
			i++;
		}
		while (this.immobileList.get(j) == this.elementList.get(i)){
			j++;
		}
		
		return this.immobileList.get(j).getPermeability() == Permeability.PENETRABLE;
	}

	public boolean spellOrNot() {
		return this.hero.getHasSpell();
	}

	public void shoot() {
		this.hero.shoot();
	}

	public void move_global(ControllerOrder direction) {
		Orientation orientation = null;
		switch(direction){
		case UP:
			orientation = Orientation.UP;
			break;
		case DOWN:
			orientation = Orientation.DOWN;
			break;
		case LEFT:
			orientation = Orientation.LEFT;
			break;
		case RIGHT:
			orientation = Orientation.RIGHT;
			break;
		case UPLEFT:
			orientation = Orientation.UP_LEFT;
			break;
		case UPRIGHT:
			orientation = Orientation.UP_RIGHT;
			break;
		case DOWNLEFT:
			orientation = Orientation.LEFT_DOWN;
			break;
		case DOWNRIGHT:
			orientation = Orientation.RIGHT_DOWN;
			break;
		default:
			break;
		}
		this.hero.moveGlobal(null, orientation);

	}

}
