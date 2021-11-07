package view;

import common.Console;
import common.Messages;

public class InputView {
	private InputView() {
	}

	private static String readLine(Messages message) {
		System.out.println(message.getValues());
		return Console.readLine();
	}

	public static String inputInvestment() {
		return readLine(Messages.INPUT_AMOUNT);
	}

	public static String inputWinningNumber() {
		return readLine(Messages.INPUT_WINNING_NUMBER);
	}

	public static String inputBonusBall() {
		return readLine(Messages.INPUT_BONUS_BALL);
	}

	public static String inputManualCount() {
		return readLine(Messages.INPUT_MANUAL_AMOUNT);
	}

	public static String inputManualNumber() {
		return readLine(Messages.INPUT_MANUAL_NUMBER);
	}

	public static String inputManualNumberNoMessage() {
		return Console.readLine();
	}
}
