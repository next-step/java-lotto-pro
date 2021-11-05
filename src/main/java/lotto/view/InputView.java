package lotto.view;

import static java.util.stream.Collectors.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;
import static lotto.constant.ViewMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import calculator.utils.StringUtils;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.utils.LottoStringSplitter;
import lotto.utils.LottoStringToIntegerParser;
import lotto.utils.MessageBuilder;

public class InputView {
	private static final String NUMBER_FROM_0_to_9_REG_EXP = "^[0-9]+$";

	private static final Scanner scanner = new Scanner(System.in);

	public Money inputMoney() {
		System.out.println(MONEY_INPUT_GUIDE_MESSAGE);
		String money = readLine();

		if (isValidMoney(money)) {
			return convertToMoney(money);
		}

		System.out.println(MessageBuilder.build(INVALID_INPUT_MONEY, money));
		return inputMoney();
	}

	public LottoCount inputCustomLottoCount(LottoCount purchasedCount) {
		System.out.println(CUSTOM_LOTTO_COUNT_INPUT_GUIDE_MESSAGE);
		String customLottoCount = readLine();

		if (isValidCustomLottoCount(customLottoCount, purchasedCount)) {
			return LottoCount.of(LottoStringToIntegerParser.parse(customLottoCount));
		}

		System.out.println(MessageBuilder.build(INVALID_INPUT_CUSTOM_LOTTO_COUNT, customLottoCount));
		return inputCustomLottoCount(purchasedCount);
	}

	public List<Integer> inputLottoNumbers(String inputGuideMessage) {
		String[] splitNumbers = LottoStringSplitter.split(readLine());

		if (isValidSplitNumbers(splitNumbers)) {
			return LottoStringToIntegerParser.parseNumbers(splitNumbers);
		}

		System.out.println(MessageBuilder.build(INVALID_INPUT_LOTTO_NUMBERS, Arrays.asList(splitNumbers)));
		System.out.println(inputGuideMessage);
		return inputLottoNumbers(inputGuideMessage);
	}

	public LottoNumber inputBonusNumber(LottoNumbers lastWinningNumbers) {
		System.out.println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE);
		String bonusNumber = readLine();

		if (isValidBonusNumber(bonusNumber) && !isContainingInLastWinningNumbers(bonusNumber, lastWinningNumbers)) {
			return LottoNumber.of(LottoStringToIntegerParser.parse(bonusNumber));
		}

		System.out.println(MessageBuilder.build(INVALID_INPUT_BONUS_NUMBER, bonusNumber));
		return inputBonusNumber(lastWinningNumbers);
	}

	private boolean isValidCustomLottoCount(String customLottoCount, LottoCount purchasedCount) {
		return isValidNumber(customLottoCount)
			&& LottoStringToIntegerParser.parse(customLottoCount) <= purchasedCount.getValue();
	}

	private boolean isValidBonusNumber(String bonusNumber) {
		return isValidNumber(bonusNumber) && isValidLottoNumber(LottoStringToIntegerParser.parse(bonusNumber));
	}

	private boolean isContainingInLastWinningNumbers(String bonusNumber, LottoNumbers lastWinningNumbers) {
		LottoNumber lottoBonusNumber = LottoNumber.of(LottoStringToIntegerParser.parse(bonusNumber));
		return lastWinningNumbers.contains(lottoBonusNumber);
	}

	private boolean isValidSplitNumbers(String[] splitWinningNumbers) {
		List<String> winningNumbers = Arrays.stream(splitWinningNumbers).map(String::trim).collect(toList());
		return isValidNumbers(winningNumbers)
			   && isValidLottoNumbers(winningNumbers)
			   && winningNumbers.size() == VALID_LOTTO_NUMBER_COUNT;
	}

	private boolean isValidNumbers(List<String> numbers) {
		return numbers.stream()
					  .allMatch(input -> input.matches(NUMBER_FROM_0_to_9_REG_EXP));
	}

	private boolean isValidLottoNumbers(List<String> numbers) {
		return numbers.stream()
					  .filter(s -> !StringUtils.isEmpty(s) && s.matches(NUMBER_FROM_0_to_9_REG_EXP))
					  .map(LottoStringToIntegerParser::parse)
					  .allMatch(this::isValidLottoNumber);
	}

	private boolean isValidNumber(String number) {
		return number.matches(NUMBER_FROM_0_to_9_REG_EXP);
	}

	private boolean isValidLottoNumber(int number) {
		return LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX;
	}

	private boolean isValidMoney(String money) {
		if (StringUtils.isEmpty(money)) {
			return false;
		}

		return money.matches(NUMBER_FROM_0_to_9_REG_EXP);
	}

	private Money convertToMoney(String money) {
		int parsedMoney = LottoStringToIntegerParser.parse(money);
		return Money.of(parsedMoney);
	}

	private String readLine() {
		return scanner.nextLine();
	}
}
