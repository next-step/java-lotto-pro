package step2.domain;

import java.util.List;

public class NumberList {
	private List<NumberElement> numbers;

	public NumberList(List<NumberElement> numbers) {
		this.numbers = numbers;
	}

	public int getSum() {
		return numbers.stream().mapToInt(NumberElement::getNumber).sum();
	}
}
