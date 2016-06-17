package model;

public class Hero extends Element{

	private boolean life;
	private int score;
	
	
	public Hero(int X, int Y) {
		super(X, Y, "HR");
		this.score = 0;
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

}
