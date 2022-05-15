package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
	private List<Number> numbers = new ArrayList<>();

	public Numbers(List<Integer> asList) {
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
}
