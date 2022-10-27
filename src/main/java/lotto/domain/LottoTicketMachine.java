package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicketMachine {

	private static final int LOTTO_COST_PER_TICKET = 1000;
	private static final int START_INCLUSIVE = 0;
	private final GenerateStrategy generateStrategy;
	private final Money ticketPrice;

	public LottoTicketMachine(GenerateStrategy generateStrategy) {
		this.generateStrategy = generateStrategy;
		this.ticketPrice = Money.of(LOTTO_COST_PER_TICKET);
	}

	public LottoTickets buyLottoTickets(Money money) {
		TicketCount ticketCount = getTicketCount(money);
		return lottoTickets(ticketCount);
	}

	private LottoTickets lottoTickets(TicketCount ticketCount) {
		return IntStream.range(START_INCLUSIVE, ticketCount.count())
			.mapToObj(i -> this.generateLottoTicket(generateStrategy))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::of));
	}

	private TicketCount getTicketCount(Money money) {
		return money.ticketCount(ticketPrice);
	}

	private LottoTicket generateLottoTicket(GenerateStrategy generateStrategy) {
		return LottoTicket.of(generateStrategy);
	}
}
