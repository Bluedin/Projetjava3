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

		elementList = new ArrayList<Element>();
		immobileList = new ArrayList<IPermeable>();
		mobileList = new ArrayList<IMobile>();
		erasableList = new ArrayList<IDisappear>();
		ennemyList = new ArrayList<Ennemy>();

	}

	public String[][] getWorld() {
		return generateMapString();
	}

	public void animate() {

		int x = 0;
		int y = 0;
		boolean condition = true;
		boolean isBlocking = false;
		for (Ennemy ennemy : ennemyList) {
			x = ennemy.getX();
			y = ennemy.getY();
			ennemy.move(hero);
			while (condition) {
				for (Element element : elementList) {
					if (element.getX() == ennemy.getX() + 1 && element.getY() == ennemy.getY() - 1
							&& element instanceof IPermeable) {
						if (element instanceof EnergyBubble || element instanceof Wall || element instanceof Gold) {
							isBlocking = true;
						} else if (element instanceof Background && !isBlocking) {
							condition = false;
						}
					}
					if (isBlocking) {
						ennemy.setX(x);
						ennemy.setY(y);
						ennemy.move(hero);
					}
				}

			}
			condition = true;
			isBlocking = false;
		}

		if (!this.spellOrNot()) {
			this.hero.getSpell().moveGlobal(this.hero.getSpell(), null);
			for (Element element : elementList) {
				if (element.getX() == this.hero.getSpell().getX() && element.getY() == this.hero.getSpell().getY()
						&& element instanceof IPermeable && !(element instanceof Background)) {
					this.hero.getSpell().setOrientation(this.hero.getSpell().getOrientation());
					this.hero.getSpell().moveGlobal(this.hero.getSpell(), null);
					this.hero.getSpell().moveGlobal(this.hero.getSpell(), null);
				}
			}
			for (Ennemy ennemy : ennemyList) {
				if (ennemy.getX() == this.hero.getSpell().getX() && ennemy.getY() == this.hero.getSpell().getY()) {
					ennemy.disappear();
				}
			}
			if (this.hero.getX() == this.hero.getSpell().getX() && this.hero.getY() == this.hero.getSpell().getY()) {
				this.hero.getSpell().disappear(hero);
			}
		}

	}

	public String[][] generateMapString() {
		String world[][] = new String[20][12];
		for (Element element : this.elementList) {
			if (element.getX() - 1 < 20 && element.getX() - 1 >= 0 && element.getY() - 1 < 12 && element.getY() - 1 >= 0
					&& element.getSprite() != null) {
				world[element.getX() - 1][element.getY() - 1] = element.getSprite();
			}
		}
		for (Ennemy ennemy : this.ennemyList) {
			if (ennemy.getX() - 1 < 20 && ennemy.getX() - 1 >= 0 && ennemy.getY() - 1 < 12 && ennemy.getY() - 1 >= 0) {
				world[ennemy.getX() - 1][ennemy.getY() - 1] = ennemy.getSprite();
			}
		}
		world[exitDoor.getX() - 1][exitDoor.getY() - 1] = exitDoor.getSprite();
		world[hero.getX() - 1][hero.getY() - 1] = hero.getSprite();
		if (hero.getSpell().getX() < 20 && hero.getSpell().getX() >= 0 && hero.getSpell().getY() < 12
				&& hero.getSpell().getY() >= 0) {
			world[hero.getSpell().getX() - 1][hero.getSpell().getY() - 1] = hero.getSpell().getSprite();
		}
		return world;
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
			this.immobileList.add(energyBubble);
			this.elementList.add(energyBubble);
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
		if (this.exitDoor.getX() == X && this.exitDoor.getY() == Y) {
			return this.exitDoor.getPermeability() == Permeability.PENETRABLE;
		} else {
			for (Element element : this.elementList) {
				if (element.getX() == X - 1 && element.getY() == Y && i == 0) {
					i++;
					j++;
				} else if (i == 0) {
					j++;
				}
			}

			return this.immobileList.get(j).getPermeability() == Permeability.PENETRABLE;
		}

	}

	public boolean spellOrNot() {
		return this.hero.getHasSpell();
	}

	public void shoot() {
		this.hero.shoot();
	}

	public void move_global(ControllerOrder direction) {
		Orientation orientation = null;
		switch (direction) {
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
		this.hero.moveGlobal(this.hero, orientation);
		int i = 0;
		int j = 0;
		for (Element element : elementList) {
			if (element instanceof IDisappear && i == 0) {
				j++;
				if (element.getX() == this.hero.getX() && element.getY() == this.hero.getY()) {
					i++;
				}
			}
		}
		this.erasableList.get(j-1).disappear();
		this.erasableList.get(j-1).disappear(this.exitDoor);
		this.erasableList.get(j-1).disappear(this.hero);

	}

}
