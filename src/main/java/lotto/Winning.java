package lotto;

import java.util.HashMap;
import java.util.Map;

public class Winning {
	private Map<Rank, Integer> winningMap;

	public Winning() {
		this.winningMap = new HashMap<>();
	}

	public void addWinningMap(Integer countOfMatch, boolean matchBonus) {
		if (!Rank.contains(countOfMatch)) {
			return;
		}
		Rank key = Rank.valueOf(countOfMatch, matchBonus);
		this.winningMap.put(key, this.winningMap.getOrDefault(key, 0) + 1);
	}

	public String getYield(int investment) {
		Double total = getTotalAmount();
		return String.format("%.2f", total / investment);
	}

	public Integer getStrikeResult(Rank key) {
		return this.winningMap.getOrDefault(key, 0);
	}

	private Double getTotalAmount() {
		int total = 0;
		for (Map.Entry<Rank, Integer> entry : this.winningMap.entrySet()) {
			total = total + (entry.getKey().getWinningMoney() * entry.getValue());
		}
		return Double.valueOf(total);
	}
}
