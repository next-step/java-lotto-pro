package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private final List<Number> numbers;

	public Numbers(String[] numbers) {
		this.numbers = Arrays.stream(numbers)
			.map(Number::new)
			.collect(Collectors.toList());
	}

	public boolean containsNegative() {
		return numbers.stream().anyMatch(Number::isNegative);
	}

	public Number sum() {
		return numbers.stream()
			.reduce(Number::sum)
			.orElse(new Number(Number.ZERO));
	}
}
