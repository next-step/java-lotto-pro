package step3.winner;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOUR(4, 50_000, false),
	FIFTH(3, 5_000, false),
	MISS(0, 0, false);

	private final int matchNumber;
	private final int amount;
	private final boolean bonus;

	Rank(int matchNumber, int winningAmount, boolean bonus) {
		this.matchNumber = matchNumber;
		this.amount = winningAmount;
		this.bonus = bonus;
	}

	public static Rank valueOf(int lottoNumbers) {
		return Arrays.stream(values())
			.filter(s -> s.matchNumber == lottoNumbers)
			.findAny()
			.orElse(MISS);
	}

	public int getMatch() {
		return matchNumber;
	}

	public int getAmount() {
		return amount;
	}
}
