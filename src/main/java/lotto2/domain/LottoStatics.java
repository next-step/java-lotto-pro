package lotto2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatics {

	public static RankCounts calculateRankCount(LottoTickets tickets, WinningLotto winningLotto) {
		Map<Rank, Integer> map = initRankCounts();
		for (LottoTicket lottoTicket : tickets) {
			Rank rank = winningLotto.getMatchRank(lottoTicket);
			map.put(rank, map.get(rank) + 1);
		}
		return RankCounts.of(map);
	}

	public static int calculateTotalPrize(RankCounts rankCounts) {
		return rankCounts.entrySet()
			.stream()
			.map((entry) ->
				entry.getKey().getPrize() * entry.getValue())
			.reduce(0, Integer::sum);
	}

	public static double calculateProfit(RankCounts rankCounts, Money money) {
		int totalPrizeMoney = calculateTotalPrize(rankCounts);
		return calculateProfit(totalPrizeMoney, money);
	}

	private static Map<Rank, Integer> initRankCounts() {
		Map<Rank, Integer> rankCounts = new HashMap<>();
		for (Rank rank : Rank.values()) {
			rankCounts.put(rank, 0);
		}
		return rankCounts;
	}

	private static double calculateProfit(int totalPrizeMoney, Money money) {
		double result = (double)totalPrizeMoney / money.toInt();
		return Math.floor(result * 100) / 100D;
	}

}
