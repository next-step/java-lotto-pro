package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.util.RandomUtil;

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

	private static List<String> generateStringNumberSet() {
		Set<String> lottoNumberSet = new HashSet<>();

		do {
			lottoNumberSet.add(randomLottoNumber());
		} while (lottoNumberSet.size() < LottoNumbers.LOTTO_NUMBERS_SIZE);

		return new ArrayList<>(lottoNumberSet);
	}

	private static String randomLottoNumber() {
		return String.valueOf(RandomUtil.pickNumber(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER));
	}

	private List<List<String>> generateLottoNumberList() {
		return Stream
			.generate(LottoGenerator::generateStringNumberSet)
			.limit(calculateRandomSize())
			.collect(Collectors.toList());
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
		return generateLottoNumberList()
			.stream()
			.map(LottoNumbers::from)
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
