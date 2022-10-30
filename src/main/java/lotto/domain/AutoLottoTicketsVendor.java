package lotto.domain;

public class AutoLottoTicketsVendor {

	private final LottoTicketGenerator lottoTicketGenerator;

	public AutoLottoTicketsVendor(LottoTicketGenerator lottoTicketGenerator) {
		this.lottoTicketGenerator = lottoTicketGenerator;
	}

	public LottoTickets buyAutoLottoTickets(int buyingLottoTicketsCount) {
		return buyAutoLottoTickets(buyingLottoTicketsCount, LottoTickets.create());
	}

	private LottoTickets buyAutoLottoTickets(int buyingLottoTicketsCount, LottoTickets lottoTickets) {
		if (buyingLottoTicketsCount <= 0) {
			return lottoTickets;
		}

		lottoTickets.add(lottoTicketGenerator.generate());
		return buyAutoLottoTickets(buyingLottoTicketsCount - 1, lottoTickets);
	}

}
