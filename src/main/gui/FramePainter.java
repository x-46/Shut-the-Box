package main.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FramePainter extends JPanel {

	private ArrayList<TileComponent> tileList;
	private DiceComponent dice1;
	private DiceComponent dice2;

	public FramePainter() {
		tileList = new ArrayList<>();
		dice1 = new DiceComponent(1, 467, 533);
		dice2 = new DiceComponent(1, 1140, 655);
		for (int i = 0; i < 9; i++) {
			tileList.add(new TileComponent(1 + i, 83 + (202 * i), 16, true));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		int width = getWidth();
		int height = getHeight();

		double sw = width / 1920.0;
		double sh = height / 1080.0;

		double f = sw;
		if (sw > sh) {
			f = sh;
		}

		int widthImg = (int) (1920 * f);
		int heightImg = (int) (1080 * f);

		g2d.translate(width / 2 - widthImg / 2, height / 2 - heightImg / 2);
		g2d.scale(f, f);

		g2d.setColor(new Color(0x433000)); // braun
		g2d.fillRect(0, 93, 1920, 987);

		g2d.setColor(new Color(0x169D00)); // green
		g2d.fillRect(60, 213, 1800, 815);

		g2d.setColor(new Color(0x856800)); // braun
		g2d.fillRect(30, 157, 1860, 39);

		for (TileComponent t : tileList)
			t.draw(g2d);

		dice1.draw(g2d);
		dice2.draw(g2d);
	}

	public void updateTile(int tileNum, boolean up) {
		tileList.get(tileNum - 1).setUp(up);

		repaint();
	}

	public void updateDice(int dice, int num) {
		if (dice == 1) {
			dice1.newPos();
			dice1.setNum(num);
		} else if (dice == 2) {
			dice2.newPos();
			dice2.setNum(num);
		}

		repaint();
	}

}
