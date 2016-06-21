package model;

public class Ennemy extends Element implements IDisappear {

	private boolean life;
	private IBehaviour behaviour;
	private boolean nBehaviour;

	public Ennemy(int X, int Y, String sprite) {
		super(X, Y, null);
		switch (sprite) {
		case "1":
			sprite = "sprite/monster_1.png";
			break;
		case "2":
			sprite = "sprite/monster_2.png";
			break;
		case "3":
			sprite = "sprite/monster_3.png";
			break;
		case "4":
			sprite = "sprite/monster_4.png";
			break;
		}
		this.setSprite(sprite);
		this.behaviour = new Normal();
		this.nBehaviour = true;
		this.life = true;
		// TODO Auto-generated constructor stub
	}

	public void changeBehaviour() {
		if (nBehaviour) {
			this.behaviour = new Enraged();
			this.nBehaviour = false;
		} else {
			this.behaviour = new Normal();
			this.nBehaviour = true;
		}
	}

	public boolean getBehaviour() {
		return this.nBehaviour;
	}

	public boolean getLife() {
		return this.life;
	}

	public void disappear() {
		// TODO Auto-generated method stub
		this.X = -5;
		this.Y = -5;
		this.life = false;
	}

	public void disappear(Hero hero) {
		// TODO Auto-generated method stub

	}

	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub

	}
	
	public void reset(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	public void move(Hero hero, World world) {
		if (hero.getX() - this.getX() > -4 && hero.getX() - this.getX() < 4 && hero.getY() - this.getY() > -4
				&& hero.getY() - this.getY() < 4 && nBehaviour) {
			changeBehaviour();
		} else if (!nBehaviour) {
			changeBehaviour();
		}
		if (life) {
			behaviour.move(this, hero, world);
		}
		if (this.getX() == hero.getX() && this.getY() == hero.getY()) {
			hero.die();
		}
	}
	

}
