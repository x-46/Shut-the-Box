package main.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.UUID;

import main.Dice;
import main.GameStrategy;
import main.PassiveGameStrategy;
import main.ShutTheBox;

public class CSVLogStrategy extends PassiveGameStrategy {

	private GameStrategy gameStrategy;
	private ArrayList<LogElement> logList;
	private String uuid;

	public CSVLogStrategy(GameStrategy gameStrategy) {
		super(gameStrategy, false);
		logList = new ArrayList<>();
		uuid = UUID.randomUUID().toString();
		this.gameStrategy = gameStrategy;
	}

	@Override
	public void passiveRound(ShutTheBox stb, int d1, int d2) {
		boolean[] tiles = stb.getTiles().clone();
		if (!isPassive())
			gameStrategy.round(stb, d1, d2);

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] != stb.getTiles()[i])
				res.add(i + 1);
		}

		logList.add(new LogElement(res, Dice.lastRolls[0], Dice.lastRolls[1]));

		if (stb.won()) {
			for (LogElement lg : logList) {
				try {
					File f = new File("log.txt");
					if (!f.exists())
						f.createNewFile();

					Files.write(f.toPath(), (lg.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			uuid = UUID.randomUUID().toString();
			logList.clear();
		} else if (res.size() == 0) {
			uuid = UUID.randomUUID().toString();
			logList.clear();
		}
	}

	private class LogElement {
		private ArrayList<Integer> tiles;
		private int dice1;
		private int dice2;

		public LogElement(ArrayList<Integer> tiles, int dice1, int dice2) {
			this.tiles = tiles;
			this.dice1 = dice1;
			this.dice2 = dice2;
		}

		@Override
		public String toString() {
			return uuid + ";" + dice1 + ";" + dice2 + ";" + tiles.toString().replace("[", "").replace("]", "");
		}

	}

}
