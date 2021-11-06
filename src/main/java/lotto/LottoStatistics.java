package lotto;

import java.util.List;

public class LottoStatistics {
	private static final double LOTTO_SALES_PRICE = 1000;
	private final WinningRecord winningRecord = new WinningRecord();
	private final Quantity totalLottoQuantity = new Quantity();

	public void record(MatchedNumber matchedNumber) {
		if (matchedNumber.isWinner()) {
			winningRecord.record(matchedNumber);
		}
		totalLottoQuantity.plus();
	}

	public List<WinningInformation> getWinningRecord() {
		return winningRecord.getWinningRecord();
	}

	public double getProfitRate() {
		double totalProfit = 0;
		double profitRate = 0;
		for (WinningInformation information : getWinningRecord()) {
			totalProfit += information.getWinningAmount() * information.getWinnerCount();
		}
		return totalProfit / (LOTTO_SALES_PRICE * getTotalLottoQuantity());
	}

	private int getTotalLottoQuantity() {
		return totalLottoQuantity.value();
	}
}
