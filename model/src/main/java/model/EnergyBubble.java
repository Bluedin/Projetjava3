package model;

public class EnergyBubble extends Element implements IDisappear{
	
	private Permeability permeability = Permeability.PENETRABLE;
	
	public EnergyBubble(int X, int Y){
		super(X, Y, "B");
	}

	public Permeability getPermeability(){
		return this.permeability;
	}

	public void disappear(ExitDoor exitDoor) {
		// TODO Auto-generated method stub
		this.X = -5;
		this.Y = -5;
		exitDoor.changeState();
	}

	public void disappear() {
		// TODO Auto-generated method stub
		
	}

	public void disappear(Hero hero) {
		// TODO Auto-generated method stub
		
	}
	
}
