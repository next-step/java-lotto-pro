package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberStrategy {
	private static List<Number> numbers = IntStream.range(Number.MIN_NUMBER, Number.MAX_NUMBER)
											.mapToObj(Number::new)
											.collect(Collectors.toList());

	public static Lotto generate() {
		Collections.shuffle(numbers);

		return new Lotto(numbers.stream()
			.limit(Lotto.LOTTO_SIZE)
			.collect(Collectors.toList()));
	}
}
