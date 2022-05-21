package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.dto.PrizeReport;

public class RankResult {
	private final long ZERO = 0;
	private Map<Rank, Long> resultMap;

	public RankResult(Map<Rank, Long> countingResult) {
		resultMap = new HashMap<>(countingResult);
	}

	public List<PrizeReport> getReport() {
		List<PrizeReport> prizes = new ArrayList<>();

		prizes.add(new PrizeReport(Rank.FIFTH, resultMap.getOrDefault(Rank.FIFTH, ZERO), false));
		prizes.add(new PrizeReport(Rank.FOURTH, resultMap.getOrDefault(Rank.FOURTH, ZERO), false));
		prizes.add(new PrizeReport(Rank.THIRD, resultMap.getOrDefault(Rank.THIRD, ZERO), false));
		prizes.add(new PrizeReport(Rank.SECOND, resultMap.getOrDefault(Rank.SECOND, ZERO), true));
		prizes.add(new PrizeReport(Rank.FIRST, resultMap.getOrDefault(Rank.FIRST, ZERO), false));

		Collections.sort(prizes);
		return prizes;
	}

	public double compileStatistics(int cost) {
		int divisionNumber = cost > 0 ? cost : 1;

		long totalPrize = resultMap.entrySet().stream()
			.mapToLong(groupingRank -> groupingRank.getValue() * groupingRank.getKey().getPrizeMoney())
			.sum();

		double rate = totalPrize / (double)divisionNumber;

		double DECIMAL = 100.0;
		return Math.floor(rate * DECIMAL) / DECIMAL;
	}
}
