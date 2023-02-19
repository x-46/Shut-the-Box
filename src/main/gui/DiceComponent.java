package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class DiceComponent {

	private int num;
	private int x;
	private int y;

	private int offX;
	private int offY;
	private int r;

	public DiceComponent(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;

		offX = 0;
		offY = 0;
		r = 0;
	}

	public void draw(Graphics2D g2d) {
		g2d.translate(x + offX, y + offY);
		g2d.rotate(Math.toRadians(r));

		Color saveColor = g2d.getColor();

		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 160, 160);

		g2d.setColor(Color.BLACK);
		if (num == 1) {
			g2d.fillOval(60, 60, 40, 40);
		} else if (num == 2) {
			g2d.fillOval(60, 25, 40, 40);
			g2d.fillOval(60, 95, 40, 40);
		} else if (num == 3) {
			g2d.fillOval(20, 20, 40, 40);
			g2d.fillOval(60, 60, 40, 40);
			g2d.fillOval(100, 100, 40, 40);
		} else if (num == 4) {
			g2d.fillOval(20, 20, 40, 40);
			g2d.fillOval(100, 100, 40, 40);

			g2d.fillOval(20, 100, 40, 40);
			g2d.fillOval(100, 20, 40, 40);
		} else if (num == 5) {
			g2d.fillOval(20, 20, 40, 40);
			g2d.fillOval(100, 100, 40, 40);
			g2d.fillOval(60, 60, 40, 40);
			g2d.fillOval(20, 100, 40, 40);
			g2d.fillOval(100, 20, 40, 40);
		} else if (num == 6) {
			g2d.fillOval(15, 15, 40, 40);
			g2d.fillOval(15, 60, 40, 40);
			g2d.fillOval(105, 105, 40, 40);

			g2d.fillOval(15, 105, 40, 40);
			g2d.fillOval(105, 60, 40, 40);
			g2d.fillOval(105, 15, 40, 40);

		}

		g2d.rotate(Math.toRadians(-r));
		g2d.setColor(saveColor);
		g2d.translate(-(x + offX), -(y + offY));
	}


	public void setNum(int num) {
		this.num = num;
	}

	public void newPos() {
		offX = getRandomNumber(-80, 80);
		offY = getRandomNumber(-80, 80);
		r = getRandomNumber(0, 180);
	}

	private int getRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
