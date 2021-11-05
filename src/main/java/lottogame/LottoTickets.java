package lottogame;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	public int getNumOfTickets() {
		return lottoTickets.size();
	}

	@Override
	public String toString() {
		return lottoTickets.stream()
			.map(lottoTicket -> lottoTicket.toString())
			.collect(Collectors.joining("\n"));
	}
}
