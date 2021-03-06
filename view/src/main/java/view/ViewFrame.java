package view;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;


/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	
	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	private ViewPanel viewPanel;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame. this is he constructor
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
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

	/**
	 * Builds the view frame.
	 * with all caracteristiques
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.viewPanel = new ViewPanel(this);
		this.setContentPane(this.viewPanel);
		this.setSize(720,480);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
	}
	
	/**
	 * this method print the win message
	 */
	public void printWin(){
		JOptionPane.showMessageDialog(null, "You have won");
	}

	/**
	 * Prints the message.
	 * this method get elements to build the frame 
	 * @param message
	 *          the message
	 */
	public void printWorld(IModel model) {

		this.viewPanel.getViewBuilder().get_elements(model.getWorld());
	}

	/**
	 *this is the method who get information of KeyEvent and make action when the key is just 
	 *typed 
	 *	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/**
	 *this is the method who get information of KeyEvent and make action when the key is 
	 * pressed whe used this for our move
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().setKeyEvent(e);
		//this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/**
	 *this is the method who get information of KeyEvent and make action when the key is
	 * released and make the action
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		this.getController().setKeyEvent(null);
	}
	
}
