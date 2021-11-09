package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.constants.Rank;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
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

	public Numbers compareNumbers(Lotto lotto) {
		return new Numbers(numbers.stream()
			.filter(lotto.numbers::contains)
			.collect(Collectors.toList()));
	}

	public Rank compare(Lotto lotto) {
		Numbers numbers = compareNumbers(lotto);

		return Rank.valueOf(numbers.size());
	}
}
