package model;

public class Spell extends Element implements IDisappear, IMobile{
	
	public Spell(int X, int Y) {
		super(X, Y, "SG");
		// TODO Auto-generated constructor stub
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

	public void disappear() {
		// TODO Auto-generated method stub
		
	}

	public void disappear(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
