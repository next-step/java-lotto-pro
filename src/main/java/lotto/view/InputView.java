package lotto.view;

import static lotto.constant.ErrorMessage.*;

import java.util.Scanner;

import calculator.utils.StringUtils;
import lotto.domain.Money;
import lotto.utils.LottoStringToIntegerParser;
import lotto.utils.MessageBuilder;

public class InputView {
	private static final String MONEY_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String MONEY_REG_EXP = "^[0-9]+$";

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

	private boolean isValidMoney(String money) {
		if (StringUtils.isEmpty(money)) {
			return false;
		}

		return money.matches(MONEY_REG_EXP);
	}

	private Money convertToMoney(String money) {
		int parsedMoney = LottoStringToIntegerParser.parse(money);
		return Money.of(parsedMoney);
	}

	private String readLine() {
		return scanner.nextLine();
	}
}
