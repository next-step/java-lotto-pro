package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets implements Iterable<LottoTicket> {

	private static final int COUNT_UNIT = 1;

	private final List<LottoTicket> tickets;

	private LottoTickets(List<LottoTicket> tickets) {
		this.tickets = new ArrayList<>(tickets);
	}

	public static LottoTickets of(List<LottoTicket> ticketList) {
		return new LottoTickets(ticketList);
	}

	public static LottoTickets ofIntList(List<List<Integer>> lottoNumbers) {
		List<LottoTicket> lottoTicketList = lottoNumbers.stream()
			.map(LottoTicket::of)
			.collect(Collectors.toList());
		return new LottoTickets(lottoTicketList);
	}

	public static LottoTickets combine(LottoTickets tickets1, LottoTickets tickets2) {
		LottoTickets lottoTickets = new LottoTickets(tickets1.tickets);
		lottoTickets.addAll(tickets2);
		return lottoTickets;
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

	@Override
	public Iterator<LottoTicket> iterator() {
		return tickets.iterator();
	}

	private void addAll(LottoTickets otherLottoTickets) {
		this.tickets.addAll(otherLottoTickets.tickets);
	}

	public int getSize() {
		return this.tickets.size();
	}

	public RankCounts countRanks(WinningLotto winningLotto) {
		Map<Rank, Integer> countByRank = this.tickets.stream()
			.map(winningLotto::getMatchRank)
			.collect(toMap(rank -> rank, rank -> COUNT_UNIT, Integer::sum));
		return RankCounts.of(countByRank);
	}
}
