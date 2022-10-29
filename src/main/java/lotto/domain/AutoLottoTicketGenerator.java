package lotto.domain;

import java.util.List;

import utils.Randoms;

public class AutoLottoTicketGenerator implements LottoTicketGenerator {

	@Override
	public LottoTicket generate() {
		return LottoTicket.of(generateUniqueNumbers());
	}

	private List<Integer> generateUniqueNumbers() {
		return Randoms.generateUniqueNumbersRangeClosed(
			LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, LottoTicket.NUMBER_COUNT);
	}
}
