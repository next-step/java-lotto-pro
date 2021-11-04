package lotto.generator;

import static lotto.constant.LottoConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
	private final List<Integer> seedNumbers;

	public LottoNumberGenerator() {
		this.seedNumbers = createSeedNumbers();
	}

	@Override
	public List<Integer> generate() {
		List<Integer> randomNumbers = createRandomNumbers();
		List<Integer> lottoNumbers = createLottoNumbers(randomNumbers);
		Collections.sort(lottoNumbers);

		return lottoNumbers;
	}

	private List<Integer> createLottoNumbers(List<Integer> randomNumbers) {
		List<Integer> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < VALID_LOTTO_NUMBER_COUNT; i++) {
			lottoNumbers.add(randomNumbers.get(i));
		}

		return lottoNumbers;
	}

	private List<Integer> createRandomNumbers() {
		Collections.shuffle(this.seedNumbers);
		return this.seedNumbers;
	}

	private List<Integer> createSeedNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
			numbers.add(i);
		}

		return numbers;
	}
}
