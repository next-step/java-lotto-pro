package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.dto.PrizeReport;

public class RankResult {
	private final int ZERO = 0;
	private Map<Rank, Integer> resultMap;

	public RankResult() {
		resultMap = new HashMap<Rank, Integer>() {
			{
				put(Rank.FIRST, ZERO);
				put(Rank.SECOND, ZERO);
				put(Rank.THIRD, ZERO);
				put(Rank.FOURTH, ZERO);
				put(Rank.FIFTH, ZERO);
				put(Rank.NONE, ZERO);
			}
		};
	}

	public void setUp(Rank rank) {
		resultMap.put(rank, resultMap.get(rank) + 1);
	}

	public List<PrizeReport> getReport() {
		List<PrizeReport> prizes = new ArrayList<>();

		prizes.add(new PrizeReport(Rank.FIFTH, resultMap.get(Rank.FIFTH), false));
		prizes.add(new PrizeReport(Rank.FOURTH, resultMap.get(Rank.FOURTH), false));
		prizes.add(new PrizeReport(Rank.THIRD, resultMap.get(Rank.THIRD), false));
		prizes.add(new PrizeReport(Rank.SECOND, resultMap.get(Rank.SECOND), true));
		prizes.add(new PrizeReport(Rank.FIRST, resultMap.get(Rank.FIRST), false));

		Collections.sort(prizes);
		return prizes;
	}

	public double compileStatistics(int cost) {
		int divisionNumber = cost > 0 ? cost : 1;
		int totalPrize = resultMap.get(Rank.FIRST) * Rank.FIRST.getPrizeMoney()
			+ resultMap.get(Rank.SECOND) * Rank.SECOND.getPrizeMoney()
			+ resultMap.get(Rank.THIRD) * Rank.THIRD.getPrizeMoney()
			+ resultMap.get(Rank.FOURTH) * Rank.FOURTH.getPrizeMoney()
			+ resultMap.get(Rank.FIFTH) * Rank.FIFTH.getPrizeMoney();

		double rate = totalPrize / (double)divisionNumber;

		double DECIMAL = 100.0;
		return Math.floor(rate * DECIMAL) / DECIMAL;
	}
}
