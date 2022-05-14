package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	private String winOrLose() {
		if (revenueRate > 1) {
			return "기준이 1이기 때문에 결과적으로 이익이라는 의미임";
		}
		return "기준이 1이기 때문에 결과적으로 손해라는 의미임";
	}

	@Override
	public String toString() {
		String winningCounts = TARGET_WINNINGS.stream()
				.map(winning -> String.format("%s- %d개", winning, winnings.countOf(winning)))
				.collect(Collectors.joining("\n"));
		return String.format("%s\n총 수익률은 %.2f입니다.(%s)", winningCounts, revenueRate, winOrLose());
	}
}
