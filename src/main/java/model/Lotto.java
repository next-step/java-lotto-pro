package model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {
	public static final Integer COST = 1000;
	public static final Integer NUMBER_COUNT = 6;
	public static final int INDEX_OF_START = 0;
	private static List<Integer> numberCandidate;

	static {
		numberCandidate = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.boxed()
			.collect(toList());
	}

	private List<LottoNumber> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers.stream()
			.map(LottoNumber::of)
			.collect(toList());
	}

	public static Lotto create() {
		Collections.shuffle(numberCandidate);

		List<Integer> selectedNumbers = numberCandidate.subList(INDEX_OF_START, INDEX_OF_START + NUMBER_COUNT);
		Collections.sort(selectedNumbers);

		return new Lotto(selectedNumbers);
	}

	public static boolean isNotDuplicatedNumber(Set<Integer> numbers) {
		return numbers.size() == NUMBER_COUNT;
	}

	public static boolean isValidLottoNumber(Set<Integer> numbers) {
		return numbers.stream()
				.allMatch(LottoNumber::isValidNumber);
	}

	public Count matchCount(Lotto other) {
		Count count = Count.zero();
		for (int i = 0; i < NUMBER_COUNT; i++) {
			count = numbers.contains(other.at(i)) ? Count.sum(count, Count.one()) : count;
		}

		return count;
	}

	public boolean isMatchBonusBall(BonusBall bonusBall) {
		return numbers.contains(bonusBall.getNumber());
	}

	public boolean isNotContain(BonusBall bonusBall) {
		return !numbers.contains(bonusBall.getNumber());
	}

	public LottoNumber at(int index) {
		return this.numbers.get(index);
	}

	public List<LottoNumber> getNumbers() {
		return numbers;
	}
}
