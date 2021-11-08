package lotto2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets implements Iterable<LottoTicket> {

	private final List<LottoTicket> tickets;

	private LottoTickets(List<LottoTicket> tickets) {
		this.tickets = tickets;
	}

	public static LottoTickets of(Collection<LottoTicket> ticketList) {
		return new LottoTickets(new ArrayList<>(ticketList));
	}

	public static LottoTickets of() {
		return new LottoTickets(new ArrayList<>());
	}

	public static LottoTickets of(List<List<Integer>> manualLottoNumbers) {
		List<LottoTicket> lottoTicketList = manualLottoNumbers.stream()
			.map(LottoTicket::of)
			.collect(Collectors.toList());
		return new LottoTickets(lottoTicketList);
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

	@Override
	public Iterator<LottoTicket> iterator() {
		return tickets.iterator();
	}

	public void addAll(LottoTickets manualLottoTickets) {
		this.tickets.addAll(manualLottoTickets.tickets);
	}
}
