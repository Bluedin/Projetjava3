package model;

public class Wall extends Element implements IPermeable{

	private Permeability permeability = Permeability.BLOCKING;
	
	public Wall(int X, int Y, String sprite){
		super(X, Y, sprite);
		switch(sprite){
		case "1":
			sprite = "/sprite/horizontal_bone.png";
			break;
		case "2":
			sprite = "/sprite/vertical_bone.png";
			break;
		case "3":
			sprite = "/sprite/bone.png";
			break;
		}
		this.setSprite(sprite);
	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
