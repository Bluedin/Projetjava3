package model;

/**
 * interface which is part of the DP Strategy
 * include the method to move the ennemy 
 * and the method to test if this move is possible
 */
public interface IBehaviour {

	public void move(Ennemy ennemy, Hero hero, World world);
	public boolean moveTest(Ennemy ennemy, Hero hero, World world, int randomNumber);
	
}
