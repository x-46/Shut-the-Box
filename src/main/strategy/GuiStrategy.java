package main.strategy;

import main.Dice;
import main.GameStrategy;
import main.PassiveGameStrategy;
import main.ShutTheBox;
import main.gui.Gui;

public class GuiStrategy extends PassiveGameStrategy {

	private Gui g;
	private int delay;

	public GuiStrategy(GameStrategy carriedGameStrategy) {
		this(carriedGameStrategy, 1000);
	}

	public GuiStrategy(GameStrategy carriedGameStrategy, int delay) {
		super(carriedGameStrategy);
		this.g = new Gui();
		this.delay = delay;
	}

	@Override
	public void passiveRound(ShutTheBox stb, int d1, int d2) {
		for (int i = 0; i < stb.getTiles().length; i++) {
			g.updateTile(i + 1, stb.getTiles()[i]);
		}

		g.updateDice(1, Dice.lastRolls[0]);
		g.updateDice(2, Dice.lastRolls[1]);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void restGui() {
		g.updateDice(1, 1);
		g.updateDice(2, 1);
		for (int i = 0; i < 9; i++) {
			g.updateTile(i + 1, true);
		}

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
