package model;

public class ExitDoor extends Element{
	
	
	/**state indicates the ExitDoor state:
	 * true = open
	 * false = closed
	 */
	private boolean state;
	private Permeability permeability = Permeability.PENETRABLE;

	/**
	 * @param X
	 * @param Y
	 * this constructor get the sprite and coordinated of the door and get the state if
	 * it s open or close 
	 */
	public ExitDoor(int X, int Y) {
		super(X, Y, "sprite/gate_closed.png");
		this.state = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * this method is for change the sprite of the exit door and the state is true when 
	 * looran get the energy ball
	 */
	public void changeState(){
		this.state = true;
		this.sprite = "sprite/gate_open.png";
	}
	/**
	 * this method is for get the state of the door open or closed
	 * @return
	 */
	public boolean getState(){
		return state;
	}
	
	/**
	 * this method get the permeability of the door 
	 * @return
	 */
	public Permeability getPermeability(){
		return this.permeability;
	}
	
}
