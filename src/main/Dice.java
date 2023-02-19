package main;

import java.util.Random;

public class Dice {

	private Random rand;
	public static int[] lastRolls = new int[5];

	public Dice() {
		rand = new Random();
	}

	public int roll() {
		int r = rand.nextInt(5) + 1;
		System.arraycopy(lastRolls, 0, lastRolls, 1, 4);
		lastRolls[0] = r;
		return r;
	}

	public int[] roll(int x) {
		int[] res = new int[x];
		for (int i = 0; i < x; i++)
			res[i] = roll();

		return res;
	}

}
