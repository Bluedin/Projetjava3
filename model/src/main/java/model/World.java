package model;

import java.util.ArrayList;

public class World {
	
	private ArrayList<Element> elementList;
	private int nbrEnnemy = 1;

	public World(){
		
	}
	
	public void getWorld(){
		
	}
	
	public void animate(String mouvement){
		
	}
	
	public void generateMapString(){
		
	}
	
	public void addElement(String key, int X, int Y){
		switch(key){
		case "l":
			this.elementList.add(new Hero(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "e":
			this.elementList.add(new Ennemy(X, Y, "" + this.nbrEnnemy));
			this.elementList.add(new Background(X, Y));
			this.nbrEnnemy ++;
			break;
		case "g":
			this.elementList.add(new Gold(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "b":
			this.elementList.add(new EnergyBubble(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "x":
			this.elementList.add(new ExitDoor(X, Y));
			break;
		case "h":
			this.elementList.add(new Wall(X, Y, "1"));
			break;
		case "v":
			this.elementList.add(new Wall(X, Y, "2"));
			break;
		case "c":
			this.elementList.add(new Wall(X, Y, "3"));
			break;
		case "f":
			this.elementList.add(new Background(X, Y));
			break;
		}
		
		
	}
	
}
