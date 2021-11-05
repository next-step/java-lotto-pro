package lottogame;

import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public List<LottoTicket> getLottoNumbers() {
		return lottoTickets;
	}

	public int getNumOftickets(){
		return lottoTickets.size();
	}
}
