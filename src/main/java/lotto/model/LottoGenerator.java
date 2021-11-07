package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	public static final int LOTTO_PRICE = 1000;
	private final Money money;
	private String inputNumber;

	public LottoGenerator(String inputMoney) {
		this.money = new Money(inputMoney);
	}

	public LottoGenerator(String inputMoney, String inputNumber) {
		this.money = new Money(inputMoney);
		this.inputNumber = inputNumber;
	}

	private int calculateLottoAmount(String inputMoney) {
		return Integer.parseInt(inputMoney) / LOTTO_PRICE;
	}

	public List<LottoNumbers> generateLottoNumbers() {
		return Stream.generate(LottoNumbers::new)
			.limit(calculateLottoAmount(money.money())).collect(Collectors.toList());
	}

	public List<LottoNumbers> generateLottoInputNumbers() {
		return Stream.generate(() -> new LottoNumbers(inputNumber))
			.limit(calculateLottoAmount(money.money())).collect(Collectors.toList());
	}

	public String getInputMoney() {
		return money.money();
	}
}
