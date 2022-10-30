package lotto.domain;

import java.util.List;
import java.util.Set;

public class InputLottoNumberStrategy implements LottoNumberStrategy {
	private static final int INPUT_LOTTO_NUMBER_SIZE = 6;
	private final List<Integer> numbers;

	public InputLottoNumberStrategy(List<Integer> numbers) {
		validateInputLottoNumbers(numbers.size());

		this.numbers = numbers;
	}

	@Override
	public Set<LottoNumber> pickNumbers() {
		return convert(numbers);
	}

	private void validateInputLottoNumbers(int size) {
		if (size != INPUT_LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호 갯수가 6개이여야 합니다.");
		}
	}
}
