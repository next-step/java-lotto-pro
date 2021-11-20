package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
	private static final List<Integer> DEFAULT_NUMBERS = makeDefaultNumbers();
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;
	public static final int PRICE = 1000;
	private final List<Integer> numbers;

	public LottoTicket() {
		this.numbers = makeLottoNumbers();
	}

	private static List<Integer> makeDefaultNumbers() {
		List<Integer> defaultNumbers = new ArrayList<>();
		for (int number = START_NUMBER; number < END_NUMBER; number++) {
			defaultNumbers.add(number);
		}
		return defaultNumbers;
	}
	private static List<Integer> getDefaultNumbers() {
		return new ArrayList<>(DEFAULT_NUMBERS);
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	private List<Integer> makeLottoNumbers() {
		List<Integer> defaultNumbers = getDefaultNumbers();
		Collections.shuffle(defaultNumbers);
		List<Integer> lottoNumbers = defaultNumbers.subList(START_NUMBER - 1, NUMBER_COUNT);
		lottoNumbers.sort((num1, num2) -> num1 - num2);
		return lottoNumbers;
	}
}
