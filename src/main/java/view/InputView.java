package view;

import java.util.Scanner;

public final class InputView {

	private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";
	private static final String WINNING_NUMBER_INPUT_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_BALL_INPUT_GUIDE = "보너스 볼을 입력해 주세요.";
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
		throw new AssertionError();
	}

	public static String inputPurchaseAmount() {
		return inputSystem(PURCHASE_AMOUNT_INPUT_GUIDE).input();
	}

	public static String inputWinningNumber() {
		return inputSystem(WINNING_NUMBER_INPUT_GUIDE).input();
	}

	public static String inputBonusBall() {
		return inputSystem(BONUS_BALL_INPUT_GUIDE).input();
	}

	private static UserInputSystem inputSystem(String guide) {
		return UserInputSystem.from(GuidePrinter.of(System.out, guide), SCANNER);
	}
}
