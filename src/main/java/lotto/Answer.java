package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.sort;
import static java.util.Collections.unmodifiableList;

public class Answer {
	private static final int ANSWER_SIZE = 6;
	private final List<Number> numbers;

	public Answer(List<Number> numbers) {
		if (numbers.size() != ANSWER_SIZE) {
			throw new IllegalArgumentException("당첨 번호는 6개여야 합니다");
		}
		if (!isUnique(numbers)) {
			throw new IllegalArgumentException("당첨 번호는 중복되지 않아야 합니다");
		}
		sort(numbers);
		this.numbers = unmodifiableList(numbers);
	}

	public Answer(String numbers) {
		this(Arrays.stream(numbers.split(","))
				.map(number -> Number.from(number.trim()))
				.collect(Collectors.toList()));
	}

	private boolean isUnique(List<Number> numbers) {
		List<Number> distinctNumbers = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		return distinctNumbers.size() == numbers.size();
	}
}
