package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
	private List<Number> numbers = new ArrayList<>();

	public Numbers(String ...strNumbers) {
		for(String number: strNumbers) {
			numbers.add(new Number(number));
		}
	}

	public int total() {
		return numbers.stream()
				.mapToInt(Number::getNumber)
			.sum();
	}
}
