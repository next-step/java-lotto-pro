package lotto.domain;

import java.util.List;

import lotto.util.RandomNumbersGenerator;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
	@Override
	public List<Integer> pickNumbers() {
		return RandomNumbersGenerator.generate(
			LottoNumber.MIN_RANGE,
			LottoNumber.MAX_RANGE,
			Lotto.LOTTO_NUMBER_SIZE
		);
	}
}
