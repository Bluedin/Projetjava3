package model;

public class Wall extends Element implements IPermeable{

	private Permeability permeability = Permeability.BLOCKING;
	
	/**
	 * @param X
	 * @param Y
	 * @param sprite
	 * this method is the construcor of the class in this we get the sprite of all type of wall 
	 * and the "super" permited to get information abour elements
	 */
	public Wall(int X, int Y, String sprite){
		super(X, Y, sprite);
		switch(sprite){
		case "1":
			sprite = "sprite/horizontal_bone.png";
			break;
		case "2":
			sprite = "sprite/vertical_bone.png";
			break;
		case "3":
			sprite = "sprite/bone.png";
			break;
		}
		this.setSprite(sprite);
	}
	
	/**
	 * this method is for put the permeability we have in the enum class permeability 
	 * blocking or penetrable
	 */
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
