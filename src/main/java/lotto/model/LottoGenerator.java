package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	private final Money money;
	private final List<String> inputNumberList;

	private LottoGenerator(Money money, List<String> inputNumberList) {
		this.money = money;
		this.inputNumberList = Collections.unmodifiableList(inputNumberList);
	}

	public static LottoGenerator from(Money money) {
		return new LottoGenerator(money, new ArrayList<>());
	}

	public static LottoGenerator of(Money money, List<String> inputNumberList) {
		return new LottoGenerator(money, inputNumberList);
	}

	public List<LottoNumbers> generateLottoNumbers() {
		if (isNullInputNumberList()) {
			return generateRandomLottoNumbers();
		}
		return generateMixLottoNumbers();
	}

	private int calculateRandomSize() {
		return money.calculateLottoAmount() - inputNumberList.size();
	}

	private List<LottoNumbers> generateMixLottoNumbers() {
		return Stream.of(generateLottoInputNumbers(), generateRandomLottoNumbers())
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}

	private List<LottoNumbers> generateRandomLottoNumbers() {
		return Stream
			.generate(LottoNumbers::from)
			.limit(calculateRandomSize())
			.collect(Collectors.toList());
	}

	private List<LottoNumbers> generateLottoInputNumbers() {
		return inputNumberList
			.stream()
			.map(LottoNumbers::from)
			.limit(inputNumberList.size())
			.collect(Collectors.toList());
	}

	private boolean isNullInputNumberList() {
		return this.inputNumberList == null || this.inputNumberList.isEmpty();
	}
}
