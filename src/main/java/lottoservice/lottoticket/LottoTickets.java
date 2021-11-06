package lottoservice.lottoticket;

import java.util.List;
import java.util.stream.Collectors;

/**
 * LottoTicket을 List 자료구조 묶음으로 다루는 일급 컬렉션
 */
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

	public boolean hasTicket(LottoTicket lottoTicket){
		return lottoTickets.contains(lottoTicket);
	}

	@Override
	public String toString() {
		return lottoTickets.stream()
			.map(lottoTicket -> lottoTicket.toString())
			.collect(Collectors.joining("\n"));
	}
}
