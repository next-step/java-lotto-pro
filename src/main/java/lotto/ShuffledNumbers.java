package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffledNumbers {
	private static final int RANGE_FROM = 1;
	private static final int RANGE_TO = 46;
	private final List<Number> numbers;

	public ShuffledNumbers() {
		numbers = IntStream.range(RANGE_FROM, RANGE_TO)
				.mapToObj(Number::new)
				.collect(Collectors.toList());
		Collections.shuffle(numbers);
	}

	public List<Number> get(int size) {
		return numbers.subList(0, size);
	}
}
