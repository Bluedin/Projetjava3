package view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	private Image image;
	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	} 

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		image = getToolkit().getImage("/sprite/lorann_b.png");
		image = getToolkit().getImage("/sprite/lorann_bl.png");
		image = getToolkit().getImage("/sprite/lorann_br.png");
		image = getToolkit().getImage("/sprite/lorann_l.png");
		image = getToolkit().getImage("/sprite/lorann_r.png");
		image = getToolkit().getImage("/sprite/lorann_u.png");
		image = getToolkit().getImage("/sprite/lorann_ul.png");
		image = getToolkit().getImage("/sprite/lorann_ur.png");
		image = getToolkit().getImage("/sprite/bone.png");
		image = getToolkit().getImage("/sprite/crystal_ball.png");
		image = getToolkit().getImage("/sprite/fireball_1.png");
		image = getToolkit().getImage("/sprite/fireball_2.png");
		image = getToolkit().getImage("/sprite/fireball_3.png");
		image = getToolkit().getImage("/sprite/fireball_4.png");
		image = getToolkit().getImage("/sprite/fireball_5.png");
		image = getToolkit().getImage("/sprite/gate_closed.png");
		image = getToolkit().getImage("/sprite/gate_open.png");
		image = getToolkit().getImage("/sprite/horizontal_bone.png");
		image = getToolkit().getImage("/sprite/monster_1.png");
		image = getToolkit().getImage("/sprite/monster_2.png");
		image = getToolkit().getImage("/sprite/monster_3.png");
		image = getToolkit().getImage("/sprite/monster_4.png");
		image = getToolkit().getImage("/sprite/purse.png");
		image = getToolkit().getImage("/sprite/vertical_bone.png");
	    graphics.drawImage(image, 32, 32, this);
	//	graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
	}
}
