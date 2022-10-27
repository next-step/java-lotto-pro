package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.exception.InvalidMoneyException;

public class LottoTicketMachine {

	public List<LottoTicket> lottoTickets(int money) {
		int count = getCount(money);
		return this.buyLottoTickets(count);
	}

	private static int getCount(int money) {
		int count = money / 1000;
		if (count < 1) {
			throw new InvalidMoneyException("로또 구입 금액은 1000원 이상이어야 합니다.");
		}
		return count;
	}

	private List<LottoTicket> buyLottoTickets(int count) {
		return IntStream.range(0, count)
			.mapToObj(i -> this.generateLottoTicket())
			.collect(Collectors.toList());
	}

	private LottoTicket generateLottoTicket() {
		LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
		return LottoTicket.of(lottoNumbersGenerator);
	}
}
