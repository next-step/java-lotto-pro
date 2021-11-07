package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	public static final int LOTTO_PRICE = 1000;
	private final Money money;
	private List<String> inputNumberList;

	public LottoGenerator(String inputMoney) {
		this.money = new Money(inputMoney);
	}

	public LottoGenerator(String inputMoney, List<String> inputNumberList) {
		this.money = new Money(inputMoney);
		this.inputNumberList = inputNumberList;
	}

	private int calculateLottoAmount(String inputMoney) {
		return Integer.parseInt(inputMoney) / LOTTO_PRICE;
	}

	public List<LottoNumbers> generateLottoNumbers() {
		if (isNullInputNumberList()) {
			return generateRandomLottoNumbers();
		}
		return generateLottoInputNumbers();
	}

	public List<LottoNumbers> generateRandomLottoNumbers() {
		return Stream
			.generate(LottoNumbers::new)
			.limit(calculateLottoAmount(money.money()))
			.collect(Collectors.toList());
	}

	public List<LottoNumbers> generateLottoInputNumbers() {
		return inputNumberList
			.stream()
			.map(LottoNumbers::new)
			.limit(calculateLottoAmount(money.money()))
			.collect(Collectors.toList());
	}

	private boolean isNullInputNumberList() {
		return this.inputNumberList == null || this.inputNumberList.isEmpty();
	}

	public String getInputMoney() {
		return money.money();
	}
}
