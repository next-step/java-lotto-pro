package lotto.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static String inputMoneyPurchaseLotto() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputWinningLottoNumber() {
		System.out.println("");
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputBonusLottoNumber() {
		System.out.println("");
		System.out.println("보너스 볼을 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputPurchaseLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static void inputPurchaseLottoNumberMent() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static String inputPurchaseLottoNumber() {
		return SCANNER.nextLine();
	}
}
