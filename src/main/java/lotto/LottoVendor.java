package lotto;

import money.Money;

public class LottoVendor {

	private final Money lottoPrice;
	private final LottoTicketGenerator lottoTicketGenerator;

	public LottoVendor(Money lottoPrice, LottoTicketGenerator lottoTicketGenerator) {
		this.lottoPrice = lottoPrice;
		this.lottoTicketGenerator = lottoTicketGenerator;
	}

	public LottoTickets purchase(Money amount) {
		return purchase(amount, LottoTickets.create());
	}

	private LottoTickets purchase(Money budget, LottoTickets lottoTickets) {
		if (isLessThanLottoPrice(budget)) {
			return lottoTickets;
		}
		lottoTickets.add(lottoTicketGenerator.generate());
		return purchase(budget.subtract(lottoPrice), lottoTickets);
	}

	private boolean isLessThanLottoPrice(Money budget) {
		return budget.isLessThan(lottoPrice);
	}
}
