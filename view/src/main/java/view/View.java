package view;

import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.zz
 *
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	public ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD8:
				return ControllerOrder.UP;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_NUMPAD6:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_NUMPAD7:
				return ControllerOrder.UPLEFT;
			case KeyEvent.VK_NUMPAD9:
				return ControllerOrder.UPRIGHT;
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.DOWNLEFT;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.DOWNRIGHT;
			case KeyEvent.VK_SPACE:
				return ControllerOrder.SHOOT;
				default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printWorld(final IModel model) {
		// On force l'executon dans le tread de l'IHM
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					printWorld(model);
				}
			});
			return;
		}
		viewFrame.printWorld(model);
		if (!viewFrame.isValid()) this.viewFrame.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	public void printWin() {
		this.viewFrame.printWin();
		
	}
}
