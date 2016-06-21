package model;

/**
 * Ennemy class
 */
public class Ennemy extends Element implements IDisappear {

	/**
	 * boolean indicate if the ennemy is alive
	 */
	private boolean life;
	/**
	 * IBehaviour contains the behaviour of the ennemy
	 */
	private IBehaviour behaviour;
	/**
	 * boolean indicates the state of the ennemy
	 */
	private boolean nBehaviour;

	/**
	 * Constructor Has a different sprite based on the string entered
	 * 
	 * @param X
	 * @param Y
	 * @param sprite
	 */
	public Ennemy(int X, int Y, String sprite) {
		super(X, Y, null);
		switch (sprite.charAt(0)) {
		case '1':
			sprite = "sprite/monster_1.png";
			break;
		case '2':
			sprite = "sprite/monster_2.png";
			break;
		case '3':
			sprite = "sprite/monster_3.png";
			break;
		case '4':
			sprite = "sprite/monster_4.png";
			break;
		}
		this.setSprite(sprite);
		this.behaviour = new Normal();
		this.nBehaviour = true;
		this.life = true;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Switch the behaviour of the ennemy
	 */
	public void changeBehaviour() {
		if (nBehaviour) {
			this.behaviour = new Enraged();
			this.nBehaviour = false;
		} else {
			this.behaviour = new Normal();
			this.nBehaviour = true;
		}
	}

	/**
	 * getter
	 * 
	 * @return boolean nBehaviour
	 */
	public boolean getBehaviour() {
		return this.nBehaviour;
	}

	/**
	 * getter
	 * 
	 * @return boolean life
	 */
	public boolean getLife() {
		return this.life;
	}

	/**
	 * @see model.IDisappear#disappear()
	 */
	public void disappear() {
		// TODO Auto-generated method stub
		this.X = -5;
		this.Y = -5;
		this.life = false;
	}

	/**
	 * @see model.IDisappear#disappear(model.Hero)
	 */
	public void disappear(Hero hero) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see model.IDisappear#disappear(model.ExitDoor)
	 */
	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub

	}

	/**
	 * reset the position of the ennemy to those given in the parameter
	 * 
	 * @param x
	 * @param y
	 */
	public void reset(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * method to move the ennemy while testing the destination of the move and
	 * testing if the ennemy must change behaviour
	 * test if game over and if ennemy is touched by spell
	 * @param hero
	 * @param world
	 */
	public void move(Hero hero, World world) {
		if (hero.getX() - this.getX() > -4 && hero.getX() - this.getX() < 4 && hero.getY() - this.getY() > -4
				&& hero.getY() - this.getY() < 4) {
			if (nBehaviour) {
				changeBehaviour();
			}

		} else {
			if (!nBehaviour) {
				changeBehaviour();
			}
		}
		if (life) {
			behaviour.move(this, hero, world);
		}
		if (this.getX() == hero.getX() && this.getY() == hero.getY()) {
			hero.die();
		}
		if (hero.getSpell().getX() == this.getX() && hero.getSpell().getY() == this.getY()) {
			this.disappear();
			hero.getSpell().disappear(hero);
		}
	}

}