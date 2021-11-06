package lotto;

import java.util.List;

public class LottoStatistics {
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
		for (WinningInformation information : getWinningRecord()) {
			totalProfit += information.getWinningAmount() * information.getWinnerCount();
		}
		return totalProfit / (CommonConstant.LOTTO_SALES_PRICE * getTotalLottoQuantity());
	}

	private int getTotalLottoQuantity() {
		return totalLottoQuantity.value();
	}
}
