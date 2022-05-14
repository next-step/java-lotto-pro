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

	public int totalSum() {
		return numbers.stream()
			.reduce(Number::sum)
			.orElse(new Number(0))
			.getNumber();
	}
}
