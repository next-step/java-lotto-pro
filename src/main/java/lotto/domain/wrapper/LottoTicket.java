package lotto.domain.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import utils.IntegerParser;

public class LottoTicket {
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;
	public static final int PRICE = 1000;
	public static final String DELIMITER = ",";
	private static final String MESSAGE_WRONG_NUMBER_COUNT = "개의 로또 번호를 중복없이 입력하세요.";
	private static final String MESSAGE_WRONG_BONUS_NUMBER = "보너스 볼을 다시 입력해 주세요.";
	private static final List<LottoNumber> DEFAULT_NUMBERS = makeDefaultNumbers();

	private final List<LottoNumber> numbers;
	private LottoNumber bonus;

	public LottoTicket() {
		this.numbers = validatedNumbers(makeLottoNumbers());
	}

	public LottoTicket(String lottoNumbers) {
		this.numbers = validatedNumbers(IntegerParser.toInteger(lottoNumbers, DELIMITER).stream()
			.map(num -> new LottoNumber(num)).collect(Collectors.toList()));
	}

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		this.numbers = validatedNumbers(lottoNumbers);
	}

	private static List<LottoNumber> makeDefaultNumbers() {
		List<LottoNumber> defaultNumbers = new ArrayList<>();
		for (int number = START_NUMBER; number < END_NUMBER; number++) {
			defaultNumbers.add(new LottoNumber(number));
		}
		return defaultNumbers;
	}

	public static List<LottoNumber> getDefaultNumbers() {
		return new ArrayList<>(DEFAULT_NUMBERS);
	}

	public LottoTicket addBonus(String bonus) {
		try {
			return addBonus(Integer.valueOf(bonus));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
	}

	public LottoTicket addBonus(int bonus) {
		LottoNumber bonusNumber = new LottoNumber(bonus);
		validateBonus(bonusNumber);
		initBonus(bonusNumber);
		return this;
	}

	public LottoNumber getBonus() {
		return this.bonus;
	}

	public List<LottoNumber> getNumbers() {
		return this.numbers;
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

	private void initBonus(LottoNumber bonus) {
		this.bonus = bonus;
	}

	private void validateBonus(LottoNumber bonus) {
		if (!getDefaultNumbers().contains(bonus) || this.numbers.contains(bonus)) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
	}
}
