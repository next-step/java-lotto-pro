package model;

import java.util.ArrayList;
import java.util.Collection;

public final class LottoStore {

	private final Money initialMoney;
	private final Money price;
	private final LottoGenerator lottoGenerator;

	private LottoStore(Money initialMoney, Money price, LottoGenerator lottoGenerator) {
		validateNonNull(initialMoney, "'initialMoney' must not be null");
		validateNonNull(price, "'price' must not be null");
		validateNonNull(lottoGenerator, "'lottoGenerator' must not be null");
		this.initialMoney = initialMoney;
		this.price = price;
		this.lottoGenerator = lottoGenerator;
	}

	public static LottoStore of(Money initialMoney, Money price, LottoGenerator lottoGenerator) {
		return new LottoStore(initialMoney, price, lottoGenerator);
	}

	public Lottos lottos() {
		Customer customer = Customer.from(initialMoney);
		int purchaseCount = customer.availablePurchaseCount(price);
		customer.subtractMoney(price.multiply(purchaseCount));
		return Lottos.from(lottoCollection(purchaseCount));
	}

	@Override
	public String toString() {
		return "LottoStore{" +
			"initialMoney=" + initialMoney +
			", price=" + price +
			", lottoGenerator=" + lottoGenerator +
			'}';
	}

	private Collection<Lotto> lottoCollection(int purchaseCount) {
		Collection<Lotto> lottoCollection = new ArrayList<>();
		for (int i = 0; i < purchaseCount; i++) {
			lottoCollection.add(lottoGenerator.lotto());
		}
		return lottoCollection;
	}

	private void validateNonNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
