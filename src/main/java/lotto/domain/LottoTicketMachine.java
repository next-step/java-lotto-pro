package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicketMachine {

	private static final int LOTTO_COST_PER_TICKET = 1000;
	private static final Money PRICE_PER_TICKET = Money.from(LOTTO_COST_PER_TICKET);
	private static final int START_INCLUSIVE = 0;
	private final GenerateStrategy generateStrategy;

	public LottoTicketMachine(GenerateStrategy generateStrategy) {
		this.generateStrategy = generateStrategy;
	}

	public LottoTickets buyLottoTickets(Money money) {
		TicketCount ticketCount = getTicketCount(money);
		return lottoTickets(ticketCount);
	}

	private LottoTickets lottoTickets(TicketCount ticketCount) {
		return IntStream.range(START_INCLUSIVE, ticketCount.count())
			.mapToObj(i -> this.generateLottoTicket(generateStrategy))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
	}

	private TicketCount getTicketCount(Money money) {
		return money.ticketCount(PRICE_PER_TICKET);
	}

	private LottoTicket generateLottoTicket(GenerateStrategy generateStrategy) {
		return LottoTicket.from(generateStrategy);
	}
}
