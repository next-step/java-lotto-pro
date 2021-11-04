package lotto.view;

import static java.util.stream.Collectors.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import calculator.utils.StringUtils;
import lotto.domain.Money;
import lotto.utils.LottoNumberValidator;
import lotto.utils.LottoStringSplitter;
import lotto.utils.LottoStringToIntegerParser;
import lotto.utils.MessageBuilder;

public class InputView {
	private static final String MONEY_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
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

	public List<Integer> inputWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
		String[] splitWinningNumbers = LottoStringSplitter.split(readLine());

		if (isValidWinningNumbers(splitWinningNumbers)) {
			return LottoStringToIntegerParser.parseNumbers(splitWinningNumbers);
		}

		System.out.println(MessageBuilder.build(INVALID_INPUT_WINNING_NUMBERS, Arrays.asList(splitWinningNumbers)));
		return inputWinningNumbers();
	}

	private boolean isValidWinningNumbers(String[] splitWinningNumbers) {
		List<String> winningNumbers = Arrays.stream(splitWinningNumbers).map(String::trim).collect(toList());
		return isValidNumbers(winningNumbers)
			   && isValidLottoNumbers(winningNumbers)
			   && winningNumbers.size() == VALID_LOTTO_NUMBER_COUNT;
	}

	private boolean isValidNumbers(List<String> winningNumbers) {
		return winningNumbers.stream()
							 .allMatch(input -> input.matches(NUMBER_FROM_0_to_9_REG_EXP));
	}

	private boolean isValidLottoNumbers(List<String> winningNumbers) {
		return winningNumbers.stream()
							 .filter(s -> !StringUtils.isEmpty(s) && s.matches(NUMBER_FROM_0_to_9_REG_EXP))
							 .map(LottoStringToIntegerParser::parse)
							 .allMatch(LottoNumberValidator::isValidLottoNumber);
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
