package lotto2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatics {

	private final Map<String, Integer> rankCounts;
	private final double profit;

	private LottoStatics(Map<String, Integer> rankCounts, double profit) {
		this.rankCounts = rankCounts;
		this.profit = profit;
	}

	public static LottoStatics of(LottoTickets lottoTickets, WinningLotto winningLotto, Money purchaseMoney) {
		Map<String, Integer> rankCounts = calculateRankCount(lottoTickets, winningLotto);
		double profit = calculateProfit(calculateTotalPrize(rankCounts), purchaseMoney);
		return new LottoStatics(rankCounts, profit);
	}

	private static Map<String, Integer> calculateRankCount(LottoTickets tickets, WinningLotto winningLotto) {
		Map<String, Integer> map = initRankCounts();
		for (LottoTicket lottoTicket : tickets) {
			Rank rank = winningLotto.getMatchRank(lottoTicket);
			String rankName = rank.name();
			map.put(rankName, map.get(rankName) + 1);
		}
		return map;
	}

	private static Map<String, Integer> initRankCounts() {
		Map<String, Integer> rankCounts = new HashMap<>();
		for (Rank rank : Rank.values()) {
			rankCounts.put(rank.name(), 0);
		}
		return rankCounts;
	}

	private static int calculateTotalPrize(Map<String, Integer> rankCounts) {
		return rankCounts.entrySet()
			.stream()
			.map((entry) ->
				Rank.valueOf(entry.getKey()).getPrize() * entry.getValue())
			.reduce(0, Integer::sum);
	}

	private static double calculateProfit(int totalPrizeMoney, Money money) {
		double result = (double)totalPrizeMoney / money.toInt();
		return Math.floor(result * 100) / 100D;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoStatics that = (LottoStatics)o;

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

	public int getCount(String rankName) {
		return this.rankCounts.get(rankName);
	}

	public Map<String, Integer> getRankCount() {
		return this.rankCounts;
	}
}
