package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	public static final int LOTTO_PRICE = 1000;
	private static final String NUMBER_REGEX = "[0-9]+";
	private final String inputMoney;
	private String inputNumber;

	public LottoGenerator(String inputMoney) {
		this.inputMoney = inputMoney;
	}

	public LottoGenerator(String inputMoney, String inputNumber) {
		this.inputMoney = inputMoney;
		this.inputNumber = inputNumber;
	}

	private void validNullOrEmpty(String input) {
		if (isNullOrEmpty(input)) {
			throw new IllegalArgumentException();
		}
	}

	private void validNumber(String input) {
		if (isNumber(input)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isNumber(String input) {
		return !input.matches(NUMBER_REGEX);
	}

	private boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private void validUnderLottoPrice(String input) {
		if (isUnderLottoPrice(input)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isUnderLottoPrice(String input) {
		return Integer.parseInt(input) < LOTTO_PRICE;
	}

	private int calculateLottoAmount(String inputMoney) {
		return Integer.parseInt(inputMoney) / LOTTO_PRICE;
	}

	public List<LottoNumbers> generateLottoNumbers() {
		validNullOrEmpty(inputMoney);
		validNumber(inputMoney);
		validUnderLottoPrice(inputMoney);

		return Stream.generate(LottoNumbers::new)
			.limit(calculateLottoAmount(inputMoney)).collect(Collectors.toList());
	}

	public List<LottoNumbers> generateLottoInputNumbers() {
		return Stream.generate(() -> new LottoNumbers(inputNumber))
			.limit(calculateLottoAmount(inputMoney)).collect(Collectors.toList());
	}

	public String getInputMoney() {
		return inputMoney;
	}
}
