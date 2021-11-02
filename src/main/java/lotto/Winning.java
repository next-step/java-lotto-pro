package lotto;

import static lotto.common.Constants.*;

import java.util.HashMap;
import java.util.Map;

public class Winning {
	private Map<Integer, Integer> winningMap;

	public Winning() {
		this.winningMap = new HashMap<>();
	}

	public void addWinningMap(Integer key) {
		this.winningMap.put(key, this.winningMap.getOrDefault(key, 0)+1);
	}

	public String getYield(int investment) {
		Double total = getTotalAmount();
		return String.format("%.2f", total/investment);
	}

	private Double getTotalAmount() {
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : this.winningMap.entrySet()) {
			total = total + (WINNING_AMOUNT_MAP.get(entry.getKey()) * entry.getValue());
		}
		return Double.valueOf(total);
	}

}
