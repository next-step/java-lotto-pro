package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankCounts {

	private final Map<Rank, Integer> rankAndCount;

	private RankCounts(Map<Rank, Integer> rankAndCount) {
		this.rankAndCount = new HashMap<>(rankAndCount);
	}

	public static RankCounts of(Map<Rank, Integer> rankAndCount) {
		return new RankCounts(rankAndCount);
	}

	public int get(String rankName) {
		Rank rank = Rank.valueOf(rankName);
		if (this.rankAndCount.containsKey(rank)) {
			return this.rankAndCount.get(rank);
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RankCounts that = (RankCounts)o;

		return rankAndCount.equals(that.rankAndCount);
	}

	@Override
	public int hashCode() {
		return rankAndCount.hashCode();
	}

	public double calculateProfitRate(Money purchaseMoney) {
		int totalPrizeMoney = calculateTotalPrize();
		double result = (double)totalPrizeMoney / purchaseMoney.toInt();
		return Math.floor(result * 100) / 100D;
	}

	private int calculateTotalPrize() {
		return rankAndCount.entrySet()
			.stream()
			.map((entry) ->
				entry.getKey().getPrize() * entry.getValue())
			.reduce(0, Integer::sum);
	}

}
