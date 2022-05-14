package lotto;

import java.util.Arrays;
import java.util.List;

public class Statistics {
	private final Winnings winnings;
	private final double revenueRate;
	private static final List<Winning> TARGET_WINNINGS = Arrays.asList(Winning.MATCH3, Winning.MATCH4, Winning.MATCH5, Winning.MATCH6);

	private Statistics(LottoCharge charge, Winnings winnings) {
		this.winnings = winnings;
		this.revenueRate = charge.revenueRate(winnings.totalMoney());
	}

	public static Statistics of(LottoCharge charge, Winnings winnings) {
		return new Statistics(charge, winnings);
	}

	public double revenueRate() {
		return revenueRate;
	}
}
