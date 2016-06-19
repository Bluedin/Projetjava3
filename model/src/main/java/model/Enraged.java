package model;

public class Enraged implements IBehaviour, IMobile{


	public void move(Ennemy ennemy, Hero hero) {
		
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
		case UP:
			moveDown(element);
			break;
		case RIGHT:
			moveLeft(element);
			break;
		case UP_RIGHT:
			moveLeft(element);
			moveDown(element);
			break;
		case LEFT:
			moveRight(element);
			break;
		case UP_LEFT:
			moveRight(element);
			moveDown(element);
			break;
		case DOWN:
			moveUp(element);
			break;
		case RIGHT_DOWN:
			moveUp(element);
			moveLeft(element);
			break;
		case LEFT_DOWN:
			moveUp(element);
			moveRight(element);
			break;
		default:
			break;
		}
	}



}
