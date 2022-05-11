package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private static final String BASE_SEPARATOR = "[,:]";
	private final List<Number> numbers;

	private Numbers(List<Number> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public static Numbers from(String string) {
		if (string == null || string.isEmpty()) {
			return new Numbers(Collections.emptyList());
		}
		List<Number> numbers = split(string);
		return new Numbers(numbers);
	}

	private static List<Number> split(String string) {
		return Arrays.stream(string.split(BASE_SEPARATOR))
				.map(Number::from)
				.collect(Collectors.toList());
	}

	public Number sum() {
		return numbers.stream()
				.reduce(Number::add)
				.orElse(Number.zero());
	}
}
