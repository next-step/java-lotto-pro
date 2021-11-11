package lotto.model;

import static lotto.constants.LottoConstants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("The number of lotto must be 6");
		}

		Set<Integer> numberSet = new HashSet<>(numbers);
		if (numberSet.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("Lotto number must be distinct");
		}

		for (Integer number : numbers) {
			lottoNumberRangeValidate(number);
		}
	}

	private void lottoNumberRangeValidate(Integer number) {
		if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
			throw new IllegalArgumentException("Lotto number must be between 1 and 45");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public int compareNumbers(Lotto lotto) {
		return (int)numbers.stream()
			.filter(lotto.numbers::contains)
			.count();
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
