package view;

public class InputView {
	private static final String inputMoneyMessage = "구입금액을 입력해 주세요.";
	private static final String inputLastWinLottoMessage = "\n지난 주 당첨 번호를 입력해 주세요.";
	
	public static String inputMoney() {
		return inputView(inputMoneyMessage);
	}

	public static String inputLastWinLotto() {
		return inputView(inputLastWinLottoMessage);
	}

	private static String inputView(String message) {
		System.out.println(message);
		return CustomScanner.readLine();
	}
}
