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

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	public void setKeyEvent(final KeyEvent e) {
		this.keyEvent = e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public synchronized void control() {

		model.loadWorld(1);
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
			

			try {
				Thread.sleep(500);
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
	 *            the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
		model.getObservable().addObserver(this);
	}

	private void spellTest() { // test si sort ou pas
		if (model.spellOrNot()) {
			model.shoot();
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
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
			System.out.println("You have won");
		}
	}

	public void update(Observable o, Object arg) {
		System.out.println("Le modèle a changé");
		this.view.printWorld(model);
	}

}
