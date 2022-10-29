package lotto;

import money.Money;

public class LottoVendor {

	private final Money lottoPrice;
	private final LottoTicketGenerator lottoTicketGenerator;

	public LottoVendor(Money lottoPrice, LottoTicketGenerator lottoTicketGenerator) {
		this.lottoPrice = lottoPrice;
		this.lottoTicketGenerator = lottoTicketGenerator;
	}

	public LottoTickets quickPick(Money amount) {
		return quickPick(amount, LottoTickets.create());
	}

	private LottoTickets quickPick(Money budget, LottoTickets lottoTickets) {
		if (isLessThanLottoPrice(budget)) {
			return lottoTickets;
		}
		lottoTickets.add(lottoTicketGenerator.generate());
		return quickPick(budget.subtract(lottoPrice), lottoTickets);
	}

	private boolean isLessThanLottoPrice(Money budget) {
		return budget.isLessThan(lottoPrice);
	}
}
