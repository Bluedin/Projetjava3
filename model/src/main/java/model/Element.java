package model;

public abstract class Element {

	protected int X;
	protected int Y;
	protected String sprite;
	
	public Element(int X, int Y, String sprite){
		
	}

	public int getX() {
		return X;
	}

	protected void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	protected void setY(int y) {
		Y = y;
	}

	public String getSprite() {
		return sprite;
	}

	protected void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
	
	
}
