package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.exception.LackOfMoneyException;

public class Store {

	private Store() {
	}

	public static Lottos order(final Money money) {
		validateMinimumPrice(money);

		int count = calcBuyAbleCount(money);
		money.spend(count * Common.LOTTO_PRICE);

		return Lottos.from(issueLottos(count));
	}

	private static List<Lotto> issueLottos(int count) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(LottoGenerator.generate());
		}

		return lottos;
	}

	private static int calcBuyAbleCount(Money money) {
		return money.amount() / Common.LOTTO_PRICE;
	}

	private static void validateMinimumPrice(final Money money) {
		if (money.amount() < Common.LOTTO_PRICE) {
			throw new LackOfMoneyException();
		}
	}
}
