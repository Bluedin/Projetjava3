package model;

public class Background extends Element {

	private Permeability permeability = Permeability.PENETRABLE;

	public Background(int X, int Y) {
		super(X, Y, "+");
	}

	public Permeability getPermeability() {

		return this.permeability;

	}

}