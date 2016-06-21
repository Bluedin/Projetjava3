package model;

public interface IBehaviour {

	public void move(Ennemy ennemy, Hero hero, World world);
	public boolean moveTest(Ennemy ennemy, Hero hero, World world, int randomNumber);
	
}
