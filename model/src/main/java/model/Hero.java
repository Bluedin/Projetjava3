package model;

public class Hero extends Element{

	private boolean life;
	private int score;
	private Orientation orientation;
	private Spell spell;
	
	public Hero(int X, int Y) {
		super(X, Y, "HR");
		this.score = 0;
		orientation = Orientation.RIGHT;
		spell = new Spell(-5, -5);
	}
	
	public boolean getLife(){
		return life;
	}
	
	public int getScore(){
		return score;
	}
	
	public void gainScore(int valeur){
		score += valeur;
	}
	
	public void shoot(){
		
	}

}
