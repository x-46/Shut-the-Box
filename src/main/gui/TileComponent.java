package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class TileComponent {

	private int num;
	private int x;
	private int y;
	private boolean oldUp;
	private boolean up;

	public TileComponent(int num, int x, int y, boolean up) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.up = up;
		this.oldUp = !up;
	}

	public void draw(Graphics2D g2d) {
		g2d.translate(x, y);

		Color saveColor = g2d.getColor();

		if (up) {
			g2d.setColor(new Color(0xAD800C));
			g2d.fillRect(0, 0, 125, 200);

			g2d.setFont(new Font("Symbol", Font.PLAIN, 70));
			g2d.setColor(Color.black);
			g2d.drawString(num + "", 10, 70);
		} else {
			g2d.setColor(new Color(0xAD800C));
			g2d.fillRect(0, 100, 125, 200);
			g2d.rotate(Math.toRadians(180), 10, 70);
			g2d.setFont(new Font("Symbol", Font.PLAIN, 70));
			g2d.setColor(oldUp == up ? Color.black : Color.white);
			g2d.drawString(num + "", -70, -90);
			g2d.rotate(Math.toRadians(-180), 10, 70);
		}

		g2d.setColor(saveColor);
		g2d.translate(-x, -y);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		oldUp = this.up;
		this.up = up;
	}
	
	

}
