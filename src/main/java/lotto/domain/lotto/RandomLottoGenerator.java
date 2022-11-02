package lotto.domain.lotto;

import java.util.List;

import lotto.util.RandomNumbersGenerator;

public class RandomLottoGenerator implements LottoGenerator {
	@Override
	public Lotto generate() {
		return Lotto.from(pickRandomNumbers());
	}

	private List<Integer> pickRandomNumbers() {
		return RandomNumbersGenerator.generate(LottoNumber.MIN_RANGE, LottoNumber.MAX_RANGE, Lotto.LOTTO_NUMBERS_SIZE);
	}
}
