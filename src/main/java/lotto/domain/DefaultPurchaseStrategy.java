package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultPurchaseStrategy implements LottoPurchaseStrategy {
	private static final int DEFAULT_PURCHASE_LOTTO_PRICE = 1000;
	private static final long MIN_PURCHASE_AMOUNT = 0L;

	private final long purchaseAmount;

	public DefaultPurchaseStrategy(final long purchaseAmount) {
		validatePurchaseAmount(purchaseAmount);
		this.purchaseAmount = purchaseAmount;
	}

	public DefaultPurchaseStrategy(final String purchaseAmount) {
		this(parseInt(purchaseAmount));
	}

	private static int parseInt(String purchaseAmount) {
		try {
			return Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}

	private void validatePurchaseAmount(long purchaseAmount) {
		if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
			throw new IllegalArgumentException("구입 금액은 음수일 수 없습니다.");
		}
	}

	@Override
	public List<Lotto> purchase() {
		return LongStream.range(0, quantity())
			.mapToObj(i -> Lotto.random())
			.collect(Collectors.toList());
	}

	private long quantity() {
		return this.purchaseAmount / DEFAULT_PURCHASE_LOTTO_PRICE;
	}
}
