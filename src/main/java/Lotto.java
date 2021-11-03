import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
	public static final Integer COST = 1000;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int INDEX_OF_START = 0;
	private static final Integer NUMBER_COUNT = 6;

	private List<Integer> numbers;

	Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Lotto create() {
		List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
			.boxed()
			.collect(toList());

		Collections.shuffle(numbers);

		List<Integer> selectedNumbers = numbers.subList(INDEX_OF_START, INDEX_OF_START + NUMBER_COUNT);
		Collections.sort(selectedNumbers);

		return new Lotto(selectedNumbers);
	}

	public int matchCount(Lotto other) {
		int count = 0;
		for (int i = 0; i < NUMBER_COUNT; i++) {
			count = this.getNumbers().contains(other.at(i)) ? ++count : count;
		}

		return count;
	}

	public Integer at(int index) {
		return this.numbers.get(index);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
