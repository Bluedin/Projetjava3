package model;

public class Hero extends Element implements IMobile{

	private boolean life;
	private int score;
	private Orientation orientation;
	private Spell spell;
	private boolean hasSpell;
	
	public Hero(int X, int Y) {
		super(X, Y, "sprite/lorann_r.png");
		this.score = 0;
		this.orientation = Orientation.RIGHT;
		this.spell = new Spell(-5, -5);
		this.hasSpell = true;
		this.life = true;
	}
	
	public boolean getLife(){
		return life;
	}
	
	public void die(){
		life = false;
		System.out.println("Perdu");
	}
	
	public int getScore(){
		return score;
	}
	
	public boolean getHasSpell(){
		return this.hasSpell;
	}
	
	public void gainSpell(){
		hasSpell = true;
	}
	
	public Spell getSpell(){
		return this.spell;
	}
	
	public void gainScore(int valeur){
		score += valeur;
	}
	
	public void shoot(){
		this.spell.setX(this.getX());
		this.spell.setY(this.getY());
		this.spell.setOrientation(this.orientation);
		this.spell.moveGlobal(this.spell, this.orientation);
		hasSpell = false;
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

	@Override
	public void moveGlobal(Element element, Orientation orientation) {
		switch(orientation){
		case DOWN:
			moveDown(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_b.png");
			break;
		case LEFT:
			moveLeft(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_l.png");
			break;
		case LEFT_DOWN:
			moveLeft(element);
			moveDown(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_bl.png");
			break;
		case RIGHT:
			moveRight(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_r.png");
			break;
		case RIGHT_DOWN:
			moveRight(element);
			moveDown(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_br.png");
			break;
		case UP:
			moveUp(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_u.png");
			break;
		case UP_LEFT:
			moveUp(element);
			moveLeft(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_ul.png");
			break;
		case UP_RIGHT:
			moveUp(element);
			moveRight(element);
			this.orientation = orientation;
			this.setSprite("sprite/lorann_ur.png");
			break;
		default:
			break;
		}
		
	}

}
