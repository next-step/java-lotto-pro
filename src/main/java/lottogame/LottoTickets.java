package lottogame;

import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	public int getNumOfTickets(){
		return lottoTickets.size();
	}
}
