package main.strategy;

import java.util.ArrayList;

import main.Dice;
import main.GameStrategy;
import main.PassiveGameStrategy;
import main.ShutTheBox;

public class LogStrategy extends PassiveGameStrategy {

	private GameStrategy carriedGameStrategy;

	public LogStrategy(GameStrategy carriedGameStrategy) {
		super(carriedGameStrategy, false);
		this.carriedGameStrategy = carriedGameStrategy;
	}

	@Override
	public void passiveRound(ShutTheBox stb, int d1, int d2) {
		boolean[] tiles = stb.getTiles().clone();
		if (!isPassive())
			carriedGameStrategy.round(stb, d1, d2);

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] != stb.getTiles()[i])
				res.add(i + 1);
		}

		System.out.println("---");

		System.out.println("Dice 1: " + Dice.lastRolls[0]);
		System.out.println("Dice 2: " + Dice.lastRolls[1]);

		System.out.println(res.toString());

	}

}
