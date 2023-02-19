package main;

public abstract class PassiveGameStrategy implements GameStrategy {

	private boolean passive;
	private boolean runNonPassiveGameStrategy;
	private GameStrategy gameStrategy;

	public PassiveGameStrategy(GameStrategy gameStrategy) {
		this(gameStrategy, true);
	}

	public PassiveGameStrategy(GameStrategy gameStrategy, boolean runNonPassiveGameStrategy) {
		this.gameStrategy = gameStrategy;
		this.runNonPassiveGameStrategy = runNonPassiveGameStrategy;
		passive = false;
	}

	@Override
	public void round(ShutTheBox stb, int d1, int d2) {

		if (passive) {
			if (gameStrategy instanceof PassiveGameStrategy)
				((PassiveGameStrategy) gameStrategy).runPassiv(stb, d1, d2);
			passive = false;
		} else if (runNonPassiveGameStrategy) {
			gameStrategy.round(stb, d1, d2);
		}
		passiveRound(stb, d1, d2);
	}

	public void runPassiv(ShutTheBox stb, int d1, int d2) {
		passive = true;
		round(stb, d1, d2);
	}

	public abstract void passiveRound(ShutTheBox stb, int d1, int d2);

	protected boolean isPassive() {
		return passive;
	}

}
