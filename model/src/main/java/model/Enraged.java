package model;

public class Enraged implements IBehaviour, IMobile{


	public Ennemy move(Ennemy ennemy, Hero hero) {
		return ennemy;
		
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

	public void moveGlobal(Element element) {
	}



}
