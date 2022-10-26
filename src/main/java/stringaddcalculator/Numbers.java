package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private static final int SUM_DEFAULT_RETURN_VALUE = 0;
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

	public Number sum() {
		return numbers.stream()
			.reduce(Number::sum)
			.orElse(Number.from(SUM_DEFAULT_RETURN_VALUE));
	}
}
