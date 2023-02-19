package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShutTheBox {

	private boolean[] tiles;

	public ShutTheBox() {
		tiles = new boolean[9];
		Arrays.fill(tiles, true);
	}

	public void flipTile(int x) {
		if (x > tiles.length || x <= 0)
			throw new IllegalArgumentException();

		if (!tiles[x - 1])
			throw new RuntimeException();

		tiles[x - 1] = false;
	}

	public boolean won() {
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i])
				return false;
		}

		return true;
	}

	public boolean areTherePossibilities(int d1, int d2) {
		return getPossible(d1, d2).length != 0;
	}

	public int[][] getPossible(int d1, int d2) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		getPossibleRecursive(d1 + d2, new ArrayList<Integer>(), result);
		return result.stream().distinct().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
	}

	@SuppressWarnings("unchecked")
	private void getPossibleRecursive(int num, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result) {
		int sum = sumArrayList(arr);
		if (sum == num) {
			result.add(arr);
			return;
		}

		if (sum > num) {
			return;
		}

		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] && !arr.contains(i + 1)) {
				ArrayList<Integer> tmp = (ArrayList<Integer>) arr.clone();
				tmp.add(i + 1);
				Collections.sort(tmp);
				getPossibleRecursive(num, tmp, result);
			}

		}
	}

	public void rest() {
		Arrays.fill(tiles, true);
	}

	private int sumArrayList(ArrayList<Integer> arr) {
		return arr.stream().mapToInt(i -> i).sum();
	}

	public boolean[] getTiles() {
		return tiles;
	}

}
