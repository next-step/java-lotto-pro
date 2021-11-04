package lotto.generator;

import static lotto.constant.LottoConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

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
		List<Integer> numbers = createSeedNumbers();
		Collections.shuffle(numbers);

		return numbers;
	}

	private List<Integer> createSeedNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
			numbers.add(i);
		}

		return numbers;
	}
}
