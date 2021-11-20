package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import utils.IntegerParser;

public class LottoTicket {
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;
	public static final int PRICE = 1000;
	public static final String DELIMITER = ",";
	private static final String MESSAGE_WRONG_NUMBER_COUNT = "개의 로또 번호를 중복없이 입력하세요.";
	private static final String MESSAGE_WRONG_NUMBER_RANGE = "로또 번호의 범위를 벗어났습니다.";
	private static final List<Integer> DEFAULT_NUMBERS = makeDefaultNumbers();

	private final List<Integer> numbers;

	public LottoTicket() {
		this.numbers = validatedNumbers(makeLottoNumbers());
	}

	public LottoTicket(String lottoNumbers) {
		this.numbers = validatedNumbers(IntegerParser.toInteger(lottoNumbers, DELIMITER));
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
		lottoNumbers.sort(Comparator.comparingInt(num -> num));
		return lottoNumbers;
	}

	private List<Integer> validatedNumbers(List<Integer> inputNumbers) {
		if (new HashSet<>(inputNumbers).size() != NUMBER_COUNT) {
			throw new IllegalArgumentException(NUMBER_COUNT + MESSAGE_WRONG_NUMBER_COUNT);
		}

		boolean overDefaultRange = inputNumbers.stream().anyMatch(num -> num > END_NUMBER && num < START_NUMBER);
		if (overDefaultRange) {
			throw new IllegalArgumentException(MESSAGE_WRONG_NUMBER_RANGE);
		}

		return inputNumbers;
	}
}
