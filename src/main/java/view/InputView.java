package view;

import java.util.Scanner;

import lotto.common.Console;
import lotto.common.Messages;

public class InputView {
	public InputView() {
	}

	private String readLine(String message) {
		System.out.println(message);
		return Console.readLine();
	}

	public String inputAmount() {
		return readLine(Messages.INPUT_AMOUNT.getValues());
	}

	public String inputWinningNumber() {
		return readLine(Messages.INPUT_WINNING_NUMBER.getValues());
	}

}
