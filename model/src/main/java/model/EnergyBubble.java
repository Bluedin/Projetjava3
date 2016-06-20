package model;

public class EnergyBubble extends Element implements IDisappear, IPermeable{
	
	private Permeability permeability = Permeability.PENETRABLE;
	
	public EnergyBubble(int X, int Y){
		super(X, Y, "sprite/crystal_ball.png");
	}

	public Permeability getPermeability(){
		return this.permeability;
	}

	public void disappear(ExitDoor exitDoor) {
		this.X = -5;
		this.Y = -5;
		exitDoor.changeState();
	}

	public void disappear() {
		
	}

	public void disappear(Hero hero) {
		
	}
	
}
