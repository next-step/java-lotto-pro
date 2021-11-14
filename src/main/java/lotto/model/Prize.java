package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lotto.constants.Rank;

public class Prize {
	private final Map<Rank, Integer> winCount;

	private Prize(Map<Rank, Integer> winCount) {
		this.winCount = winCount;
	}

	public static Prize withRankList(List<Rank> ranks) {
		Map<Rank, Integer> winCount = new HashMap<>();
		for (Rank rank : ranks) {
			winCount.put(rank, winCount.getOrDefault(rank, 0) + 1);
		}
		return new Prize(winCount);
	}

	public double rateReturn(PurchaseMoney money) {
		return money.divided(winMoney());
	}

	public int winMoney() {
		return winCount.entrySet().stream().reduce(0, (acc, entry) -> {
			Rank rank = entry.getKey();
			int count = entry.getValue();
			acc += rank.calculateWinningMoney(count);
			return acc;
		}, Integer::sum);
	}

	public int getCount(Rank rank) {
		return winCount.getOrDefault(rank, 0);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Prize prize = (Prize)o;
		return Objects.equals(winCount, prize.winCount);
	}
}
