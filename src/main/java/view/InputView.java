package view;

import lotto.common.Console;
import lotto.common.Messages;

public class InputView {

	private static String readLine(String message) {
		System.out.println(message);
		return Console.readLine();
	}

	public static String inputInvestment() {
		return readLine(Messages.INPUT_AMOUNT.getValues());
	}

	public static String inputWinningNumber() {
		return readLine(Messages.INPUT_WINNING_NUMBER.getValues());
	}

}
