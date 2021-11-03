package lotto;

import static lotto.common.Constants.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Winning {
	private Map<Integer, Integer> winningMap;

	public Winning() {
		this.winningMap = new HashMap<>();
	}

	public void addWinningMap(Integer key) {
		if (!validateKey(key)) {
			return;
		}
		this.winningMap.put(key, this.winningMap.getOrDefault(key, 0)+1);
	}

	private boolean validateKey(Integer key) {
		Set<Integer> keySet = WINNING_AMOUNT_MAP.keySet();
		return keySet.contains(key);
	}

	public String getYield(int investment) {
		Double total = getTotalAmount();
		return String.format("%.2f", total/investment);
	}

	public Integer getStrikeResult(Integer key) {
		return this.winningMap.getOrDefault(key, 0);
	}

	private Double getTotalAmount() {
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : this.winningMap.entrySet()) {
			total = total + (WINNING_AMOUNT_MAP.get(entry.getKey()) * entry.getValue());
		}
		return Double.valueOf(total);
	}

}
