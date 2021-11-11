package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;
import lotto.util.RandomUtil;

public class LottoGenerator {
	private static final String IS_NUMBER_REGEX = "[1-9]";
	private static final int ONLY_RANDOM_NUMBERS = 0;

	private LottoGenerator() {
	}

	public static LottoGenerator getInstance() {
		return new LottoGenerator();
	}

	private static void validInputSize(String input, int inputNumberListSize) {
		if (input == null || input.isEmpty() || !input.matches(IS_NUMBER_REGEX)) {
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

	public List<LottoNumbers> generateLottoNumbers(Money money) {
		return generateRandomLottoNumbers(money, ONLY_RANDOM_NUMBERS);
	}

	public List<LottoNumbers> generateLottoNumbers(Money money, List<String> inputNumberList) {
		validInputListSize(money, inputNumberList.size());

		return generateMixLottoNumbers(money, inputNumberList);
	}

	public List<LottoNumbers> generateLottoNumbers(Money money, List<String> inputNumberList, String inputSize) {
		validInputSize(inputSize, inputNumberList.size());
		validInputListSize(money, Integer.parseInt(inputSize));

		return generateMixLottoNumbers(money, inputNumberList);
	}

	private List<List<String>> generateLottoNumberList(Money money, int inputNumberListSize) {
		return Stream
			.generate(LottoGenerator::generateStringNumberSet)
			.limit(calculateRandomSize(money, inputNumberListSize))
			.collect(Collectors.toList());
	}

	private int calculateRandomSize(Money money, int inputNumberListSize) {
		System.out.println();
		return money.calculateLottoAmount() - inputNumberListSize;
	}

	private List<LottoNumbers> generateRandomLottoNumbers(Money money, int inputNumberListSize) {
		return generateLottoNumberList(money, inputNumberListSize)
			.stream()
			.map(LottoNumbers::from)
			.collect(Collectors.toList());
	}

	private List<LottoNumbers> generateInputLottoNumbers(List<String> inputNumberList) {
		return inputNumberList
			.stream()
			.map(LottoNumbers::from)
			.limit(inputNumberList.size())
			.collect(Collectors.toList());
	}

	private List<LottoNumbers> generateMixLottoNumbers(Money money, List<String> inputNumberList) {
		return Stream.of(generateInputLottoNumbers(inputNumberList),
			generateRandomLottoNumbers(money, inputNumberList.size()))
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}
}
