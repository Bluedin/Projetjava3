package model;

/**
 * spell class 
 * extends Element
 * implements IDisappear and IMobile
 *
 */
public class Spell extends Element implements IDisappear, IMobile{
	
	/**
	 * indicates the color(sprite) which is used
	 * used in the movement to make the spell change color
	 */
	private int state;
	/**
	 * orientation of the spell
	 * defines the course of its movement
	 */
	private Orientation orientation;
	
	/**
	 * constructor
	 * @param X
	 * @param Y
	 */
	public Spell(int X, int Y) {
		super(X, Y, "sprite/fireball_1.png");
		state = 0;
	}
	
	/**
	 * getter
	 * @return Orientation orientation
	 */
	public Orientation getOrientation(){
		return this.orientation;
	}
	
	/**
	 * set the orientation of the spell
	 * using this method inverse the orientation given in parameters
	 * @param orientation
	 */
	public void setOrientation(Orientation orientation){
		switch(orientation){
		case UP:
			this.orientation = Orientation.DOWN;
			break;
		case UP_RIGHT:
			this.orientation = Orientation.LEFT_DOWN;
			break;
		case RIGHT:
			this.orientation = Orientation.LEFT;
			break;
		case RIGHT_DOWN:
			this.orientation = Orientation.UP_LEFT;
			break;
		case DOWN:
			this.orientation = Orientation.UP;
			break;
		case LEFT_DOWN:
			this.orientation = Orientation.UP_RIGHT;
			break;
		case LEFT:
			this.orientation = Orientation.RIGHT;
			break;
		case UP_LEFT:
			this.orientation = Orientation.RIGHT_DOWN;
			break;
			
		}
	}

	/**
	 * @see model.IMobile#moveDown(model.Element)
	 */
	public void moveDown(Element element) {
		element.Y ++;
	}

	/**
	 * @see model.IMobile#moveLeft(model.Element)
	 */
	public void moveLeft(Element element) {
		element.X --;
	}

	/**
	 * @see model.IMobile#moveUp(model.Element)
	 */
	public void moveUp(Element element) {
		element.Y --;
	}

	/**
	 * @see model.IMobile#moveRight(model.Element)
	 */
	public void moveRight(Element element) {
		element.X ++;
	}

	/**
	 * move the spell from the orientation
	 * then change the sprite to change the color
	 * each time this method is called the sprite change
	 * by the fifth the sprite comes back to the first
	 * @see model.IMobile#moveGlobal(model.Element, model.Orientation)
	 */
	public void moveGlobal(Element element, Orientation orientation) {
		switch(this.orientation){
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
		switch(state){
		case 0:
			this.setSprite("sprite/fireball_2.png");
			this.state ++;
			break;
		case 1:
			this.setSprite("sprite/fireball_3.png");
			this.state ++;
			break;
		case 2:
			this.setSprite("sprite/fireball_4.png");
			this.state ++;
			break;
		case 3:
			this.setSprite("sprite/fireball_5.png");
			this.state ++;
			break;
		case 4:
			this.setSprite("sprite/fireball_1.png");
			this.state = 0;
			break;
		}
	}

	/**
	 * empty)
	 * @see model.IDisappear#disappear()
	 */
	public void disappear() {
		
	}

	/**
	 * make the spell return to hero
	 * @see model.IDisappear#disappear(model.Hero)
	 */
	public void disappear(Hero hero) {
		this.setX(-5);
		this.setY(-5);
		hero.gainSpell();
	}

	/**
	 * empty
	 * @see model.IDisappear#disappear(model.ExitDoor)
	 */
	public void disappear(ExitDoor exitDoor) {
		
	}
	
	

}
