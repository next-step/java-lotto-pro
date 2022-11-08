package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.exception.InvalidMoneyException;

public class LottoTicketMachine {

	public static final int LOTTO_COST_PER_TICKET = 1000;
	private static final String INVALID_INPUT_MONEY_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";
	private static final Money PRICE_PER_TICKET = Money.from(LOTTO_COST_PER_TICKET);

	private LottoTicketMachine() {
	}

	private static class LottoTicketMachineHolder {
		private static final LottoTicketMachine INSTANCE = new LottoTicketMachine();
	}

	public static LottoTicketMachine getInstance() {
		return LottoTicketMachineHolder.INSTANCE;
	}

	public LottoTickets lottoTickets(List<LottoNumbers> lottoNumbers) {
		return lottoNumbers.stream()
			.map(LottoTicket::from)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
	}
	public TicketCount ticketCount(Money money) {
		if (money.isLessThan(PRICE_PER_TICKET)) {
			throw new InvalidMoneyException(INVALID_INPUT_MONEY_MESSAGE);
		}
		return TicketCount.from((int)money.divide(PRICE_PER_TICKET));
	}

}
