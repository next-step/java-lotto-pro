package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import utils.IntegerParser;

public final class LottoTicket {
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;
	public static final int PRICE = 1000;
	public static final String DELIMITER = ",";
	private static final String MESSAGE_WRONG_NUMBER_COUNT = "개의 로또 번호를 중복없이 입력하세요.";
	private static final List<LottoNumber> DEFAULT_NUMBERS = makeDefaultNumbers();

	private final List<LottoNumber> numbers;

	public LottoTicket() {
		this.numbers = validatedNumbers(makeLottoNumbers());
	}

	public LottoTicket(String lottoNumbers) {
		this.numbers = validatedNumbers(IntegerParser.toInteger(lottoNumbers, DELIMITER).stream()
			.map(num -> LottoNumber.of(num)).collect(Collectors.toList()));
	}

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		this.numbers = validatedNumbers(lottoNumbers);
	}

	public LottoTicket(LottoTicket lottoTicket) {
		this.numbers = lottoTicket.getNumbers();
	}

	public static List<LottoNumber> getDefaultNumbers() {
		return new ArrayList<>(DEFAULT_NUMBERS);
	}

	private static List<LottoNumber> makeDefaultNumbers() {
		List<LottoNumber> defaultNumbers = new ArrayList<>();
		for (int number = START_NUMBER; number < END_NUMBER; number++) {
			defaultNumbers.add(LottoNumber.of(number));
		}
		return defaultNumbers;
	}

	public int countMatchNumbers(LottoTicket otherLottoTicket) {
		return (int) this.numbers.stream()
			.filter(lottoNumber -> otherLottoTicket.getNumbers().contains(lottoNumber))
			.count();
	}

	private List<LottoNumber> makeLottoNumbers() {
		List<LottoNumber> defaultNumbers = getDefaultNumbers();
		Collections.shuffle(defaultNumbers);
		List<LottoNumber> lottoNumbers = defaultNumbers.subList(START_NUMBER - 1, NUMBER_COUNT);
		lottoNumbers.sort(Comparator.comparingInt(num -> num.get()));
		return lottoNumbers;
	}

	private List<LottoNumber> validatedNumbers(List<LottoNumber> inputNumbers) {
		if (new HashSet<>(inputNumbers).size() != NUMBER_COUNT) {
			throw new IllegalArgumentException(NUMBER_COUNT + MESSAGE_WRONG_NUMBER_COUNT);
		}
		return inputNumbers;
	}

	public List<LottoNumber> getNumbers() {
		return this.numbers;
	}
}
