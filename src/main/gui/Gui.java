package main.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Gui extends JFrame {

	private FramePainter framePainter;

	public Gui() {
		framePainter = new FramePainter();
		setupGui();
	}

	private void setupGui() {
		setTitle("Shut the Box");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(framePainter, BorderLayout.CENTER);

		setVisible(true);
	}

	public void updateTile(int tileNum, boolean up) {
		framePainter.updateTile(tileNum, up);
		repaint();
	}

	public void updateDice(int dice, int num) {
		framePainter.updateDice(dice, num);
	}

}
