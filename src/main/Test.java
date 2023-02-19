package main;

import java.util.stream.IntStream;

import main.strategy.CSVLogStrategy;
import main.strategy.GuiStrategy;
import main.strategy.LogStrategy;
import main.strategy.RandomStrategy;

public class Test {

	public static void main(String[] args) {
		
		GameStrategy gs = new GuiStrategy(new LogStrategy(new RandomStrategy()), 5000);
		Game g = new Game(gs);
		System.out.println(g.run());
/*
		IntStream.range(0, 10).parallel().forEach(num -> {
			for (int i = 0;; i++) {
				GameStrategy gs = new CSVLogStrategy(new RandomStrategy());
				Game g = new Game(gs);
				if (g.run())
					System.out.println(num);
			}
		});*/

	}

}
