package model;

public class Enraged implements IBehaviour, IMobile{


	public Ennemy move(Ennemy ennemy, Hero hero) {
		return ennemy;
		
	}

	public Ennemy moveDown(Ennemy ennemy) {
		ennemy.Y ++;
		return ennemy;
	}

	public Ennemy moveLeft(Ennemy ennemy) {
		ennemy.X --;
		return ennemy;
	}

	public Ennemy moveUp(Ennemy ennemy) {
		ennemy.Y --;
		return ennemy;
	}

	public Ennemy moveRight(Ennemy ennemy) {
		ennemy.X ++;
		return ennemy;
	}

	public Ennemy moveGlobal(Ennemy ennemy) {
		return ennemy;
	}



}
