package lotto.domain;

import money.Money;

public class AutoLottoTicketsVendor {

	private final Money lottoPrice;
	private final LottoTicketGenerator lottoTicketGenerator;

	public AutoLottoTicketsVendor(Money lottoPrice, LottoTicketGenerator lottoTicketGenerator) {
		this.lottoPrice = lottoPrice;
		this.lottoTicketGenerator = lottoTicketGenerator;
	}

	public LottoTickets buyAutoLottoTickets(Money amount) {
		return buyAutoLottoTickets(amount, LottoTickets.create());
	}

	private LottoTickets buyAutoLottoTickets(Money budget, LottoTickets lottoTickets) {
		if (isLessThanLottoPrice(budget)) {
			return lottoTickets;
		}
		lottoTickets.add(lottoTicketGenerator.generate());
		return buyAutoLottoTickets(budget.subtract(lottoPrice), lottoTickets);
	}

	private boolean isLessThanLottoPrice(Money budget) {
		return budget.isLessThan(lottoPrice);
	}
}
