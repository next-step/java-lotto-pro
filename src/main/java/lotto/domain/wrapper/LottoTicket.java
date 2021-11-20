package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
	private static final List<Integer> DEFAULT_NUMBERS = getDefaultNumbers();
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;
	public static final int PRICE = 1000;
	private final List<Integer> numbers;

	public LottoTicket() {
		this.numbers = makeRandomNumbers();
	}

	private static List<Integer> getDefaultNumbers() {
		List<Integer> defaultNumbers = new ArrayList<>();
		for (int number = START_NUMBER; number < END_NUMBER; number++) {
			defaultNumbers.add(number);
		}
		return defaultNumbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	private List<Integer> makeRandomNumbers() {
		List<Integer> defaultNumbers = new ArrayList<>(DEFAULT_NUMBERS);
		Collections.shuffle(defaultNumbers);
		return defaultNumbers.subList(START_NUMBER - 1, NUMBER_COUNT);
	}
}
