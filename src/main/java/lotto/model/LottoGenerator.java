package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;
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
		validInputListSize(money, inputNumberList.size());
		return new LottoGenerator(money, inputNumberList);
	}

	public static LottoGenerator of(Money money, List<String> inputNumberList, String inputSize) {
		validInputSize(inputSize, inputNumberList.size());
		validInputListSize(money, Integer.parseInt(inputSize));
		return new LottoGenerator(money, inputNumberList);
	}

	private static void validInputSize(String input, int inputNumberListSize) {
		if (input == null || input.isEmpty() || !input.matches("[1-9]")) {
			throw new LottoException(ErrorCode.NEGATIVE_AMOUNT_ERROR);
		}

		if (Integer.parseInt(input) != inputNumberListSize) {
			throw new LottoException(ErrorCode.INVALID_INPUT_SIZE_INPUT_LIST_SIZE_ERROR);
		}
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

	private static void validInputListSize(Money money, int inputSize) {
		if (money.validSizeUnderAmount(inputSize)) {
			throw new LottoException(ErrorCode.INVALID_MONEY_INPUT_NUMBER_SIZE_ERROR);
		}
	}

	private List<List<String>> generateLottoNumberList() {
		return Stream
			.generate(LottoGenerator::generateStringNumberSet)
			.limit(calculateRandomSize())
			.collect(Collectors.toList());
	}

	private int calculateRandomSize() {
		return money.calculateLottoAmount() - inputNumberList.size();
	}

	public List<LottoNumbers> generateRandomLottoNumbers() {
		return generateLottoNumberList()
			.stream()
			.map(LottoNumbers::from)
			.collect(Collectors.toList());
	}

	public List<LottoNumbers> generateInputLottoNumbers() {
		return inputNumberList
			.stream()
			.map(LottoNumbers::from)
			.limit(inputNumberList.size())
			.collect(Collectors.toList());
	}
}
