package lotto.domain.lotto;

import java.util.List;
import java.util.Set;

import lotto.util.RandomNumbersGenerator;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
	public static final int RANDOM_RANGE_START = 1;
	public static final int RANDOM_RANGE_END = 45;
	public static final int NUMBER_SIZE = 6;

	@Override
	public Set<LottoNumber> pickNumbers() {
		return convert(pickRandomNumbers());
	}

	private List<Integer> pickRandomNumbers() {
		return RandomNumbersGenerator.generate(RANDOM_RANGE_START, RANDOM_RANGE_END, NUMBER_SIZE);
	}
}
