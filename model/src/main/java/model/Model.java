package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
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
		String world[][] = null;
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
		this.setChanged();
		this.notifyObservers();
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int positionHeroY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isPenetrable(int X, int Y) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean spellOrNot() {
		// TODO Auto-generated method stub
		return false;
	}

	public int positionSpellX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int positionSpellY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	public void move_global(ControllerOrder direction) {
		// TODO Auto-generated method stub
		
	}

	public void animate() {
		// TODO Auto-generated method stub
		
	}
}
