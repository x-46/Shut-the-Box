package main;

public class Game {
	private ShutTheBox shutTheBox;
	private GameStrategy gameStrategy;
	private Dice dice;

	public Game(GameStrategy gameStrategy) {
		shutTheBox = new ShutTheBox();
		dice = new Dice();
		this.gameStrategy = gameStrategy;
	}

	public boolean run() {
		shutTheBox.rest();
		while (!shutTheBox.won()) {
			int[] dic = dice.roll(2);
			int[][] pos = shutTheBox.getPossible(dic[0], dic[1]);
			if (pos.length == 0) {
				if(gameStrategy instanceof PassiveGameStrategy)
					((PassiveGameStrategy) gameStrategy).runPassiv(shutTheBox, 0, 0);
				return false;
			}
			gameStrategy.round(shutTheBox, dic[0], dic[1]);
		}

		return true; // won
	}

}
