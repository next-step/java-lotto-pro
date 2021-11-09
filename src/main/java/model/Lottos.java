package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<Lotto> values;

	Lottos(List<Lotto> values) {
		this.values = values;
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public static PurchaseCount purchaseCountFrom(Money money) {
		return money.purchaseableCount(Money.of(Lotto.COST));
	}

	public static Lottos from(Purchase purchase) {
		List<Lotto> values = new ArrayList<>(purchase.getManualLottos().values);

		for (int i = 0; i < purchase.getAutoCount().getValue(); i++) {
			values.add(Lotto.createByAuto());
		}

		return new Lottos(values);
	}

	public MatchResult matchResult(LastWeekWinningNumber lastWeekWinningNumber) {
		MatchResult matchResult = new MatchResult();

		values.forEach(lotto -> {
			Count count = lotto.matchCount(lastWeekWinningNumber.getLotto());
			boolean isMatchBonusBall = lotto.isMatchBonusBall(lastWeekWinningNumber.getBonusBall());
			matchResult.increaseByMatchCount(MatchingNumberCount.getByCount(count, isMatchBonusBall));
		});

		return matchResult;
	}

	public List<Lotto> getValues() {
		return values;
	}
}
