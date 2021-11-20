package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.domain.wrapper.LottoTicket;

public class Machine {
	public static void showLottoTickets(List<LottoTicket> tickets) {
		tickets.stream()
			.forEach(ticket -> System.out.println(
				'['
					+ ticket.getNumbers().stream()
					.map(x -> x.toString())
					.collect(joining(","))
					+ ']'
				)
			);
	}
}
