package model;

public class Wall extends Element {

	private Permeability permeability = Permeability.BLOCKING;
	
	public Wall(int X, int Y){
		super(X, Y, "X");
	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
