package model.store;

import model.LottoPapers;
import model.common.Money;
import utility.Assert;

public final class LottoStore {

	private final Customer customer;
	private final Money price;
	private final LottoMachine lottoMachine;

	private LottoStore(Customer customer, Money price, LottoMachine lottoMachine) {
		Assert.notNull(customer, "'customer' must not be null");
		Assert.notNull(price, "'price' must not be null");
		Assert.notNull(lottoMachine, "'lottoMachine' must not be null");
		this.customer = customer;
		this.price = price;
		this.lottoMachine = lottoMachine;
	}

	public static LottoStore of(Customer customer, Money price, LottoMachine lottoMachine) {
		return new LottoStore(customer, price, lottoMachine);
	}

	public LottoPapers lottoPapers() {
		validateMoney();
		int purchaseCount = customer.purchaseCount(price);
		LottoPapers papers = lottoMachine.manualLotto(customer.numbers());
		return papers.addAll(lottoMachine.randomLotto(restCount(purchaseCount, papers)));
	}

	@Override
	public String toString() {
		return "LottoStore{" +
			"customer=" + customer +
			", price=" + price +
			", lottoMachine=" + lottoMachine +
			'}';
	}

	private void validateMoney() {
		if (customer.hasNumbersGreaterThanPurchaseCount(price)) {
			throw new IllegalStateException(
				String.format("customer does not have enough money(%s) to buy %d manual lotto",
					customer.money(), customer.numberSize()));
		}
	}

	private int restCount(int purchaseCount, LottoPapers papers) {
		return purchaseCount - papers.size();
	}
}
