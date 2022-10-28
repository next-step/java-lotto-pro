package lotto;

import money.Money;

public class LottoVendor {

	private final Money lottoPrice;
	private final LottoNumberGenerator lottoNumberGenerator;

	public LottoVendor(Money lottoPrice, LottoNumberGenerator lottoNumberGenerator) {
		this.lottoPrice = lottoPrice;
		this.lottoNumberGenerator = lottoNumberGenerator;
	}

	public LottoTicket purchase(Money amount) {
		return purchase(amount, LottoTicket.create());
	}

	private LottoTicket purchase(Money budget, LottoTicket lottoTicket) {
		if (budget.equals(Money.ZERO)) {
			return lottoTicket;
		}
		lottoTicket.add(lottoNumberGenerator.generate());
		return purchase(budget.subtract(lottoPrice), lottoTicket);
	}
}
