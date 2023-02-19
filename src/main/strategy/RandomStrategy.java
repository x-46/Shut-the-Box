package main.strategy;

import java.util.Random;

import main.GameStrategy;
import main.ShutTheBox;

public class RandomStrategy implements GameStrategy {

	@Override
	public void round(ShutTheBox stb, int d1, int d2) {
		int[][] pos = stb.getPossible(d1, d2);
		Random r = new Random();
		int index = r.nextInt(pos.length);
	
		for (int i = 0; i < pos[index].length; i++) {
			stb.flipTile(pos[index][i]);
		}
	}

}
