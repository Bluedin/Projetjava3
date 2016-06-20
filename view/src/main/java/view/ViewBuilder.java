package view;
// this class is for put the picture on the screen

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ViewBuilder {

	String world[][] = new String[20][12];
	ViewPanel viewpanel;
	
	public ViewBuilder(ViewPanel v){
		this.viewpanel = v;
	}

	public void get_elements(String[][] world) {
		this.world = world;
		this.viewpanel.repaint();
	}

	public void createImage(Graphics graphics) throws IOException {
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 20; x++) {
				Image image = ImageIO.read(this.getClass().getResourceAsStream(world[x][y]));
				graphics.drawImage(image, x * 32 , y * 32, null);
			}
		}
	}
	
	

}
