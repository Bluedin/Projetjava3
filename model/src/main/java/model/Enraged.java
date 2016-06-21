package model;

public class Enraged implements IBehaviour, IMobile{


	public void move(Ennemy ennemy, Hero hero, World world) {
		
	}

	public void moveDown(Element element) {
		element.Y ++;
	}

	public void moveLeft(Element element) {
		element.X --;
	}

	public void moveUp(Element element) {
		element.Y --;
	}

	public void moveRight(Element element) {
		element.X ++;
	}

	public void moveGlobal(Element element, Orientation orientation) {
		switch(orientation){
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

	@Override
	public boolean moveTest(Ennemy ennemy, Hero hero, World world, int randomNumber) {
		// TODO Auto-generated method stub
		return false;
	}



}
