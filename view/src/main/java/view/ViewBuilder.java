package view;
// this class is for put the picture on the screen

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ViewBuilder {

	String world[][] = new String[20][12];
	ViewPanel viewpanel;
	
	private HashMap<String, Image> map = new HashMap<String, Image>();

	public ViewBuilder(ViewPanel v) {
		this.viewpanel = v;
	}

	public void get_elements(String[][] world) {
		this.world = world;
		this.viewpanel.repaint();
	}

	public void createImage(Graphics graphics) throws IOException {
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 20; x++) {
				String chr = world[x][y];
				// S'il n'y a rien au sol, on ne fait rien
				if (chr == null) continue;
				// Si on a besoin de créer l'image
				if (!map.containsKey(chr)) {
					Image image = ImageIO.read(this.getClass().getResourceAsStream(chr));
					if (image != null)
						map.put(chr, image);
				}
				Image image = map.get(chr);
				graphics.drawImage(image, x * 32, y * 32, null);
			}
		}
	}

}
