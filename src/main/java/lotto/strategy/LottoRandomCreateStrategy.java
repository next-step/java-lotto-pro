package lotto.strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoRandomCreateStrategy implements LottoCreateStrategy {
	private final static int MIN_NUMBER = 1;
	private final static int MAX_NUMBER = 45;
	private final static int LOTTO_SIZE = 6;

	private final List<LottoNumber> numberPool = createPool();

	private List<LottoNumber> createPool() {
		List<LottoNumber> result = new ArrayList<>();
		for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
			result.add(new LottoNumber(number));
		}
		return result;
	}

	@Override
	public Lotto create() {
		Set<LottoNumber> result = new HashSet<>();
		Random random = new Random();
		while(result.size() < LOTTO_SIZE){
			result.add(numberPool.get(random.nextInt(MAX_NUMBER)));
		}
		return new Lotto(result);
	}
}
