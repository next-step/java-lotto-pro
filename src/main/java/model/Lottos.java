package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<Lotto> values;

	Lottos(List<Lotto> values) {
		this.values = values;
	}

	public static PurchaseCount purchaseCountFrom(Money money) {
		return money.purchaseableCount(Money.of(Lotto.COST));
	}

	public static Lottos purchase(PurchaseCount purchaseCount) {
		List<Lotto> values = new ArrayList<>();
		for (int i = 0; i < purchaseCount.getValue(); i++) {
			values.add(Lotto.create());
		}

		return new Lottos(values);
	}

	public MatchResult matchResult(LastWeekWinningNumber lastWeekWinningNumber) {
		MatchResult matchResult = new MatchResult();

		values.forEach(lotto -> {
				Count count = lotto.matchCount(lastWeekWinningNumber.getValue());
				matchResult.increaseByMatchCount(MatchingNumberCount.getByCount(count));
			});

		return matchResult;
	}

	public List<Lotto> getValues() {
		return values;
	}
}
