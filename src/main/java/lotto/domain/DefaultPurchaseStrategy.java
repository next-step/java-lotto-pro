package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultPurchaseStrategy implements LottoPurchaseStrategy {
	private static final int DEFAULT_PURCHASE_LOTTO_PRICE = 1000;

	private final Amount purchaseAmount;

	public DefaultPurchaseStrategy(final Amount purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	@Override
	public List<Lotto> purchase() {
		return LongStream.range(0, quantity())
			.mapToObj(i -> Lotto.random())
			.collect(Collectors.toList());
	}

	private long quantity() {
		return this.purchaseAmount.getLong() / DEFAULT_PURCHASE_LOTTO_PRICE;
	}
}
