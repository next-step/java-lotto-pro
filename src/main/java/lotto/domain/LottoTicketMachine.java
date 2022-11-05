package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.strategy.GenerateStrategy;
import lotto.exception.InvalidMoneyException;

public class LottoTicketMachine {

	public static final int LOTTO_COST_PER_TICKET = 1000;
	private static final String INVALID_INPUT_MONEY_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";
	private static final Money PRICE_PER_TICKET = Money.from(LOTTO_COST_PER_TICKET);
	private static final int START_INCLUSIVE = 0;

	private LottoTicketMachine() {
	}

	public static LottoTicketMachine create() {
		return new LottoTicketMachine();
	}
	public LottoTickets lottoTickets(Money money, GenerateStrategy strategy) {
		TicketCount ticketCount = getTicketCount(money);
		return IntStream.range(START_INCLUSIVE, ticketCount.count())
			.mapToObj(i -> this.generateLottoTicket(strategy))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
	}

	private TicketCount getTicketCount(Money money) {
		if (money.isLessThan(PRICE_PER_TICKET)) {
			throw new InvalidMoneyException(INVALID_INPUT_MONEY_MESSAGE);
		}
		return TicketCount.from((int)money.divide(PRICE_PER_TICKET));
	}

	private LottoTicket generateLottoTicket(GenerateStrategy generateStrategy) {
		return LottoTicket.from(generateStrategy);
	}
}
