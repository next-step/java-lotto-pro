package lotto;

import static lotto.common.Constants.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	private List<Integer> numbers;

	public Lotto() {
		this.numbers = generate();
	}

	private List<Integer> generate() {
		List<Integer> allNumbers =
			IntStream.range(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
		Collections.shuffle(allNumbers);
		return allNumbers.subList(0, VOLUME);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
