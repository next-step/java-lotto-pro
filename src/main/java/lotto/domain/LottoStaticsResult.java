package lotto.domain;

public class LottoStaticsResult {

	private final RankCounts rankCounts;
	private final double profit;

	private LottoStaticsResult(RankCounts rankCounts, double profit) {
		this.rankCounts = rankCounts;
		this.profit = profit;
	}

	public static LottoStaticsResult of(RankCounts rankCounts, double profit) {
		return new LottoStaticsResult(rankCounts, profit);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoStaticsResult that = (LottoStaticsResult)o;

		if (Double.compare(that.profit, profit) != 0)
			return false;
		return rankCounts.equals(that.rankCounts);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = rankCounts.hashCode();
		temp = Double.doubleToLongBits(profit);
		result = 31 * result + (int)(temp ^ (temp >>> 32));
		return result;
	}

	public double getProfit() {
		return this.profit;
	}

	public RankCounts getRankCount() {
		return this.rankCounts;
	}
}
