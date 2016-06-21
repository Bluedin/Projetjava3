package model;

/**
 * Hero class
 * extends Element
 * implements IMobile
 *
 */
public class Hero extends Element implements IMobile{

	/**
	 * boolean life
	 */
	private boolean life;
	/**
	 * int score
	 */
	private int score;
	/**
	 * Orientation orientation
	 */
	private Orientation orientation;
	/**
	 * Spell spell
	 * composition
	 */
	private Spell spell;
	/**
	 * boolean hasSpell
	 * indicates if the hero is in possession of his spell
	 */
	private boolean hasSpell;
	
	/**
	 * constructor of Hero
	 * Create the spell at the same time out of the map
	 * @param X
	 * @param Y
	 */
	public Hero(int X, int Y) {
		super(X, Y, "sprite/lorann_r.png");
		this.score = 0;
		this.orientation = Orientation.RIGHT;
		this.spell = new Spell(-5, -5);
		this.hasSpell = true;
		this.life = true;
	}
	
	/**
	 * @return boolean
	 */
	public boolean getLife(){
		return life;
	}
	
	/**
	 * set life to false
	 */
	public void die(){
		life = false;
	}
	
	/**
	 * @return int score
	 */
	public int getScore(){
		return score;
	}
	
	/**
	 * @return boolean = true
	 * if the hero is in possession of his spell
	 */
	public boolean getHasSpell(){
		return this.hasSpell;
	}
	
	/**
	 * the hero gain his spell back
	 * set hasSpell to true
	 */
	public void gainSpell(){
		hasSpell = true;
	}
	
	/**
	 * @return Spell spell
	 * from the hero
	 */
	public Spell getSpell(){
		return this.spell;
	}
	
	/**
	 * @param valeur
	 * increase the score by the int in the parameter
	 */
	public void gainScore(int valeur){
		score += valeur;
	}
	
	/**
	 * shoot the spell
	 */
	public void shoot(){
		this.spell.setX(this.getX());
		this.spell.setY(this.getY());
		this.spell.setOrientation(this.orientation);
		this.spell.moveGlobal(this.spell, this.orientation);
		hasSpell = false;
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
	 * move the hero in fonction of the orientation given in parameter
	 * @see model.IMobile#moveGlobal(model.Element, model.Orientation)
	 */
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
