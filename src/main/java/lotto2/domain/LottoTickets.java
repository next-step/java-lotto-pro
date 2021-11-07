package lotto2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LottoTickets {

	private final List<LottoTicket> tickets;

	private LottoTickets(List<LottoTicket> tickets) {
		this.tickets = tickets;
	}

	public static LottoTickets of(Collection<LottoTicket> ticketList) {
		List<LottoTicket> ticketSet = new ArrayList<>(ticketList);
		return new LottoTickets(ticketSet);
	}

	public static LottoTickets of() {
		return new LottoTickets(new ArrayList<>());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LottoTickets tickets1 = (LottoTickets)o;

		return tickets.equals(tickets1.tickets);
	}

	@Override
	public int hashCode() {
		return tickets.hashCode();
	}

	public boolean isEqualSize(PositiveNumber size) {
		return this.tickets.size() == size.toInt();
	}

	public void add(LottoTicket ticket) {
		this.tickets.add(ticket);
	}
}
