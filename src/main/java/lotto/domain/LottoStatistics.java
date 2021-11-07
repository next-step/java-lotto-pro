package lotto.domain;

public class LottoStatistics {
	private static final int LOTTO_PRICE = 1000;
	private final Quantity totalLottoQuantity = new Quantity();
	private final Winners winners = new Winners();

	public void record(int matchedNumber) {
		winners.record(matchedNumber);
		totalLottoQuantity.plus();
	}

	public int countWinners(int matchedNumber) {
		return winners.count(matchedNumber);
	}

	public double getProfitRate() {
		double totalProfit = 0;
		for (Rank rank : Rank.values()) {
			totalProfit += rank.getWinningAmount() * countWinners(rank.getMatchedNumber());
		}
		return totalProfit / (LOTTO_PRICE * getTotalLottoQuantity());
	}

	private int getTotalLottoQuantity() {
		return totalLottoQuantity.value();
	}
}
