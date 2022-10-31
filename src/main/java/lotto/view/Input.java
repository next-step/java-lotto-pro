package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoType;
import lotto.model.Lottos;
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

	public static Lottos inputManualLottos() {
		try {
			int manualCount = inputManualCount();
			System.out.println();
			System.out.println("수동으로 구매할 번호를 입력해 주세요.");
			return inputLottos(manualCount);
		} catch (Exception e) {
			return inputManualLottos();
		}
	}

	private static Lottos inputLottos(final int manualCount) {
		List<Lotto> result = new ArrayList<>();
		for (int i = 0; i < manualCount; i++) {
			result.add(inputLotto(LottoType.MANUAL));
		}
		System.out.println();
		return new Lottos(result);
	}

	private static int inputManualCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return Integer.parseInt(nextLine());
	}

	public static Lotto inputWinnerLotto() {
		try {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			return inputLotto(LottoType.WINNER);
		} catch (IllegalArgumentException e) {
			return inputWinnerLotto();
		}
	}

	private static Lotto inputLotto(final LottoType lottoType) {
		String number = nextLine();
		return new Lotto(LottoNumber.of(number.split(SPLITER)), lottoType);
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
