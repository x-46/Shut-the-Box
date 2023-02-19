package main.strategy;

import main.GameStrategy;
import main.ShutTheBox;

public class StrategyLast implements GameStrategy{

	@Override
	public void round(ShutTheBox stb, int d1, int d2) {
		int[][] pos = stb.getPossible(d1, d2);
		
		if(pos.length == 0)
			return;
		
		for(int i = 0; i < pos[pos.length-1].length; i++) {
			stb.flipTile(pos[pos.length-1][i]);
		}
	}

}
