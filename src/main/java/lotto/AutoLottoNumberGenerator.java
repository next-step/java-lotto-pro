package lotto;

import java.util.List;

import utils.Randoms;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {

	@Override
	public LottoTicket generate() {
		return LottoTicket.of(generateUniqueNumbers());
	}

	private List<Integer> generateUniqueNumbers() {
		return Randoms.generateUniqueNumbers(
			LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, LottoTicket.NUMBER_COUNT);
	}
}
