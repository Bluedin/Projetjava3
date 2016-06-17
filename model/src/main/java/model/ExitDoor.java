package model;

public class ExitDoor extends Element{
	
	private boolean state;
	private Permeability permeability = Permeability.PENETRABLE;

	public ExitDoor(int X, int Y) {
		super(X, Y, "XC");
		this.state = false;
		// TODO Auto-generated constructor stub
	}

	public void changeState(){
		this.state = true;
		this.sprite = "XO";
	}
	public boolean getState(){
		return state;
	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
