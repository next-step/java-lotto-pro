package model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {
	public static final Integer COST = 1000;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final Integer NUMBER_COUNT = 6;
	public static final int INDEX_OF_START = 0;

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

	public static boolean isNotDuplicatedNumber(Set<Integer> numbers) {
		return numbers.size() == NUMBER_COUNT;
	}

	public static boolean isValidLottoNumber(Set<Integer> numbers) {
		return
			numbers.stream().allMatch(
				number -> number.compareTo(MIN_NUMBER) >= 0 && number.compareTo(MAX_NUMBER) <= 0
			);
	}

	public Count matchCount(Lotto other) {
		Count count = Count.zero();
		for (int i = 0; i < NUMBER_COUNT; i++) {
			count = numbers.contains(other.at(i)) ? Count.sum(count, Count.one()) : count;
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
