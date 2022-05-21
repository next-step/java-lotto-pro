package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumbers implements LottoNumberStrategy {
	private static List<Number> numbers = IntStream.range(Number.MIN_NUMBER, Number.MAX_NUMBER)
											.mapToObj(Number::new)
											.collect(Collectors.toList());

	public List<Number> generate(int limit) {
		Collections.shuffle(numbers);

		return numbers.stream()
			.limit(limit)
			.collect(Collectors.toList());
	}
}
