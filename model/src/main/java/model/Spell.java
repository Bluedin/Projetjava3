package model;

public class Spell extends Element implements IDisappear, IMobile{
	
	private int state;
	private Orientation orientation;
	
	public Spell(int X, int Y) {
		super(X, Y, "sprite/fireball_1.png");
		state = 0;
	}
	
	public Orientation getOrientation(){
		return this.orientation;
	}
	
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

	public void disappear() {
		// TODO Auto-generated method stub
		
	}

	public void disappear(Hero hero) {
		this.setX(-5);
		this.setY(-5);
		hero.gainSpell();
	}

	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
