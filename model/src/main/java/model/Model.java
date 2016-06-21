package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IModel;

/**
 * The Class Model.
 *
 */
public class Model extends Observable implements IModel {

	/**  */
	private World world;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String[][] getWorld() {
		String world[][] = this.world.getWorld();
		return world;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setWorld(final World world) {
		this.world = world;
	}

	/*
	 * 
	 */
	public void loadWorld(int key) {
		try {
			final DAOWorld daoWorld = new DAOWorld(DBConnection.getInstance().getConnection());
			this.setWorld(daoWorld.find(key));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public int positionHeroX() {
		return this.world.positionHeroX();
	}

	public int positionHeroY() {
		return this.world.positionHeroY();
	}

	public boolean isPenetrable(int X, int Y) {
		return this.world.isPenetrable(X, Y);
	}

	public boolean spellOrNot() {
		return this.world.spellOrNot();
	}

	public void shoot() {
		this.world.shoot();
	}

	public boolean move_global(ControllerOrder direction) {
		boolean win = this.world.move_global(direction);
		this.setChanged();
		this.notifyObservers();
		return win;
	}

	public void animate() {
		this.world.animate();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public boolean heroIsAlive() {
		return this.world.getHero().getLife();
	}
}
