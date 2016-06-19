package model;

public class Spell extends Element implements IDisappear, IMobile{
	
	int state;
	
	public Spell(int X, int Y) {
		super(X, Y, "/sprite/fireball_1.png");
		state = 0;
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
		switch(orientation){
		case UP:
			moveDown(element);
			break;
		case RIGHT:
			moveLeft(element);
			break;
		case UP_RIGHT:
			moveLeft(element);
			moveDown(element);
			break;
		case LEFT:
			moveRight(element);
			break;
		case UP_LEFT:
			moveRight(element);
			moveDown(element);
			break;
		case DOWN:
			moveUp(element);
			break;
		case RIGHT_DOWN:
			moveUp(element);
			moveLeft(element);
			break;
		case LEFT_DOWN:
			moveUp(element);
			moveRight(element);
			break;
		default:
			break;
		}
		switch(state){
		case 0:
			this.setSprite("/sprite/fireball_2.png");
			this.state ++;
			break;
		case 1:
			this.setSprite("/sprite/fireball_3.png");
			this.state ++;
			break;
		case 2:
			this.setSprite("/sprite/fireball_4.png");
			this.state ++;
			break;
		case 3:
			this.setSprite("/sprite/fireball_5.png");
			this.state ++;
			break;
		case 4:
			this.setSprite("/sprite/fireball_1.png");
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
