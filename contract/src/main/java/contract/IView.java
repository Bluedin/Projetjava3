package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printWorld(IModel model);
	public void printWin();
	public ControllerOrder keyCodeToControllerOrder(final int keyCode);
}
