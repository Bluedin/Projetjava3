package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
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
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_8:
				return ControllerOrder.UP;
				break;
			case KeyEvent.VK_2:
				return ControllerOrder.DOWN;
				break;
			case KeyEvent.VK_4:
				return ControllerOrder.LEFT;
				break;
			case KeyEvent.VK_6:
				return ControllerOrder.RIGHT;
				break;
			case KeyEvent.VK_7:
				return ControllerOrder.UPLEFT;
				break;
			case KeyEvent.VK_9:
				return ControllerOrder.UPRIGHT;
				break;
			case KeyEvent.VK_1:
				return ControllerOrder.DOWNLEFT;
				break;
			case KeyEvent.VK_3:
				return ControllerOrder.DOWNRIGHT;
				break;
				default:
					break;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printWorld(IModel model) {
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
}
