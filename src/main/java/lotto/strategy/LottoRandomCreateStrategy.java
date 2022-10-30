package lotto.strategy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoRandomCreateStrategy implements LottoCreateStrategy {
	private final static int MIN_NUMBER = 1;
	private final static int MAX_NUMBER = 45;
	private final static int LOTTO_SIZE = 6;

	@Override
	public Lotto create() {
		Set<LottoNumber> result = new HashSet<>();
		Random random = new Random();
		while (result.size() < LOTTO_SIZE) {
			result.add(LottoNumberCache.cache[random.nextInt(MAX_NUMBER)]);
		}
		return new Lotto(result);
	}

	private static class LottoNumberCache{
		static final LottoNumber[] cache = new LottoNumber[MAX_NUMBER];

		static {
			for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
				cache[number-1] = new LottoNumber(number);
			}
		}
	}
}
