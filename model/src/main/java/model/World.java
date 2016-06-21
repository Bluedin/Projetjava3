package model;

import model.Element;
import model.Enraged;
import model.ExitDoor;
import model.Hero;
import model.IBehaviour;
import model.IDisappear;
import model.IPermeable;
import model.Normal;
import model.Permeability;
import model.World;

import java.util.ArrayList;

import contract.ControllerOrder;

/**
 * World class
 * which contains the different object 
 * which compose our model
 *
 */
public class World {

	/**
	 * ArrayList<Element> elementList
	 * contains all elements which doesn't move
	 * such as background, gold, energyBubble and wall
	 * could possibly contains all elements
	 * allows the use of getter to find the position and the sprite of the objects
	 */
	private ArrayList<Element> elementList;
	/**
	 * ArrayList<IPermeable> immobileList
	 * contains all elements which doesn't move
	 * such as background, gold, energyBubble and wall
	 * allows the use of Getter to find the Permeability of the objects
	 */
	private ArrayList<IPermeable> immobileList;
	/**
	 * ArrayList<IDisappear> erasableList
	 * contains all elements which can be erased
	 * such as gold, energyBubble, spell and ennemy
	 * allows the use of the method disappear
	 */
	private ArrayList<IDisappear> erasableList;
	/**
	 * ArrayList<Ennemy> ennemyList
	 * contains the list of ennemy
	 */
	private ArrayList<Ennemy> ennemyList;
	/**
	 * ExitDoor exitDoor
	 */
	private ExitDoor exitDoor;
	/**
	 * Hero hero
	 */
	private Hero hero;
	/**
	 * nbrEnnemy = 1
	 * allows to define different sprite for each ennemy
	 */
	private int nbrEnnemy = 1;

	/**
	 * constructor
	 * initialize the different list
	 */
	public World() {

		elementList = new ArrayList<Element>();
		immobileList = new ArrayList<IPermeable>();
		erasableList = new ArrayList<IDisappear>();
		ennemyList = new ArrayList<Ennemy>();

	}

	/**
	 * return the table of string 
	 * formed by the different elements of world 
	 * at their respective position
	 * @return String[][]
	 */
	public String[][] getWorld() {
		return generateMapString();
	}
	
	/**
	 * getter
	 * @return Hero
	 */
	public Hero getHero(){
		return this.hero;
	}

	/**
	 * make the different ennemy move automatically
	 * Different tests relative to spell
	 * make the spell move if not with the hero
	 */
	public void animate() {

		for (Ennemy ennemy : ennemyList) {

			ennemy.move(hero, this);

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
					this.hero.getSpell().disappear(this.hero);
				}
			}
			if (this.hero.getX() == this.hero.getSpell().getX() && this.hero.getY() == this.hero.getSpell().getY()) {
				this.hero.getSpell().disappear(hero);
			}
		}

	}

	/**
	 * @return ArrayList<Element>
	 */
	public ArrayList<Element> getElementList() {
		return elementList;
	}

	/**
	 * @return ArrayList<IPermeable>
	 */
	public ArrayList<IPermeable> getImmobileList() {
		return immobileList;
	}

	/**
	 * @return ArrayList<IDisappear>
	 */
	public ArrayList<IDisappear> getErasableList() {
		return erasableList;
	}

	/**
	 * @return ArrayList<Ennemy>
	 */
	public ArrayList<Ennemy> getEnnemyList() {
		return ennemyList;
	}

	/**
	 * generate the table of string relative at this world
	 * @return String[][]
	 */
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

	/**
	 * create the respective elements from the key
	 * in the right lists (or stocked in the right attribute)
	 * a background at the same position if erasable
	 * @param key
	 * @param X
	 * @param Y
	 */
	public void addElement(char key, int X, int Y) {
		Background background = new Background(X, Y);
		switch (key) {
		case 'l':
			this.hero = new Hero(X, Y);
			//this.mobileList.add(this.hero.getSpell());
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case 'e':
			this.ennemyList.add(new Ennemy(X, Y, "" + this.nbrEnnemy));
			this.immobileList.add(background);
			this.elementList.add(background);
			this.nbrEnnemy++;
			break;
		case 'g':
			Gold gold = new Gold(X, Y);
			this.erasableList.add(gold);
			this.immobileList.add(gold);
			this.elementList.add(gold);
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case 'b':
			EnergyBubble energyBubble = new EnergyBubble(X, Y);
			this.erasableList.add(energyBubble);
			this.immobileList.add(energyBubble);
			this.elementList.add(energyBubble);
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		case 'x':
			this.exitDoor = new ExitDoor(X, Y);
			break;
		case 'h':
			Wall wall1 = new Wall(X, Y, "1");
			this.immobileList.add(wall1);
			this.elementList.add(wall1);
			break;
		case 'v':
			Wall wall2 = new Wall(X, Y, "2");
			this.immobileList.add(wall2);
			this.elementList.add(wall2);
			break;
		case 'c':
			Wall wall3 = new Wall(X, Y, "3");
			this.immobileList.add(wall3);
			this.elementList.add(wall3);
			break;
		case 'f':
			this.immobileList.add(background);
			this.elementList.add(background);
			break;
		}

	}

	/**
	 * getter position Hero X
	 * @return int
	 */
	public int positionHeroX() {
		return this.hero.getX();
	}

	/**
	 * getter position Hero Y
	 * @return int
	 */
	public int positionHeroY() {
		return this.hero.getY();
	}

	/**
	 * test if the element at the given position is PENETRABLE
	 * @param X
	 * @param Y
	 * @return
	 */
	public boolean isPenetrable(int X, int Y) {
		int j = 0;
		// test si on est sur la porte
		if (this.exitDoor.getX() == X && this.exitDoor.getY() == Y) {
			return this.exitDoor.getPermeability() == Permeability.PENETRABLE;
		}
		for (Element element : this.elementList) {
			if (element.getX() == X && element.getY() == Y) {
				if (this.immobileList.get(j).getPermeability() == Permeability.BLOCKING) {
					return false;
				}
			}
			j++;
		}

		return true;

	}

	/**
	 * test if the hero has his spell
	 * @return boolean
	 */
	public boolean spellOrNot() {
		return this.hero.getHasSpell();
	}

	/**
	 * the hero shoot his spell
	 */
	public void shoot() {
		this.hero.shoot();
	}

	/**
	 * make the hero move
	 * test if interaction with other objects
	 * if the hero is at the same position that the door
	 * and the door is open the method return true
	 * @param direction
	 * @return boolean
	 */
	public boolean move_global(ControllerOrder direction) {
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
					this.erasableList.get(j - 1).disappear();
					this.erasableList.get(j - 1).disappear(this.exitDoor);
					this.erasableList.get(j - 1).disappear(this.hero);
					i++;
				}
			}
		}
		for(Ennemy ennemy : ennemyList){
			if(this.hero.getX() == ennemy.getX() && this.hero.getY() == ennemy.getY()){
				this.hero.die();
			}
		}
		if(!this.hero.getHasSpell()){
			if(this.hero.getSpell().getX() == this.hero.getX() && this.hero.getSpell().getY() == this.hero.getY()){
				this.hero.getSpell().disappear(hero);
			}
		}
		if (this.hero.getX() == this.exitDoor.getX() && this.hero.getY() == this.exitDoor.getY()
				&& !this.exitDoor.getState()) {
			this.hero.die();
		} else if (this.hero.getX() == this.exitDoor.getX() && this.hero.getY() == this.exitDoor.getY()
				&& this.exitDoor.getState()) {
			return true;
		}
		return false;
	}

}