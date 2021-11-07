package lotto.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static String inputMoneyPurchaseLotto() {
		String inputMoney = SCANNER.nextLine();
		System.out.println("구입금액을 입력해 주세요.");
		SCANNER.close();
		return inputMoney;
	}

	public static String inputWinningLottoNumber() {
		System.out.println("");
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = SCANNER.nextLine();
		SCANNER.close();
		return winningNumber;
	}
}
