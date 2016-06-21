package model;

/**
 * contains the method to make an object disappear
 * with 3 methods of the same name which create a polymorphism
 */
public interface IDisappear {

	void disappear();
	void disappear(Hero hero);
	void disappear(ExitDoor exitDoor);
	
}
