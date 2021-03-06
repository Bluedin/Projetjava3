package controller;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	private KeyEvent keyEvent;
	
	private int level = 1;

	/**
	 * Instantiates a new controller.
	 * Constructor of controller.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public Controller(final IView view, final IModel model, int level) {
		this.setView(view);
		this.setModel(model);
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see contract.IController#setKeyEvent(java.awt.event.KeyEvent)
	 * 
	 */
	public void setKeyEvent(final KeyEvent e) {
		this.keyEvent = e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 * Loading world
	 * If there is a key event, associate this key event with a controllerOrder state, 
	 * then animate (all the elements wiches are not the hero)
	 * Verify if the hero is dead or not, then if he is, re-load the world
	 * Add a timer for the refresh every 0.25 secs
	 */
	public synchronized void control() {

		model.loadWorld(this.level);
		while (true) {

			
			//System.out.println(this.keyEvent);
			if (this.keyEvent != null) {
				this.orderPerform(this.view.keyCodeToControllerOrder(keyEvent.getKeyCode()));
			}
			model.animate();
			/*SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					view.printWorld(model);
				}
			});*/
			if(!this.model.heroIsAlive()){
				this.model.loadWorld(level);
			}

			try {
				Thread.sleep(250);
			}

			catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				return ;
			}

		}
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 * The new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 * The new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
		model.getObservable().addObserver(this);
	}

	/**
	 * Look with the help of the model method spellOrNot if the spell is available or not. 
	 */
	private void spellTest() { 
		if (model.spellOrNot()) {
			model.shoot();
		}

	}

	
	/* (non-Javadoc)
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 * orderPerform associate a controllerOrder state with a changement of a position, incrementation or decrementation. 
	 * win is a boolean wich  determine if yes or not the move is the winning move. 
	 * We also have in this method a method called spellTest who look if the spell have already been shoot, if not, it shoot!
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		int posHeroX;
		int posHeroY;
		boolean win = false;
		
		posHeroX = model.positionHeroX();
		posHeroY = model.positionHeroY();
		if (controllerOrder != null) {
			switch (controllerOrder) {
			case UP:
				posHeroY--;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.UP);
				} else {
				}
				break;
			case DOWN:
				posHeroY++;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.DOWN);
				} else {

				}
				break;
			case LEFT:
				posHeroX--;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.LEFT);
				} else {

				}
				break;
			case RIGHT:
				posHeroX++;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.RIGHT);
				} else {

				}
				break;
			case UPLEFT:
				posHeroX--;
				posHeroY--;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.UPLEFT);
				} else {

				}
				break;
			case UPRIGHT:
				posHeroX++;
				posHeroY--;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.UPRIGHT);
				} else {

				}
				break;
			case DOWNLEFT:
				posHeroX--;
				posHeroY++;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.DOWNLEFT);
				} else {

				}
				break;
			case DOWNRIGHT:
				posHeroX++;
				posHeroY++;
				if (model.isPenetrable(posHeroX, posHeroY)) {
					win = model.move_global(ControllerOrder.DOWNRIGHT);
				} else {

				}
				break;
			case SHOOT:
				spellTest();
				break;

			default:

				break;

			}
		}
		this.view.printWorld(model);

		if (win) {
			level ++;
			if(level > 5){
				this.view.printWin();
			}else{
				this.model.loadWorld(level);
			}
		}
	}

	/**
	 * @param o
	 * @param arg
	 * If model change, re-print
	 */
	public void update(Observable o, Object arg) {
		this.view.printWorld(model);
	}

}