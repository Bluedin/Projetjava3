package model;

public class Normal implements IBehaviour, IMobile {

	public void move(Ennemy ennemy, Hero hero) {
		int randomNumber = (int) Math.random() * 8;
		switch (randomNumber) {
		case 0:
			moveGlobal(ennemy, Orientation.UP);
			break;
		case 1:
			moveGlobal(ennemy, Orientation.UP_RIGHT);
			break;
		case 2:
			moveGlobal(ennemy, Orientation.RIGHT);
			break;
		case 3:
			moveGlobal(ennemy, Orientation.RIGHT_DOWN);
			break;
		case 4:
			moveGlobal(ennemy, Orientation.DOWN);
			break;
		case 5:
			moveGlobal(ennemy, Orientation.LEFT_DOWN);
			break;
		case 6:
			moveGlobal(ennemy, Orientation.LEFT);
			break;
		case 7:
			moveGlobal(ennemy, Orientation.UP_LEFT);
			break;
		default:
			break;
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

}
