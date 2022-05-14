package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningList {
	private Map<WinningMoney, Integer> winningList;
	private long sum;

	public WinningList() {
		winningList = new LinkedHashMap<>();
		initWinningList();
	}

	public Map<WinningMoney, Integer> getWinningList() {
		return this.winningList;
	}

	private void initWinningList() {
		for (WinningMoney winningMoney : WinningMoney.values()) {
			winningList.put(winningMoney, 0);
		}
	}

	public void increase(WinningMoney winningMoney) {
		winningList.put(winningMoney, winningList.get(winningMoney) + 1);
	}

	public double profitRate(UserMoney userMoney) {
		return (double) totalWinningMoney() / userMoney.useMoney();
	}
	
	private long totalWinningMoney() {
		sum = 0;
		winningList.forEach((winningMoney, count) -> {
			sum += winningMoney.winningMoney(count);
		});
		return sum;
	}
}
