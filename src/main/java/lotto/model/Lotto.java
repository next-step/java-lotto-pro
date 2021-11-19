package lotto.model;

import static lotto.constants.LottoConstants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	private final List<LottoNumber> numbers;

	public Lotto(List<LottoNumber> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public Lotto(int... numbers) {
		this(IntStream.of(numbers)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList()));
	}

	private void validate(List<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("The number of lotto must be 6");
		}

		Set<LottoNumber> numberSet = new HashSet<>(numbers);
		if (numberSet.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("Lotto number must be distinct");
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
	public int hashCode() {
		return Objects.hash(numbers);
	}

	public int compareNumbers(Lotto lotto) {
		return (int)numbers.stream()
			.filter(lotto.numbers::contains)
			.count();
	}

	public boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
