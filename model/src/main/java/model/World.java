package model;

import java.util.ArrayList;

public class World {
	
	private ArrayList<Element> elementList;

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
		case "H":
			this.elementList.add(new Hero(X, Y));
			this.elementList.add(new Background(X, Y));
			break;
		case "E":
			this.elementList.add(new Ennemy(X, Y, "1"));
			break;
		
		}
		
		
	}
	
}
