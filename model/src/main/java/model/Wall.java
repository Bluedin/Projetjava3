package model;

public class Wall extends Element {

	private Permeability permeability = Permeability.BLOCKING;
	
	public Wall(int X, int Y, String sprite){
		super(X, Y, sprite);
	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
