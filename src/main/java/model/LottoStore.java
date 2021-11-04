package model;

import java.util.ArrayList;
import java.util.Collection;

public final class LottoStore {

	private final Money initialMoney;
	private final Seller seller;

	private LottoStore(Money initialMoney, Seller seller) {
		validate(initialMoney);
		validate(seller);
		this.initialMoney = initialMoney;
		this.seller = seller;
	}

	public static LottoStore of(Money initialMoney, Seller seller) {
		return new LottoStore(initialMoney, seller);
	}

	public Lottos lottos() {
		Customer customer = Customer.from(initialMoney);
		Money lottoPrice = seller.price();

		Collection<Lotto> lottoCollection = new ArrayList<>();
		while (customer.hasMoreThan(lottoPrice)) {
			customer.subtractMoney(lottoPrice);
			lottoCollection.add(seller.lotto());
		}
		return Lottos.from(lottoCollection);
	}

	@Override
	public String toString() {
		return "LottoStore{" +
			"initialMoney=" + initialMoney +
			", seller=" + seller +
			'}';
	}

	private void validate(Seller seller) {
		if (seller == null) {
			throw new IllegalArgumentException("'seller' must not be null");
		}
	}

	private void validate(Money initialMoney) {
		if (initialMoney == null) {
			throw new IllegalArgumentException("'initialMoney' must not be null");
		}
	}
}
