package model;

public class Ennemy extends Element implements IDisappear{

	private boolean life;
	private IBehaviour behaviour;
	private boolean nBehaviour;
		
	
	public Ennemy(int X, int Y, String sprite) {
		super(X, Y, sprite);
		this.behaviour = new Normal();
		this.nBehaviour = true;
		// TODO Auto-generated constructor stub
	}
	
	public void changeBehaviour(){
		if(nBehaviour){
			this.behaviour = new Enraged();
			this.nBehaviour = false;
		}else{
			this.behaviour = new Normal();
			this.nBehaviour = true;
		}
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
	
	public void move(Hero hero){
		if(life){
			behaviour.move(this , hero);
		}
	}
	
	

}
