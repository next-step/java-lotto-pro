package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lotto.constants.Rank;

public class Prize {
	private final Map<Rank, Integer> winCount;

	public Prize(Rank... ranks) {
		winCount = new HashMap<>();
		for (Rank rank : ranks) {
			winCount.put(rank, winCount.getOrDefault(rank, 0) + 1);
		}
	}

	public Prize(List<Rank> ranks) {
		winCount = new HashMap<>();
		for (Rank rank : ranks) {
			winCount.put(rank, winCount.getOrDefault(rank, 0) + 1);
		}
	}

	public double rateReturn(int money) {
		return (double)winMoney() / money;
	}

	public int winMoney() {
		return winCount.entrySet().stream().reduce(0, (acc, entry) -> {
			Rank rank = entry.getKey();
			Integer prize = rank.getPrize();

			acc += prize * entry.getValue();
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
