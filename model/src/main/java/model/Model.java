package model;

import java.sql.SQLException;
import java.util.Observable;

import javax.swing.JOptionPane;

import contract.ControllerOrder;
import contract.IModel;

/**
 * The Class Model.
 *
 */
public class Model extends Observable implements IModel {

	/** 
	 * the world  
	 *  
	 */
	private World world;

	/**
	 * Instantiates a new model.
	 */
	public Model() {

	}

	/**
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
	 *            the new message
	 */
	private void setWorld(final World world) {
		this.world = world;
	}

	/** 
	 * load the level in accordance to the number of the level
	 * by creating a connection to the database
	 */
	public void loadWorld(int key) {
		try {
			final DAOWorld daoWorld = new DAOWorld(DBConnection.getInstance().getConnection());
			this.setWorld(daoWorld.find(key));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	/**
	 * show an frame to let the player choose the level
	 * @return int level
	 */
	public int levelBySelection() {
		int level = 0;
		String[] tabLvl = { "1", "2", "3", "4", "5" };
		JOptionPane jop = new JOptionPane();
		while(level == 0){
			level = JOptionPane.showOptionDialog(null, "Welcome! Which level do you want to try?", "Select your level",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, tabLvl, tabLvl[0])+1;
		}
		return level;
	}

	/**
	 * get the position X of the hero
	 * @see contract.IModel#positionHeroX()
	 */
	public int positionHeroX() {
		return this.world.positionHeroX();
	}

	/**
	 * get the position Y of the hero
	 * @see contract.IModel#positionHeroY()
	 */
	public int positionHeroY() {
		return this.world.positionHeroY();
	}

	/**
	 * check if the object at the coodinate is PENETRABLE or not
	 * @see contract.IModel#isPenetrable(int, int)
	 */
	public boolean isPenetrable(int X, int Y) {
		return this.world.isPenetrable(X, Y);
	}

	/**
	 * indicates if the hero has his spell
	 * @see contract.IModel#spellOrNot()
	 */
	public boolean spellOrNot() {
		return this.world.spellOrNot();
	}

	/** make the hero shoot
	 * @see contract.IModel#shoot()
	 */
	public void shoot() {
		this.world.shoot();
	}

	/** method to make the hero moves
	 * and notify the controller of the changes in model
	 * @see contract.IModel#move_global(contract.ControllerOrder)
	 */
	public boolean move_global(ControllerOrder direction) {
		boolean win = this.world.move_global(direction);
		this.setChanged();
		this.notifyObservers();
		return win;
	}

	/**
	 * make all the object in the world which can move move
	 * except for the hero
	 * @see contract.IModel#animate()
	 */
	public void animate() {
		this.world.animate();
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * check if the hero is alive
	 * @see contract.IModel#heroIsAlive()
	 */
	public boolean heroIsAlive() {
		return this.world.getHero().getLife();
	}
}
