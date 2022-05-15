package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
	private final String VALID_DUPLICATION = "중복된 숫자가 존재합니다.";

	private List<Number> numbers = new ArrayList<>();

	public Numbers(List<Integer> asList) {
		validDuplication(asList);

		for(Integer number: asList) {
			numbers.add(new Number(number));
		}
	}

	public int match(Numbers comparisonNumbers) {
		return (int)numbers.stream()
						.filter(comparisonNumbers::isContainNumber)
						.count();
	}

	private boolean isContainNumber(Number number) {
		return numbers.contains(number);
	}

	private void validDuplication(List<Integer> numbers) {
		Set<Integer> numberSet = new HashSet<>(numbers);

		if(numberSet.size() != numbers.size()) {
			throw new IllegalArgumentException(VALID_DUPLICATION);
		}
	}
}
