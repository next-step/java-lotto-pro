package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.dto.LottoNumber;

public class Numbers {
	private final String VALID_DUPLICATION = "중복된 숫자가 존재합니다.";

	private Set<Number> elements;

	public Numbers(List<Number> numbers) {
		this.elements = new HashSet<>(numbers);
		validDuplication(numbers);
	}

	public int match(Numbers comparisonNumbers) {
		return (int)elements.stream()
						.filter(comparisonNumbers::isContainNumber)
						.count();
	}

	public LottoNumber getNumbers() {
		return LottoNumber.convertTo(elements);
	}

	public boolean isContainNumber(Number number) {
		return elements.contains(number);
	}

	private void validDuplication(List<Number> numbers) {
		if(elements.size() != numbers.size()) {
			throw new IllegalArgumentException(VALID_DUPLICATION);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Numbers numbers = (Numbers)o;
		return Objects.equals(elements,
					numbers.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(VALID_DUPLICATION, elements);
	}
}
