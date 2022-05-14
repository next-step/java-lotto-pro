package view;

public class InputView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WIN_LOTTO_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

	private InputView() {
	}

	public static String inputMoney() {
		return inputView(INPUT_MONEY_MESSAGE);
	}

	public static String inputLastWinLotto() {
		return inputView(INPUT_WIN_LOTTO_MESSAGE);
	}

	private static String inputView(String message) {
		System.out.println(message);
		return CustomScanner.readLine();
	}
}
