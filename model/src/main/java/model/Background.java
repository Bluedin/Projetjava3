package model;

public class Background extends Element implements IPermeable{

	private Permeability permeability = Permeability.PENETRABLE;

	public Background(int X, int Y) {
		super(X, Y, "F");
	}

	public Permeability getPermeability() {

		return this.permeability;

	}

}
