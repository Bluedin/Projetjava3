package model;

/**
 * contains the methods which allow an object to move by manipulating its coordinate
 *
 */
public interface IMobile {

	void moveDown(Element element);
	void moveLeft(Element element);
	void moveUp(Element element);
	void moveRight(Element element);
	void moveGlobal(Element element, Orientation orientation);
	
}
