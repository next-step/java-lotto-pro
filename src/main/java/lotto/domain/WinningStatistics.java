package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
	private final Lottos lottos;
	private final LottoNumbers lastWinningNumbers;
	private final Money money;
	private final List<WinningRecord> winningRecords;

	private WinningStatistics(Lottos lottos, LottoNumbers lastWinningNumbers, Money money) {
		this.lottos = lottos;
		this.lastWinningNumbers = lastWinningNumbers;
		this.money = money;
		this.winningRecords = new ArrayList<>();
	}

	public static WinningStatistics createBy(Lottos lottos, LottoNumbers lastWinningNumbers, Money money) {
		return new WinningStatistics(lottos, lastWinningNumbers, money);
	}

	public void buildStatistics() {
		for (WinningRank winningRank : WinningRank.getPlaceRanks()) {
			int count = countNumberOfWinningRank(winningRank);
			this.winningRecords.add(WinningRecord.of(winningRank, count));
		}
	}

	private int countNumberOfWinningRank(WinningRank winningRank) {
		return (int) this.lottos.getValues()
								.stream()
								.filter(lotto -> winningRank.isWinning(lotto.countWinningNumbers(lastWinningNumbers)))
								.count();
	}

	public double getRoundedTotalProfitRate() {
		double totalProfitRate = calculateTotalProfitRate();
		return Math.round(totalProfitRate * 100) / 100.0;
	}

	private double calculateTotalProfitRate() {
		double totalPrizeMoney = (double) calculateTotalPrizeMoney();
		double spentMoney = this.money.getValue();

		return totalPrizeMoney / spentMoney;
	}

	private long calculateTotalPrizeMoney() {
		long totalProfile = 0L;
		for (WinningRecord winningRecord : this.winningRecords) {
			totalProfile += winningRecord.getTotalPrizeMoney();
		}

		return totalProfile;
	}

	public List<WinningRecord> getWinningRecords() {
		return winningRecords;
	}
}
