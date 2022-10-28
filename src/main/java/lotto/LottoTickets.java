package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

	private final List<LottoTicket> lottoTicketList;

	private LottoTickets(List<LottoTicket> lottoTicketList) {
		this.lottoTicketList = lottoTicketList;
	}

	public static LottoTickets of(List<LottoTicket> lottoNumbers) {
		return new LottoTickets(lottoNumbers);
	}

	public static LottoTickets create() {
		return new LottoTickets(new ArrayList<>());
	}

	public void add(LottoTicket lottoTicket) {
		lottoTicketList.add(lottoTicket);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoTickets that = (LottoTickets)o;
		return lottoTicketList.equals(that.lottoTicketList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoTicketList);
	}
}
