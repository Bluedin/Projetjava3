package model;

/**
 *ELement abstract class
 * 
 */
public abstract class Element {

	/**
	 * int x
	 * indicates the horizontal position on the map
	 */
	protected int X;
	/**
	 * int y
	 * indicates the vertical position on the map from the top
	 */
	protected int Y;
	/**
	 * string
	 * contains the path to the corresponding image
	 */
	protected String sprite;
	
	/**
	 * Constructor of the class
	 * @param X
	 * @param Y
	 * @param sprite
	 */
	public Element(int X, int Y, String sprite){
		this.X = X;
		this.Y = Y;
		this.sprite = sprite;
	}

	/**
	 * getter
	 * @return X
	 */
	public int getX() {
		return X;
	}

	/**
	 * setter
	 * @param x
	 */
	protected void setX(int x) {
		X = x;
	}

	/**
	 * getter
	 * @return Y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * setter
	 * @param y
	 */
	protected void setY(int y) {
		Y = y;
	}

	/**
	 * getter
	 * @return sprite
	 */
	public String getSprite() {
		return sprite;
	}

	/**
	 * setter
	 * @param sprite
	 */
	protected void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
}
