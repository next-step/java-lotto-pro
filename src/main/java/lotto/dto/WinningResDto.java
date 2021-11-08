package lotto.dto;

import java.util.Map;

public class WinningResDto {

	private Map<String, Integer> rankCounts;
	private double profit;

	public WinningResDto(Map<String, Integer> rankCounts, double profit) {
		this.rankCounts = rankCounts;
		this.profit = profit;
	}

	public Map<String, Integer> getRankCounts() {
		return rankCounts;
	}

	public double getProfit() {
		return profit;
	}

}
