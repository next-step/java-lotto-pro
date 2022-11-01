package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoTicketsVendor {

	private final LottoTicketGenerator lottoTicketGenerator;

	public AutoLottoTicketsVendor(LottoTicketGenerator lottoTicketGenerator) {
		this.lottoTicketGenerator = lottoTicketGenerator;
	}

	public LottoTickets buyAutoLottoTickets(int buyingLottoTicketsCount) {
		return LottoTickets.of(
			buyAutoLottoTickets(buyingLottoTicketsCount, new ArrayList<>(buyingLottoTicketsCount)));
	}

	private List<LottoTicket> buyAutoLottoTickets(int buyingLottoTicketsCount, List<LottoTicket> lottoTickets) {
		if (buyingLottoTicketsCount <= 0) {
			return lottoTickets;
		}

		lottoTickets.add(lottoTicketGenerator.generate());
		return buyAutoLottoTickets(buyingLottoTicketsCount - 1, lottoTickets);
	}

}
