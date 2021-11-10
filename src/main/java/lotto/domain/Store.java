package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.exception.LackOfMoneyException;

public class Store {

	private static final String NOT_ENOUGH_MONEY = "금액이 원하는 개수를 구매하기에 충분하지 않습니다.";

	private Store() {
	}

	public static Lottos order(final Money money, List<List<Integer>> manualNumbers) {
		validateMinimumPrice(money);

		int manualCount = manualNumbers.size();

		validateEnoughMoney(money, manualCount);

		List<Lotto> manualLottos = lottoOrder(money, manualCount);
		List<Lotto> autoLottos = autoLottoOrder(money);

		List<Lotto> allLottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
			.collect(Collectors.toList());

		return Lottos.from(allLottos);
	}

	private static List<Lotto> autoLottoOrder(Money money) {
		int buyAbleCount = calcBuyAbleCount(money);
		List<Lotto> autoLottos = new ArrayList<>();

		if (buyAbleCount > 0) {
			autoLottos = lottoOrder(money, buyAbleCount);
		}

		return autoLottos;
	}

	private static void validateEnoughMoney(Money money, int manualCount) {
		if (manualCount * Common.LOTTO_PRICE > money.amount()) {
			throw new LackOfMoneyException(NOT_ENOUGH_MONEY);
		}
	}

	private static List<Lotto> lottoOrder(Money money, int manualCount) {
		money.spend(manualCount * Common.LOTTO_PRICE);

		return issueLottos(manualCount);
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
