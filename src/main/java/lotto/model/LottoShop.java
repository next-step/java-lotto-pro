package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.strategy.LottoCreateStrategy;

public class LottoShop {
	private static final Money LOTTO_PRICE = new Money(1000L);
	private final LottoCreateStrategy lottoCreateStrategy;

	public LottoShop(final LottoCreateStrategy lottoCreateStrategy) {
		this.lottoCreateStrategy = lottoCreateStrategy;
	}

	public Lottos buy(final Money payment) {
		long quantity = payment.calculateQuantity(LOTTO_PRICE);
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			lottoList.add(lottoCreateStrategy.create());
		}
		return new Lottos(lottoList);
	}
}
