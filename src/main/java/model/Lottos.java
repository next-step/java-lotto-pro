package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<Lotto> values;

	public static int buyCountFor(int money) {
		return money / Lotto.COST;
	}

	public static Lottos purchase(int volume) {
		List<Lotto> values = new ArrayList<>();
		for (int i = 0; i < volume; i++) {
			values.add(Lotto.create());
		}

		return new Lottos(values);
	}

	public MatchResult matchResult(LastWeekWinningNumber lastWeekWinningNumber) {
		MatchResult matchResult = new MatchResult();

		values.stream()
			.forEach(lotto -> {
				int matchCount = lotto.matchCount(lastWeekWinningNumber.getValue());
				matchResult.increaseByMatchCount(matchCount);
			});

		return matchResult;
	}

	public List<Lotto> getValues() {
		return values;
	}
}
