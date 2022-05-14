package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.sort;
import static java.util.Collections.unmodifiableList;

public class Lotto {
	private static final int LOTTO_SIZE = 6;
	private final List<Number> numbers;

	public Lotto(List<Number> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개여야 합니다");
		}
		if (!isUnique(numbers)) {
			throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다");
		}
		sort(numbers);
		this.numbers = unmodifiableList(numbers);
	}

	public Lotto(int... numbers) {
		this(Arrays.stream(numbers)
				.mapToObj(Number::from)
				.collect(Collectors.toList()));
	}

	public static Lotto auto() {
		return new Lotto(new ShuffledNumbers().get(LOTTO_SIZE));
	}

	private boolean isUnique(List<Number> numbers) {
		List<Number> distinctNumbers = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		return distinctNumbers.size() == numbers.size();
	}

	public Winning winning(Answer answer) {
		return Winning.from(answer.match(numbers));
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
