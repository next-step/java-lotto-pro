package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Prize {
	private final Map<Integer, Integer> winCount;

	public Prize(Numbers... numbersArr) {
		winCount = new HashMap<>();
		for (Numbers numbers : numbersArr) {
			winCount.put(numbers.size(), winCount.getOrDefault(numbers.size(), 0) + 1);
		}
	}

	public Prize(List<Numbers> numbersList) {
		winCount = new HashMap<>();
		for (Numbers numbers : numbersList) {
			winCount.put(numbers.size(), winCount.getOrDefault(numbers.size(), 0) + 1);
		}
	}

	public double rateReturn() {
		return (double)winMoney() / (totalCount() * LottoConstants.PRICE);
	}

	public int totalCount() {
		return winCount.values().stream().reduce(Integer::sum).orElse(0);
	}

	public int winMoney() {
		return winCount.entrySet().stream().reduce(0, (acc, entry) -> {
			Integer prize = LottoConstants.PRIZE_LIST.getOrDefault(entry.getKey(), 0);
			acc += prize * entry.getValue();
			return acc;
		}, Integer::sum);
	}

	public int getCount(int match) {
		return winCount.getOrDefault(match, 0);
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
