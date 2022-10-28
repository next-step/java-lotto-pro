package lotto;

import money.Money;

public class LottoVendor {

	private final Money lottoPrice;
	private final LottoNumberGenerator lottoNumberGenerator;

	public LottoVendor(Money lottoPrice, LottoNumberGenerator lottoNumberGenerator) {
		this.lottoPrice = lottoPrice;
		this.lottoNumberGenerator = lottoNumberGenerator;
	}

	public LottoTickets purchase(Money amount) {
		return purchase(amount, LottoTickets.create());
	}

	private LottoTickets purchase(Money budget, LottoTickets lottoTickets) {
		if (isLessThanLottoPrice(budget)) {
			return lottoTickets;
		}
		lottoTickets.add(lottoNumberGenerator.generate());
		return purchase(budget.subtract(lottoPrice), lottoTickets);
	}

	private boolean isLessThanLottoPrice(Money budget) {
		return budget.isLessThan(lottoPrice);
	}
}
