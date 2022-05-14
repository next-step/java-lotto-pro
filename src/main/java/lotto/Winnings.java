package lotto;

public enum Winnings {
	MATCH6(2000000000),
	MATCH5(1500000),
	MATCH4(50000),
	MATCH3(5000),
	NAN(0);

	private final int money;

	Winnings(int money) {
		this.money = money;
	}

	public static Winnings from(int match) {
		if (match == 6) {
			return Winnings.MATCH6;
		}
		if (match == 5) {
			return Winnings.MATCH5;
		}
		if (match == 4) {
			return Winnings.MATCH4;
		}
		if (match == 3) {
			return Winnings.MATCH3;
		}
		return Winnings.NAN;
	}

	public int getMoney() {
		return money;
	}
}
