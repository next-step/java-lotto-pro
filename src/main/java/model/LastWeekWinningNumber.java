package model;

public class LastWeekWinningNumber {
	private Lotto lotto;
	private BonusBall bonusBall;

	private LastWeekWinningNumber(Lotto lotto) {
		this.lotto = lotto;
	}

	public static boolean validate(String value) {
		return Lotto.validate(value);
	}

	public static LastWeekWinningNumber of(String lastWeekWinningNumber) {
		return new LastWeekWinningNumber(Lotto.of(lastWeekWinningNumber));
	}

	public void updateBonusBall(BonusBall bonusBall) {
		this.bonusBall = bonusBall;
	}

	public boolean isNotContain(String bonusBall) {
		return lotto.isNotContain(BonusBall.from(bonusBall));
	}

	public Lotto getLotto() {
		return lotto;
	}

	public BonusBall getBonusBall() {
		return bonusBall;
	}
}
