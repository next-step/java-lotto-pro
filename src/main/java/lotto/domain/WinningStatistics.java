package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
	private final Lottos lottos;
	private final Money money;
	private final List<WinningRecord> winningRecords;

	private WinningStatistics(Lottos lottos, Money money) {
		this.lottos = lottos;
		this.money = money;
		this.winningRecords = new ArrayList<>();
	}

	public static WinningStatistics createBy(Lottos lottos, Money money) {
		return new WinningStatistics(lottos, money);
	}

	public void buildStatistics() {
		List<Lotto> winningLottos = extractWinningLottos(this.lottos);

		for (WinningRank winningRank : WinningRank.getPlaceRanks()) {
			int count = countNumberOfWinningRank(winningLottos, winningRank);
			this.winningRecords.add(WinningRecord.of(winningRank, count));
		}
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

	private int countNumberOfWinningRank(List<Lotto> winningLottos, WinningRank winningRank) {
		return (int)winningLottos.stream()
								 .map(Lotto::getWinningNumbers)
								 .filter(numbers -> numbers.getSize() == winningRank.getWinningNumberCount())
								 .count();
	}

	private List<Lotto> extractWinningLottos(Lottos lottos) {
		return lottos.getValues()
					 .stream()
					 .filter(Lotto::isWinning)
					 .collect(toList());
	}
}
