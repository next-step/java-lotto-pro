package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffledNumbers {
	private static final int RANGE_FROM = 1;
	private static final int RANGE_TO = 46;
	private static final int MINIMUM_SIZE = 0;
	private static final int MAXIMUM_SIZE = 45;
	private final List<Number> numbers;

	public ShuffledNumbers() {
		numbers = IntStream.range(RANGE_FROM, RANGE_TO)
				.mapToObj(Number::from)
				.collect(Collectors.toList());
		Collections.shuffle(numbers);
	}

	public List<Number> get(int size) {
		if (size < MINIMUM_SIZE || size > MAXIMUM_SIZE) {
			throw new IllegalArgumentException("0개 이상 45개 이하만 선택할 수 있습니다");
		}
		return numbers.subList(0, size);
	}
}
