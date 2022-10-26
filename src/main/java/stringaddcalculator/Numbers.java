package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private final List<Number> numbers;

	private Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public static Numbers from(String[] numbers) {
		return new Numbers(
			Arrays.stream(numbers)
				.map(Number::from)
				.collect(Collectors.toList())
		);
	}

	public boolean containsNegative() {
		return numbers.stream().anyMatch(Number::isNegative);
	}

	public Number sum() {
		return numbers.stream()
			.reduce(Number::sum)
			.orElse(Number.from(Number.ZERO));
	}
}
