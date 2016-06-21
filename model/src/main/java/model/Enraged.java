package model;

/**
 * Enraged class
 * Implements IBehaviour and IMobile
 * Part of the DP Strategy for ennemy
 * Make the ennemy chase after the hero
 */
public class Enraged implements IBehaviour, IMobile {

	public void move(Ennemy ennemy, Hero hero, World world) {
		
		Orientation orientation;
		Orientation orientation1 = null;
		Orientation orientation2 = null;
		int orientationOrdinal = 0;
		
		if (hero.getX() > ennemy.getX()) {
			orientation1 = Orientation.RIGHT;
		}else if(hero.getX() < ennemy.getX()){
			orientation1 = Orientation.LEFT;
		}
		if (hero.getY() > ennemy.getY()) {
			orientation2 = Orientation.DOWN;
		}else if (hero.getY() < ennemy.getY()){
			orientation2 = Orientation.UP;
		}
		
		if(orientation1 != null){
			if(orientation1 == Orientation.RIGHT){
				if(orientation2 != null){
					orientation = Orientation.RIGHT_DOWN;
					orientationOrdinal = 3;
				}else if(orientation2 == Orientation.UP){
					orientation = Orientation.UP_RIGHT;
					orientationOrdinal = 1;
				}else{
					orientation = Orientation.RIGHT;
					orientationOrdinal = 2;
				}
			}else{
				if(orientation2 != null){
					orientation = Orientation.LEFT_DOWN;
					orientationOrdinal = 5;
				}else if(orientation2 == Orientation.UP){
					orientation = Orientation.UP_LEFT;
					orientationOrdinal = 7;
				}else{
					orientation = Orientation.LEFT;
					orientationOrdinal = 6;
				}
			}
		}else{
			if(orientation2 == Orientation.UP){
				orientation = Orientation.UP;
				orientationOrdinal = 0;
			}else{
				orientation = Orientation.DOWN;
				orientationOrdinal = 4;
			}
		}
		if(!moveTest(ennemy, hero, world, orientationOrdinal)){
			this.moveGlobal(ennemy, orientation);
		}
		

	}

	public void moveDown(Element element) {
		element.Y++;
	}

	public void moveLeft(Element element) {
		element.X--;
	}

	public void moveUp(Element element) {
		element.Y--;
	}

	public void moveRight(Element element) {
		element.X++;
	}

	public void moveGlobal(Element element, Orientation orientation) {
		switch (orientation) {
		case DOWN:
			moveDown(element);
			break;
		case LEFT:
			moveLeft(element);
			break;
		case LEFT_DOWN:
			moveLeft(element);
			moveDown(element);
			break;
		case RIGHT:
			moveRight(element);
			break;
		case RIGHT_DOWN:
			moveRight(element);
			moveDown(element);
			break;
		case UP:
			moveUp(element);
			break;
		case UP_LEFT:
			moveUp(element);
			moveLeft(element);
			break;
		case UP_RIGHT:
			moveUp(element);
			moveRight(element);
			break;
		default:
			break;
		}
	}

	public boolean moveTest(Ennemy ennemy, Hero hero, World world, int randomNumber) {
		int xTest = ennemy.getX();
		;
		int yTest = ennemy.getY();
		switch (randomNumber) {
		case 0:
			yTest--;
			break;
		case 1:
			yTest--;
			xTest++;
			break;
		case 2:
			xTest++;
			break;
		case 3:
			xTest++;
			yTest++;
			break;
		case 4:
			yTest++;
			break;
		case 5:
			xTest--;
			yTest++;
			break;
		case 6:
			xTest--;
			break;
		case 7:
			xTest--;
			yTest--;
			break;
		default:
			break;
		}
		for (Element element : world.getElementList()) {
			if (xTest == element.getX() && yTest == element.getY() && !(element instanceof Background)
					&& element instanceof IPermeable) {
				return true;
			}
		}
		if(xTest == hero.getX() && yTest == hero.getY()){
			hero.die();
		}
		return false;
	}

}
