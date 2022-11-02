package lotto.domain.lotto;

import java.util.List;

public class InputLottoGenerator implements LottoGenerator {
	private final List<Integer> numbers;

	public InputLottoGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public Lotto generate() {
		return Lotto.from(numbers);
	}
}
