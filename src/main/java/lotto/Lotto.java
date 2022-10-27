package lotto;

import java.util.List;

public class Lotto {
	private final static int SIZE_OF_LOTTO = 6;

	private final List<Integer> numbers;

	public Lotto(final List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != SIZE_OF_LOTTO) {
			throw new IllegalArgumentException("로또의 번호는 6개 이다.");
		}
	}
}
