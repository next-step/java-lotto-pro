package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static final String MINIMUM_PRICE_REQUIRED_ERROR = "구매 금액은 1000원 이상이어야 합니다.";

	private Store() {
	}

	public static List<Lotto> sell(final Money money) {
		validateMinimumPrice(money);

		int count = calcBuyAbleCount(money);
		money.spend(count * Common.LOTTO_PRICE);

		return issueLottos(count);
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
			throw new IllegalArgumentException(MINIMUM_PRICE_REQUIRED_ERROR);
		}
	}
}
