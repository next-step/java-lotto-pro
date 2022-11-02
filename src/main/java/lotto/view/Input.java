package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.model.LottoNumber;
import lotto.model.Money;

public class Input {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String SPLITER = ", ";

	private Input() {
	}

	private static String nextLine() {
		return SCANNER.nextLine();
	}

	public static Money inputPayment() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String money = nextLine();
			System.out.println();
			return new Money(Integer.parseInt(money));
		} catch (NumberFormatException e) {
			return inputPayment();
		}
	}

	public static int inputManualLottoNumbers() {
		try {
			return inputManualCount();
		} catch (Exception e) {
			return inputManualLottoNumbers();
		}
	}

	public static List<LottoNumber> inputManualLottoNumber() {
		return inputLottoNumber();
	}

	private static int inputManualCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return Integer.parseInt(nextLine());
	}

	public static List<LottoNumber> inputWinnerLottoNumber() {
		try {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			return inputLottoNumber();
		} catch (IllegalArgumentException e) {
			return inputWinnerLottoNumber();
		}
	}

	private static List<LottoNumber> inputLottoNumber() {
		String number = nextLine();
		return LottoNumber.of(number.split(SPLITER));
	}

	public static LottoNumber inputBonusNumber() {
		try {
			System.out.println("보너스 볼을 입력해 주세요.");
			String bonusBall = nextLine();
			System.out.println();
			return LottoNumber.of(bonusBall);
		} catch (NumberFormatException e) {
			return inputBonusNumber();
		}
	}
}
