package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		
	}

	public void move_possible ()
	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		int posHeroX;
		int posHeroY;
		
		posHeroX = model.positionHeroX();
		posHeroY = model.positionHeroY();
		
		switch (controllerOrder) {
			case UP:
				posHeroY --;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_global(UP);
					}
					else {
					}
				break;
			case DOWN:
				posHeroY ++;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(DOWN);
						}
					else {
						
					}
				break;
			case LEFT:
				posHeroX --;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(LEFT);
						}
					else {
						
					}
				break;
			case RIGHT:
				posHeroX ++;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(RIGHT);
						}
					else {
						
					}
				break;
			case UPLEFT:
				posHeroX --;
				posHeroY --;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(UPLEFT);
						}
					else {
						
					}
				break;
			case UPRIGHT:
				posHeroX ++;
				posHeroY --;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(UPRIGHT);
						}
					else {
						
					}
				break;
			case DOWNLEFT:
				posHeroX --;
				posHeroY ++;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(DOWNLEFT);
						}
					else {
						
					}
				break;
			case DOWNRIGHT:
				posHeroX ++;
				posHeroY ++;
					if (model.isPenetrable(posHeroX, posHeroY)) {
						model.move_gobal(DOWNRIGHT);
						}
					else {
						
					}
				break;
				default:
				break;
		}
	}

}
